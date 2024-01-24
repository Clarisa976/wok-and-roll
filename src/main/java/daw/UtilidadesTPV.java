/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;

/**
 *
 * @author miguel
 */
public class UtilidadesTPV {

    public static void agregarAlCarrito(TPV tpv, Producto producto) {

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

    public void cancelarCompra(TPV tpv) {

        List<Producto> carritoTmp = tpv.getCarrito();

        carritoTmp.removeAll(carritoTmp);

        tpv.setCarrito(carritoTmp);
    }

    public void finalizarCompra(TPV tpv, Tarjeta tarjeta) {

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

        } else {
            System.out.println("No tiene saldo suficente en la tarjeta para realizar"
                    + " la compra o la tarjeta no existe");
        }

        carritoTmp.removeAll(carritoTmp);

        tpv.setCarrito(carritoTmp);
    }

    //método para encender el tpv
    public static void encenderTPV() {
        //generamos y mostrabmos la contraseña del administrador
        System.out.println("Contraseña: " + TPV.generarPass());

        //booleano para el bucle
        boolean salirTPV = false;
        //bucle para poder elegir entre usuario o administrador hasta que le den a salir
        do {
            //las opciones a mostrar
            String[] opcionesInicioTPV = {"Usuario", "Administrador", "Salir"};

            //mensaje de JOption para seleccionar una de las opciones
            int opcionInicioTPV = JOptionPane.showOptionDialog(null,
                    "Bienvenido \nPor favor seleccione una opción", "TPV",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.PLAIN_MESSAGE, null,
                    opcionesInicioTPV, opcionesInicioTPV[0]);

            //switch con las diferentes opciones dadas
            switch (opcionesInicioTPV[opcionInicioTPV]) {
                //si elige la opción usuario se llamará al método usuario para mostrar sus opciones
                case "Usuario":
                    System.out.println("Modo usuario");
                    modoUsuario();
                    break;
                //si elige la opción administrador se mostrará el método que contiene las opciones de administrador    
                case "Administrador":
                    System.out.println("Modo admin");
                    break;
                //si elige salir se apagará el programa
                case "Salir":
                    System.out.println("Apagar TPV");
                    return;
            }

        } while (!salirTPV);
    }

    //método para las opciones del usuario
    private static void modoUsuario() {
        boolean salirUsuario = false;

        //iniciamos el bucle
        do {
            //creamos las opciones del usuario
            String[] opcionesUsuario = {"Ver comidas", "Ver bebidas",
                "Ver postres", "Ver carrito", "Salir"};
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
                case "Ver comidas":
                    verCategorias("Comidas");
                    System.out.println("comidas");
                    break;
                case "Ver bebidas":
                    System.out.println("bebidas");
                    break;
                case "Ver postres":
                    System.out.println("postre");
                    break;
                case "Ver carrito":
                    System.out.println("carrito");
                    break;
                //si elige salir vuelve al menú de inicio
                case "Salir":
                    System.out.println("volver a inicio");
                    return;
            }

        } while (!salirUsuario);
    }

    /*método del usuario para ver las clases hijas de la clase Producto
    pasandole un String con el tipo de categoría, que optenemos en el switch del 
    modoUsuario.*/
    private static void verCategorias(String nombreCategoria) {
        //atributo boolean para el bucle
        boolean salirCategorias = false;

        //iniciamos el bucle 
        do {
            //opciones a mostrar: ver todo, ver los subtipos para elegir, volver
            String[] opcionesCategorias = {"Ver todo", "Ver subcategorias", "Volver"};
            //mensaje de JOptionPane par mostrar dichas opciones
            int opcionCategorias = JOptionPane.showOptionDialog(null,
                    "Seleccione una opción",
                    "Wok and Roll -- DAWFOOD -- Modo Usuario",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.PLAIN_MESSAGE, null,
                    opcionesCategorias, opcionesCategorias[0]);

            //switch con las diferentes opciones dadas
            switch (opcionesCategorias[opcionCategorias]) {
                //con cada opcion llamamos a su método correspondiente 
                case "Ver todo":
                    if (nombreCategoria.equalsIgnoreCase("comidas")) {
                        List<Producto> listaComida = CatalogoCarta.comidasBD();
                        String[] opcionesProductos = new String[listaComida.size()];

                        for (int i = 0; i < listaComida.size(); i++) {
                            Producto producto = listaComida.get(i);
                            opcionesProductos[i] = producto.getNombre() + " - Precio: " + producto.getPrecioConIVA() + "€";
                        }

                        String seleccionProducto = (String) JOptionPane.showInputDialog(null,
                                "Selecciona un producto",
                                "Elegir producto",
                                JOptionPane.QUESTION_MESSAGE,
                                null,
                                opcionesProductos,
                                opcionesProductos[0]);
                        if (seleccionProducto != null) {
                            // El usuario seleccionó un producto
                            int opcionElegida = JOptionPane.showOptionDialog(null,
                                    "¿Qué deseas hacer con este producto?",
                                    "Opciones",
                                    JOptionPane.YES_NO_OPTION,
                                    JOptionPane.QUESTION_MESSAGE,
                                    null,
                                    new String[]{"Añadir al carrito", "Volver"},
                                    "Añadir al carrito");

                            if (opcionElegida == 0) {
                                // El usuario eligió "Añadir al carrito"
                                // Aquí puedes agregar la lógica para añadir el producto al carrito
                            } else if (opcionElegida == 1) {
                                // El usuario eligió "Volver"
                                // Aquí puedes agregar la lógica para volver al menú anterior
                            }
                        }
                    

//                    List<Producto> listaCompleta = filtarProducto(nombreCategoria);
                    System.out.println("toda la lista");
                    break;
            }

          case "Ver subcategoria":
                    System.out.println("enums");
                    break;
                //si elige salir vuelve al menú de anterior
                case "Volver":
                    System.out.println("volver a categorías");
                    return;
            }

        
    }
    while (!salirCategorias

);

        }

    }
