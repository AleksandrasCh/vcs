package lt.vcs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import static lt.vcs.VcsUtils.*;

/**
 *
 * @author aleksandras
 */
public class Registration {
    
    private final String user;
    
    public Registration (String user) {
        
        this.user = user;
        
    }
    
    public void newUser () throws SQLException{
        
        String pw = inputLine("Naudotojas " + user + " iveskite savo nauja slaptazodi");
        
        String url = "jdbc:mysql://localhost:3306/";
        String dbName = "pokerdiceuser";
        String userName = "root";
        String password = "";
        Connection conn = DriverManager.getConnection(url + dbName, userName, password);
        
        Statement st = conn.createStatement();
        
        st.executeUpdate("insert into person values ('" + user + "', '" + pw + "')");
        
        conn.close();
    }

}
