/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.print.attribute.standard.DateTimeAtCompleted;
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

    public static void cancelarCompra(TPV tpv) {

        List<Producto> carritoTmp = tpv.getCarrito();

        carritoTmp.removeAll(carritoTmp);

        tpv.setCarrito(carritoTmp);
    }

    public static void finalizarCompra(TPV tpv, Tarjeta tarjeta) {

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

        TPV tpv = new TPV();

        //generamos y mostrabmos la contraseña del administrador
        System.out.println("Contraseña: " + tpv.getPassAdministrador());

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
                    modoUsuario(tpv);
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
    private static void modoUsuario(TPV tpv) {
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
                //si elige salir vuelve al menú de inicio
                case "Ver comidas" -> {
                    verCategorias("comidas", tpv);
                    System.out.println("comidas");
                }
                case "Ver bebidas" -> {
                    verCategorias("bebidas", tpv);
                    System.out.println("bebidas");
                }
                case "Ver postres" -> {
                    verCategorias("postres", tpv);
                    System.out.println("postre");
                }
                case "Ver carrito" -> {
                    verCarrito(tpv);
                    System.out.println("carrito");
                }
                case "Salir" -> {
                    System.out.println("volver a inicio");
                    return;
                }
            }

        } while (!salirUsuario);
    }

    /*método del usuario para ver las clases hijas de la clase Producto
    pasandole un String con el tipo de categoría, que optenemos en el switch del 
    modoUsuario.*/
    private static void verCarrito(TPV tpv) {

        //Producto productotmp = new Producto("lo que sea", 3, TipoIVA.IVA_DIEZ, 2);
        //agregarAlCarrito(tpv, productotmp);
        List<Producto> listaCarrito = tpv.getCarrito();

        if (!listaCarrito.isEmpty()) {
            String[] opcionesProductos = new String[listaCarrito.size()];

            for (int i = 0; i < listaCarrito.size(); i++) {
                Producto producto = listaCarrito.get(i);
                opcionesProductos[i] = producto.getNombre() + " - Precio: " + producto.getPrecioConIVA() + "€";
            }

            String seleccionProducto = (String) JOptionPane.showInputDialog(null,
                    "Este es tu carrito actualmente:",
                    "Elegir producto",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    opcionesProductos,
                    opcionesProductos[0]);
            if (seleccionProducto != null) {
                // El usuario seleccionó un producto
                //opciones a mostrar: ver todo, ver los subtipos para elegir, volver
                String[] opcionesElegidas = {"Pagar","Cancelar compra", "Volver"};
                int opcionElegida = JOptionPane.showOptionDialog(null,
                        "¿Qué deseas hacer con este producto?",
                        "Wok and Roll -- DAWFOOD --",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        opcionesElegidas,
                        opcionesElegidas[0]);
                switch (opcionesElegidas[opcionElegida]) {
                    case "Pagar":
                        Tarjeta aux = pedirTarjeta();
                        UtilidadesTPV.finalizarCompra(tpv, aux);
                        System.out.println("Pagando");
                        break;
                        case "Cancelar compra":
                        UtilidadesTPV.cancelarCompra(tpv);
                        break;
                        case "Volver":
                            System.out.println("Volver");
                        return;
                    
                }
//                if (opcionElegida != 1) {
//
//                    System.out.println("pagando");
//                } else if (opcionElegida != 0) {
//                    System.out.println("volver");
//                    return;
//                }else{
//                    
//                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "El carrito esta vacío...");;
            modoUsuario(tpv);
        }

    }

    private static void verCategorias(String nombreCategoria, TPV tpv) {
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
                        mostrarProd(listaComida, opcionesProductos);
//                        for (int i = 0; i < listaComida.size(); i++) {
//                            Producto producto = listaComida.get(i);
//                            opcionesProductos[i] = producto.getNombre()
//                                    + " - Precio: " + producto.getPrecioConIVA()
//                                    + "€";
//                        }

                        String seleccionProducto = (String) JOptionPane.showInputDialog(null,
                                "Selecciona un producto",
                                "Wok and Roll -- DAWFOOD --",
                                JOptionPane.QUESTION_MESSAGE,
                                null,
                                opcionesProductos,
                                opcionesProductos[0]);

                        if (seleccionProducto != null) {
                            // El usuario seleccionó un producto
                            //opciones a mostrar: ver todo, ver los subtipos para elegir, volver
                            String[] opcionesElegidas = {"Agregar al carrito", "Volver"};
                            int opcionElegida = JOptionPane.showOptionDialog(null,
                                    "¿Qué deseas hacer con este producto?",
                                    "Wok and Roll -- DAWFOOD --",
                                    JOptionPane.YES_NO_OPTION,
                                    JOptionPane.QUESTION_MESSAGE,
                                    null,
                                    opcionesElegidas,
                                    opcionesElegidas[0]);

                            if (opcionElegida != 1) {
                                /*creamos un producto auxiliar para poder 
                                añadir el producto seleccionado al carrito*/
                                Producto productoSeleccionado = listaComida.get(Arrays.asList(opcionesProductos).indexOf(seleccionProducto));
                                UtilidadesTPV.agregarAlCarrito(tpv, productoSeleccionado);
                                System.out.println("producto añadido");
                            } else if (opcionElegida != 0) {
                                System.out.println("volver");
                                return;
                            }
                        }

                        System.out.println("toda la lista");
                        break;
                    } else if (nombreCategoria.equalsIgnoreCase("bebidas")) {

                        List<Producto> listaBebida = CatalogoCarta.bebidasBD();
                        String[] opcionesProductos = new String[listaBebida.size()];

                        mostrarProd(listaBebida, opcionesProductos);
//                        for (int i = 0; i < listaBebida.size(); i++) {
//                            Producto producto = listaBebida.get(i);
//                            opcionesProductos[i] = producto.getNombre() + " - Precio: "
//                                    + producto.getPrecioConIVA() + "€";
//                        }

                        String seleccionProducto = (String) JOptionPane.showInputDialog(null,
                                "Selecciona un producto",
                                "Wok and Roll -- DAWFOOD --",
                                JOptionPane.QUESTION_MESSAGE,
                                null,
                                opcionesProductos,
                                opcionesProductos[0]);

                        if (seleccionProducto != null) {
                            // El usuario seleccionó un producto
                            //opciones a mostrar: ver todo, ver los subtipos para elegir, volver
                            String[] opcionesElegidas = {"Agregar al carrito", "Volver"};
                            int opcionElegida = JOptionPane.showOptionDialog(null,
                                    "¿Qué deseas hacer con este producto?",
                                    "Wok and Roll -- DAWFOOD --",
                                    JOptionPane.YES_NO_OPTION,
                                    JOptionPane.QUESTION_MESSAGE,
                                    null,
                                    opcionesElegidas,
                                    opcionesElegidas[0]);

                            if (opcionElegida != 1) {
                                /*creamos un producto auxiliar para poder 
                                añadir el producto seleccionado al carrito*/
                                Producto productoSeleccionado = listaBebida.get(Arrays.asList(opcionesProductos).indexOf(seleccionProducto));
                                UtilidadesTPV.agregarAlCarrito(tpv, productoSeleccionado);
                                System.out.println("producto añadido");
                            } else if (opcionElegida != 0) {
                                System.out.println("volver");
                                return;
                            }

                        }
                    } else if (nombreCategoria.equalsIgnoreCase("postres")) {

                        List<Producto> listaPostre = CatalogoCarta.postresBD();
                        String[] opcionesProductos = new String[listaPostre.size()];
                        mostrarProd(listaPostre, opcionesProductos);
//                        for (int i = 0; i < listaPostre.size(); i++) {
//                            Producto producto = listaPostre.get(i);
//                            opcionesProductos[i] = producto.getNombre() + " - Precio: "
//                                    + producto.getPrecioConIVA() + "€";
//                        }

                        String seleccionProducto = (String) JOptionPane.showInputDialog(null,
                                "Selecciona un producto",
                                "Wok and Roll -- DAWFOOD --",
                                JOptionPane.QUESTION_MESSAGE,
                                null,
                                opcionesProductos,
                                opcionesProductos[0]);

                        if (seleccionProducto != null) {
                            // El usuario seleccionó un producto
                            //opciones a mostrar: ver todo, ver los subtipos para elegir, volver
                            String[] opcionesElegidas = {"Agregar al carrito", "Volver"};
                            int opcionElegida = JOptionPane.showOptionDialog(null,
                                    "¿Qué deseas hacer con este producto?",
                                    "Wok and Roll -- DAWFOOD --",
                                    JOptionPane.YES_NO_OPTION,
                                    JOptionPane.QUESTION_MESSAGE,
                                    null,
                                    opcionesElegidas,
                                    opcionesElegidas[0]);

                            if (opcionElegida != 1) {
                                /*creamos un producto auxiliar para poder 
                                añadir el producto seleccionado al carrito*/
                                Producto productoSeleccionado = listaPostre.get(Arrays.asList(opcionesProductos).indexOf(seleccionProducto));
                                UtilidadesTPV.agregarAlCarrito(tpv, productoSeleccionado);
                                System.out.println("producto añadido");
                            } else if (opcionElegida != 0) {
                                System.out.println("volver");
                                return;
                            }
                        }
                    }
                    System.out.println("toda la lista");
                    break;
                case "Ver subcategoria":

                    System.out.println("enums");
                    break;
                //si elige salir vuelve al menú de anterior
                case "Volver":
                    System.out.println("volver a categorías");
                    return;
            }

        } while (!salirCategorias);
    }

    private static void mostrarProd(List<Producto> aux, String[] opciones) {
        for (int i = 0; i < aux.size(); i++) {
            Producto producto = aux.get(i);
            opciones[i] = producto.getNombre() + " - Precio: "
                    + producto.getPrecioConIVA() + "€";
        }
    }
    
    private static Tarjeta pedirTarjeta(){
        Tarjeta aux;
        String mensajeNumero = JOptionPane.showInputDialog("Introduce los cuatro últimos dígitos de tu tarjeta.");
        String numeroTarjeta = pedirEnteroString(mensajeNumero);
        String mensajeCVV = JOptionPane.showInputDialog("Introduce el CVV de tu tarjeta.");
        String CVVTarjeta = pedirEnteroString(mensajeCVV);
        
        String diaNumero = JOptionPane.showInputDialog("Introduce ed día en el que caduca tu tarjeta.");
        int diaTarjeta = pedirEntero(diaNumero);
        String mesNumero = JOptionPane.showInputDialog("Introduce ed día en el que caduca tu tarjeta.");
        int mesTarjeta = pedirEntero(mesNumero);
        String anioNumero = JOptionPane.showInputDialog("Introduce ed día en el que caduca tu tarjeta.");
        int anioTarjeta = pedirEntero(anioNumero);
        
        LocalDate fechaTarjeta = LocalDate.of(anioTarjeta, mesTarjeta, diaTarjeta);
        
        aux = new Tarjeta(numeroTarjeta, fechaTarjeta, CVVTarjeta);
        return aux;
    }
    public static int pedirEntero(String mensaje) {
        while (true) {
            try {
//                String entrada = JOptionPane.showInputDialog(mensaje);
                int numero = Integer.parseInt(mensaje);
                return numero;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Introduce un número entero válido.");
            }
        }
    }
    public static String pedirEnteroString(String mensaje) {
        while (true) {
            try {
                String aux = JOptionPane.showInputDialog(mensaje);
                Integer.parseInt(aux); // Intentamos convertir a entero para validar la entrada
                return aux; // Si no se lanza una excepción, la entrada es válida como cadena.
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Introduce un número entero válido.");
            }
        }
    }
}
