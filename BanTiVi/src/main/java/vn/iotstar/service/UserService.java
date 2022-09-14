package vn.iotstar.service;

import vn.iotstar.model.AccountModel;

public interface UserService {

	void insert(AccountModel user);

	AccountModel get(int id);
	
}
