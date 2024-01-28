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
public class MetodosAdmin2 {

    public static String pedirContrasenia() {
        String contrasenia = JOptionPane.showInputDialog("Introduce la contraseña.");
        return contrasenia;
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
            String opcionesUsuarioAdmin = MetodosAdmin2.opcionesUsuarioAdministrador();

            //switch con las diferentes opciones dadas
            switch (opcionesUsuarioAdmin) {
                //con cada opcion llamamos a su método correspondiente
                //si elige salir vuelve al menú de inicio
                case "Modificar producto" -> {
                    String opciones = MetodosProductos.elegirCategoria();
                    switch (opciones) {
                        case "Comidas":
                            List<Producto> lista = tpv.getProductos();
                            String[] opcionesProductos = new String[lista.size()];
                            MetodosProductos.mostrarProductosComida(lista, opcionesProductos);

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
                                    Producto productoSeleccionado = tpv.getProductos()
                                            .get(Arrays.asList(opcionesProductos)
                                                    .indexOf(seleccionProducto));

                                    //metodos para pedir que modificar y tal
                                    MetodosAdmin2.modificarComida((Comida) productoSeleccionado,
                                            MetodosProductos.elegirCategoriaACambiarComdia());
                                } else if (opcionElegida != 0) {
                                    System.out.println("volver");
                                    return;
                                }
                            }
                            break;
                        case "Bebidas":
                            List<Producto> listaBebidas = tpv.getProductos();
                            String[] opcionesProductosBebidas = new String[listaBebidas.size()];
                            MetodosProductos.mostrarProductosBebida(listaBebidas, opcionesProductosBebidas);

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
                                    /*AQUI PETA*/
                                    Producto productoSeleccionado = tpv.getProductos()
                                            .get(Arrays.asList(opcionesProductosBebidas)
                                                    .indexOf(opcionesProductosBebidas));

                                    //metodos para pedir que modificar y tal
                                    MetodosAdmin2.modificarBebida((Bebida) productoSeleccionado,
                                            MetodosProductos.elegirCategoriaACambiarBebida());
                                } else if (opcionElegida != 0) {
                                    System.out.println("volver");
                                    return;
                                }
                            }
                            break;

                        case "Postres":

                            List<Producto> listaPostre = tpv.getProductos();
                            String[] opcionesProductosPostre = new String[listaPostre.size()];
                            MetodosProductos.mostrarProductosPostre(listaPostre, opcionesProductosPostre);

                            String seleccionProductoPostre = (String) JOptionPane.showInputDialog(null,
                                    "Selecciona un producto",
                                    "Wok and Roll -- DAWFOOD --",
                                    JOptionPane.QUESTION_MESSAGE,
                                    null,
                                    opcionesProductosPostre,
                                    opcionesProductosPostre[0]);

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
                                    Producto productoSeleccionado = tpv.getProductos()
                                            .get(Arrays.asList(opcionesProductosPostre)
                                                    .indexOf(opcionesProductosPostre));

                                    //metodos para pedir que modificar y tal
                                    MetodosAdmin2.modificarPostre((Postre) productoSeleccionado,
                                            MetodosProductos.elegirCategoriaACambiarPostre());
                                } else if (opcionElegida != 0) {
                                    System.out.println("volver");
                                    return;
                                }
                            }

                        //si elige salir vuelve al menú de anterior
                        case "Salir":
                            System.out.println("volver a categorías");
                            return;
                    }
                }

                case "Dar de alta un producto" -> {
                    System.out.println("Dar de alta un producto");
                    String elegirCategoria = MetodosProductos.elegirCategoria();
                    switch (elegirCategoria) {
                        case "Comidas" -> {

                            tpv.getProductos().add(crearComida());
                        }
                        case "Bebidas" -> {
                            tpv.getProductos().add(crearBebida());
                        }
                        case "Postres" -> {
                            tpv.getProductos().add(crearPostre());
                        }
                        case "Salir" -> {
                            System.out.println("Volviendo al menú de mantenimiento");
                            return;
                        }
                    }
//                    MetodosAdmin.altaProducto(tpv.getProductos(), productoNuevo);
                }
                case "Borrar producto" -> {

//                    CatalogoCarta catalogo = CatalogoCarta getCarta();
//                    
//                    MetodosAdmin.bajaProducto(tpv.getProductos(), productoABorrar);
                }
                case "Ver ventas" -> {
                    System.out.println("Ver ventas de hoy");
                    MetodosAdmin2.consultarTicketsFecha(tpv, LocalDateTime.now());
                }
                case "Salir" -> {
                    System.out.println("volver a inicio");
                    salirAdmin = true;
                }
            }

        } while (!salirAdmin);
    }

    //método para ver las opciones del usuario administrador
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

    //método que le pasas un Producto de tipo Comida y un String aux y elige que atributos de la comida cambiar
    public static void modificarComida(Comida comidaAux, String tmp) {
        //si deja algo en null no se cambiará
        if (comidaAux != null && tmp != null) {
            switch (tmp) {
                case "Nombre" -> {
                    String nuevoNombre = JOptionPane.showInputDialog(
                            "Introduce el nuevo nombre");
                    comidaAux.setNombre(nuevoNombre);
                }
                //atributo propio de la comida
                case "Descripcion" -> {
                    String nuevaDescripcion = JOptionPane.showInputDialog(
                            "Introduce la nueva descripción del producto");
                    comidaAux.setDescripcionComida(nuevaDescripcion);
                }
                case "Precio sin IVA" -> {
                    double nuevoPrecioSinIVA;
                    try {
                        String nuevoPrecio = JOptionPane.showInputDialog(
                                "Introduce el nuevo precio");
                        if (nuevoPrecio != null) {
                            //parseamos el string introducido para comprobar que es un double
                            nuevoPrecioSinIVA = Double.parseDouble(nuevoPrecio);
                            comidaAux.setPrecio(nuevoPrecioSinIVA);
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
                //atributo propio de la comida
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

    //método que le pasas un Producto de tipo Bebida y un String aux y elige que atributos de la bebida cambiar
    public static void modificarBebida(Bebida bebidaAux, String tmp) {
        //si deja algo en null no se cambiará
        if (bebidaAux != null && tmp != null) {
            switch (tmp) {
                case "Nombre" -> {
                    String nuevoNombre = JOptionPane.showInputDialog(
                            "Introduce el nuevo nombre para "
                            + bebidaAux.getNombre());
                    bebidaAux.setNombre(nuevoNombre);
                }
                //atributo propio de la bebida
                case "Tamanio Bebida" -> {
                    int nuevoStock = 0;
                    try {
                        nuevoStock = Integer.parseInt(
                                JOptionPane.showInputDialog(
                                        "Introduce el nuevo tamaño del producto"));
                    } catch (NumberFormatException nfe) {
                        System.out.println("Introduce un número entero");
                    }
                    bebidaAux.setStock(nuevoStock);
                }
                case "Precio sin IVA" -> {
                    double nuevoPrecioSinIVA;
                    try {
                        String nuevoPrecio = JOptionPane.showInputDialog(
                                "Introduce el nuevo precio");
                        if (nuevoPrecio != null) {
                            //parseamos el string introducido para comprobar que es un double
                            nuevoPrecioSinIVA = Double.parseDouble(nuevoPrecio);
                            bebidaAux.setPrecio(nuevoPrecioSinIVA);
                        } else {
                            System.out.println("No has introducido número decimal");
                        }
                    } catch (NumberFormatException nfe) {
                        System.out.println("No has introducido número decimal");
                    }
                }
                case "IVA" -> {
                    bebidaAux.setTipoIVA(MetodosProductos.elegirTipoIVA());
                }
                case "Tipo de Bebida" -> {
                    bebidaAux.setTipoBebida(MetodosProductos.elegirTipoBebida());
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
                    bebidaAux.setStock(nuevoStock);
                }
            }
        }
    }

    //método que le pasas un Producto de tipo Postre y un String aux y elige que atributos de la postre cambiar
    public static void modificarPostre(Postre postreAux, String tmp) {
        //si deja algo en null no se cambiará
        if (postreAux != null && tmp != null) {
            switch (tmp) {
                case "Nombre" -> {
                    String nuevoNombre = JOptionPane.showInputDialog(
                            "Introduce el nuevo nombre para "
                            + postreAux.getNombre());
                    postreAux.setNombre(nuevoNombre);
                }
                //atributo propio de la bebida
                case "Kcal" -> {
                    int nuevoStock = 0;
                    try {
                        nuevoStock = Integer.parseInt(
                                JOptionPane.showInputDialog(
                                        "Introduce el nuevo tamaño del producto"));
                    } catch (NumberFormatException nfe) {
                        System.out.println("Introduce un número entero");
                    }
                    postreAux.setStock(nuevoStock);
                }
                case "Precio sin IVA" -> {
                    double nuevoPrecioSinIVA;
                    try {
                        String nuevoPrecio = JOptionPane.showInputDialog(
                                "Introduce el nuevo precio");
                        if (nuevoPrecio != null) {
                            //parseamos el string introducido para comprobar que es un double
                            nuevoPrecioSinIVA = Double.parseDouble(nuevoPrecio);
                            postreAux.setPrecio(nuevoPrecioSinIVA);
                        } else {
                            System.out.println("No has introducido número decimal");
                        }
                    } catch (NumberFormatException nfe) {
                        System.out.println("No has introducido número decimal");
                    }
                }
                case "IVA" -> {
                    postreAux.setTipoIVA(MetodosProductos.elegirTipoIVA());
                }
                case "Tipo de Postre" -> {
                    postreAux.setTipoPostre(MetodosProductos.elegirTipoPostre());
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
                    postreAux.setStock(nuevoStock);
                }
            }
        }
    }

    //método para crear un nuevo Producto de tipo Comida introduciendo los datos
    public static Comida crearComida() {
        Comida aux = new Comida();
        //inicializamos primero los valores
        String nuevoNombre = "";
        String nuevaDescripcion = "";
        int nuevoStock;
        double nuevoPrecioSinIVA;

        //si deja algo en null no se cambiará
        try {
            nuevoNombre = JOptionPane.showInputDialog(
                    "Introduce el nuevo nombre");
            aux.setNombre(nuevoNombre.trim());
            //atributo propio de la comida
            nuevaDescripcion = JOptionPane.showInputDialog(
                    "Introduce la nueva descripción del producto");
            aux.setDescripcionComida(nuevaDescripcion.trim());

            System.out.println("No dejes nada en blanco");

            nuevoStock = Integer.parseInt(JOptionPane.showInputDialog(
                    "Introduce el nuevo stock del producto"));
            aux.setStock(nuevoStock);

            try {
                String nuevoPrecio = JOptionPane.showInputDialog(
                        "Introduce el nuevo precio");
                if (nuevoPrecio != null) {
                    //parseamos el string introducido para comprobar que es un double
                    nuevoPrecioSinIVA = Double.parseDouble(nuevoPrecio);
                    aux.setPrecio(nuevoPrecioSinIVA);
                } else {
                    System.out.println("No has introducido número decimal");
                }
            } catch (NumberFormatException nfe) {
                System.out.println("No has introducido número decimal");
            }

        } catch (NumberFormatException nfe) {

        }
        aux.setTipoComida(MetodosProductos.elegirTipoComida());
        aux.setTipoIVA(MetodosProductos.elegirTipoIVA());

        return aux;
    }
    //método para crear un Producto de tipo Bebida

    public static Bebida crearBebida() {
        Bebida bebidaAux = new Bebida();
        //inicializamos primero los valores
        String nuevoNombre = "";
        String nuevaDescripcion = "";
        int nuevoStock = 0;
        double nuevoPrecioSinIVA;
        nuevoNombre = JOptionPane.showInputDialog(
                "Introduce el nuevo nombre para ");
        bebidaAux.setNombre(nuevoNombre);

        try {
            nuevoStock = Integer.parseInt(
                    JOptionPane.showInputDialog(
                            "Introduce el nuevo tamaño del producto"));
        } catch (NumberFormatException nfe) {
            System.out.println("Introduce un número entero");
        }
        bebidaAux.setStock(nuevoStock);

        try {
            String nuevoPrecio = JOptionPane.showInputDialog(
                    "Introduce el nuevo precio");
            if (nuevoPrecio != null) {
                //parseamos el string introducido para comprobar que es un double
                nuevoPrecioSinIVA = Double.parseDouble(nuevoPrecio);
                bebidaAux.setPrecio(nuevoPrecioSinIVA);
            } else {
                System.out.println("No has introducido número decimal");
            }
        } catch (NumberFormatException nfe) {
            System.out.println("No has introducido número decimal");
        }

        bebidaAux.setTipoIVA(MetodosProductos.elegirTipoIVA());

        bebidaAux.setTipoBebida(MetodosProductos.elegirTipoBebida());

        try {
            nuevoStock = Integer.parseInt(
                    JOptionPane.showInputDialog(
                            "Introduce el nuevo stock del producto"));
        } catch (NumberFormatException nfe) {
            System.out.println("Introduce un número entero");
        }
        bebidaAux.setStock(nuevoStock);
        return bebidaAux;
    }

    //método para crear un Producto de tipo Postre 
    public static Postre crearPostre() {
        Postre postreAux = new Postre();
        //inicializamos primero los valores
        String nuevoNombre = "";
        String nuevaDescripcion = "";
        int nuevoStock = 0;
        double nuevoPrecioSinIVA;

        nuevoNombre = JOptionPane.showInputDialog(
                "Introduce el nuevo nombre para ");
        postreAux.setNombre(nuevoNombre);

        try {
            nuevoStock = Integer.parseInt(
                    JOptionPane.showInputDialog(
                            "Introduce el nuevo tamaño del producto"));
        } catch (NumberFormatException nfe) {
            System.out.println("Introduce un número entero");
        }
        postreAux.setStock(nuevoStock);

        try {
            String nuevoPrecio = JOptionPane.showInputDialog(
                    "Introduce el nuevo precio");
            if (nuevoPrecio != null) {
                //parseamos el string introducido para comprobar que es un double
                nuevoPrecioSinIVA = Double.parseDouble(nuevoPrecio);
                postreAux.setPrecio(nuevoPrecioSinIVA);
            } else {
                System.out.println("No has introducido número decimal");
            }
        } catch (NumberFormatException nfe) {
            System.out.println("No has introducido número decimal");
        }

        postreAux.setTipoIVA(MetodosProductos.elegirTipoIVA());

        postreAux.setTipoPostre(MetodosProductos.elegirTipoPostre());

        try {
            nuevoStock = Integer.parseInt(
                    JOptionPane.showInputDialog(
                            "Introduce el nuevo stock del producto"));
        } catch (NumberFormatException nfe) {
            System.out.println("Introduce un número entero");
        }
        postreAux.setStock(nuevoStock);

        return postreAux;
    }
}
