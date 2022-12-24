package vn.iotstar.service;

import vn.iotstar.model.ShipModel;

import java.util.List;

public interface ShipService {
    int getShip(String nameShip);
    int getShipFirst();
    List<ShipModel> getAllShip();
}
