package com.agendaemail.model;

public class Cuenta {
    private String tipoCuenta;
    private String usuario;
    private String password;

    public Cuenta() {
    }

    public Cuenta(String tipoCuenta, String usuario, String password) {
        this.tipoCuenta = tipoCuenta;
        this.usuario = usuario;
        this.password = password;
    }

    public String getTipoCuenta() {
        return tipoCuenta;
    }

    public void setTipoCuenta(String tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
