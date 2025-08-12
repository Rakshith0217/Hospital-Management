package hospital;

import java.util.Scanner;

public class HospitalMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PatientDAO patientDAO = new PatientDAO();
        DoctorDAO doctorDAO = new DoctorDAO();
        AppointmentDAO appointmentDAO = new AppointmentDAO();
        BillingDAO billingDAO = new BillingDAO();

        while (true) {
            System.out.println("\n=== Hospital Management System ===");
            System.out.println("1. Add Patient");
            System.out.println("2. View Patients");
            System.out.println("3. Add Doctor");
            System.out.println("4. View Doctors");
            System.out.println("5. Book Appointment");
            System.out.println("6. View Appointments");
            System.out.println("7. Add Bill");
            System.out.println("8. View Bills");
            System.out.println("9. Exit");
            System.out.print("Enter choice: ");

            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    System.out.print("Enter Name: ");
                    String pname = sc.nextLine();
                    System.out.print("Enter Age: ");
                    int age = Integer.parseInt(sc.nextLine());
                    System.out.print("Enter Gender: ");
                    String gender = sc.nextLine();
                    patientDAO.addPatient(pname, age, gender);
                    break;

                case 2:
                    patientDAO.viewPatients();
                    break;

                case 3:
                    System.out.print("Enter Name: ");
                    String dname = sc.nextLine();
                    System.out.print("Enter Specialization: ");
                    String spec = sc.nextLine();
                    doctorDAO.addDoctor(dname, spec);
                    break;

                case 4:
                    doctorDAO.viewDoctors();
                    break;

                case 5:
                    System.out.print("Enter Patient ID: ");
                    int pid = Integer.parseInt(sc.nextLine());
                    System.out.print("Enter Doctor ID: ");
                    int did = Integer.parseInt(sc.nextLine());
                    System.out.print("Enter Date (YYYY-MM-DD): ");
                    String date = sc.nextLine();
                    appointmentDAO.bookAppointment(pid, did, date);
                    break;

                case 6:
                    appointmentDAO.viewAppointments();
                    break;

                case 7:
                    System.out.print("Enter Patient ID: ");
                    int bpid = Integer.parseInt(sc.nextLine());
                    System.out.print("Enter Amount: ");
                    double amt = Double.parseDouble(sc.nextLine());
                    billingDAO.addBill(bpid, amt);
                    break;

                case 8:
                    billingDAO.viewBills();
                    break;

                case 9:
                    System.out.println("Exiting...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
