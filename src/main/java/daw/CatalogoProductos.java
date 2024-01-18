/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author clara
 */
public class CatalogoProductos {

    //atributos
    private final List<Producto> listaProductos;

    //constructor
    public CatalogoProductos(List<Producto> listaProductos) {
        this.listaProductos = new ArrayList<>();
    }

    //método para calcular el precio con iva
    public static double calcularPrecio(Producto aux) {
        //tipos de IVA
        final int DIEZ = 10;
        final int VEINTIUNO = 21;
        int porcentaje = (aux.getTipoIVA()
                .equals(TipoIVA.IVA_DIEZ)) ? 10 : 21;

        //V+((P/100)*V
        double precioFinal = aux.getPrecioSinIVA() + ((porcentaje / 100)
                + aux.getPrecioSinIVA());

        return precioFinal;
    }

}
