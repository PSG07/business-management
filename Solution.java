import java.util.*;
import java.util.ArrayList;

import javax.lang.model.util.ElementScanner14;
public class Solution {
    static ArrayList<Item>Irr=new ArrayList<Item>();
    static ArrayList<Sell>Srr=new ArrayList<Sell>();
    static ArrayList<Return>Rrr=new ArrayList<Return>();
    static ArrayList<Admin>Arr=new ArrayList<Admin>();
    static ArrayList<general>Grr=new ArrayList<general>();
    public static void start()
    {
        while(true){
        System.out.println("enter 1 to create object of Admin class");
        System.out.println("enter 2 to create object of general class");
        System.out.println("enter 3 to exit this and go back to main menu");
        Scanner sc=new Scanner(System.in);
        int h=sc.nextInt();
        switch(h)
        {
            case 1:
            Admin ad1=new Admin();
            System.out.println("Adminn class created please setdetails");
            ad1.setDetails();
            Arr.add(ad1);
            break;
            case 2:
            general gr1=new general();
            System.out.println("general class created please setDetails");
            gr1.setDetails();
            Grr.add(gr1);
            break;
            case 3:
            return;
        }
    }
    }
    public static void  menuAdmin(int d)
    {
        while(true)
        {
            Scanner sc=new Scanner(System.in);
            System.out.println("hey! welcome to Admin application");
            System.out.println("enter appropriate integer to perform operation");
            System.out.println("enter 1 to add new STock");
            System.out.println("enter 2 to delete stock");
            System.out.println("enter 3 to modify stock");
            System.out.println("enter 4 to exit this aadmin application and go to main menu");
            int t=sc.nextInt();
            switch(t)
            {
                case 1:
                Arr.get(d).addNewStock();
                break;
                case 2:
                System.out.println("enter itemcode to delete stock");
                int t1=sc.nextInt();
                Arr.get(d).deleteStock(t1);
                break;
                case 3:
                System.out.println("enter itemcode to modify stock");
                int t2=sc.nextInt();
                Arr.get(d).modifyStock(t2);
                break;
                case 4:
                return;

            }
        }
    }
    public static void menuGeneral(int d2)
    {
        boolean flag=true;
        while(true)
        {
            Scanner sc=new Scanner(System.in);
            System.out.println("hey welcome to general application");
            System.out.println("enter appropriate integer to perform operation");
            System.out.println("enter 1 to sell item");
            System.out.println("enter 2 to return item");
            System.out.println("enter 3 to display stock");
            System.out.println("enter 4 to display sell");
          System.out.println("enter 5 to exit this general application and go to main menu");
          int g1=sc.nextInt();
          switch(g1)
          {
            case 1:
            System.out.println("enter itemcode and quantity to sell item ");
            int itemCODE=sc.nextInt();
            int QUANTITY=sc.nextInt();
            Grr.get(d2).SellItem(itemCODE,QUANTITY);
            break;
            case 2:
            System.out.println("enter itemcode and quantity to return item");
            int itemCODE1=sc.nextInt();
            int QUANTITY1=sc.nextInt();
            Grr.get(d2).returnItem(itemCODE1, QUANTITY1);
            break;
            case 3:
            System.out.println("enter itemcode to display stock");
            int itemCODE2=sc.nextInt();
            Grr.get(d2).displayStock(itemCODE2);
            break;
            case 4:
            System.out.println("enter intial date and final date between which u wanna see sell");
            int date1=sc.nextInt();
            int date2=sc.nextInt();
            Grr.get(d2).displaySell(date1, date2);
            break;
            case 5:
            return;
          }
        }


    }
public static void main(String[]args){
    System.out.println("hello world");
    Scanner sc=new Scanner(System.in);
    boolean l1=true;
    while(l1)
    {
    System.out.println("choose appropriate choice");
    System.out.println("enter 1 to create objects of admin/general class");
    System.out.println("enter 2 to go to Admin applications");
    System.out.println("enter 3 to go to General application");
    System.out.println("enter 4 to exit the program");
    int k=sc.nextInt();
    switch(k)
    {
        case 1:
        start();
        break;
        case 2:
        if(Arr.size()==0){
            System.out.println("first create object of Admin class and get an user id ");
            System.out.println("sending you back to main menu");
        }
        else{
        System.out.println("enter user id to login to Admin application");
        int userid7=sc.nextInt();
        for(int i=0;i<Arr.size();i++)
        {
            if(Arr.get(i).userID==userid7)
            {
                menuAdmin(i);
            }
        }
    }
        break;
        case 3:
        if(Grr.size()==0)
        {
            System.out.println("first create an object of general class and generate an user id");
            System.out.println("sending you back to main menu");
        }
        else{
        System.out.println("enter user id to login to general application");
        int userid8=sc.nextInt();
        for(int i=0;i<Grr.size();i++)
        {
            if(Grr.get(i).userID==userid8)
            {
                menuGeneral(i);
            }
        }
    }
        break;
        case 4:
        System.out.println("program ended thanks for being with us");
        l1=false;
    }
    }
}
}
class User{
     int userID;
    private String name;
    private int  dateOfBirth;
    private String Address;
    private String  pan;
    Scanner sc=new Scanner(System.in);
    public void setDetails()
    {
        System.out.println("enter userId");
        userID=sc.nextInt();
        sc.nextLine();
        System.out.println("enter name");
        name=sc.nextLine();
        System.out.println("enter dateofbirth");
        dateOfBirth=sc.nextInt();
        sc.nextLine();
        System.out.println("enter address");
        Address=sc.nextLine();
        System.out.println("enter pan");
        pan=sc.nextLine();
        
    }
}
class Admin extends User{
    private int dateOfJoining;
    private float  salary;
    Scanner sc=new Scanner(System.in);
    public void setDetails()
    {
        super.setDetails();
        System.out.println("enter dateofjoining");
        dateOfJoining=sc.nextInt();
        System.out.println("enter salary");
        salary=sc.nextFloat();
    }
    public void addNewStock()
    {
        Item temp=new Item();
        System.out.println("hey item added to stock now set details of this item");
        temp.setDetails();
        Solution.Irr.add(temp);
    }
    public void deleteStock (int itemcod){
        for(int i=0;i<Solution.Irr.size();i++)
        {
            if(itemcod==Solution.Irr.get(i).itemCode)
            {
                if(Solution.Irr.get(i).availableQty==0)
                {
                    Solution.Irr.remove(i);
                    System.out.println("item successfully deleted");
                }
                else
                {
                    System.out.println("the available quantity is not o so cannt delete");
                }
            }
        }
    }
    public void modifyStock(int itemcod)
    {
        for(int i=0;i<Solution.Irr.size();i++)
        {
            if(itemcod==Solution.Irr.get(i).itemCode)
            {
                Solution.Irr.get(i).modify();
            }
        }
    }
}
class general extends User{
    private int dateOfJoining;
    private float  salary;
    private int  dutyHourPerDay;
    Scanner sc=new Scanner(System.in);
    public void setDetails()
    {
        super.setDetails();
        System.out.println("enter datofjoining");
        dateOfJoining=sc.nextInt();
        System.out.println("enter your salary");
        salary=sc.nextFloat();
        System.out.println("enter dutyperhour");
        dutyHourPerDay=sc.nextInt();
    }
    public void SellItem(int itemcod,int quantiti)
    {
        Sell tempSell=new Sell();
        float price1;
        for(int i=0;i<Solution.Irr.size();i++)
        {
            if(itemcod==Solution.Irr.get(i).itemCode)
            {
                price1=Solution.Irr.get(i).price;
            }
        }
        System.out.println("please enter details to sell item");
        tempSell.setDetails(itemcod,quantiti,6);
        Solution.Srr.add(tempSell);
        System.out.println("item sold");
    }
    public void returnItem (int itemcod,int quantiti)
    {
        Return tempReturn=new Return();
        float price2;
        for(int i=0;i<Solution.Irr.size();i++)
        {
            if(itemcod==Solution.Irr.get(i).itemCode)
            {
                price2=Solution.Irr.get(i).price;
            }
        }
        System.out.println("add details to return item");
        tempReturn.setDetails(itemcod, quantiti,7);
        Solution.Rrr.add(tempReturn);
        System.out.println("item successfully returned");
        //modifystock;
    }
    public void displayStock (int itemcod)
    {
        for(int i=0;i<Solution.Irr.size();i++)
        {
            if(itemcod==Solution.Irr.get(i).itemCode)
            {
            Solution.Irr.get(i).display();
            }
        }
    }
    public void displaySell (int startDate, int endDate)
    {
        //Displays the details of the sold items within the date range
    }
}
class Item{
     int itemCode;
     float  price;
     int  availableQty;
     Scanner sc=new Scanner(System.in);
     public void setDetails()
     {
        System.out.println("enter itemcode");
        itemCode=sc.nextInt();
        System.out.println("enter available quantity");
        availableQty=sc.nextInt();
        System.out.println("enter price");
        price=sc.nextFloat();
    }
    public void modify()
    {
        System.out.println("enter new available quantity");
        availableQty=sc.nextInt();
        System.out.println("enter new  price");
        price=sc.nextFloat();
    }
    public void display()
    {
        System.out.println("itemcode= "+itemCode);
        System.out.println("price= "+price);
        System.out.println("availablequantity= "+availableQty);
    }
}
class FoodItem extends Item{
    private int dateOfExpiry;
    public void setDetails()
    {
        super.setDetails();
        System.out.println("enter dateofexpiry");
        dateOfExpiry=sc.nextInt();
    }
    public void modify()
    {
        super.modify();
    }
}
class NonFoodItem extends Item{
    private int returnCount;
}
class Sell{
    private int dateOfSell;
   private int  itemCode;
    private int  quantity;
    private float  totalAmount;
    Scanner sc=new Scanner(System.in);
    public void setDetails(int itemcod,int quantiti,float price1)
    {
        System.out.println("enter dateofsell");
        dateOfSell=sc.nextInt();
        itemCode=itemcod;
        quantity=quantiti;
        totalAmount=quantiti*price1;
    }
}
class Return{
    private int dateOfReturn;
    private int  itemCode;
    private int quantity;
    private float  returnAmount;
    Scanner sc=new Scanner(System.in);
    public void setDetails(int itemcod,int quantiti,float price1)
    {
        System.out.println("enter dateofreturn");
        dateOfReturn=sc.nextInt();
        itemCode=itemcod;
        quantity=quantiti;
        returnAmount=quantiti*price1;
    }
}