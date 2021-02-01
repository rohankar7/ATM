//USE~~~
//export CLASSPATH=$CLASSPATH:/usr/share/java/mysql-connector-java-8.0.22.jar
// package Bank;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;

public class DatabaseConnection {
    private final static String user = "root";
    private final static String password = "";
    private static Connection conn = null;
    public Statement st = null;

    public DatabaseConnection() throws Exception{
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/", user, password);
            st = conn.createStatement();
        } catch(SQLException sqle){
            System.out.println(sqle);
        }
    }
}
