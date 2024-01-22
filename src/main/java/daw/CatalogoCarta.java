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
public class CatalogoCarta {
    //atributos
    private List<Producto> listaComida;
    private List<Producto> listaBebida;
    private List<Producto> listaPostre;
    
    //constructor
    public CatalogoCarta() {
        this.listaComida = cartaComidas();
        this.listaBebida = cartaBebidas();
        this.listaPostre = cartaPostres();
    }
    //gettes
    public List<Producto> getListaComida() {
        return listaComida;
    }

    public List<Producto> getListaBebida() {
        return listaBebida;
    }

    public List<Producto> getListaPostre() {
        return listaPostre;
    }
    //setters
    public void setListaComida(List<Producto> listaComida) {
        this.listaComida = listaComida;
    }

    public void setListaBebida(List<Producto> listaBebida) {
        this.listaBebida = listaBebida;
    }

    public void setListaPostre(List<Producto> listaPostre) {
        this.listaPostre = listaPostre;
    }
    //toString
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CatalogoCarta{");
        sb.append("Comidas: ").append(listaComida);
        sb.append("\nBebidas: ").append(listaBebida);
        sb.append("\nPostre: ").append(listaPostre);
        sb.append('}');
        return sb.toString();
    }
    //método de cartaComida
    private List<Producto> cartaComidas() {
        List<Producto> cartaComidas = new ArrayList<>();
        //creamos nueve comidas
        Producto c1 = new Comida("Ramen de curry",
                "Delicioso ramen con fideos udon, tonkatsu "
                + "y sopa de curry ", TipoComida.RAMEN,
                9.50, TipoIVA.IVA_DIEZ, 20);
        Producto c2 = new Comida("Ramen de pollo",
                "Clásico ramen de pollo ", TipoComida.RAMEN,
                8, TipoIVA.IVA_DIEZ, 20);
        Producto c3 = new Comida("Ramen de miso",
                "Ramen de miso sosillo", TipoComida.RAMEN,
                6, TipoIVA.IVA_DIEZ, 20);

        Producto c4 = new Comida("Nigiri de salmón",
                "Dos piezas de nigiri de salmón", TipoComida.SUSHI,
                3, TipoIVA.IVA_DIEZ, 20);
        Producto c5 = new Comida("Nigiri de atún",
                "Dos piezas de nigiri de atún rojo de remolacha",
                TipoComida.SUSHI,
                2.50, TipoIVA.IVA_DIEZ, 20);
        Producto c6 = new Comida("Uramame de pollo crujiente",
                "Rollo de arroz relleno de pollo rebozado con "
                + "panko y alga nori", TipoComida.SUSHI,
                2, TipoIVA.IVA_DIEZ, 20);

        Producto c7 = new Comida("Veruras", "Wok de verduritas",
                TipoComida.WOK, 4, TipoIVA.IVA_DIEZ, 20);
        Producto c8 = new Comida("Carne", "Wok de carnecita",
                TipoComida.WOK, 4.50, TipoIVA.IVA_DIEZ, 20);
        Producto c9 = new Comida("Marisco",
                "Wok de gambas de Cádiz", TipoComida.WOK,
                5.50, TipoIVA.IVA_DIEZ, 20);

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
     //método de cartaBebidas
    private List<Producto> cartaBebidas(){
        List<Producto> cartaBebidas = new ArrayList<>();
        
        //creamos nueve bebidas
        Producto b1 = new Bebida("Coca cola Zero", 33, 
                TipoBebida.REFRESCOS, 1.66, 
                TipoIVA.IVA_DIEZ, 20);
        Producto b2 = new Bebida("Nestea de maracuyá", 45, 
                TipoBebida.REFRESCOS, 2, 
                TipoIVA.IVA_DIEZ, 20);
        Producto b3 = new Bebida("Fanta de limón", 45, 
                TipoBebida.REFRESCOS, 1.89, 
                TipoIVA.IVA_DIEZ, 20);
        
        Producto b4 = new Bebida("Colacao", 20, 
                TipoBebida.OTROS, 1, 
                TipoIVA.IVA_DIEZ, 20);
        Producto b5 = new Bebida("Té rojo", 20, 
                TipoBebida.OTROS, 0.8, 
                TipoIVA.IVA_DIEZ, 20);
        Producto b6 = new Bebida("Café con leche", 20, 
                TipoBebida.OTROS, 0.9, 
                TipoIVA.IVA_DIEZ, 20);
        
        Producto b7 = new Bebida("Cerveza Victoria", 33, 
                TipoBebida.ALCOHOLICAS, 1.2, 
                TipoIVA.IVA_VEINTIUNO, 20);
        Producto b8 = new Bebida("Cerveza Kirin de importación", 
                35, TipoBebida.ALCOHOLICAS,3, 
                TipoIVA.IVA_VEINTIUNO, 20);
        Producto b9 = new Bebida("Cerveza Alhambra Roja", 33, 
                TipoBebida.ALCOHOLICAS, 2.3, 
                TipoIVA.IVA_VEINTIUNO, 20);
        
        //añadimos los productos a la lista
        cartaBebidas.add(b1);
        cartaBebidas.add(b2);
        cartaBebidas.add(b3);
        cartaBebidas.add(b4);
        cartaBebidas.add(b5);
        cartaBebidas.add(b6);
        cartaBebidas.add(b7);
        cartaBebidas.add(b8);
        cartaBebidas.add(b9);
        
        return cartaBebidas;
    }
     //método de cartaPostres
    private List<Producto> cartaPostres() {

        List<Producto> cartaPostres = new ArrayList<>();

        //creamos los postres
        Producto p1 = new Postre("Bol de fresitas con nata", 185, 
                TipoPostre.FRUTITA, 2.70, TipoIVA.IVA_DIEZ, 20);
        
        Producto p2 = new Postre("Bol de kiwi con leche y muesli", 97, 
                TipoPostre.FRUTITA, 2.50, TipoIVA.IVA_DIEZ, 20);
        
        Producto p3 = new Postre("Bol de piña con leche de coco y nata", 231, 
                TipoPostre.FRUTITA, 3, TipoIVA.IVA_DIEZ, 20);
        
        Producto p4 = new Postre("Mochi de helado de mango (2 unidades)", 203, 
                TipoPostre.MOCHI, 2.1, TipoIVA.IVA_DIEZ, 20);
        
        Producto p5 = new Postre("Mochi de helado de coco (2 unidades)", 214, 
                TipoPostre.MOCHI, 2, TipoIVA.IVA_DIEZ, 20);
        
        Producto p6 = new Postre("Mochi de helado de oreo (2 unidades)", 278, 
                TipoPostre.MOCHI, 2.5, TipoIVA.IVA_DIEZ, 20);
        
        Producto p7 = new Postre("Helado de pistacho y chocolate con nata", 430, 
                TipoPostre.OTROS, 2.8, TipoIVA.IVA_DIEZ, 20);
        
        Producto p8 = new Postre("Helado de limón y mango", 367, 
                TipoPostre.OTROS, 2.3, TipoIVA.IVA_DIEZ, 20);
        
        Producto p9 = new Postre("Helado de matcha con vainilla", 391, 
                TipoPostre.OTROS, 3.5, TipoIVA.IVA_DIEZ, 20);

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
