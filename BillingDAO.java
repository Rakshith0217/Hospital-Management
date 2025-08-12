package hospital;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BillingDAO {
    public void addBill(int patientId, double amount) {
        try (Connection con = DBConnection.getConnection()) {
            String sql = "INSERT INTO billing (patient_id, amount) VALUES (?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, patientId);
            ps.setDouble(2, amount);
            ps.executeUpdate();
            System.out.println("Bill added successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void viewBills() {
        try (Connection con = DBConnection.getConnection()) {
            String sql = "SELECT b.id, p.name AS patient, b.amount, b.date " +
                         "FROM billing b JOIN patients p ON b.patient_id = p.id";
            ResultSet rs = con.createStatement().executeQuery(sql);
            System.out.println("ID\tPatient\tAmount\tDate");
            while (rs.next()) {
                System.out.printf("%d\t%s\t%.2f\t%s%n",
                        rs.getInt("id"),
                        rs.getString("patient"),
                        rs.getDouble("amount"),
                        rs.getTimestamp("date").toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
