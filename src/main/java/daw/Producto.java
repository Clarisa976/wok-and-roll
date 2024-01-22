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
    private TipoIVA tipoIVA;//21% para las bebidas alcohólicas y 10% para el resto
    private double precioConIVA;
    private int stock;

    //constructor
    public Producto(String nombre, double precioSinIVA, TipoIVA tipoIVA, int stock) {
        this.codProducto = RandomStringUtils.randomNumeric(5);
        this.nombre = nombre;
        this.precioSinIVA = precioSinIVA;
        this.tipoIVA = tipoIVA;
        this.precioConIVA = calcularPrecio();
        this.stock = stock;
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

    public TipoIVA getTipoIVA() {
        return tipoIVA;
    }

    public double getPrecioConIVA() {
        return precioConIVA;
    }

    public int getStock() {
        return stock;
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

    public void setStock(int stock) {
        this.stock = stock;
    }

    public void setTipoIVA(TipoIVA tipoIVA) {
        this.tipoIVA = tipoIVA;
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
        sb.append(", nombre: ").append(nombre);
        sb.append(", precio sin IVA: ").append(precioSinIVA);
        sb.append(", tipo de IVA: ").append(tipoIVA);
        sb.append(", precio con IVA: ").append(precioConIVA);
        sb.append(", stock: ").append(stock);
        return sb.toString();
    }
    //método para calcular el precio con iva
    public double calcularPrecio() {
        //tipos de IVA
        final int DIEZ = 10;
        final int VEINTIUNO = 21;
        int porcentaje = (this.tipoIVA
                .equals(TipoIVA.IVA_DIEZ)) ? DIEZ : VEINTIUNO;

        //V+((P/100)*V
        double precioFinal = this.precioSinIVA + ((porcentaje / 100)
                + this.precioSinIVA);

        return precioFinal;
    }
}
