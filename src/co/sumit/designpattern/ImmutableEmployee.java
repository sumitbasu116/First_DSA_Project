package co.sumit.designpattern;

import java.util.ArrayList;
import java.util.List;

public final class ImmutableEmployee {

	private final long id;
	private final String name;
	
	private final String address;
	
	private final List<String> hobbies;
	
	public ImmutableEmployee(long id,String name,String address,List<String> hobbies) {
		this.id=id;
		this.name=name;
		this.address=address;
		this.hobbies = new ArrayList<>();
		for(String hobby:hobbies) {
			this.hobbies.add(hobby);
		}
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}

	public List<String> getHobbies() {
		List<String> newList = new ArrayList<>();
		for(String hobby:this.hobbies) {
			newList.add(hobby);
		}
		return newList;
	}
}
