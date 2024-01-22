/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

/**
 *
 * @author miguel
 */
public class TPV {

    //atributos
    private final UUID numeroSerie;
    private String passAdministrador;
    private String direccion;
    private LocalDateTime fechaHora;
    private List<Producto> productos;// CatalogoCarta
    private List<Producto> carrito;
    private List<Ticket> listaTickets;

    //constructor
    public TPV() {
        this.numeroSerie = UUID.randomUUID();
        this.passAdministrador = generarPass();
        this.direccion = "Calle Falsa, 123";
        this.fechaHora = LocalDateTime.now();
        this.productos = CatalogoCarta.listaComida;
        this.carrito = new ArrayList<>();
        this.listaTickets = new ArrayList<>();
    }

    //getters
    public UUID getNumeroSerie() {
        return numeroSerie;
    }

    public String getPassAdministrador() {
        return passAdministrador;
    }

    public String getDireccion() {
        return direccion;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public List<Producto> getCarrito() {
        return carrito;
    }

    public List<Ticket> getListaTickets() {
        return listaTickets;
    }

    //setters
    public void setPassAdministrador(String passAdministrador) {
        this.passAdministrador = passAdministrador;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    public void setCarrito(List<Producto> carrito) {
        this.carrito = carrito;
    }

    public void setListaTickets(List<Ticket> listaTickets) {
        this.listaTickets = listaTickets;
    }

    //toString
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("TPV{");
        sb.append("número de serie: ").append(numeroSerie);
        sb.append(", dirección: ").append(direccion);
        sb.append(", fecha y hora: ").append(fechaHora);
        sb.append('}');
        return sb.toString();
    }

    //método para generar una contraseña 
    private static String generarPass() {
        //String regexp = "^[A-Z]{2}[0-9]{2}[*#$%&()*+,-.:;<=>@][a-z]{2}$";
        Random random = new Random();
        int aMayuscula = 65;
        int aMinuscula = 97;
        int zMayuscula = 90;
        int zMinuscula = 122;

        //generamos dos letras mayúsculas aleatorias
        char letra1 = (char) (random.nextInt(aMayuscula, zMayuscula + 1));
        char letra2 = (char) (random.nextInt(aMayuscula, zMayuscula + 1));

        //generamos dos dígitos aleatorios
        int digito1 = random.nextInt(10);
        int digito2 = random.nextInt(10);

        //se elige un carácter especial aleatorio de la lista permitida
        String caracteresEspeciales = "*#$%&()*+,-.:;<=>@";
        char caracterEspecial = caracteresEspeciales.charAt(random.nextInt(caracteresEspeciales.length()));

        //se generan dos letras minúsculas aleatorias
        char letra3 = (char) (random.nextInt(aMinuscula, zMinuscula + 1));
        char letra4 = (char) (random.nextInt(aMinuscula, zMinuscula + 1));

        //se construye la contraseña como una cadena de caracteres
        String pass = "" + letra4 + letra2 + digito1 + caracterEspecial
                + letra3 + letra1 + digito2;

        //mostramos la contraseña
        System.out.println(pass);
        return pass;
    }
}
