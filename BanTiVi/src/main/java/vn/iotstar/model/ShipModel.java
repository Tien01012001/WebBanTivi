package vn.iotstar.model;

public class ShipModel {
    private String cityName;
    private Integer priceShip;

    public void setPriceShip(Integer priceShip) {
        this.priceShip = priceShip;
    }

    public ShipModel(String cityName, Integer priceShip) {
        this.cityName = cityName;
        this.priceShip = priceShip;
    }

    @Override
    public String toString() {
        return "ShipModel{" +
                "cityName='" + cityName + '\'' +
                ", priceShip=" + priceShip +
                '}';
    }

    public String getCityName() {
        return cityName;
    }

    public Integer getPriceShip() {
        return priceShip;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }





}
