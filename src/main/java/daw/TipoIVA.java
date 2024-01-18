/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package daw;

/**
 *
 * @author clara
 */
public enum TipoIVA {
    //tipos de IVA
    IVA_DIEZ("IVA del 10% para comidas y bebidas no alcohólicas"),
    IVA_VEINTIUNO("IVA del 21% para bebidas alcohólicas");
    
    //atributos
    private final String descripcion;
    
    //constructor
    private TipoIVA(String descripcion) {
        this.descripcion = descripcion;
    }
}
