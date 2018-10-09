package sist.utils;

public class MarkKeyWords {
	
	public static void Mark(Object bean,String markWord){/*
		if(markWord==null||bean==null||markWord.trim().isEmpty()){
			return;
		}
		
		Class<? extends Object> cls = bean.getClass();
		boolean primitive = cls.isPrimitive();
		
		if(primitive)
			return;
		else{
			boolean isArray = cls.isArray();
			if(isArray){
				Object[] object = (Object[]) bean;
				for (Object obj : object) {
					Mark(obj,markWord);
				}
			}else{
				Field[] fields = cls.getDeclaredFields();
				for (Field field : fields) {
					Class<?> type = field.getType();
					if(type.equals(String.class)){
						String name = field.getName();
						String getter = "get"+name.substring(0, 1).toUpperCase()+name.substring(1);
						String setter = "set"+name.substring(0,1).toUpperCase()+name.substring(1);
						try {
							Method method = cls.getMethod(getter);
							Method method2 = cls.getMethod(setter, String.class);
							if(method==null||method2==null)
								continue;
							String str = (String) method.invoke(bean);
							String replace = replace(str,markWord);
							method2.invoke(bean, replace);
						} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
							e.printStackTrace();
						}
					}
				}
			}
		}*/
	}
	
	public static String replace(String str,String key){
		return str;/*
		if(str==null || key==null)
			return str;
		StringBuffer sb = new StringBuffer();
		char[] array = str.toCharArray();
		boolean isHtml = false;
		boolean isStart = false;
		boolean isEnd = true;
		for (char c : array) {
			String ch = String.valueOf(c);
			if("<".equals(ch)){
				isHtml = true;
				continue;
			}
			if(">".equals(ch)){
				isHtml = false;
				continue;
			}
			if(isHtml)
				continue;
			boolean b = key.contains(ch);
			if(b){
				if(isEnd&&!isStart){
					sb.append("<span style='color:red;'>");
					isEnd = false;
					isStart = true;
				}
				sb.append(c);
			}else{
				if(isStart&&!isEnd){
					sb.append("</span>");
					isStart = false;
					isEnd = true;
				}
				sb.append(c);
			}
		}
		return sb.toString();*/
	}
	public static void main(String[] args) {
		String replace = replace("我爱河东狮,东方不败,不知东方之季白","东林野郡一七星方狮子,");
		System.out.println(replace);
	}
}
