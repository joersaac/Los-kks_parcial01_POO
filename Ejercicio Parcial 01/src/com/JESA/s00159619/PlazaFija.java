package com.JESA.s00159619;

public class PlazaFija extends Empleado {
    private int extencion;

    public PlazaFija(String nombre, String puesto, double salario, int extencion) {
        super(nombre, puesto, salario);
        this.extencion = extencion;
    }

    public void setExtencion(int extencion) {
        this.extencion = extencion;
    }

    public int getExtencion() {
        return extencion;
    }

    @Override
    public String toString() {
        return "PlazaFija{" +
                "extencion=" + extencion +
                ", Nombre='" + Nombre + '\'' +
                ", puesto='" + puesto + '\'' +
                ", salario=" + salario + '}' + "\n    " + Documentos.toString();
    }
}
