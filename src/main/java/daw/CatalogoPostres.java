/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author miguel
 */
public class CatalogoPostres {
    
    //atributos
    private final List<Producto> listaPostres;

    //constructor
    public CatalogoPostres() {
        this.listaPostres = cartaPostres();
    }

    //getter
    public List<Producto> getListaPostres() {
        return listaPostres;
    }

    //toString
    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();

        for (Producto producto : listaPostres) {
            sb.append(producto).append("\n");
        }

        return sb.toString();
    }

    //método de cartaPostres
    public List<Producto> cartaPostres() {

        List<Producto> cartaPostres = new ArrayList<>();

        //creamos los postres
        Producto p1 = new Postre("Bol de fresitas con nata", 185, 
                TipoPostre.FRUTITA, 2.70, TipoIVA.IVA_DIEZ);
        
        Producto p2 = new Postre("Bol de kiwi con leche y muesli", 97, 
                TipoPostre.FRUTITA, 2.50, TipoIVA.IVA_DIEZ);
        
        Producto p3 = new Postre("Bol de piña con leche de coco y nata", 231, 
                TipoPostre.FRUTITA, 3, TipoIVA.IVA_DIEZ);
        
        Producto p4 = new Postre("Mochi de helado de mango (2 unidades)", 203, 
                TipoPostre.MOCHI, 2.1, TipoIVA.IVA_DIEZ);
        
        Producto p5 = new Postre("Mochi de helado de coco (2 unidades)", 214, 
                TipoPostre.MOCHI, 2, TipoIVA.IVA_DIEZ);
        
        Producto p6 = new Postre("Mochi de helado de oreo (2 unidades)", 278, 
                TipoPostre.MOCHI, 2.5, TipoIVA.IVA_DIEZ);
        
        Producto p7 = new Postre("Helado de pistacho y chocolate con nata", 430, 
                TipoPostre.OTROS, 2.8, TipoIVA.IVA_DIEZ);
        
        Producto p8 = new Postre("Helado de limón y mango", 367, 
                TipoPostre.OTROS, 2.3, TipoIVA.IVA_DIEZ);
        
        Producto p9 = new Postre("Helado de matcha con vainilla", 391, 
                TipoPostre.OTROS, 3.5, TipoIVA.IVA_DIEZ);

        cartaPostres.add(p1);
        cartaPostres.add(p2);
        cartaPostres.add(p3);
        cartaPostres.add(p4);
        cartaPostres.add(p5);
        cartaPostres.add(p6);
        cartaPostres.add(p7);
        cartaPostres.add(p8);
        cartaPostres.add(p9);

        return cartaPostres;
    }
}
