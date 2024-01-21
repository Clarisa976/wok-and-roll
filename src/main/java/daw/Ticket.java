/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import org.apache.commons.lang3.RandomStringUtils;

/**
 *
 * @author clara
 */
public class Ticket {

    //atributos    
    private static final int contadorTickets = 1;
    private final String numeroPedido;//random de 4 dígitos
    private final List<Producto> productos;
    private final List<Integer> cantidad; //por cada producto elegido
    private final double importeTotal; //el precio de cada producto (con iva) * cantidad
    private final LocalDateTime fechaEmision;

    //constructor
    public Ticket(List<Producto> productos, List<Integer> cantidad) {
        //controlamos que haya el mismo número de productos añadidos a la lista que de cantidades
        if (productos.size() != cantidad.size()) {
            throw new IllegalArgumentException("Algo no coincide.");
        }
        this.numeroPedido = RandomStringUtils.randomNumeric(4);
        this.productos = productos;
        this.cantidad = cantidad;
        this.importeTotal = calcularImporteTotal();
        this.fechaEmision = LocalDateTime.now();
    }

    //getter
    public static int getContadorTickets() {
        return contadorTickets;
    }

    public String getNumeroPedido() {
        return numeroPedido;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public List<Integer> getCantidad() {
        return cantidad;
    }

    public double getImporteTotal() {
        return importeTotal;
    }

    public LocalDateTime getFechaEmision() {
        return fechaEmision;
    }

    //toString
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("================================\n");
        sb.append("          TICKET DE COMPRA       \n");
        sb.append("================================\n");
        sb.append("Número de Pedido: ").append(numeroPedido).append("\n");
        sb.append("Fecha de Emisión: ").append(fechaEmision.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"))).append("\n");
        sb.append("================================\n");
        sb.append("Productos:\n");
        for (int i = 0; i < productos.size(); i++) {
            sb.append("- ").append(productos.get(i).getNombre()).append(" x ").append(cantidad.get(i)).append("\n");
        }
        sb.append("================================\n");
        sb.append("Cantidad de Productos: ").append(productos.size()).append("\n");
        sb.append("Importe Total: ").append(importeTotal).append("€\n");
        sb.append("================================\n");
        return sb.toString();
    }

    //método para calcular el importe total
    private double calcularImporteTotal() {
        double total = 0;
        for (int i = 0; i < productos.size(); i++) {
            total += productos.get(i).getPrecioConIVA() * cantidad.get(i);
        }
        return total;
    }
}
