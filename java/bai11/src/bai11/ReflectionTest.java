package bai11;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionTest {
	
	private static void explore(Object obj) 
	
	{
		// TODO Auto-generated method stub
		
		Class<? extends Object> clazz = obj.getClass();
		System.out.println("clazz name: " + clazz.getName());
	
		try {
			Field field = clazz.getDeclaredField("TOTAL");
			field.setAccessible(true);
			field.setInt(obj, 23);
			System.out.println("total value is "+ field.getModifiers());
			System.out.println("modified value of the total field is" + field.getInt(obj));
			Method method= clazz.getDeclaredMethod("getTotal", new Class[] {int.class});
			method.setAccessible(true);
			System.out.println("method return value= " + method.invoke(obj, new Object[]{5}));
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		}
	}
		
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TotalCalculator obj;
		try {
			obj = TotalCalculator.class.newInstance();
			explore(obj);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		}

	}

}
