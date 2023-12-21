
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.Scanner;



public class JDBCOP {
    public static void main(String[] args) throws Exception {
        Scanner sobj = new Scanner(System.in);
        System.out.println(" Enter the DataBaseName");
        String strData =sobj.nextLine();
       JDBCActivity jobj = new JDBCActivity(strData);
        jobj.DataBaseCreate();
        jobj.CreateTable();
        jobj.creatData();
        jobj.creatData();
        jobj.creatData();
        jobj.readData();
        sobj.close();
     }
}

class JDBCActivity
{
    public String Datastr;
    public JDBCActivity(String Xstr)
    {
      Datastr = Xstr;
    }
  public void DataBaseCreate()
  {
    try{
   String URL = "jdbc:mysql://localhost:3307";
   String Username = "root";
   String Password = "Prashant22";
  
   Connection cobj = DriverManager.getConnection(URL,Username,Password);

   Statement stm = cobj.createStatement();

   String query = "create database "+Datastr;

    stm.execute(query);

   System.out.println(" Database crated successfully !");
  
   cobj.close();
    }

   catch(Exception e)
   {
    e.printStackTrace();
   }
   finally
   {

   }
  }

    public void CreateTable()
    {
        try
        {
      String URL = "jdbc:mysql://localhost:3307/"+Datastr;
      String UserName = "root";
      String Password = "Prashant22";

      Connection cobj = DriverManager.getConnection(URL, UserName, Password);
      Statement stm = cobj.createStatement();

     String query = " create table ScoreCard (Name varchar(200), Score int(10))";
     stm.execute(query);
     System.out.println("Table created successfully!");
	 cobj.close();  
   }
    catch(Exception eobj)
    {
          eobj.printStackTrace();
    } 
    }

    public void creatData()
    {
        try{
     String URL = "jdbc:mysql://localhost:3307/"+Datastr;
     String UserName = "root";
     String Password = "Prashant22";

     Connection cobj = DriverManager.getConnection(URL,UserName,Password);
    
     Scanner sobj = new Scanner(System.in);
     System.out.println("Enter the Name ");
     String strN = sobj.nextLine();
     System.out.println("Enter the Score ");
     int scoreInt = sobj.nextInt();

     String query = "Insert into ScoreCard values('"+strN+"',"+scoreInt+")";
     Statement stm = cobj.createStatement();
      
    stm.executeUpdate(query);
    System.out.println("Data Inserted successfully!");
	cobj.close(); 
    }
  catch(Exception eobj)
  {
    eobj.printStackTrace();
  }
}
 public void readData()
    {
        try{
     String URL = "jdbc:mysql://localhost:3307/"+Datastr;
     String UserName = "root";
     String Password = "Prashant22";

     Connection cobj = DriverManager.getConnection(URL,UserName,Password);
 
     String query = "select * from ScoreCard";
     Statement stm = cobj.createStatement();
     ResultSet rs = stm.executeQuery(query);

     while(rs.next())
     {
        System.out.println("Name is : "+rs.getString("Name")+ " Score is : "+rs.getInt("Score"));
     }
    
     System.out.println("Data readed successfully!");
	cobj.close(); 
    }
  catch(Exception eobj)
  {
    eobj.printStackTrace();
  }
}
  }


