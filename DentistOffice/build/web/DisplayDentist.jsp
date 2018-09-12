<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<!
*********************************************************************
* Walter Scott  java 3   Dentist office project
********************************************************************* 
>


<%-- 
    Document   : DisplayDentist
    Created on : March 20, 2018, 5:25:07 AM 
    Author     : walt310
--%>
<<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ page import = "business.*" %>


<%   
         int z ;
          doctor nDA;
       
           nDA = (doctor)request.getAttribute("nD");       
        
         %>



<html>
    <head>
        <title>Display Doctor Appointment </title>
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
            <h1 >Chatt Dentist </h1> 
            </div> 
                <div>  
            <h2> Your Information and appointments </h2> <br>
                </div>  
                <div>
            <H2> First Name:  <input type="text" name="pfName" value="<%= nDA.getfirstName() %>" >  Last Name.:  <input type="text" name="plName" value="<%= nDA.getlastName() %>" >      </h2>
            <H2> DDS ID: <%= nDA.getid()%>          </h2>
            <input type="hidden" name="pID" value="<%= nDA.getid() %>" />
            <input type="hidden" name="ppw" value="<%= nDA.getpasswd() %>" />
           <h2>   Your Office: <input type="text" name="officeID" value="<%= nDA.getoffice()%>"     > 
               E-mail....:  <input type="text" name="pEmail" value="<%= nDA.getemail() %>"     >      </h2>
            
            <h3> To make changes  just  type over the field and click DDs Update Button </h3>
                 </div>
                 <% 
                     
                     if (nDA.appList1 == null )
                 { 
                      z= 0;
                   }  
                 else 
                 {      
                     z = nDA.appList1.numberOfappointments();
                 }  

                   String[][] patSt = nDA.patList1.display();
                   String[][] proSt = nDA.proList1.displayL();
                    
                   int patX = patSt.length;
                   int proX = proSt.length;

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
                   dSt[0][1] = "None";
                   dSt[0][2] =  nDA.getid()  ;
                   dSt[0][3] = "None";
                 }
                 else
                 {
                  dSt =  nDA.appList1.displayL();
                 }
                int x = dSt.length;
                int y = dSt[0].length;
                 
                  
             %>
            <div class="grid1" >
                <div> Appointment time </div>
                 <div> Customer ID </div>
                  <div> Doctor ID </div>
                   <div> Procedure Code </div>
                   <%  
                       for(int cx=0; cx < x; cx++)
                       { 
                    %>
                          <div> <%= dSt[cx][0]   %>    </div> 
                           <div> <%= dSt[cx][1]   %>  
                               <%   String pFLName = "no name on file";
                                   for(int pax = 0; pax < patX; pax++) 
                                   {
                                     if(patSt[pax][0].equalsIgnoreCase(dSt[cx][1])) 
                                     {    
                                         pFLName = patSt[pax][2] +" " +patSt[pax][3];
                                         
                                     }
                                   }
                               %>
                                <%= pFLName   %> 
                           </div> 
                            <div> <%= dSt[cx][2]   %>    </div> 
                             <div> <%= dSt[cx][3]   %> 
                                      <%   String pCodeN = "Not Listed";
                                   for(int pax = 0; pax < proX; pax++) 
                                   {
                                     if(proSt[pax][0].equalsIgnoreCase(dSt[cx][3])) 
                                     {    
                                         pCodeN = proSt[pax][2];
                                     }
                                   }
                               %>
                                <%= pCodeN   %> 
                             </div> 
                          
                    <%   
                        }
                   %>
            </div>               
            <h4>                </H4>           
           <button   formaction="dLoginPage.html"> Exit to Login </button>
           <button  name="doFunction" value="DDS Update" formaction="LoginServlet" > DDs Update </button>
          
           
        </form>               
        </div>
        
             
    </body>
</html>

