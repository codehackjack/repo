package servlet;

import dao.RegisterDao;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.User;
import services.RegisterService;

public class RegisterServlet extends HttpServlet {
    RegisterService registerService;
    RegisterDao registerDao;
    String jdbcUserName;
    String jdbcPassword;
    String jdbcURL;
    
    @Override
    public void init() throws ServletException {
        jdbcURL = getServletContext().getInitParameter("jdbcURL");
        jdbcUserName = getServletContext().getInitParameter("jdbcUserName");
        jdbcPassword = getServletContext().getInitParameter("jdbcPassword");
        
        registerDao = new RegisterDao(jdbcURL, jdbcUserName, jdbcPassword);
        registerService = new RegisterService();
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action=request.getServletPath();
        
        //String action = request.getParameter("submit");
        switch(action){
            case "/new":
                showNewUserForm(request, response);
                break;
                
            case "/insert":
                addUser(request, response);
                break;
            
            case "/edit":
                showEditForm(request, response);
                break;
            
            case "/update":
                updateUser(request, response);
                break;
            
            case "/delete":
                deleteUser(request, response);
                break;
            default:
                viewUsers(request, response);
                break;
           
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
    
    protected void addUser(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String phoneNo = request.getParameter("phoneNo");
        String email = request.getParameter("email");
        
        
        int res = registerService.addUser(firstName,lastName, email, phoneNo, registerDao);
        
        if(res>0){
           RequestDispatcher dispatcher = request.getRequestDispatcher("list");
           dispatcher.forward(request, response);
        } else {
           response.sendRedirect("error.jsp");
        }
    }
    
    protected void viewUsers(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException{
        ArrayList<User> userList = new ArrayList();
        userList = registerService.viewUsers(registerDao);
        
        request.setAttribute("userList", userList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("viewUserList.jsp");
        dispatcher.forward(request, response);
        //response.sendRedirect("viewUserList.jsp");
    }

    private void showNewUserForm(HttpServletRequest request, HttpServletResponse response)
        throws IOException, ServletException{
        RequestDispatcher dispatcher = request.getRequestDispatcher("register.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) 
            throws IOException, ServletException{
        int id = Integer.parseInt(request.getParameter("id"));
        try{
            User user = registerService.showUser(id,registerDao);
            request.setAttribute("user",user);
            
            RequestDispatcher dispatcher = request.getRequestDispatcher("editUserForm.jsp");
            dispatcher.forward(request,response);
            
        } catch(SQLException sqlEx){
            sqlEx.printStackTrace();
        }
    }

    private void updateUser(HttpServletRequest request, HttpServletResponse response) 
            throws IOException, ServletException{
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String phoneNo = request.getParameter("phoneNo");
        String email = request.getParameter("email");
       
        int id = Integer.parseInt(request.getParameter("id"));
        
        User userObj = new User(id,firstName,lastName,phoneNo,email);
        try{
            registerService.updateUser(userObj,registerDao);
        } catch(SQLException ex){
            ex.printStackTrace();
        }
        
        response.sendRedirect("list");
    }
    private void deleteUser(HttpServletRequest request, HttpServletResponse response) 
            throws IOException, ServletException{

        int id = Integer.parseInt(request.getParameter("id"));
        
        User userObj = new User(id);
        try{
            registerService.deleteUser(userObj,registerDao);
        } catch(SQLException ex){
            ex.printStackTrace();
        }
        
        response.sendRedirect("list?id="+id);
    }
}
