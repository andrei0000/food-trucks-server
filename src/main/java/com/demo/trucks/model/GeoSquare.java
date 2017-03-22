package com.demo.trucks.model;

/**
 * Created by andrei.
 */
public class GeoSquare {

    private Double bottomLatitude;

    private Double topLatitude;

    private Double leftLongitude;

    private Double rightLongitude;

    public GeoSquare(Double bottomLatitude, Double topLatitude, Double leftLongitude, Double rightLongitude) {
        this.bottomLatitude = bottomLatitude;
        this.topLatitude = topLatitude;
        this.leftLongitude = leftLongitude;
        this.rightLongitude = rightLongitude;
    }

    public Double getBottomLatitude() {
        return bottomLatitude;
    }

    public void setBottomLatitude(Double bottomLatitude) {
        this.bottomLatitude = bottomLatitude;
    }

    public Double getTopLatitude() {
        return topLatitude;
    }

    public void setTopLatitude(Double topLatitude) {
        this.topLatitude = topLatitude;
    }

    public Double getLeftLongitude() {
        return leftLongitude;
    }

    public void setLeftLongitude(Double leftLongitude) {
        this.leftLongitude = leftLongitude;
    }

    public Double getRightLongitude() {
        return rightLongitude;
    }

    public void setRightLongitude(Double rightLongitude) {
        this.rightLongitude = rightLongitude;
    }

    @Override
    public String toString() {
        return new StringBuilder()
                .append("{ ")
                .append("bottomLatitude: ")
                .append(getBottomLatitude())
                .append(", ")
                .append("topLatitude: ")
                .append(getTopLatitude())
                .append(", ")
                .append("leftLongitude: ")
                .append(getLeftLongitude())
                .append(", ")
                .append("rightLongitude: ")
                .append(getRightLongitude())
                .append(" }")
                .toString();
    }

    /**
     * Returns a formed where clause for a request to DataSF
     *
     * @return where clause
     */
    public String buildSquare() {
        return new StringBuilder().append("latitude > ")
                .append(getBottomLatitude())
                .append(" AND ")
                .append(" latitude < ")
                .append(getTopLatitude())
                .append(" AND ")
                .append(" longitude > ")
                .append(getLeftLongitude())
                .append(" AND ")
                .append(" longitude < ")
                .append(getRightLongitude())
                .toString();
    }
}
