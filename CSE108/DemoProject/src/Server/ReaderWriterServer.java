/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import util.Data;
import util.Information;
import util.NetworkConnection;
import java.util.HashMap;

/**
 *
 * @author user
 */
public class ReaderWriterServer implements Runnable{
    String username;
    NetworkConnection nc;
    HashMap<String,Information> clientList;
    
    public ReaderWriterServer(String user, NetworkConnection netConnection, HashMap<String,Information> cList){
        username=user;
        nc=netConnection;
        clientList=cList;
        
    }
    
    @Override
    public void run() {
       // System.out.println("jdbcjzfdkbfd");
      String  actualMessage=null;
        while(true){
            try{
                int f=0;
            Object obj=nc.read();
            //System.out.println(obj.toString());
            if(obj!=null)
            {
                           
            
            actualMessage=(String)obj;
            //System.out.println(actualMessage);
            
            String msgs[]=actualMessage.split(":",2);
            String toUser=msgs[0];
            String sendMsg=msgs[1];
            File file1 = null,file2=null;
             BufferedWriter bwfile1 = null;
		FileWriter fwfile1 = null;
                BufferedWriter bwfile2= null;
		FileWriter fwfile2 = null;
            if(f==0){
             try{
              file1=new File("C:\\Users\\DELL\\Documents\\NetBeansProjects\\Filereader\\"+username+toUser+".txt");
              file2=new File("C:\\Users\\DELL\\Documents\\NetBeansProjects\\Filereader\\"+toUser+username+".txt");
              f=1;
              if (file1.createNewFile()){
	        System.out.println("File1 is created!");
	      }else{
	        System.out.println("File1 already exists.");
	      }
               if (file2.createNewFile()){
	        System.out.println("File2 is created!");
	      }else{
	        System.out.println("File2 already exists.");
	      }
            }
            catch(Exception e)
            {
               
            }
            }
             try{
                 String str1="C:\\Users\\DELL\\Documents\\NetBeansProjects\\Filereader\\"+username+toUser+".txt";
                 String str2="C:\\Users\\DELL\\Documents\\NetBeansProjects\\Filereader\\"+toUser+username+".txt";
              
                fwfile1 = new FileWriter(str1,true);
               // fwfile2=new FileWriter(file2.getAbsoluteFile(),true);
			bwfile1 = new BufferedWriter(fwfile1);
                        fwfile2 = new FileWriter(str2,true);
			bwfile2 = new BufferedWriter(fwfile2);
                        System.out.println("i am khairul amzan1");
                        bwfile1.write("Send:"+sendMsg+"\n");
                         System.out.println("i am khairul amzan2");

                        bwfile1.write("\r\n");
                        bwfile2.write("Received:"+sendMsg+"\n");
                         System.out.println("i am khairul amzan3");

                        bwfile2.write("\r\n");
             }
             catch(Exception e)
             {
                 
             }
             finally {

			try {

				if (bwfile1!= null)
					bwfile1.close();
                                if(bwfile2!=null)
                                    bwfile2.close();
				if (fwfile1 != null)
					fwfile1.close();
                                if(fwfile2!=null)
                                    fwfile2.close();

			} catch (IOException ex) {

				ex.printStackTrace();

			}
		}



            Information info=clientList.get(toUser);
                System.out.println(info.username);
            String messageToSend=username+": "+sendMsg;
            //File file;
            
           
          Data data=new Data();
            data.message=messageToSend;
                System.out.println(data.message);
            
            info.netConnection.write(data.message);
            }
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
            
            
        
        
        }
        
    }
    
}
