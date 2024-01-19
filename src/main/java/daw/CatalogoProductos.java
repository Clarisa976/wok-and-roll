/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author clara
 */
public class CatalogoProductos {

    //atributos
    private final List<Producto> listaProductos;

    //constructor
        public CatalogoProductos(List<Producto> listaProductos) {
        this.listaProductos = new ArrayList<>();
    }

    //getter
    public List<Producto> getListaProductos() {
        return listaProductos;
    }

    //toString
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CatalogoProductos{");
        sb.append("listaProductos=").append(listaProductos);
        sb.append('}');
        return sb.toString();
    }
}
