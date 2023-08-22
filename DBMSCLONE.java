import java.util.*;

class Student
{
 public int Rno;
 public String Name;
 public int Age;
 public int Marks;

public static int Genrator;

static 
{
 Genrator = 0;
}

public Student( String str, int X, int Y)
{
  this.Rno = ++Genrator;
  this.Name = str;
  this.Age  =  X;
  this.Marks = Y; 
}

 public void Display()
 {
  System.out.println(this.Rno + " " + this.Name+" "+this.Age+" "+ this.Marks);
 }

}

class DBMS 
{
 public LinkedList <Student> lobj;

 public DBMS()
 {
 lobj = new LinkedList <Student> ();
 }

 public void StartDBMS()
{
 System.out.println("Marvellous DBMS Started Successfully...");
 System.out.println("Table Schema created Successfully...");
  
 String Query;
 String Tokens[];


 Scanner sobj = new Scanner(System.in);
 int TokensCount = 0;
 
 while(true)
  {
 System.out.print("Marvellous DBMS : ");
 Query = sobj.nextLine();
 
 Tokens = Query.split(" ");

 TokensCount = Tokens.length;


 if(TokensCount == 1)
 {
    if("exit".equals(Tokens[0]))
    {
     System.out.println("Thank you for using Marvellous DBMS..");
     break;
    }
  }

 else if(TokensCount == 2)
 {}
 else if(TokensCount == 3)
 {}
 else if(TokensCount == 4)
 { 
    if("select".equals(Tokens[0]))
    {
    SelectFrom();
    }
 }
 else if(TokensCount == 5)
 {
    if("select".equals(Tokens[0]))
    {
     if("MAX".equals(Tokens[1]))
      {
    System.out.println("Maximum marks are : "+Aggregate_Max());
  }
  else if("MIN".equals(Tokens[1]))
  {
    System.out.println("Minimum marks are : "+Aggregate_Min());
  }
  else if("AVG".equals(Tokens[1]))
  {
   System.out.println("Avarage marks are : "+Aggregate_Avarage());
  }
  else if("SUM".equals(Tokens[1]))
  {
   System.out.println("Sum of marks are : "     +Aggregate_Sum());
    }
  }
}
 else if(TokensCount == 6)
 {}
 else if(TokensCount == 7)
 {
  if("insert".equals(Tokens[0]))
  {
  InsertIntoTale(Tokens[4],Integer.parseInt(Tokens[5]),Integer.parseInt(Tokens[6]));
  }
  else if ("delete".equals(Tokens[0]))
  {
    DeleteFrom(Integer.parseInt(Tokens[6]));
      }
    }
  }
}

  // insert into table student values(______, _______, _______);

public void InsertIntoTale(String name, int age , int marks)
{
 Student sobj = new Student(name,age,marks);
 lobj .add(sobj);

}
// select * from student
public void SelectFrom()
 {
 System.out.println("Records from the student table are : ");
  for(Student serf : lobj)
  {
   serf.Display();
  }
 }

// select * from student where Rno = 11;
 public void SelectFrom(int no)
 {
 System.out.println("Records from the student database are : ");
  for(Student serf : lobj)
  {
    if(serf.Rno == no)
    {
     serf.Display();
     break;
    }  
   }
 }

  public void SelectFrom(String str)
 {
 System.out.println("Records from the student database are : ");
  for(Student serf : lobj)
  {
    if(str.equals(serf.Name))
    {
     serf.Display();
     break;
     }  
   }
 }


  // delete * from student where Rno = 2
 public void DeleteFrom(int no)
 {  
     int i = 0;
    for(Student serf : lobj)
  {
    if(serf.Rno == no)
    {
     lobj.remove(i);
     break;
    }
    i++;
      } 
   }

 // select Max(marks)from student
 public int Aggregate_Max()
 {   Student temp =lobj.get(0);
     int iMax = temp.Marks;
    for(Student serf : lobj)
  {
    if(serf.Marks > iMax)
    {
     iMax = serf.Marks;
    }  
}
   return iMax;
 }

 // select Min(marks)from student

 public int Aggregate_Min()
 {  Student temp =lobj.get(0);
     int iMin = temp.Marks;
    for(Student serf : lobj)
  {
    if(serf.Marks < iMin)
    {
     iMin = serf.Marks;
    }  
}
   return iMin;
 }
 // select Sum(marks)from student
 public int Aggregate_Sum()
 {  
     int Sum = 0;
    for(Student serf : lobj)
  {
      Sum = Sum + serf.Marks;
}
   return Sum;
 }

 // select Avarage(marks)from student
 public float Aggregate_Avarage()
 {  
     int Sum = 0;
    for(Student serf : lobj)
  {
      Sum+=serf.Marks;
}
   return Sum/(lobj.size());
 }
}


class DBMSCLONE
{
  public   static void main(String args[])
   {
   DBMS dobj = new DBMS();
  dobj.StartDBMS();

   }
  }


/*
  dobj.InsertIntoTale("Rahul",23,89);
  dobj.InsertIntoTale("Sager",26,98);
  dobj.InsertIntoTale("Pooja",20,56);
  dobj.InsertIntoTale("Sayali",30,78);
  dobj.InsertIntoTale("Tejas",29,68);
  
  dobj.SelectFrom();
  dobj.SelectFrom(4);
  dobj.SelectFrom("Tejas");
  System.out.println("Maximum marks are : "+dobj.Aggregate_Max());
  System.out.println("Manimum marks are : "+dobj.Aggregate_Min());
  System.out.println("Summestion  of marks are : "+dobj.Aggregate_Sum());
  System.out.println("Avarage  of marks are : "+dobj.Aggregate_Avarage());
  dobj.DeleteFrom(4);
   dobj.SelectFrom();

   */


//  Insert Query 
//  insert into student Values Rahule 23  67
//  0       1     2       3       4    5   6
// No of tokens 7
//

// select * from student
// No of tokens : 4

//  delete from student where Rno = 4
// 0      1      2      3     4     5

//  select Max Age from student
//   0      1    2   3   4