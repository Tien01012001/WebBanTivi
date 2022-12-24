package vn.iotstar.service.impl;

import vn.iotstar.dao.ShipDao;
import vn.iotstar.dao.impl.ShipDaoiml;
import vn.iotstar.model.ShipModel;
import vn.iotstar.service.ShipService;

import java.util.List;

public class ShipServiceImpl implements ShipService {
    ShipDao shipDao = new ShipDaoiml();
    public int getShip(String nameShip) {
        return shipDao.getShip(nameShip);
    }

    public int getShipFirst() {
        return shipDao.getShipFirst();
    }

    public List<ShipModel> getAllShip(){
        return shipDao.getAllShip();
    }
}
