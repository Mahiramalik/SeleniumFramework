		import java.lang.reflect.Method;
		import java.util.Date;

		public class Demo1 {
			
			public void display() {
				System.out.println("displaying");
			}
			
			public void method1() {
				
			}
			
			public void method2() {
				
			}

			public static void main(String[] args) {
				
					Date d = new Date();
					System.out.println(d);
					
					
					Method methods[] = Demo1.class.getMethods();
					
					Demo1 d1 = new Demo1();
					
					for(Method m : methods) {
						System.out.println(m.getName());
					}
			}

	}
