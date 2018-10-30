package predicates;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;


//Predicate is  a function that takes a value and returns true or false 
public class LaptopPredicate {
	
	public List<Laptops> laptops;
	
	public static Predicate<Laptops> isBrandApple(){
		return laptop -> laptop.getBrand().equals("apple");
	}
	
	public static Predicate<Laptops> isPriceMorethan1100(){
		return laptop -> laptop.getPrice() >= 1100;
	}
	
	public static Predicate<Laptops> isPriceLessthan650(){
		return laptop -> laptop.getPrice() <= 650;
	}
	
	public static List<Laptops> filterLaptops(List<Laptops> laptops, Predicate<Laptops>predicate){
		return laptops.stream()
				.filter(predicate)
				 // We can even use default filter() to mention this, if we don't have a method.
				//.filter(laptop ->{return  laptop.getPrice() >= 1100;})
				.collect(Collectors.toList());
	}
	
	 //Predicate methods 
	// And predicate combining both predicates using logical AND
	static Predicate<Laptops> andPredicate = LaptopPredicate.isPriceMorethan1100()
			.and(LaptopPredicate.isBrandApple());
	
	//Negate predicate method (Getting an logical negation predicate of existing condition)
	static Predicate<Laptops> negatePredicate = LaptopPredicate
			.isPriceLessthan650()
			.negate();
	

	public static void main(String[]args) {
		List<Laptops> list = Arrays.asList(new Laptops("Apple", 1150),
				 new Laptops("lenevo", 800),
				 new Laptops("Dell",640)
				 ,new Laptops("Asus",420));
		
		 /*LaptopPredicate.filterLaptops(list, isPriceMorethan1100())
		 .forEach(System.out::println);*/
		
		// Lambda way of doing it 
		 
		 LaptopPredicate.filterLaptops(list, laptop->{
			 return laptop.getPrice() >= 1100;
		 }).forEach(System.out::println);
		 
		 // Using andPredicate combining the conditions of brand and price 
		 list.stream()
		 .filter(andPredicate)
		 .forEach(System.out::println);
		 
		 //Combining stream, negatePredicate
		 list.stream()
		 .filter(negatePredicate)
		 .forEach(System.out::println);
	}

}

