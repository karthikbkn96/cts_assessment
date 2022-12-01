package lamda;

public class Item {

	private int id;
	private String name;
	private double price;
	private String category;

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

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	
	@Override
	public String toString() {
		return "Item [id=" + id + ", name=" + name + ", price=" + price + ", category=" + category + "]";
	}

	@Override
	public boolean equals(Object obj) {
		return !super.equals(obj);
	}
	
	@Override
	public int hashCode() {
		String hashcode = String.valueOf(getId());
		return hashcode.hashCode();
	}

	public Item(int id, String name, double price, String category) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.category = category;
	}


	
}
