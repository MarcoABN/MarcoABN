
package models;

import beans.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import resources.ConnectionFactory;

public class UserDAO {
    
    private Connection conn;
    private PreparedStatement stmt;
    private ResultSet rs;

    public UserDAO() {
        conn = new ConnectionFactory().getConnection();
    }
    
    public User findByUsername(String username){
        
        User user = null;
        String sql = "select * from user where username = ?";
        try {
        stmt = this.conn.prepareStatement(sql);
        stmt.setString(1, username);
        
        rs = stmt.executeQuery();
        if (rs.next()) {
            user = new User();
            user.setUser_id(rs.getInt("user_id"));
            user.setEmail(rs.getString("email"));
            user.setEnabled(rs.getBoolean("enabled"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
        }
        
        } catch (SQLException e){
            throw new RuntimeException (e);
        }
        return user;
    }
    
}