/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dawv2;

/**
 *
 * @author clara
 */
public class Comida extends Producto {

    //atributos
    private String descripcionComida;
    private TipoComida tipoComida;

    //constructor
    public Comida(String nombre, String descripcionComida, TipoComida tipoComida,
            double precioSinIVA, TipoIVA tipoIVA,  int stock) {
        super(nombre, precioSinIVA, tipoIVA, stock);
        this.descripcionComida = descripcionComida;
        this.tipoComida = tipoComida;
        //precioConIVA = calcularPrecio();
    }

    public Comida() {
        super();
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
        sb.append(super.getCodProducto());
        sb.append(super.getNombre());
        sb.append("descripción: ").append(descripcionComida);
        sb.append(", tipo: ").append(tipoComida);
        sb.append(super.getPrecioSinIVA());
        sb.append(super.getTipoIVA());
        sb.append(super.getPrecioConIVA());
        sb.append(super.getStock());
        sb.append('}');
        return sb.toString();
    }

    
}
