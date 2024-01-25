/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw;

import static daw.UtilidadesTPV.pedirEntero;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.swing.JOptionPane;

/**
 *
 * @author miguel
 */
public class Tarjeta {

    private String nombreTitularTarjeta;
    private String numeroTarjeta;
    private LocalDate fechaCaducidadTarjeta;
    private String Cvv;
    private Double SaldoTarjeta;

    //lista de tarjetas registradas en la pasarela
    private static List<Tarjeta> tarjetasRegistradas;
    //constructor parametrizado

    public Tarjeta(String nombreTitularTarjeta, String numeroTarjeta, LocalDate fechaCaducidadTarjeta, String Cvv, Double SaldoTarjeta) {
        this.nombreTitularTarjeta = nombreTitularTarjeta;
        this.numeroTarjeta = numeroTarjeta;
        this.fechaCaducidadTarjeta = fechaCaducidadTarjeta;
        this.Cvv = Cvv;
        this.SaldoTarjeta = SaldoTarjeta;
    }

    public Tarjeta(String numeroTarjeta, LocalDate fechaCaducidadTarjeta, String Cvv) {
        this.numeroTarjeta = numeroTarjeta;
        this.fechaCaducidadTarjeta = fechaCaducidadTarjeta;
        this.Cvv = Cvv;
        
    }

    public Tarjeta() {
    }
    

    // Getter y setter
    public String getNombreTitularTarjeta() {
        return nombreTitularTarjeta;
    }

    public void setNombreTitularTarjeta(String nombreTitularTarjeta) {
        this.nombreTitularTarjeta = nombreTitularTarjeta;
    }

    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public void setNumeroTarjeta(String numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    public LocalDate getFechaCaducidadTarjeta() {
        return fechaCaducidadTarjeta;
    }

    public void setFechaCaducidadTarjeta(LocalDate fechaCaducidadTarjeta) {
        this.fechaCaducidadTarjeta = fechaCaducidadTarjeta;
    }

    public String getCvv() {
        return Cvv;
    }

    public void setCvv(String Cvv) {
        this.Cvv = Cvv;
    }

    public Double getSaldoTarjeta() {
        return SaldoTarjeta;
    }

    public void setSaldoTarjeta(Double SaldoTarjeta) {
        this.SaldoTarjeta = SaldoTarjeta;
    }

    // método equals y hashcode de numeroTarjeta y CVV
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 11 * hash + Objects.hashCode(this.numeroTarjeta);
        hash = 11 * hash + Objects.hashCode(this.Cvv);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Tarjeta other = (Tarjeta) obj;
        if (!Objects.equals(this.numeroTarjeta, other.numeroTarjeta)) {
            return false;
        }
        return Objects.equals(this.Cvv, other.Cvv);
    }

    // método to-string (creo que no es necesario)
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Tarjeta{");
        sb.append("nombreTitularTarjeta=").append(nombreTitularTarjeta);
        sb.append(", numeroTarjeta=").append(numeroTarjeta);
        sb.append(", fechaCaducidadTarjeta=").append(fechaCaducidadTarjeta);
        sb.append(", Cvv=").append(Cvv);
        sb.append(", SaldoTarjeta=").append(SaldoTarjeta);
        sb.append('}');
        return sb.toString();
    }

    //método de una Lista con tarjetas
    private static List<Tarjeta> tarjetasRegistradasBD() {
        List<Tarjeta> listaTarjetas = new ArrayList<>();
        //creamos tarjetas
        Tarjeta t1 = new Tarjeta("Juan Perez",
                "1234567812345678", 
                LocalDate.of(2025, 12, 31),
                "123", 1000.0);
        Tarjeta t2 = new Tarjeta("Maria Lopez", 
                "2345678923456789", 
                LocalDate.of(2024, 6, 30), 
                "456", 500.0);
        Tarjeta t3 = new Tarjeta("Carlos Rodriguez", 
                "3456789034567890", 
                LocalDate.of(2023, 4, 15),
                "789", 200.0);
        Tarjeta t4 = new Tarjeta("Ana Garcia", 
                "4567890145678901", 
                LocalDate.of(2026, 8, 28),
                "234", 1500.0);
        Tarjeta t5 = new Tarjeta("Pedro Sanchez", 
                "5678901256789012", 
                LocalDate.of(2024, 10, 10),
                "567", 800.0);

        //las añadimos a la lista
        listaTarjetas.add(t1);
        listaTarjetas.add(t2);
        listaTarjetas.add(t3);
        listaTarjetas.add(t4);
        listaTarjetas.add(t5);
        return listaTarjetas;
    }

//    // método para verificar si una tarjeta es válida y tiene saldo suficiente
//    public boolean verificarTarjeta(Double importeTotal) {
//        //comprobar si la tarjeta está registrada
//       if (!verificarTarjetaRegistrada()) {
//            return false; //la tarjeta no está registrada
//        }
//
//        //comprobar si la fecha de caducidad es válida (no posterior a la fecha actual)
//         if (fechaCaducidadTarjeta.isAfter(LocalDate.now())) {
//            return false; //la fecha de caducidad es posterior a la fecha actual
//        }
//
//        //comprobar si el CVV coincide
//        if (!Cvv.equals(buscarTarjeta(numeroTarjeta).Cvv)) {
//            return false; //el CVV no coincide
//        }
//
//        //comprobar si el saldo es suficiente para el importeTotal del ticket
//        if (SaldoTarjeta <= importeTotal) {
//            return false; //el saldo no es suficiente
//        }
//
//        return true; //la tarjeta es válida y tiene saldo suficiente
//    }

    //método auxiliar para buscar una tarjeta por número en la lista de tarjetas registradas
    private Tarjeta buscarTarjeta(String numero) {
        for (Tarjeta tarjeta : tarjetasRegistradas) {
            if (tarjeta.numeroTarjeta.endsWith(numero)) {
                return tarjeta;
            }
        }
        return null; //tarjeta no encontrada
    }
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
    public static LocalDate pedirFechaTarjeta(){
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
    public static boolean verificarFecha(LocalDate fecha, String numeroCliente){
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
}
