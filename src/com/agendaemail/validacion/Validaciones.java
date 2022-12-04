package com.agendaemail.validacion;

import javax.swing.*;

public class Validaciones {
    public boolean validaIngMenuPrin(int opcion, int rangoOpcion){
    if((opcion<0||opcion>rangoOpcion)&&opcion!=-10) {
        JOptionPane.showMessageDialog(null, "INGRESO ERRONEO");
        return false;
    }else if(opcion==-10) {
        return false;
    }
    else{return true;
    }
}
    public  boolean esUnNumero(String n){
        try{
            Integer.parseInt(n);
            return true;
        }catch (NumberFormatException nfe){
            return false;
        }
    }
}
