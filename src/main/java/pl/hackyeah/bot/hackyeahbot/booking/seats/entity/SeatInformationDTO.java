package pl.hackyeah.bot.hackyeahbot.booking.seats.entity;

public class SeatInformationDTO {

    //y 3 - 3 x - 15
    private int x;
    private int y;
    private String seatClass;
    private double price;
    private String benefits;

    public SeatInformationDTO(int x, int y, String seatClass, int price) {
        this.x = x;
        this.y = y;
        this.seatClass = seatClass;
        this.price = price;
    }

    public SeatInformationDTO(int x, int y, String seatClass, int price, String benefits) {
        this.x = x;
        this.y = y;
        this.seatClass = seatClass;
        this.price = price;
        this.benefits = benefits;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getSeatClass() {
        return seatClass;
    }

    public void setSeatClass(String seatClass) {
        this.seatClass = seatClass;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getBenefits() {
        return benefits;
    }

    public void setBenefits(String benefits) {
        this.benefits = benefits;
    }
}
