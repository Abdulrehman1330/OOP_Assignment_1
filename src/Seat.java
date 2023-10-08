public class Seat {

    private String seatID;
    private Seatstatus status;

    private Person passenger = null;

    public Person getPassenger() {
        return passenger;
    }

    public void setPassenger(Person passenger) {
        this.passenger = passenger;
    }

    @Override
    public String toString() {
        if (status == Seatstatus.AVAILABLE)
            return "[ '"+  seatID + "', '" + status + "' ] ";
        else
            return "[ '"+  seatID + "', '" + status + " by "+ passenger.getName()+"' ] ";
    }

    public Seat(String seatID, Seatstatus status) {
        setSeatID(seatID);
        setStatus(status);
    }

    public String getSeatID() {
        return seatID;
    }

    public void setSeatID(String seatID) {
        this.seatID = seatID;
    }

    public Seatstatus getStatus() {
        return status;
    }

    public void setStatus(Seatstatus status) {
        this.status = status;
    }
}
