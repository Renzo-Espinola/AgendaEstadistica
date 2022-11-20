package com.agendaemail.ui.crud;

import com.agendaemail.model.Agenda;
import com.agendaemail.model.Cuenta;
import com.agendaemail.model.TitulosPantallas;
import com.agendaemail.ui.PantallaPrincipalAgenda;

import javax.swing.*;
import java.text.DecimalFormat;

public class BajaCuenta {
    public void borrarCuenta(Agenda agenda){
        PantallaPrincipalAgenda pantallaPrincipalAgenda = new PantallaPrincipalAgenda();
        int cont=1;
        String listado=new String();
        for(Cuenta cuenta: agenda.getCuentas()){
            listado+="\nN°  : "+cont+" - TIPO CUENTA: "+cuenta.getTipoCuenta() +" - USER/MAIL: "+cuenta.getUsuario()+ " - CONTRASEÑA: "+cuenta.getPassword()+"";
            cont+=1;}
        int opcion= Integer.parseInt(JOptionPane.showInputDialog(null,"                                  LISTADO DE CUENTAS           \n" +
                        "\n" +
                        "NOMBRE:"+agenda.getPersona().getNombre()+" APELLIDO: "+agenda.getPersona().getApellido()+"\n"+
                        "\n"+
                        ""+listado+"\n",
                TitulosPantallas.TITULOBAJACUENTAS.descripcion, 1));

        if (opcionSeleccion(agenda,opcion))
            JOptionPane.showMessageDialog(null,"EL REGISTRO FUE ELIMINADO");
        else
            JOptionPane.showMessageDialog(null,"OCURRIO UN ERROR AL ELIMINAR");
        pantallaPrincipalAgenda.pantallaSubMenuMovconsultas(agenda);
    }
    private boolean opcionSeleccion(Agenda agenda,int opcion){
        if (opcion>0 && opcion-1 < agenda.getCuentas().size()) {
            agenda.getCuentas().remove(opcion-1);
            return true;
        }else return false;
    }
}
