package hospital;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DoctorDAO {
    public void addDoctor(String name, String specialization) {
        try (Connection con = DBConnection.getConnection()) {
            String sql = "INSERT INTO doctors (name, specialization) VALUES (?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, specialization);
            ps.executeUpdate();
            System.out.println("Doctor added successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void viewDoctors() {
        try (Connection con = DBConnection.getConnection()) {
            String sql = "SELECT * FROM doctors";
            ResultSet rs = con.createStatement().executeQuery(sql);
            System.out.println("ID\tName\tSpecialization");
            while (rs.next()) {
                System.out.printf("%d\t%s\t%s%n",
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("specialization"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
