package com.agendaemail.ui.crud;

import com.agendaemail.model.Agenda;
import com.agendaemail.model.Cuenta;
import com.agendaemail.model.TitulosPantallas;
import com.agendaemail.ui.PantallaPrincipalAgenda;

import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;

public class ModificarCuenta {
    public void modificar(Agenda agenda) {
        PantallaPrincipalAgenda pantallaPrincipalAgenda = new PantallaPrincipalAgenda();
        int cont = 1;
        String listado = new String();
        for (Cuenta cuenta : agenda.getCuentas()) {
            listado += "\nN°  : " + cont + " - TIPO CUENTA: " + cuenta.getTipoCuenta() + " - USER/MAIL: " + cuenta.getUsuario() + " - CONTRASEÑA: " + cuenta.getPassword() + "";
            cont += 1;
        }
        int opcion = Integer.parseInt(JOptionPane.showInputDialog(null, "                                  LISTADO DE CUENTAS           \n" +
                        "\n" +
                        "NOMBRE:" + agenda.getPersona().getNombre() + " APELLIDO: " + agenda.getPersona().getApellido() + "\n" +
                        "\n" +
                        "" + listado + "\n",
                TitulosPantallas.TITULOMODIFICACUENTA.descripcion, 1));

        if (opcionSeleccion(agenda, opcion))
            JOptionPane.showMessageDialog(null, "EL REGISTRO FUE MODIFICADO");

        pantallaPrincipalAgenda.pantallaSubMenuMovconsultas(agenda);
    }

    private boolean opcionSeleccion(Agenda agenda, int opcion) {
        if (opcion > 0 && opcion - 1 < agenda.getCuentas().size()) {
            Cuenta cuentaModificada=modificarDatos(agenda.getCuentas().get(opcion-1));
            if(cuentaModificada!=null){
                agenda.getCuentas().set(opcion-1,cuentaModificada);
                return true;
            }else
                return false;
        } else
            return false;
    }

    private Cuenta modificarDatos(Cuenta cuenta) {
        JFrame frame;
        JPanel pane;
        JTextField userField;
        JTextField passField;
        JTextField tipoCuentaField;
        frame = new JFrame("                  MODIFICAR DATO CUENTAS                  \n " +
                "\n");
        pane = new JPanel();
        pane.setLayout(new GridLayout(0, 2, 2, 2));

        userField = new JTextField(5);
        passField = new JTextField(5);
        tipoCuentaField = new JTextField(5);

        pane.add(new JLabel("Tipo Cuenta: "));
        pane.add(tipoCuentaField);

        pane.add(new JLabel("Usuario: "));
        pane.add(userField);

        pane.add(new JLabel("Contraseña: "));
        pane.add(passField);
        boolean bandera = false;
        do {
        int option = JOptionPane.showConfirmDialog(frame, pane, TitulosPantallas.TITULOMODIFICACUENTA.descripcion, JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
        if (option == JOptionPane.YES_OPTION) {
            if (!userField.getText().isEmpty() && !passField.getText().isEmpty()) {
                bandera = true;
                String userInput = userField.getText();
                String passInput = passField.getText();
                String tipoCuentaInput = tipoCuentaField.getText();
                cuenta.setTipoCuenta(tipoCuentaInput);
                cuenta.setUsuario(userInput);
                cuenta.setPassword(passInput);
                return cuenta;
        } else
            JOptionPane.showMessageDialog(null, "ERROR, Debe ingresar un User/mail y password", TitulosPantallas.TITULONUEVACUENTA.descripcion, JOptionPane.ERROR_MESSAGE);
            bandera = false;
        } else
           return null;
    } while (!bandera);
    return null;
}
}