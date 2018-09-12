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
 * Insert  update data  bye  rows  
 * @author walt310
 */
public class insertDB1 {
    
    private String selectSQL ="";   

    
/**
 * this handles the inserts of data in to the dentist schema  only 
 * it uses dynamic values to build the SQL string  
 *   tableName
 *   fieldData1
 * @return
 * @throws SQLException
 * @throws ClassNotFoundException 
 */    
public String insertOneRecord(String tableName,  String[] fieldData1)  throws SQLException, ClassNotFoundException  
{ 
    String ValueEffected = "0";
    Connection rConnect = null;
       Statement  rStatement = null;
       String rString[][] = null; 
          
         
              rConnect = getConnectStuff();
              rStatement = rConnect.createStatement(); 
                   
              selectSQL = new String("INSERT INTO dentist." +  tableName + " ");
              selectSQL = selectSQL  + "VALUES (";
                    for(int x = 0 ; x < (fieldData1.length); x =x +1) 
                    {
                      selectSQL = selectSQL  + "'"+  fieldData1[x] +"'" ; 
                       if (x < fieldData1.length -1) {selectSQL = selectSQL  + ", " ;} 
                    }
              selectSQL = selectSQL  + " );";
                      
              long rBtf = rStatement.executeUpdate(selectSQL);
            //  long rBtf  = rStatement.executeLargeUpdate(selectSQL); 
             
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
