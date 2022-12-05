package com.agendaemail.model;

public enum TitulosPantallas {
    TITULOLOGIN("LOGIN AGENDA"),
    TITULOLOGNUEVACUENTAAGENDA("LOGIN-NUEVA CUENTA AGENDA"),
    TITULOBAJACUENTAS("BAJA DE CUENTA"),
    TITULOAGENDA("AGENDA DE CUENTAS"),
    TITULOMODIFICACUENTA("MODIFICAR DATOS CUENTAS"),
    TITULOCONSULTACUENTAS("CONSULTA DE CUENTAS"),
    TITULONUEVACUENTA("NUEVA CUENTA"),
    TITULOLOGNUEVACUENTA("LOGIN-NUEVA CUENTA");


    public final String descripcion;

    private TitulosPantallas(String descripcion) {
        this.descripcion = descripcion;
    }
}
