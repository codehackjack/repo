/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClientPackage;


import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.RequestDispatcher;


/**
 *
 * @author parminder singh
 */
public class ControllerServlet extends HttpServlet {

   private ClientDAO clientDAO;
   
   
   public void init(){
       String jdbcURL = getServletContext().getInitParameter("jdbcURL");
       String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
       String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");
       
       clientDAO = new ClientDAO(jdbcURL, jdbcUsername, jdbcPassword);
   }
   

  
   
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       String action = request.getServletPath();
       try{
           switch(action){
                case"/new":
                    showNewForm(request, response);
                    break;
                case"/insert":
                    insertClient(request,response);
                    break;
                case "/delete":
                    deleteClient(request, response);
                    break;
                case "/edit":
                    showEditForm(request, response);
                    break;
                case "/update":
                    updateClient(request, response);
                    break;     
                default:
                    listClient(request,response);
                    break;
           }
       }
       catch(SQLException ex){
           throw new ServletException(ex);
       }
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
        
    }
     private void listClient(HttpServletRequest request,HttpServletResponse response)
      throws SQLException, IOException, ServletException
    {
        List<Clients> listClient = clientDAO.listAllClients();
        request.setAttribute("listClient",listClient);
        RequestDispatcher dispatcher = request.getRequestDispatcher("ClientList.jsp");
        dispatcher.forward(request, response);
    }
      private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("ClientForm.jsp");
        dispatcher.forward(request, response);
    }
       private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Clients existingClient = clientDAO.getClient(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("ClientForm.jsp");
        request.setAttribute("client", existingClient);
        dispatcher.forward(request, response);
 
    }
       private void insertClient(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
         int agentid = Integer.parseInt(request.getParameter("agentId"));
            String firstname  = request.getParameter("firstName");
            String lastname  = request.getParameter("lastName");
            String streetnumber  = request.getParameter("streetNumber");
            String streetname  = request.getParameter("streetName");
           String city  = request.getParameter("city");
           String province = request.getParameter("province");
           String postalcode  = request.getParameter("postalCode");
           String teloffice  = request.getParameter("telOffice");
           String telcell  = request.getParameter("telCell");
           String email  = request.getParameter("email");
           String company  = request.getParameter("company");
            String companytype = request.getParameter("companyType");
       
 
        Clients newClient = new Clients(agentid,firstname,lastname,streetnumber,streetname,city,province,postalcode,teloffice,telcell,email,company,companytype);
        clientDAO.insertClient(newClient);
        response.sendRedirect("list");
    }
       private void updateClient(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
         int agentid = Integer.parseInt(request.getParameter("agentId"));
            String firstname  = request.getParameter("firstName");
            String lastname  = request.getParameter("lastName");
            String streetnumber  = request.getParameter("streetNumber");
            String streetname  = request.getParameter("streetName");
           String city  = request.getParameter("city");
           String province = request.getParameter("province");
           String postalcode  = request.getParameter("postalCode");
           String teloffice  = request.getParameter("telOffice");
           String telcell  = request.getParameter("telCell");
           String email  = request.getParameter("email");
           String company  = request.getParameter("company");
            String companytype = request.getParameter("companyType");
 
        Clients client = new Clients(id, agentid,firstname,lastname,streetnumber,streetname,city,province,postalcode,teloffice,telcell,email,company,companytype);
        clientDAO.updateClient(client);
        response.sendRedirect("list");
    }
 
    private void deleteClient(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
 
        Clients client = new Clients(id);
        clientDAO.deleteClient(client);
        response.sendRedirect("list");
 
    }

   


}
