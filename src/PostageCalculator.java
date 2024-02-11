public class PostageCalculator {


    public static double calculatePostage(String zipCode1, String zipCode2, double weight, double length, double height, double width) {
        double cost = 3.75;
        if (weight <= 40) {
            cost += .05 * (weight / .1);
        }
        else {
            cost += 20 + (.1 * (weight / .1));
        }
        if (length + height + width > 36) {
            cost += (length + height + width - 36) * .1;
        }
        cost += Math.abs(Integer.parseInt(zipCode1.substring(0, 3)) - Integer.parseInt(zipCode2.substring(0, 3))) / 100.0;
        cost = (Math.round(cost * 100.0) / 100.0);
        return cost;
    }
    public static double calculatePostage(Address address1, Address address2, double weight, double length, double height, double width) {
        double cost = 3.75;
        if (weight <= 40) {
            cost += .05 * (weight / .1);
        }
        else {
            cost += 20 + (.1 * (weight / .1));
        }
        if (length + height + width > 36) {
            cost += (length + height + width - 36) * .1;
        }
        cost += Math.abs(Integer.parseInt(address1.getZipCode().substring(0, 3)) - Integer.parseInt(address2.getZipCode().substring(0, 3))) / 100.0;
        cost = (Math.round(cost * 100.0) / 100.0);
        return cost;
    }
    public static double calculatePostage(Package pack) {
        double cost = 3.75;
        if (pack.getWeight() <= 40) {
            cost += .05 * (pack.getWeight() / .1);
        }
        else {
            cost += 20 + (.1 * (pack.getWeight() / .1));
        }
        if (pack.getLength() + pack.getHeight() + pack.getWidth() > 36) {
            cost += (pack.getLength() + pack.getHeight() + pack.getWidth() - 36) * .1;
        }
        cost += Math.abs(Integer.parseInt(pack.getOrigin().getZipCode().substring(0, 3)) - Integer.parseInt(pack.getDestination().getZipCode().substring(0, 3))) / 100.0;
        cost = (Math.round(cost * 100.0) / 100.0);
        return cost;
    }
}
