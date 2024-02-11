import java.util.ArrayList;

public class PackageSimulator {
    private ArrayList<Package> packages;

    public PackageSimulator() {
        packages = new ArrayList<Package>();
    }

    public void packageGenerator(int num) {
        String address = "123 Random Street Apt 3C, City, State ";
        for (int i = 0; i < num; i++) {
            String zipCode1 = Integer.toString((int) (Math.random() * 99023) + 501);
            String zipCode2 = Integer.toString((int) (Math.random() * 99023) + 501);
            while (zipCode1.length() < 5) {
                zipCode1 = "0" + zipCode1;
            }
            while (zipCode2.length() < 5) {
                zipCode2 = "0" + zipCode2;
            }
            double length = (Math.random() * 8) + 12;
            double height = (Math.random() * 6) + 12;
            double width = (Math.random() * 6) + 6;
            double weight = (Math.random() * 50) + 2;
            packages.add(new Package(new Address(address + zipCode1), new Address(address + zipCode2), weight, length, height, width));
        }
    }

    public double generateTotalCost() {
        double total = 0;
        for (Package pack: packages) {
            total += PostageCalculator.calculatePostage(pack);
        }
        return total;
    }
    public String getSimulationInfo() {
        String result = "Randomly generated packages info:\n";
        for (int i = 0; i < packages.size(); i++) {
            result += "Package " + i + "-------------------------------------\n";
            result += "Origin address: " + packages.get(i).getOrigin().toString() + "\n";
            result += "Destination address: " + packages.get(i).getDestination().toString() + "\n";
            result += "Weight: " + packages.get(i).getWeight() + " pounds\n";
            result += "Height: " + packages.get(i).getHeight() + " inches\n";
            result += "Length: " + packages.get(i).getLength() + " inches\n";
            result += "Width: " + packages.get(i).getWidth() + " inches\n";
            result += "Cost: " + PostageCalculator.calculatePostage(packages.get(i)) + "\n";
        }
        return result;
    }

    public ArrayList<Package> getPackages() {
        return packages;
    }

    public void resetSimulation() {
        packages.clear();
    }
}
