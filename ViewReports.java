import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class ViewReports {

    public void viewReport1() throws SQLException, InterruptedException, ClassNotFoundException {
        AdminDashboard adminDashboard = new AdminDashboard();

        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("=====================================");
            System.out.println("1) Cars Report");
            System.out.println("2) Managers Report");
            System.out.println("3) Executives Report");
            System.out.println("4) Customers Report");
            System.out.println("5) Menu");
            System.out.println("6) Exit");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    adminDashboard.CarsInfo();
                    break;
                case 2:
                    MangersReport();
                    break;
                case 3:
                    ExecutiveReport();
                    break;
                case 4:
                    CustomerReport();
                    break;
                case 5:
                    Menu();
                    break;
                case 6:
                    Exit();
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 6.");
                    break;
            }
        }
    }

    public static void MangersReport() throws ClassNotFoundException, SQLException {

        Scanner sc = new Scanner(System.in);

        String url = "jdbc:mysql://localhost:3306/showroom";
        String user = "root";
        String pass = "Shinchan";
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(url, user, pass);

        String sql = "select * from manager";

        PreparedStatement st = con.prepareStatement(sql);
        try (ResultSet rs = st.executeQuery()) {
            while (rs.next()) {
                int mid = rs.getInt(1);
                String mname = rs.getString(2);
                String mmobile = rs.getString(3);
                String musername = rs.getString(4);
                String mpassword = rs.getString(5);
                String memail = rs.getString(6);
                int id = rs.getInt(7);

                System.out.println(" mid = " + mid + " " + " mname = " + mname + " " + " mmobile = " + mmobile
                        + " musername =  " + musername + " mpassword = " + mpassword + " memail = " + memail + " id = "
                        + id);
            }
        }

    }

    public static void ExecutiveReport() throws ClassNotFoundException, SQLException {
        Scanner sc = new Scanner(System.in);

        String url = "jdbc:mysql://localhost:3306/showroom";
        String user = "root";
        String pass = "Shinchan";
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(url, user, pass);

        String sql = "select * from executive";

        PreparedStatement st = con.prepareStatement(sql);
        ResultSet rs = st.executeQuery();
        while (rs.next()) {
            int eid = rs.getInt(1);
            String ename = rs.getString(2);
            String emobile = rs.getString(3);
            String eusername = rs.getString(4);
            String epassword = rs.getString(5);
            String eemail = rs.getString(6);
            int id = rs.getInt(7);

            System.out.println(" mid = " + eid + " " + " mname = " + ename + " " + " mmobile = " + emobile
                    + " musername =  " + eusername + " mpassword = " + epassword + " memail = " + eemail + " id = "
                    + id);
        }
    }

    public static void CustomerReport() throws ClassNotFoundException, SQLException {

        Scanner sc = new Scanner(System.in);

        String url = "jdbc:mysql://localhost:3306/showroom";
        String user = "root";
        String pass = "Shinchan";
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(url, user, pass);

        String sql = "select * from customer";

        PreparedStatement st = con.prepareStatement(sql);
        ResultSet rs = st.executeQuery();
        while (rs.next()) {
            int cid = rs.getInt(1);
            String cname = rs.getString(2);
            String cmobile = rs.getString(3);
            String cusername = rs.getString(4);
            String cpassword = rs.getString(5);
            String cemail = rs.getString(6);
            int id = rs.getInt(7);

            System.out.println(" cid = " + cid + " " + " cname = " + cname + " " + " cmobile = " + cmobile
                    + " cusername =  " + cusername + " cpassword = " + cpassword + " cemail = " + cemail + " id = "
                    + id);

        }

    }

    public static void Menu() throws InterruptedException, ClassNotFoundException, SQLException {
        Dashboard dashboard = new Dashboard();
        dashboard.Main_Menu();
    }

    public static void Exit() throws InterruptedException {
        Dashboard dashboard = new Dashboard();
        dashboard.Exit();
    }
}
