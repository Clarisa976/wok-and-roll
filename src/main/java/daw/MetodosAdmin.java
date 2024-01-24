/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw;

import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author clara
 */
/*
■ Cambiar cualquier dato de los productos, excepto su ID.
■ Dar de alta nuevos productos.
■ Borrar productos existentes.
■ Consultar las ventas realizadas:
● en un día concreto,
● hasta una fecha concreta, y
● todas las ventas que haya registradas.

 */
public class MetodosAdmin {
//
//    //atributos
//    private List<Producto> menuProductos;
//
//    //constructor
//    public MetodosAdmin() {
//        this.menuProductos = menuProductos;
//    }

    //método para cambiar cualquier dato de los productos a excepción de su ID
    public static void modificarProducto(Producto aux) {
        try {
            String nuevoNombre = null;// = JOptionPane.showInputDialog(null, "Ingrese el nuevo nombre del producto:", aux.getNombre());
            //controlamos que no sea nulo
            if (nuevoNombre != null) {
                aux.setNombre(nuevoNombre);
            }
            String nuevoPrecioSinIVAStr = null;
            if (nuevoPrecioSinIVAStr != null) {
                double nuevoPrecioSinIVA = Double.parseDouble(nuevoPrecioSinIVAStr);
                aux.setPrecioSinIVA(nuevoPrecioSinIVA);
            }
            String tipoIVAString = null;// = JOptionPane.showInputDialog(null, "Ingrese el tipo de IVA del producto (21% o 10%):");
            if (tipoIVAString != null) {
                TipoIVA nuevoTipoIVA = tipoIVAString.equals("21%") ? TipoIVA.IVA_VEINTIUNO : TipoIVA.IVA_DIEZ;
                aux.setTipoIVA(nuevoTipoIVA);
            }
            String nuevoStockStr = null;
            if (nuevoStockStr != null) {
                int nuevoStock = Integer.parseInt(nuevoStockStr);
                aux.setStock(nuevoStock);
            }

            //JOptionPane.showMessageDialog(null, "Producto modificado con éxito.");
        } catch (NumberFormatException nfe) {
            // JOptionPane.showMessageDialog(null, "Valores no válidos.");
        }
    }

    //método para dar de alta un nuevo producto
    public void altaProducto(CatalogoCarta catalogoCarta, Producto productoNuevo) {
        
        List<Producto> catalogoCartaTmp = catalogoCarta.getCarta();
        
        catalogoCartaTmp.add(productoNuevo);
        
        catalogoCarta.setCarta(catalogoCartaTmp);       
    }
    
    //método para dar de alta un nuevo producto
    public void bajaProducto(CatalogoCarta catalogoCarta, Producto productoABorrar) {
        
        List<Producto> catalogoCartaTmp = catalogoCarta.getCarta();
        
        for (Producto producto : catalogoCartaTmp) {
            if (productoABorrar.equals(producto)) {
                catalogoCartaTmp.remove(productoABorrar);
            }
        }
        
        catalogoCarta.setCarta(catalogoCartaTmp);
    }
    
    //consultar todos los tickets del tpv
    public List<Ticket> consultarTickets(TPV tpv){
        
        return tpv.getListaTickets();
    }
    
    //consultar tickets del tpv segun un dia concreto
    public List<Ticket> consultarTicketsDia(TPV tpv, int diaDelMes){
        
        List<Ticket> listaTickets = tpv.getListaTickets();
        List<Ticket> listaTicketsDia = new ArrayList<>();
        
        for (Ticket ticket : listaTickets) {
            
            if (ticket.getFechaEmision().getDayOfMonth() == diaDelMes) {
                 listaTicketsDia.add(ticket);
            }
        }

        return listaTicketsDia;
    }
    
    //consultar tickets del tpv segun un dia concreto
    public List<Ticket> consultarTicketsFecha(TPV tpv, LocalDateTime fecha){
        
        List<Ticket> listaTickets = tpv.getListaTickets();
        List<Ticket> listaTicketsFecha = new ArrayList<>();
        
        for (Ticket ticket : listaTickets) {
            if (ticket.getFechaEmision().isEqual(fecha)) {
               listaTicketsFecha.add(ticket);
            }
        }

        return listaTicketsFecha;
    }
}
