package com.JESA.s00159619;

public class ServicioProfesional extends Empleado {
    private int mesesContrato;

    public ServicioProfesional(String nombre, String puesto, double salario, int mesesContrato) {
        super(nombre, puesto, salario);
        this.mesesContrato = mesesContrato;
    }

    public void setMesesContrato(int mesesContrato) {
        this.mesesContrato = mesesContrato;
    }

    public int getMesesContrato() {
        return mesesContrato;
    }

    @Override
    public String toString() {
        return "servicioProfesional{" +
                ", Nombre='" + Nombre + '\'' +
                ", puesto='" + puesto + '\'' +
                ", salario=" + salario + '\'' +
                "mesesContrato=" + mesesContrato +
                '}';
    }
}
