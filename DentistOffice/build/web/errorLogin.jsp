<%--
/*********************************************************************
/* Walter Scott  java 3   Dentist office project
/********************************************************************* 
    Document   : errorLogin
    Created on : April 7, 2018, 5:30:52 PM
    Author     : walt310
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ page import = "business.*" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>lab1 Walter Scott Dentist Office</title>
       <style>
             .g1{display:grid; 
                   grid-template-columns:600px;
                   grid-gap: 4px;
                    
                  }     
                .g1  div:nth-child(n) {background: #aabbcc;
                                 border: 1px solid #00ff00 ; 
                                 text-align: center;
                        }
             .g2{display:grid; 
                   grid-template-columns:600px;
                   grid-gap: 4px;
                    
                  }     
                .g2  div:nth-child(n) {background: #66bbcc;
                                 border: 1px solid #ff0000 ; 
                                 text-align: center;
                        }           
            h1 { display:grid; 
                   grid-template-columns:600px;
                   background: #aaaaaa;
                  
                   grid-gap: 2px;
                   border: 1px solid #00ff00;
                   text-align: center;   
            }
            button { display:grid; 
                   grid-template-columns:580px;
                   background: #ff0000;
                  
                   grid-gap: 8px;
                   border: 1px solid #00ffff;
                   text-align: center;   
                   align-self: center;
                   font-size: 16px;
            }
            
        </style>
         
        
        
    </head>
    <body center>
        <div class="g1">
        
            <div>
        <h1> Chatt Dentist </h1>
       
      <%   
            doctor nD;   
            patient nP; 
       
          
          String cID = " ";  
          String uType = "   user";
          nD = (doctor)request.getAttribute("nD");
          nP = (patient)request.getAttribute("nP");
            
          
          
          if (nD.getid() != null){
                           System.out.println("ID = " + nD.getid().toString());
                          cID = nD.getid();
                          uType = "Dentist";
                         }
          
          if (nP.getpatId() != null ){
                          System.out.println("ID = " + nP.getpatId().toString());
                         cID = nP.getpatId();
                         uType = "Patient";
                           }
          
           
          
         // out.println("getcust = "+ nC.getCustID() +" custID =" + cID +"<<" );
        
         %>
        <h2> <%= uType %>  <%= cID  %> , you have an error in your login.
             <br> Please try again <%= uType %>  <%= cID.toString() %> . </h2>
    
                   
          <img src=" cleanTeath.jpg" hight ="400" width="400"> <br/>
        
          <form>
             <button formaction="dLoginPage.html"  > Go to Login Page </button>
          </form>       
          
          </div>
        </div>
             
    </body>
</html>