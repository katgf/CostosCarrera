/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Carrera;

import archivos.archivos;
import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class Carrera {
    private ArrayList<Periodo> Periodos;
    private String Nombre;
    private int añoInicio;

    public Carrera() {
        Periodos = new ArrayList<>();
    }

    public ArrayList<Periodo> getPeriodos() {
        return Periodos;
    }

    public void setPeriodos(ArrayList<Periodo> Periodos) {
        this.Periodos = Periodos;
    }

    public String getNombre() {
        return Nombre;
    }
    
    public void addPeriodo(Periodo periodo)
    {
        this.Periodos.add(periodo);
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public int getAñoInicio() {
        return añoInicio;
    }

    public void setAñoInicio(int añoInicio) {
        this.añoInicio = añoInicio;
    }
    
    
    public double CalcularCosto(){
              double val=0;
              for (Periodo Periodo : Periodos) 
                  val +=Periodo.CalcularPeriodo();

              return val;
    }
    
    public void SaveFile(){
            
           archivos.writeFileTruncate(getNombre(), getNombre()+"-"+getAñoInicio()+"\n");
           for (Periodo Periodo : Periodos) {
            archivos.writeFileAppend(getNombre(), Periodo.NombrePeriodo()+";\n");
            Periodo.SaveFile();
        }

    }
    
    
    public boolean SetFromFile(String Carrera){
        ArrayList<String> lineas = archivos.ReadFile(Carrera);
        if(!lineas.isEmpty()){
            ArrayList<Periodo> LoadPeriod=new ArrayList<Periodo>();
           String infoGeneral[] = lineas.get(0).split("-");
            setNombre(infoGeneral[0]);
            setAñoInicio(Integer.parseInt(infoGeneral[1].replace(";","")));
            lineas.remove(0);
            for (String linea : lineas) {
                Periodo thisp = new Periodo();
                int A= Integer.parseInt(linea.split("-")[0]);
                int P=Integer.parseInt(linea.split("-")[1].replace(";",""));
                thisp.setAño(A);
                thisp.setPeriodo(P);
                thisp.SetFromFile(thisp.NombrePeriodo());
                LoadPeriod.add(thisp);
            }
            this.setPeriodos(LoadPeriod);
            return true;
        }  
        return false;
    }
    
    
 
}
