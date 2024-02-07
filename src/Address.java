public class Address {

    private String houseNumber, streetName, apartmentNumber, city, state, zipCode;


    public Address(String houseNumber, String streetName, String apartmentNumber, String city, String state, String zipCode) {
        houseNumber = houseNumber;
        streetName = streetName;
        apartmentNumber = apartmentNumber;
        city = city;
        state = state;
        zipCode = zipCode;
    }
    public Address(Address copy) {
        houseNumber = copy.houseNumber;
        streetName = copy.streetName;
        apartmentNumber = copy.apartmentNumber;
        city = copy.city;
        state = copy.state;
        zipCode = copy.zipCode;
    }

    public Address(String address) {
        String[] separate = address.split(", ");
        String[] first = separate[1].split(" ");
        houseNumber = first[0];
        streetName = first[1] + " " + first[2];
        try {
            apartmentNumber = first[4];
        }
        catch (ArrayIndexOutOfBoundsException e) {
            apartmentNumber = "";
        }
        city = separate[1];
        state = separate[2].substring(0, separate[2].length() - 7);
        zipCode = separate[2].substring(separate[2].length() - 6);
    }
    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getApartmentNumber() {
        return apartmentNumber;
    }

    public void setApartmentNumber(String apartmentNumber) {
        this.apartmentNumber = apartmentNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String toString() {
        if (apartmentNumber.isEmpty()) {
            return houseNumber + " " + streetName + ", " + city + ", " + state + " " + zipCode;
        }
        return houseNumber + " " + streetName + " Apt " + apartmentNumber + ", " + city + ", " + state + " " + zipCode;

    }
}
