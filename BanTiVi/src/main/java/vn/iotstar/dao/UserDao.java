package vn.iotstar.dao;

import vn.iotstar.model.AccountModel;

import java.util.List;

public interface UserDao {
	
	void insert(AccountModel user);

	AccountModel edit(AccountModel account);

	void delete(int uid);
	List<AccountModel> getAllAccount();
	AccountModel ExistAcount(String user);
	AccountModel get(int id);
}
