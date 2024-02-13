/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package dawv2;

/**
 *
 * @author clara
 */
public enum TipoIVA {
    //tipos de IVA
    IVA_DIEZ(0.10,"IVA del 10% para comidas y bebidas no alcohólicas"),
    IVA_VEINTIUNO(0.21,"IVA del 21% para bebidas alcohólicas");
    
    //atributos
    private final double valor;
    private final String descripcion;
    
    //constructor
//    private TipoIVA(String descripcion) {
//        this.descripcion = descripcion;
//    }

    private TipoIVA(double valor, String descripcion) {
        this.valor = valor;
        this.descripcion = descripcion;
    }

    public double getValor() {
        return valor;
    }
    
    
}
