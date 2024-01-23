/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package daw;

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

        String[] opcionUsuario = {"Usuario", "Administrador"};
        //muestra el cuadro de diálogo con el desplegable de opciones
        String seleccionUsuario = (String) JOptionPane.showInputDialog(
                null,
                "Selecciona una opción:",
                "Desplegable",
                JOptionPane.PLAIN_MESSAGE,
                null,
                opcionUsuario,
                opcionUsuario[0] // Opción preseleccionada
        );

        //verifica si el usuario seleccionó una opción y muestra un mensaje
        if (seleccionUsuario != null) {
            JOptionPane.showMessageDialog(null,
                    "Bienvenido " + seleccionUsuario,
                    "Selección",
                    JOptionPane.INFORMATION_MESSAGE
            );
        } else {
            JOptionPane.showMessageDialog(
                    null,
                    "No seleccionaste ninguna opción.",
                    "Cancelado",
                    JOptionPane.WARNING_MESSAGE
            );
        }
                
        if (seleccionUsuario.equalsIgnoreCase("usuario")) {
            System.out.println("cosas de usuario");
        
        
        
        } else if (seleccionUsuario.equalsIgnoreCase("administrador")) {
            System.out.println("cosas de admin");
            String[] opcionesAdministrador = {"Modificar producto",
                "Dar de alta un nuevo producto", "Borrar un producto",
                 "Consultar ventas"};
            //muestra el cuadro de diálogo con el desplegable de opciones
            String seleccionOpcionesAdmin = (String) JOptionPane.showInputDialog(
                    null,
                    "Selecciona una opción:",
                    "Desplegable",
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    opcionesAdministrador,
                    opcionesAdministrador[0] // Opción preseleccionada
            );
            if(seleccionOpcionesAdmin.equalsIgnoreCase("Modificar producto")){
                //mostramos la lista de productos
                CatalogoCarta.cartaMenu().toString();
//                MetodosAdmin.modificarProducto(aux);
            }
        }

    }

}
