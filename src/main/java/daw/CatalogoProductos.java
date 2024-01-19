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

    //getter
    public List<Producto> getListaProductos() {
        return listaProductos;
    }

    //toString
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CatalogoProductos{");
        sb.append("listaProductos=").append(listaProductos);
        sb.append('}');
        return sb.toString();
    }
    
    //método de cartaComida
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
        
        cartaComidas.add(c1);
        cartaComidas.add(c2);
        cartaComidas.add(c3);
        cartaComidas.add(c4);
        cartaComidas.add(c5);
        cartaComidas.add(c6);
        cartaComidas.add(c7);
        cartaComidas.add(c8);
        cartaComidas.add(c9);
        
        return cartaComidas;
    }
}
