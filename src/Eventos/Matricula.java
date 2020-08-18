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
public class Matricula extends Evento{
    private String Fecha;

    public Matricula() {
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String Fecha) {
        this.Fecha = Fecha;
    }
    @Override
    public String TextToFile() {
        String info;
        info = "M:"+getCodigo()+":"+getFecha()+":"+getPrecio()+";";
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
        setFecha(tokens.get(1));
        setPrecio(Integer.parseInt(tokens.get(2)));
        setCodigo(tokens.get(0));
        setTipo("Matricula");
    }

}
