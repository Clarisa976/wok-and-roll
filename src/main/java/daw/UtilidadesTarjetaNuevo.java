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
public class UtilidadesTarjetaNuevo {

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

    //método apra pedir números en String que ignora los datos que no sean números
    private static String pedirNumeroString(String mensaje) {
        String numero = null;
        boolean esValido = false;
        while (!esValido) {
            try {
                numero = mensaje;
                esValido = true;
            } catch (NumberFormatException nfe) {
                JOptionPane.showMessageDialog(null,
                        "Introduce un número entero válido.");
            }
        }
        return numero;
    }

    /*método Tarjeta para obtejer la tarjeta del cliente creando una nueva
    tarjeta temporal que guardará la tarjeta si está en base de datos de tarjetas
    que tenemos creada*/
    public static Tarjeta obtenerTarjeta(String numeroTarjetaCliente) {
        List<Tarjeta> tarjetasBD = Tarjeta.tarjetasRegistradasBD();
        Tarjeta tarjetaTmp = new Tarjeta();
        //verificamos la tarjeta
        for (int i = 0; i < tarjetasBD.size(); i++) {
            if (numeroTarjetaCliente.equals(tarjetasBD.get(i).getNumeroTarjeta()
                    .substring(tarjetasBD.get(i).getNumeroTarjeta().length() - 4,
                            tarjetasBD.get(i).getNumeroTarjeta().length()))) {
                tarjetaTmp = tarjetasBD.get(i);
            }

        }
        return tarjetaTmp;
    }

    //método para pedir la fecha de caducidad al cliente
    public static LocalDate pedirFechaTarjeta() {

        int diaTarjeta = LocalDate.MIN.getDayOfMonth();
        int mesTarjeta = 0;
        int anioTarjeta = 0;

        try {
            String mesNumero = JOptionPane.showInputDialog(
                    "Introduce el mes en el que caduca tu tarjeta");
            mesTarjeta = pedirNumeroEntero(mesNumero);
            if (mesTarjeta < 1 || mesTarjeta > 12) {
                throw new IllegalArgumentException("Has introducido un mes no válido");
            }
        } catch (IllegalArgumentException iae) {
            JOptionPane.showMessageDialog(null, 
                    "Has introducido un mes no válido. "
                            + "Por favor, introduce un número entre 1 y 12");
        }

        try {
            String anioNumero = JOptionPane.showInputDialog(
                    "Introduce el año en el que caduca tu tarjeta");
            anioTarjeta = pedirNumeroEntero(anioNumero);
            LocalDate fechaActual = LocalDate.now();
            int anioActual = fechaActual.getYear();
            if (anioTarjeta <= anioActual) {
                throw new IllegalArgumentException("El año debe ser posterior al año actual");
            }
        } catch (IllegalArgumentException iae) {
            JOptionPane.showMessageDialog(null, 
                    "El año debe ser posterior al año actual");
        }

        LocalDate fechaTarjeta = LocalDate.of(anioTarjeta, mesTarjeta, diaTarjeta);

        return fechaTarjeta;
    }

    //método para verificar la fecha de la tarjeta
    public static boolean verificarFecha(LocalDate fecha, String numeroCliente) {
        boolean esValida = false;
        Tarjeta tarjetaClienteTmp = obtenerTarjeta(numeroCliente);

        //comprobamos que la fecha introducida es la misma que está guardada
        //en los datos de la tarjeta de nuestra base de datos
        if (fecha.equals(tarjetaClienteTmp.getFechaCaducidadTarjeta())) {
            esValida = true;
        }

        return esValida;
    }

    //método para pedir el CVV
    public static String pedirCVV() {
        String mensajeCVV = JOptionPane.showInputDialog("Introduce el CVV de tu tarjeta.");
        String CVVTarjeta = pedirNumeroString(mensajeCVV);
        return CVVTarjeta;
    }

    //método para verificar el CVV
    public static boolean verificarCVV(String CVV, String numeroCliente) {
        boolean esValida = false;
        Tarjeta tarjetaClienteTmp = obtenerTarjeta(numeroCliente);

        if (CVV.equals(tarjetaClienteTmp.getCvv())) {
            esValida = true;
            return esValida;
        }

        return esValida;
    }

    //método que comprueba el saldo del cliente con la cantidad a pagar
    public static boolean saldoSuficiente(String numeroCliente, double totalPagar) {
        boolean esValida = false;
        Tarjeta tarjetaClienteTmp = obtenerTarjeta(numeroCliente);
        if (tarjetaClienteTmp.getSaldoTarjeta() >= totalPagar) {
            esValida = true;
            return esValida;
        }
        return esValida;
    }

    //método para pedir un entero y controlar excepciones
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

    // método para verificar si una tarjeta es válida y tiene saldo suficiente
    public static boolean verificarTarjetaCompleto(double importeTotal) {

        boolean estaBien = false;

        do {
            String numeroTarjetaCliente = UtilidadesTarjetaNuevo.pedirTarjeta();
            boolean esValidoNumeroTarjeta = UtilidadesTarjetaNuevo.numeroTarjetaValido(numeroTarjetaCliente);

            LocalDate fecha = null;
            try {
                fecha = UtilidadesTarjetaNuevo.pedirFechaTarjeta();

            } catch (IllegalArgumentException iae) {
                System.out.println("Te has colado con la fecha");
            }
            boolean esFechaValida = UtilidadesTarjetaNuevo.verificarFecha(fecha, numeroTarjetaCliente);

            String numeroCVV = UtilidadesTarjetaNuevo.pedirCVV();
            boolean esValidoCVV = UtilidadesTarjetaNuevo.verificarCVV(numeroCVV, numeroTarjetaCliente);

            boolean sePuedePagar = UtilidadesTarjetaNuevo.saldoSuficiente(numeroTarjetaCliente, importeTotal);

            if (esValidoNumeroTarjeta && esFechaValida && esValidoCVV & sePuedePagar) {
                estaBien = true;
            }

        } while (!estaBien);

        return estaBien;
    }

    public static Tarjeta TarjetaDefinitiva(double importe) {
        List<Tarjeta> tarjetasBD = Tarjeta.tarjetasRegistradasBD();
        Tarjeta tarjetaTmp = new Tarjeta();

        String numeroTarjetaCliente = UtilidadesTarjetaNuevo.pedirTarjeta();
        boolean esValidoNumeroTarjeta = UtilidadesTarjetaNuevo.numeroTarjetaValido(numeroTarjetaCliente);

        if (esValidoNumeroTarjeta && verificarTarjetaCompleto(importe)) {

            for (int i = 0; i < tarjetasBD.size(); i++) {
                if (numeroTarjetaCliente.equals(tarjetasBD.get(i).getNumeroTarjeta()
                        .substring(tarjetasBD.get(i).getNumeroTarjeta().length() - 4,
                                tarjetasBD.get(i).getNumeroTarjeta().length()))) {
                    tarjetaTmp = tarjetasBD.get(i);
                }

            }
        }
        return tarjetaTmp;
//        List<Tarjeta> tarjetasBD = Tarjeta.tarjetasRegistradasBD();
//        Tarjeta tarjetaTmp = new Tarjeta();
//
//        String numeroTarjetaCliente = UtilidadesTarjetaNuevo.pedirTarjeta();
//        boolean esValidoNumeroTarjeta = UtilidadesTarjetaNuevo.numeroTarjetaValido(numeroTarjetaCliente);
//
//        if (verificarTarjetaCompleto(importe)) {
//
//            for (int i = 0; i < tarjetasBD.size(); i++) {
//                if (numeroTarjetaCliente.equals(tarjetasBD.get(i).getNumeroTarjeta()
//                        .substring(tarjetasBD.get(i).getNumeroTarjeta().length() - 4,
//                                tarjetasBD.get(i).getNumeroTarjeta().length()))) {
//                    tarjetaTmp = tarjetasBD.get(i);
//                }
//
//            }
//        }
//        return tarjetaTmp;
    }
}
