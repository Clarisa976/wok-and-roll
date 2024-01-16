package daw;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */

/**
 *
 * @author miguel
 */
public enum TipoBebida {
    
    REFRESCOS("cocacola, fanta, nestea, acuarius..."), 
    ALCOHOLICAS("cerveza, vino, ron, vodka, whisky..."), 
    OTROS("café, té, infusiones, batidos...");
    
    private String descTipoBebida;

    private TipoBebida(String descTipoBebida) {
        this.descTipoBebida = descTipoBebida;
    }
}
