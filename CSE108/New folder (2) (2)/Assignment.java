package mypack;

import static java.lang.Double.sum;
import static java.lang.Integer.sum;
import java.util.*;

interface Shop {

    void buy(int type, int amount);

    void sell(int x, int amount);
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
                logentry[i]=new LogEntry();
                Formatter fmt=new Formatter();
          Calendar cal=Calendar.getInstance();
     fmt.format("%tc", cal);
     logentry[i].TimeStamp=fmt.toString();
                logentry[i].ItemName="Green Apples";
                logentry[i].soldorbought="Bought";
                logentry[i].Amount=amount;
                 sum=(GreenNumber+RedNumber+OrangeNumber+PackedNumber+CannedNumber);
                i++;
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
                logentry[i]=new LogEntry();
                Formatter fmt=new Formatter();
          Calendar cal=Calendar.getInstance();
     fmt.format("%tc", cal);
     logentry[i].TimeStamp=fmt.toString();
                logentry[i].ItemName="Red Apples";
                logentry[i].soldorbought="Bought";
                logentry[i].Amount=amount;
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
                logentry[i]=new LogEntry();
                Formatter fmt=new Formatter();
          Calendar cal=Calendar.getInstance();
     fmt.format("%tc", cal);
     logentry[i].TimeStamp=fmt.toString();
                logentry[i].ItemName="Orange";
                logentry[i].soldorbought="Bought";
                logentry[i].Amount=amount;
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
                logentry[i]=new LogEntry();
                Formatter fmt=new Formatter();
          Calendar cal=Calendar.getInstance();
     fmt.format("%tc", cal);
     logentry[i].TimeStamp=fmt.toString();
                logentry[i].ItemName="Canned Strawberries";
                logentry[i].soldorbought="Bought";
                logentry[i].Amount=amount;
                 sum=(GreenNumber+RedNumber+OrangeNumber+PackedNumber+CannedNumber);
                i++;
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
                logentry[i]=new LogEntry();
                Formatter fmt=new Formatter();
          Calendar cal=Calendar.getInstance();
     fmt.format("%tc", cal);
     logentry[i].TimeStamp=fmt.toString();
                logentry[i].ItemName="Packed Strawberries";
                logentry[i].soldorbought="Bought";
                logentry[i].Amount=amount;
                 sum=(GreenNumber+RedNumber+OrangeNumber+PackedNumber+CannedNumber);
                i++;
            }
             else if(((sum+amount)>InventoryLimit))
                System.out.println("Not enough Space in inventory");
            else
               System.out.println("Not enough money");
          }
        
    }
    
    public void sell(int x,int amount)
    {
        if(x==1)
        {
           if(GreenNumber>=amount) 
           {
               GreenNumber=GreenNumber-amount;
               sum=sum-amount;
               Balance=Balance+(amount*5);
               //System.out.println(Balance);
               logentry[i]=new LogEntry();
               Formatter fmt=new Formatter();
          Calendar cal=Calendar.getInstance();
     fmt.format("%tc", cal);
     logentry[i].TimeStamp=fmt.toString();
               logentry[i].ItemName="Green Apple";
               logentry[i].Amount=amount;
               logentry[i].soldorbought="sold";
               i++;
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
               logentry[i]=new LogEntry();
               Formatter fmt=new Formatter();
          Calendar cal=Calendar.getInstance();
     fmt.format("%tc", cal);
     logentry[i].TimeStamp=fmt.toString();
               logentry[i].ItemName="Red Apple";
               logentry[i].Amount=amount;
               logentry[i].soldorbought="sold";
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
               logentry[i]=new LogEntry();
               Formatter fmt=new Formatter();
          Calendar cal=Calendar.getInstance();
     fmt.format("%tc", cal);
     logentry[i].TimeStamp=fmt.toString();
               logentry[i].ItemName="Orange ";
               logentry[i].Amount=amount;
               logentry[i].soldorbought="sold";
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
               logentry[i]=new LogEntry();
               Formatter fmt=new Formatter();
          Calendar cal=Calendar.getInstance();
     fmt.format("%tc", cal);
     logentry[i].TimeStamp=fmt.toString();
               logentry[i].ItemName="Canned strawbeeries";
               logentry[i].Amount=amount;
               logentry[i].soldorbought="sold";
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
               logentry[i]=new LogEntry();
               Formatter fmt=new Formatter();
          Calendar cal=Calendar.getInstance();
     fmt.format("%tc", cal);
     logentry[i].TimeStamp=fmt.toString();
               logentry[i].ItemName="Packed  strawberries";
               logentry[i].Amount=amount;
               logentry[i].soldorbought="sold";
               i++;
           }
           else if(PackedNumber<amount)
           {
               System.out.println("Not enough goods");
           }
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

public class Assignment {

    public static void main(String[] args) 
    {
        int increase=0;
        FruitShop fruitshop=new FruitShop(20,60);
        System.out.println(fruitshop.getBalance());
       fruitshop.buy(1,20);
        System.out.println(fruitshop.getBalance());
       fruitshop.sell(1,5);
        System.out.println(fruitshop.getBalance());
       fruitshop.buy(4,5);
       fruitshop.buy(4,10);
       fruitshop.sell(4,5);
       fruitshop.sell(1,15);
       fruitshop.buy(3,10);
       fruitshop.buy(4,2);
       fruitshop.buy(5,3);
       fruitshop.sell(4,1);
        System.out.println(fruitshop.getBalance());
       System.out.println("Generated logs");
       System.out.println("TimeStamp"+"\t\t\t"+"   "+"Amount"+"\t\t\t"+"Name"+"\t\t"+"BoughtOrSold");
        for(LogEntry logentry:fruitshop.getLog())
        {
            if(increase<fruitshop.ret())
            {
                System.out.println(logentry.toString());
                increase++;
            }
        }
        System.out.println("Items in inventory...");
System.out.println("Name"+"      " +"Buying Price"+"     " +"Selling Price");
                   for (ShopItem shopitem : fruitshop.getInventory()) 
                   {
                       System.out.println(shopitem.toString());
                   }
                   
                       // System.out.println(shoem.toString());

}
            
        
    }}

}
