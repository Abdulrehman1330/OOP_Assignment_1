public class Airplane {
    private final AirplaneModel model;
    public Seat[][] seats;

    Airplane(AirplaneModel model){

        seats = new Seat[model.getRow()][model.getColumn()];
        for (int i=0;i< model.getRow();i++){
            for (int j = 0;j < model.getColumn();j++){
                char c = (char)(i+65);
                seats[i][j] = new Seat((j+1) + Character.toString(c),Seatstatus.AVAILABLE);
            }
        }
        this.model = model;
    }

    @Override
    public String toString() {
        return "Airplane_Model='" + model + "'";
    }
}
