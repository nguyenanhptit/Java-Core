package bai11;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodHandles.Lookup;
import java.lang.invoke.MethodType;

public class MethodHandlerExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Lookup lookup = MethodHandles.lookup();
		
		try {
			MethodHandle mh = lookup.findVirtual(TotalCalculator.class, "getTotal", MethodType.methodType(long.class, short.class));
			TotalCalculator obj = TotalCalculator.class.newInstance();
			try {
				
				System.out.println(mh.invoke(obj,(short)27));
				mh= MethodHandles.insertArguments(mh, 1, (short)10);
				System.out.println("total= %d" + mh.invoke(obj));
			} catch (Throwable e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}

}
