<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<!
*********************************************************************
* Walter Scott  java 3   Dentist office project
********************************************************************* 
>


<%-- 
    Document   : processPachent
    Created on : Apr 20, 2018, 4:10:08 pm 
    Author     : walt310
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ page import = "business.*" %>
<%@ page import = "java.util.*" %>
<%@ page import = "java.text.SimpleDateFormat" %>

<%   
         int z ;
          patient nPA;
       
           nPA = (patient)request.getAttribute("nP");       
        
         %>



<html>
    <head>
        <title>Display Patient Appointment </title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <style>
            .grid1{display:grid; 
                   grid-template-columns:repeat(4,200px);
                   grid-gap: 4px;
                   
                  }
                  
                  .grid1  div:nth-child(odd) {background: #66ff66;
                                        border: 1px solid #AA00AA ;  
                                        
                    }
                  .grid1  div:nth-child(even) {background: #66ffff; 
                                         border: 1px solid #AA0000 ; 
                                         
                    }         
             .grid2{display:grid; 
                   grid-template-columns:800px;
                   grid-gap: 4px;
                    
                  }     
                .grid2  div:nth-child(n) {background: #aaaaaa;
                                 border: 1px solid #00ff00 ; 
                                 text-align: center;
                        }
                    
        </style>
      
    
    
    </head>
       
    <body>
        <div>
        <form action="localtext.txt" method="post" autocomplete="on" >
            <div class="grid2" >
            <div>
            <h1 >Chatt Dentist</h1> 
            </div> 
                <div>  
            <h2> Display appointment  List </h2> <br>
                </div>  
                <div>
            <H2> First Name:  <input type="text" name="pfName" value="<%= nPA.getfirstName() %>" >  Last Name.:  <input type="text" name="plName" value="<%= nPA.getlastName() %>" >      </h2>
            <H2><pre class="tab">Patient ID:<%= nPA.getpatId() %>           Insurance Co:<%= nPA.getinsCo()%></pre></h2>
            <input type="hidden" name="pID" value="<%= nPA.getpatId() %>" />
            <input type="hidden" name="ppw" value="<%= nPA.getpasswd() %>" />
             
            <H2> Address...:  <input type="text" name="paddr" value="<%= nPA.getaddr() %>"      >      
                 E-mail....:  <input type="text" name="pEmail" value="<%= nPA.getemail() %>"     >      </h2>
            
            <h3> To make changes  just  type over the field or select a drop down box and click the Change update button </h3>
                 </div>
                 <% 
                     
                     if (nPA.appList1 == null )
                 { 
                      z= 0;
                   }  
                 else 
                 {      
                     z = nPA.appList1.numberOfappointments();
                 }  
                 %>
                 <div>
            <h4>  You have <%= z %>  appointment/s. </h4>
                 </div>
            </div>
             <br>
             <% 
                 String[][] dSt = null;
                 if (z == 0 )
                 {
                   dSt = new String[1][4];
                   dSt[0][0] = "None";
                   dSt[0][1] = nPA.getpatId();
                   dSt[0][2] = "None";
                   dSt[0][3] = "None";
                 }
                 else
                 {
                  dSt =  nPA.appList1.displayL();
                 }
                int x = dSt.length;
                int y = dSt[0].length;
                
                String[][] drSt = nPA.drList1.display();
                String[][] proSt = nPA.proList1.displayL();
                String[] fDates = new String[10];
               
                Calendar c = Calendar.getInstance();
                Date d1 = new Date();
                c.add(Calendar.DAY_OF_MONTH, 14);
                
                SimpleDateFormat dForM = new SimpleDateFormat("MMM d', ' y', '  ha ");
                for(int xd =0; xd <7; xd++)
                {
                 c.add(Calendar.HOUR, 23);
                 c.add(Calendar.MINUTE, 30);
                 
                 fDates[xd] = dForM.format(c.getTime());
                    
                }
                
                  
             %>
            <div class="grid1" >
                <div> Appointment time </div>
                 <div> Customer ID </div>
                  <div> Doctor ID </div>
                   <div> Procedure Code </div>
                   <input type="hidden" name="ppdatetimep" value="<%= dSt[0][0] %>" />
             <%
                for(int cx = 0 ; cx < x ; cx++)
                {  
             %>
                    <div >
                        
                     <select name="pdatetimeps1"  >    
                           <option value="<%= dSt[cx][0] %>" Selected="selected"> <%= dSt[cx][0] %></option> 
                           <% 
                           for(int xd =0; xd <7; xd++)
                            {
                            %>
                           <option value="<%= fDates[xd] %>" > <%= fDates[xd] %>   </option>  
                           <%
                            }    
                           %>
                     </select>
                    </div> 
                    
                    <div >        
                        <select name="patIdps1">  
                            <option value="<%= nPA.getpatId() %>" Selected="selected"> <%= nPA.getpatId() %></option>     
                        
                        </select>
                    </div>
                            
                     <div >        
                        <select name="pdentIdps1">                             
                            <%                     
                                int x2 = drSt.length;
                                int y2 = drSt[0].length;
                                for( int dx = 0 ; dx < x2 ; dx++)
                                { 
                                
                                 if ( dSt[cx][2].equals(drSt[dx][0])) 
                                 {
                                  %>
                                     <option value="<%= drSt[dx][0] %>" Selected="selected"> <%= drSt[dx][0] %> <%= drSt[dx][2] %>  <%= drSt[dx][3] %>  </option>   
                                  <% 
                                 }
                                     else 
                                 {
                                  %>
                                      <option value="<%= drSt[dx][0] %>" > <%= drSt[dx][0] %> <%= drSt[dx][2] %>  <%= drSt[dx][3] %>  </option>   
                                  <%  
                                 }
                                }                         
                             %> 

                             
                        </select>    
                    </div>  
                            
                    <div >    
                       <select name="pprocCodeps1">  
                          <%                     
                                 x2 = proSt.length;
                               
                                for( int dx = 0 ; dx < x2 ; dx++)
                                { 
                                
                                 if ( dSt[cx][3].equals(proSt[dx][0])) 
                                  {
                                  %>
                                     <option value="<%= proSt[dx][0] %>" Selected="selected"> <%= proSt[dx][0] %> <%= proSt[dx][1] %>  <%= proSt[dx][3] %>  </option>   
                                  <% 
                                  }
                                     else 
                                  {
                                  %>
                                      <option value="<%= proSt[dx][0] %>" > <%= proSt[dx][0] %> <%= proSt[dx][1] %>  <%= proSt[dx][3] %>  </option>   
                                  <%  
                                  }
                                 }                         
                             %>  
                        </select>
                        
                    </div>  
                 <% 
                
                }
             %>
             
            </div>               
            <h4>                </H4>           
           <button   formaction="dLoginPage.html"> Exit to Login </button>
           <button  name="doFunction" value="patient update" formaction="LoginServlet" > Update All </button>
           <button  name="doFunction" value="Delete Appointment" formaction="LoginServlet" > Delete Appointment </button>
           
        </form>               
        </div>
        
             
    </body>
</html>

