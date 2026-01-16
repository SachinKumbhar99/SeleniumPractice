package Selenium4Features;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.testng.Assert;

public class StreamBasic {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Count the number of names starting with alphabet A in list
		
		
		//Regular
		
		/*ArrayList<String>names = new ArrayList<String>();
		names.add("Sachin");
		names.add("Adam");
		names.add("Saddam");
		names.add("Milan");
		names.add("Alekhya");
		
		int count=0;
		
		for(int i=0; i<names.size();i++) {
			
			String name = names.get(i);
			if(name.startsWith("A")) {
				System.out.println("name starts with A");
				count++;
			}
			
		}
		System.out.println(count);
		*/
		
		
		//Using Stream
		
		ArrayList<String>names = new ArrayList<String>();
		names.add("Sachin");
		names.add("Azdam");
		names.add("Saddam");
		names.add("Milan");
		names.add("Alekhya");
		
		//Scenario 1
//		Long c =names.stream().filter(s->s.startsWith("A")).count();
//		System.out.println(c);
		
		//Scenario 2
//		long d=Stream.of("Sachin","Adam","Saddam","Milan","Alekhya","Gopal","Srikanth").filter(s->
//		{
//			s.startsWith("A");
//			return true;
//	     }).count();
//		System.out.println(d);
		
		
		//print all the names having length>4
//		names.stream().filter(s->s.length()>4).forEach(s->System.out.println(s));
		
		//limit the list
//		names.stream().filter(s->s.length()>4).limit(2).forEach(s->System.out.println(s));
		
       // sort
//		names.stream().sorted().forEach(s->System.out.println(s));
		
		
		//map to print all names in uppercase
		
		//names.stream().filter(s->s.endsWith("n")).map(s->s.toUpperCase()).forEach(s->System.out.println(s));
		
		//print names which have first letter as a with uppercase and sorted
		
		//names.stream().filter(s->s.startsWith("A")).sorted().map(s->s.toLowerCase()).forEach(s->System.out.println(s));
		
		//array to arraylist
		
//		String[] array = {"Shubham","Kushagra","Akshay","Gopal"};
//		
//		List<String> names1 = Arrays.asList(array);
//		
//		//concat two arraylist
//		
//		Stream<String> newstream = Stream.concat(names.stream(), names1.stream());
//		
//		newstream.sorted().forEach(s->System.out.println(s));
		
		
//		Boolean flag =newstream.anyMatch(s->s.equalsIgnoreCase("Azdam"));
//		System.out.println(flag);
//		Assert.assertTrue(flag);
		
		
		//Collect
		
		
		
		
	}

}
