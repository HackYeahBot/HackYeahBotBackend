package pl.hackyeah.bot.hackyeahbot.booking.luggage.entity;

public class LuggageInformationDTO {
    private LuggageType luggageType;
    private int price;
    private String size;

    public LuggageInformationDTO(LuggageType luggageType) {
        this.luggageType = luggageType;
        setLuggageInfo();
    }

    private void setLuggageInfo() {
        if(this.luggageType.equals(LuggageType.SMALL)){
            this.price = 50;
            this.size = "20x30";
        }else if(this.luggageType.equals(LuggageType.MEDIUM)){
            this.price = 100;
            this.size = "50x70";
        }else if(this.luggageType.equals(LuggageType.LARGE)){
            this.price = 150;
            this.size = "100x120";
        }
    }

    public LuggageType getLuggageType() {
        return luggageType;
    }

    public void setLuggageType(LuggageType luggageType) {
        this.luggageType = luggageType;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
}
