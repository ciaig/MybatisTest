package utils;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.ibatis.datasource.DataSourceFactory;
//实现DataSourceFactory接口，自定义数据库连接池为dbcp
public class DBCPPoolFactory implements DataSourceFactory{
	private BasicDataSource ds;
	
	public DBCPPoolFactory() {
		ds=new BasicDataSource();
	}

	//读取mybatis配置并应用到BasicDataSource
	@Override
	public void setProperties(Properties props) {
		ds.setDriverClassName(props.getProperty("driver"));
		ds.setUrl(props.getProperty("url"));
		ds.setUsername(props.getProperty("username"));
		ds.setPassword(props.getProperty("password"));
		ds.setInitialSize(Integer.parseInt(props.getProperty("initSize","5")));
		ds.setMaxIdle(Integer.parseInt(props.getProperty("maxIdle","10")));
		ds.setMinIdle(Integer.parseInt(props.getProperty("minIdle","5")));
		ds.setMaxTotal(Integer.parseInt(props.getProperty("maxTotal","100")));
	}
    //获得连接池对象
	@Override
	public DataSource getDataSource() {
		return ds;
	}

}
