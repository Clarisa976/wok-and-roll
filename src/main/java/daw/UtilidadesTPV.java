/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw;

import java.util.List;

/**
 *
 * @author miguel
 */
public class UtilidadesTPV {

    public void agregarAlCarrito(TPV tpv, Producto producto) {

        List<Producto> carritoTmp = tpv.getCarrito();

        if (producto.getStock() > 1) {

            carritoTmp.add(producto);

            tpv.setCarrito(carritoTmp);

        } else {

            System.out.println("No queda Stock del artículo seleccionado.");
        }

    }

    public void quitarDelCarrito(TPV tpv, Producto producto) {

        List<Producto> carritoTmp = tpv.getCarrito();

        if (carritoTmp.contains(producto)) {

            carritoTmp.remove(producto);

            tpv.setCarrito(carritoTmp);
        } else {

            System.out.println("No se puede quitar del carrito un producto "
                    + "que no está");
        }
    }

    public void cancelarCompra(TPV tpv){
    
        List<Producto> carritoTmp = tpv.getCarrito();
        
        carritoTmp.removeAll(carritoTmp);
        
        tpv.setCarrito(carritoTmp);
    }
    
    public void finalizarCompra(TPV tpv, Tarjeta tarjeta){
    
        List<Producto> carritoTmp = tpv.getCarrito();
        
        /*calculo el importe total*/
        double importeTotal = 0; 
        
        for (Producto producto : carritoTmp) {
            
            importeTotal += producto.getPrecioConIVA();
        }
        /*------------------------*/
        
        if (tarjeta.verificarTarjeta(importeTotal)) {
            
            //Ticket ticketCompra = new Ticket(carritoTmp, cantidad);
        }
        
        carritoTmp.removeAll(carritoTmp);
        
        tpv.setCarrito(carritoTmp);
    }
    
    public TPV encenderTpv() {

        return new TPV();
    }
}
