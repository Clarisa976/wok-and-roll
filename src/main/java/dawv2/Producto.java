/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dawv2;

import java.util.Objects;
import org.apache.commons.lang3.RandomStringUtils;

/**
 *
 * @author clara
 */
public abstract class Producto {

    //atributos
    private final String codProducto;
    private String nombre;
    private double precioSinIVA;
    private double precioConIVA;
    private TipoIVA tipoIVA;//21% para las bebidas alcohólicas y 10% para el resto
    private int stock;

    //constructor
    public Producto(String nombre, double precioSinIVA, TipoIVA tipoIVA, int stock) {
        this.codProducto = RandomStringUtils.randomNumeric(5);
        this.nombre = nombre;
        this.precioSinIVA = precioSinIVA;
        this.tipoIVA = tipoIVA;
        this.stock = stock;
        this.precioConIVA = calcularPrecio();
    }

    public Producto() {
        this.codProducto = RandomStringUtils.randomNumeric(5);
    }

    public Producto(Producto copia) {
        this.codProducto = copia.codProducto;
        this.nombre = copia.nombre;
        this.precioSinIVA = copia.precioSinIVA;
        this.tipoIVA = copia.tipoIVA;
        this.stock = copia.stock;
        this.precioConIVA = calcularPrecio();
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

    public int getStock() {
        return stock;
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

    public void setStock(int stock) {
        this.stock = stock;
    }

    public void setTipoIVA(TipoIVA tipoIVA) {
        this.tipoIVA = tipoIVA;
    }

    public void setPrecioConIVA(double precioConIVA) {
        this.precioConIVA = precioConIVA;
    }

    //hashcode
    @Override
    public final int hashCode() {
        int hash = 3;
        hash = 41 * hash + Objects.hashCode(this.codProducto);
        return hash;
    }

    //equals
    @Override
    public final boolean equals(Object obj) {
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
        sb.append(", precio con IVA: ").append(precioSinIVA);
        sb.append(", tipo de IVA: ").append(tipoIVA);
        sb.append(", stock: ").append(stock);
        return sb.toString();
    }

    //método para calcular el precioSinIVA con iva
    public final double calcularPrecio(){
    double valorIVA = tipoIVA.getValor();
        return precioConIVA = precioSinIVA * (1 + valorIVA);
    }
}
