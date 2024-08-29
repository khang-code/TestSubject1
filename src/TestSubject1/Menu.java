package TestSubject1;
import java.util.Scanner;
import java.text.DecimalFormat;

public class Menu {
    private static final DecimalFormat df = new DecimalFormat("#,###,##0.00 VND");
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int selectingNumber;
        do {
            System.out.println("please select an option:");
            System.out.println("1. Submit electricity bill for the end of the month");
            System.out.println("2. Submit Your travel money by taxi for the end of the month");
            System.out.println("3. Submit monthly salary (assuming tax = 15%)");
            System.out.println("4. Submit total income after expenses for the end of the month");
            System.out.println("Press any other number to exit the program:");
            selectingNumber = scanner.nextInt();
            switch (selectingNumber) {
                case 1:
                    System.out.println("Enter Energy money used for this month:");
                    double MoneyEnergy = scanner.nextDouble();
                    System.out.println("Money is:" + MoneyEnergy);
                    break;
                case 2:
                    System.out.println("Enter Taxi money used for this month: ");
                    double MoneyTaxi = scanner.nextDouble();
                    System.out.println("Money is:" + MoneyTaxi);
                    break;
                case 3:
                    System.out.println("Enter your salary this month before tax:");
                    double salary = scanner.nextDouble();
                    double netSalary = calculateNetSalary(salary);
                    System.out.println("Net Salary after tax: " + df.format(netSalary));
                    break;
                case 4:
                    System.out.print("Enter the electricity bill: ");
                    double electricityFee = scanner.nextDouble();
                    System.out.print("Enter the taxi fare: ");
                    double taxiFee = scanner.nextDouble();
                    System.out.print("Enter the net salary after tax: ");
                    double netSalaryFee = scanner.nextDouble();

                    double totalIncome = calculateTotalIncome(netSalaryFee, electricityFee, taxiFee);
                    System.out.println("Total Income after expenses: " + df.format(totalIncome));
                    break;
                default:
                    System.out.println("Thank you for using the program. Goodbye!");
                    scanner.close();
                    return;
            }
        }while (true);
    }

    private static double calculateNetSalary(double salary) {
        double taxRate = 0.15;
    return salary * (1 - taxRate);
    }

    private static double calculateTotalIncome(double netSalary, double electricityFee, double taxiFee) {
        return netSalary - (electricityFee + taxiFee);
}}
