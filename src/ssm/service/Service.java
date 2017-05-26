package ssm.service;

import ssm.po.User;

public interface Service {
	public User findUserById(int id)throws Exception;

}
