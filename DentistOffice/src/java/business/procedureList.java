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


/**
 * procedure List class makes a list procedures in the dentist  data base
 * a base of 4 variables and an array of it self
 *  makes an array of  it self 
 * @author walt310
 */
public class procedureList {
        String procCode = null;
        String procName  = null;
        String procDesc = null;
        String cost = null;
        
         procedureList[] pcL1 = null;
          int x = 0;
        
        
          
          
          
          
          
          
   /**
    * Set the procedure List for creating a new procList
    *   _procCode
    *   _procName
    *   _procDesc
    *   _cost
  
    */    
          
    /**
     * numberOfprocedures  returns the number of it self in the array
     * @return 
     */      
   public int numberOfprocedures()
  {
     
          return pcL1.length;
      
  }      
   
   /**
    * setprocList  base set and get of the class
    *   _procCode
    *   _procName
    *   _procDesc
    *   _cost 
    */
  public void setprocList (String _procCode,  String _procName, String _procDesc, String _cost) 
  {
        procCode = _procCode;
        procName = _procName;
        procDesc = _procDesc;
        cost = _cost;
       
  }     
   public void setprocCode(String dprocCode){ procCode = dprocCode;}
    public String getprocCode(){ return procCode ;}
    
    public void setprocName(String dFN){ procName = dFN;}
    public String getprocName(){ return procName ;}
      
    public void setprocDesc(String dLN){ procDesc = dLN;}
    public String getprocDesc(){ return procDesc ;}
      
   public void setcost(String dcost){ cost = dcost;}
    public String getcost(){ return cost ;}
  
    
    
    
    
    
    
  /**
   * selectDB gets a base data based on id of the procedure code
   *   procCode1 
   */  
  
  public void selectDB(String procCode1)
  {  
      String[][] rdata = null;
      selectDB1 nSel = new selectDB1();
      try 
      {
     rdata = nSel.getOneRecord("dentist.procedures", "procCode", procCode1);
       
        procCode = rdata[0][0];
        procName  = rdata[0][1];
        procDesc = rdata[0][2];
        cost = rdata[0][3];
      
              
     
      }
      catch (Exception ex  )
      {
          System.out.println("error in selectDB, procList, getOneRecord ");
      }
      
      
      
  }
  
  
  
  
  
  /**
   * inserts a new procedure code 
   *   _procCode
   *   _procName
   *   _procDesc
   *   _cost 
   */
  
  public void insertDB(String _procCode,  String _procName, String _procDesc, String _cost) 
  {
        procCode = _procCode;
        procName = _procName;
        procDesc = _procDesc;
        cost = _cost;
       
        
        insertDB1 iProc = new insertDB1();
        String[] dI = new String[4];
        
         dI[0] = procCode;
         dI[1] = procName;
         dI[2] = procDesc;
         dI[3] = cost;

        try{
        String rV = iProc.insertOneRecord("procedures", dI);
        }
        catch ( Exception ex)
        {
            System.out.println("Insert procList failed " + ex.toString()   );   
        }
        
  }
    
  /**
   * deleteDB()
   * deletes This  procedure code from the database
   */
  public void deleteDB()
  {
      //   deletes  the current account      no no no !   never delete data we should at the must mark the  data as inactive
      deleteDB1 dAcct = new deleteDB1();
      
      try{
      String rDv = dAcct.deleteOneRecord("procedures","procCode",procCode,"procName",procName );
      }
      catch(Exception ex)
      {
          System.out.println(" error in procedures deleteDB");
      }
  }
  
  
   
  /**
   * display()
   *  just used for testing 
   */
  public void display()
  {
      System.out.println("procCode :"+procCode+" procName :"+  procName+" procDesc:"+procDesc.trim()+" cost:"+ cost.trim()+" .");
      
  }
 
  
  /**
   * updateDB ()
   *  makes changes in the database for  THIS instance of the class
   */
   public void updateDB ()
  {  //   update base on the current custID 
      updateDB1 uAcct = new updateDB1();
 
      String[] fN = new String[] { "procCode","procName","procDesc","cost"};
       String[] dI = new String[4];
        
         dI[0] = procCode;
         dI[1] = procName;
         dI[2] = procDesc;
         dI[3] = cost;

         
    try{
      String uRv = uAcct.updateOneRecord("procedures", fN, dI);
    }
    catch (Exception ex)
    {
        System.out.println("Error in procedures update :" + ex.toString()  );
    }
      
  }
  
  public void add(procedureList a1)
  {
      if ( pcL1 == null)
      {   
          x = 0;      }
      else{
          x = pcL1.length;} 
          
        procedureList[] pcLt = new procedureList[(x=x+1)];
          
       if ( x > 1 )
       {
           
         for(int y = 0; y < x-1 ; y=y+1)
            {
              pcLt[y] = pcL1[y];         
           
            }
          pcLt[x-1] = a1;
         
       }
       else 
       {
        pcLt[0] = a1;
        
       } // end of if x == 0 
   
       pcL1 = pcLt;
      
       System.out.println("Number of procedureList ="+pcL1.length+ " " );
       
  } // end of   add  
   
  /**
   * displayL()
   *  Returns an easy to use string array of the data in this class
   * @return 
   */
   public String[][] displayL()
   {
        String[][] pcStA = null;
        x = pcL1.length;
        
      if (x==0)
      {
          System.out.println("NO  procedures found");
          pcStA = new String[1][1];
           pcStA[0][0] =  "NO  procedures found";
      }
       else
      {
           pcStA = new String[x][4];
         for(int y = 0; y <= x-1 ; y=y+1)
            {
            //  aL1[y].display();
              pcStA[y][0] = pcL1[y].getprocCode();   ;
              pcStA[y][1] = pcL1[y].getprocName()   ;
              pcStA[y][2] = pcL1[y].getprocDesc()   ;
              pcStA[y][3] = pcL1[y].getcost()   ;  
             
              // have to extract the data in to the array 
            }
      }
      
      return pcStA;
   } // of of  display
   /**
    * make the procedure list form all of the procedures
    */    
   
   
   /**
    * makeProList() 
    * makes an array  list of this class from the data base used
    * 
    */
   public void makeProList()
   {
    //**    pcL1
      selectDB1 nAcc = new selectDB1();
          try
          {
           String[][] proData = null;   
              
          proData = nAcc.getALL("dentist.procedures");
          if (proData != null)
          {
              
            int x = proData.length;
             
          for(int y = 0; y < x ; y=y+1 )
           {
            procedureList t1 = new procedureList();
            
            t1.selectDB(proData[y][0]);
            
            this.add(t1);
       
            System.out.println("proclist "+t1.procCode +" added. ");
            
           }
          }
          else 
          {  
              pcL1 = null;
          }
          }
          catch(Exception ex2)
          {
              System.out.println("error in makeprolist,  in procedurelist ");
          }    
        
   }
   
   
} // end procedurelist class