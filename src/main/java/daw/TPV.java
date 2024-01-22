/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;
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

    //método para generar una contraseña 
    private static String generarPass() {
        // Expresión regular para validar el patrón
//        String regexp = "^[A-Z]{2}[0-9]{2}[*#$%&()*+,-.:;<=>@][a-z]{2}$";
        Random random = new Random();
        int aMayuscula = 65;
        int aMinuscula = 97;
        int zMayuscula = 90;
        int zMinuscula = 122;

        // Generar dos letras mayúsculas aleatorias
        char letra1 = (char) (random.nextInt(aMayuscula, zMayuscula + 1));
        char letra2 = (char) (random.nextInt(aMayuscula, zMayuscula + 1));

        // Generar dos dígitos aleatorios
        int digito1 = random.nextInt(10);
        int digito2 = random.nextInt(10);

        // Elegir un carácter especial aleatorio de la lista permitida
        String caracteresEspeciales = "*#$%&()*+,-.:;<=>@";
        char caracterEspecial = caracteresEspeciales.charAt(random.nextInt(caracteresEspeciales.length()));

        // Generar dos letras minúsculas aleatorias
        char letra3 = (char) (random.nextInt(aMinuscula, zMinuscula + 1));
        char letra4 = (char) (random.nextInt(aMinuscula, zMinuscula + 1));

        // Construir la contraseña como una cadena de caracteres
        String pass = "" + letra4 + letra2 + digito1  + caracterEspecial 
                + letra3 + letra1+ digito2;

        return pass;
    }
}
