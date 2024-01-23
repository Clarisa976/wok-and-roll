/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package daw;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author clara
 */
public class DawFoodClaraMiguel {

    public static void main(String[] args) {
        /*
                    Wok and Roll
        Proyecto de un TPV enfocado en un restaurante de comida asiática
            
         */

        CatalogoCarta c1 = new CatalogoCarta();

        c1.toString();

        System.out.println(c1);
        System.out.println(c1.getCarta());
        List<Producto> productos = new ArrayList<>();

        Producto co1 = new Comida("Ramen de curry",
                "Delicioso ramen con fideos udon, tonkatsu "
                + "y sopa de curry ", TipoComida.RAMEN,
                9.50, TipoIVA.IVA_DIEZ, 20);
        Producto c2 = new Comida("Ramen de pollo",
                "Clásico ramen de pollo ", TipoComida.RAMEN,
                8, TipoIVA.IVA_DIEZ, 20);
        Producto c3 = new Comida("Ramen de miso",
                "Ramen de miso sosillo", TipoComida.RAMEN,
                6, TipoIVA.IVA_DIEZ, 20);
        productos.add(c2);
        /* productos.add(co1);
        productos.add(c2);*/
        List<Integer> cantidad = new ArrayList<>();
        cantidad.add(2);
        /* cantidad.add(6);
        cantidad.add(2);*/
        Ticket t1 = new Ticket(productos, cantidad);
        Ticket t2 = new Ticket(productos, cantidad);        
        Ticket t3 = new Ticket(productos, cantidad);
        t1.imprimirTicket();
        System.out.println(t1);
        t2.imprimirTicket();
        System.out.println(t2);
        t3.imprimirTicket();
        System.out.println(t3);
        
    }
}
