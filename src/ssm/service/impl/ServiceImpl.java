package ssm.service.impl;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import ssm.dao.impl.UserDaoImpl;
import ssm.po.User;
import ssm.service.Service;

public class ServiceImpl implements Service{
	@Autowired
	private UserDaoImpl userimpl;

	@Override
	public User findUserById(int id) throws Exception {
		User user = userimpl.findUserById(id);
		
		return user;
	}
	

}
