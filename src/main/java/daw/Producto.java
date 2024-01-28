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
    private double precio;
    private TipoIVA tipoIVA;//21% para las bebidas alcohólicas y 10% para el resto
    private int stock;

    //constructor
    public Producto(String nombre, double precioSinIVA, TipoIVA tipoIVA, int stock) {
        this.codProducto = RandomStringUtils.randomNumeric(5);
        this.nombre = nombre;
        this.precio = precioSinIVA;
        this.tipoIVA = tipoIVA;
        this.stock = stock;
    }

    public Producto() {
        this.codProducto = RandomStringUtils.randomNumeric(5);
    }


    //getters
    public String getCodProducto() {
        return codProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public TipoIVA getTipoIVA() {
        return tipoIVA;
    }

    public int getStock() {
        return stock;
    }

    //setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
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
        sb.append(", precio: ").append(precio);
        sb.append(", tipo de IVA: ").append(tipoIVA);
        sb.append(", stock: ").append(stock);
        return sb.toString();
    }
//    //método para calcular el precio con iva
//    public static double calcularPrecio() {
//        Producto p = new Producto();
//        //tipos de IVA
//        final int DIEZ = 10;
//        final int VEINTIUNO = 21;
//        int porcentaje = (p.getTipoIVA()
//                .equals(TipoIVA.IVA_DIEZ)) ? DIEZ : VEINTIUNO;
//
//        double precioFinal = p.getPrecioSinIVA() + ((porcentaje / 100)
//                * p.getPrecioSinIVA());
//
//        return precioFinal;
//    }
}
