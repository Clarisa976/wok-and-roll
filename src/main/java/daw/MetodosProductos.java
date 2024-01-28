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
public class MetodosProductos {

    //método para mostrar un desplegable del enum de comida
    public static TipoComida elegirTipoComida() {
        Object[] opciones = TipoComida.values();

        TipoComida eleccion = (TipoComida) JOptionPane.showInputDialog(null,
                "Elige la subcategoría",
                "Selección de subcategoría",
                JOptionPane.QUESTION_MESSAGE, null,
                opciones, opciones[0]);
        return eleccion;
    }

    //mismo método pero en lugar de un enum sale un String
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

    //método para mostrar un desplegable del enum de postre
    public static TipoPostre elegirTipoPostre() {
        Object[] opciones = TipoPostre.values();

        TipoPostre eleccion = (TipoPostre) JOptionPane.showInputDialog(null,
                "Elige la subcategoría",
                "Selección de subcategoría",
                JOptionPane.QUESTION_MESSAGE, null,
                opciones, opciones[0]);
        return eleccion;
    }

    //mismo método pero con un String en lugar del enum
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

    //método para mostrar un desplegable del enum de bebida
    public static TipoBebida elegirTipoBebida() {
        Object[] opciones = TipoBebida.values();

        TipoBebida eleccion = (TipoBebida) JOptionPane.showInputDialog(null,
                "Elige la subcategoría",
                "Selección de subcategoría",
                JOptionPane.QUESTION_MESSAGE, null,
                opciones, opciones[0]);
        return eleccion;
    }

    //mismo método pero para que salga un string en lugar del enum
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

    //método par amostrar un desplegable con el enum del IVA
    public static TipoIVA elegirTipoIVA() {
        TipoIVA[] opciones = TipoIVA.values();

        TipoIVA eleccion = (TipoIVA) JOptionPane.showInputDialog(null,
                "Elige el IVA",
                "Selección del IVA",
                JOptionPane.QUESTION_MESSAGE, null,
                opciones, opciones[0]);
        return eleccion;
    }

    //método string para elegir las opciones de la Comida
    public static String elegirCategoriaACambiarComdia() {
        String[] opcionesElegidas = {"Nombre", "Descripcion", "Precio sin IVA", "IVA",
            "Tipo de Comida", "Stock", "Volver"};

        String opcionElegida = (String) JOptionPane.showInputDialog(null,
                "Elige el campo que quiere modificar:",
                "Seleccione para modificar",
                JOptionPane.QUESTION_MESSAGE, null,
                opcionesElegidas, opcionesElegidas[0]);

        if (!opcionesElegidas.equals(null)) {
            return opcionElegida;
        } else {
            return opcionElegida = "Volver";
        }
    }

    //método string para elegir las opciones del Postre
    public static String elegirCategoriaACambiarPostre() {
        String[] opcionesElegidas = {"Nombre", "Kcal", "Precio sin IVA", "IVA",
            "Tipo de Postre", "Stock", "Volver"};

        String opcionElegida = (String) JOptionPane.showInputDialog(null,
                "Elige el campo que quiere modificar:",
                "Seleccione para modificar",
                JOptionPane.QUESTION_MESSAGE, null,
                opcionesElegidas, opcionesElegidas[0]);

        if (!opcionesElegidas.equals(null)) {
            return opcionElegida;
        } else {
            return opcionElegida = "Volver";
        }
    }

    //método string para elegir las opciones de la Bebida
    public static String elegirCategoriaACambiarBebida() {
        String[] opcionesElegidas = {"Nombre", "Tamanio Bebida", "Precio sin IVA", "IVA",
            "Tipo de Bebida", "Stock", "Volver"};

        String opcionElegida = (String) JOptionPane.showInputDialog(null,
                "Elige el campo que quiere modificar:",
                "Seleccione para modificar",
                JOptionPane.QUESTION_MESSAGE, null,
                opcionesElegidas, opcionesElegidas[0]);

        if (!opcionesElegidas.equals(null)) {
            return opcionElegida;
        } else {
            return opcionElegida = "Volver";
        }
    }

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

    public static void mostrarProductos(List<Producto> aux, String[] opciones) {
        for (int i = 0; i < aux.size(); i++) {
            Producto tmp = aux.get(i);
            if (tmp instanceof Comida comidaAux) {
                opciones[i] = comidaAux.getNombre() + " - Precio: "
                        + comidaAux.getPrecioConIVA() + "€" + " - Stock: "
                        + comidaAux.getStock();
            }
        }
    }

    public static void mostrarProdComida(List<Comida> aux, String[] opciones) {
        for (int i = 0; i < aux.size(); i++) {
            Comida comida = aux.get(i);
            opciones[i] = comida.getNombre() + " - Precio: "
                    + comida.getPrecioConIVA() + "€" + " - Stock: " + comida.getStock();
        }
    }

    public static void mostrarProdBebida(List<Bebida> aux, String[] opciones) {
        for (int i = 0; i < aux.size(); i++) {
            Bebida bebida = aux.get(i);
            opciones[i] = bebida.getNombre() + " - Precio: "
                    + bebida.getPrecioConIVA() + "€";
        }
    }

    public static void mostrarProdPostre(List<Postre> aux, String[] opciones) {
        for (int i = 0; i < aux.size(); i++) {
            Postre postre = aux.get(i);
            opciones[i] = postre.getNombre() + " - Precio: "
                    + postre.getPrecioConIVA() + "€";
        }
    }

}
