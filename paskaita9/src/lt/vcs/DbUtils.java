package lt.vcs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author aleksandras
 */
public class DbUtils {
    
    public static Connection newCon(String url, String userName, String password) throws SQLException{
        
        return DriverManager.getConnection(url, userName, password);
    }
    
    public static Statement newStatement(Connection newCon, boolean updatable) throws SQLException{
        
        if (updatable = true){
            return newCon.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        } else {
            return newCon.createStatement();
        }
        
    }
    
}
