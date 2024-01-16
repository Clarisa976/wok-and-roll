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
    private TipoComida tipoComida;
    
    //constructor

    public Comida(String descripcionComida, TipoComida tipoComida, 
            String codProducto, String nombre, double precioSinIVA, double precioConIVA) {
        super(codProducto, nombre, precioSinIVA, precioConIVA);
        this.descripcionComida = descripcionComida;
        this.tipoComida = tipoComida;
    }

    //getter y setter
    public String getDescripcionComida() {
        return descripcionComida;
    }

    public void setDescripcionComida(String descripcionComida) {
        this.descripcionComida = descripcionComida;
    }

    public TipoComida getTipoComida() {
        return tipoComida;
    }

    public void setTipoComida(TipoComida tipoComida) {
        this.tipoComida = tipoComida;
    }

    //toString

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("descripción: ").append(descripcionComida);
        sb.append(", tipo: ").append(tipoComida);
        sb.append('}');
        return sb.toString();
    }
    
    
}
