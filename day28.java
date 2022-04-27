Problem : Given an unordered list of flights taken by someone, each represented as (origin, destination) pairs, and a starting airport, compute the person's itinerary. If no such itinerary exists, 			return null. If there are multiple possible itineraries, return the lexicographically smallest one. All flights must be used in the itinerary.

		For example, given the list of flights [('SFO', 'HKO'), ('YYZ', 'SFO'), ('YUL', 'YYZ'), ('HKO', 'ORD')] and starting airport 'YUL', you should return the list ['YUL', 'YYZ', 'SFO', 			'HKO','ORD'].

	Given the list of flights [('SFO', 'COM'), ('COM', 'YYZ')] and starting airport 'COM', you should return null.

	Given the list of flights [('A', 'B'), ('A', 'C'), ('B', 'C'), ('C', 'A')] and starting airport 'A', you should return the list ['A', 'B', 'C', 'A', 'C'] even though ['A', 'C', 'A', 'B', 'C'] 	is also a valid itinerary. However, the first one is lexicographically smaller.

Solution :
	import java.util.*;
	public class MyClass {
	    public static void main(String args[]) {
	      Scanner sc= new Scanner(System.in);
	      
	      ArrayList<ArrayList<String>> flights = new ArrayList<ArrayList<String>>();
	      
	      //No.of flights
	      int n = sc.nextInt();
	      
	      for(int i = 0; i < n; i++) {
		  flights.add(new ArrayList<String>());
		  //ith flight starting airport and destination airport
		  flights.get(i).add(sc.next());
		  flights.get(i).add(sc.next());
	      }
	      
	      //Starting airport selected by a person from where the journey starts
	      String startingAirport = sc.next();
	      
	      findItinerary(flights, startingAirport);
	      
	    }
	    
	    public static void findItinerary(ArrayList<ArrayList<String>> flights, String startingAirport) {
		//Stores each airport and list of it's various destination airports of flights
		Map<String, List<String>> flightsMap = new HashMap<>();
		
		for(int i = 0; i < flights.size(); i++) {
		    List<String> destinations = new ArrayList<>();
		    
		    if(flightsMap.get(flights.get(i).get(0)) != null) 
		        destinations = flightsMap.get(flights.get(i).get(0));
		        
		    destinations.add(flights.get(i).get(1));
		    Collections.sort(destinations);
		    
		    flightsMap.put(flights.get(i).get(0), destinations);  
		}
		
		List<String> itinerary = new ArrayList<>();
		itinerary.add(startingAirport);
		
		while(flightsMap.get(startingAirport) != null) {
		    List<String> destinations = flightsMap.get(startingAirport);
		    
		    String nextAirport = destinations.get(0);
		    destinations.remove(0);
		    
		    if(destinations.size() > 0)
		        flightsMap.put(startingAirport, destinations);
		    else
		        flightsMap.remove(startingAirport);
		        
		    itinerary.add(nextAirport);
		    startingAirport = nextAirport;
		}
		
		if(flightsMap.size() == 0) {
		        for(int i = 0; i < itinerary.size(); i++)
		            System.out.print(itinerary.get(i)+" ");
		}
		else
		    System.out.println("null");
		
	    }
	}
