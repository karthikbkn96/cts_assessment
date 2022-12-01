package lamda;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class lamda_stream_api {

	public static void main(String[] args) {

		List<Item> itemList = Arrays.asList(new Item(134, "Moto24", 15000, "Mobiles"),
				new Item(157, "Spiderman", 50, "Books"), new Item(204, "Acer", 70000, "Laptops"),
				new Item(210, "IPhone", 45000, "Mobiles"), new Item(215, "Shirt", 1500, "Shirts"));

		List<Customer> customerList = Arrays.asList(new Customer(1, "Tom", "Male", "Bangalore"),
				new Customer(2, "Mike", "Male", "Delhi"), new Customer(3, "Miley", "Female", "Pune"),
				new Customer(4, "Kunal", "Male", "Delhi"), new Customer(5, "Sakshi", "Female", "Delhi"));

		List<Order> orderList = Arrays.asList(
				new Order(1, "Delivered", LocalDate.of(2021, Month.NOVEMBER, 12),
						LocalDate.of(2021, Month.NOVEMBER, 14),
						Arrays.asList(new Item(134, "Moto24", 15000, "Mobiles"),
								new Item(204, "Acer", 70000, "Laptops")),
						new Customer(1, "Tom", "Male", "Bangalore")),
				new Order(2, "Delivered", LocalDate.of(2022, Month.MAY, 19), LocalDate.of(2022, Month.MAY, 24),
						Arrays.asList(new Item(134, "Moto24", 15000, "Mobiles")),
						new Customer(4, "Kunal", "Male", "Delhi")),
				new Order(3, "Delivered", LocalDate.of(2021, Month.JULY, 12), LocalDate.of(2021, Month.AUGUST, 04),
						Arrays.asList(new Item(134, "Moto24", 15000, "Mobiles"),
								new Item(204, "Acer", 70000, "Laptops")),
						new Customer(2, "Mike", "Male", "Delhi")),
				new Order(4, "Pending", LocalDate.of(2022, Month.OCTOBER, 12), LocalDate.of(2022, Month.OCTOBER, 12),
						Arrays.asList(new Item(134, "Moto24", 15000, "Mobiles"),
								new Item(204, "Acer", 70000, "Laptops")),
						new Customer(3, "Miley", "Female", "Pune")),
				new Order(5, "Pending", LocalDate.of(2021, Month.NOVEMBER, 12), LocalDate.of(2022, Month.OCTOBER, 12),
						Arrays.asList(new Item(134, "Moto24", 15000, "Mobiles"),
								new Item(204, "Acer", 70000, "Laptops")),
						new Customer(5, "Sakshi", "Female", "Delhi")));

		// Lambda
		// case 1 : List of items belongs to category "Mobiles"
		AtomicInteger count = new AtomicInteger(1);
		System.out.println("******List of items belongs to category Mobiles******\n");
		List<Item> listOfMobiles = new ArrayList<>();
		Consumer<List<Item>> case1 = (item) -> {
			item.forEach((items) -> {
				if (items.getCategory().equals("Mobiles")) {
					listOfMobiles.add(items);
					System.out.println(count.getAndIncrement() + ". " + items);
				}
			});
			System.out.println(listOfMobiles + "\n");
		};
		itemsList(case1, itemList);

		// case 2 : List of items belongs to category "Mobiles" and price greater than
		// 20000
		AtomicInteger count1 = new AtomicInteger(1);
		System.out.println("******List of items belongs to category Mobiles and price greater than 20000******\n");
		List<Item> listOfMobilesAndGT20K = new ArrayList<>();
		Consumer<List<Item>> case2 = (item) -> {
			item.forEach((items) -> {
				if (items.getCategory().equals("Mobiles") && items.getPrice() > 20000) {
					listOfMobilesAndGT20K.add(items);
					System.out.println(count1.getAndIncrement() + ". " + items);
				}
			});
			System.out.println(listOfMobilesAndGT20K + "\n");
		};

		itemsList(case2, listOfMobiles);

		// case 3 : List of order with items category is not "Mobiles"
		AtomicInteger count2 = new AtomicInteger(1);
		System.out.println("******List of orders not belongs to category Mobiles****** \n");
		List<Order> listOfNotMobiles = new ArrayList<>();
		Consumer<List<Order>> case3 = (order) -> {
			order.forEach((orders) -> {
				orders.getItems().forEach((itemss) -> {
					if (!itemss.getCategory().equals("Mobiles")) {
						listOfNotMobiles.add(orders);
						System.out.println(count2.getAndIncrement() + ". " + orders);
					}

				});

			});
			System.out.println(listOfNotMobiles + "\n");
		};

		orderList(case3, orderList);

		// case 4: List of items belongs to category "Laptops" and then apply 5%
		// discount
		AtomicInteger count4 = new AtomicInteger(1);
		System.out.println("******List of items belongs to category Laptops and then apply 5% discount******\n");
		List<Item> listOfLaptopsDiscoun5 = new ArrayList<>();
		Consumer<List<Item>> case4 = (item) -> {
			item.forEach((items) -> {
				if (items.getCategory().equals("Laptops")) {
					items.setPrice(items.getPrice() - (items.getPrice() * 0.05));
					listOfLaptopsDiscoun5.add(items);
					System.out.println(count4.getAndIncrement() + ". " + items);
				}
			});
			System.out.println(listOfLaptopsDiscoun5 + "\n");
		};

		itemsList(case4, itemList);

		// case 5: List of Ordered by customers who are female
		System.out.println("******List of Ordered by customers who are female******\n");
		Set<Item> listOForderByFemaleset = new HashSet<>();
		Consumer<List<Order>> case5 = (order) -> {
			order.forEach((orders) -> {
				if (orders.getCustomer().getGender().equals("Female")) {
					orders.getItems().forEach((items) -> {
						listOForderByFemaleset.add(items);
					});
				}
			});

			System.out.println(listOForderByFemaleset + "\n");
		};

		orderList(case5, orderList);

		// case 6: List of Ordered by customers between 01 Jan 2022 to 31 Oct 2022
		System.out.println("******List of Ordered by customers between 01 Jan 2022 to 31 Oct 2022******\n");
		Set<Item> listOForderByDate = new HashSet<>();
		Consumer<List<Order>> case6 = (order) -> {
			order.forEach((orders) -> {
				if (orders.getOrderDate().compareTo(LocalDate.of(2022, Month.JANUARY, 01)) >= 0
						|| orders.getOrderDate().compareTo(LocalDate.of(2022, Month.OCTOBER, 31)) <= 0) {
					orders.getItems().forEach((items) -> {
						listOForderByDate.add(items);
					});
				}
			});
			System.out.println(listOForderByDate + "\n");
		};

		orderList(case6, orderList);
		
		
//===================================================================================================
// Stream API
		
// Case 1 :
		
List<Item> listitems = itemList.stream()
					.filter(item -> item.getCategory().equals("Mobiles")).collect(Collectors.toList());
System.out.println("=============================================================");
System.out.println("Case 1");
System.out.println(listitems + "\n");
		
//Case 2 : 
List<Item> listitems20k = listitems.stream()
				.filter(item -> item.getPrice()>20000).collect(Collectors.toList());	
System.out.println("Case 2");
System.out.println(listitems20k + "\n");		


//Case 3 :
List<Order> notMob = orderList.stream().filter(order -> order.getItems().stream().anyMatch(item -> !item.getCategory().equals("Mobiles"))).collect(Collectors.toList());
System.out.println("Case 3");
notMob.forEach(list -> System.out.println(list));
System.out.println(notMob + "\n");	

//Case 4 :
List<Item> listItemsDiscount = itemList.stream()
				.filter(item -> item.getCategory().equals("Laptops"))
				.map(item -> {item.setPrice(item.getPrice() - (item.getPrice() * 0.05));
return item;}).collect(Collectors.toList());
System.out.println("Case 4");
System.out.println(listItemsDiscount + "\n");

//Case 5 :
Set<Item> listItemsPurachasedByFemale = orderList.stream()
 						.filter(order -> order.getCustomer().getGender().equals("Female"))
 						.collect(Collectors.toList()).stream()
 						.map(list-> {return list.getItems();})
 						.collect(Collectors.toList())
 						.stream().flatMap(List::stream).collect(Collectors.toSet());
System.out.println("Case 5");
System.out.println(listItemsPurachasedByFemale + "\n");

//Case 5 :
Set<Item> ListOfItemDateRange = orderList.stream()
						.filter(order -> order.getOrderDate().compareTo(LocalDate.of(2022, Month.JANUARY, 01)) >= 0
								|| order.getOrderDate().compareTo(LocalDate.of(2022, Month.OCTOBER, 31)) <= 0)
						.collect(Collectors.toList()).stream().map(items -> {
							return items.getItems();
						}).collect(Collectors.toList()).stream().flatMap(List::stream).collect(Collectors.toSet());
						
System.out.println("Case 6");
System.out.println(ListOfItemDateRange + "\n");

};

	private static void itemsList(Consumer<List<Item>> itemConsumer, List<Item> itemList) {
		itemConsumer.accept(itemList);
	}

	private static void orderList(Consumer<List<Order>> itemConsumer, List<Order> itemList) {
		itemConsumer.accept(itemList);
	}
};
