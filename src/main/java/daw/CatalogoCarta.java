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
    private List<Producto> carta;
//    public static List<Producto> listaComida = cartaComidas();
//    private List<Producto> listaBebida;
//    private List<Producto> listaPostre;

    //constructor
    public CatalogoCarta() {
        this.carta = cartaMenu();
//        this.listaComida = cartaComidas();
//        this.listaBebida = cartaBebidas();
//        this.listaPostre = cartaPostres();
    }

    //gettes
    public List<Producto> getCarta() {
        return carta;
    }
    
    //setters
    public void setCarta(List<Producto> carta) {
        this.carta = carta;
    }
    
    //toString
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CatalogoCarta{");
//        sb.append("Comidas: ").append(listaComida);
//        sb.append("\nBebidas: ").append(listaBebida);
//        sb.append("\nPostre: ").append(listaPostre);
        sb.append('}');
        return sb.toString();
    }
    
    //base de datos de productos que hay en el menú
    private static List<Producto> cartaMenu(){
        List <Producto> carta = new ArrayList<>();
        //comidas
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

        carta.add(c1);
        carta.add(c2);
        carta.add(c3);
        carta.add(c4);
        carta.add(c5);
        carta.add(c6);
        carta.add(c7);
        carta.add(c8);
        carta.add(c9);
        
        //bebidas
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
                35, TipoBebida.ALCOHOLICAS, 3,
                TipoIVA.IVA_VEINTIUNO, 20);
        Producto b9 = new Bebida("Cerveza Alhambra Roja", 33,
                TipoBebida.ALCOHOLICAS, 2.3,
                TipoIVA.IVA_VEINTIUNO, 20);

        //añadimos los productos a la lista
        carta.add(b1);
        carta.add(b2);
        carta.add(b3);
        carta.add(b4);
        carta.add(b5);
        carta.add(b6);
        carta.add(b7);
        carta.add(b8);
        carta.add(b9);

        //postre
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

        carta.add(p1);
        carta.add(p2);
        carta.add(p3);
        carta.add(p4);
        carta.add(p5);
        carta.add(p6);
        carta.add(p7);
        carta.add(p8);
        carta.add(p9);

        
        return carta;
    }
}
//    //método de cartaComida
//    private static List<Producto> cartaComidas() {
//        List<Producto> cartaComidas = new ArrayList<>();
//        //creamos nueve comidas
//        Producto c1 = new Comida("Ramen de curry",
//                "Delicioso ramen con fideos udon, tonkatsu "
//                + "y sopa de curry ", TipoComida.RAMEN,
//                9.50, TipoIVA.IVA_DIEZ, 20);
//        Producto c2 = new Comida("Ramen de pollo",
//                "Clásico ramen de pollo ", TipoComida.RAMEN,
//                8, TipoIVA.IVA_DIEZ, 20);
//        Producto c3 = new Comida("Ramen de miso",
//                "Ramen de miso sosillo", TipoComida.RAMEN,
//                6, TipoIVA.IVA_DIEZ, 20);
//
//        Producto c4 = new Comida("Nigiri de salmón",
//                "Dos piezas de nigiri de salmón", TipoComida.SUSHI,
//                3, TipoIVA.IVA_DIEZ, 20);
//        Producto c5 = new Comida("Nigiri de atún",
//                "Dos piezas de nigiri de atún rojo de remolacha",
//                TipoComida.SUSHI,
//                2.50, TipoIVA.IVA_DIEZ, 20);
//        Producto c6 = new Comida("Uramame de pollo crujiente",
//                "Rollo de arroz relleno de pollo rebozado con "
//                + "panko y alga nori", TipoComida.SUSHI,
//                2, TipoIVA.IVA_DIEZ, 20);
//
//        Producto c7 = new Comida("Veruras", "Wok de verduritas",
//                TipoComida.WOK, 4, TipoIVA.IVA_DIEZ, 20);
//        Producto c8 = new Comida("Carne", "Wok de carnecita",
//                TipoComida.WOK, 4.50, TipoIVA.IVA_DIEZ, 20);
//        Producto c9 = new Comida("Marisco",
//                "Wok de gambas de Cádiz", TipoComida.WOK,
//                5.50, TipoIVA.IVA_DIEZ, 20);
//
//        cartaComidas.add(c1);
//        cartaComidas.add(c2);
//        cartaComidas.add(c3);
//        cartaComidas.add(c4);
//        cartaComidas.add(c5);
//        cartaComidas.add(c6);
//        cartaComidas.add(c7);
//        cartaComidas.add(c8);
//        cartaComidas.add(c9);
//
//        return cartaComidas;
//    }
//    //método de cartaBebidas
//
//    private List<Producto> cartaBebidas() {
//        List<Producto> cartaBebidas = new ArrayList<>();
//
//        //creamos nueve bebidas
//        Producto b1 = new Bebida("Coca cola Zero", 33,
//                TipoBebida.REFRESCOS, 1.66,
//                TipoIVA.IVA_DIEZ, 20);
//        Producto b2 = new Bebida("Nestea de maracuyá", 45,
//                TipoBebida.REFRESCOS, 2,
//                TipoIVA.IVA_DIEZ, 20);
//        Producto b3 = new Bebida("Fanta de limón", 45,
//                TipoBebida.REFRESCOS, 1.89,
//                TipoIVA.IVA_DIEZ, 20);
//
//        Producto b4 = new Bebida("Colacao", 20,
//                TipoBebida.OTROS, 1,
//                TipoIVA.IVA_DIEZ, 20);
//        Producto b5 = new Bebida("Té rojo", 20,
//                TipoBebida.OTROS, 0.8,
//                TipoIVA.IVA_DIEZ, 20);
//        Producto b6 = new Bebida("Café con leche", 20,
//                TipoBebida.OTROS, 0.9,
//                TipoIVA.IVA_DIEZ, 20);
//
//        Producto b7 = new Bebida("Cerveza Victoria", 33,
//                TipoBebida.ALCOHOLICAS, 1.2,
//                TipoIVA.IVA_VEINTIUNO, 20);
//        Producto b8 = new Bebida("Cerveza Kirin de importación",
//                35, TipoBebida.ALCOHOLICAS, 3,
//                TipoIVA.IVA_VEINTIUNO, 20);
//        Producto b9 = new Bebida("Cerveza Alhambra Roja", 33,
//                TipoBebida.ALCOHOLICAS, 2.3,
//                TipoIVA.IVA_VEINTIUNO, 20);
//
//        //añadimos los productos a la lista
//        cartaBebidas.add(b1);
//        cartaBebidas.add(b2);
//        cartaBebidas.add(b3);
//        cartaBebidas.add(b4);
//        cartaBebidas.add(b5);
//        cartaBebidas.add(b6);
//        cartaBebidas.add(b7);
//        cartaBebidas.add(b8);
//        cartaBebidas.add(b9);
//
//        return cartaBebidas;
//    }
//    //método de cartaPostres
//
//    private List<Producto> cartaPostres() {
//
//        List<Producto> cartaPostres = new ArrayList<>();
//
//        //creamos los postres
//        Producto p1 = new Postre("Bol de fresitas con nata", 185,
//                TipoPostre.FRUTITA, 2.70, TipoIVA.IVA_DIEZ, 20);
//
//        Producto p2 = new Postre("Bol de kiwi con leche y muesli", 97,
//                TipoPostre.FRUTITA, 2.50, TipoIVA.IVA_DIEZ, 20);
//
//        Producto p3 = new Postre("Bol de piña con leche de coco y nata", 231,
//                TipoPostre.FRUTITA, 3, TipoIVA.IVA_DIEZ, 20);
//
//        Producto p4 = new Postre("Mochi de helado de mango (2 unidades)", 203,
//                TipoPostre.MOCHI, 2.1, TipoIVA.IVA_DIEZ, 20);
//
//        Producto p5 = new Postre("Mochi de helado de coco (2 unidades)", 214,
//                TipoPostre.MOCHI, 2, TipoIVA.IVA_DIEZ, 20);
//
//        Producto p6 = new Postre("Mochi de helado de oreo (2 unidades)", 278,
//                TipoPostre.MOCHI, 2.5, TipoIVA.IVA_DIEZ, 20);
//
//        Producto p7 = new Postre("Helado de pistacho y chocolate con nata", 430,
//                TipoPostre.OTROS, 2.8, TipoIVA.IVA_DIEZ, 20);
//
//        Producto p8 = new Postre("Helado de limón y mango", 367,
//                TipoPostre.OTROS, 2.3, TipoIVA.IVA_DIEZ, 20);
//
//        Producto p9 = new Postre("Helado de matcha con vainilla", 391,
//                TipoPostre.OTROS, 3.5, TipoIVA.IVA_DIEZ, 20);
//
//        cartaPostres.add(p1);
//        cartaPostres.add(p2);
//        cartaPostres.add(p3);
//        cartaPostres.add(p4);
//        cartaPostres.add(p5);
//        cartaPostres.add(p6);
//        cartaPostres.add(p7);
//        cartaPostres.add(p8);
//        cartaPostres.add(p9);
//
//        return cartaPostres;
//    }
//}
