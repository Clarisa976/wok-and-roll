/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw;

import java.time.LocalDate;
import java.util.Objects;

/**
 *
 * @author miguel
 */
public class Tarjeta {
    
    private String numeroTarjeta;
    private LocalDate fechaCaducidadTarjeta;
    private String Cvv;

    //constructor parametrizado
    public Tarjeta(String numeroTarjeta, LocalDate fechaCaducidadTarjeta, String Cvv) {
        this.numeroTarjeta = numeroTarjeta;
        this.fechaCaducidadTarjeta = fechaCaducidadTarjeta;
        this.Cvv = Cvv;
    }

    // Getter y setter de todo
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
        sb.append("numeroTarjeta=").append(numeroTarjeta);
        sb.append(", fechaCaducidadTarjeta=").append(fechaCaducidadTarjeta);
        sb.append(", Cvv=").append(Cvv);
        sb.append('}');
        return sb.toString();
    }
}
