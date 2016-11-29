package lt.vcs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import static lt.vcs.VcsUtils.*;

/**
 *
 * @author aleksandras
 */
public class Login {
    
    private final String user;
    
    public Login (String user) {
        
        this.user = user;
        
    }
    
    public boolean checkUser () throws SQLException{
        
        boolean login = false;
        
        String url = "jdbc:mysql://localhost:3306/";
        String dbName = "pokerdiceuser";
        String userName = "root";
        String password = "";
        Connection conn = DriverManager.getConnection(url + dbName, userName, password);
        
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("select * from person");
        
        while (rs.next()){
            
           String vardas = rs.getString("name");
           if (vardas.equalsIgnoreCase(user)){
               
              String pw =  inputLine("Sveiki " + vardas + ". Iveskite savo slaptazodi");
              
                if(pw.equals(rs.getString("password"))){
                    println("Jus sekmingai prisijungete prie zaidimo!");
                    login = true;
                } else {
                    println("Ivestas slaptazodis neteisingas!");
                }
                
           }
           
        }
        
        conn.close();
        
        return login;
    }

    public String getUser() {
        return user;
    }
    
}
