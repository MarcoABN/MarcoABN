
package controllers;

import beans.User;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JPanel;
import views.Layout;
import views.LoginUI;

public class Application {
    
    private static Layout layout = new Layout ();
    
    private static User user;
    
    public static void main(String[] args) {
        Application app = new Application();
        app.init();
    }

    public static User getUser() {
        return user;
    }

    public static void setUser(User aUser) {
        user = aUser;
    }
    
    private void init() {
        layout.setVisible(true);
        
        if (getUser() == null){
            LoginUI login = new LoginUI (layout, true);
            //evento quando fechar a janela
            login.addWindowListener(new WindowAdapter() {
                public void windowClosing (WindowEvent e) {
                    if (getUser() == null)
                        System.exit(0);
                }
            });
            login.setVisible(true);
        }
    }
    
    public static void redesenhar (JPanel panel){
        layout.getContentPane().removeAll();
        
        layout.setContentPane(panel);
        
        layout.validate();
        layout.repaint();
    }
    
}
