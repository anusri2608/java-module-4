import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class DisplayStudent {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/java_management";
        String username = "root";
        String password = "YOUR_PASSWORD";
        String sql = "SELECT * FROM students";
        try {
            Connection con = DriverManager.getConnection(url, username, password);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            System.out.println("ID\tName\tAge\tCourse");
            System.out.println("--------------------------------");
            while (rs.next()) {
                System.out.println(
                    rs.getInt("id") + "\t" +
                    rs.getString("name") + "\t" +
                    rs.getInt("age") + "\t" +
                    rs.getString("course")
                );
            }
            rs.close();
            stmt.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
