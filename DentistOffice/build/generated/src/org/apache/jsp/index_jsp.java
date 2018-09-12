package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Dentist office project  Walter Scott</title>\n");
      out.write("        <style>\n");
      out.write("             .g1{display:grid; \n");
      out.write("                   grid-template-rows:800px;\n");
      out.write("                   grid-gap: 4px;\n");
      out.write("                    \n");
      out.write("                  }     \n");
      out.write("                .g1  div:nth-child(n) {background: #112233;\n");
      out.write("                                 border: 1px solid #00ff33 ; \n");
      out.write("                                 text-align: center;\n");
      out.write("                        }\n");
      out.write("             .g2{display:grid; \n");
      out.write("                   grid-template-columns:800px;\n");
      out.write("                   grid-gap: 4px;\n");
      out.write("                    \n");
      out.write("                  }     \n");
      out.write("                .g2  div:nth-child(n) {background: #112233;\n");
      out.write("                                 border: 1px solid #ff0000 ; \n");
      out.write("                                 text-align: center;\n");
      out.write("                        }           \n");
      out.write("            h1 { display:grid; \n");
      out.write("                   grid-template-columns:800px;\n");
      out.write("                   background: #11aaff;\n");
      out.write("                  \n");
      out.write("                   grid-gap: 2px;\n");
      out.write("                   border: 1px solid #00ff00;\n");
      out.write("                   text-align: center;   \n");
      out.write("            }\n");
      out.write("            \n");
      out.write("            \n");
      out.write("        </style>\n");
      out.write("        \n");
      out.write("        \n");
      out.write("        \n");
      out.write("        \n");
      out.write("    </head>\n");
      out.write("    <body center>\n");
      out.write("        <div class=\"g2\">\n");
      out.write("            <div>\n");
      out.write("        <h1> Chat Dentist Office </h1>\n");
      out.write("          \n");
      out.write("        \n");
      out.write("        \n");
      out.write("        <div>\n");
      out.write("          <img src=\"cleanTeath.jpg\" hight =\"300\" width=\"300\"> <br/>\n");
      out.write("        </div>\n");
      out.write("          <form>\n");
      out.write("             <div> \n");
      out.write("             <button formaction=\"dLoginPage.html\"> Go to Login Page </button>\n");
      out.write("             </div>\n");
      out.write("          </form>       \n");
      out.write("          </div>\n");
      out.write("        </div>\n");
      out.write("          \n");
      out.write("    </body>\n");
      out.write("</html>\n");
      out.write("\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
