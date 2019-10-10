import java.util.function.Consumer;

public class ConsumerExample01 {
  public static void main(String[] args)  {
 
    //java.util.function.Consumer is a functional interface in Java8
    //hence it can be used as an assignment
    Consumer<String> c1 = (input) -> {
     	System.out.println("Inside the consumer implementation"); 
    };
    
    c1.accept("A");
    
    //example 2
    Consumer<Integer> c2 = System.out::println;
    c2.accept(1);
    
  }
}
