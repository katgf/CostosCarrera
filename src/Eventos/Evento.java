/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Eventos;

/**
 *
 * @author Admin
 */
public abstract class Evento {
    private String codigo;
    private double Precio;
    private String Tipo;

    public Evento() {
    }

    public double getPrecio() {
        return Precio;
    }

    public void setPrecio(double Precio) {
        this.Precio = Precio;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String Tipo) {
        this.Tipo = Tipo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    
    public abstract String TextToFile();
    public abstract void SetFromFile(String datos);
    public abstract Object toobj();
}
