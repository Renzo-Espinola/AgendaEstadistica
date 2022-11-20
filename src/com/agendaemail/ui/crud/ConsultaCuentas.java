package com.agendaemail.ui.crud;

import com.agendaemail.model.Agenda;
import com.agendaemail.model.Cuenta;
import com.agendaemail.model.TitulosPantallas;
import com.agendaemail.ui.PantallaPrincipalAgenda;

import javax.swing.*;
import java.text.DecimalFormat;

public class ConsultaCuentas {
    public void Consultar(Agenda agenda){
            PantallaPrincipalAgenda pantallaPrincipalAgenda = new PantallaPrincipalAgenda();
            int cont=1;
            String listado=new String();
            for(Cuenta cuenta: agenda.getCuentas()){
                listado+="\nN°  : "+cont+" - TIPO CUENTA: "+cuenta.getTipoCuenta() +" - USER/MAIL: "+cuenta.getUsuario()+ " - CONTRASEÑA: "+cuenta.getPassword()+"";
                cont+=1;}
            JOptionPane.showMessageDialog(null,"                                                            LISTADO DE CUENTAS           \n" +
                            "\n" +
                            "NOMBRE:"+agenda.getPersona().getNombre()+" APELLIDO: "+agenda.getPersona().getApellido()+"\n"+
                            "\n"+
                            ""+listado+"\n",
                             TitulosPantallas.TITULOCONSULTACUENTAS.descripcion, 1);
            pantallaPrincipalAgenda.pantallaSubMenuMovconsultas(agenda);
        }
}

