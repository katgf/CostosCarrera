/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Eventos;

import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 *
 * @author Admin
 */
public class Clase extends Evento{
    private String Nombre;
    private String Catedratico;

    public Clase() {
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getCatedratico() {
        return Catedratico;
    }

    public void setCatedratico(String Catedratico) {
        this.Catedratico = Catedratico;
    }

    @Override
    public String TextToFile() {
        String info;
        info = "C:"+getCodigo()+":"+getNombre()+":"+getCatedratico()+":"+getPrecio()+";";
        return info;
    }

    @Override
    public void SetFromFile(String datos) {
        datos =datos.split(";")[0];
        ArrayList <String> tokens = new ArrayList<>();
        for (StringTokenizer stringTokenizer = new StringTokenizer(datos,":"); stringTokenizer.hasMoreTokens();) {
            String token = stringTokenizer.nextToken();
                tokens.add(token);
        }
        setNombre(tokens.get(1));
        setCatedratico(tokens.get(2));
        setPrecio(Double.parseDouble(tokens.get(3)));
        setCodigo(tokens.get(0));
        setTipo("Clase");
    }

    @Override
    public Object toobj() {
        String datos[] = {"Nombre: "+getNombre(),"Catedratico:"+getCatedratico(),"Tipo:"+getTipo(),"Precio:"+getPrecio()};
        return datos;
    }
    
}
