import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;
public class DeleteStudent {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/java_management";
        String username = "root";
        String password = "YOUR_PASSWORD";
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Student ID to delete: ");
        int id = sc.nextInt();
        String sql = "DELETE FROM students WHERE id=?";
        try {
            Connection con = DriverManager.getConnection(url, username, password);
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            int rows = ps.executeUpdate();
            if (rows > 0)
                System.out.println("Student deleted successfully!");
            else
                System.out.println("Student not found.");
            ps.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        sc.close();
    }
}
