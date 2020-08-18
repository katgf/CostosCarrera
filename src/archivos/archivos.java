/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivos;

import java.io.FileWriter;
import java.io.FileReader;
import java.io.*;
import java.io.IOException;
import java.util.ArrayList;
import java.io.File;

/**
 *
 * @author Admin
 */
public class archivos {
    
    public static void writeFileAppend(String Nombre, String texto)
    {
         try{
            FileWriter FW = new FileWriter(Nombre, true);
            FW.append(texto);
            FW.flush();
            FW.close();
        }catch (IOException reporte){
            reporte.printStackTrace();
        }
    }

    public static void writeFileTruncate(String Nombre, String texto)
    {
         try{
            FileWriter FW = new FileWriter(Nombre,false);
            FW.append(texto);
            FW.flush();
            FW.close();
        }catch (IOException reporte){
            reporte.printStackTrace();
        }
    }

    
    public static ArrayList<String> ReadFile(String file) {
    ArrayList<String> lines = new ArrayList<>();
    String line;
    try {
        File f1 = new File(file);
        FileReader fr = new FileReader(f1);
        BufferedReader br = new BufferedReader(fr);
        while ((line = br.readLine()) != null) {
            lines.add(line);
        }
        fr.close();
        br.close();
    
    }catch(Exception e){
        e.printStackTrace();
        
    }
        return lines;
    }
}
