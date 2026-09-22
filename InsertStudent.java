import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;
public class InsertStudent {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/java_management";
        String username = "root";
        String password = "YOUR_PASSWORD";
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Age: ");
        int age = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Course: ");
        String course = sc.nextLine();
        String sql = "INSERT INTO students (id, name, age, course) VALUES (?, ?, ?, ?)";
        try {
            Connection con = DriverManager.getConnection(url, username, password);
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setInt(3, age);
            ps.setString(4, course);
            ps.executeUpdate();
            System.out.println("Student inserted successfully!");
            ps.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        sc.close();
    }
}
