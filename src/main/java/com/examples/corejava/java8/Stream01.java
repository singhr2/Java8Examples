import java.util.List;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Stream;
import java.util.stream.Collectors;

public class Stream01  {
  
	public static void main(String... args){
      	//Create an empty stream
      	Stream<String> streamEmpty = Stream.empty();
      
      	//Create Stream from List
    	Collection<String> collection = Arrays.asList("Three", "one", "Two", "Five", "Four");
      	Stream<String> streamOfItems = collection.stream();
      
      	//Converting back from Stream to List { terminal operation – the collect() method }
      	Collection<String> backToList = streamOfItems.collect(Collectors.toList());
      	System.out.println("Total Elements in List :" + backToList.size());
      
      	//Converting from Stream to comma-separated Strings
        String values = collection.stream().collect(Collectors.joining(", ", "{", "}")); // joining(delimiter, prefix, suffix)
      	System.out.println("Values as string :" + values); // {Three, one, Two, Five, Four}
      
      	//Create Stream from Array
      	Stream s3 = Stream.of("a", "A", "c");
      
      	//Create using Arrays.stream()
      	String[] serviceClasses = {"Gold", "Platinum", "Silver", "Bronze"};
      	Stream s4 = Arrays.stream(serviceClasses);
      
      	//OK as well
        Stream<Integer> stream = Stream.of( new Integer[]{1,2,3,4,5,6,7,8,9} );

      
      	//----------------------------------------------
      
      	//total elements
      	streamOfItems= collection.stream();
      	System.out.println("Total Items in stream: " + streamOfItems.count());
        
      	//reassigned to overcome issue 'stream has already been operated upon or closed'
      	// Note: Java 8 streams can't be reused.
      	streamOfItems = collection.stream();
      	//Print elements in sorted order
        streamOfItems.sorted().forEach(System.out::println);
      
      	//----------------------------------------------
      	/*
      	Operations:
        > Intermediate : 
        	map() : converts each element into another object via the given functiont.
            filter():  eliminate elements based on a criteria.
            distinct():
            limit(): reduce the size of the stream
            sorted() : 
            
            
        > Terminating : 
        	count():
            collect():
            reduce():
            forEach()
      	*/ 

      
      	System.out.println("\n ~~~~~~~~~~ filter() Example ~~~~~~~~");
		Stream<String> stream01 = Stream.of("", "a", "ab","o","z","i");
      	System.out.println(stream01.filter( (e) -> e.startsWith("a")).count()); //remove element if filter returns false
      	
      	System.out.println("\n ~~~~~~~~~~ map() Example ~~~~~~~~");
      	stream01 = Stream.of("", "a", "ab","o","z","i");
      	stream01.map( e -> e.toUpperCase()).forEach(System.out::println);
      
      	//print in Uppercase all names ending with 'ica
      	System.out.println("\n ~~~~~~~~~~ map() and filter() Example ~~~~~~~~");
      	Stream<String> stream02 = Stream.of("", "America", "Jamaica","uae","usa","uk");
      	stream02.filter( e -> e.endsWith("ica")).map(String::toUpperCase).forEach(System.out::println); 
      	
      	//Distinct example
      	System.out.println("\n ~~~~~~~~~~ Distinct Example ~~~~~~~~");
      
      	Stream<String> stream03 = Stream.of("USA", "UK", "UAE", "USA", "NL", "HK", "UK");
      	//stream03.distinct().forEach(System.out::println); 
      	String values01 = stream03.distinct().collect(Collectors.joining(", ", "[", "]"));
      	System.out.println("Distinct Values : " + values01);
    }
}
