import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class Console {
	
	private int index = -1;
	
	public void log (Object o){
		int n = compare(o);
		
		if (n==0){
			System.err.println("ERROR: console.log(x) -> unrecognizable object x");
		} else {
			this.index = -1;
			printObject(o,n);
		}
		
	}
	
	public void element (Object o, int index){
		int n = compare(o);
		
		if (n==0){
			System.err.println("ERROR: console.log(x) -> unrecognizable object x");
		} else {
			this.index = index;
			printObject(o,n);
		}
		
	}
	
	private int compare (Object o){
		
		if (o instanceof ArrayList) return 1;
		
		else if (o instanceof HashMap) return 2;
		
		else if (o instanceof Integer[]) return 3;
		
		else if (o instanceof String[]) return 3;
		
		else return 0;
		
	}
	
	
	private void printObject (Object o, int n){
		
		switch(n){
			
			case 1: printArrayList (o); break;
			
			case 2: printHashMap(o); break;
			
			case 3: printArray((Object[]) o); break;
		
		}
		
	}
	
	
	private void printArrayList (Object in){
		
		ArrayList o = (ArrayList) in;
		Object e = null;
		int n = o.size();
		
		if (index > -1){
			e = o.get(index);
			System.out.print(e + "\n");
		} 
		
		else {		
				System.out.print("{");
				
				for (int i=0; i<n; i++){
					e = o.get(i);
					System.out.print(e);
					if (i<n-1) System.out.print(", ");		
				}
				
				System.out.print("}\n");	
		}
	}
	
	
	private void printHashMap(Object in){
		
		HashMap o = (HashMap) in;
		int iterator = 0;
		Object v = null;
		String div = ", ";
		
		if (index > -1){
			for (Object k: o.keySet()){			
							
				if (iterator == index){
					v = o.get(k);
					System.out.print(k + ": " + v + "\n");
					break;
				}
				
				iterator++;
				
			}
		} 
		
		else {
			System.out.print("{");
			for (Object k: o.keySet()){
				
				v = o.get(k);
				System.out.print(k + ": " + v + div);
				
				iterator++;
				if (iterator == o.size()-1) div = "";
				
			}
			System.out.print("}\n");
		}
		
	}
	
	
	private void printArray (Object[] o){
		
		if (index > -1){
			System.out.print(o[index] + "\n");
		}
		
		else{
			System.out.print("[");
			for (int i=0; i<o.length; i++){
				
				System.out.print(o[i]);
				if (i<o.length-1) System.out.print(", ");
				
			}
			System.out.print("]\n");
		}
	}
		
	
}
