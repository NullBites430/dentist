//*********************************************************************
//* Walter Scott  java 3   Dentist office project
//*********************************************************************
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;


/* SQL stuff */
import java.util.*;
import java.sql.*;
/**
 *
 * @author walt310
 */
public class connectDB {
           String dbUser1 = "root";
           String dbPW1 = "linux";
           String dbCon = "jdbc:mysql://localhost:3306/";

//*********************************************************************
//* return the connection object with a contection  or Null if there is an error
//*********************************************************************           
public Connection connectDB(String dbTableName) throws Exception
{
     Connection rConnect = null;
     String dbCon2 = dbCon + dbTableName;
     
     try{
       rConnect  = DriverManager.getConnection(dbCon2,dbUser1,dbPW1);
     }
      catch (Exception ex)
              {
                  throw ex;
              }
     

 return rConnect;   // if rConnect = null then there is no connection
} // end 

} // end class connectDB