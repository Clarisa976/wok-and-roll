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

    public static String pedirContrasenia() {
        String contrasenia = JOptionPane.showInputDialog("Introduce la contraseña.");
        return contrasenia;
    }

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

    public static void modoMantenimiento(TPV tpv) {
        boolean salirAdmin = false;

        //iniciamos el bucle
        do {
            String opcionesUsuarioAdmin = MetodosAdmin.opcionesUsuarioAdministrador();

            //switch con las diferentes opciones dadas
            switch (opcionesUsuarioAdmin) {
                //con cada opcion llamamos a su método correspondiente
                //si elige salir vuelve al menú de inicio
                case "Modificar producto" -> {
                    String opciones = MetodosAdmin.elegirCategoria();
                    switch (opciones) {
                        case "Ver comidas":
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

                                String[] opcionesElegidas = {"Modificar", "Volver"};
                                int opcionElegida = JOptionPane.showOptionDialog(null,
                                        "¿Qué deseas hacer con este producto?",
                                        "Wok and Roll -- DAWFOOD --",
                                        JOptionPane.YES_NO_OPTION,
                                        JOptionPane.QUESTION_MESSAGE,
                                        null,
                                        opcionesElegidas,
                                        opcionesElegidas[0]);

                                if (opcionElegida == 0) {
                                    //creamos un producto auxiliar para modificarlo
                                    Comida productoSeleccionado = CatalogoCarta.comidasBD()
                                            .get(Arrays.asList(opcionesProductos)
                                                    .indexOf(seleccionProducto));
                                    //metodos para pedir que modificar y tal
                                    
                                    MetodosAdmin.modificarComida(productoSeleccionado, 
                                            MetodosProductos.elegirCategoriaACambiar());
                                    System.out.println("producto añadido pa modificar");
                                } else if (opcionElegida != 0) {
                                    System.out.println("volver");
                                    return;
                                }
                            }
                            break;
                        case "Ver bebidas":
                            List<Bebida> listaBebida = CatalogoCarta.bebidasBD();
                            String[] opcionesProductosBebidas = new String[listaBebida.size()];

                            mostrarProdBebida(listaBebida, opcionesProductosBebidas);

                            String seleccionProductoBebidas = (String) JOptionPane.showInputDialog(null,
                                    "Selecciona un producto",
                                    "Wok and Roll -- DAWFOOD -- Modo mantenimiento",
                                    JOptionPane.QUESTION_MESSAGE,
                                    null,
                                    opcionesProductosBebidas,
                                    opcionesProductosBebidas[0]);

                            if (seleccionProductoBebidas != null) {
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
                                    //creamos un producto auxiliar para modificarlo
                                    Producto productoSeleccionado = listaBebida
                                            .get(Arrays.asList(seleccionProductoBebidas)
                                                    .indexOf(opcionesProductosBebidas));
                                    //metodos para pedir que modificar y tal
                                    System.out.println("producto añadido pa modificar");
                                } else if (opcionElegida != 0) {
                                    System.out.println("volver");
                                    return;
                                }
                            }
                            break;

                        case "Ver postres":

                            List<Postre> listaPostre = CatalogoCarta.postresBD();
                            String[] opcionesProductosPostres = new String[listaPostre.size()];
                            mostrarProdPostre(listaPostre, opcionesProductosPostres);

                            String seleccionProductoPostre = (String) JOptionPane.showInputDialog(null,
                                    "Selecciona un producto",
                                    "Wok and Roll -- DAWFOOD --",
                                    JOptionPane.QUESTION_MESSAGE,
                                    null,
                                    opcionesProductosPostres,
                                    opcionesProductosPostres[0]);

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
                                    //creamos un producto auxiliar para modificarlo
                                    Producto productoSeleccionado = listaPostre
                                            .get(Arrays.asList(seleccionProductoPostre)
                                                    .indexOf(opcionesProductosPostres));
                                    
                                    //metodos para pedir que modificar y tal
                                    System.out.println("producto añadido pa modificar");
                                } else if (opcionElegida != 0) {
                                    System.out.println("volver");
                                    return;
                                }
                            }
                            break;

                        //si elige salir vuelve al menú de anterior
                        case "Volver":
                            System.out.println("volver a categorías");
                            return;
                    }
                }

//
//                    System.out.println("Modificar producto");
//                    MetodosAdmin.modificarProducto(aux);
                case "Dar de alta un producto" -> {
                    System.out.println("Dar de alta un producto");
//                    MetodosAdmin.altaProducto(tpv.getProductos(), productoNuevo);
                }
                case "Borrar producto" -> {

//                    CatalogoCarta catalogo = CatalogoCarta getCarta();
//                    
//                    MetodosAdmin.bajaProducto(tpv.getProductos(), productoABorrar);
                }
                case "Ver ventas" -> {
                    System.out.println("Ver ventas de hoy");
                    MetodosAdmin.consultarTicketsFecha(tpv, LocalDateTime.now());
                }
                case "Salir" -> {
                    System.out.println("volver a inicio");
                    salirAdmin = true;
                }
            }

        } while (!salirAdmin);
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

    //métodos
    public static String elegirCategoria() {
        String[] opcionesCategoria = {"Ver comidas", "Ver bebidas",
            "Ver postres", "Salir"};
        //mensaje de JOptionPane par mostrar dichas opciones
        String opcionCategoria = (String) JOptionPane.showInputDialog(null,
                "Seleccione una opción",
                "Wok and Roll -- DAWFOOD",
                JOptionPane.QUESTION_MESSAGE, null,
                opcionesCategoria, opcionesCategoria[0]);
        if (!opcionCategoria.equals(null)) {
            return opcionCategoria;
        } else {
            return opcionCategoria = "Salir";
        }
    }

    public static String elegirSubcategoriaComida() {
        String[] opcionesSubcategoriaComdia = {"Ramen", "Sushi", "Wok"};

        String opcionSubcategoriaComdia = (String) JOptionPane.showInputDialog(null,
                "Seleccione una opción",
                "Wok and Roll -- DAWFOOD",
                JOptionPane.QUESTION_MESSAGE, null,
                opcionesSubcategoriaComdia, opcionesSubcategoriaComdia[0]);
        if (!opcionSubcategoriaComdia.equals(null)) {
            return opcionSubcategoriaComdia;
        } else {
            return opcionSubcategoriaComdia = "Salir";
        }
    }

    public static String elegirSubcategoriaBebidas() {
        String[] opcionesSubcategoriaBebidas = {"Refrescos", "Alcoholicas", "Otras"};

        String opcionSubcategoria = (String) JOptionPane.showInputDialog(null,
                "Seleccione una opción",
                "Wok and Roll -- DAWFOOD",
                JOptionPane.QUESTION_MESSAGE, null,
                opcionesSubcategoriaBebidas, opcionesSubcategoriaBebidas[0]);
        if (!opcionSubcategoria.equals(null)) {
            return opcionSubcategoria;
        } else {
            return opcionSubcategoria = "Salir";
        }
    }

    public static String elegirSubcategoriaPostres() {
        String[] opcionesSubcategoriaPostre = {"Mochis", "Frutitas", "Otros"};

        String opcionSubcategoria = (String) JOptionPane.showInputDialog(null,
                "Seleccione una opción",
                "Wok and Roll -- DAWFOOD",
                JOptionPane.QUESTION_MESSAGE, null,
                opcionesSubcategoriaPostre, opcionesSubcategoriaPostre[0]);
        if (!opcionSubcategoria.equals(null)) {
            return opcionSubcategoria;
        } else {
            return opcionSubcategoria = "Salir";
        }
    }

    public static String opcionesUsuarioAdministrador() {
        //creamos las opciones del admin
        String[] opcionesUsuarioAdmin = {"Modificar producto", "Dar de alta un producto",
            "Borrar producto", "Ver ventas", "Salir"};
        //mensaje de JOptionPane par mostrar dichas opciones
        String opcionUsuarioAdmin = (String) JOptionPane.showInputDialog(null,
                "Seleccione una opción",
                "Wok and Roll -- DAWFOOD -- Modo Mantenimiento",
                JOptionPane.QUESTION_MESSAGE, null,
                opcionesUsuarioAdmin, opcionesUsuarioAdmin[0]);
        if (!opcionUsuarioAdmin.equals(null)) {
            return opcionUsuarioAdmin;
        } else {
            return opcionUsuarioAdmin = "Salir";
        }
    }

    public static void modificarComida(Comida comidaAux, String tmp) {
        //si deja algo en null no se cambiará
        if (comidaAux != null && tmp != null) {
            switch (tmp) {
                case "Nombre" -> {
                    String nuevoNombre = JOptionPane.showInputDialog(
                            "Introduce el nuevo nombre para " 
                            + comidaAux.getNombre());
                    comidaAux.setNombre(nuevoNombre);
                    System.out.println(comidaAux.getNombre());
                }
                case "Descripcion" -> {
                    String nuevaDescripcion = JOptionPane.showInputDialog(
                            "Introduce la nueva descripción del producto");
                    comidaAux.setDescripcionComida(nuevaDescripcion);
                }
                case "Precio sin IVA" -> {
                    double nuevoPrecioSinIVA;
                    try {
                        String nuevoPrecio = JOptionPane.showInputDialog(
                                "Introduce el nuevo precio sin IVA");
                        if (nuevoPrecio != null) {
                            //parseamos el string introducido para comprobar que es un double
                            nuevoPrecioSinIVA = Double.parseDouble(nuevoPrecio);
                            comidaAux.setPrecioSinIVA(nuevoPrecioSinIVA);
                        } else {
                            System.out.println("No has introducido número decimal");
                        }
                    } catch (NumberFormatException nfe) {
                        System.out.println("No has introducido número decimal");
                    }
                }
                case "IVA" -> {
                    comidaAux.setTipoIVA(MetodosProductos.elegirTipoIVA());
                }
                case "Tipo de Comida" -> {
                    comidaAux.setTipoComida(MetodosProductos.elegirTipoComida());
                }
                case "Stock" -> {
                    int nuevoStock = 0;
                    try {
                        nuevoStock = Integer.parseInt(
                                JOptionPane.showInputDialog(
                                        "Introduce el nuevo stock del producto"));
                    } catch (NumberFormatException nfe) {
                        System.out.println("Introduce un número entero");
                    }
                    comidaAux.setStock(nuevoStock);
                }


                
            }
        }
    }

}
