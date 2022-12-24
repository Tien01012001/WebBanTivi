package vn.iotstar.dao.impl;

import vn.iotstar.connection.DBConnect;
import vn.iotstar.dao.ShipDao;
import vn.iotstar.model.ProductModel;
import vn.iotstar.model.ShipModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ShipDaoiml extends DBConnect implements ShipDao {
    public int getShip(String nameShip) {
        String sql = "Select ShipPrice from Ship where CityName =? ";
        try {
            Connection con = super.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, nameShip);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
        return -1;
    }

    public int getShipFirst() {
        String sql = "select  top(1) ShipPrice  from Ship ";
        try {
            Connection con = super.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
        return -1;
    }

    public List<ShipModel> getAllShip(){
        //Khai báo List để lưu danh sách sp
        List<ShipModel> list = new ArrayList<ShipModel>();
        //Khai báo chuỗi truy vấn
        String sql = "select * from Ship";
        try {
            Connection con = super.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new ShipModel(rs.getString(1),
                        rs.getInt(2)));
            }

        } catch (Exception e) {
            // TODO: handle exception
        }
        return list;

    }
}
