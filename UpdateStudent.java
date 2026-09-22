import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;
public class UpdateStudent {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/java_management";
        String username = "root";
        String password = "YOUR_PASSWORD";
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Student ID to update: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter new Name: ");
        String name = sc.nextLine();
        System.out.print("Enter new Age: ");
        int age = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter new Course: ");
        String course = sc.nextLine();
        String sql = "UPDATE students SET name=?, age=?, course=? WHERE id=?";
        try {
            Connection con = DriverManager.getConnection(url, username, password);
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, name);
            ps.setInt(2, age);
            ps.setString(3, course);
            ps.setInt(4, id);
            int rows = ps.executeUpdate();
            if (rows > 0)
                System.out.println("Student updated successfully!");
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
