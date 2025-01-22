package co.sumit.designpattern;

public class Student {
	//mandatory fields
	private final long id;
	private final String name;
	//optional fields
	private final String address;
	
	
	private Student(Builder builder) {
		this.id=builder.id;
		this.name=builder.name;
		this.address=builder.address;
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



	public static class Builder{
		private long id;
		private String name;
		
		private String address;
		
		public Builder(long id,String name) {
			this.id=id;
			this.name=name;
		}
		
		public Builder address(String address) {
			this.address=address;
			return this;
		}
		
		public Student build() {
			return new Student(this);
		}
	}
	
	
	public static void main(String[] args) {
		Student.Builder MBAStudentBuilder=new Student.Builder(123, "Sumit");
		Student MBAStudent1 = MBAStudentBuilder.address("123 street").build();

		MBAStudentBuilder = new Student.Builder(542, "Samhita");
		Student MBAStudent2 = MBAStudentBuilder.address("123 street").build();
	}

}
