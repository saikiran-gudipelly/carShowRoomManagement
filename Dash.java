import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

class Dashboard {

    Scanner sc = new Scanner(System.in);

    public void Main_Menu() throws ClassNotFoundException, SQLException, InterruptedException {
        while (true) {

            System.out.println("==========================================");
            System.out.println("1) Admin");
            System.out.println("2) Manager");
            System.out.println("3) Executive");
            System.out.println("4) Customer");
            System.out.println("5) Exit");
            System.out.println("==========================================");

            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    Admin();
                    break;
                case 2:
                    Manager();
                    break;
                case 3:
                    Executive();
                    break;
                case 4:
                    Customer();
                    break;
                case 5:
                    Exit();
                    break;
                default:
                    System.out.println("You have entered invalid option. Please try again!");
                    break;
            }

        }
    }

    public void Admin() throws ClassNotFoundException, SQLException, InterruptedException {

        Scanner sc = new Scanner(System.in);
        // JDBC Conncetion
        String url = "jdbc:mysql://localhost:3306/showroom";
        String user = "root";
        String pass = "Shinchan";
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(url, user, pass);

        System.out.println("Enter username");
        String username = sc.nextLine();
        System.out.println("Enter password");
        String password = sc.nextLine();

        // Sql query
        String sql = "select ausername, apassword from admin where ausername =? AND apassword = ?";

        PreparedStatement st = con.prepareStatement(sql);
        st.setString(1, username);
        st.setString(2, password);
        ResultSet rs = st.executeQuery();
        if (rs.next()) {
            AdminDashboard adminDashboard = new AdminDashboard();
            System.out.println("Welcome to Happy Showroom : " + username);
            adminDashboard.ADashboard();

        } else {
            System.out.println("You have entered an invalid username or password. Please try again!");

            // con.close();
            // sc.close();
        }

    }

    public void Manager() throws ClassNotFoundException, SQLException, InterruptedException {
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

        String sql = "select musername, mpassword from manager where musername = ? and mpassword = ? ";

        PreparedStatement st = con.prepareStatement(sql);
        st.setString(1, username);
        st.setString(2, password);
        ResultSet rs = st.executeQuery();
        if (rs.next()) {
            System.out.println("Welcome to Happy Showroom : " + username);
            Managers managers = new Managers();
            managers.MangerMenu();

        } else {
            System.out.println("You have entered invalid login details. Please try again!");
        }

    }

    public void Executive() throws ClassNotFoundException, SQLException, InterruptedException {

        Executives executives = new Executives();
        executives.Executive();

    }

    public void Customer() throws ClassNotFoundException, SQLException, InterruptedException {

        Customers customers = new Customers();
        customers.Customer();

    }

    public void Exit() throws InterruptedException {
        System.out.print("Exiting");
        for (int i = 1; i <= 5; i++) {
            System.out.print(".");
            Thread.sleep(1000);
        }
        System.exit(0);
    }

    public class Dash {

    }
}
