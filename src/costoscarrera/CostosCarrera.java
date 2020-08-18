/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package costoscarrera;

import Carrera.Carrera;
import Carrera.Periodo;
import Eventos.Clase;
import Eventos.Evento;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class CostosCarrera {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Carrera c = new Carrera();
        c.setNombre("Ing Financiera");
        c.setAñoInicio(2007);
        
        ArrayList<Periodo> periodos = new ArrayList<Periodo>();
        Periodo p = new Periodo();
        Periodo p2 = new Periodo();
        p.setAño(2007);
        p.setPeriodo(1);
        periodos.add(p);
        p2.setAño(2007);
        p2.setPeriodo(2);
        
        Clase cl = new Clase();
        cl.setNombre("POO");
        cl.setCatedratico("Maestro x");
        cl.setCodigo("cl-01");
        cl.setPrecio(2300);
        
        Clase cl2 = new Clase();
        cl2.setNombre("Biologia");
        cl2.setCatedratico("Maestro xy");
        cl2.setCodigo("cl-02");
        cl2.setPrecio(2550);
        ArrayList<Evento> evs = new ArrayList<Evento>();
        evs.add(cl);
        evs.add(cl2);
        p2.setEvs(evs);

        periodos.add(p2);

        
        c.setPeriodos(periodos);
        c.SaveFile();
        
        Carrera d = new Carrera();
        d.SetFromFile("Ing Financiera");
        System.out.println(d.CalcularCosto());
    }
    
}
