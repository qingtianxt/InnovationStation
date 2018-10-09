package sist.utils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;


/**
 * @author �ö�
 *
 */
public class SQLUtil {

	/**
	 * ����ָ���Ķ���������Ӧ��update SQL��䣬ע����������к��г�String����ֵ���͵������������ͣ�
	 * �÷������ܽ����װ����SQL����У���ֵ������ֵΪ0���ֶ�Ҳ�޷����ܷ�װ��String���͵��ֶΣ�
	 * ���ֵ�ǿ��ַ������ܷ�װ	���������ƺͶ���������һ��
	 * @param bean			��Ҫ����Ķ���
	 * @param primaryKeys	���е���������
	 * @return				SQL������null
	 */
	public static String update(Object bean,String...primaryKeys){
		return update(bean,bean.getClass().getSimpleName(),primaryKeys);
	}
	
	
	/**
	 * ����ָ���Ķ���������Ӧ��update SQL��䣬ע����������к��г�String����ֵ���͵������������ͣ�
	 * �÷������ܽ����װ����SQL����У���ֵ������ֵΪ0���ֶ�Ҳ�޷����ܷ�װ��String���͵��ֶΣ�
	 * ���ֵ�ǿ��ַ������ܷ�װ
	 * @param bean			��Ҫ����Ķ���
	 * @param table			���������ݱ�
	 * @param primaryKeys	���е���������
	 * @return				SQL������null
	 */
	public static String update(Object bean,String table,String...primaryKeys){
		
		Map<String, Object> columnAndValue = getColumnAndValue(bean);
		if(columnAndValue.isEmpty())
			return null;
		StringBuffer where = new StringBuffer();
		boolean count = true;
		for(String primary : primaryKeys){
			Object remove = columnAndValue.remove(primary);
			if(remove!=null){
				if(count)
					where.append(" where ");
				else
					where.append(" and ");
				where.append(primary).append("='").append(remove).append("'");
				count = false;
			}
		}
		StringBuffer set = new StringBuffer(" set ");
		Set<String> keySet = columnAndValue.keySet();
		for(String column : keySet){
			set.append(column).append("='").append(columnAndValue.get(column)).append("',");
		}
		set.deleteCharAt(set.length()-1).append(where).insert(0, "update "+table);
		return set.toString();
	}
	
	/**
	 * ����ָ���Ķ���������Ӧ�Ĳ���SQL��䣬ע����������к��г�String����ֵ���͵������������ͣ�
	 * �÷������ܽ����װ����SQL����У���ֵ������ֵΪ0���ֶ�Ҳ�޷����ܷ�װ��String���͵��ֶΣ�
	 * ���ֵ�ǿ��ַ������ܷ�װ
	 * @param bean	��Ҫ����SQL���Ķ���
	 * @param table	�����ı�����
	 * @return		SQL������null
	 */
	public static String insert(Object bean,String table){
		// ����ֶ����Ƶ�����
		ArrayList<String> columns = new ArrayList<>();
		// ����ֶ�ֵ������
		ArrayList<Object> values = new ArrayList<>();
		// ��ȡ�������е��ֶκ�ֵ
		getColumnAndValue(bean, columns, values);
		
		
		String sql = "insert into "+table+" ";
		
		if(!columns.isEmpty()&&!values.isEmpty()){
			StringBuffer columnNames = new StringBuffer("(");
			for(String column : columns){
				columnNames.append(column).append(",");
			}
			columnNames.deleteCharAt(columnNames.length()-1).append(") ");
			StringBuffer val = new StringBuffer("values(");
			for(Object value : values){
				val.append('\'').append(value).append("',");
			}
			val.deleteCharAt(val.length()-1).append(")");
			return columnNames.insert(0, sql).append(val).toString();
		}
		
		return null;
	}

	/**
	 * ����ָ���Ķ���������Ӧ�Ĳ���SQL��䣬ע����������к��г�String����ֵ���͵������������ͣ�
	 * �÷������ܽ����װ����SQL����У���ֵ������ֵΪ0���ֶ�Ҳ�޷����ܷ�װ��String���͵��ֶΣ�
	 * ���ֵ�ǿ��ַ������ܷ�װ
	 * @param bean	��Ҫ����SQL���Ķ���
	 * @return		��װ���SQL������null
	 */
	public static String insert(Object bean){
		return insert(bean,bean.getClass().getSimpleName());
	}
	
	/**
	 * �������е����Ժ�����ֵ��װ����Ӧ��������
	 * @param bean		����
	 * @param columns	��������
	 * @param values	����ֵ
	 */
	private static void getColumnAndValue(Object bean,ArrayList<String> columns,ArrayList<Object> values){
		Class<? extends Object> clazz = bean.getClass();
		// ��ȡ�����з�װ�������ֶ�
		Field[] fields = clazz.getDeclaredFields();
		
		// ���������ֶ�
		for (Field field : fields) {
			// ��ȡ�ֶ�����
			String name = field.getName();
			// ��Ӧ�ֶε�get��������
			String methodName = "get"+name.substring(0, 1).toUpperCase()+name.substring(1);
			try {
				// ���Ҹ��ֶε�get����
				Method method = clazz.getMethod(methodName);
				// ������ֶ�û��get������������ѭ��
				if(method==null)
					continue;
				// ��ȡ���ֶε�ֵ
				Object object = method.invoke(bean);
				// ���ֶ��Ƿ�����������
				boolean b = Number.class.isInstance(object);
				if(b){
					// ������ֶ�����ֵ���ͱ���
					float f = Float.parseFloat(object.toString());
					if(f!=0){
						columns.add(name);
						values.add(object);
					}
				}
				// ������ַ�������
				boolean isStr = String.class.isInstance(object);
				if(isStr){
					if(object!=null&&!object.toString().isEmpty()){
						columns.add(name);
						values.add(object);
					}
					
				}
				// �����Boolean����
				if(Boolean.class.isInstance(object)){
					columns.add(name);
					values.add(object);
				}
			} catch (NoSuchMethodException | SecurityException 
					| IllegalAccessException | IllegalArgumentException 
					| InvocationTargetException e) {
				e.printStackTrace();
			}
		}
	};


	/**
	 * �������е��ֶ����ƺ��ֶ�ֵ��װ��һ��map���϶����У��ֶ�������Ϊ�����ֶ�ֵ��Ϊֵ
	 * @param bean	����
	 * @return		map���϶���
	 */
	private static Map<String,Object> getColumnAndValue(Object bean){
		Map<String,Object> map = new HashMap<>();
		Class<? extends Object> clazz = bean.getClass();
		// ��ȡ�����з�װ�������ֶ�
		Field[] fields = clazz.getDeclaredFields();
		// ���������ֶ�
		for (Field field : fields) {
			// ��ȡ�ֶ�����
			String name = field.getName();
			// ��Ӧ�ֶε�get��������
			String methodName = "get"+name.substring(0, 1).toUpperCase()+name.substring(1);
			try {
				// ���Ҹ��ֶε�get����
				Method method = clazz.getMethod(methodName);
				// ������ֶ�û��get������������ѭ��
				if(method==null)
					continue;
				// ��ȡ���ֶε�ֵ
				Object object = method.invoke(bean);
				// ���ֶ��Ƿ�����������
				boolean b = Number.class.isInstance(object);
				if(b){
					// ������ֶ�����ֵ���ͱ��� TODO �˴������޸�
//					float f = Float.parseFloat(object.toString());
//					if(f!=0){
//						map.put(name, object);
//					}
					if(object!=null)
						map.put(name, object);
				}
				// ������ַ�������
				boolean isStr = String.class.isInstance(object);
				if(isStr){
					if(object!=null&&!object.toString().isEmpty()){
						map.put(name, object);
					}
					
				}
				// �����Boolean����
				if(Boolean.class.isInstance(object)){
					map.put(name, object);
				}
			} catch (NoSuchMethodException | SecurityException 
					| IllegalAccessException | IllegalArgumentException 
					| InvocationTargetException e) {
//				e.printStackTrace();
			}
		}
		return map;
	}
	
	public static SQLFactory getSQLFactory(String tableName,Object bean,String...primaryKeys){
		SQLFactory factory = new SQLFactory(tableName,bean,primaryKeys);
		return factory;
	}
	public static SQLFactory getSQLFactory(Object bean,String...primaryKeys){
		SQLFactory factory = new SQLFactory(bean,primaryKeys);
		return factory;
	}
	public static UpdateFactory getUpdateFactory(String tableName,Object bean,String...primaryKeys){
		return new UpdateFactory(tableName,bean,primaryKeys);
	}
	public static class SQLFactory{
		private String tableName;
		private Object bean;
		private String[] primaryKeys;
		private Object[] params;
		public SQLFactory(String tableName, Object bean, String...primaryKeys) {
			super();
			this.tableName = tableName;
			this.bean = bean;
			this.primaryKeys = primaryKeys;
		}
		
		public SQLFactory(Object bean,String...primaryKeys){
			super();
			this.bean = bean;
			this.tableName = bean.getClass().getSimpleName();
			this.primaryKeys = primaryKeys;
		}
		
		public String insertSql(){
			Map<String, Object> columnAndValue = getColumnAndValue(bean);
			ArrayList<Object> list = new ArrayList<>();
			
			for(String key : primaryKeys){
				columnAndValue.remove(key);
			}
			if(columnAndValue.isEmpty())
				return null;
			
			Set<String> keySet = columnAndValue.keySet();
			
			StringBuffer columnNames = new StringBuffer("(");
			StringBuffer values = new StringBuffer(" values (");
			for(String column : keySet){
				Object value = columnAndValue.get(column);
				if(value!=null&&!value.toString().trim().isEmpty()){
					columnNames.append(column).append(",");
					values.append("?,");
					list.add(value);
				}
			}
			params = list.toArray();
			columnNames.deleteCharAt(columnNames.length()-1).append(")");
			values.deleteCharAt(values.length()-1).append(")");
			String sql = "insert into "+tableName+" "+columnNames+values;
			System.out.println(sql);
			System.out.println(Arrays.toString(params));
			if(list.size()>0)
				return sql;
			return null;
		}
		
		public String updateSql(){
			Map<String, Object> columnAndValue = getColumnAndValue(bean);
			StringBuffer where = new StringBuffer();
			ArrayList<Object> arrayList = new ArrayList<>();
			boolean count = true;
			for(String primary : primaryKeys){
				Object remove = columnAndValue.remove(primary);
				if(remove!=null){
					if(count)
						where.append(" where ");
					else
						where.append(" and ");
					where.append(primary).append("=?");
					arrayList.add(remove);
					count = false;
				}
			}
			
			if(columnAndValue.isEmpty())
				return null;
			ArrayList<Object> values = new ArrayList<>(columnAndValue.values());
			values.addAll(arrayList);
			params = values.toArray();
			StringBuffer set = new StringBuffer(" set ");
			Set<String> keySet = columnAndValue.keySet();
			for(String column : keySet){
				set.append(column).append("=?, ");
			}
			set.deleteCharAt(set.lastIndexOf(",")).append(where).insert(0, "update "+tableName);
//			System.out.println(set);
//			System.out.println(Arrays.toString(params));
			return set.toString();
		}
		
		public Object[] getParams(){
			return params;
		}
	}
	
	public static class UpdateFactory{
		private String tableName;
		private Object bean;
		private String[] excep;
		private Map<String,Object> map;
		private Map<String,Object> map2;
		private Map<String,Boolean> isFunction = new HashMap<>();
		private Object[] params;
		public UpdateFactory(String tableName, Object bean, String[] excep) {
			super();
			this.tableName = tableName;
			this.bean = bean;
			this.excep = excep;
			map = getColumnAndValue(this.bean);
			params = map.values().toArray();
			map2 = new HashMap<>();
		}
		
		public String updateSql(){
			map.putAll(map2);
			map2.clear();
			StringBuffer where = new StringBuffer();
			List<Object> whps = new ArrayList<>(); 
			for(String s : excep){
				Object key = map.remove(s);
				if(key==null){
					
				}else{
					where.append("and ").append(s).append("=?, ");
					whps.add(key);
					map2.put(s, key);
				}
			}
			if(!where.toString().trim().isEmpty()){
				
				where.deleteCharAt(where.lastIndexOf(","));
				int andIndex = where.indexOf("and");
				where.delete(andIndex, andIndex+3);
				where.insert(0, " where ");
			}
			StringBuffer setstr = new StringBuffer();
			List<Object> setps = new ArrayList<>();
			Set<String> keySet = map.keySet();
			for(String key : keySet){
				Object value = map.get(key);
				Boolean f = isFunction.get(key);
				if(f!=null&&f==true){
					setstr.append(key).append("=").append(value).append(", ");
				}else{
					setps.add(value);
					setstr.append(key).append("=?, ");
				}
			}
			if(!setstr.toString().trim().isEmpty()){
				setstr.deleteCharAt(setstr.lastIndexOf(","));
				setstr.insert(0, "update "+tableName+" set ");
				setstr.append(where);
				setps.addAll(whps);
				params = setps.toArray();
				return setstr.toString();
			}
			return null;
		}
		
		public String insertSql(){
			map.putAll(map2);
			map2.clear();
			StringBuffer sb = new StringBuffer();
			for(String key : excep){
				Object value = map.remove(key);
				map2.put(key, value);
			}
			Map<String,Object> map3 = new HashMap<>();
			Set<String> keySet = map.keySet();
			for(String key : keySet){
				Object value = map.get(key);
				sb.append(key).append(",");
				map3.put(key, value);
			}
			if(!sb.toString().isEmpty()){
				sb.deleteCharAt(sb.length()-1);
				sb.insert(0, "insert into "+tableName+" (");
				sb.append(") values(");
				Set<String> keySet2 = map3.keySet();
				for(String key1 : keySet2){
					Boolean b = isFunction.get(key1);
					if(b!=null&&b==true){
						sb.append(map3.get(key1)).append(",");
					}else{
						sb.append("?,");
					}
				}
				sb.deleteCharAt(sb.length()-1);
				sb.append(")");
				
				Set<String> keySet3 = isFunction.keySet();
				for(String key4:keySet3){
					map3.remove(key4);
				}
				params = map3.values().toArray();
				System.out.println(sb);
				return sb.toString();
			}
			return null;
		}
		
		public void addFiled(String name,Object value){
			map.put(name, value);
			isFunction.put(name, false);
		}
		public Object remove(String name){
			return map.remove(name);
		}
		
		public void addFunction(String name,Object str){
			map.put(name, str);
			isFunction.put(name, true);
		};
		
		public void removeFunction(String name){
			map.remove(name);
			isFunction.remove(name);
		}
		
		public Object[] getParams(){
			System.out.println(Arrays.toString(params));
			return params;
		}
	}
}
