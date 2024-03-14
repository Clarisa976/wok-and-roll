/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dawv2;

/**
 *
 * @author miguel
 */
public class Bebida extends Producto {

    // atributos
    private int tamanioBebida;
    private TipoBebida tipoBebida;

    //cosntructor 
    public Bebida(String nombre, int tamanioBebida, TipoBebida tipoBebida,
            double precioSinIVA, TipoIVA tipoIVA, int stock) {
        super(nombre, precioSinIVA, tipoIVA, stock);
        this.tamanioBebida = tamanioBebida;
        this.tipoBebida = tipoBebida;
    }

    public Bebida() {
    }

    public int getTamanioBebida() {
        return tamanioBebida;
    }

    public void setTamanioBebida(int tamanioBebida) {
        this.tamanioBebida = tamanioBebida;
    }

    public TipoBebida getTipoBebida() {
        return tipoBebida;
    }

    public void setTipoBebida(TipoBebida tipoBebida) {
        this.tipoBebida = tipoBebida;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.getCodProducto());
        sb.append(super.getNombre());
        sb.append("tamaño bebida: ").append(tamanioBebida);
        sb.append(", tipo bebida: ").append(tipoBebida);
        sb.append(super.getPrecioSinIVA());
        sb.append(super.getTipoIVA());
        sb.append(super.getPrecioConIVA());
        sb.append(super.getStock());        
        sb.append('}');
        return sb.toString();
    }

    
}
