package pl.hackyeah.bot.hackyeahbot.booking.seats.entity;

import javax.persistence.*;

@Entity
public class Seat {
    private Long id;
    private boolean booked;
    private int x;
    private int y;
    private String seatClass;
    private double price;
    private String benefits;

    public Seat() {
    }

    public Seat(boolean booked, int x, int y, String seatClass, double price) {
        this.booked = booked;
        this.x = x;
        this.y = y;
        this.seatClass = seatClass;
        this.price = price;
    }

    public Seat(boolean booked, int x, int y, String seatClass, double price, String benefits) {
        this.booked = booked;
        this.x = x;
        this.y = y;
        this.seatClass = seatClass;
        this.price = price;
        this.benefits = benefits;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean getBooked() {
        return booked;
    }

    public void setBooked(boolean booked) {
        this.booked = booked;
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
