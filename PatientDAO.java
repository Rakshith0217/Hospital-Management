package hospital;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PatientDAO {
    public void addPatient(String name, int age, String gender) 
    {
        try (Connection con = DBConnection.getConnection()) {
            String sql = "INSERT INTO patients (name, age, gender) VALUES (?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, name);
            ps.setInt(2, age);
            ps.setString(3, gender);
            ps.executeUpdate();
            System.out.println("Patient added successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void viewPatients() {
        try (Connection con = DBConnection.getConnection()) {
            String sql = "SELECT * FROM patients";
            ResultSet rs = con.createStatement().executeQuery(sql);
            System.out.println("ID\tName\tAge\tGender");
            while (rs.next()) {
                System.out.printf("%d\t%s\t%d\t%s%n",
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("age"),
                        rs.getString("gender"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
