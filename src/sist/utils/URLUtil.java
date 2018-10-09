package sist.utils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import sist.bean.PagingBean;

public class URLUtil {

	public static <T extends PagingBean> String preUrl(T obj){
		
		Field[] fields = obj.getClass().getDeclaredFields();
		StringBuffer sb = new StringBuffer();
		for (Field field : fields) {
			String name = field.getName();
			String methodName = "get"+name.substring(0,1).toUpperCase()+name.substring(1);
			try {
				Method method = obj.getClass().getMethod(methodName);
				if(method!=null){
					Object value = method.invoke(obj);
					if(Number.class.isInstance(value)||// 数值类型
							Boolean.class.isInstance(value)||// Boolean类型
							CharSequence.class.isInstance(value)){// 字符串类型
						sb.append(name).append("=").append(value).append("&");
					}
				}
			} catch (NoSuchMethodException | SecurityException |
					IllegalAccessException | IllegalArgumentException |
					InvocationTargetException e) {
			}
			
		}
		try {
			sb.deleteCharAt(sb.length()-1);
		} catch (Exception e) {
		}
		return sb.toString();
	};
}
