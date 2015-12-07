package Solid.model;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.Date;
import java.text.SimpleDateFormat;

/**
 *
 * @author welynton
 */
@SuppressWarnings("unused")
public class Data {
    
    @SuppressWarnings("deprecation")
	
    
    public Date banco(String dat){
        java.sql.Date newDate;
        String[] data;  
        data = dat.split("/");
        // agora vamos converter pra long  
        int ano = Integer.parseInt(data[2]) - 1900;  
        int mes = Integer.parseInt(data[1])-1;  
        int dia = Integer.parseInt(data[0]);  
        // agora é só instanciar a Date de java.sql  
        return  newDate = new java.sql.Date(ano, mes, dia);  
    }
    
	public String semanal(String object){
       String[] data;  
       data = object.split("-");
       int ano = Integer.parseInt(data[0]);  
       int mes = Integer.parseInt(data[1]);  
       int dia = Integer.parseInt(data[2]); 
       return dia+"/"+mes+"/"+ano;    
    }
    
    
    //@SuppressWarnings("deprecation")
	public String mensal(String object){
         String[] data;  
         data = object.split("/");
         //int ano = Integer.parseInt(data[2]) - 1900;  
         //int mes = (Integer.parseInt(data[1])-1)+1;  
         //int dia = Integer.parseInt(data[0]); 
         //if(mes==1 && dia>=30){
          //   dia=28;
         //}
         String ano = data[2];
         String mes = data[1];
         String dia = data[0];
         return ano+"-"+mes+"-"+dia;//return  newDate = new java.sql.Date(ano, mes, dia);  
    }
	
    @SuppressWarnings("deprecation")
	public Date anual(String dat){
         java.sql.Date newDate;
         String[] data;  
         int dia=0;
         data = dat.split("/");
         int ano = (Integer.parseInt(data[2])+1) - 1900;  
         int mes = (Integer.parseInt(data[1])-1);  
         dia = Integer.parseInt(data[0]); 
         return  newDate = new java.sql.Date(ano, mes, dia);  
    }
}

