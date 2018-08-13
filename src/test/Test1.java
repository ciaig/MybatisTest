package test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import dao.UserDao;
import domain.User;
import utils.MybatisUtils;

public class Test1 {
	public static void main(String[] args) {
		SqlSession session = MybatisUtils.getSession();
		UserDao userDao = session.getMapper(UserDao.class);
		List<User> user = userDao.getUser(1, null);
		User user2=new User();
		user2.setId(1);
		user2.setName("xiaoming");
		user2.setPwd("111111");
		user2.setEmail("11111@abc.com");
		userDao.addUser(user2);
		session.commit();
		session.close();
	}
}
