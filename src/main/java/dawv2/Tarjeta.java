/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dawv2;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
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
    public static List<Tarjeta> tarjetasRegistradasBD() {
        List<Tarjeta> listaTarjetas = new ArrayList<>();
        //creamos tarjetas
        Tarjeta t1 = new Tarjeta("Juan Perez",
                "1234567812345678",
                LocalDate.of(2025, 12, LocalDate.MIN.getDayOfMonth()),
                "123", 1000.0);
        Tarjeta t2 = new Tarjeta("Maria Lopez",
                "2345678923456789",
                LocalDate.of(2024, 6, LocalDate.MIN.getDayOfMonth()),
                "456", 500.0);
        Tarjeta t3 = new Tarjeta("Carlos Rodriguez",
                "3456789034567890",
                LocalDate.of(2023, 4, LocalDate.MIN.getDayOfMonth()),
                "789", 200.0);
        Tarjeta t4 = new Tarjeta("Ana Garcia",
                "4567890145678901",
                LocalDate.of(2026, 8, LocalDate.MIN.getDayOfMonth()),
                "234", 1500.0);
        Tarjeta t5 = new Tarjeta("Pedro Sanchez",
                "5678901256789012",
                LocalDate.of(2024, 10, LocalDate.MIN.getDayOfMonth()),
                "567", 800.0);

        //las añadimos a la lista
        listaTarjetas.add(t1);
        listaTarjetas.add(t2);
        listaTarjetas.add(t3);
        listaTarjetas.add(t4);
        listaTarjetas.add(t5);
        return listaTarjetas;
    }


    //método auxiliar para buscar una tarjeta por número en la lista de tarjetas registradas
    private Tarjeta buscarTarjeta(String numero) {
        for (Tarjeta tarjeta : tarjetasRegistradas) {
            if (tarjeta.numeroTarjeta.endsWith(numero)) {
                return tarjeta;
            }
        }
        return null; //tarjeta no encontrada
    }

}
