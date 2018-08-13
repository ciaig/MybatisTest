package dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import domain.User;

public interface UserDao {
	//查询用户方法
	List<User> getUser(@Param("id") int id, @Param("name") String name);
	//添加用户方法
	int addUser(User user);
	//删除用户方法
	int deleteUser(int id);
	//更新用户方法
	int updateUser(@Param("id") int id, @Param("name") String name, @Param("pwd") String pwd, @Param("email") String email);
}
