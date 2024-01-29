/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw;

import java.time.LocalDate;
import java.time.LocalDateTime;
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

    public static void agregarAlCarrito(TPV tpv, Producto producto, int cantidad) {
        List<Producto> carritoTmp = tpv.getCarrito();

        if (producto.getStock() >= cantidad) {
            // Crea una nueva instancia del producto con el stock ajustado a la cantidad
            Producto productoParaAgregar = new Producto(producto.getNombre(),
                    producto.getPrecio(), producto.getTipoIVA(),
                    cantidad);
            carritoTmp.add(productoParaAgregar);

            producto.setStock(producto.getStock() - cantidad); // reduce el stock del producto
            tpv.setCarrito(carritoTmp);
        } else {
            System.out.println("No hay suficiente stock del artículo seleccionado.");
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

            importeTotal += producto.getPrecio();
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
            //se añade el nuevo ticket a la lista de tickets
            tpv.getListaTickets().add(ticketCompra);
            ticketCompra.imprimirTicket();

        } else {
            System.out.println("No tiene saldo suficente en la tarjeta para realizar"
                    + " la compra o la tarjeta no existe");
        }

        carritoTmp.removeAll(carritoTmp);

        tpv.setCarrito(carritoTmp);
    }

    //método para encender el tpv
    public static void encenderTPV(TPV tpv) {

//        TPV tpv = new TPV();
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
                    String pedirPass = MetodosAdmin.pedirContrasenia();
                    if (tpv.getPassAdministrador().equals(pedirPass)) {
                        MetodosAdmin.modoMantenimiento(tpv);

                        System.out.println("Modo admin");
                    } else {
                        JOptionPane.showMessageDialog(null, "No deberías de estar por aquí.");
                        break;
                    }

                    break;
                //si elige salir se apagará el programa
                case "Salir":
                    System.out.println("Apagar TPV");
//                    apagarTPV(tpv);
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

                }
                case "Ver bebidas" -> {
                    verCategorias("bebidas", tpv);

                }
                case "Ver postres" -> {
                    verCategorias("postres", tpv);

                }
                case "Ver carrito" -> {
                    verCarrito(tpv);

                }
                case "Salir" -> {
                    System.out.println("volver a inicio");
                    return;
                }
            }

        } while (!salirUsuario);
    }

    //método para ver los productos que hay en el carrito
    private static void verCarrito(TPV tpv) {

        double importeTotal = 0;

        String infoCarrito = "\t\t Wok and Roll -- DAWFOOD\n\n";

        if (!tpv.getCarrito().isEmpty()) {
            String[] opcionesProductos = new String[tpv.getCarrito().size()];

            //con un bucle for vamos recorriendo el carrito del tpv
            for (int i = 0; i < tpv.getCarrito().size(); i++) {
                Producto producto = tpv.getCarrito().get(i);
                //primero añadimos el nombre, el estoc y el precio de los productos añadidos
                infoCarrito += producto.getNombre() + " x "
                        + producto.getStock() + " " + producto.getPrecio()
                        + "€\n";
                //luego calculamos los precios
                importeTotal += producto.getPrecio() * producto.getStock();
                //llenamos las opciones de productos
                opcionesProductos[i] = producto.getNombre();
            }

            //por último fomateamos el precio
            infoCarrito += "*************************************\n"
                    + "\t Importe total a pagar: %.2f€\n".formatted(importeTotal);

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
                        infoCarrito,
                        "Wok and Roll -- DAWFOOD --",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        opcionesElegidas,
                        opcionesElegidas[0]);

                //opciones de elección
                switch (opcionesElegidas[opcionElegida]) {
                    case "Pagar":
                        UtilidadesTPV.pagar(tpv, importeTotal);

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
            JOptionPane.showMessageDialog(null, "El carrito está vacío...");
            modoUsuario(tpv);
        }

    }

    /*
    private static void verCarritoViejo(TPV tpv) {

        //Producto productotmp = new Producto("lo que sea", 3, TipoIVA.IVA_DIEZ, 2);
        //agregarAlCarrito(tpv, productotmp);
        List<Producto> listaCarrito = tpv.getCarrito();

        if (!listaCarrito.isEmpty()) {
            String[] opcionesProductos = new String[listaCarrito.size()];

            double totalPagar = 0;
            for (int i = 0; i < listaCarrito.size(); i++) {
                Producto producto = listaCarrito.get(i);
                opcionesProductos[i] = producto.getNombre() + " - Precio: "
                        + producto.getPrecio() + "€";
                totalPagar += producto.getPrecio();
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
                        /
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
     */
    //método para confirmar que la tarjeta es correcta y pagar
    private static void pagar(TPV tpv, double importeTotal) {
        boolean datosCorrectos = false;
        String numeroTarjeta = "";
        LocalDate fechaTarjeta = null;
        String numeroCVV = "";
        do {
            numeroTarjeta = UtilidadesTarjetaNuevo.pedirTarjeta();
            if (UtilidadesTarjetaNuevo.numeroTarjetaValido(numeroTarjeta)) {
                do {
                    fechaTarjeta = UtilidadesTarjetaNuevo.pedirFechaTarjeta();
                    if (UtilidadesTarjetaNuevo.verificarFecha(fechaTarjeta, numeroTarjeta)) {
                        do {
                            numeroCVV = UtilidadesTarjetaNuevo.pedirCVV();
                            if (UtilidadesTarjetaNuevo.verificarCVV(numeroCVV, numeroTarjeta)) {
                                datosCorrectos = true;
                            } else {
                                System.out.println("El CVV introducido no es correcto. Por favor, inténtelo de nuevo.");
                            }
                        } while (!datosCorrectos);
                    } else {
                        System.out.println("La fecha introducida no es correcta. Por favor, inténtelo de nuevo.");
                    }
                } while (!datosCorrectos);
            } else {
                System.out.println("El número de tarjeta introducido no es correcto. Por favor, inténtelo de nuevo.");
            }
        } while (!datosCorrectos);

        //verificamos si el número es correcto
        if (UtilidadesTarjetaNuevo.numeroTarjetaValido(numeroTarjeta)) {
            //comprobamos la fecha
            boolean esCorrecto = true;

            if (UtilidadesTarjetaNuevo.verificarFecha(fechaTarjeta, numeroTarjeta)) {
                if (UtilidadesTarjetaNuevo.verificarCVV(numeroCVV, numeroTarjeta)) {
                    //comprobamos si hay saldo
                    if (UtilidadesTarjetaNuevo.saldoSuficiente(numeroTarjeta, importeTotal)) {
                        /*si hay saldo usamos un for para buscar esa tarjeta en
                                            la lista de tarjetas creadas y restarle la cantidad*/
                        for (int i = 0; i < Tarjeta.tarjetasRegistradasBD().size(); i++) {
                            if (numeroTarjeta.equals(Tarjeta.tarjetasRegistradasBD()
                                    .get(i).getNumeroTarjeta()
                                    .substring(Tarjeta.tarjetasRegistradasBD()
                                            .get(i).getNumeroTarjeta()
                                            .length() - 4,
                                            Tarjeta.tarjetasRegistradasBD()
                                                    .get(i).getNumeroTarjeta()
                                                    .length()))) {
                                Tarjeta.tarjetasRegistradasBD().get(i)
                                        .setSaldoTarjeta(Tarjeta.tarjetasRegistradasBD()
                                                .get(i).getSaldoTarjeta()
                                                - importeTotal);
                            }
                        }
                        //restamso la cantidad total de stock de la base de datos creada
                        for (Producto cesta : tpv.getCarrito()) {
                            for (Producto menu : tpv.getProductos()) {
                                if (cesta.equals(menu)) {
                                    menu.setStock(menu.getStock() - cesta.getStock());

                                }
                            }
                        }
                        //creamos el ticket
                        Ticket tmp = new Ticket(new ArrayList<Producto>(
                                tpv.getCarrito()), importeTotal,
                                LocalDateTime.now());
                        System.out.println("pagado correctamente");
                        JOptionPane.showMessageDialog(null, tmp);
                        //agregamos los productos al ticket
                        tpv.getListaTickets().add(tmp);
                        tmp.toString();
                        //nos aseguramos de que se vacía la cesta
                        tpv.getCarrito().clear();
                    }
                }
            }
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
                        List<Producto> listaComida = tpv.getProductos();
//                        List<Comida> listaComida = CatalogoCarta.comidasBD();
                        String[] opcionesProductos = new String[listaComida.size()];
                        MetodosProductos.mostrarProductosComida(listaComida, opcionesProductos);

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
                                Producto productoSeleccionado = listaComida
                                        .get(Arrays.asList(opcionesProductos)
                                                .indexOf(seleccionProducto));

                                //añadimos una cantidad del producto seleccionado
                                String cantidadStr = JOptionPane.showInputDialog("Introduce la cantidad del producto seleccionado que deseas añadir.");
                                int cantidad = Integer.parseInt(cantidadStr);

                                //comprobamos que no haya o no se pase
                                if (cantidad > 0 && cantidad <= productoSeleccionado.getStock()) {
                                    // Añade la cantidad especificada del producto al carrito

                                    UtilidadesTPV.agregarAlCarrito(tpv, productoSeleccionado, cantidad);

                                    System.out.println("Producto añadido");
                                } else {
                                    System.out.println("Cantidad no válida");
                                }

                            } else if (opcionElegida != 0) {
                                System.out.println("volver");
                                return;
                            }
                        }

                        break;
                    } else if (nombreCategoria.equalsIgnoreCase("bebidas")) {
                        List<Producto> listaBebida = tpv.getProductos();
//                        List<Bebida> listaBebida = CatalogoCarta.bebidasBD();
                        String[] opcionesProductos = new String[listaBebida.size()];

                        MetodosProductos.mostrarProductosBebida(listaBebida, opcionesProductos);

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
                                Producto productoSeleccionado = listaBebida
                                        .get(Arrays.asList(opcionesProductos)
                                                .indexOf(seleccionProducto));

                                //añadimos una cantidad del producto seleccionado
                                String cantidadStr = JOptionPane.showInputDialog("Introduce la cantidad del producto seleccionado que deseas añadir.");
                                int cantidad = Integer.parseInt(cantidadStr);

                                //comprobamos que no haya o no se pase
                                if (cantidad > 0 && cantidad <= productoSeleccionado.getStock()) {
                                    // Añade la cantidad especificada del producto al carrito

                                    UtilidadesTPV.agregarAlCarrito(tpv, productoSeleccionado, cantidad);

                                    System.out.println("Producto añadido");
                                } else {
                                    System.out.println("Cantidad no válida");
                                }

                            } else if (opcionElegida != 0) {
                                System.out.println("volver");
                                return;
                            }
                        }
                    } else if (nombreCategoria.equalsIgnoreCase("postres")) {
                        List<Producto> listaPostre = tpv.getProductos();
                        //List<Postre> listaPostre = CatalogoCarta.postresBD();
                        String[] opcionesProductos = new String[listaPostre.size()];
                        MetodosProductos.mostrarProductosPostre(listaPostre, opcionesProductos);

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
                                Producto productoSeleccionado = listaPostre
                                        .get(Arrays.asList(opcionesProductos)
                                                .indexOf(seleccionProducto));

                                //añadimos una cantidad del producto seleccionado
                                String cantidadStr = JOptionPane.showInputDialog("Introduce la cantidad del producto seleccionado que deseas añadir.");
                                int cantidad = Integer.parseInt(cantidadStr);

                                //comprobamos que no haya o no se pase
                                if (cantidad > 0 && cantidad <= productoSeleccionado.getStock()) {
                                    // Añade la cantidad especificada del producto al carrito

                                    UtilidadesTPV.agregarAlCarrito(tpv, productoSeleccionado, cantidad);

                                    System.out.println("Producto añadido");
                                } else {
                                    System.out.println("Cantidad no válida");
                                }

                            } else if (opcionElegida != 0) {
                                System.out.println("volver");
                                return;
                            }
                        }
                    }

                    break;
                case "Ver subcategorias":
                    //si selecciona comida →
                    if (nombreCategoria.equalsIgnoreCase("comidas")) {

                        String[] opcionesSubCategorias = {"Ramen", "Sushi", "Wok", "Volver"};
                        //mensaje de JOptionPane par mostrar las opciones de comida
                        int opcionSubCategorias = JOptionPane.showOptionDialog(null,
                                "Seleccione una opción",
                                "Wok and Roll -- DAWFOOD -- Modo Usuario",
                                JOptionPane.DEFAULT_OPTION,
                                JOptionPane.PLAIN_MESSAGE, null,
                                opcionesSubCategorias, opcionesSubCategorias[0]);

                        //switch segun el tipo de comida
//                        List<Comida> listaComidaTmp = CatalogoCarta.comidasBD();
                        List<Producto> listaComidaTmp = tpv.getProductos();

                        switch (opcionesSubCategorias[opcionSubCategorias]) {

                            case "Ramen":

                                listaComidaTmp = tpv.getProductos();
                                List<Comida> listaRamen = new ArrayList<>();

                                for (Producto comida : listaComidaTmp) {
                                    if (comida instanceof Comida comidaAux) {
                                        if (comidaAux.getTipoComida().equals(TipoComida.RAMEN)) {
                                            listaRamen.add(comidaAux);
                                        }
                                    }
                                }

                                String[] opcionesProductosRamen = new String[listaRamen.size()];
                                MetodosProductos.mostrarProdComida(listaRamen, opcionesProductosRamen);

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
                                        Producto productoSeleccionadoRamen = listaRamen
                                                .get(Arrays.asList(opcionesProductosRamen)
                                                        .indexOf(seleccionProducto));

                                        //añadimos una cantidad del producto seleccionado
                                        String cantidadStr = JOptionPane.showInputDialog("Introduce la cantidad del producto seleccionado que deseas añadir.");
                                        int cantidad = Integer.parseInt(cantidadStr);

                                        //comprobamos que no haya o no se pase
                                        if (cantidad > 0 && cantidad <= productoSeleccionadoRamen.getStock()) {
                                            // Añade la cantidad especificada del producto al carrito

                                            UtilidadesTPV.agregarAlCarrito(tpv, productoSeleccionadoRamen, cantidad);

                                            System.out.println("Producto añadido");
                                        } else {
                                            System.out.println("Cantidad no válida");
                                        }

                                    } else if (opcionElegida != 0) {
                                        System.out.println("volver");
                                        return;
                                    }
                                }
                            case "Sushi":

                                listaComidaTmp = tpv.getProductos();
                                List<Comida> listaSushi = new ArrayList<>();

                                for (Producto comida : listaComidaTmp) {
                                    if (comida instanceof Comida comidaAux) {
                                        if (comidaAux.getTipoComida().equals(TipoComida.SUSHI)) {
                                            listaSushi.add(comidaAux);
                                        }
                                    }
                                }

//                                listaComidaTmp = CatalogoCarta.comidasBD();
//                                List<Comida> listaSushi = new ArrayList<>();
//
//                                for (Comida comida : listaComidaTmp) {
//                                    if (comida.getTipoComida().equals(TipoComida.SUSHI)) {
//                                        listaSushi.add(comida);
//                                    }
//                                }
                                String[] opcionesProductosSushi = new String[listaSushi.size()];
                                MetodosProductos.mostrarProdComida(listaSushi,
                                        opcionesProductosSushi);

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
                                        Producto productoSeleccionado = listaSushi
                                                .get(Arrays.asList(opcionesProductosSushi)
                                                        .indexOf(seleccionProductoSushi));

                                        //añadimos una cantidad del producto seleccionado
                                        String cantidadStr = JOptionPane.showInputDialog("Introduce la cantidad del producto seleccionado que deseas añadir.");
                                        int cantidad = Integer.parseInt(cantidadStr);

                                        //comprobamos que no haya o no se pase
                                        if (cantidad > 0 && cantidad <= productoSeleccionado.getStock()) {
                                            // Añade la cantidad especificada del producto al carrito
                                            for (int i = 0; i < cantidad; i++) {
                                                UtilidadesTPV.agregarAlCarrito(tpv, productoSeleccionado, cantidad);
                                            }
                                            System.out.println("Producto añadido");
                                        } else {
                                            System.out.println("Cantidad no válida");
                                        }

                                    } else if (opcionElegida != 0) {
                                        System.out.println("volver");
                                        return;
                                    }
                                }
                            case "Wok":
                                listaComidaTmp = tpv.getProductos();
                                List<Comida> listaWok = new ArrayList<>();

                                for (Producto comida : listaComidaTmp) {
                                    if (comida instanceof Comida comidaAux) {
                                        if (comidaAux.getTipoComida().equals(TipoComida.WOK)) {
                                            listaWok.add(comidaAux);
                                        }
                                    }
                                }
//                                listaComidaTmp = CatalogoCarta.comidasBD();
//                                List<Comida> listaWok = new ArrayList<>();
//
//                                for (Comida comida : listaComidaTmp) {
//                                    if (comida.getTipoComida().equals(TipoComida.WOK)) {
//                                        listaWok.add(comida);
//                                    }
//                                }

                                String[] opcionesProductosWok = new String[listaWok.size()];
                                MetodosProductos.mostrarProdComida(listaWok,
                                        opcionesProductosWok);

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
                                        Producto productoSeleccionadoRamen = listaWok
                                                .get(Arrays.asList(opcionesProductosWok)
                                                        .indexOf(seleccionProductoWok));

                                        //añadimos una cantidad del producto seleccionado
                                        String cantidadStr = JOptionPane.showInputDialog("Introduce la cantidad del producto seleccionado que deseas añadir.");
                                        int cantidad = Integer.parseInt(cantidadStr);

                                        //comprobamos que no haya o no se pase
                                        if (cantidad > 0 && cantidad <= productoSeleccionadoRamen.getStock()) {
                                            // Añade la cantidad especificada del producto al carrito

                                            UtilidadesTPV.agregarAlCarrito(tpv, productoSeleccionadoRamen, cantidad);

                                            System.out.println("Producto añadido");
                                        } else {
                                            System.out.println("Cantidad no válida");
                                        }

                                    } else if (opcionElegida != 0) {
                                        System.out.println("volver");
                                        return;
                                    }
                                }
                                break;

                        }
                    } else if (nombreCategoria.equalsIgnoreCase("bebidas")) {
                        String[] opcionesSubCategorias = {"Refrescos", "Alcoholicas", "Otras", "Volver"};
                        //mensaje de JOptionPane par mostrar las opciones de comida
                        int opcionSubCategorias = JOptionPane.showOptionDialog(null,
                                "Seleccione una opción",
                                "Wok and Roll -- DAWFOOD -- Modo Usuario",
                                JOptionPane.DEFAULT_OPTION,
                                JOptionPane.PLAIN_MESSAGE, null,
                                opcionesSubCategorias, opcionesSubCategorias[0]);

                        //switch segun el tipo de bebida
                        List<Producto> listaBebidaTmp = tpv.getProductos();

                        switch (opcionesSubCategorias[opcionSubCategorias]) {

                            case "Refrescos":
                                listaBebidaTmp = tpv.getProductos();
                                List<Bebida> listaRefrescos = new ArrayList<>();

                                for (Producto bebida : listaBebidaTmp) {
                                    if (bebida instanceof Bebida bebidaAux) {
                                        if (bebidaAux.getTipoBebida().equals(TipoBebida.REFRESCOS)) {
                                            listaRefrescos.add(bebidaAux);
                                        }
                                    }
                                }

//                                listaBebidaTmp = CatalogoCarta.bebidasBD();
//                                List<Bebida> listaRefrescos = new ArrayList<>();
//
//                                for (Bebida bebida : listaBebidaTmp) {
//                                    if (bebida.getTipoBebida().equals(TipoBebida.REFRESCOS)) {
//                                        listaRefrescos.add(bebida);
//                                    }
//                                }
                                String[] opcionesProductosRefresco = new String[listaRefrescos.size()];
                                MetodosProductos.mostrarProdBebida(listaRefrescos,
                                        opcionesProductosRefresco);

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
                                        Producto productoSeleccionadoRamen = listaRefrescos
                                                .get(Arrays.asList(opcionesProductosRefresco)
                                                        .indexOf(seleccionProducto));

                                        //añadimos una cantidad del producto seleccionado
                                        String cantidadStr = JOptionPane.showInputDialog("Introduce la cantidad del producto seleccionado que deseas añadir.");
                                        int cantidad = Integer.parseInt(cantidadStr);

                                        //comprobamos que no haya o no se pase
                                        if (cantidad > 0 && cantidad <= productoSeleccionadoRamen.getStock()) {
                                            // Añade la cantidad especificada del producto al carrito

                                            UtilidadesTPV.agregarAlCarrito(tpv, productoSeleccionadoRamen, cantidad);

                                            System.out.println("Producto añadido");
                                        } else {
                                            System.out.println("Cantidad no válida");
                                        }

                                    } else if (opcionElegida != 0) {
                                        System.out.println("volver");
                                        return;
                                    }
                                }
                            case "Alcoholicas":
                                listaBebidaTmp = tpv.getProductos();
                                List<Bebida> listaAlcoholicas = new ArrayList<>();

                                for (Producto bebida : listaBebidaTmp) {
                                    if (bebida instanceof Bebida bebidaAux) {
                                        if (bebidaAux.getTipoBebida().equals(TipoBebida.ALCOHOLICAS)) {
                                            listaAlcoholicas.add(bebidaAux);
                                        }
                                    }
                                }

//                                listaBebidaTmp = CatalogoCarta.bebidasBD();
//                                List<Bebida> listaAlcoholicas = new ArrayList<>();
//
//                                for (Bebida bebida : listaBebidaTmp) {
//                                    if (bebida.getTipoBebida().equals(TipoBebida.ALCOHOLICAS)) {
//                                        listaAlcoholicas.add(bebida);
//                                    }
//                                }
                                String[] opcionesProductosAlcoholicas = new String[listaAlcoholicas.size()];
                                MetodosProductos.mostrarProdBebida(listaAlcoholicas,
                                        opcionesProductosAlcoholicas);

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
                                        Producto productoSeleccionadoRamen = listaAlcoholicas
                                                .get(Arrays.asList(opcionesProductosAlcoholicas)
                                                        .indexOf(seleccionAlcoholicas));

                                        //añadimos una cantidad del producto seleccionado
                                        String cantidadStr = JOptionPane.showInputDialog("Introduce la cantidad del producto seleccionado que deseas añadir.");
                                        int cantidad = Integer.parseInt(cantidadStr);

                                        //comprobamos que no haya o no se pase
                                        if (cantidad > 0 && cantidad <= productoSeleccionadoRamen.getStock()) {
                                            // Añade la cantidad especificada del producto al carrito

                                            UtilidadesTPV.agregarAlCarrito(tpv, productoSeleccionadoRamen, cantidad);

                                            System.out.println("Producto añadido");
                                        } else {
                                            System.out.println("Cantidad no válida");
                                        }

                                    } else if (opcionElegida != 0) {
                                        System.out.println("volver");
                                        return;
                                    }
                                }
                            case "Otras":
                                listaBebidaTmp = tpv.getProductos();
                                List<Bebida> listaOtras = new ArrayList<>();

                                for (Producto bebida : listaBebidaTmp) {
                                    if (bebida instanceof Bebida bebidaAux) {
                                        if (bebidaAux.getTipoBebida().equals(TipoBebida.OTROS)) {
                                            listaOtras.add(bebidaAux);
                                        }
                                    }
                                }
//                                listaBebidaTmp = CatalogoCarta.bebidasBD();
//                                List<Bebida> listaOtras = new ArrayList<>();
//
//                                for (Bebida bebida : listaBebidaTmp) {
//                                    if (bebida.getTipoBebida().equals(TipoBebida.OTROS)) {
//                                        listaOtras.add(bebida);
//                                    }
//                                }

                                String[] opcionesProductosOtras = new String[listaOtras.size()];
                                MetodosProductos.mostrarProdBebida(listaOtras, opcionesProductosOtras);

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
                                        Producto productoSeleccionadoRamen = listaOtras
                                                .get(Arrays.asList(opcionesProductosOtras)
                                                        .indexOf(seleccionOtras));

                                        //añadimos una cantidad del producto seleccionado
                                        String cantidadStr = JOptionPane.showInputDialog("Introduce la cantidad del producto seleccionado que deseas añadir.");
                                        int cantidad = Integer.parseInt(cantidadStr);

                                        //comprobamos que no haya o no se pase
                                        if (cantidad > 0 && cantidad <= productoSeleccionadoRamen.getStock()) {
                                            // Añade la cantidad especificada del producto al carrito

                                            UtilidadesTPV.agregarAlCarrito(tpv, productoSeleccionadoRamen, cantidad);

                                            System.out.println("Producto añadido");
                                        } else {
                                            System.out.println("Cantidad no válida");
                                        }

                                    } else if (opcionElegida != 0) {
                                        System.out.println("volver");
                                        return;
                                    }
                                }
                                break;

                        }
                    } else if (nombreCategoria.equalsIgnoreCase("postres")) {
                        String[] opcionesSubCategorias = {"Mochis", "Frutitas", "Otros", "Volver"};
                        //mensaje de JOptionPane par mostrar las opciones de comida
                        int opcionSubCategorias = JOptionPane.showOptionDialog(null,
                                "Seleccione una opción",
                                "Wok and Roll -- DAWFOOD -- Modo Usuario",
                                JOptionPane.DEFAULT_OPTION,
                                JOptionPane.PLAIN_MESSAGE, null,
                                opcionesSubCategorias, opcionesSubCategorias[0]);

                        //switch segun el tipo de bebida
                        List<Producto> listaPostreTmp = tpv.getProductos();

                        switch (opcionesSubCategorias[opcionSubCategorias]) {

                            case "Mochis":
                                listaPostreTmp = tpv.getProductos();
                                List<Postre> listaPostres = new ArrayList<>();

                                for (Producto postre : listaPostreTmp) {
                                    if (postre instanceof Postre postreAux) {
                                        if (postreAux.getTipoPostre().equals(TipoPostre.MOCHI)) {
                                            listaPostreTmp.add(postreAux);
                                        }
                                    }
                                }

//                                listaPostreTmp = CatalogoCarta.postresBD();
//                                List<Postre> listaPostres = new ArrayList<>();
//
//                                for (Postre postre : listaPostreTmp) {
//                                    if (postre.getTipoPostre().equals(TipoPostre.MOCHI)) {
//                                        listaPostres.add(postre);
//                                    }
//                                }
                                String[] opcionesProductosMochi = new String[listaPostres.size()];
                                MetodosProductos.mostrarProdPostre(listaPostres,
                                        opcionesProductosMochi);

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
                                        Producto productoSeleccionadoMochi = listaPostres
                                                .get(Arrays.asList(opcionesProductosMochi)
                                                        .indexOf(seleccionProductoPostre));

                                        //añadimos una cantidad del producto seleccionado
                                        String cantidadStr = JOptionPane.showInputDialog("Introduce la cantidad del producto seleccionado que deseas añadir.");
                                        int cantidad = Integer.parseInt(cantidadStr);

                                        //comprobamos que no haya o no se pase
                                        if (cantidad > 0 && cantidad <= productoSeleccionadoMochi.getStock()) {
                                            // Añade la cantidad especificada del producto al carrito

                                            UtilidadesTPV.agregarAlCarrito(tpv, productoSeleccionadoMochi, cantidad);

                                            System.out.println("Producto añadido");
                                        } else {
                                            System.out.println("Cantidad no válida");
                                        }

                                    } else if (opcionElegida != 0) {
                                        System.out.println("volver");
                                        return;
                                    }
                                }

                            case "Frutitas":

                                listaPostreTmp = tpv.getProductos();
                                List<Postre> listaFrutitas = new ArrayList<>();

                                for (Producto postre : listaPostreTmp) {
                                    if (postre instanceof Postre postreAux) {
                                        if (postreAux.getTipoPostre().equals(TipoPostre.FRUTITA)) {
                                            listaPostreTmp.add(postreAux);
                                        }
                                    }
                                }
//                                listaPostreTmp = CatalogoCarta.postresBD();
//                                List<Postre> listaFrutitas = new ArrayList<>();
//
//                                for (Postre postre : listaPostreTmp) {
//                                    if (postre.getTipoPostre().equals(TipoPostre.FRUTITA)) {
//                                        listaFrutitas.add(postre);
//                                    }
//                                }

                                String[] opcionesProductosFrutitas = new String[listaFrutitas.size()];
                                MetodosProductos.mostrarProdPostre(listaFrutitas,
                                        opcionesProductosFrutitas);

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
                                        Producto productoSeleccionadoRamen = listaFrutitas
                                                .get(Arrays.asList(opcionesProductosFrutitas)
                                                        .indexOf(seleccionFrutitas));

                                        //añadimos una cantidad del producto seleccionado
                                        String cantidadStr = JOptionPane.showInputDialog("Introduce la cantidad del producto seleccionado que deseas añadir.");
                                        int cantidad = Integer.parseInt(cantidadStr);

                                        //comprobamos que no haya o no se pase
                                        if (cantidad > 0 && cantidad <= productoSeleccionadoRamen.getStock()) {
                                            // Añade la cantidad especificada del producto al carrito

                                            UtilidadesTPV.agregarAlCarrito(tpv, productoSeleccionadoRamen, cantidad);

                                            System.out.println("Producto añadido");
                                        } else {
                                            System.out.println("Cantidad no válida");
                                        }

                                    } else if (opcionElegida != 0) {
                                        System.out.println("volver");
                                        return;
                                    }
                                }
                            case "Otros":
                                listaPostreTmp = tpv.getProductos();
                                List<Postre> listaOtras = new ArrayList<>();

                                for (Producto postre : listaPostreTmp) {
                                    if (postre instanceof Postre postreAux) {
                                        if (postreAux.getTipoPostre().equals(TipoPostre.OTROS)) {
                                            listaPostreTmp.add(postreAux);
                                        }
                                    }
                                }
//                                listaPostreTmp = CatalogoCarta.postresBD();
//                                List<Postre> listaOtras = new ArrayList<>();
//
//                                for (Postre postre : listaPostreTmp) {
//                                    if (postre.getTipoPostre().equals(TipoPostre.OTROS)) {
//                                        listaOtras.add(postre);
//                                    }
//                                }

                                String[] opcionesProductosOtros = new String[listaOtras.size()];
                                MetodosProductos.mostrarProdPostre(listaOtras,
                                        opcionesProductosOtros);

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
                                        Producto productoSeleccionadoOtros = listaOtras
                                                .get(Arrays.asList(opcionesProductosOtros)
                                                        .indexOf(seleccionOtros));

                                        //añadimos una cantidad del producto seleccionado
                                        String cantidadStr = JOptionPane.showInputDialog("Introduce la cantidad del producto seleccionado que deseas añadir.");
                                        int cantidad = Integer.parseInt(cantidadStr);

                                        //comprobamos que no haya o no se pase
                                        if (cantidad > 0 && cantidad <= productoSeleccionadoOtros.getStock()) {
                                            // Añade la cantidad especificada del producto al carrito

                                            UtilidadesTPV.agregarAlCarrito(tpv, productoSeleccionadoOtros, cantidad);

                                            System.out.println("Producto añadido");
                                        } else {
                                            System.out.println("Cantidad no válida");
                                        }

                                    } else if (opcionElegida != 0) {
                                        System.out.println("volver");
                                        return;
                                    }
                                }
                                break;

                        }
                    }

                    break;
                //si elige salir vuelve al menú de anterior
                case "Volver":
                    System.out.println("volver a categorías");
                    return;
            }

        } while (!salirCategorias);
    }

    public static void apagarTPV(TPV tpv, List<Producto> productosTPV) {
        if (!productosTPV.isEmpty()) {
            //obtenemos la lista del menu
//            List<Producto> catalogo = CatalogoCarta.cartaMenu();
            List<Producto> catalogo = tpv.getProductos();

            for (Producto productoAux : productosTPV) {
                //comprobamos que el producto ya exista
                boolean productoEnCatalogo = false;

                for (Producto productoCatalogo : catalogo) {
                    //hacemos instanceof para buscar cada clase hija de Producto
                    if (productoCatalogo instanceof Comida comidaAux) {
                        if (productoCatalogo.getCodProducto().equals(comidaAux.getCodProducto())) {
                            productoCatalogo.setNombre(comidaAux.getNombre());
                            ((Comida) productoCatalogo).setDescripcionComida(comidaAux.getDescripcionComida());
                            ((Comida) productoCatalogo).setTipoComida(comidaAux.getTipoComida());
                            productoCatalogo.setPrecio(comidaAux.getPrecio());
                            productoCatalogo.setStock(comidaAux.getStock());
                            productoCatalogo.setTipoIVA(comidaAux.getTipoIVA());

                        }
                    } else if (productoCatalogo instanceof Bebida bebidaAux) {
                        if (productoCatalogo.getCodProducto().equals(bebidaAux.getCodProducto())) {
                            productoCatalogo.setNombre(bebidaAux.getNombre());
                            ((Bebida) productoCatalogo).setTamanioBebida(bebidaAux.getTamanioBebida());
                            ((Bebida) productoCatalogo).setTipoBebida(bebidaAux.getTipoBebida());
                            productoCatalogo.setPrecio(bebidaAux.getPrecio());
                            productoCatalogo.setStock(bebidaAux.getStock());
                            productoCatalogo.setTipoIVA(bebidaAux.getTipoIVA());

                        }
                    } else if (productoCatalogo instanceof Postre postreAux) {
                        if (productoCatalogo.getCodProducto().equals(postreAux.getCodProducto())) {
                            productoCatalogo.setNombre(postreAux.getNombre());
                            ((Postre) productoCatalogo).setKcal(postreAux.getKcal());
                            ((Postre) productoCatalogo).setTipoPostre(postreAux.getTipoPostre());
                            productoCatalogo.setPrecio(postreAux.getPrecio());
                            productoCatalogo.setStock(postreAux.getStock());
                            productoCatalogo.setTipoIVA(postreAux.getTipoIVA());

                        }
                    }
                    for (Producto producto : catalogo) {
                        System.out.println(" | "+ producto);
                    }
                    break;
                }

                //si el producto no existe se agrega
                if (!productoEnCatalogo) {
                    catalogo.add(productoAux);
                }
            }

            //borramos la lista del tpv para que al iniciar no cree confictos
            productosTPV.clear();
        }
    }

    public static void gestionarTPV() {
        String[] opciones = {"Encender TPV", "Apagar TPV"};
        boolean continuar = false;
        //Creamos el TPV
        TPV tpv = new TPV();
        //Creamos la lista de productos
        List<Producto> productosTPV = CatalogoCarta.cartaMenu();

        while (!continuar) {
            int respuesta = JOptionPane.showOptionDialog(null,
                    "¿Quieres encender o apagar el TPV?",
                    "TPV",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.PLAIN_MESSAGE, null,
                    opciones, opciones[0]);

            if (respuesta != 1) {
                encenderTPV(tpv);
            } else if (respuesta != 0) {
                apagarTPV(tpv, productosTPV);
                continuar = true;
            }
        }
    }

}
