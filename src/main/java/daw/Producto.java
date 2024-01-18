/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw;

import java.util.Objects;
import org.apache.commons.lang3.RandomStringUtils;

/**
 *
 * @author clara
 */
public class Producto {
    //atributos
    private final String codProducto;
    private String nombre;
    private double precioSinIVA;
    private final TipoIVA tipoIVA;//21% para las bebidas alcohólicas y 10% para el resto
    
    //constructor
    public Producto(String nombre, double precioSinIVA, TipoIVA tipoIVA) {
        this.codProducto = RandomStringUtils.randomNumeric(5);
        this.nombre = nombre;
        this.precioSinIVA = precioSinIVA;
        this.tipoIVA = tipoIVA;
    }

   
    //getters
    public String getCodProducto() {
        return codProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecioSinIVA() {
        return precioSinIVA;
    }

    
    //setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecioSinIVA(double precioSinIVA) {
        this.precioSinIVA = precioSinIVA;
    }

    //hashcode
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 41 * hash + Objects.hashCode(this.codProducto);
        return hash;
    }
    
    //equals
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
        final Producto other = (Producto) obj;
        return Objects.equals(this.codProducto, other.codProducto);
    }
    
    //toString

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Producto{");
        sb.append("código del producto: ").append(codProducto);
        sb.append(", nombre ").append(nombre);
        sb.append(", precio sin IVA: ").append(precioSinIVA);
        return sb.toString();
    }

}
