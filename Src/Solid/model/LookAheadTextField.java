package Solid.model;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;

// import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;

public class LookAheadTextField extends JTextField {
	/**
	 * 
	 */
	private static final long	serialVersionUID	= 1L;
	
	public LookAheadTextField(ArrayList<String> dados) {
		this(0, null);
	}
	
	public LookAheadTextField(int columns) {
		this(columns, null);
	}
	
	public LookAheadTextField(int columns, TextLookAhead lookAhead) {
		super(columns);
		setLookAhead(lookAhead);
		addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				// Remove any existing selection
				setCaretPosition(getDocument().getLength());
			}
		});
		addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent evt) {
			}
			
			public void focusLost(FocusEvent evt) {
				if (evt.isTemporary() == false) {
					// Remove any existing selection
					setCaretPosition(getDocument().getLength());
				}
			}
		});
	}
	
	public void setLookAhead(TextLookAhead lookAhead) {
		this.lookAhead = lookAhead;
	}
	
	public TextLookAhead getLookAhead() {
		return lookAhead;
	}
	
	public void replaceSelection(String content) {
		super.replaceSelection(content);
		
		if (isEditable() == false || isEnabled() == false) {
			return;
		}
		
		Document doc = getDocument();
		if (doc != null && lookAhead != null) {
			try {
				String oldContent = doc.getText(0, doc.getLength());
				String newContent = lookAhead.doLookAhead(oldContent);
				if (newContent != null) {
					// Substitute the new content
					setText(newContent);
					
					// Highlight the added text
					setCaretPosition(newContent.length());
					moveCaretPosition(oldContent.length());
				}
			}
			catch (BadLocationException e) {
				// Won't happen
			}
		}
	}
	
	protected TextLookAhead	lookAhead;
	
	// The TextLookAhead interface
	public interface TextLookAhead {
		public String doLookAhead(String key);
	}
}
