import java.sql.SQLException;
import java.util.Scanner;

public class Managers {

    public void MangerMenu() throws ClassNotFoundException, SQLException, InterruptedException {
        while (true) {
            AdminDashboard adminDashboard = new AdminDashboard();
            ViewReports viewReports = new ViewReports();
            System.out.println("**************Manager Dashboard*******************");
            System.out.println("1) Add Cars");
            System.out.println("2) Car Info");
            System.out.println("3) Request Cars");
            System.out.println("4) View Report");
            System.out.println("5) Menu");
            System.out.println("6) Exit");

            Scanner sc = new Scanner(System.in);
            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    adminDashboard.AddCars();
                    break;
                case 2:
                    adminDashboard.CarsInfo();
                    break;
                case 3:
                    adminDashboard.RequestCars();
                    break;
                case 4:
                    viewReports.viewReport1();

                    break;
                case 5:
                    Dashboard dashboard = new Dashboard();
                    dashboard.Main_Menu();
                    break;
                case 6:
                    Dashboard dashboard2 = new Dashboard();
                    dashboard2.Exit();

                default:
                    break;
            }
        }

    }

    public static void main(String[] args) {

    }

}
