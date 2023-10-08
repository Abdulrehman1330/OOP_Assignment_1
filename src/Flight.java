public class Flight {

    private String flightNo;
    private final Airplane airplane;

    private final Person[] passengers;
    private int currentPassengers = 0;

    public Airplane getAirplane() {
        return airplane;
    }

    Flight(String flightNo, AirplaneModel model){
        setFlightNo(flightNo);
        airplane = new Airplane(model);
        passengers = new Person[airplane.seats.length*airplane.seats[0].length];
    }

    public String getFlightNo() {
        return flightNo;
    }

    public void setFlightNo(String flightNo) {
        this.flightNo = flightNo;
    }

    public void allocateSeat(String SeatId, Person person){
        int flag = 0;
        for (Seat[] seat_row:airplane.seats){
            for (Seat seat:seat_row){
                if ((SeatId.equals(seat.getSeatID())) && (seat.getStatus().equals(Seatstatus.AVAILABLE))){
                    seat.setStatus(Seatstatus.RESERVED);
                    seat.setPassenger(person);
                    if (person.getFlightNo() == null){
                        person.setFlightNo(this);
                    }
                    person.setSeatNo(seat.getSeatID());
                    System.out.println("Congratulations " + person.getName() +", Your seat is '"+ SeatId + "'.");

                    flag++;
                    break;
                }
                if ((SeatId.equals(seat.getSeatID())) && (seat.getStatus().equals(Seatstatus.RESERVED))){
                    System.out.println("Seat number '"+ SeatId +"' is already occupied");
                    flag++;
                    break;
                }
            }
        }
        if (flag == 0)
            System.out.println("Invalid Seat Number: "+ SeatId);
    }

    public void relocate_passenger(String from_seat, String to_seat){
            for (Seat[] seat:airplane.seats){
                for (Seat seat1:seat){
                    if(from_seat.equals(seat1.getSeatID()) && (seat1.getStatus().equals(Seatstatus.AVAILABLE))) {
                        System.out.println("There is no passenger on seat '" +from_seat+"'");
                        break;
                    }
                    if (from_seat.equals(seat1.getSeatID()) && (seat1.getStatus().equals(Seatstatus.RESERVED))){
                        allocateSeat(to_seat,seat1.getPassenger());
                        seat1.setStatus(Seatstatus.AVAILABLE);
                    }
                }
            }
    }

    public void displaySeats(){
        int counter = 0;
        for (Seat[] seat_row: airplane.seats){
            for (Seat seat:seat_row){
                if (seat.getStatus().equals(Seatstatus.AVAILABLE)){
                    counter++;
                }
                System.out.print(seat);
            }
            System.out.println("\n");
        }
        System.out.println("There are "+ counter + " seats available");
    }

    public void cancelFlight(Person person) {

        for (Seat[] seat : airplane.seats) {
                for (Seat seat1 : seat) {
                    if (seat1.getPassenger() != null){
                    if (person.getName().equals(seat1.getPassenger().getName())) {
                        seat1.setPassenger(null);
                        seat1.setStatus(Seatstatus.AVAILABLE);
                    }
                }
            }
        }
    }

    private void setPassengers(){
        for (Seat[] seats: airplane.seats){
            for (Seat seat:seats){
                if (seat.getPassenger() != null){
                    passengers[currentPassengers++] = seat.getPassenger();
                }
            }
        }
    }
    @Override
    public String toString(){
        setPassengers();
        StringBuilder stringBuilder = new StringBuilder();
        for (Person person: passengers) {
            if (!(person == null)) {
                stringBuilder.append(person);
                stringBuilder.append("\n");
            }
        }
        stringBuilder.append("There are currently ").append(currentPassengers).append(" passengers in this Airplane");
        return stringBuilder.toString();
    }

}
