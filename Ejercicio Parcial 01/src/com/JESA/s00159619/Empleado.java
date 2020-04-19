package com.JESA.s00159619;

import java.util.ArrayList;

abstract class Empleado {
    protected String Nombre;
    protected String puesto;
    protected ArrayList<Documento> Documentos;
    protected double salario;

    public Empleado(String nombre, String puesto, double salario) {
        Nombre = nombre;
        this.puesto = puesto;
        Documentos = new ArrayList<>();
        this.salario = salario;
    }

    public String getNombre() {
        return Nombre;
    }

    public String getPuesto() {
        return puesto;
    }

    public ArrayList<Documento> getDocumentos() {
        return Documentos;
    }

    public void addDocumento (Documento doc) throws AlreadyExistingDocException {
        for (Documento d : Documentos) {
            if (d.getNumero().equals(doc.getNumero()))
            throw new AlreadyExistingDocException("Numero de documento ingresado ya existe.");
        }
        Documentos.add(doc);
    }

    public void removeDocumento (String name){
        Documentos.removeIf(s->s.getNombre().equalsIgnoreCase(name));
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "Nombre='" + Nombre + '\'' +
                ", puesto='" + puesto + '\'' +
                ", salario=" + salario +
                '}';
    }
}