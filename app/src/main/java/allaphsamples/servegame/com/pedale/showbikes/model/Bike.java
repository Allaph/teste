package allaphsamples.servegame.com.pedale.showbikes.model;

import java.io.Serializable;

/**
 * Created by Allaph on 03/12/2016.
 */
public class Bike implements Serializable {

    private String mName;
    private Float mPrice;
    private Integer mWeight;
    private String mColor;
    private String mDescription;

    public Bike(String mName, Float mPrice, Integer mWeight, String mColor, String mDescription) {
        this.mName = mName;
        this.mPrice = mPrice;
        this.mWeight = mWeight;
        this.mColor = mColor;
        this.mDescription = mDescription;
    }

    public String getName() {
        return mName;
    }

    public Float getPrice() {
        return mPrice;
    }

    public Integer getWeight() {
        return mWeight;
    }

    public String getColor() {
        return mColor;
    }

    public String getDescription() {
        return mDescription;
    }
}
