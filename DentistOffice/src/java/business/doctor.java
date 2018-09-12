//**********************************************************************/
/* Walter scott  java 3   lab 3
//*********************************************************************/
/// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
package business;


import business.connectDB;
import java.sql.*;
import business.selectDB1;
import business.insertDB1;
import business.updateDB1;
import business.deleteDB1;
import business.drList;
import business.patientList1;
import business.procedureList;
import business.appointments;
import business.patient;




/**
 * this is the Dentist aka  doctor class 
 * @author walt310
 */
public class doctor {
        String id = null;
        String passwd = null;
        String firstName  = null;
        String lastName = null;
        String email = null;
        String office = null ;
        
   public     patientList1 patList1 = null;
   public     procedureList proList1 = null;
   public     appointments appList1 = null;
   public     drList drList1 = null;
        
        
   /**
    * Set the doctor account for creating a new doctor
    *   _id
    *   _passwd
    *   _firstName
    *   _lastName
    *   _email
    *   _office 
    */    
        
  public void setDoctor (String _id,  String _passwd, String _firstName, String _lastName, String _email, String _office) 
  {
        id = _id;
        passwd = _passwd;
        firstName = _firstName;
        lastName = _lastName;
        email = _email;
        office = _office;
  }     
   public void setid(String did){ id = did;}
    public String getid(){ return id ;}
   
    public void setpasswd(String dpass){ passwd = dpass;}
    public String getpasswd(){ return passwd ;}
    
    public void setfirstName(String dFN){ firstName = dFN;}
    public String getfirstName(){ return firstName ;}
      
    public void setlastName(String dLN){ lastName = dLN;}
    public String getlastName(){ return lastName ;}
      
   public void setemail(String demail){ email = demail;}
    public String getemail(){ return email ;}
      
    public void setoffice(String doffice){ office = doffice;}
    public String getoffice(){ return office ;}
  
  
  
  /**
   * This Class SelectDB gets all the base information for the Dentist 
   *   acctNO  aka id
   * then  get the associated Class information
   * like appoints and procedures...
   */
  
  public void selectDB(String acctNO)
  {  
      String[][] rdata = null;
      selectDB1 nSel = new selectDB1();
      try 
      {
     rdata = nSel.getOneRecord("dentist.dentists", "id", acctNO);
       
        id = rdata[0][0];
        passwd = rdata[0][1];
        firstName  = rdata[0][2];
        lastName = rdata[0][3];
        email = rdata[0][4];
        office = rdata[0][5];
            
       
       appList1 = new appointments();  appList1.makeAppList("dr", id);
       patList1 = new patientList1();  makePatList();
      proList1 = new   procedureList(); proList1.makeProList();
        
        
        
     
      }
      catch (Exception ex  )
      {
          System.out.println("error in selectDB, doctor, getOneRecord ");
      }
      
      
      
  }
  /**
   * passWordCheck
   * this just  checks the password and returns a boolean
   * without exposing the the password
   *   pW
   * @return 
   */
  public Boolean passWordCheck(String pW)
  {   //*  never expose the password to pass the busness layer
      //   put 30 second delay in here 
      Boolean tB = false;
        if (pW.equals(passwd))
        {
            tB = true;}
            
      return tB;
      
  }
  
  
  
  
  /**
   * insertDB this fills all fields in this class and updates the database
   * this is also the way to create a new record 
   *   _id
   *   _passwd
   *   _firstName
   *   _lastName
   *   _email
   *   _office 
   */
  public void insertDB(String _id,  String _passwd, String _firstName, String _lastName, String _email, String _office) 
  {
        id = _id;
        passwd = _passwd;
        firstName = _firstName;
        lastName = _lastName;
        email = _email;
        office =  _office;
        
        insertDB1 iDoc = new insertDB1();
        String[] dI = new String[4];
        
         dI[0] = id;
         dI[1] = passwd;
         dI[2] = firstName;
         dI[3] = lastName;
         dI[4] = email;
         dI[5] = office; 
        try{
        String rV = iDoc.insertOneRecord("dentists", dI);
        }
        catch ( Exception ex)
        {
            System.out.println("Insert doctor failed " + ex.toString()   );   
        }
        
  }
    /**
     * deleteDB() 
     * this simply calls the deleteDB1 class and
     * deletes function with the current information
     */
  public void deleteDB()
  {
      //   deletes  the current account      no no no !   never delete data we should at the must mark the  data as inactive
      deleteDB1 dAcct = new deleteDB1();
      
      try{
      String rDv = dAcct.deleteOneRecord("dentists","id",id,"passwd",passwd);
      }
      catch(Exception ex)
      {
          System.out.println(" error in dentist deleteDB");
      }
  }
  
  
   
  /**
   * just displays information for to the system out mostly for testing
   */
  public void display()
  {
      System.out.println("id :"+id+" passwd :"+passwd+" firstName :"+  firstName+" lastName:"+lastName.trim()+" Email:"+ email.trim()+"  office #:"+ office.trim()+" .");
      
  }
 
  
  /**
   * updateDB ()
   * Calls the update class and updates the current base information
   * of the doctor class
   */
   public void updateDB ()
  {  //   update base on the current custID 
      updateDB1 uAcct = new updateDB1();
 
      String[] fN = new String[] { "id","passwd","firstName","lastName","email","office"};
       String[] dI = new String[6];
        
         dI[0] = id;
         dI[1] = passwd;
         dI[2] = firstName;
         dI[3] = lastName;
         dI[4] = email;
         dI[5] = office; 
         
    try{
      String uRv = uAcct.updateOneRecord("dentists", fN, dI);
    }
    catch (Exception ex)
    {
        System.out.println("Error in dentist update :" + ex.toString()  );
    }
      
  }
  
   
   
//  private void makeDrList()
//   {
//      drList1 = new drList();
//          selectDB1 nAcc = new selectDB1();
//          try
//          {
//           String[][] drData = null;   
//              
//          drData = nAcc.getALL("dentist.dentists");
//          if (drData != null)
//          {
//          int x = drData.length;
//          
//          for(int y = 0; y < x ; y=y+1 )
//           {
//            doctor t1 = new doctor();
//            
//            t1.selectDB(drData[y][0]);
//            
//            drList1.add(t1);
//            System.out.println("dentist account"+t1.id+" added to DDs ID"+id+" ");
//            
//           }
//          }
//          else 
//          {   drList1 = null;
//          }
//          }
//          catch(Exception ex2)
//          {
//              System.out.println("error in selectDB, Patient, add dentist ");
//          }
//        
//          
//       
//   } // end make doctor list 
//   
   
   /**
    * make a patient list for just this Dentist aka Dr
    * using this classes Dr id and the patientlits1 class
    */
   
   
   private void makePatList()
   {
      patList1 = new patientList1();
          selectDB1 nAcc = new selectDB1();
          try
          {
           String[][] patData = null;   
              
          patData = nAcc.getALL("dentist.patients");
          if (patData != null)
          {
          int x = patData.length;
          
          for(int y = 0; y < x ; y=y+1 )
           {
               
            patient t1 = new patient();
            
            t1.setpatient(patData[y][0],patData[y][1],patData[y][2],patData[y][3],patData[y][4],patData[y][5],patData[y][6]);
            
            patList1.add(t1);
            System.out.println("Patient account"+t1.patId+" added to DDS ID "+id+" ");
            
           }
          }
          else 
          {    patList1 = null;
          }
          }
          catch(Exception ex2)
          {
              System.out.println("error in selectDB, make Patient list, add patient ");
          }
        
          
       
   } // end make Patient list
   
   
   
   
} // end doctor class