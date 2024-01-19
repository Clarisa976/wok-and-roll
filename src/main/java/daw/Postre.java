/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw;

/**
 *
 * @author miguel
 */
public class Postre extends Producto {

    //atributos
    private int kcal; //kilocalorías
    private TipoPostre tipoPostre; //Mochi, Frutita u Otros

    //constructor
      public Postre(String nombre, int kcal, TipoPostre tipoPostre, double precioSinIVA, 
            TipoIVA tipoIVA) {
        super(nombre, precioSinIVA, tipoIVA);
        this.kcal = kcal;
        this.tipoPostre = tipoPostre;
    }

    //getter
    public int getKcal() {
        return kcal;
    }

    public TipoPostre getTipoPostre() {
        return tipoPostre;
    }

    //setter
    public void setKcal(int kcal) {
        this.kcal = kcal;
    }

    public void setTipoPostre(TipoPostre tipoPostre) {
        this.tipoPostre = tipoPostre;
    }

    //toString
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("kcal: ").append(kcal);
        sb.append(", tipo de postre: ").append(tipoPostre);
        sb.append('}');
        return sb.toString();
    }

}
