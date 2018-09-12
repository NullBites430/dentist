/**********************************************************************/
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
import business.doctor;
import business.drList;
import business.appointments;
import business.procedureList;

/**
 * patient class 
 *  creates a base list of variables and list relating to the patient
 * @author walt310
 */
public class patient {
        String patId = null;
        String passwd = null;
        String firstName  = null;
        String lastName = null;
        String addr = null;
        String email = null;
        String insCo = null ;
      
      public  drList drList1 = null;  
      public  procedureList proList1 = null; 
      public  appointments appList1 = null; 
      
      
     
      
      
   /**
    * Set the patient account for creating a new patient
    *   _patId
    *   _passwd
    *   _firstName
    *   _lastName
    *   _addr
    *   _email
    *   _insCo 
    */    
       
  /** setpatient 
   *   sets the all the base information for the patient for this class 
   */ 
    
      
  public void setpatient (String _patId,  String _passwd, String _firstName, String _lastName, String _addr, String _email, String _insCo) 
  {
        patId = _patId;
        passwd = _passwd;
        firstName = _firstName;
        lastName = _lastName;
        addr = _addr;
        email = _email;
        insCo = _insCo;
  }     
  
  /** all gets and sets  set th4e information or gets the data for each item 
  * 
  */
  
   public void setpatId(String dpatId){ patId = dpatId;}
    public String getpatId(){ return patId ;}
   
    public void setpasswd(String dpass){ passwd = dpass;}
    public String getpasswd(){ return passwd ;}
    
    public void setfirstName(String dFN){ firstName = dFN;}
    public String getfirstName(){ return firstName ;}
      
    public void setlastName(String dLN){ lastName = dLN;}
    public String getlastName(){ return lastName ;}
    
    public void setemail(String demail){ email = demail;}
    public String getemail(){ return email ;}
      
   public void setaddr(String daddr){ addr = daddr;}
    public String getaddr(){ return addr ;}
      
    public void setinsCo(String dinsCo){ insCo = dinsCo;}
    public String getinsCo(){ return insCo ;}
  
  
  
  /**
   * selectDB  get the base information for THIS class form the Database
   * and initialize the associated list 
   *   patId1 
   */
  
  public void selectDB(String patId1)
  {  
      String[][] rdata = null;
      selectDB1 nSel = new selectDB1();
      try 
      {
     rdata = nSel.getOneRecord("dentist.patients", "patId", patId1);
       
        patId = rdata[0][0];
        passwd = rdata[0][1];
        firstName  = rdata[0][2];
        lastName = rdata[0][3];
        addr = rdata[0][4];
        email = rdata[0][5];
        insCo = rdata[0][6];
           
       drList1 = new drList();  makeDrList();
       proList1 = new procedureList();  proList1.makeProList();
       appList1 = new appointments();  appList1.makeAppList("patId", patId1);
       
          
     
      }
      catch (Exception ex  )
      {
          System.out.println("error in selectDB, patient, getOneRecord ");
      }
      
  }
  
  
  /**
   * passWordCheck   returns a boolean to see if the provide password is good
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
   * insertDB  inserts the provided data in to the data base creating a new record
   *   _patId
   *   _passwd
   *   _firstName
   *   _lastName
   *   _addr
   *   _email
   *   _insCo 
   */
  
  public void insertDB(String _patId,  String _passwd, String _firstName, String _lastName, String _addr, String _email, String _insCo) 
  {
        patId = _patId;
        passwd = _passwd;
        firstName = _firstName;
        lastName = _lastName;
        addr = _addr;
        email = _email;
        insCo =  _insCo;
        
        insertDB1 iPat = new insertDB1();
        String[] dI = new String[4];
        
         dI[0] = patId;
         dI[1] = passwd;
         dI[2] = firstName;
         dI[3] = lastName;
         dI[4] = addr;
         dI[5] = email;
         dI[6] = insCo; 
        try{
        String rV = iPat.insertOneRecord("patients", dI);
        }
        catch ( Exception ex)
        {
            System.out.println("Insert patient failed " + ex.toString()   );   
        }
        
  }
    
  /**
   * deleteDB()
   *   removes an instance of THIS data form the data base
   */
  public void deleteDB()
  {
      //   deletes  the current account      no no no !   never delete data we should at the must mark the  data as inactive
      deleteDB1 dAcct = new deleteDB1();
      
      try{
      String rDv = dAcct.deleteOneRecord("patients","patId",patId,"passwd",passwd);
      }
      catch(Exception ex)
      {
          System.out.println(" error in patient deleteDB");
      }
  }
  
  
   /**
    * display() 
    * just used for testing 
    */
  
  public void display()
  {
      System.out.println("patId :"+patId+" passwd :"+passwd+" firstName :"+  firstName+" lastName:"+lastName.trim()+" Address:"+ addr.trim()+" Email:"+ email.trim()+"  insCo #:"+ insCo.trim()+" .");
      
  }
 
  /**
   * updates  the information in an instance of THIS class in the database
   */
  
   public void updateDB ()
  {  //   update base on the current custID 
      updateDB1 uAcct = new updateDB1();
 
      String[] fN = new String[] { "patId","passwd","firstName","lastName","addr","email","insCo"};
       String[] dI = new String[7];
        
         dI[0] = patId;
         dI[1] = passwd;
         dI[2] = firstName;
         dI[3] = lastName;
         dI[4] = addr;
         dI[5] = email;
         dI[6] = insCo; 
         
    try{
      String uRv = uAcct.updateOneRecord("patients", fN, dI);
    }
    catch (Exception ex)
    {
        System.out.println("Error in patient update :" + ex.toString()  );
    }
      
  }
  
 /** makedrlist
  *  makes a list of doctors aka dentist related to this patient
  */
   private void makeDrList()
   {
      drList1 = new drList();
          selectDB1 nAcc = new selectDB1();
          try
          {
           String[][] drData = null;   
              
          drData = nAcc.getALL("dentist.dentists");
          if (drData != null)
          {
          int x = drData.length;
          
          for(int y = 0; y < x ; y=y+1 )
           {
            doctor t1 = new doctor();
            
            t1.selectDB(drData[y][0]);
            
            drList1.add(t1);
            System.out.println("dentist account"+t1.id+" added to patient"+patId+" ");
            
           }
          }
          else 
          {   drList1 = null;
          }
          }
          catch(Exception ex2)
          {
              System.out.println("error in selectDB, Patient, add dentist ");
          }
        
          
       
   } // end make doctor list
   
         
   
   
   
} // end patient class