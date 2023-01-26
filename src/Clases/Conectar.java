
package Clases;

import java.sql.Connection;
import java.sql.DriverManager;


/**
 *
 * @author misa_
 */
public class Conectar {
   
   public static final String URL = "jdbc:mysql://localhost:3308/escuel@";
    public static final String USER = "root";
    public static final String CLAVE = "";
     
    public Connection getConexion(){
        Connection con = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = (Connection) DriverManager.getConnection(URL, USER, CLAVE);
            System.out.println("Connected"); 
        }catch(Exception e){
            System.out.println("Error: " + e.getMessage());
        }
        return con;
    }

  
    
}
  