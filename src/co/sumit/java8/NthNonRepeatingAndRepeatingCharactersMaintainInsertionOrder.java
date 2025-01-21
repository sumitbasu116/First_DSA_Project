package co.sumit.java8;

import java.util.LinkedHashMap;
import java.util.stream.Collectors;

public class NthNonRepeatingAndRepeatingCharactersMaintainInsertionOrder {

	public static void main(String[] args) {
		String str = "KNodirOpare";
		//Nth repeating chars,n=1 means 1st repeating char i.e. r. Suppose, n=2 means 2nd char which is repeating i.e. not presnt here.
		//if str="KNodirOparep"; then we have 2nd repeating char i.e. p.
		int n =1;
		
		Character nonUnique = str.chars().mapToObj(c->(char)c)
		.collect(Collectors.groupingBy(c->c, LinkedHashMap::new, Collectors.counting())).entrySet()
		.stream().filter(entry->entry.getValue()>1).skip(n-1).findFirst().get().getKey();
		
		System.out.println(nonUnique);
		
		//Nth non repeating or unique chars
		n =2;
		Character unique = str.chars().mapToObj(c->(char)c).collect(Collectors.groupingBy(c->c,LinkedHashMap::new,Collectors.counting())).entrySet()
		.stream().filter(c->c.getValue()==1).skip(n-1).findFirst().get().getKey();
		System.out.println(unique);
	}

}
