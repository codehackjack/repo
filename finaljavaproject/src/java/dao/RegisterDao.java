package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.User;

public class RegisterDao {
    private String url;
    private String userDB;
    private String passDB;
  
    
    public RegisterDao(){
    }
    
    public RegisterDao(String url, String userDB, String passDB){
        this.url = url;
        this.userDB = userDB;
        this.passDB = passDB;
    }
    
       protected Connection getConnection(){
       Connection conn = null;
       try{
           Class.forName("com.mysql.jdbc.Driver");
           if(conn==null || conn.isClosed()){
                conn = DriverManager.getConnection(url, userDB, passDB);
           }
       } catch(SQLException sqlEx){
           sqlEx.printStackTrace();
       } catch(ClassNotFoundException ex){
           ex.printStackTrace();
       }
       return conn;
   }
    
    public int addUser(User userObj){
        int res = 0;
        String sql = "INSERT INTO marketingagent (id,firstName,lastName,phoneNo,email) VALUES (?,?,?,?)";
        try{
            Connection conn = getConnection();
            if(conn!=null){
                PreparedStatement stmt = conn.prepareStatement(sql);
               
                stmt.setString(1,userObj.getFirstName());
          
                stmt.setString(2, userObj.getLastName());
                 stmt.setString(3, userObj.getPhoneNo());
                  stmt.setString(4, userObj.getEmail());
                res = stmt.executeUpdate();
                conn.close();
            }
            
        } catch (SQLException sqlEx){
            sqlEx.printStackTrace();
        }
        return res;
    }
    
   public ArrayList<User> viewUsers(){
       ArrayList<User> userList = new ArrayList();
       String sql = "SELECT * FROM marketingagent";
       String firstName = "";
       String lastName = "";
       String phoneNo = "";
       String email = "";
       

       int id = 0;
       
       try{
        Connection conn = getConnection();
        Statement stmt = conn.createStatement();
        ResultSet resultSet = stmt.executeQuery(sql);

        while(resultSet.next()){
             
            firstName = resultSet.getString("firstName");
            lastName = resultSet.getString("lastName");
             phoneNo = resultSet.getString("phoneNo");
             email = resultSet.getString("email");
             
            
            
            id = resultSet.getInt("id");
            
            User userObj = new User();
            
            userObj.setUserId(id);
            userObj.setFirstName(firstName);
            userObj.setLastName(lastName);
            userObj.setPhoneNo(phoneNo);
            userObj.setEmail(email);
            
            
            userList.add(userObj);
        }
       resultSet.close();
       stmt.close();
        if(conn!=null && !conn.isClosed()){
         conn.close();
        }
       } catch(SQLException sqlEx){
           sqlEx.printStackTrace();
       }
       return userList;
   }
   
   public User showUser(int id) throws SQLException{
       User userObj = null;
       String sql = "SELECT * FROM marketingagent ";
       sql += "WHERE id = ?";
       
       Connection con = getConnection();
       PreparedStatement statement = con.prepareStatement(sql);
       statement.setInt(1, id);
       ResultSet result = statement.executeQuery();
       
       while(result.next()){
           userObj = new User();
           userObj.setUserId(result.getInt("id"));
           userObj.setFirstName(result.getString("firstName"));
           userObj.setLastName(result.getString("lastName"));
           userObj.setPhoneNo(result.getString("phoneNo"));
           userObj.setEmail(result.getString("email"));
          
       }
       return userObj;
   }
   
   public boolean updateUser(User userObj) throws SQLException{
       boolean res;
       String sql = "UPDATE marketingagent SET firstName = ?, lastName = ?, phoneNO = ?,email = ? ";
       sql += "WHERE id = ?";
       
       Connection con = getConnection();
       PreparedStatement statement = con.prepareStatement(sql);
       
      
       statement.setString(1, userObj.getFirstName());
       statement.setString(2, userObj.getLastName());
      statement.setString(3, userObj.getPhoneNo());
      statement.setString(4, userObj.getEmail());
       statement.setInt(5, userObj.getUserId());
       res = statement.executeUpdate() > 0;
       
       return res;
   
   }
   public boolean deleteUser(User userObj) throws SQLException{
       boolean res;
       String sql = "delete from marketingagent ";
       sql += "WHERE id = ?";
       
       Connection con = getConnection();
       PreparedStatement statement = con.prepareStatement(sql);
      
       statement.setInt(1, userObj.getUserId());
       
       res = statement.executeUpdate() > 0;
       
       return res;
   }
}
