package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Admin;
import model.MainDAO;

/**
 *
 * @author rajyawardhan
 */
public class AddAdmin extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
           String aid = null;
           String aname = null;
           String apass = null;
           String acontact = null;
           String amail =null;
            try {
            
            aid = request.getParameter("id");
            apass = request.getParameter("pass");
            aname = request.getParameter("name");
            acontact = request.getParameter("contact");
            amail = request.getParameter("mail");
            
            Admin A = new Admin();
            A.setId(aid);
            A.setPass(apass);
            A.setName(aname);
            A.setContact(acontact);
            A.setMail(amail);
            
            MainDAO md = new MainDAO();
         
            if(md.addAdmin(A))
                response.sendRedirect("adminhome.jsp");
            else
                response.sendRedirect("addadmin.jsp?state=invalid");
        }
        catch(Exception e)
        {
            out.println(e);
            response.sendRedirect("addadmin.jsp?state=invalid");
        }
//        finally
//        {
//            out.println(aid);
//            out.println(aname);
//            out.println(apass);
//            out.println(amail);
//            out.println(acontact);
//        }
    }
}

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
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
     * @param request servlet request
     * @param response servlet response
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
