import java.io.FileNotFoundException;
import java.util.Scanner;

public class PostageRunner {
    public static void main(String[] args) throws FileNotFoundException {
        PackageSimulator simulate = new PackageSimulator();
        Scanner s = new Scanner(System.in);
        String input  = "";
        while(!input.equals("4")) {
            simulate.resetSimulation();
            System.out.println("-------------------------------------");
            System.out.println("1. Calculate cost of one package");
            System.out.println("2. Simulate packages");
            System.out.println("3. How package costs are calculated");
            System.out.println("4. Exit");
            System.out.print("Input: ");
            input = s.nextLine();
            System.out.println("-------------------------------------");
            if (input.equals("1")) {
                System.out.print("Enter the zip code of the origin package: ");
                String zip1 = s.nextLine();
                System.out.print("Enter the zip code of the destination package: ");
                String zip2 = s.nextLine();
                System.out.print("Enter the weight of the package: ");
                double weight = Double.parseDouble(s.nextLine());
                System.out.print("Enter the height of the package: ");
                double height = Double.parseDouble(s.nextLine());
                System.out.print("Enter the length of the package: ");
                double length = Double.parseDouble(s.nextLine());
                System.out.print("Enter the width of the package: ");
                double width = Double.parseDouble(s.nextLine());
                System.out.println("Cost: " + PostageCalculator.calculatePostage(zip1, zip2, weight, height, length, width));
            }
            else if (input.equals("2")) {
                System.out.print("How many packages would you like to simulate? ");
                input = s.nextLine();
                simulate.packageGenerator(Integer.parseInt(input));
                System.out.println(simulate.getSimulationInfo());
                System.out.println("-------------------------------------");
                System.out.println("Total Cost of all packages: " + simulate.generateTotalCost());
                input = "";
            }
            else if (input.equals("3")) {
                System.out.println("The starting price is $3.75");
                System.out.println("The difference of the country codes divided by 100 is added to the cost");
                System.out.println("Each tenth of a pound increases the cost by 5 cents");
                System.out.println("Every tenth pound over 40 pounds will cost 10 cents");
                System.out.println("Every inch over 36 inches will cost 10 cents per inch");
            }
        }
    }
}
