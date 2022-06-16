/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import javafx.scene.control.TextArea;
import javafx.scene.paint.Color;

/**
 *
 * @author user
 */
public class Reader implements Runnable{
    public NetworkConnection netConnection;
    TextArea[] area;
    String[] str;
    public Reader(NetworkConnection nc,String[] str,TextArea[] area){
        netConnection=nc;
        this.area=area;
          this.str=str;  
    }
    
    @Override
    public void run() {
        while(true){
            
            Object obj=netConnection.read();
            System.out.println((String)obj);
           // Data dataObj=(Data)obj;
           if(obj!=null){
               String[] msg=obj.toString().split(":",2);
               String touser=msg[0];
               String message=msg[1];
               for(int i=0;i<20;i++)
               {
                  if(str[i].equals(touser))
                  {
                      
                     area[i].appendText("Received:"+message+"\n");
                  }
               }
            //area.appendText(obj.toString()+"\n");
            System.out.println("Received : "+obj.toString());
           }
            
        }
    }
    
}
