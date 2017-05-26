package ssm.dao;

import ssm.po.User;

public interface UserDao {
	public User findUserById(int id)throws Exception;
}
