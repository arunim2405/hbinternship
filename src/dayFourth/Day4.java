package dayFourth;
import java.util.LinkedHashMap;
import java.util.Set;
import java.util.Iterator;
import java.util.Map;

public class Day4{
	public static void main(String[] args) {
		pro1();
		//pro2();


	}

	public static void pro2() {
		LinkedHashMap<Integer, String> lhmap = 
				new LinkedHashMap<Integer, String>();

		//Adding elements to LinkedHashMap
		lhmap.put(22, "Abey");
		lhmap.put(33, "Dawn");
		lhmap.put(1, "Sherry");
		lhmap.put(2, "Karon");
		lhmap.put(100, "Jim");

		// Generating a Set of entries
		Set set = lhmap.entrySet();

		// Displaying elements of LinkedHashMap
		Iterator iterator = set.iterator();
		while(iterator.hasNext()) {
			Map.Entry me = (Map.Entry)iterator.next();
			System.out.print("Key is: "+ me.getKey() + 
					"& Value is: "+me.getValue()+"\n");
		}
	}


	public static void pro1() {

		Company a = new Company();
		Company b = new Ebay(); 
		Ebay c= new Ebay();

		a.address();
		b.address();
		c.address();
	}
	public static class Company {

		public void address() {
			System.out.println("This is Address of Crunchify Company...");
		}
		
	}
	

	public static class Ebay extends Company {

		public void address() {
			//super.address(); 
			System.out.println("This is eBay's Address...");
		}
	}

	public void ex() {

		try {

		}catch(Exception ex) {
			ex.getMessage();
		}
	}

}


