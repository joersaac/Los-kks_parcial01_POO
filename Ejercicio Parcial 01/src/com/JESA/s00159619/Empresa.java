package com.JESA.s00159619;

import java.util.ArrayList;

public class Empresa {
    private String nombre;
    private ArrayList<Empleado> planilla;

    public Empresa(String nombre) {
        this.nombre = nombre;
        planilla=new ArrayList<>();
    }

    public ArrayList<Empleado> getPersonal() {
        return planilla;
    }

    public String getNombre() {
        return nombre;
    }

    public void  addEmpleado (Empleado empleado){
        planilla.add(empleado);
    }

    public void quitEmpleado (String name){
        planilla.removeIf(s->s.Nombre.equalsIgnoreCase(name));
    }
}
