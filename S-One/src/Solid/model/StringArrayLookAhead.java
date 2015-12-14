package Solid.model;

import java.util.ArrayList;

public class StringArrayLookAhead implements LookAheadTextField.TextLookAhead {
	public StringArrayLookAhead() {
		values = new ArrayList<String>();
	}

	public StringArrayLookAhead(ArrayList<String> values) {
		this.values = values;
	}

	public void setValues(ArrayList<String> values) {
		this.values = values;
	}

	public ArrayList<String> getValues() {
		return values;
	}

	public String doLookAhead(String key) {
		int length = values.size();

		// Look for a string that starts with the key
		for (int i = 0; i < length; i++) {
			if (values.get(i).startsWith(key) == true) {
				return values.get(i);

			}
			if (values.get(i).toUpperCase().startsWith(key.toUpperCase()) == true) {
				return values.get(i);
			}
		}

		// No match found - return null
		return null;
	}

	protected ArrayList<String> values;
}