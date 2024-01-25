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
public class UtilidadesTarjeta {
        //método para verificar si la tarjeta está registrada en la base de datos por los últimos 4 dígitos

    public static boolean verificarTarjetaRegistrada(String numeroTarjeta) {
        boolean esValida = false;
        List<Tarjeta> tarjetaBD = tarjetasRegistradasBD();

        for (int i = 0; i < tarjetaBD.size(); i++) {

            if (numeroTarjeta.equals(tarjetaBD.get(i)
                    .getNumeroTarjeta()
                    .substring(tarjetaBD.get(i).getNumeroTarjeta().length() - 4,
                            tarjetaBD.get(i).getNumeroTarjeta().length()))) {
                esValida = true;
                return esValida;
            }
        }
        return esValida;
    }

    //método para pedirle la tarjeta al cliente
    public static Tarjeta obtenerTarjetaCliente(String digitosCliente) {
        List<Tarjeta> tarjetaBD = tarjetasRegistradasBD();
        Tarjeta tarjetaCliente = new Tarjeta();

        for (int i = 0; i < tarjetaBD.size(); i++) {
            if (digitosCliente.equals(tarjetaBD.get(i)
                    .getNumeroTarjeta()
                    .substring(tarjetaBD.get(i).getNumeroTarjeta().length() - 4,
                            tarjetaBD.get(i).getNumeroTarjeta().length()))) {
                tarjetaCliente = tarjetaBD.get(i);
            }
        }
        return tarjetaCliente;
    }

    //método para pedir la fecha al cliente
    public static LocalDate pedirFechaTarjeta() {
        String diaNumero = JOptionPane.showInputDialog("Introduce ed día en el que caduca tu tarjeta.");
        int diaTarjeta = pedirEntero(diaNumero);
        String mesNumero = JOptionPane.showInputDialog("Introduce ed día en el que caduca tu tarjeta.");
        int mesTarjeta = pedirEntero(mesNumero);
        String anioNumero = JOptionPane.showInputDialog("Introduce ed día en el que caduca tu tarjeta.");
        int anioTarjeta = pedirEntero(anioNumero);

        LocalDate fechaTarjeta = LocalDate.of(anioTarjeta, mesTarjeta, diaTarjeta);

        return fechaTarjeta;
    }

    //método para verificar la fecha de la tarjeta
    public static boolean verificarFecha(LocalDate fecha, String numeroCliente) {
        boolean esValida = false;
        Tarjeta tarjetaCliente = obtenerTarjetaCliente(numeroCliente);

        //comprobamos que la fecha introducida no esté pasada (caducada)
        //y que la fecha introducida es la misma que está guardada
        //en los datos de la tarjeta de nuestra base de datos
        if (fecha.isAfter(LocalDate.now())
                && fecha.equals(tarjetaCliente.getFechaCaducidadTarjeta())) {

        }

        return esValida;
    }

    //método para pedir el CVV
    public static String pedirCVV() {
        String mensajeCVV = JOptionPane.showInputDialog("Introduce el CVV de tu tarjeta.");
        String CVVTarjeta = pedirEnteroString(mensajeCVV);
        return CVVTarjeta;
    }

    //método para verificar el CVV
    public static boolean verificarCVV(String CVV, String numeroCliente) {
        boolean esValida = false;
        Tarjeta tarjetaCliente = obtenerTarjetaCliente(numeroCliente);

        if (CVV.equals(tarjetaCliente.getCvv())) {
            esValida = true;
            return esValida;
        }

        return esValida;
    }

    //método para pedir un entero y controlar excepciones
    public static int pedirEntero(String mensaje) {
        while (true) {
            try {
                int numero = Integer.parseInt(mensaje);
                return numero;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Introduce un número entero válido.");
            }
        }
    }

    private static String pedirEnteroString(String mensaje) {
        while (true) {
//            try {
            if (esEntero(mensaje)) {
                return mensaje;
            } else {
//                String aux = JOptionPane.showInputDialog(mensaje);
//                Integer.parseInt(aux); // Intentamos convertir a entero para validar la entrada
//                return aux; // Si no se lanza una excepción, la entrada es válida como cadena.
//            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Introduce un número entero válido.");
            }
        }
    }

    private static boolean esEntero(String mensaje) {
        try {
            Integer.parseInt(mensaje);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
    
    //método para pagar verificando la tarjeta
    private static void pagar (TPV tpv, double importe){
        
    }
    /*
    if (UtilidadesTarjeta.fechaCaducidadYCVVValidos(digitosTarjeta, fechaCaducidad, cvv.getText())) {

                        if (UtilidadesTarjeta.saldoSuficiente(digitosTarjeta, totalPagar)) {
                            for (int i = 0; i < UtilidadesTarjeta.baseDatosTarjeta().size(); i++) {
                                if (digitosTarjeta.equals(UtilidadesTarjeta.baseDatosTarjeta().get(i)
                                        .getNumTarjeta()
                                        .substring(UtilidadesTarjeta.baseDatosTarjeta().get(i).getNumTarjeta().length() - 4,
                                                UtilidadesTarjeta.baseDatosTarjeta().get(i).getNumTarjeta().length()))) {

                                    UtilidadesTarjeta.baseDatosTarjeta().get(i).setSaldo(
                                            UtilidadesTarjeta.baseDatosTarjeta().get(i).getSaldo() - totalPagar);
                                }
                            }

                            for (Producto p1 : tpv.getCarrito()) {
                                for (Producto p2 : tpv.getCartaProductos()) {
                                    if(p1.equals(p2)){
                                        p2.setStock(p2.getStock() - p1.getStock());
                                    }
                                }
                            }

                            Ticket t = new Ticket(new ArrayList<Producto>(tpv.getCarrito()),
                                    totalPagar, LocalDate.now(),
                                    LocalTime.now());
                            tpv.getBaseDatosTicket().add(t);
                            tpv.getCarrito().clear();

                            String[] opciones = {"Aceptar"};

                            JOptionPane.showOptionDialog(null,
                                    t, "TPV", JOptionPane.DEFAULT_OPTION,
                                    JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);
                            seleccionarCategoría(tpv);
    
    */
}
