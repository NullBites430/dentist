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
 * Update  class 
 *  used for working with MySql update strings
 * @author walt310
 */
public class updateDB1 {
    
  private String selectSQL ="";   
    
  
 public String updateOneRecord(String tableName,String[] fieldNames,  String[] fieldData1)  throws SQLException, ClassNotFoundException  
{ 
    String ValueEffected = "0";
    Connection rConnect = null;
       Statement  rStatement = null;
       String rString[][] = null; 
          
         
              rConnect = getConnectStuff();
              rStatement = rConnect.createStatement(); 
                   
              selectSQL = new String("UPDATE dentist." +  tableName + " ");
              selectSQL = selectSQL  + "SET ";
                    for(int x = 0 ; x < (fieldData1.length); x =x +1) 
                    {
                      selectSQL = selectSQL  + " "+ fieldNames[x]+" =  '"+  fieldData1[x] +"' " ;
                      
                      if (x < (fieldData1.length-1)) { selectSQL = selectSQL  + ", ";}
                      
                        
                    }
              selectSQL = selectSQL  + " where " + fieldNames[0] + " = '" + fieldData1[0] + "' ;" ;
                      
             
              long rBtf  = rStatement.executeUpdate(selectSQL); 
             
              if (rBtf > 0) { ValueEffected = Long.toString(rBtf); }
    
    
  return  ValueEffected; 
} // end update one record    
    
 
 /**
  * getConnectStuff()  used to connect with MySQL  56 to 57
  * @return Connection
  * @throws ClassNotFoundException
  * @throws SQLException 
  */
    private Connection getConnectStuff() throws ClassNotFoundException, SQLException
  {  
      Connection rConnect = null;
     
  try 
          {
              // Load the JDBC driver
                 Class.forName("com.mysql.jdbc.Driver");
              // establish connection localtion and user and password
              rConnect = DriverManager.getConnection("jdbc:mysql://localhost:3306/chatbank", "root", "linux"); 
       	  
              
          }
         catch (Exception ex) 
          {
           if (ex instanceof SQLException    ){  throw ex; }
           if (ex instanceof ClassNotFoundException   ){  throw ex; }
           
          }
      return rConnect;
  }    
 
 
 
    
    
}
