/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Carrera;

import Eventos.*;
import archivos.archivos;
import archivos.properties;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class Periodo {
    private ArrayList<Evento> Evs;
    private int año;
    private int periodo;
    

    public Periodo() {
        Evs= new ArrayList<>();
    }

    public ArrayList<Evento> getEvs() {
        return Evs;
    }

    public void setEvs(ArrayList<Evento> Evs) {
        this.Evs = Evs;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public int getPeriodo() {
        return periodo;
    }

    public void setPeriodo(int periodo) {
        this.periodo = periodo;
    }
    
    public String NombrePeriodo(){
        return getAño()+"-"+getPeriodo();
    }
    
    
    public double CalcularPeriodo(){
        double val=0;
        for (Evento Ev : Evs) {
            val+= Ev.getPrecio();
        }
        return val;
    }
    
    public void SaveFile(){
            archivos.writeFileTruncate(NombrePeriodo(), NombrePeriodo()+"\n");
            if(getEvs().size()>0){
                for (Evento evs : getEvs()) {
                    archivos.writeFileAppend(NombrePeriodo(), evs.TextToFile()+"\n");
                }
            }        
    }
    
    public void SetFromFile(String periodo){
        ArrayList<String> lineas = archivos.ReadFile(periodo);
        ArrayList<Evento> LoadEvs=new ArrayList<Evento>();
       String infoGeneral[] = lineas.get(0).split("-");
        setAño(properties.StrToInt(infoGeneral[0]));
        setPeriodo(properties.StrToInt(infoGeneral[1],";"));
        lineas.remove(0);
        for (String linea : lineas) {
            char str = linea.charAt(0);
            String datos =linea.substring(2);
            Evento evs;
            switch(str){
                case 'M':
                     evs = new Matricula();
                    evs.SetFromFile(datos);
                    break;
                
                case 'C':
                     evs = new Clase();
                    evs.SetFromFile(datos);
                    break;

                case 'N':
                     evs = new Congreso();
                    evs.SetFromFile(datos);
                    break;
                default:
                    evs = new Clase();
                    evs.SetFromFile(datos);
                    break;
            }
            LoadEvs.add(evs);
                        
            
        }
           this.setEvs(LoadEvs);
    }
    
}
