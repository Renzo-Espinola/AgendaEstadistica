package com.agendaemail.model;

import java.util.ArrayList;
import java.util.List;

public class Agenda {
    private User user;
    private Persona persona;
    private List<Cuenta> cuentas;

    public Agenda() {
        crearUsuarioAdmin();
    }

    public Agenda(User user, Persona persona) {
        this.user = user;
        this.persona = persona;
        crearUsuarioAdmin();
    }

    public Agenda(String nombreEmail, Persona persona,List<Cuenta> cuentas) {
        this.user = user;
        this.persona = persona;
        this.cuentas=cuentas;
        crearUsuarioAdmin();

    }
    public boolean guardarCuenta(Cuenta cuenta){
        List<Cuenta> cuentasList = new ArrayList<>();
        cuentasList.add(cuenta);
            if(this.getCuentas()!=null) {
                this.getCuentas().add(cuenta);
                return true;
            }else{
                this.setCuentas(cuentasList);
            return true;
            }
    }

    public List<Cuenta> getCuentas() {
        return cuentas;
    }

    public void setCuentas(List<Cuenta> cuentas) {
        this.cuentas = cuentas;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }
    public void crearUsuarioAdmin(){
        this.setUser(new User("ADMIN","1234"));
    }
}
