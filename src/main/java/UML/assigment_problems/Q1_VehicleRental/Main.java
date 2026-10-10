public class Main {
    public static void main(String[] args) {
        RentalService service = new RentalService();
        Customer c1 = new Customer("Customer 1"), c2 = new Customer("Customer 2"), c3 = new Customer("Customer 3");
        Vehicle sedanA = new Sedan("Sedan A"), suvB = new SUV("SUV B");

        service.rent(c1, sedanA, 3);
        service.rent(c2, sedanA, 2);       // unavailable
        service.returnVehicle(c1, sedanA);
        service.rent(c3, suvB, 5);
    }
}
