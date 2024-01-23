/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        
        Map<Producto, Integer> mapCantidadProductos = new HashMap<>();

        // Iterar sobre la lista y agregar objetos al mapa
        for (Producto producto : carritoTmp) {
            // Si el producto ya está en el mapa, incrementa la cantidad
            // Si no está, agrega el producto al mapa con una cantidad inicial de 1
            mapCantidadProductos.put(producto, mapCantidadProductos
                    .getOrDefault(producto, 0) + 1);
        }
        
        // Meto en cada lista los productos y las cantidades de estos 
        List<Producto> listaDeProductos = List.copyOf(
                mapCantidadProductos.keySet());
        List<Integer> listaDeCantidades = List.copyOf(
                mapCantidadProductos.values());
        
        if (tarjeta.verificarTarjeta(importeTotal)) {
            
            Ticket ticketCompra = new Ticket(listaDeProductos, 
                    listaDeCantidades);
            
            ticketCompra.imprimirTicket();
            
        } else{
            System.out.println("No tiene saldo suficente en la tarjeta para realizar"
                    + " la compra o la tarjeta no existe");
        }

        carritoTmp.removeAll(carritoTmp);
        
        tpv.setCarrito(carritoTmp);
    }
    
    public TPV encenderTpv() {

        return new TPV();
    }
}
