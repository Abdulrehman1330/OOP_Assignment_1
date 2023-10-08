

public class Person {
    private String name;
    private Flight flightNo;
    private String seatNo;

    public String getName() {
        return name;
    }

    public void setSeatNo(String seatNo) {
        this.seatNo = seatNo;
    }

    public void setName(String name) {
        this.name = name;
    }

    Person(String name){
        setName(name);
        flightNo = null;
        seatNo = null;
    }
    Person(String name,Flight flight,String seatNo){
        setName(name);
        flightNo = flight;

        flight.allocateSeat(seatNo,this);
    }

    public void setFlightNo(Flight flightNo) {
        this.flightNo = flightNo;
    }

    public Flight getFlightNo() {
        return flightNo;
    }

    @Override
    public String toString() {
        return "[ Name='" + name + '\'' +
                ", FlightNo='" + flightNo.getFlightNo()
                + "', " + flightNo.getAirplane()+
                ", Seat_No='" + seatNo + '\'' +
                ']';
    }
}
