/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package daw;

import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author clara
 */
public class Prueba {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //creamos un TPV
        TPV tpv1 = new TPV();
        List<Producto> a = CatalogoCarta.cartaMenu();
        //lo encendemos
        UtilidadesTPV.encenderTPV();
//        List<Producto> catalogo = CatalogoCarta.cartaMenu();
//        Producto seleccionProducto = (Producto)JOptionPane.showInputDialog(null,
//                "Selecciona un producto",
//                "Elegir producto",
//                JOptionPane.QUESTION_MESSAGE,
//                null,
//                catalogo.toArray(),
//                catalogo.get(0));
//        if (seleccionProducto != null) {
//            Object[] botones = {"Ver precio", "Añadir al carrito"};
//            int seleccionAccion = JOptionPane.showOptionDialog(null,
//                    "Selecciona una acción para " + seleccionProducto.getNombre() + ":",
//                    "Acciones",
//                    JOptionPane.DEFAULT_OPTION,
//                    JOptionPane.QUESTION_MESSAGE,
//                    null,
//                    botones,
//                    botones[0]);
//
//            if (seleccionAccion == 0) {
//                // Lógica para "Ver precio"
//                System.out.println("aaaaaaaa");
//            } else if (seleccionAccion == 1) {
//                // Lógica para "Añadir al carrito"
//                UtilidadesTPV.agregarAlCarrito(tpv, seleccionProducto);
//            }
//        }
//    }
        
//        String[] opcionUsuario = {"Usuario", "Administrador"};
//        //muestra el cuadro de diálogo con el desplegable de opciones
//        String seleccionUsuario = (String) JOptionPane.showInputDialog(
//                null,
//                "Selecciona una opción:",
//                "Desplegable",
//                JOptionPane.PLAIN_MESSAGE,
//                null,
//                opcionUsuario,
//                opcionUsuario[0] // Opción preseleccionada
//        );
//
//        //verifica si el usuario seleccionó una opción y muestra un mensaje
//        if (seleccionUsuario != null) {
//            JOptionPane.showMessageDialog(null,
//                    "Bienvenido " + seleccionUsuario,
//                    "Selección",
//                    JOptionPane.INFORMATION_MESSAGE
//            );
//        } else {
//            JOptionPane.showMessageDialog(
//                    null,
//                    "No seleccionaste ninguna opción.",
//                    "Cancelado",
//                    JOptionPane.WARNING_MESSAGE
//            );
//        }
//                
//        if (seleccionUsuario.equalsIgnoreCase("usuario")) {
//            System.out.println("cosas de usuario");
//        
//        
//        
//        } else if (seleccionUsuario.equalsIgnoreCase("administrador")) {
//            System.out.println("cosas de admin");
//            String[] opcionesAdministrador = {"Modificar producto",
//                "Dar de alta un nuevo producto", "Borrar un producto",
//                 "Consultar ventas"};
//            //muestra el cuadro de diálogo con el desplegable de opciones
//            String seleccionOpcionesAdmin = (String) JOptionPane.showInputDialog(
//                    null,
//                    "Selecciona una opción:",
//                    "Desplegable",
//                    JOptionPane.PLAIN_MESSAGE,
//                    null,
//                    opcionesAdministrador,
//                    opcionesAdministrador[0] // Opción preseleccionada
//            );
//            if(seleccionOpcionesAdmin.equalsIgnoreCase("Modificar producto")){
//                //mostramos la lista de productos
//                CatalogoCarta.cartaMenu().toString();
////                MetodosAdmin.modificarProducto(aux);
//            }
//        }

    }
}


