package edu.cftic.fichapp.bean;

public class Social {
    private String red;
    private String enlace;

    public Social(String red, String enlace) {
        this.red = red;
        this.enlace = enlace;
    }

    public String getRed() {
        return red;
    }

    public void setRed(String red) {
        this.red = red;
    }

    public String getEnlace() {
        return enlace;
    }

    public void setEnlace(String enlace) {
        this.enlace = enlace;
    }
}
