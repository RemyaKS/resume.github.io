/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package task;
import java.sql.*;

/**
 *
 * @author nsti w
 */
public class Task {

   private static final String URL = "jdbc:mysql://localhost:3306/registerlogin";
    private static final String USER = "root";
    private static final String PASSWORD = "nsti";
    
       public static void register(String username, String password, String email){
        String query = "insert into register(username,password,email)values(?,?,?)";
        try(Connection conn = DriverManager.getConnection(URL,USER,PASSWORD);
               PreparedStatement ps = conn.prepareStatement(query)){
            ps.setString(1,username);
            ps.setString(2,password);
            ps.setString(3,email);
           
            ps.executeUpdate();
           
            System.out.println("Registration Success!");
           
        }
        catch(SQLException e){
            System.out.println(e);
        }
    }
         public static void login(String username, String password){
       String query = "SELECT * FROM register WHERE username=? AND password=?";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
           
            if(rs.next()) {
                // Valid credentials, create a session
                String uname = rs.getString("username");
                System.out.println("Hello "+uname+" Welcome to home page");
               
            } else {
                // Invalid credentials
                System.out.println("Invalid username or password.");
               
            }
        } catch (SQLException e) {
            System.out.println(e);
         
        }
           
    }
    public static void main(String[] args) {
        
        // TODO code application logic here
           register("Remya", "remya@12","remya@gmail.com");
      // login("Remya","remya@12");
    }
    
}
