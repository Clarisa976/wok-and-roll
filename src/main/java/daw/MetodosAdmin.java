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

    //atributos
    private List<Producto> menuProductos;

    //constructor
    public MetodosAdmin() {
        this.menuProductos = menuProductos;
    }

    //método para cambiar cualquier dato de los productos a excepción de su ID
    public void modificarProducto(Producto aux) {
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
    public void altaProducto() {
        try {
//            String nuevoNombre = null;// = JOptionPane.showInputDialog(null, "Ingrese el nuevo nombre del producto:", aux.getNombre());
//            if (nuevoNombre != null) {
//                String precioSinIVAStr = null;
//                if (precioSinIVAStr != null) {
//                    double precioSinIVA = Double.parseDouble(precioSinIVAStr);
//                    String stockStr = null;
//                    if (stockStr != null) {
//                        int stock = Integer.parseInt(stockStr);
//                        String tipoIVAString = null;
//                        if (tipoIVAString != null) {
//                            TipoIVA tipoIVA = tipoIVAString.equals("21%") ? TipoIVA.IVA_VEINTIUNO : TipoIVA.IVA_DIEZ;
//                            //creamos un nuevo producto
//                            Producto aux = new Producto(nuevoNombre,
//                                    precioSinIVA, tipoIVA,
//                                    stock);
//                            //lo añadimos
//                            CatalogoCarta.listaComida.add(aux);
//                            
//                        }
//                    }
//                }
//            }

        } catch (NumberFormatException nfe) {

        }
    }
}
