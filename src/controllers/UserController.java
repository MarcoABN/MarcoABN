package controllers;

import beans.User;
import models.UserDAO;

public class UserController {
    
    private UserDAO userDao;

    public UserController() {
        userDao = new UserDAO();
    }

    public boolean login(User user) {
        
        User fetechedUser = userDao.findByUsername(user.getUsername());
        
        if (fetechedUser != null ) {
            
            if (fetechedUser.getPassword().equals(user.getPassword())) {
                Application.setUser(fetechedUser);
                return true;
            }           
        }
        return false;
    }
    
}
