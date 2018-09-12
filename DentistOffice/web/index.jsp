<%-- 
/*********************************************************************
/* Walter Scott  java 3   Dentist office project
/********************************************************************* 
    Document   : index
    Created on : Mar 20, 2018, 12:40:33 PM
    Author     : walter scott
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Dentist office project  Walter Scott</title>
        <style>
             .g1{display:grid; 
                   grid-template-rows:800px;
                   grid-gap: 4px;
                    
                  }     
                .g1  div:nth-child(n) {background: #112233;
                                 border: 1px solid #00ff33 ; 
                                 text-align: center;
                        }
             .g2{display:grid; 
                   grid-template-columns:800px;
                   grid-gap: 4px;
                    
                  }     
                .g2  div:nth-child(n) {background: #112233;
                                 border: 1px solid #ff0000 ; 
                                 text-align: center;
                        }           
            h1 { display:grid; 
                   grid-template-columns:800px;
                   background: #11aaff;
                  
                   grid-gap: 2px;
                   border: 1px solid #00ff00;
                   text-align: center;   
            }
            
            
        </style>
        
        
        
        
    </head>
    <body center>
        <div class="g2">
            <div>
        <h1> Chat Dentist Office </h1>
          
        
        
        <div>
          <img src="cleanTeath.jpg" hight ="300" width="300"> <br/>
        </div>
          <form>
             <div> 
             <button formaction="dLoginPage.html"> Go to Login Page </button>
             </div>
          </form>       
          </div>
        </div>
          
    </body>
</html>

