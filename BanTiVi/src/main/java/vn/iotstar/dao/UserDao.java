package vn.iotstar.dao;

import vn.iotstar.model.AccountModel;

public interface UserDao {
	
	void insert(AccountModel user);
	AccountModel get(int id);
}
