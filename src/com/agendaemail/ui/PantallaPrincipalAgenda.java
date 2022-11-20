package com.agendaemail.ui;

import com.agendaemail.model.Agenda;
import com.agendaemail.model.TitulosPantallas;
import com.agendaemail.ui.crud.AgregarCuenta;
import com.agendaemail.ui.crud.BajaCuenta;
import com.agendaemail.ui.crud.ConsultaCuentas;
import com.agendaemail.ui.crud.ModificarCuenta;
import com.agendaemail.validacion.Validaciones;

import javax.swing.*;

public class PantallaPrincipalAgenda { public void pantallaSubMenuMovconsultas(Agenda agenda){
    String opcion= JOptionPane.showInputDialog(null, new StringBuilder()
            .append("                       SELECCIONE EL TIPO DE               \n")
            .append("              OPERACION QUE DESEA EFECTUAR              \n")
            .append("\n").append("       CONSULTA DE         BORRAR    \n")
            .append("1<--------CUENTAS          CUENTAS------------>2\n")
            .append("\n").append("3<--EDITAR CUENTAS    AGREGAR CUENTA--->4    \n")
            .append("\n")
            .append("0<--------SALIR                                  ")
            .toString(), TitulosPantallas.TITULOAGENDA.descripcion,1);
    opcionSeleccion(opcion!=null?Integer.parseInt(opcion):0,agenda);
}
    public void opcionSeleccion(int opcion, Agenda agenda) {
        Validaciones validaciones = new Validaciones();
        ConsultaCuentas cuentas = new ConsultaCuentas();
        BajaCuenta bajaCuenta = new BajaCuenta();
        ModificarCuenta modificarCuenta = new ModificarCuenta();
        AgregarCuenta agregarCuenta = new AgregarCuenta();
        while (validaciones.validaIngMenuPrin(opcion,5)) {
            switch(opcion) {
                case 1:cuentas.Consultar(agenda);
                    break;
                case 2:
                    bajaCuenta.borrarCuenta(agenda);
                    break;
                case 3:modificarCuenta.modificar(agenda);
                    break;
                case 4:agregarCuenta.agregarCuentaNueva(agenda);
                    break;
                case 0:JOptionPane.showMessageDialog(null,"ADIOS GRACIAS POR USAR NUESTROS SERVICIOS");
                    return;
                default:
                    JOptionPane.showMessageDialog(null,"Ingreso Erroneo");
                    break;
            }
            opcion=-10;
        }
    }
}
