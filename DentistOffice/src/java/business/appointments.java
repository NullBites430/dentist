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


 
public class appointments {
        String apptDateTime = null;
        String patId  = null;
        String dentId = null;
        String procCode = null;
        
         appointments[] ppL1 = null;
          int x = 0;
        
        
  
   public int numberOfappointments()
  {      int z = 0;
        if (ppL1 != null)
        {
            z =ppL1.length;
        }  
      
          return z;
      
  }      
  public void setprocList (String _apptDateTime,  String _patId, String _dentId, String _procCode) 
  {
        apptDateTime = _apptDateTime;
        patId = _patId;
        dentId = _dentId;
        procCode = _procCode;
       
  }     
   public void setapptDateTime(String dapptDateTime){ apptDateTime = dapptDateTime;}
    public String getapptDateTime(){ return apptDateTime ;}
    
    public void setpatId(String dFN){ patId = dFN;}
    public String getpatId(){ return patId ;}
      
    public void setdentId(String dLN){ dentId = dLN;}
    public String getdentId(){ return dentId ;}
      
   public void setprocCode(String dprocCode){ procCode = dprocCode;}
    public String getprocCode(){ return procCode ;}
  
  
  public void selectDB( String pID)
  {  
      String[][] rdata = null;
      selectDB1 nSel = new selectDB1();
      try 
      {
     rdata = nSel.getOneRecord("dentist.appointments", "patId", pID);
       
        apptDateTime = rdata[0][0];
        patId  = rdata[0][1];
        dentId = rdata[0][2];
        procCode = rdata[0][3];
      
              
     
      }
      catch (Exception ex  )
      {
          System.out.println("error in selectDB, procList, getOneRecord ");
      }
      
      
      
  }
  
  
  
  
  
  
  
  public void insertDB(String _apptDateTime,  String _patId, String _dentId, String _procCode) 
  {
        apptDateTime = _apptDateTime;
        patId = _patId;
        dentId = _dentId;
        procCode = _procCode;
       
        
        insertDB1 iProc = new insertDB1();
        String[] dI = new String[4];
        
         dI[0] = apptDateTime;
         dI[1] = patId;
         dI[2] = dentId;
         dI[3] = procCode;

        try{
        String rV = iProc.insertOneRecord("appointments", dI);
        }
        catch ( Exception ex)
        {
            System.out.println("Insert appointments failed " + ex.toString()   );   
        }
        
  }
    
  public void deleteDB()
  {
      //   deletes  the current account      no no no !   never delete data we should at the must mark the  data as inactive
      deleteDB1 dAcct = new deleteDB1();
      
      try{
      String rDv = dAcct.deleteOneRecord("appointments","apptDateTime",apptDateTime,"patId",patId);
      }
      catch(Exception ex)
      {
          System.out.println(" error in appointments deleteDB");
      }
  }
  
  
   
  
  public void display()
  {
      System.out.println("apptDateTime :"+apptDateTime+" patId :"+  patId+" dentId:"+dentId.trim()+" procCode:"+ procCode.trim()+" .");
      
  }
 
  
  
   public void updateDB ()
  {  //   update base on the current custID 
      updateDB1 uAcct = new updateDB1();
 
      String[] fN = new String[] { "apptDateTime","patId","dentId","procCode"};
       String[] dI = new String[4];
        
         dI[0] = apptDateTime;
         dI[1] = patId;
         dI[2] = dentId;
         dI[3] = procCode;

         
    try{
      String uRv = uAcct.updateOneRecord("appointments", fN, dI);
    }
    catch (Exception ex)
    {
        System.out.println("Error in appointments update :" + ex.toString()  );
    }
      
  }
  
  public void add(appointments a1)
  {
      if ( ppL1 == null)
      {   
          x = 0;      }
      else{
          x = ppL1.length;} 
          
        appointments[] ppLt = new appointments[(x=x+1)];
          
       if ( x > 1 )
       {
           
         for(int y = 0; y < x-1 ; y=y+1)
            {
              ppLt[y] = ppL1[y];         
           
            }
          ppLt[x-1] = a1;
         
       }
       else 
       {
        ppLt[0] = a1;
        
       } // end of if x == 0 
   
       ppL1 = ppLt;
      
       System.out.println("Number of appointment ="+ppL1.length+ " " );
       
  } // end of   add  
   
   public String[][] displayL()
   {
        String[][] pcStA = null;
        x = ppL1.length;
        
      if (x==0)
      {
          System.out.println("NO  appointments found");
          pcStA = new String[1][1];
           pcStA[0][0] =  "NO  appointments found";
      }
       else
      {
           pcStA = new String[x][4];
         for(int y = 0; y <= x-1 ; y=y+1)
            {
            //  aL1[y].display();
              pcStA[y][0] = ppL1[y].getapptDateTime();   ;
              pcStA[y][1] = ppL1[y].getpatId()   ;
              pcStA[y][2] = ppL1[y].getdentId()   ;
              pcStA[y][3] = ppL1[y].getprocCode()   ;  
             
              // have to extract the data in to the array 
            }
      }
      
      return pcStA;
   } // of of  display
       
   public void makeAppList(String DrOrPat, String drPtID)
   {
    //**    pcL1
      selectDB1 nAcc = new selectDB1();
          try
          {
           String[][] proData = null;   
          
            if (DrOrPat.equals("dr"))
           {
              proData = nAcc.getWhere("dentist.appointments","dentId",drPtID );
           }
           if (DrOrPat.equals("patId"))
              {
                proData = nAcc.getWhere("dentist.appointments","patId",drPtID );
              }
          
          if (proData != null)
          {
          int xx = proData.length;
          
          for(int y = 0; y < xx ; y=y+1 )
           {
            appointments t1 = new appointments();
            
            t1.selectDB(proData[y][1]);
            
            this.add(t1);
       
            System.out.println("appointment list  "+t1.apptDateTime +" added. ");
            
           }
          }
          else 
          {  
              ppL1 = null;
          }
          }
          catch(Exception ex2)
          {
              System.out.println("error in selectDB, appointmenta make list  ");
          }    
        
   }
   
   
   
} // end appointments class