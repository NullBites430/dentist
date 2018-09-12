//*********************************************************************
//* Walter Scott  java 3   Dentist office project
//*********************************************************************
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import business.doctor;
import business.patient;
import javax.servlet.RequestDispatcher;

/* SQL stuff */
import java.util.*;
import java.sql.*;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;



/**
 *
 * @author walt310
 */
@WebServlet(urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet
{

//    /**
//     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
//     * methods.
//     *
//     *   request servlet request
//     *   response servlet response
//     * @throws ServletException if a servlet-specific error occurs
//     * @throws IOException if an I/O error occurs
//     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException 
    {
        response.setContentType("text/html;charset=UTF-8");
        System.out.println("it worked maybe");

        doctor nD = new doctor();    
        patient nP = new patient();

  String user1 = request.getParameter("userName1");
  String pass1 = request.getParameter("passWord1");
  
  
  String pfName = request.getParameter("pfName");
  String plName = request.getParameter("plName");
  String pID = request.getParameter("pID");
  String ppw = request.getParameter("ppw");
  String paddr = request.getParameter("paddr");
  String pEmail = request.getParameter("pEmail");
  
  String officeID = request.getParameter("officeID");
  
  String ppdate = request.getParameter("ppdatetimep");
  String pdatetimeps = request.getParameter("pdatetimeps1");
  String patIdps1 = request.getParameter("patIdps1");
  String pdentIdps1 = request.getParameter("pdentIdps1");
  String pprocCodeps1 = request.getParameter("pprocCodeps1");
  
  
  String doStuff1 = request.getParameter("doFunction");

    if (doStuff1 != null)
    {
       if (doStuff1.equalsIgnoreCase("patient update") )
       {
         nP.selectDB(pID);
         nP.setfirstName(pfName);
         nP.setlastName(plName);
         nP.setaddr(paddr);
         nP.setemail(pEmail);
         nP.updateDB();
         
         nP.appList1.selectDB(pID);
         nP.appList1.deleteDB();
         nP.appList1.insertDB(pdatetimeps, patIdps1, pdentIdps1, pprocCodeps1);
       }
       
        if (doStuff1.equalsIgnoreCase("Delete Appointment") )
       {
         nP.selectDB(pID);  
         nP.appList1.selectDB(pID);
         nP.appList1.deleteDB();
       }
        
        if (doStuff1.equalsIgnoreCase("DDS Update") )
       {
         nD.setid(pID);
         nD.setpasswd(ppw);
         nD.setfirstName(pfName);
         nD.setlastName(plName);
         nD.setemail(pEmail);
         nD.setoffice(officeID);
         nD.updateDB();
         
         
       }
        
        
        user1 = pID;
        pass1 = ppw;
        
    }

  
  
        
    if (user1 == null || pass1 == null)
    {   System.out.println("after IF null null");  
       try (PrintWriter out = response.getWriter()) 
       {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Null LoginServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1> Null values       from " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>"); 
            
        } 
    }
    else
    {
        if( (user1.equalsIgnoreCase("admin")) & (pass1.equalsIgnoreCase("123")) )
        {  System.out.println("after IF admin 123");
           try (PrintWriter out = response.getWriter()) 
           {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Valid LoginServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1> Valid Login   user:" + user1.toString() + " from form: " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>"); 
            
           }
            
        }
            else
           {
            if (user1.length() >= 4 )   
            {

              
             
            nD.selectDB(user1);
            nP.selectDB(user1);
            
            request.setAttribute("nD", nD);    
            request.setAttribute("nP", nP);   
            
           if(nP.passWordCheck(pass1))
           {
                     //    newhtmlAccountLookUp
             //    RequestDispatcher tS2 = request.getRequestDispatcher("newhtmlAccountLookUp.html") ;
               
                RequestDispatcher tS2 = request.getRequestDispatcher("DisplayPachent.jsp") ;
                 tS2.forward(request, response);
               
           }   
           else // call the error 
           if(nD.passWordCheck(pass1))
           {
                     //    newhtmlAccountLookUp
             //    RequestDispatcher tS2 = request.getRequestDispatcher("newhtmlAccountLookUp.html") ;
                RequestDispatcher tS2 = request.getRequestDispatcher("DisplayDentist.jsp") ;
                tS2.forward(request, response);
                
           }   
           else // call the error 
           {    
                
                RequestDispatcher tS1 = request.getRequestDispatcher("errorLogin.jsp") ;
                tS1.forward(request, response);
           }

            
       }
            else 
            {
                 RequestDispatcher tS1 = request.getRequestDispatcher("errorLogin") ;
                tS1.forward(request, response);
            }
       }
    }





    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     *   request servlet request
     *   response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     *   request servlet request
     *   response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
