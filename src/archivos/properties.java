/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivos;

/**
 *
 * @author Admin
 */
public class properties {
    public static int StrToInt(String text)
    {
       return Integer.parseInt(text);
    }
    public static int StrToInt(String text,String replace)
    {
       return Integer.parseInt(text.replace(replace,""));
    }

}
