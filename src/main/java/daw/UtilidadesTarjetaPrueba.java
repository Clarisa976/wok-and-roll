/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw;

import static daw.Tarjeta.tarjetasRegistradasBD;
import java.time.LocalDate;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author clara
 */
public class UtilidadesTarjetaPrueba {

    /*buscamos que el número introducido por el cliente coincida con los ultimos
    cuatro dígitos de alguna de las tarjetas ya guardadas en nuestro sistema. 
    Para ello creamos un método boolean para verificar si está en nuestro sistema
    o no. Usamos un for que recorre la lista de tarjetas y .substring-4 para
    seleccionar los cuatro últimos dígitos de las tarjetas y así lo podremos
    comparar con los números introducidos.*/
    public static boolean numeroTarjetaValido(String numeroCliente) {
        List<Tarjeta> tarjetasBD = Tarjeta.tarjetasRegistradasBD();
        boolean estaRegistrada = false;
        for (int i = 0; i < tarjetasBD.size(); i++) {
            if (numeroCliente.equals(tarjetasBD.get(i).getNumeroTarjeta()
                    .substring(tarjetasBD.get(i).getNumeroTarjeta().length() - 4,
                            tarjetasBD.get(i).getNumeroTarjeta().length()))) {
                estaRegistrada = true;
                return estaRegistrada;
            }

        }
        return estaRegistrada;
    }
//método para pedir la tarjeta al usuario usando JOptionPane

    public static String pedirTarjeta() {
        String mensajeNumero = JOptionPane.showInputDialog("Introduce los cuatro últimos dígitos de tu tarjeta.");
        String numeroTarjeta = pedirNumeroString(mensajeNumero);
        return numeroTarjeta;
    }

    private static String pedirNumeroString(String mensaje) {
        String numero = null;
        boolean esValido = false;
        while (!esValido) {
            try {
                numero = mensaje;
                if (numero.length() <= 5) {
                    esValido = true;
                } else {
                    JOptionPane.showMessageDialog(null,
                            "Intoduzca solo cuatro dígitos");
                }
            } catch (NumberFormatException nfe) {
                JOptionPane.showMessageDialog(null,
                        "Introduce un número entero válido.");
            }
        }
        return numero;
    }
//
//    //método para verificar si la tarjeta está registrada en la base de datos por los últimos 4 dígitos
//    public static boolean verificarTarjeta(String numeroTarjeta) {
//        boolean esValida = false;
//        List<Tarjeta> tarjetaBD = tarjetasRegistradasBD();
//
//        for (int i = 0; i < tarjetaBD.size(); i++) {
//
//            if (numeroTarjeta.equals(tarjetaBD.get(i)
//                    .getNumeroTarjeta()
//                    .substring(tarjetaBD.get(i).getNumeroTarjeta().length() - 4,
//                            tarjetaBD.get(i).getNumeroTarjeta().length()))) {
//                esValida = true;
//                return esValida;
//            }
//        }
//        return esValida;
//    }
//
//    //método para pedirle la tarjeta al cliente
//    public static Tarjeta obtenerTarjetaCliente(String digitosCliente) {
//        List<Tarjeta> tarjetaBD = tarjetasRegistradasBD();
//        Tarjeta tarjetaCliente = new Tarjeta();
//
//        for (int i = 0; i < tarjetaBD.size(); i++) {
//            if (digitosCliente.equals(tarjetaBD.get(i)
//                    .getNumeroTarjeta()
//                    .substring(tarjetaBD.get(i).getNumeroTarjeta().length() - 4,
//                            tarjetaBD.get(i).getNumeroTarjeta().length()))) {
//                tarjetaCliente = tarjetaBD.get(i);
//            }
//        }
//        return tarjetaCliente;
//    }
//
//    //método para pedir la fecha al cliente
//    public static LocalDate pedirFechaTarjeta() {
//        String diaNumero = JOptionPane.showInputDialog("Introduce el día en el que caduca tu tarjeta.");
//        int diaTarjeta = pedirEntero(diaNumero);
//        String mesNumero = JOptionPane.showInputDialog("Introduce el mes en el que caduca tu tarjeta.");
//        int mesTarjeta = pedirEntero(mesNumero);
//        String anioNumero = JOptionPane.showInputDialog("Introduce el año en el que caduca tu tarjeta.");
//        int anioTarjeta = pedirEntero(anioNumero);
//
//        LocalDate fechaTarjeta = LocalDate.of(anioTarjeta, mesTarjeta, diaTarjeta);
//
//        return fechaTarjeta;
//    }
//
//    //método para verificar la fecha de la tarjeta
//    public static boolean verificarFecha(LocalDate fecha, String numeroCliente) {
//        boolean esValida = false;
//        Tarjeta tarjetaCliente = obtenerTarjetaCliente(numeroCliente);
//
//        //comprobamos que la fecha introducida no esté pasada (caducada)
//        //y que la fecha introducida es la misma que está guardada
//        //en los datos de la tarjeta de nuestra base de datos
//        if (fecha.isAfter(LocalDate.now())
//                && fecha.equals(tarjetaCliente.getFechaCaducidadTarjeta())) {
//
//        }
//
//        return esValida;
//    }
//
//    //método para pedir el CVV
//    public static String pedirCVV() {
//        String mensajeCVV = JOptionPane.showInputDialog("Introduce el CVV de tu tarjeta.");
//        String CVVTarjeta = pedirEnteroString(mensajeCVV);
//        return CVVTarjeta;
//    }
//
//    //método para verificar el CVV
//    public static boolean verificarCVV(String CVV, String numeroCliente) {
//        boolean esValida = false;
//        Tarjeta tarjetaCliente = obtenerTarjetaCliente(numeroCliente);
//
//        if (CVV.equals(tarjetaCliente.getCvv())) {
//            esValida = true;
//            return esValida;
//        }
//
//        return esValida;
//    }
//
//    //método para pedir un entero y controlar excepciones

    public static int pedirNumeroEntero(String mensaje) {
        while (true) {
            try {
                int numero = Math.abs(Integer.parseInt(mensaje));
                return numero;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Introduce un número entero válido.");
            }
        }
    }

//    private static String pedirEnteroString(String mensaje) {
//
//        boolean  = false;
//
//        do {
//            if (esEntero(mensaje)) {
//                esEntero = true;
//                return mensaje;
//            } else {
//                JOptionPane.showMessageDialog(null, "Introduce un número entero válido.");
//            }
//        } while (!esEntero);
//        return null;
//    }
//
//    private static boolean esEntero(String mensaje) {
//        try {
//            Integer.parseInt(mensaje);
//            return true;
//        } catch (NumberFormatException nfe) {
//            return false;
//        }
//    }
//
//    //método que verifica si hay saldo suficiente
//    public static boolean saldoSuficiente(String numeroCliente, double totalPagar) {
//        Tarjeta tarjetaCliente = new Tarjeta();
//        
//        List<Tarjeta> listaTmp = Tarjeta.tarjetasRegistradasBD();
//        
//        for (Tarjeta tarjeta : listaTmp) {
//            if (tarjeta.getNumeroTarjeta().equals(numeroCliente)) {
//                tarjetaCliente = tarjeta;
//            }
//        }
//        
//        if (tarjetaCliente.getSaldoTarjeta() >= totalPagar) {
//            return true;
//        }
//        return false;
//    }
//
//    // método para verificar si una tarjeta es válida y tiene saldo suficiente
//    public static boolean verificarTarjetaCompleto(double importeTotal) {
//
//        String numeroTarjeta = pedirTarjeta();
//        LocalDate fecha = pedirFechaTarjeta();
//        String numeroCVV = pedirCVV();
//
//        Tarjeta tarjetaAux = new Tarjeta(numeroTarjeta, fecha, numeroCVV);
//
//        boolean estaBien = true;
//
//        do {
//            //comprobar si la tarjeta está registrada
//            if (UtilidadesTarjetaPrueba.verificarTarjeta(numeroTarjeta)) {
//                tarjetaAux.setNumeroTarjeta(numeroTarjeta);
//            }
//
//            //comprobar si la fecha de caducidad es válida (no posterior a la fecha actual)
//            if (UtilidadesTarjetaPrueba.verificarFecha(fecha, numeroTarjeta)) {
//                tarjetaAux.setFechaCaducidadTarjeta(fecha);
//            }
//
//            //comprobar si el CVV coincide
//            if (UtilidadesTarjetaPrueba.verificarCVV(numeroCVV, numeroCVV)) {
//                tarjetaAux.setCvv(numeroCVV);
//            }
//
//            //comprobar si el saldo es suficiente para el importeTotal del ticket
//            if (!UtilidadesTarjetaPrueba.saldoSuficiente(numeroCVV, importeTotal)) {
//                estaBien = false;
//            }
//
//        } while (!estaBien);
//
//        return estaBien;
//    }
//
//    //aaaaaaaaaaaaaa
//    public static Tarjeta eTarjetaDefinitiva(double importeTotal) {
//
//        Tarjeta tarjetaAux = new Tarjeta();
//        
//        if (verificarTarjetaCompleto(importeTotal)) {
//            
//            String numeroTarjeta = pedirTarjeta();
//            LocalDate fecha = pedirFechaTarjeta();
//            String numeroCVV = pedirCVV();
//
//            tarjetaAux = new Tarjeta(numeroTarjeta, fecha, numeroCVV);
//        }
//        return tarjetaAux;
//
//    }
}
