package com.agendaemail.test;

import com.agendaemail.model.Agenda;
import com.agendaemail.model.*;
import com.agendaemail.ui.*;

public class TestAgenda {
    private static Domicilio domicilio = new Domicilio("Barrio Guiraldes manzana1","Chaco","Resistencia");
    private static Persona persona = new Persona("Renzo","Espinola",domicilio,"33074277");
    private static Cuenta cuenta = new Cuenta("EMAIL-HOTMAIL","renzo.espinola@hotmail.com","1234");
    private static Cuenta cuenta2 = new Cuenta("EMAIL-GMAIL","renzo-espi@gmail.com","renzo1234");
    private static Cuenta cuenta3 = new Cuenta("NETFILX","renzoespinola","renzoNetflix3698");
    private static Agenda agenda = new Agenda();

    public static void main(String[] args) {
        agenda.setPersona(persona);
        agenda.guardarCuenta(cuenta);
        agenda.guardarCuenta(cuenta2);
        agenda.guardarCuenta(cuenta3);
        PantallaLoggin pantallaLogin = new PantallaLoggin();
        PantallaPrincipalAgenda pantallaPrincipal = new PantallaPrincipalAgenda();
        boolean bandera=false;
        do{
            bandera=pantallaLogin.login(agenda);
        }while(!bandera);
        pantallaPrincipal.pantallaSubMenuMovconsultas(agenda);
    }

}
