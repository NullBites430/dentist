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


/**
 * deleteDB1  class
 * delete the selected object from the database
 */
public class deleteDB1 {
    
    private String selectSQL ="";    
    
 public String deleteOneRecord(String tableName, String fieldName, String fieldData1,String fieldName2, String fieldData2)  throws SQLException, ClassNotFoundException  
{ 
    String ValueEffected = "0";
    Connection rConnect = null;
       Statement  rStatement = null;
       String rString[][] = null; 
          
         
              rConnect = getConnectStuff();
              rStatement = rConnect.createStatement(); 
                   
              selectSQL = new String("delete from dentist." +  tableName + " where " + fieldName +" = '" + fieldData1 + "' and " + fieldName2 +" = '" + fieldData2 + "' ;" );
              
              long rBtf  = rStatement.executeUpdate(selectSQL); 
             
              if (rBtf > 0) { ValueEffected = Long.toString(rBtf); }
    
    
  return  ValueEffected; 
} // end insert one record 
    
        
  private Connection getConnectStuff() throws ClassNotFoundException, SQLException
  {  
      Connection rConnect = null;
     
  try 
          {
              //** Load the JDBC driver
               Class.forName("com.mysql.jdbc.Driver");
              //** establish connection localtion and user and password
              rConnect = DriverManager.getConnection("jdbc:mysql://localhost:3306/dentist", "root", "linux"); 
       	  
              
          }
         catch (Exception ex) 
          {
           if (ex instanceof SQLException    ){  throw ex; }
           if (ex instanceof ClassNotFoundException   ){  throw ex; }
           
          }
      return rConnect;
  }       
    
    
    
    
    
}// end of deleteDB1
