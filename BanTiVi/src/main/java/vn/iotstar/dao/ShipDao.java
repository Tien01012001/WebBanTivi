package vn.iotstar.dao;

import vn.iotstar.model.ShipModel;

import java.util.List;

public interface ShipDao {
    int getShip(String nameShip);
    int getShipFirst();
    List<ShipModel> getAllShip();
}
