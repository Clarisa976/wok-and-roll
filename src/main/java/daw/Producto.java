/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw;

import java.util.Objects;

/**
 *
 * @author clara
 */
public class Producto {
    //atributos
    private final String codProducto;
    private String nombre;
    private double precioSinIVA;
    private double precioConIVA;
    
    //constructor
    public Producto(String codProducto, String nombre, double precioSinIVA, double precioConIVA) {
        this.codProducto = codProducto;
        this.nombre = nombre;
        this.precioSinIVA = precioSinIVA;
        this.precioConIVA = precioConIVA;
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

    public double getPrecioConIVA() {
        return precioConIVA;
    }
    
    //setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecioSinIVA(double precioSinIVA) {
        this.precioSinIVA = precioSinIVA;
    }

    public void setPrecioConIVA(double precioConIVA) {
        this.precioConIVA = precioConIVA;
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
        sb.append(", precio con IVA: ").append(precioConIVA);
        sb.append('}');
        return sb.toString();
    }
    
}
