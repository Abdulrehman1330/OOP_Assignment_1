// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Airport {
    public static void main(String[] args) {
        Flight flight1 = new Flight("BA365",AirplaneModel.BOEING777);

        Person p2 = new Person("AbdulRehman",flight1,"3A");
        Person p1 = new Person("Ali");
        Person p3 = new Person("Abdul",flight1,"6A");
        Person p4 = new Person("A",flight1,"3C");

        flight1.allocateSeat("3A",p1);
        flight1.relocate_passenger("3A","6B");
        flight1.allocateSeat("3A",p1);
        flight1.displaySeats();
        flight1.cancelFlight(p2);
        System.out.println(flight1);
        flight1.displaySeats();


        Flight flight2 = new Flight("SP190",AirplaneModel.AIRBLUE_A340);
        flight2.displaySeats();
        System.out.println(flight2.getAirplane());
    }
}