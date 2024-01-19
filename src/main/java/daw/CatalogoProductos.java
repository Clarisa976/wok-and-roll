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
    public List<Producto> listaProductos;

    //constructor
//    public CatalogoProductos(List<Producto> listaProductos) {
//        this.listaProductos = new ArrayList<>();
//    }
    
    public List<Producto> cartaComidas(){
        List<Producto> cartaComidas = new ArrayList<>();
        //creamos nueve comidas
        Producto c1 = new Comida("Ramen de curry", 
                "Delicioso ramen con fideos udon, tonkatsu "
                        + "y sopa de curry ", TipoComida.RAMEN,
                9.50, TipoIVA.IVA_DIEZ);        
        Producto c2 = new Comida("Ramen de pollo", 
                "Clásico ramen de pollo ", TipoComida.RAMEN,
                8, TipoIVA.IVA_DIEZ);
        Producto c3 = new Comida("Ramen de miso", 
                "Ramen de miso sosillo", TipoComida.RAMEN,
                6, TipoIVA.IVA_DIEZ);
        
        Producto c4 = new Comida("Nigiri de salmón", 
                "Dos piezas de nigiri de salmón", TipoComida.SUSHI,
                3, TipoIVA.IVA_DIEZ);
        Producto c5 = new Comida("Nigiri de atún",
                "Dos piezas de nigiri de atún rojo de remolacha", 
                TipoComida.SUSHI,
                2.50, TipoIVA.IVA_DIEZ);        
        Producto c6 = new Comida("Uramame de pollo crujiente", 
                "Rollo de arroz relleno de pollo rebozado con "
                        + "panko y alga nori", TipoComida.SUSHI,
                2, TipoIVA.IVA_DIEZ);
        
        Producto c7 = new Comida("Veruras","Wok de verduritas",
                TipoComida.WOK,4, TipoIVA.IVA_DIEZ);        
        Producto c8 = new Comida("Carne", "Wok de carnecita", 
                TipoComida.WOK, 4.50, TipoIVA.IVA_DIEZ);
        Producto c9 = new Comida("Marisco", 
                "Wok de gambas de Cádiz", TipoComida.WOK,
                5.50, TipoIVA.IVA_DIEZ);

        return cartaComidas;
    }
    

    //método para calcular el precio con iva
    public static double calcularPrecio(Producto aux) {
        //tipos de IVA
        final int DIEZ = 10;
        final int VEINTIUNO = 21;
        int porcentaje = (aux.getTipoIVA()
                .equals(TipoIVA.IVA_DIEZ)) ? DIEZ : VEINTIUNO;

        //V+((P/100)*V
        double precioFinal = aux.getPrecioSinIVA() + ((porcentaje / 100)
                + aux.getPrecioSinIVA());

        return precioFinal;
    }

}
