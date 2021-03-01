import java.util.*;
/*
Create a Rectangle class which stores only the Cartesian coordinates of the four corners of the rectangle.
The constructor calls a set function that accepts four sets of coordinates and verified each of these is in the first quadrant with no single x or y coordinate larger than 50.0. 
The set function also verified that the supplied coordinate do, in fact, specify a rectangle. 
Provide member functions that calculate the length, width, perimeters and area. 
The length is the larger of the two dimensions. 
Include a predicate function square that determines whether the rectangle is a square.
Write a tester program to test the working of the Rectangle class.

BY:
SHUJA SAJID
19MCA046
MCA(SEM-4)

*/


class Rectangle
{
   float x1, x2, x3, x4;
   float y1, y2, y3, y4;
   double AB, BC, CD, DA, AC;
   double perimeter, area, length, width; 
   int k1,k2;
   
   Rectangle(float x1, float x2, float x3, float x4, float y1, float y2, float y3, float y4)
   {
      this.x1=x1;
      this.x2=x2;
      this.x3=x3;
      this.x4=x4;
      this.y1=y1;
      this.y2=y2;
      this.y3=y3;
      this.y4=y4;
   }
     
   void validatePoint()
   {
     if((x1<0.00 || x1>50.00) || (y1<0.00 || y1>50.00) || (x2<0.00 || x2>50.00) || (y2<0.00 || y2>50.00) || (x3<0.00 || x3>50.00) || (y3<0.00 || y3>50.00) || (x4<0.00 || x4>50.00) || (y4<0.00 || y4>50.00))
        {
         System.out.println("coordinates are not in first qaudrant. EXit....");
         System.exit(1);
        }
   }

   int checkRectangle()
   {
      AB=((x2-x1)*(x2-x1)+(y2-y1)*(y2-y1));
      BC=((x3-x2)*(x3-x2)+(y3-y2)*(y3-y2));
      CD=((x4-x3)*(x4-x3)+(y4-y3)*(y4-y3));
      DA=((x1-x4)*(x1-x4)+(y1-y4)*(y1-y4));
      AC=((x3-x1)*(x3-x1)+(y3-y1)*(y3-y1));
   
      if((AC==AB+BC) && (AB==CD && DA==BC) /* && (AB!=DA)*/)
              {
                 k1=1;
                 System.out.println("Given coordinates form rectangle.");
              } 
           else
              {  
                 k1=0;
                 System.out.println("Given coordinates doesn't form rectangle.");
              } 
         return k1; 
      }
   
   void getLength()
  {
      length=Math.sqrt(AB);
      System.out.println("Length of rectangle is : "+length);
   }
   
   void getWidth()
   {
      width=Math.sqrt(BC);
      System.out.println("Width of rectangle is : "+width);
   }
        
        
   void getPerimeter()
   {
     perimeter=2*(length+width);
     System.out.println("Perimeter of rectangle is : "+perimeter); 
   }
    
   void getArea()
   {
     area=length*width;
     System.out.println("Area of rectangle is : "+area);
   } 

}
      



class Assignment{
   
public static void main(String args[])
  {
   float x1, x2, x3, x4;
   float y1, y2, y3, y4;
   Scanner scan= new Scanner(System.in);
   System.out.println("The Test Case is a square of 10 unit/r");
   Rectangle recTest=new Rectangle(0, 10, 10, 0, 0, 0, 10, 10);
   recTest.validatePoint();
   if(recTest.checkRectangle()==1)
      {
        recTest.getLength();
        recTest.getWidth(); 
        recTest.getPerimeter();
        recTest.getArea();
       }  
   System.out.println("/rThe 2nd Test Case is a quadrilateral with only changing the point x3 to (9,9)./r");
   Rectangle recTestFail=new Rectangle(0, 10, 9, 0, 0, 0, 9, 10);
   recTestFail.validatePoint();
   if(recTestFail.checkRectangle()==1)
      {
         recTestFail.getLength();
         recTestFail.getWidth(); 
         recTestFail.getPerimeter();
         recTestFail.getArea();
       }  

   try {
      System.out.println("/rEnter the coordinates of A");
      x1= scan.nextFloat(); 
     
      y1= scan.nextFloat();
     
      System.out.println("Enter the coordinates of B");
      x2= scan.nextFloat();
      y2= scan.nextFloat();
      
      System.out.println("Enter the coordinates of C");
      x3= scan.nextFloat();
      y3= scan.nextFloat();
      
      System.out.println("Enter the coordinates of D");
      x4= scan.nextFloat();
      y4= scan.nextFloat();
      
      Rectangle rec=new Rectangle(x1,x2,x3,x4,y1,y2,y3,y4);
      rec.validatePoint();
 
      if(rec.checkRectangle()==1)
      {
        rec.getLength();
        rec.getWidth(); 
        rec.getPerimeter();
        rec.getArea();
       }  
       else 
       {
       System.out.println("Please enter valid rectangle coordinates");
       } 
      
   } finally {
      scan.close();
   }
   }  
}
