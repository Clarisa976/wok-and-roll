/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw;

import java.util.ArrayList;
import java.util.Arrays;
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

        for (Map.Entry<Producto, Integer> entry : mapCantidadProductos.entrySet()) {
            Object key = entry.getKey();
            Object val = entry.getValue();

        }
        if (UtilidadesTarjetaNuevo.verificarTarjetaCompleto(importeTotal)) {
//        if (UtilidadesTarjeta.verificarTarjetaCompleto(importeTotal)) {

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
                    MetodosAdmin.modoAdministrador(tpv);
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

            double totalPagar = 0;
            for (int i = 0; i < listaCarrito.size(); i++) {
                Producto producto = listaCarrito.get(i);
                opcionesProductos[i] = producto.getNombre() + " - Precio: "
                        + producto.getPrecioConIVA() + "€";
                totalPagar += producto.getPrecioConIVA();
            }

            //mensajes para elegir
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
                String[] opcionesElegidas = {"Pagar", "Cancelar compra", "Volver"};
                int opcionElegida = JOptionPane.showOptionDialog(null,
                        "¿Qué deseas hacer con este producto?",
                        "Wok and Roll -- DAWFOOD --",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        opcionesElegidas,
                        opcionesElegidas[0]);

                //opciones de elección
                switch (opcionesElegidas[opcionElegida]) {
                    case "Pagar":
                        /*hay que optener el importe del carrito*/
                        double importe = 25;
                        Tarjeta tarjetaAux = UtilidadesTarjetaNuevo.TarjetaDefinitiva(importe);

                        UtilidadesTPV.finalizarCompra(tpv, tarjetaAux);
                        System.out.println("Pagando");
                        break;

                    case "Cancelar compra":
                        tpv.getCarrito().clear();//vaciamos el carrito
                        break;
                    case "Volver":

                        System.out.println("Volver");
                        return;
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "El carrito esta vacío...");
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
                        List<Comida> listaComida = CatalogoCarta.comidasBD();
                        String[] opcionesProductos = new String[listaComida.size()];
                        mostrarProdComida(listaComida, opcionesProductos);

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

                        List<Bebida> listaBebida = CatalogoCarta.bebidasBD();
                        String[] opcionesProductos = new String[listaBebida.size()];

                        mostrarProdBebida(listaBebida, opcionesProductos);

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

                        List<Postre> listaPostre = CatalogoCarta.postresBD();
                        String[] opcionesProductos = new String[listaPostre.size()];
                        mostrarProdPostre(listaPostre, opcionesProductos);

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
                case "Ver subcategorias":
                    //si selecciona comida →
                    if (nombreCategoria.equalsIgnoreCase("comidas")) {

                        String[] opcionesSubCategorias = {"Ramen", "Sushi", "Wok"};
                        //mensaje de JOptionPane par mostrar las opciones de comida
                        int opcionSubCategorias = JOptionPane.showOptionDialog(null,
                                "Seleccione una opción",
                                "Wok and Roll -- DAWFOOD -- Modo Usuario",
                                JOptionPane.DEFAULT_OPTION,
                                JOptionPane.PLAIN_MESSAGE, null,
                                opcionesSubCategorias, opcionesSubCategorias[0]);

                        //switch segun el tipo de comida
                        List<Comida> listaComidaTmp = CatalogoCarta.comidasBD();

                        switch (opcionesSubCategorias[opcionSubCategorias]) {

                            case "Ramen":

                                listaComidaTmp = CatalogoCarta.comidasBD();
                                List<Comida> listaRamen = new ArrayList<>();

                                for (Comida comida : listaComidaTmp) {
                                    if (comida.getTipoComida().equals(TipoComida.RAMEN)) {
                                        listaRamen.add(comida);
                                    }
                                }

                                String[] opcionesProductosRamen = new String[listaRamen.size()];
                                mostrarProdComida(listaRamen, opcionesProductosRamen);

                                String seleccionProducto = (String) JOptionPane.showInputDialog(null,
                                        "Selecciona un producto: Ramen",
                                        "Wok and Roll -- DAWFOOD --",
                                        JOptionPane.QUESTION_MESSAGE,
                                        null,
                                        opcionesProductosRamen,
                                        opcionesProductosRamen[0]);

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
                                        Producto productoSeleccionadoRamen = listaRamen.get(Arrays.asList(opcionesProductosRamen).indexOf(seleccionProducto));
                                        UtilidadesTPV.agregarAlCarrito(tpv, productoSeleccionadoRamen);
                                        System.out.println("producto añadido");
                                    } else if (opcionElegida != 0) {
                                        System.out.println("volver");
                                        return;
                                    }
                                }
                            case "Sushi":

                                listaComidaTmp = CatalogoCarta.comidasBD();
                                List<Comida> listaSushi = new ArrayList<>();

                                for (Comida comida : listaComidaTmp) {
                                    if (comida.getTipoComida().equals(TipoComida.SUSHI)) {
                                        listaSushi.add(comida);
                                    }
                                }

                                String[] opcionesProductosSushi = new String[listaSushi.size()];
                                mostrarProdComida(listaSushi, opcionesProductosSushi);

                                String seleccionProductoSushi = (String) JOptionPane.showInputDialog(null,
                                        "Selecciona un producto: Sushi",
                                        "Wok and Roll -- DAWFOOD --",
                                        JOptionPane.QUESTION_MESSAGE,
                                        null,
                                        opcionesProductosSushi,
                                        opcionesProductosSushi[0]);

                                if (seleccionProductoSushi != null) {
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
                                        Producto productoSeleccionado = listaSushi.get(Arrays.asList(opcionesProductosSushi).indexOf(seleccionProductoSushi));
                                        UtilidadesTPV.agregarAlCarrito(tpv, productoSeleccionado);
                                        System.out.println("producto añadido");
                                    } else if (opcionElegida != 0) {
                                        break;
                                    }
                                }
                            case "Wok":

                                listaComidaTmp = CatalogoCarta.comidasBD();
                                List<Comida> listaWok = new ArrayList<>();

                                for (Comida comida : listaComidaTmp) {
                                    if (comida.getTipoComida().equals(TipoComida.WOK)) {
                                        listaWok.add(comida);
                                    }
                                }

                                String[] opcionesProductosWok = new String[listaWok.size()];
                                mostrarProdComida(listaWok, opcionesProductosWok);

                                String seleccionProductoWok = (String) JOptionPane.showInputDialog(null,
                                        "Selecciona un producto: Wok",
                                        "Wok and Roll -- DAWFOOD --",
                                        JOptionPane.QUESTION_MESSAGE,
                                        null,
                                        opcionesProductosWok,
                                        opcionesProductosWok[0]);

                                if (seleccionProductoWok != null) {
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
                                        Producto productoSeleccionadoRamen = listaWok.get(Arrays.asList(opcionesProductosWok).indexOf(seleccionProductoWok));
                                        UtilidadesTPV.agregarAlCarrito(tpv, productoSeleccionadoRamen);
                                        System.out.println("producto añadido");
                                    } else if (opcionElegida != 0) {
                                        break;
                                    }
                                }
                                break;
                            default:
                                throw new AssertionError();
                        }
                    } else if (nombreCategoria.equalsIgnoreCase("bebidas")) {
                        String[] opcionesSubCategorias = {"Refrescos", "Alcoholicas", "Otras"};
                        //mensaje de JOptionPane par mostrar las opciones de comida
                        int opcionSubCategorias = JOptionPane.showOptionDialog(null,
                                "Seleccione una opción",
                                "Wok and Roll -- DAWFOOD -- Modo Usuario",
                                JOptionPane.DEFAULT_OPTION,
                                JOptionPane.PLAIN_MESSAGE, null,
                                opcionesSubCategorias, opcionesSubCategorias[0]);

                        //switch segun el tipo de bebida
                        List<Bebida> listaBebidaTmp = new ArrayList<>();

                        switch (opcionesSubCategorias[opcionSubCategorias]) {

                            case "Refrescos":

                                listaBebidaTmp = CatalogoCarta.bebidasBD();
                                List<Bebida> listaRefrescos = new ArrayList<>();

                                for (Bebida bebida : listaBebidaTmp) {
                                    if (bebida.getTipoBebida().equals(TipoBebida.REFRESCOS)) {
                                        listaRefrescos.add(bebida);
                                    }
                                }

                                String[] opcionesProductosRefresco = new String[listaRefrescos.size()];
                                mostrarProdBebida(listaRefrescos, opcionesProductosRefresco);

                                String seleccionProducto = (String) JOptionPane.showInputDialog(null,
                                        "Selecciona un producto: Refrescos",
                                        "Wok and Roll -- DAWFOOD --",
                                        JOptionPane.QUESTION_MESSAGE,
                                        null,
                                        opcionesProductosRefresco,
                                        opcionesProductosRefresco[0]);

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
                                        Producto productoSeleccionadoRamen = listaRefrescos.get(Arrays.asList(opcionesProductosRefresco).indexOf(seleccionProducto));
                                        UtilidadesTPV.agregarAlCarrito(tpv, productoSeleccionadoRamen);
                                        System.out.println("producto añadido");
                                    } else if (opcionElegida != 0) {
                                        System.out.println("volver");
                                        return;
                                    }
                                }
                            case "Alcoholicas":
                                listaBebidaTmp = CatalogoCarta.bebidasBD();
                                List<Bebida> listaAlcoholicas = new ArrayList<>();

                                for (Bebida bebida : listaBebidaTmp) {
                                    if (bebida.getTipoBebida().equals(TipoBebida.ALCOHOLICAS)) {
                                        listaAlcoholicas.add(bebida);
                                    }
                                }

                                String[] opcionesProductosAlcoholicas = new String[listaAlcoholicas.size()];
                                mostrarProdBebida(listaAlcoholicas, opcionesProductosAlcoholicas);

                                String seleccionAlcoholicas = (String) JOptionPane.showInputDialog(null,
                                        "Selecciona un producto: Alcoholicas",
                                        "Wok and Roll -- DAWFOOD --",
                                        JOptionPane.QUESTION_MESSAGE,
                                        null,
                                        opcionesProductosAlcoholicas,
                                        opcionesProductosAlcoholicas[0]);

                                if (seleccionAlcoholicas != null) {
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
                                        Producto productoSeleccionadoRamen = listaAlcoholicas.get(Arrays.asList(opcionesProductosAlcoholicas).indexOf(seleccionAlcoholicas));
                                        UtilidadesTPV.agregarAlCarrito(tpv, productoSeleccionadoRamen);
                                        System.out.println("producto añadido");
                                    } else if (opcionElegida != 0) {
                                        System.out.println("volver");
                                        return;
                                    }
                                }
                            case "Otras":
                                listaBebidaTmp = CatalogoCarta.bebidasBD();
                                List<Bebida> listaOtras = new ArrayList<>();

                                for (Bebida bebida : listaBebidaTmp) {
                                    if (bebida.getTipoBebida().equals(TipoBebida.OTROS)) {
                                        listaOtras.add(bebida);
                                    }
                                }

                                String[] opcionesProductosOtras = new String[listaOtras.size()];
                                mostrarProdBebida(listaOtras, opcionesProductosOtras);

                                String seleccionOtras = (String) JOptionPane.showInputDialog(null,
                                        "Selecciona un producto: Alcoholicas",
                                        "Wok and Roll -- DAWFOOD --",
                                        JOptionPane.QUESTION_MESSAGE,
                                        null,
                                        opcionesProductosOtras,
                                        opcionesProductosOtras[0]);

                                if (seleccionOtras != null) {
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
                                        Producto productoSeleccionadoRamen = listaOtras.get(Arrays.asList(opcionesProductosOtras).indexOf(seleccionOtras));
                                        UtilidadesTPV.agregarAlCarrito(tpv, productoSeleccionadoRamen);
                                        System.out.println("producto añadido");
                                    } else if (opcionElegida != 0) {
                                        System.out.println("volver");
                                        return;
                                    }
                                }
                                break;
                            default:
                                throw new AssertionError();
                        }
                    } else if (nombreCategoria.equalsIgnoreCase("postres")) {
                        String[] opcionesSubCategorias = {"Mochis", "Frutitas", "Otros"};
                        //mensaje de JOptionPane par mostrar las opciones de comida
                        int opcionSubCategorias = JOptionPane.showOptionDialog(null,
                                "Seleccione una opción",
                                "Wok and Roll -- DAWFOOD -- Modo Usuario",
                                JOptionPane.DEFAULT_OPTION,
                                JOptionPane.PLAIN_MESSAGE, null,
                                opcionesSubCategorias, opcionesSubCategorias[0]);

                        //switch segun el tipo de bebida
                        List<Postre> listaPostreTmp = new ArrayList<>();

                        switch (opcionesSubCategorias[opcionSubCategorias]) {

                            case "Mochis":

                                listaPostreTmp = CatalogoCarta.postresBD();
                                List<Postre> listaPostres = new ArrayList<>();

                                for (Postre postre : listaPostreTmp) {
                                    if (postre.getTipoPostre().equals(TipoPostre.MOCHI)) {
                                        listaPostres.add(postre);
                                    }
                                }

                                String[] opcionesProductosMochi = new String[listaPostres.size()];
                                mostrarProdPostre(listaPostres, opcionesProductosMochi);

                                String seleccionProductoPostre = (String) JOptionPane.showInputDialog(null,
                                        "Selecciona un producto: Mochis",
                                        "Wok and Roll -- DAWFOOD --",
                                        JOptionPane.QUESTION_MESSAGE,
                                        null,
                                        opcionesProductosMochi,
                                        opcionesProductosMochi[0]);

                                if (seleccionProductoPostre != null) {
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
                                        Producto productoSeleccionadoMochi = listaPostres.get(Arrays.asList(opcionesProductosMochi).indexOf(seleccionProductoPostre));
                                        UtilidadesTPV.agregarAlCarrito(tpv, productoSeleccionadoMochi);
                                        System.out.println("producto añadido");
                                    } else if (opcionElegida != 0) {
                                        System.out.println("volver");
                                        return;
                                    }
                                }

                            case "Frutitas":
                                listaPostreTmp = CatalogoCarta.postresBD();
                                List<Postre> listaFrutitas = new ArrayList<>();

                                for (Postre postre : listaPostreTmp) {
                                    if (postre.getTipoPostre().equals(TipoPostre.FRUTITA)) {
                                        listaFrutitas.add(postre);
                                    }
                                }

                                String[] opcionesProductosFrutitas = new String[listaFrutitas.size()];
                                mostrarProdPostre(listaFrutitas, opcionesProductosFrutitas);

                                String seleccionFrutitas = (String) JOptionPane.showInputDialog(null,
                                        "Selecciona un producto: Frutitas",
                                        "Wok and Roll -- DAWFOOD --",
                                        JOptionPane.QUESTION_MESSAGE,
                                        null,
                                        opcionesProductosFrutitas,
                                        opcionesProductosFrutitas[0]);

                                if (seleccionFrutitas != null) {
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
                                        Producto productoSeleccionadoRamen = listaFrutitas.get(Arrays.asList(opcionesProductosFrutitas).indexOf(seleccionFrutitas));
                                        UtilidadesTPV.agregarAlCarrito(tpv, productoSeleccionadoRamen);
                                        System.out.println("producto añadido");
                                    } else if (opcionElegida != 0) {
                                        System.out.println("volver");
                                        return;
                                    }
                                }
                            case "Otros":
                                listaPostreTmp = CatalogoCarta.postresBD();
                                List<Postre> listaOtras = new ArrayList<>();

                                for (Postre postre : listaPostreTmp) {
                                    if (postre.getTipoPostre().equals(TipoPostre.OTROS)) {
                                        listaOtras.add(postre);
                                    }
                                }

                                String[] opcionesProductosOtros = new String[listaOtras.size()];
                                mostrarProdPostre(listaOtras, opcionesProductosOtros);

                                String seleccionOtros = (String) JOptionPane.showInputDialog(null,
                                        "Selecciona un producto: Otros",
                                        "Wok and Roll -- DAWFOOD --",
                                        JOptionPane.QUESTION_MESSAGE,
                                        null,
                                        opcionesProductosOtros,
                                        opcionesProductosOtros[0]);

                                if (seleccionOtros != null) {
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
                                        Producto productoSeleccionadoOtros = listaOtras.get(Arrays.asList(opcionesProductosOtros).indexOf(seleccionOtros));
                                        UtilidadesTPV.agregarAlCarrito(tpv, productoSeleccionadoOtros);
                                        System.out.println("producto añadido");
                                    } else if (opcionElegida != 0) {
                                        System.out.println("volver");
                                        return;
                                    }
                                }
                                break;

                            default:
                                throw new AssertionError();
                        }
                    }
                    System.out.println("enums");
                    break;
                //si elige salir vuelve al menú de anterior
                case "Volver":
                    System.out.println("volver a categorías");
                    return;
            }

        } while (!salirCategorias);
    }

    private static void mostrarProdComida(List<Comida> aux, String[] opciones) {
        for (int i = 0; i < aux.size(); i++) {
            Comida comida = aux.get(i);
            opciones[i] = comida.getNombre() + " - Precio: "
                    + comida.getPrecioConIVA() + "€";
        }
    }

    private static void mostrarProdBebida(List<Bebida> aux, String[] opciones) {
        for (int i = 0; i < aux.size(); i++) {
            Bebida bebida = aux.get(i);
            opciones[i] = bebida.getNombre() + " - Precio: "
                    + bebida.getPrecioConIVA() + "€";
        }
    }

    private static void mostrarProdPostre(List<Postre> aux, String[] opciones) {
        for (int i = 0; i < aux.size(); i++) {
            Postre postre = aux.get(i);
            opciones[i] = postre.getNombre() + " - Precio: "
                    + postre.getPrecioConIVA() + "€";
        }
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

    private static String pedirEnteroString(String mensaje) {
        while (true) {
//            try {
            if (esEntero(mensaje)) {
                return mensaje;
            } else {
//                String aux = JOptionPane.showInputDialog(mensaje);
//                Integer.parseInt(aux); // Intentamos convertir a entero para validar la entrada
//                return aux; // Si no se lanza una excepción, la entrada es válida como cadena.
//            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Introduce un número entero válido.");
            }
        }
    }

    private static boolean esEntero(String mensaje) {
        try {
            Integer.parseInt(mensaje);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
