public enum AirplaneModel {
    AIRBLUE_A340(4,5),BOEING777(10,6),AIRBUS_A380(8,5),AIRBUS_A319(6,5);

    private final int row;
    private final int column;
    AirplaneModel(int row, int column){
        this.row = row;
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

}