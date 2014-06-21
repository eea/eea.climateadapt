package nl.wur.alterra.quickanddirtyows.wcs;

public class Extent {

    private double xMin;

    private double yMin;

    private double xMax;

    private double yMax;

    private String srsCode;

    public Extent(double xMin, double yMin, double xMax, double yMax, String srsCode) {
        super();
        this.xMin = xMin;
        this.yMin = yMin;
        this.xMax = xMax;
        this.yMax = yMax;
        this.srsCode = srsCode;
    }

    public double getxMin() {
        return xMin;
    }

    public void setxMin(double xMin) {
        this.xMin = xMin;
    }

    public double getyMin() {
        return yMin;
    }

    public void setyMin(double yMin) {
        this.yMin = yMin;
    }

    public double getxMax() {
        return xMax;
    }

    public void setxMax(double xMax) {
        this.xMax = xMax;
    }

    public double getyMax() {
        return yMax;
    }

    public void setyMax(double yMax) {
        this.yMax = yMax;
    }

    public String getSrsCode() {
        return srsCode;
    }

    public void setSrsCode(String srsCode) {
        this.srsCode = srsCode;
    }

    public Double getHeight() {
        return this.yMax - this.yMin;
    }

    public Double getWidth() {
        return this.xMax - this.xMin;
    }
}
