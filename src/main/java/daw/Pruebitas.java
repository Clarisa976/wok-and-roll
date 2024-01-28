/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package daw;

import java.util.List;

/**
 *
 * @author clara
 */
public class Pruebitas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String numeroPrueba = "5678";
        numeroPrueba = UtilidadesTarjetaPrueba.pedirTarjeta();
        
        boolean esValido = UtilidadesTarjetaPrueba.numeroTarjetaValido(numeroPrueba);
        System.out.println("Es válido el número?" + esValido);
    }
    
}
