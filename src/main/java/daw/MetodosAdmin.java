/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
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
    public static List<Ticket> consultarTickets(TPV tpv) {

        return tpv.getListaTickets();
    }

    //consultar tickets del tpv segun un dia concreto
    public static List<Ticket> consultarTicketsDia(TPV tpv, int diaDelMes) {

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
    public static List<Ticket> consultarTicketsFecha(TPV tpv, LocalDateTime fecha) {

        List<Ticket> listaTickets = tpv.getListaTickets();
        List<Ticket> listaTicketsFecha = new ArrayList<>();

        for (Ticket ticket : listaTickets) {
            if (ticket.getFechaEmision().isEqual(fecha)) {
                listaTicketsFecha.add(ticket);
            }
        }

        return listaTicketsFecha;
    }

    public static void modoAdministrador(TPV tpv) {
        boolean salirAdmin = false;

        //iniciamos el bucle
        do {
            //creamos las opciones del admin
            String[] opcionesUsuarioAdmin = {"Modificar producto", "Dar de alta un producto",
                "Borrar producto", "Ver ventas", "Salir"};
            //mensaje de JOptionPane par mostrar dichas opciones
            int opcionUsuarioAdmin = JOptionPane.showOptionDialog(null,
                    "Seleccione una opción",
                    "Wok and Roll -- DAWFOOD -- Modo Administrador",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.PLAIN_MESSAGE, null,
                    opcionesUsuarioAdmin, opcionesUsuarioAdmin[0]);

            //switch con las diferentes opciones dadas
            switch (opcionesUsuarioAdmin[opcionUsuarioAdmin]) {
                //con cada opcion llamamos a su método correspondiente
                //si elige salir vuelve al menú de inicio
                case "Modificar producto" -> {
                    //creamos las opciones del usuario
                    String[] opcionesAdmin = {"Comidas", "Bebidas",
                        "Postres", "Salir"};
                    //mensaje de JOptionPane par mostrar dichas opciones
                    int opcionAdmin = JOptionPane.showOptionDialog(null,
                            "¿En qué categoría está el producto que quieres cambiar?",
                            "Wok and Roll -- DAWFOOD -- Modo Administrador",
                            JOptionPane.DEFAULT_OPTION,
                            JOptionPane.PLAIN_MESSAGE, null,
                            opcionesAdmin, opcionesAdmin[0]);

                    switch (opcionesAdmin[opcionAdmin]) {
                        case "Comidas" -> {

                            String[] opcionesSubCategorias = {"Ramen", "Sushi", "Wok"};
                            //mensaje de JOptionPane par mostrar las opciones de comida
                            int opcionSubCategorias = JOptionPane.showOptionDialog(null,
                                    "Seleccione una opción",
                                    "Wok and Roll -- DAWFOOD -- Modo Administrador",
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
                                            "Wok and Roll -- DAWFOOD -- Modo Administrador",
                                            JOptionPane.QUESTION_MESSAGE,
                                            null,
                                            opcionesProductosRamen,
                                            opcionesProductosRamen[0]);

                                    if (seleccionProducto != null) {
                                        // El usuario seleccionó un producto
                                        //opciones a mostrar: ver todo, ver los subtipos para elegir, volver
                                        String[] opcionesElegidas = {"Modificar", "Volver"};
                                        int opcionElegida = JOptionPane.showOptionDialog(null,
                                                "¿Qué deseas hacer con este producto?",
                                                "Wok and Roll -- DAWFOOD -- Modo Administrador",
                                                JOptionPane.YES_NO_OPTION,
                                                JOptionPane.QUESTION_MESSAGE,
                                                null,
                                                opcionesElegidas,
                                                opcionesElegidas[0]);

                                        if (opcionElegida != 1) {
                                            /*creamos un producto auxiliar para poder 
                                                    añadir el producto seleccionado al carrito*/
//                                            Producto productoSeleccionadoRamen = listaRamen.get(Arrays.asList(opcionesProductosRamen).indexOf(seleccionProducto));
//                                            UtilidadesTPV.agregarAlCarrito(tpv, productoSeleccionadoRamen);
                                            System.out.println("producto añadido pa modificar");
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
                                            "Wok and Roll -- DAWFOOD -- Modo Administrador",
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
                                                "Wok and Roll -- DAWFOOD -- Modo Administrador",
                                                JOptionPane.YES_NO_OPTION,
                                                JOptionPane.QUESTION_MESSAGE,
                                                null,
                                                opcionesElegidas,
                                                opcionesElegidas[0]);

                                        if (opcionElegida != 1) {
                                            /*creamos un producto auxiliar para poder 
                                                    añadir el producto seleccionado al carrito*/
//                                            Producto productoSeleccionado = listaSushi.get(Arrays.asList(opcionesProductosSushi).indexOf(seleccionProductoSushi));
//                                            UtilidadesTPV.agregarAlCarrito(tpv, productoSeleccionado);
                                            System.out.println("producto añadido pa modificar");
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
                                            "Wok and Roll -- DAWFOOD -- Modo Administrador",
                                            JOptionPane.QUESTION_MESSAGE,
                                            null,
                                            opcionesProductosWok,
                                            opcionesProductosWok[0]);

                                    if (seleccionProductoWok != null) {
                                        // El usuario seleccionó un producto
                                        //opciones a mostrar: ver todo, ver los subtipos para elegir, volver
                                        String[] opcionesElegidas = {"Modificar", "Volver"};
                                        int opcionElegida = JOptionPane.showOptionDialog(null,
                                                "¿Qué deseas hacer con este producto?",
                                                "Wok and Roll -- DAWFOOD -- Modo Administrador",
                                                JOptionPane.YES_NO_OPTION,
                                                JOptionPane.QUESTION_MESSAGE,
                                                null,
                                                opcionesElegidas,
                                                opcionesElegidas[0]);

                                        if (opcionElegida != 1) {
                                            /*creamos un producto auxiliar para poder 
                                                    añadir el producto seleccionado al carrito*/
//                                            Producto productoSeleccionadoRamen = listaWok.get(Arrays.asList(opcionesProductosWok).indexOf(seleccionProductoWok));
//                                            UtilidadesTPV.agregarAlCarrito(tpv, productoSeleccionadoRamen);
                                            System.out.println("producto pa modificar");
                                        } else if (opcionElegida != 0) {
                                            break;
                                        }
                                    }
                                    break;

                            }

                        }
                        case "Bebidas" -> {

                            String[] opcionesSubCategorias = {"Refrescos", "Alcoholicas", "Otras"};
                            //mensaje de JOptionPane par mostrar las opciones de comida
                            int opcionSubCategorias = JOptionPane.showOptionDialog(null,
                                    "Seleccione una opción",
                                    "Wok and Roll -- DAWFOOD -- Modo Administrador",
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
                                            "Wok and Roll -- DAWFOOD -- Modo Administrador",
                                            JOptionPane.QUESTION_MESSAGE,
                                            null,
                                            opcionesProductosRefresco,
                                            opcionesProductosRefresco[0]);

                                    if (seleccionProducto != null) {
                                        // El usuario seleccionó un producto
                                        //opciones a mostrar: ver todo, ver los subtipos para elegir, volver
                                        String[] opcionesElegidas = {"Modificar", "Volver"};
                                        int opcionElegida = JOptionPane.showOptionDialog(null,
                                                "¿Qué deseas hacer con este producto?",
                                                "Wok and Roll -- DAWFOOD -- Modo Administrador",
                                                JOptionPane.YES_NO_OPTION,
                                                JOptionPane.QUESTION_MESSAGE,
                                                null,
                                                opcionesElegidas,
                                                opcionesElegidas[0]);

                                        if (opcionElegida != 1) {
                                            /*creamos un producto auxiliar para poder 
                                                    añadir el producto seleccionado al carrito*/
//                                            Producto productoSeleccionadoRamen = listaRefrescos.get(Arrays.asList(opcionesProductosRefresco).indexOf(seleccionProducto));
//                                            UtilidadesTPV.agregarAlCarrito(tpv, productoSeleccionadoRamen);
                                            System.out.println("producto añadido pa modificar");
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
                                            "Wok and Roll -- DAWFOOD -- Modo Administrador",
                                            JOptionPane.QUESTION_MESSAGE,
                                            null,
                                            opcionesProductosAlcoholicas,
                                            opcionesProductosAlcoholicas[0]);

                                    if (seleccionAlcoholicas != null) {
                                        // El usuario seleccionó un producto
                                        //opciones a mostrar: ver todo, ver los subtipos para elegir, volver
                                        String[] opcionesElegidas = {"Modificar", "Volver"};
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
//                                            Producto productoSeleccionadoRamen = listaAlcoholicas.get(Arrays.asList(opcionesProductosAlcoholicas).indexOf(seleccionAlcoholicas));
//                                            UtilidadesTPV.agregarAlCarrito(tpv, productoSeleccionadoRamen);
                                            System.out.println("producto añadido pa modificar");
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
                                            "Wok and Roll -- DAWFOOD -- Modo Administrador",
                                            JOptionPane.QUESTION_MESSAGE,
                                            null,
                                            opcionesProductosOtras,
                                            opcionesProductosOtras[0]);

                                    if (seleccionOtras != null) {
                                        // El usuario seleccionó un producto
                                        //opciones a mostrar: ver todo, ver los subtipos para elegir, volver
                                        String[] opcionesElegidas = {"Modificar", "Volver"};
                                        int opcionElegida = JOptionPane.showOptionDialog(null,
                                                "¿Qué deseas hacer con este producto?",
                                                "Wok and Roll -- DAWFOOD -- Modo Administrador",
                                                JOptionPane.YES_NO_OPTION,
                                                JOptionPane.QUESTION_MESSAGE,
                                                null,
                                                opcionesElegidas,
                                                opcionesElegidas[0]);

                                        if (opcionElegida != 1) {
                                            /*creamos un producto auxiliar para poder 
                                                    añadir el producto seleccionado al carrito*/
//                                            Producto productoSeleccionadoRamen = listaOtras.get(Arrays.asList(opcionesProductosOtras).indexOf(seleccionOtras));
//                                            UtilidadesTPV.agregarAlCarrito(tpv, productoSeleccionadoRamen);
                                            System.out.println("producto añadido pa modificar");
                                        } else if (opcionElegida != 0) {
                                            System.out.println("volver");
                                            return;
                                        }

                                    }
                            }

                        }
                        case "Postres" -> {

                            String[] opcionesSubCategorias = {"Mochis", "Frutitas", "Otros"};
                            //mensaje de JOptionPane par mostrar las opciones de comida
                            int opcionSubCategorias = JOptionPane.showOptionDialog(null,
                                    "Seleccione una opción",
                                    "Wok and Roll -- DAWFOOD -- Modo Administrador",
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
                                            "Wok and Roll -- DAWFOOD -- Modo Administrador",
                                            JOptionPane.QUESTION_MESSAGE,
                                            null,
                                            opcionesProductosMochi,
                                            opcionesProductosMochi[0]);

                                    if (seleccionProductoPostre != null) {
                                        // El usuario seleccionó un producto
                                        //opciones a mostrar: ver todo, ver los subtipos para elegir, volver
                                        String[] opcionesElegidas = {"Modificar", "Volver"};
                                        int opcionElegida = JOptionPane.showOptionDialog(null,
                                                "¿Qué deseas hacer con este producto?",
                                                "Wok and Roll -- DAWFOOD -- Modo Administrador",
                                                JOptionPane.YES_NO_OPTION,
                                                JOptionPane.QUESTION_MESSAGE,
                                                null,
                                                opcionesElegidas,
                                                opcionesElegidas[0]);

                                        if (opcionElegida != 1) {
                                            /*creamos un producto auxiliar para poder 
                                                    añadir el producto seleccionado al carrito*/
//                                            Producto productoSeleccionadoMochi = listaPostres.get(Arrays.asList(opcionesProductosMochi).indexOf(seleccionProductoPostre));
//                                            UtilidadesTPV.agregarAlCarrito(tpv, productoSeleccionadoMochi);
                                            System.out.println("producto añadido pa modificar");
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
                                            "Wok and Roll -- DAWFOOD -- Modo Administrador",
                                            JOptionPane.QUESTION_MESSAGE,
                                            null,
                                            opcionesProductosFrutitas,
                                            opcionesProductosFrutitas[0]);

                                    if (seleccionFrutitas != null) {
                                        // El usuario seleccionó un producto
                                        //opciones a mostrar: ver todo, ver los subtipos para elegir, volver
                                        String[] opcionesElegidas = {"Modificar", "Volver"};
                                        int opcionElegida = JOptionPane.showOptionDialog(null,
                                                "¿Qué deseas hacer con este producto?",
                                                "Wok and Roll -- DAWFOOD -- Modo Administrador",
                                                JOptionPane.YES_NO_OPTION,
                                                JOptionPane.QUESTION_MESSAGE,
                                                null,
                                                opcionesElegidas,
                                                opcionesElegidas[0]);

                                        if (opcionElegida != 1) {
                                            /*creamos un producto auxiliar para poder 
                                                    añadir el producto seleccionado al carrito*/
//                                            Producto productoSeleccionadoRamen = listaFrutitas.get(Arrays.asList(opcionesProductosFrutitas).indexOf(seleccionFrutitas));
//                                            UtilidadesTPV.agregarAlCarrito(tpv, productoSeleccionadoRamen);
                                            System.out.println("producto añadido pa modificar");
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
                                            "Wok and Roll -- DAWFOOD -- Modo Administrador",
                                            JOptionPane.QUESTION_MESSAGE,
                                            null,
                                            opcionesProductosOtros,
                                            opcionesProductosOtros[0]);

                                    if (seleccionOtros != null) {
                                        // El usuario seleccionó un producto
                                        //opciones a mostrar: ver todo, ver los subtipos para elegir, volver
                                        String[] opcionesElegidas = {"Modificar", "Volver"};
                                        int opcionElegida = JOptionPane.showOptionDialog(null,
                                                "¿Qué deseas hacer con este producto?",
                                                "Wok and Roll -- DAWFOOD -- Modo Administrador",
                                                JOptionPane.YES_NO_OPTION,
                                                JOptionPane.QUESTION_MESSAGE,
                                                null,
                                                opcionesElegidas,
                                                opcionesElegidas[0]);

                                        if (opcionElegida != 1) {
                                            /*creamos un producto auxiliar para poder 
                                                    añadir el producto seleccionado al carrito*/
//                                            Producto productoSeleccionadoOtros = listaOtras.get(Arrays.asList(opcionesProductosOtros).indexOf(seleccionOtros));
//                                            UtilidadesTPV.agregarAlCarrito(tpv, productoSeleccionadoOtros);
                                            System.out.println("producto añadido pa modificar");
                                        } else if (opcionElegida != 0) {
                                            System.out.println("volver");
                                            return;
                                        }
                                    }
                            }

                        }
                        case "Salir" -> {
                            System.out.println("volviendo");
                            return;
                        }
                    }

                    System.out.println("Modificar producto");
//                    MetodosAdmin.modificarProducto(aux);
                }
                case "Dar de alta un producto" -> {
                    System.out.println("Dar de alta un producto");
//                    MetodosAdmin.altaProducto(tpv.getProductos(), productoNuevo);
                }
                case "Borrar producto" -> {
                    System.out.println("Dar de baja un producto");
//                    MetodosAdmin.bajaProducto(tpv.getProductos(), productoABorrar);
                }
                case "Ver ventas" -> {
                    System.out.println("Ver ventas de hoy");
                    MetodosAdmin.consultarTicketsFecha(tpv, LocalDateTime.now());
                }
                case "Salir" -> {
                    System.out.println("volver a inicio");
                    return;
                }
            }

        } while (!salirAdmin);
    }

    //aaaaaaaaaaaaaaaaaaaaa
   
    private static void mostrarProd(List<Producto> aux, String[] opciones) {
        for (int i = 0; i < aux.size(); i++) {
            Producto producto = aux.get(i);
            opciones[i] = producto.getNombre() + " - Precio: "
                    + producto.getPrecioConIVA() + "€";
        }
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

}
