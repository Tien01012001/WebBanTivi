package vn.iotstar.service.impl;

import vn.iotstar.dao.UserDao;
import vn.iotstar.dao.impl.UserDaoImpl;
import vn.iotstar.model.AccountModel;
import vn.iotstar.service.UserService;

public class UserServiceImpl implements UserService {
	UserDao userDao = new UserDaoImpl();

	@Override
	public void insert(AccountModel user) {
			userDao.insert(user);
	}

	@Override
	public AccountModel get(int id) {
		// TODO Auto-generated method stub
		return userDao.get(id);
	}
	
}
