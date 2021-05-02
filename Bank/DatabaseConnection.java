//USE~~~
//export CLASSPATH=$CLASSPATH:/usr/share/java/mysql-connector-java-8.0.22.jar
// package Bank;
import java.sql.Connection;
// import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;

public class DatabaseConnection {
    private final static String user = "rohan";
    private final static String password = "Rohankar@11";
    private static Connection conn = null;
    public Statement st = null;

    public DatabaseConnection() throws Exception{
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/ATM", user, password);
            st = conn.createStatement();
        } catch(SQLException sqle){
            System.out.println(sqle);
        }
    }

    // public static void main(String args[]){
    //     try{
    //         ResultSet rs = new DatabaseConnection().st.executeQuery("show databases");
    //         while(rs.next()){
    //             System.out.println(rs.getString("Database"));
    //         }
    //     }
    //     catch(Exception e){
    //         System.out.println(e);
    //     }
    // }
}
