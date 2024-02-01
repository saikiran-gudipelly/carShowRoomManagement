import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Executives {
    AdminDashboard adminDashboard = new AdminDashboard();
    Dashboard dashboard = new Dashboard();

    public void Executive() throws ClassNotFoundException, SQLException, InterruptedException {

        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("==============================");
            System.out.println("1) Login");
            System.out.println("2) Menu");
            System.out.println("3) Exit");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    Login();
                    break;
                case 2:
                    Menu();
                    break;
                case 3:
                    Exit();
                    break;
                default:
                    System.out.println("You have entered invalid option please try again.");
                    break;
            }
        }
    }

    public void Login() throws SQLException, ClassNotFoundException, InterruptedException {

        Scanner sc = new Scanner(System.in);
        String url = "jdbc:mysql://localhost:3306/showroom";
        String user = "root";
        String pass = "Shinchan";
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(url, user, pass);

        System.out.println("Enter username");
        String username = sc.nextLine();
        System.out.println("Enter password");
        String password = sc.nextLine();

        String sql = "select eusername, epassword from executive where eusername = ? and epassword = ?";

        PreparedStatement st = con.prepareStatement(sql);
        st.setString(1, username);
        st.setString(2, password);
        ResultSet rs = st.executeQuery();
        if (rs.next()) {
            System.out.println("Successfully Logged in " + username);
            ExecutiveMenu();

        } else {
            System.out.println("You have entered wrong login details. Please try again");
        }
    }

    public void ExecutiveMenu() throws ClassNotFoundException, SQLException, InterruptedException {

        Scanner sc = new Scanner(System.in);
        while (true) {

            System.out.println("1) Car Info");
            System.out.println("2) Request Cars");
            System.out.println("3) ViewReports");
            System.out.println("4) Menu");
            System.out.println("5) Exit");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    CarInfo();
                    break;
                case 2:
                    RequestCars();
                    break;
                case 3:
                    ViewReport();
                    break;
                case 4:
                    Menu();
                    break;
                case 5:
                    Exit();
                    break;
                default:
                    break;
            }
        }
    }

    public void CarInfo() throws ClassNotFoundException, SQLException {

        adminDashboard.CarsInfo();

    }

    public void RequestCars() {
        adminDashboard.RequestCars();

    }

    public void ViewReport() throws ClassNotFoundException, SQLException, InterruptedException {
        ViewReports viewReports = new ViewReports();
        viewReports.viewReport1();
    }

    public void Menu() throws ClassNotFoundException, SQLException, InterruptedException {
        dashboard.Main_Menu();

    }

    public void Exit() throws InterruptedException {
        dashboard.Exit();
    }

}
