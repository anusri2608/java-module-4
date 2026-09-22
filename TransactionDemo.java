import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
public class TransactionDemo {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/java_management";
        String username = "root";
        String password = "YOUR_PASSWORD";
        try {
            Connection con = DriverManager.getConnection(url, username, password);
            con.setAutoCommit(false);
            String sql = "UPDATE students SET age=? WHERE id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, 21);
            ps.setInt(2, 1);
            ps.executeUpdate();
            con.commit();
            System.out.println("Transaction completed successfully!");
            ps.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Transaction failed!");
        }
    }
}
