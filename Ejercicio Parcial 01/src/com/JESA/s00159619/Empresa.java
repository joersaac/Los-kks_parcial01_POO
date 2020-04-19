package com.JESA.s00159619;

import javax.swing.*;
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

    public void quitEmpleado (String name)throws NotFoundEmployeeException{
        boolean exist=false;
        for (Empleado p : planilla) {
            if(p.getNombre().equalsIgnoreCase(name)){
                planilla.remove(p);
                exist=true;
                JOptionPane.showMessageDialog(null,"Empleado despedido");

                break;
            }
        }
        if(!exist)
            throw new NotFoundEmployeeException("Empleado a despedir no existe.");
    }
}
