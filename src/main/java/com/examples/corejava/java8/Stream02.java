import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

class Itinerary{
 	private long itineraryID ;
    private String sourceAirport;
    private String destinationAirport;
    private LocalDate dateOfTravel;
 
    public Itinerary(long itineraryID, String sourceAirport, String destinationAirport, LocalDate dateOfTravel) {
       this.itineraryID = itineraryID;
       this.sourceAirport = sourceAirport;
       this.destinationAirport = destinationAirport;
       this.dateOfTravel = dateOfTravel;
    }
  
  	public long getItineraryID (){
  		return itineraryID;
  	}
  
  	public String getSourceAirport(){
    	return sourceAirport;
    }
  
  	public String getDestinationAirport(){
    	return destinationAirport;
  	}
  
  	public LocalDate getDateOfTravel(){
    	return dateOfTravel;
    }
}



public class Stream02
{
  // arguments are passed using the text field below this editor
  public static void main(String[] args)
  {
    //Some verbose 
    LocalDate today = LocalDate.now(); 
    System.out.println("Today's Local date : " + today);
    
    LocalTime time = LocalTime.now(); 
    System.out.println("local time now : " + time);

    
	// Populating Data
    Itinerary it1 = new Itinerary(2001, "DEL", "PNQ", LocalDate.of(2019, 5,29));
    Itinerary it2 = new Itinerary(3002, "PNQ", "BKK", LocalDate.of(2009, 8,2));
    Itinerary it3 = new Itinerary(1402, "BOM", "IXC", LocalDate.of(2012, 5,4));
    Itinerary it4 = new Itinerary(1402, "IXC", "DEL", LocalDate.of(2019, 1,14));
    Itinerary it5 = new Itinerary(900,  "PNQ", "CHN", LocalDate.of(2017, 12,25));
    
    List<Itinerary> travels = Arrays.asList(it1, it2, it3, it4, it5);
    System.out.println("Total Itineraties :" + travels.size());
    
    Stream travelsStream = travels.stream();
    System.out.println("Total Itineraties-2 :" + travelsStream.count()); //terminating ops
    
        
    //Get all travels before 2019 from PNQ
    LocalDate dt01012019 = LocalDate.of(2019,1,1);
    travels.stream()
            .filter( t -> t.getDateOfTravel().isBefore(dt01012019))
            .filter( t -> t.getSourceAirport().equals("PNQ"))
            .map( t -> t.getDestinationAirport())			
            .forEach(System.out::println) ;
  }
}
