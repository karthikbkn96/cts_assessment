package lamda;

public class Customer {

	private int id;
	private String name;
	private String gender;
	private String city;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Customer(int id, String name, String gender, String city) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.city = city;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", gender=" + gender + ", city=" + city + "]";
	}

}
