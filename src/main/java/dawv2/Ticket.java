/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dawv2;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.RandomStringUtils;

/**
 *
 * @author clara
 */
public class Ticket {

    //atributos    
    private static int contadorTickets = 0;
    private int idPedido;
    private final String numeroPedido;//random de 4 dígitos
//    private List<Producto> productos;
    Map<Producto, Integer> productos;
    private double importeTotal; //el precio de cada producto (con iva) * cantidad
    private LocalDateTime fechaEmision;

    //constructor
//    public Ticket(List<Producto> productos, List<Integer> cantidad) {
//        //controlamos que haya el mismo número de productos añadidos a la lista que de cantidades
//        if (productos.size() != cantidad.size()) {
//            throw new IllegalArgumentException("Algo no coincide.");
//        }
//        this.idPedido = contadorTickets;
//        contadorTickets++;
//        this.numeroPedido = RandomStringUtils.randomNumeric(4);
//        this.productos = productos;
//        this.fechaEmision = LocalDateTime.now();
//    }
    public Ticket(Map<Producto, Integer> productos, double importeTotal, LocalDateTime fechaEmision) {
        this.idPedido = contadorTickets;
        contadorTickets++;
        this.numeroPedido = RandomStringUtils.randomNumeric(4);
        this.productos = productos;
        this.importeTotal = importeTotal;
        this.fechaEmision = LocalDateTime.now();
    }

    //getter
    public static int getContadorTickets() {
        return contadorTickets;
    }

    public static void setContadorTickets(int contadorTickets) {
        Ticket.contadorTickets = contadorTickets;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
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
        sb.append("            Wok and Roll         \n");
        sb.append("================================\n");
        sb.append("ID del Pedido: ").append(idPedido).append("\n");
        sb.append("Número de Pedido: ").append(numeroPedido).append("\n");
        sb.append("Fecha de Emisión: ").append(fechaEmision.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"))).append("\n");
        sb.append("================================\n");
        sb.append("Productos:\n");
        double totalSinIVA = 0;
        double totalConIVA = 0;
        for (Map.Entry<Producto, Integer> entry : productos.entrySet()) {
//            Object key = entry.getKey();
//            Object val = entry.getValue();
            sb.append("- ").append(entry.getKey().getNombre())
                    .append(" x ").append(entry.getValue().toString())
                    .append(" - ")
                    .append(String.format("%.2f", entry.getKey().getPrecioConIVA())).append("€\n");
            totalSinIVA += entry.getKey().getPrecioSinIVA();
            totalConIVA += entry.getKey().getPrecioConIVA();

//    for (int i = 0; i < productos.size(); i++) {
//        Producto producto = productos.get(i);
//        sb.append("- ").append(producto.getNombre()).append(" - ").append(String.format("%.2f", producto.getPrecioConIVA())).append("€\n");
//        totalSinIVA += producto.getPrecioSinIVA();
//        totalConIVA += producto.getPrecioConIVA();
//    }
            sb.append("================================\n");
//            sb.append("Cantidad de Productos: ").append(entry.getValue().toString()).append("\n");
            sb.append("Importe Total sin IVA: ")
                    .append(String.format("%.2f",
                            (totalSinIVA * entry.getValue()))).append("€\n");
            sb.append("Importe Total con IVA: ")
                    .append(String.format("%.2f",
                            (totalConIVA * entry.getValue()))).append("€\n");
        }
        sb.append("================================\n");
        return sb.toString();
    }

//    //método para calcular el importe total
//    private double calcularImporteTotal() {
//        double total = 0;
//        for (int i = 0; i < productos.size(); i++) {
//            total += productos.get(i).getPrecio() * cantidad.get(i);
//        }
//        return total;
//    }
    public void imprimirTicket() {

        String rutaArchivo = "tickets/ticket" + this.getIdPedido()
                + "_" + this.getFechaEmision().getDayOfMonth()
                + "-" + this.getFechaEmision().getMonthValue()
                + "-" + this.getFechaEmision().getYear()
                + "_" + this.getFechaEmision().getHour()
                + ":" + this.getFechaEmision().getMinute();

        try (FileWriter writer = new FileWriter(rutaArchivo)) {

            writer.write(this.toString());
            System.out.println("Objeto escrito en el archivo correctamente.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
