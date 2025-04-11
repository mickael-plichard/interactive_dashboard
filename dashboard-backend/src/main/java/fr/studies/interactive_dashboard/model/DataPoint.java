package fr.studies.interactive_dashboard.model;

public class DataPoint {
    private String date;
    private double value;
    private String category;

    // CONSTRUCTORS
    public DataPoint(){}
    public DataPoint(String date, double value, String category) {
        this.date = date;
        this.value = value;
        this.category = category;
    }

    // GETTERS AND SETTERS
    public String getDate() {return date;}
    public void setDate(String date) {this.date = date;}
    public double getValue() {return value;}
    public void setValue(double value) {this.value = value;}
    public String getCategory() {return category;}
    public void setCategory(String category) {this.category = category;}
}
