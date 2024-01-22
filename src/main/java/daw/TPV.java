/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.regex.Pattern;

/**
 *
 * @author miguel
 */
public class TPV {
    //atributos
    private UUID numeroSerie;
    private String passAdministrador;
    private String direccion;
    private LocalDateTime fechaHora;
    private List<Producto> productos;// CatalogoCarta?
    private List<Tarjeta> listaTarjetas;
    private List<Ticket> listaTickets;
    
   //constructor
       public TPV() {
        this.numeroSerie = numeroSerie;
        this.passAdministrador = passAdministrador;
        this.direccion = "Calle Falsa, 123";
        this.fechaHora = fechaHora;
        this.productos = productos;
        this.listaTarjetas = listaTarjetas;
        this.listaTickets = listaTickets;
    } 
//    private String numeroSerieTPV;
//    private String contraseniaTPV;
//    private String DireccionTPV;
//    private LocalDateTime fechaHora;
//    private CatalogoProductos catalogoProductos;
//    private List<Tarjeta> listaTarjetasRegistradas;
//    private List<Ticket>


    //método para generar una contraseña apartir de una expresión regular

       private static String generarPass(){
           // Expresión regular para validar el patrón
        String regexp = "^[A-Z]{2}[0-9]{2}[*!][a-z]{2}$";
        
       }
}
