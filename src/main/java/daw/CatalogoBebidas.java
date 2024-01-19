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
public final class CatalogoBebidas {

    //lista de bebidas
    private final List<Producto> listaBebidas;

    //constructor
    public CatalogoBebidas() {
        this.listaBebidas = cartaBebidas();
    }

    //getter
    public List<Producto> getListaBebidas() {
        return listaBebidas;
    }

    //toString
    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();

        for (Producto producto : listaBebidas) {
            sb.append(producto).append("\n");
        }

        return sb.toString();
    }
    
    //método de cartaBebidas
    public List<Producto> cartaBebidas(){
        List<Producto> cartaBebidas = new ArrayList<>();
        
        //creamos nueve bebidas
        Producto b1 = new Bebida("Coca cola Zero", 33, 
                TipoBebida.REFRESCOS, 1.66, 
                TipoIVA.IVA_DIEZ);
        Producto b2 = new Bebida("Nestea de maracuyá", 45, 
                TipoBebida.REFRESCOS, 2, 
                TipoIVA.IVA_DIEZ);
        Producto b3 = new Bebida("Fanta de limón", 45, 
                TipoBebida.REFRESCOS, 1.89, 
                TipoIVA.IVA_DIEZ);
        
        Producto b4 = new Bebida("Colacao", 20, 
                TipoBebida.OTROS, 1, 
                TipoIVA.IVA_DIEZ);
        Producto b5 = new Bebida("Té rojo", 20, 
                TipoBebida.OTROS, 0.8, 
                TipoIVA.IVA_DIEZ);
        Producto b6 = new Bebida("Café con leche", 20, 
                TipoBebida.OTROS, 0.9, 
                TipoIVA.IVA_DIEZ);
        
        Producto b7 = new Bebida("Cerveza Victoria", 33, 
                TipoBebida.ALCOHOLICAS, 1.2, 
                TipoIVA.IVA_VEINTIUNO);
        Producto b8 = new Bebida("Cerveza Kirin de importación", 
                35, TipoBebida.ALCOHOLICAS,3, 
                TipoIVA.IVA_VEINTIUNO);
        Producto b9 = new Bebida("Cerveza Alhambra Roja", 33, 
                TipoBebida.ALCOHOLICAS, 2.3, 
                TipoIVA.IVA_VEINTIUNO);
        
        return cartaBebidas;
    }
}
