package com.company;

public class Countries {
    String ID;
    String countryCode;

    public Countries(String ID, String countryCode) {
        this.ID = ID;
        this.countryCode = countryCode;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }


}
