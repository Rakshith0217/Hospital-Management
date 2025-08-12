package hospital;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AppointmentDAO {
    public void bookAppointment(int patientId, int doctorId, String date) {
        try (Connection con = DBConnection.getConnection()) {
            String sql = "INSERT INTO appointments (patient_id, doctor_id, date) VALUES (?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, patientId);
            ps.setInt(2, doctorId);
            ps.setString(3, date);
            ps.executeUpdate();
            System.out.println("Appointment booked successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void viewAppointments() {
        try (Connection con = DBConnection.getConnection()) {
            String sql = "SELECT a.id, p.name AS patient, d.name AS doctor, a.date " +
                         "FROM appointments a " +
                         "JOIN patients p ON a.patient_id = p.id " +
                         "JOIN doctors d ON a.doctor_id = d.id";
            ResultSet rs = con.createStatement().executeQuery(sql);
            System.out.println("ID\tPatient\tDoctor\tDate");
            while (rs.next()) {
                System.out.printf("%d\t%s\t%s\t%s%n",
                        rs.getInt("id"),
                        rs.getString("patient"),
                        rs.getString("doctor"),
                        rs.getString("date"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
