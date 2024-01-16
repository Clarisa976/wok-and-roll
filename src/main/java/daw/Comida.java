/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw;

/**
 *
 * @author clara
 */
public class Comida extends Producto {
    //atributos
    private String descripcionComida;
    
    //constructor
    public Comida(String descripcionComida, String codProducto, String nombre, 
            double precioSinIVA, double precioConIVA) {
        super(codProducto, nombre, precioSinIVA, precioConIVA);
        this.descripcionComida = descripcionComida;
    }
    
    //getter y setter
    public String getDescripcionComida() {
        return descripcionComida;
    }

    public void setDescripcionComida(String descripcionComida) {
        this.descripcionComida = descripcionComida;
    }
    
    //toString

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Comida{");
        sb.append("Descripción: ").append(descripcionComida);
        sb.append('}');
        return sb.toString();
    }
    
}
