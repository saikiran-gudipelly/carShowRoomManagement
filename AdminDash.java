import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

class AdminDashboard {

    public void ADashboard() {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("1) Add Location ");
            System.out.println("2) Add Manager");
            System.out.println("3) Add Cars");
            System.out.println("4) Car info ");
            System.out.println("5) Request Cars");
            System.out.println("6) View Report");
            System.out.println("7) Menu");
            System.out.println("8) Exit");

            int choice = sc.nextInt();
            sc.nextLine();

            try {
                switch (choice) {
                    case 1:
                        AddLocation();
                        break;
                    case 2:
                        AddManager();
                        break;
                    case 3:
                        AddCars();
                        break;
                    case 4:
                        CarsInfo();
                        break;
                    case 5:
                        RequestCars();
                        break;
                    case 6:
                        ViewReport2();

                        break;
                    case 7:
                        Dashboard dashboard = new Dashboard();
                        dashboard.Main_Menu();
                        break;
                    case 8:
                        Exit();
                        break;
                    default:
                        System.out.println("You have entered invalid option. Please try again!");
                        break;
                }

            } catch (ClassNotFoundException | SQLException | InterruptedException e) {
                // Handle or log the exceptions as needed
                e.printStackTrace();
            }
        }
    }

    public void AddLocation() throws ClassNotFoundException, SQLException {
        Scanner sc = new Scanner(System.in);
        String url = "jdbc:mysql://localhost:3306/showroom";
        String user = "root";
        String pass = "Shinchan";
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(url, user, pass);

        System.out.println("Enter your City");
        String City = sc.nextLine();
        System.out.println("Enter your State");
        String State = sc.nextLine();

        String sql = "insert into location (City, State) values (?, ?)";
        PreparedStatement st = con.prepareStatement(sql);
        st.setString(1, City);
        st.setString(2, State);
        int affectedRows = st.executeUpdate();
        if (affectedRows > 0) {
            System.out.println("Your location has been added successfully");
        } else {
            System.out.println("Something went wrong! Please try again.");
        }
    }

    public void AddManager() throws ClassNotFoundException, SQLException {
        Scanner sc = new Scanner(System.in);
        String url = "jdbc:mysql://localhost:3306/showroom";
        String user = "root";
        String pass = "Shinchan";
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(url, user, pass);

        System.out.println("Enter Manager ID");
        int mid = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter Manager Name");
        String mname = sc.nextLine();
        System.out.println("Enter Manager Mobile Number");
        String mmobile = sc.nextLine();
        System.out.println("Enter Manager Username");
        String musername = sc.nextLine();
        System.out.println("Enter Manager Password");
        String mpassword = sc.nextLine();
        System.out.println("Enter Manager Email");
        String memail = sc.nextLine();
        System.out.println("Enter Id");
        int id = sc.nextInt();

        String sql = "insert into manager (mid, mname, mmobile, musername, mpassword, memail, id) values (?, ?, ?, ?, ?, ?, ?) ";

        PreparedStatement st = con.prepareStatement(sql);
        st.setInt(1, mid);
        st.setString(2, mname);
        st.setString(3, mmobile);
        st.setString(4, musername);
        st.setString(5, mpassword);
        st.setString(6, memail);
        st.setInt(7, id);

        int affectedRows = st.executeUpdate();
        if (affectedRows > 0) {
            System.out.println("Manger details added successfully");
        } else {
            System.out.println("Something went wrong. Please try again!");
        }
    }

    public void AddCars() throws ClassNotFoundException, SQLException {
        Scanner sc = new Scanner(System.in);
        String url = "jdbc:mysql://localhost:3306/showroom";
        String user = "root";
        String pass = "Shinchan";
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(url, user, pass);

        System.out.println("Enter Car ID");
        int cid = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter Car Name");
        String cname = sc.nextLine();
        System.out.println("Enter Car Model");
        String cmodel = sc.nextLine();
        System.out.println("Enter Manufacture Year");
        int cyear = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter Price");
        String cprice = sc.nextLine();
        System.out.println("Type of Car");
        String cabout = sc.nextLine();
        System.out.println("Enter Manager ID");
        int mid = sc.nextInt();

        String sql = "insert into car (cid, cname, cmodel, cyear, cprice, cabout, mid) values (?, ?, ?, ?, ?, ?, ?)";

        PreparedStatement st = con.prepareStatement(sql);
        st.setInt(1, cid);
        st.setString(2, cname);
        st.setString(3, cmodel);
        st.setInt(4, cyear);
        st.setString(5, cprice);
        st.setString(6, cabout);
        st.setInt(7, mid);

        int affectedRows = st.executeUpdate();

        if (affectedRows > 0) {
            System.out.println("Car details updated successfully");
        } else {
            System.out.println("Something went wrong. Please try again!");
        }
    }

    public void CarsInfo() throws ClassNotFoundException, SQLException {
        Scanner sc = new Scanner(System.in);
        String url = "jdbc:mysql://localhost:3306/showroom";
        String user = "root";
        String pass = "Shinchan";
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(url, user, pass);
        String sql = "select * from car";

        PreparedStatement st = con.prepareStatement(sql);
        ResultSet rs = st.executeQuery();

        while (rs.next()) {
            int cid = rs.getInt("cid");
            String cname = rs.getString("cname");
            String cmodel = rs.getString("cmodel");
            int cyear = rs.getInt("cyear");
            String cprice = rs.getString("cprice");
            String cabout = rs.getString("cabout");
            int mid = rs.getInt("mid");

            System.out.println("cid = :" + cid + "  cname = :" + cname + "  cmodel = :" + cmodel
                    + "  cyear = :"
                    + cyear + "  cprice = :" + cprice + "  cabout = :" + cabout + "  mid = :" + mid);
        }
    }

    public void RequestCars() {
        RequestCars requestCars = new RequestCars();
        requestCars.Email();
    }

    public void ViewReport2() throws ClassNotFoundException, SQLException, InterruptedException {
        ViewReports viewReports = new ViewReports();
        viewReports.viewReport1();
    }

    public void Exit() throws InterruptedException {
        Dashboard dashboard = new Dashboard();
        dashboard.Exit();

    }

}

public class AdminDash {

}
