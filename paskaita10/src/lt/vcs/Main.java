package lt.vcs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import static lt.vcs.VcsUtils.println;
import static lt.vcs.DbUtils.*;

/**
 *
 * @author aleksandras
 */
public class Main {


    public static void main(String[] args) throws SQLException{
   
        String url = "jdbc:mysql://localhost:3306/";
        String dbName = "vcstestas";
        String userName = "root";
        String password = "";
        Connection conn = newCon(url + dbName, userName, password);
        println("valio, prisijungem prie duomenu bazes");
        

        Statement st = newStatement(conn, true);
        
        ResultSet rs = st.executeQuery("select * from person");
        
        println("Person lenteles duomenys pries update");
        
        println("| ak | name | lastname | age | pet_id");
        
        while (rs.next()){
            
            println("| " + rs.getInt("ak") + " | " + rs.getString("name") + " | " + rs.getString("lastname") + " | " + rs.getInt("age") + " | " + rs.getInt("pet_id"));
            
        }
        
        rs.absolute(3);
        rs.updateString("lastname", "sabonis-vasia");
        rs.updateRow();                                         // update row leidzia updatinti duomenu baze
        
//        rs.moveToInsertRow();
//        rs.updateInt(1, 7);
//        rs.updateString("name", "lucky");
//        rs.updateString("lastname", "seven");
//        rs.updateInt("age", 77);
//        rs.insertRow();                                         // nusiuncia nauja informacija i duomenu baze
        
               
//        rs.absolute(2);
//        rs.deleteRow();                                         // trina eilute is duombazes (nera optimalu, galima daug greiciau, pvz su execute query)
        
        rs.beforeFirst();
        
        println("Person lenteles duomenys PO UPDATE");
        
        println("| ak | name | lastname | age | pet_id");
        
        while (rs.next()){
            
            println("| " + rs.getInt("ak") + " | " + rs.getString("name") + " | " + rs.getString("lastname") + " | " + rs.getInt("age") + " | " + rs.getInt("pet_id"));
            
        }
        
        conn.close();
        
    }
    
}
