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
import business.patient;


/**
 * patientList1   makes a list of patient class
 * @author walt310
 */
public class patientList1 {
    
   patient[] ptL1 = null;
   int x = 0;
   
  public int numberOfPatients()
  {
     
          return ptL1.length;
      
  }
   
  /**
   * add
   * expands the patient array list 
   *   a1 
   */
  public void add(patient a1)
  {
      if ( ptL1 == null)
      {   
          x = 0;      }
      else{
          x = ptL1.length;} 
          
        patient[] pTLt = new patient[(x=x+1)];
          
       if ( x > 1 )
       {
           
         for(int y = 0; y < x-1 ; y=y+1)
            {
              pTLt[y] = ptL1[y];         
           
            }
          pTLt[x-1] = a1;
         
       }
       else 
       {
        pTLt[0] = a1;
        
       } // end of if x == 0 
   
       ptL1 = pTLt;
      
       System.out.println("Number of patients ="+ptL1.length+ " " );
       
  } // end of   add
    
  
  /** public String[][] display()
   *  returns a nice easy to use string arraY OF DATA
   * return and array of the patients the patients aka dentist 
   * @return an array patients info aka dentist 
   */
   public String[][] display()
   {
        String[][] patStA = null;
        x = ptL1.length;
        
      if (x==0)
      {
          System.out.println("NO  patients found");
          patStA = new String[1][1];
           patStA[0][0] =  "NO  patients found";
      }
       else
      {
           patStA = new String[x][7];
         for(int y = 0; y <= x-1 ; y=y+1)
            {
            //  aL1[y].display();
              patStA[y][0] = ptL1[y].getpatId();   ;
              patStA[y][1] = ptL1[y].getpasswd()   ;
              patStA[y][2] = ptL1[y].getfirstName()   ;
              patStA[y][3] = ptL1[y].getlastName()   ;  
              patStA[y][4] = ptL1[y].getaddr()   ;
              patStA[y][5] = ptL1[y].getemail()   ;
              patStA[y][6] = ptL1[y].getinsCo()   ;     
              // have to extract the data in to the array 
            }
      }
      
      return patStA;
   } // of of  display
       
 
}  // end  patient list


