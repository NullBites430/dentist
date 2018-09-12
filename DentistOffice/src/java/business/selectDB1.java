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
 * selectDB1 class  gets  data from MYSQL sever bases on selections
 * @author walt310
 */
public class selectDB1 {
    
//CustID  
//CustPassword 
//CustFirstName  
//CustLastName
//CustAddress 
//CustEmail
    
//AcctNo  
//Cid  
//Type 
//Balance  
    
 private String selectSQL ;   
 private Connection connection;   
   /**
    * Returns one record from the provided table 
    * in and easy to use  string array
    *   tableName
    *   cID
    *   columnName
    * @return
    * @throws SQLException
    * @throws ClassNotFoundException 
    */
 
  public  String[][] getOneRecord(String tableName,String columnName ,String cID) throws SQLException, ClassNotFoundException {   
       Connection rConnect = null;
       Statement  rStatement = null;
       String rString[][] = null; 
        try {   
         
              rConnect = getConnectStuff();
              rStatement = rConnect.createStatement(); 
     	      if (tableName != null && columnName != null && cID != null)
              {
                 selectSQL = new String("SELECT *  FROM "+  tableName+"  WHERE "+columnName.toString()+" = " + "'" + cID.toString() +"'  ;   " );
              }
             
              
              
              ResultSet resultSet = rStatement.executeQuery(selectSQL); 
              rString = getStringArray(resultSet);
              
              
    }
    catch ( Exception ex) 
    {
                     
           if (ex instanceof SQLException    ){  throw ex; }
           if (ex instanceof ClassNotFoundException   ){  throw ex; }   
    }
    finally
    {  // Close the connection 
        try
          {
           rConnect.close();
          }
       catch ( SQLException exS) 
          {
              throw exS;
          }
        finally
        {
           return rString; 
        }
    }
        
  } // end getALL  
    
  
  
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
              rConnect = DriverManager.getConnection("jdbc:mysql://localhost:3306/dentist", "root", "linux"); 
       	  
              
          }
         catch (Exception ex) 
          {
           if (ex instanceof SQLException    ){  throw ex; }
           if (ex instanceof ClassNotFoundException   ){  throw ex; }
           
          }
      return rConnect;
  } 
  /**
   * Get all the rows for a table  
   *   tableNam
   * @return
   * @throws SQLException
   * @throws ClassNotFoundException 
   */
 
   
   /**
    * Gets all the records form a table and returns them to an easy to use string array
    *   tableName
    * @return
    * @throws SQLException
    * @throws ClassNotFoundException 
    */
   public String[][] getALL(String tableName) throws SQLException, ClassNotFoundException {   
       Connection rConnect = null;
       Statement  rStatement = null;
       String rString[][] = null; 
        try {   
         
              rConnect = getConnectStuff();
       	      // make the connection active ie make the pipe
              rStatement = rConnect.createStatement(); 
     	        
     //       selectSQL = new String("SELECT *  FROM  student AS s     WHERE s.ssn = " + "'" + stuId.toString() +"'  ORDER BY s.ssn;   " );
         //     selectSQL = new String("SELECT *  FROM  CustDB  ORDER BY CustID;   " );
              selectSQL = new String("SELECT * FROM "+tableName  +"; ");
              ResultSet resultSet = rStatement.executeQuery(selectSQL); 
              rString = getStringArray(resultSet);
              
              
    }
    catch ( Exception ex) 
    {
                     
           if (ex instanceof SQLException    ){  throw ex; }
           if (ex instanceof ClassNotFoundException   ){  throw ex; }   
    }
    finally
    {  // Close the connection 
        try
          {
           rConnect.close();
          }
       catch ( SQLException exS) 
          {
              throw exS;
          }
        finally
        {
           return rString; 
        }
    }
        
  } // end getALL  
    
   
   /**
    * getWhere  returns a limited number of records bases on selection 
    * in an easy to use String array
    *   tableName
    *   colName
    *   eqVal
    * @return
    * @throws SQLException
    * @throws ClassNotFoundException 
    */
 public String[][] getWhere(String tableName,String colName, String eqVal) throws SQLException, ClassNotFoundException {   
       Connection rConnect = null;
       Statement  rStatement = null;
       String rString[][] = null; 
        try {   
         
              rConnect = getConnectStuff();
       	      // make the connection active ie make the pipe
              rStatement = rConnect.createStatement(); 
     	        
     //       selectSQL = new String("SELECT *  FROM  student AS s     WHERE s.ssn = " + "'" + stuId.toString() +"'  ORDER BY s.ssn;   " );
         //     selectSQL = new String("SELECT *  FROM  CustDB  ORDER BY CustID;   " );
              selectSQL = "SELECT * FROM "+tableName  +" WHERE "+colName+" = '"+eqVal+"' ; ";
              ResultSet resultSet = rStatement.executeQuery(selectSQL); 
              rString = getStringArray(resultSet);
              
              
    }
    catch ( Exception ex) 
    {
                     
           if (ex instanceof SQLException    ){  throw ex; }
           if (ex instanceof ClassNotFoundException   ){  throw ex; }   
    }
    finally
    {  // Close the connection 
        try
          {
           rConnect.close();
          }
       catch ( SQLException exS) 
          {
              throw exS;
          }
        finally
        {
           return rString; 
        }
    }
       
  } // end getALL  
    
 
 
  private String[][] getStringArray(ResultSet r)
  { 
    String[][] rString = null;  
    int rX = 0;
    int yC = 0;
    
    try
    {
        
         if ( r.last() )
        {
          rX = r.getRow();
          r.first();
          ResultSetMetaData mD = r.getMetaData();   
          yC = mD.getColumnCount();
          rString = new String[rX][yC];
         for( int x = 0; x < rX ; x = x + 1)
         {
             for(int y = 1; y <= yC; y = y + 1 )
             {
               rString[x][y-1] = r.getString(y).toString();
               System.out.println(">>"+r.getString(y).toString() +"<<" );
             }
//            rString[x][1] = r.getString(2);
//            rString[x][2] = r.getString(3);
//            rString[x][3] = r.getString(4);
//            rString[x][4] = r.getString(5);
//            rString[x][5] = r.getString(6);
            r.next();
         }            
        }
         
        else
        {
         // throw new SQLException("no data");
            
        }
    }
   
    catch( Exception ex) 
    {
        if (ex instanceof SQLException    ){  throw ex; }
        if (ex instanceof ClassNotFoundException   ){  throw ex; }   
    }
    finally
    {
      try
          {
           r .close();
          }
       catch ( SQLException exS) 
          {
              throw exS;
          }
        finally
        {
           return rString; 
        }    
    } 
  }  // end of get string array; 
    
    
}
