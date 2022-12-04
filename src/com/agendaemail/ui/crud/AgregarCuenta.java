package com.agendaemail.ui.crud;

import com.agendaemail.model.Agenda;
import com.agendaemail.model.Cuenta;
import com.agendaemail.model.TitulosPantallas;
import com.agendaemail.ui.PantallaPrincipalAgenda;

import javax.swing.*;
import java.awt.*;

public class AgregarCuenta {
    public void agregarCuentaNueva(Agenda agenda) {
        PantallaPrincipalAgenda pantallaPrincipalAgenda = new PantallaPrincipalAgenda();
        opcionSeleccion(agenda);
        pantallaPrincipalAgenda.pantallaSubMenuMovconsultas(agenda);
    }

    private void opcionSeleccion(Agenda agenda) {
        agenda.getCuentas().add(cargarDatosCuenta());
    }

    private Cuenta cargarDatosCuenta() {
        JFrame frame;
        JPanel pane;
        JTextField userField;
        JTextField passField;
        JTextField tipoCuentaField;
        frame = new JFrame("                  AGREGAR CUENTA                  \n " +
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
            int option = JOptionPane.showConfirmDialog(frame, pane, TitulosPantallas.TITULONUEVACUENTA.descripcion, JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);

            if (option == JOptionPane.YES_OPTION) {
                if (!userField.getText().isEmpty() && !passField.getText().isEmpty()) {
                    bandera = true;
                    Cuenta cuenta = new Cuenta();
                    String userInput = userField.getText();
                    String passInput = passField.getText();
                    String tipoCuentaInput = tipoCuentaField.getText();
                    cuenta.setTipoCuenta(tipoCuentaInput);
                    cuenta.setUsuario(userInput);
                    cuenta.setPassword(passInput);
                    JOptionPane.showMessageDialog(null, "Se agrego una nueva Cuenta",TitulosPantallas.TITULOLOGNUEVACUENTA.descripcion,JOptionPane.INFORMATION_MESSAGE);
                    return cuenta;
                } else
                    bandera = false;
            } else
                return null;
            JOptionPane.showMessageDialog(null, "ERROR, Debe ingresar un User/mail y password", TitulosPantallas.TITULONUEVACUENTA.descripcion, JOptionPane.ERROR_MESSAGE);
        } while (!bandera);
        return null;
    }
}

