package co.sumit.java8;

import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CountCharactersInStringAndSortByCountDesc {

	public static void main(String[] args) {
		String str = "KNodirrrOpareeeee";

		str.chars().mapToObj(c->(char)c).collect(Collectors.groupingBy(Function.identity(),Collectors.counting())).entrySet()
		.stream().sorted(Collections.reverseOrder(Comparator.comparing(Map.Entry::getValue))).collect(Collectors.toList()).
		forEach(entry->{
			System.out.println("{"+entry.getKey()+","+entry.getValue()+"}");
		});
		
		System.out.println("==========Without Function.identity()=========");
		
		str.chars().mapToObj(c->(char)c).collect(Collectors.groupingBy(c->c,Collectors.counting())).entrySet()
		.stream().sorted(Collections.reverseOrder(Comparator.comparing(Map.Entry::getValue))).collect(Collectors.toList()).
		forEach(entry->{
			System.out.println("{"+entry.getKey()+","+entry.getValue()+"}");
		});
		
	}

}
