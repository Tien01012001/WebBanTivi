package vn.iotstar.service;

import vn.iotstar.model.AccountModel;

import java.util.List;

public interface UserService {

	void insert(AccountModel user);
	void delete(int uid);
	AccountModel ExistAcount(String user);
	AccountModel get(int id);
	AccountModel edit(AccountModel account);
	List<AccountModel> getAllAccount();
}
