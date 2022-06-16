/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import util.Information;
import util.NetworkConnection;
import java.util.HashMap;
import java.util.Scanner;
import util.Reader;

/**
 *
 * @author user
 */
public class CreateConnection implements Runnable{
    
    HashMap<String,Information> clientList;
    NetworkConnection nc;
    boolean b=true;
    
    public CreateConnection(HashMap<String,Information> cList, NetworkConnection nConnection){
        clientList=cList;
        nc=nConnection;    
    }
        
    
    @Override
    public void run() {
        
        Object userObj=nc.read();
        String username=(String)userObj;
        
        while(b==true){
        
        if(username!=null){
        
        System.out.println("User : "+username+" connected");
         
        
        clientList.put(username,new Information(username,nc));
        
        
        new Thread(new ReaderWriterServer(username,nc,clientList)).start();
        b=false;
        }
        }
        
    }
    
}
