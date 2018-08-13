package utils;

import java.io.InputStream;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisUtils {
	private static SqlSessionFactory ssf;
	//通过mybatis-config.xml创建SQLSessionFactory
	static{
			InputStream inputStream = MybatisUtils.class.getClassLoader().getResourceAsStream("mybatis-config.xml");
			ssf=new SqlSessionFactoryBuilder().build(inputStream);
	}
	//返回sqlSession
	public static SqlSession getSession(){
		return ssf.openSession();
	}
}
