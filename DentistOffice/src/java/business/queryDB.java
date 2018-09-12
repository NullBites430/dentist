//*********************************************************************
//* Walter Scott  java 3   Dentist office project
//*********************************************************************
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import java.sql.*;

/**
 *  return query  data bye  2 dimensional array  aka a table 
 * @author walt310
 */

public class queryDB {

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
          rString = new String[rX][6];
         for( int x = 0; x < rX ; x = x + 1)
         {
            rString[x][0] = r.getString(0);
            rString[x][1] = r.getString(1);
            rString[x][2] = r.getString(2);
            rString[x][3] = r.getString(3);
            rString[x][4] = r.getString(4);
            rString[x][5] = r.getString(5);
            r.next();
         }            
        }
         
        else
        {
         //** throw new SQLException("no data");
            
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
  }  //** end of get string array;    
    
    
    
    
}
