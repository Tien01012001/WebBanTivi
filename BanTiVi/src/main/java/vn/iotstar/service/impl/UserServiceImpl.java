package vn.iotstar.service.impl;

import vn.iotstar.dao.UserDao;
import vn.iotstar.dao.impl.UserDaoImpl;
import vn.iotstar.model.AccountModel;
import vn.iotstar.model.CategoryModel;
import vn.iotstar.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
	UserDao userDao = new UserDaoImpl();

	@Override
	public void insert(AccountModel user) {
			userDao.insert(user);
	}

	public void delete(int uid) {
		userDao.delete(uid);
	}
	public List<AccountModel> getAllAccount() {

		return userDao.getAllAccount();
	}
	@Override
	public AccountModel ExistAcount(String user) { return userDao.ExistAcount(user); }
	@Override
	public AccountModel get(int id) {
		// TODO Auto-generated method stub
		return userDao.get(id);
	}
	public AccountModel edit(AccountModel newAccount) {
		AccountModel oldAccount = userDao.get(newAccount.getUid());
		oldAccount.setUser(newAccount.getUser());
		oldAccount.setPass(newAccount.getPass());
		oldAccount.setIsSell(newAccount.getIsSell());
		oldAccount.setIsAdmin(newAccount.getIsAdmin());

		return userDao.edit(oldAccount);
	}
}
