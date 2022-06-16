/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.Serializable;


public class Data implements Serializable,Cloneable{
    
    public String message;           
    
    public Object clone()throws CloneNotSupportedException{  
        return super.clone();  
    }  
}
