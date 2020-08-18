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
public class Congreso extends Evento{
    private String Nombre;
    private ArrayList<String> Conferencistas;

    public Congreso() {
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public ArrayList<String> getConferencistas() {
        return Conferencistas;
    }

    public void setConferencistasText(String text)
    {
        ArrayList <String> tokens = new ArrayList<>();
        for (StringTokenizer stringTokenizer = new StringTokenizer(text,"-"); stringTokenizer.hasMoreTokens();) {
            String token = stringTokenizer.nextToken();
                tokens.add(token);
        }
        setConferencistas(tokens);
    }
    public String getConferencistasText(){
    String text;
        ArrayList<String> tmp =(ArrayList<String>)Conferencistas.clone();
        text =tmp.get(0);
        tmp.remove(0);
        text = tmp.stream().map((Conferencista) -> "-"+Conferencista).reduce(text, String::concat);
        return text;
    }
    
    public void setConferencistas(ArrayList<String> Conferencistas) {
        this.Conferencistas = Conferencistas;
    }

        @Override
    public String TextToFile() {
        String info;
        info = "N:"+getCodigo()+":"+getNombre()+":"+getConferencistasText()+":"+getPrecio()+";";
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
        setConferencistasText(tokens.get(2));
        setPrecio(Integer.parseInt(tokens.get(3)));
        setCodigo(tokens.get(0));
        setTipo("Clase");
    }
    
 
    
}
