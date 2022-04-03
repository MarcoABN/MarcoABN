
package resources;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    
    private String url = "jdbc:mysql://localhost:3306/world";
    private String user = "root";
    private String password = "ma199125";
    
    public Connection getConnection(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection(this.url, this.user, this.password);
          } catch (SQLException e) {
              throw new RuntimeException(e);
          }catch (ClassNotFoundException e){
              throw new RuntimeException(e.getMessage());
        }
    }
    
}
