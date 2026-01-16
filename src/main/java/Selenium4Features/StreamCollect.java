package Selenium4Features;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamCollect {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<String> names = Arrays.asList("Shubham","Kushagra","Akshay","Gopal","Alekhya");
		
		
		List<String> li =names.stream().filter(s->s.endsWith("a")).sorted().map(s->s.toUpperCase()).collect(Collectors.toList());
		
		System.out.println(li.get(0));
		
		//print unique numbers from numbers arraylist
		//sort the array
		//print 3rd index value
		
		List<Integer> values = Arrays.asList(1,2,7,2,4,5,1,5,9,12);
		
		//print unique
//		values.stream().distinct().forEach(s->System.out.println(s));
		
		List<Integer> newList =values.stream().distinct().sorted().collect(Collectors.toList());
		
		System.out.println(newList.get(2));
		
	}

}
