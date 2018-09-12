//*********************************************************************
//* Walter Scott  java 3   Dentist office project
//*********************************************************************
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;
import business.connectDB;
import java.sql.*;
import business.selectDB1;
import business.doctor;


/**
 * Doctor aka dentist list class 
 * ints an array of  Doctor
 * @author walt310
 */
public class drList {
    
   doctor[] drL1 = null;
   int x = 0;
   
  public int numberOfDr()
  {
     
          return drL1.length;
      
  }
    
  /**
   * add a doctor aka dds 
   * this expands the doctor array and add
   * the doctor class element to the array
   *   a1 
   */
  public void add(doctor a1)
  {
      if ( drL1 == null)
      {   
          x = 0;      }
      else{
          x = drL1.length;} 
          
        doctor[] drLt = new doctor[(x=x+1)];
          
       if ( x > 1 )
       {
           
         for(int y = 0; y < x-1 ; y=y+1)
            {
              drLt[y] = drL1[y];         
           
            }
          drLt[x-1] = a1;
         
       }
       else 
       {
        drLt[0] = a1;
        
       } // end of if x == 0 
   
       drL1 = drLt;
      
       System.out.println("Number of doctors ="+drL1.length+ " " );
       
  } // end of   add
    
  
  // public String[][] display()
  /**
   * Display returns each doctor element of the array to a String
   * for each segregation and printing just as the table is a 
   * two dimensional array 
   */
   public String[][] display()
   {
        String[][] drStA = null;
        x = drL1.length;
        
      if (x==0)
      {
          System.out.println("NO  doctors found");
          drStA = new String[1][1];
           drStA[0][0] =  "NO  doctors found";
      }
       else
      {
           drStA = new String[x][6];
         for(int y = 0; y <= x-1 ; y=y+1)
            {
            //  aL1[y].display();
              drStA[y][0] = drL1[y].getid();   ;
              drStA[y][1] = drL1[y].getpasswd()   ;
              drStA[y][2] = drL1[y].getfirstName()   ;
              drStA[y][3] = drL1[y].getlastName()   ;     
              drStA[y][4] = drL1[y].getemail()   ;
              drStA[y][5] = drL1[y].getoffice()   ;     
              // have to extract the data in to the array 
            }
      }
      
      return drStA;
   } // of of  display
       
  
    
    
    
    
    
    
}  // end  doctors list


