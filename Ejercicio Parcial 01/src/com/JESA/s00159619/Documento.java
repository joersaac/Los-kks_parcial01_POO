package com.JESA.s00159619;

public class Documento {
    private String Nombre;
    private String numero;

    public Documento(String nombre, String numero) {
        Nombre = nombre;
        this.numero = numero;
    }

    public String getNombre() {
        return Nombre;
    }

    public String getNumero() {
        return numero;
    }

    @Override
    public String
    toString() {
        return "Documento{" +
                "Nombre='" + Nombre + '\'' +
                ", numero='" + numero + '\'' +
                '}';
    }
}
