package com.JESA.s00159619;

import javax.swing.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args){
        ArrayList<Empleado> auxPlanilla = new ArrayList<>();
        Empresa Empresa1 = new Empresa("Papa jones");
        int opcion = 1;
        char opcionchar = ' ';

        do {
            try {
                opcion = Integer.parseInt(JOptionPane.showInputDialog(null, menu()));
                switch (opcion) {
                    case 1:
                        String nombre = JOptionPane.showInputDialog(null, "Nombre: ");
                        String puesto = JOptionPane.showInputDialog(null, "puesto: ");
                        double Salario = Double.parseDouble(JOptionPane.showInputDialog(null, "salario:"));
                        if(Salario<300)
                            throw new SalaryViolationException("El salario esta por debajo del minimo.");
                        String Tipo = JOptionPane.showInputDialog(null, "servicio profecional o plaza fija?");
                        if(Tipo.equalsIgnoreCase("plaza fija") || Tipo.equalsIgnoreCase("servicio profecional")) {
                            if (Tipo.equalsIgnoreCase("plaza fija")) {
                                int extencion = Integer.parseInt(JOptionPane.showInputDialog(null, "Extencion: "));
                                Empresa1.addEmpleado(new PlazaFija(nombre, puesto, Salario, extencion));
                            }
                            else {
                                int mesesContrato = Integer.parseInt(JOptionPane.showInputDialog(null, "meses de contrato:"));
                                Empresa1.addEmpleado(new ServicioProfesional(nombre, puesto, Salario, mesesContrato));
                            }
                            do {
                                try {
                                    opcionchar = JOptionPane.showInputDialog(null, "Desea agregar algun documento de este empleado: S/N").toUpperCase().charAt(0);
                                    switch (opcionchar) {
                                        case 'S':
                                            String NombreDoc = JOptionPane.showInputDialog(null, "Documento a agregar:");
                                            String NumeroDoc = JOptionPane.showInputDialog(null, "Numero del documento:");
                                            Empresa1.getPersonal().get(Empresa1.getPersonal().size() - 1).addDocumento(new Documento(NombreDoc, NumeroDoc));
                                            break;
                                        case 'N':
                                            JOptionPane.showMessageDialog(null, "Empleado igresado.");
                                            break;
                                        default:
                                            JOptionPane.showMessageDialog(null, "Opcion NO valida.");
                                    }
                                } catch (Exception e) {
                                    JOptionPane.showMessageDialog(null, "ERROR: " + e.getMessage());
                                }
                            } while (opcionchar == 'S');
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
                                JOptionPane.showMessageDialog(null,calculadoraImpuestos.calculaPago(s));
                        });
                        break;
                    case 5:
                        JOptionPane.showMessageDialog(null,calculadoraImpuestos.mostrarTotales());
                        break;
                    case 0:
                        JOptionPane.showMessageDialog(null, "Saliendo...");
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "opcion NO valida");
                        break;
                }
            }
            catch (Exception e){
                JOptionPane.showMessageDialog(null,"ERROR: "+ e.getMessage());
            }
        }while(opcion!=0);

    }

    static String menu(){

        return "1.Agregar Empleado\n 2.Despedir Empleado\n 3.Ver lista de empleados\n 4.Calcular Sueldo\n 5.Mostrar totales\n 0. Salir";
    }
}

