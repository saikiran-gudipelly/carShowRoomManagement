import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Customers {
    public void Customer() throws ClassNotFoundException, SQLException, InterruptedException {

        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("==================================");
            System.out.println("1) Register new customer");
            System.out.println("2) Existing customer login");
            System.out.println("3) Menu");
            System.out.println("4) Exit");

            int choice = sc.nextInt();
            Dashboard dashboard = new Dashboard();

            switch (choice) {
                case 1:
                    Register();
                    break;
                case 2:
                    Login();
                    break;
                case 3:
                    dashboard.Main_Menu();
                case 4:
                    dashboard.Exit();
                    break;
                default:
                    System.out.println("You have entered invalid option. Please try again.");
                    break;
            }
        }
    }

    public void Register() throws ClassNotFoundException, SQLException {
        Scanner sc = new Scanner(System.in);
        String url = "jdbc:mysql://localhost:3306/showroom";
        String user = "root";
        String pass = "Shinchan";
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(url, user, pass);

        System.out.println("Enter Customer ID");
        int cid = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter Customer Name");
        String cname = sc.nextLine();
        System.out.println("Enter customer mobile number");
        String cmobile = sc.nextLine();
        System.out.println("Enter username");
        String username = sc.nextLine();
        System.out.println("Enter password");
        String password = sc.nextLine();
        System.out.println("Enter customer email");
        String cemail = sc.nextLine();
        System.out.println("Enter ID");
        int id = sc.nextInt();

        String sql = "insert into customer (cid, cname, cmobile, cusername, cpassword, cemail, id)  values(?, ?, ?, ?, ?, ?, ?)";

        PreparedStatement st = con.prepareStatement(sql);
        st.setInt(1, cid);
        st.setString(2, cname);
        st.setString(3, cmobile);
        st.setString(4, username);
        st.setString(5, password);
        st.setString(6, cemail);
        st.setInt(7, id);
        int affectedRows = st.executeUpdate();
        if (affectedRows > 0) {
            System.out.println("Registration Success");
        } else {
            System.out.println("Something went wrong please try again!");
        }
    }

    public void Login() throws ClassNotFoundException, SQLException, InterruptedException {

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

        String sql = "select cusername, cpassword from customer where cusername = ? and cpassword = ?";

        PreparedStatement st = con.prepareStatement(sql);

        st.setString(1, username);
        st.setString(2, password);
        ResultSet rs = st.executeQuery();

        if (rs.next()) {
            System.out.println("Successfully Logged in " + username);
            CustomerMenu();
        } else {
            System.out.println("Your login details are wrong please try again");
        }
    }

    public void CustomerMenu() throws ClassNotFoundException, SQLException, InterruptedException {
        while (true) {
            Scanner sc = new Scanner(System.in);
            AdminDashboard adminDashboard = new AdminDashboard();
            RequestCars requestCars = new RequestCars();
            System.out.println("==========================");
            System.out.println("1) Car Info");
            System.out.println("2) Request a Car through mail");
            System.out.println("3) Delete your account");
            System.out.println("4) Menu");
            System.out.println("5) Exit");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    adminDashboard.CarsInfo();
                    break;
                case 2:
                    requestCars.Email();
                    break;
                case 3:
                    Delete();
                    break;
                case 4:
                    Dashboard dashboard = new Dashboard();
                    dashboard.Main_Menu();
                    break;
                case 5:
                    adminDashboard.Exit();
                    break;

                default:
                    System.out.println("You have entered invalid option. Please try agian.");
                    break;
            }
        }
    }

    public void Delete() throws ClassNotFoundException, SQLException {

        Scanner sc = new Scanner(System.in);
        String url = "jdbc:mysql://localhost:3306/showroom";
        String user = "root";
        String pass = "Shinchan";
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(url, user, pass);

        System.out.println("Enter your login username ");
        String username = sc.nextLine();
        System.out.println("Enter your login password to delete your account");
        String password = sc.nextLine();

        String sql = "delete from customer where cusername = ? and cpassword = ?";

        PreparedStatement st = con.prepareStatement(sql);
        st.setString(1, username);
        st.setString(2, password);
        int affectedRows = st.executeUpdate();
        if (affectedRows > 0) {
            System.out.println("Your account deleted successfully");
        } else {
            System.out.println("The account doesen't exist");
        }
    }

}
