package ssm.mapper;

import ssm.po.User;

public interface UserMapper {
	public User findUserById(int id)throws Exception;
}
