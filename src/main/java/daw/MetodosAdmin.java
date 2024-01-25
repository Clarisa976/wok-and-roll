/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw;

import java.time.LocalDateTime;
import java.util.ArrayList;
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
    public static void altaProducto(CatalogoCarta catalogoCarta, Producto productoNuevo) {
        
        List<Producto> catalogoCartaTmp = catalogoCarta.getCarta();
        
        catalogoCartaTmp.add(productoNuevo);
        
        catalogoCarta.setCarta(catalogoCartaTmp);       
    }
    
    //método para dar de alta un nuevo producto
    public static void bajaProducto(CatalogoCarta catalogoCarta, Producto productoABorrar) {
        
        List<Producto> catalogoCartaTmp = catalogoCarta.getCarta();
        
        for (Producto producto : catalogoCartaTmp) {
            if (productoABorrar.equals(producto)) {
                catalogoCartaTmp.remove(productoABorrar);
            }
        }
        
        catalogoCarta.setCarta(catalogoCartaTmp);
    }
    
    //consultar todos los tickets del tpv
    public static List<Ticket> consultarTickets(TPV tpv){
        
        return tpv.getListaTickets();
    }
    
    //consultar tickets del tpv segun un dia concreto
    public static List<Ticket> consultarTicketsDia(TPV tpv, int diaDelMes){
        
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
    public static List<Ticket> consultarTicketsFecha(TPV tpv, LocalDateTime fecha){
        
        List<Ticket> listaTickets = tpv.getListaTickets();
        List<Ticket> listaTicketsFecha = new ArrayList<>();
        
        for (Ticket ticket : listaTickets) {
            if (ticket.getFechaEmision().isEqual(fecha)) {
               listaTicketsFecha.add(ticket);
            }
        }

        return listaTicketsFecha;
    }
    
    public static void modoAdministrador (TPV tpv){
        boolean salirAdmin = false;

        //iniciamos el bucle
        do {
            //creamos las opciones del usuario
            String[] opcionesUsuario = {"Modificar producto", "Dar de alta un producto",
                "Borrar producto", "Ver ventas", "Salir"};
            //mensaje de JOptionPane par mostrar dichas opciones
            int opcionUsuario = JOptionPane.showOptionDialog(null,
                    "Seleccione una opción",
                    "Wok and Roll -- DAWFOOD -- Modo Usuario",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.PLAIN_MESSAGE, null,
                    opcionesUsuario, opcionesUsuario[0]);

            //switch con las diferentes opciones dadas
            switch (opcionesUsuario[opcionUsuario]) {
                //con cada opcion llamamos a su método correspondiente
                //si elige salir vuelve al menú de inicio
                case "Modificar producto" -> {
                    
                }
                case "Dar de alta un producto" -> {
                    
                }
                case "Borrar producto" -> {
                    
                }
                case "Ver ventas" -> {
                    
                }
                case "Salir" -> {
                    System.out.println("volver a inicio");
                    return;
                }
            }

        } while (!salirAdmin);
    }
}
