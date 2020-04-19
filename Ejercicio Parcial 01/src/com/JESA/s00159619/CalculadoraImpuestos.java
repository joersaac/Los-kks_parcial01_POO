package com.JESA.s00159619;

public final class calculadoraImpuestos {
    private static double totalRenta;
    private static double totalISSS;
    private static double totalAFP;

    private calculadoraImpuestos() {
    }

    public static double calculaPago (Empleado empleado){
        double pago=0, Renta=0, ISSS=0, AFP=0;
        double auxSalario=empleado.getSalario();
        if(empleado instanceof plazaFija){
            AFP=0.0625*auxSalario;
            ISSS=0.03*auxSalario;
            auxSalario=auxSalario-AFP-ISSS;
            if(auxSalario <= 472)
                Renta=0;
            else if(auxSalario <= 895.24 && auxSalario > 472)
                Renta=0.1*(auxSalario-472)+17.67;
            else if(auxSalario <= 2038.10 && auxSalario > 895.24)
                Renta=0.2*(auxSalario-895.24)+60;
            else
                Renta=0.3*(auxSalario-2038.10)+288.57;
        }
        else
            Renta=0.1*auxSalario;
        pago=auxSalario-Renta;
        totalAFP+=AFP;
        totalISSS+=ISSS;
        totalRenta+=Renta;

        return pago;
    }

    public static String mostrarTotales(){
        return "Total ISSS: $" + totalISSS + "\nTotal AFP: $" + totalAFP + "\nTotal Renta: $" + totalRenta;
    }
}

