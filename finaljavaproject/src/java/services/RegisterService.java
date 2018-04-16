package services;
import dao.RegisterDao;
import java.sql.SQLException;
import java.util.ArrayList;
import model.User;

public class RegisterService {
    public int addUser(String firstName,String lastName, String phoneNo,String email, RegisterDao dao){
        int res = 0;
        User userObj = new User();
        if(firstName!=null && email!=null){
            userObj.setFirstName(firstName);
            userObj.setLastName(lastName);
            userObj.setPhoneNo(phoneNo);
            userObj.setEmail(email);
             res = dao.addUser(userObj);
        }
        return res;
    }
    
    public ArrayList<User> viewUsers(RegisterDao dao){
        ArrayList<User> userList = new ArrayList();
        userList = dao.viewUsers();
        return userList;
    }
    
    public User showUser(int id, RegisterDao dao) throws SQLException{
        User userObj = dao.showUser(id);
        return userObj;
    }
    
    public boolean updateUser(User userObj, RegisterDao dao) throws SQLException{
        boolean res = dao.updateUser(userObj);
        return res;
    }
     public boolean deleteUser(User userObj, RegisterDao dao) throws SQLException{
        boolean res = dao.deleteUser(userObj);
        return res;
    }
}