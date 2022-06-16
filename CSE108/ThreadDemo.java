package mypack;

import java.io.File;
import java.io.FileNotFoundException;
import static java.lang.Double.sum;
import static java.lang.Integer.sum;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

interface Shop {

    void buy(int type, int amount);

    void sell(int x, int amount,int d);
    LogEntry[] getLog();
    ShopItem[] getInventory();

    double getBalance();

}
class ShopItem
{
    private String name;
     private double sellingPricePerUnit;
      private double buyingPricePerUnit;
      void SetString(String str)
      {
          name=new String(str);
      }
      void Setsellprice(double price)
      {
          sellingPricePerUnit=price;
      }
      void setBuyprice(double price)
      {
          buyingPricePerUnit=price;
      }
      String getString()
      {
          return name;
      }
      double getsellprice()
      {
          return sellingPricePerUnit;
      }
      double getbuyprice()
      {
          return buyingPricePerUnit;
      }
       public String toString()
    {
        return this.sellingPricePerUnit+"    "+this.buyingPricePerUnit+"    "+this.name;
                

    }
}
class LogEntry
{
   String TimeStamp;
    String ItemName;
    String soldorbought;
    int Amount;
    public String toString()
    {
        return this.TimeStamp+"        "+this.Amount+"  "+"                    "+this.ItemName+"               "+this.soldorbought;
    }
}

class FruitShop implements Shop {

    int InventoryLimit, Balance,GreenNumber=0,RedNumber=0,OrangeNumber=0,PackedNumber=0,CannedNumber=0,i=0;
    int sum=(GreenNumber+RedNumber+OrangeNumber+PackedNumber+CannedNumber);
    LogEntry[] logentry=new LogEntry[20];
    //boolean getBalance;
   
            int ret()
            {
                return i;
            }

    FruitShop(int m, int n)
    {
        InventoryLimit = m;
        Balance = n;
    }
    public double getBalance()
    {
        return Balance;
    }
   public  LogEntry[] getLog()
    {
        return logentry;
    }
    public void buy(int type,int amount)
    {
        if(type==1)
        {
            if(((sum+amount)<=InventoryLimit)&&((amount*3)<=Balance))
            {
                                GreenNumber=(GreenNumber+amount);
                Balance=Balance-(amount*3);
                
                 sum=(GreenNumber+RedNumber+OrangeNumber+PackedNumber+CannedNumber);
                i++;
                //System.out.println("jxndsjdkx"+);
            }
           else if(((sum+amount)>InventoryLimit))
                System.out.println("Not enough Space in inventory");
            else
               System.out.println("Not enough money");
                
        }
        if(type==2)
        {
            if(((sum+amount)<=InventoryLimit)&&(amount*3<=Balance))
            {
                RedNumber=(RedNumber+amount);
                Balance=Balance-(amount*3);
                
                 sum=(GreenNumber+RedNumber+OrangeNumber+PackedNumber+CannedNumber);
                i++;
            }
             else if(((sum+amount)>InventoryLimit))
                System.out.println("Not enough Space in inventory");
            else
               System.out.println("Not enough money");
        }

          if(type==3)
          {
              //System.out.println(sum);
              if(((sum+amount)<=InventoryLimit)&&((amount*3)<=Balance))
            {
                OrangeNumber=(OrangeNumber+amount);
                
                Balance=Balance-(amount*3);
                                
                 sum=(GreenNumber+RedNumber+OrangeNumber+PackedNumber+CannedNumber);
                i++;
            }
             else if(((sum+amount)>InventoryLimit))
                System.out.println("Not enough Space in inventory");
            else
               System.out.println("Not enough money");
          }
           if(type==4)
          {
              if(((sum+amount)<=InventoryLimit)&&(amount*8<=Balance))
            {
                CannedNumber=(CannedNumber+amount);
                Balance=Balance-(amount*8);
               sum=(GreenNumber+RedNumber+OrangeNumber+PackedNumber+CannedNumber);
              
            }
             else if(((sum+amount)>InventoryLimit))
                System.out.println("Not enough Space in inventory");
            else
               System.out.println("Not enough money");
          }
             if(type==5)
          {
              if(((sum+amount)<=InventoryLimit)&&(amount*5<=Balance))
            {
                PackedNumber=(PackedNumber+amount);
                Balance=Balance-(amount*5);
                sum=(GreenNumber+RedNumber+OrangeNumber+PackedNumber+CannedNumber);
    
            }
             else if(((sum+amount)>InventoryLimit))
                System.out.println("Not enough Space in inventory");
            else
               System.out.println("Not enough money");
          }
        
    }
    
    public synchronized void sell(int x,int amount,int z)
    {
       
        if(x==1)
        {
           if(GreenNumber>=amount) 
           {
               GreenNumber=GreenNumber-amount;
               sum=sum-amount;
               Balance=Balance+(amount*5);
               //System.out.println(Balance);
              
           }
           else
           {
               System.out.println("Not enough goods");
           }
        }
        if(x==2)
        {
           if(RedNumber>=amount) 
           {
               sum=sum-amount;
               RedNumber=RedNumber-amount;
               Balance=Balance+amount*5;
               
               i++;
           }
           else if(RedNumber<amount)
           {
               System.out.println("Not enough goods");
           }
        }
        if(x==3)
        {
           if(OrangeNumber>=amount) 
           {
               sum=sum-amount;
              OrangeNumber=OrangeNumber-amount;
               Balance=Balance+(amount*6);
               
               i++;
           }
           else if(OrangeNumber<amount)
           {
               System.out.println("Not enough goods");
           }
        }
        if(x==4)
        {
           if(CannedNumber>=amount) 
           {
               sum=sum-amount;
              CannedNumber=CannedNumber-amount;
               Balance=Balance+amount*10;
               
               i++;
           }
           else if(CannedNumber<amount)
           {
               System.out.println("Not enough goods");
           }
        }
        if(x==5)
        {
           if(PackedNumber>=amount) 
           {
               sum=sum-amount;
              PackedNumber=PackedNumber-amount;
               Balance=Balance+amount*8;
               
               i++;
           }
           else if(PackedNumber<amount)
           {
               System.out.println("Not enough goods");
           }
        }
        try
        {
            if(z==1)
            Thread.sleep(1000);
            if(z==2)
                Thread.sleep(2000);
            if(z==3)
                Thread.sleep(3000);
        } catch (InterruptedException ex) {
           System.out.println("jschsd");
        }
            }

    public ShopItem[] getInventory()
    {
        int k,sum1;
        sum=GreenNumber+RedNumber+CannedNumber+PackedNumber+OrangeNumber;
        ShopItem[] shopitem=new ShopItem[sum];
        for(k=0;k<GreenNumber;k++)
        {
            shopitem[k]=new ShopItem();
            shopitem[k].SetString("Green apple");
            shopitem[k].Setsellprice(5);
            shopitem[k].setBuyprice(3);
        }
        sum1=k;
        for(k=k;k<(sum1+RedNumber);k++)
           {
               shopitem[k]=new ShopItem();
            shopitem[k].SetString("Red apple");
            shopitem[k].Setsellprice(5);
            shopitem[k].setBuyprice(3);
        } 
          sum1=k;
        for(k=k;k<(sum1+OrangeNumber);k++)
           {
               shopitem[k]=new ShopItem();
            shopitem[k].SetString("Orange");
            shopitem[k].Setsellprice(6);
            shopitem[k].setBuyprice(3);
        }   
        sum1=k;
        for(k=k;k<(sum1+CannedNumber);k++)
           {
               shopitem[k]=new ShopItem();
            shopitem[k].SetString("Canned Strawberries");
            shopitem[k].Setsellprice(10);
            shopitem[k].setBuyprice(8);
        } 
        sum1=k;
        for(k=k;k<(sum1+PackedNumber);k++)
           {
               shopitem[k]=new ShopItem();
            shopitem[k].SetString("Packed strawberries");
            shopitem[k].Setsellprice(8);
            shopitem[k].setBuyprice(5);
        } 
        return shopitem;
        
    }


}

class SalesmanThread implements Runnable 
{
    
    FruitShop fx;
    int i;
    Thread t;
    Scanner sc;
    		int choice, type, amount,n;
                

    public SalesmanThread(FruitShop fs,int d)
    {
      fx=fs;
      i=d;
      t=new Thread(this);
     t.start();
     //System.out.println(fx.getBalance());
    }
    public void run()
    {
       try{
       if(i==1)
          sc = new Scanner(new File("C:\\Users\\DELL\\Downloads\\Study BUET\\Week 8\\input1.txt"));
       if(i==2)
          sc = new Scanner(new File("C:\\Users\\DELL\\Downloads\\Study BUET\\Week 8\\input2.txt"));
       if(i==3)
          sc = new Scanner(new File("C:\\Users\\DELL\\Downloads\\Study BUET\\Week 8\\input3.txt"));
       n=sc.nextInt();
       for (int i = 0; i < n; i++) {
			choice = sc.nextInt();
                        //System.out.println(choice );
                         
                        
			if (choice == 1)
                        {
				type=sc.nextInt();
				amount=sc.nextInt();
                                fx.buy(type, amount);
                        }
                        else if (choice == 2) 
                        {
				type=sc.nextInt();
				amount=sc.nextInt();
                               fx.sell(type, amount,i);
                        }
                        else if(choice==3)
                        {
                            System.out.println(fx.getBalance());
                        }
       }
       
       }
       catch(FileNotFoundException e)
       {
           
       }
                  
       
 
    }
    
}

public class ThreadDemo
{
    
       public static void main(String[] args) 
    {
       FruitShop fs=new FruitShop(20, 70);
       SalesmanThread salesmanThread[]=new SalesmanThread[3];
		
		for (int i = 0; i < salesmanThread.length; i++) {
			salesmanThread[i]= new SalesmanThread(fs,i+1);
                      

	//salesmanThread[i].start();
                 
		}
		
				
		for (ShopItem s : fs.getInventory())
                {
                    System.out.println("asjx");

                    
			System.out.println(s);
		}
       }
}


    
            
        
    



