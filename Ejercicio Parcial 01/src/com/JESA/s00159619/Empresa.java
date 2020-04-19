package com.JESA.s00159619;

import java.util.ArrayList;

public class Empresa {
    private String nombre;
    private ArrayList<Empleado> Personal;

    public Empresa(String nombre) {
        this.nombre = nombre;
        Personal=new ArrayList<>();
    }

    public ArrayList<Empleado> getPersonal() {
        return Personal;
    }

    public String getNombre() {
        return nombre;
    }

    public void  addEmpleado (Empleado empleado){
        Personal.add(empleado);
    }

    public void quitEmpleado (String name){
        Personal.removeIf(s->s.Nombre.equalsIgnoreCase(name));
    }
}
