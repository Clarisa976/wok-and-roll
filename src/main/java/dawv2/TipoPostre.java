/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package dawv2;

/**
 *
 * @author clara
 */
public enum TipoPostre {
    //tipos de enum y su descripción
    MOCHI("Dulce tipico japonés"),
    FRUTITA("Fruta de temporada"),
    OTROS("Helados, tartas congeladas, etc.");
    
    //atributos del enum
    private final String desTipoBebida;
    
    //constructor
    private TipoPostre(String desTipoBebida) {
        this.desTipoBebida = desTipoBebida;
    }
}
