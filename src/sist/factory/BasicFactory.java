package sist.factory;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import sist.dao.Dao;
import sist.service.Service;

public class BasicFactory {

	private BasicFactory(){
		daoMap = new HashMap<>();
		serviceMap = new HashMap<>();
	};
	
	private Map<Class<?>,Dao> daoMap = null;
	private Map<Class<?>,Service> serviceMap = null;
	private static BasicFactory factory = new BasicFactory();
	public static BasicFactory getFactory(){
		return factory;
	}
	
	@SuppressWarnings("unchecked")
	public <T extends Dao> T getDao(Class<T> clazz){
		Dao dao2 = daoMap.get(clazz);
		if(dao2!=null)
			return (T) dao2;
		String className = prop.getProperty(clazz.getSimpleName());
		try {
			Class<?> cls = Class.forName(className);
			T dao = (T) cls.newInstance();
			daoMap.put(clazz, dao);
			return dao;
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	@SuppressWarnings("unchecked")
	public <T extends Service> T getService(Class<T> clazz){
		Dao dao2 = daoMap.get(clazz);
		if(dao2!=null)
			return (T) dao2;
		String className = prop.getProperty(clazz.getSimpleName());
		try {
			Class<?> cls = Class.forName(className);
			T dao = (T) cls.newInstance();
			serviceMap.put(clazz, dao);
			return dao;
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	private static Properties prop = null;
	static {
		 String path = BasicFactory.class.getClassLoader().getResource("conf.properties").getPath();
		 prop = new Properties();
		 try {
			prop.load(new FileInputStream(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
