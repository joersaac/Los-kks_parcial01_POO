package com.JESA.s00159619;

import javax.swing.*;
import java.text.ParseException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args){
        ArrayList<Empleado> auxPlanilla = new ArrayList<>();
        Empresa Empresa1 = new Empresa("Papa jones");
        int opcion = 1;

        do {
            try {
                opcion = Integer.parseInt(JOptionPane.showInputDialog(null, menu()));
                switch (opcion) {
                    case 1:
                        String nombre = JOptionPane.showInputDialog(null, "Nombre: ");
                        String puesto = JOptionPane.showInputDialog(null, "puesto: ");
                        double Salario = Double.parseDouble(JOptionPane.showInputDialog(null, "salario:"));
                        String Tipo = JOptionPane.showInputDialog(null, "servicio profecional o plaza fija?");

                        if(Tipo.equalsIgnoreCase("plaza fija")) {
                            int extencion = Integer.parseInt(JOptionPane.showInputDialog(null, "Extencion: "));
                            Empresa1.addEmpleado(new PlazaFija(nombre, puesto, Salario, extencion));
                        }
                        else if(Tipo.equalsIgnoreCase("servicio profecional")){
                            int mesesContrato = Integer.parseInt(JOptionPane.showInputDialog(null, "meses de contrato:"));
                            Empresa1.addEmpleado(new ServicioProfesional(nombre, puesto, Salario, mesesContrato));
                        }
                        else
                            JOptionPane.showMessageDialog(null, "area ingresada no valida ");
                        break;
                    case 2:
                        String EmployeeFired = JOptionPane.showInputDialog(null, "Nombre del empleado a despedir:");
                        Empresa1.quitEmpleado(EmployeeFired);
                        break;
                    case 3:
                        String mess = "";

                        for(Empleado p : Empresa1.getPersonal()){
                            mess+= p.toString() + "\n";
                        }

                        JOptionPane.showMessageDialog(null, mess);
                        break;
                    case 4:
                        String EmployeePay = JOptionPane.showInputDialog(null, "Nombre del empleado a Pagar:");
                        auxPlanilla = Empresa1.getPersonal();
                        auxPlanilla.forEach(s -> {
                            if (s.Nombre.equalsIgnoreCase(EmployeePay))
                                JOptionPane.showMessageDialog(null, calculadoraImpuestos.calculaPago(s));
                        });
                        break;
                    case 5:
                        JOptionPane.showMessageDialog(null,calculadoraImpuestos.mostrarTotales());
                        break;
                    case 0:
                        JOptionPane.showMessageDialog(null, "Saliendo...");
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "opcion erronea");
                        break;
                }
            }
            catch (Exception e){
                JOptionPane.showMessageDialog(null,"ERROR");
            }
        }while(opcion!=0);

    }

    static String menu(){

        return "1.Agregar Empleado\n 2.Despedir Empleado\n 3.Ver lista de empleados\n 4.Calcular Sueldo\n 5.Mostrar totales\n 0. Salir";
    }
}

