package com.movieticketbooking;
import java.util.*;
import java.util.concurrent.*;
import java.time.LocalDateTime;
public class MovieTicketBookingSystem{
	private List<Movie> movies=new CopyOnWriteArrayList<>();
	private Set<Theater> theaters=new CopyOnWriteArraySet<>();
	private Map<Theater,List<Showtime>> theaterShowtimes=new ConcurrentHashMap<>();
	private List<Booking> bookings=new CopyOnWriteArrayList<>();
	public void addMovie(Movie movie){
		movies.add(movie);
	}
	public void addTheater(Theater theater){
		theaters.add(theater);
		theaterShowtimes.put(theater,new ArrayList<>());
	}
	public void addShowtimeToTheater(Theater theater,Showtime showtime){
		theaterShowtimes.get(theater).add(showtime);
	}
	public void bookTicket(Movie movie,Showtime showtime,String customerName){
		if(showtime.isAvailable()){
			showtime.book();
			bookings.add(new Booking(movie,showtime,customerName));
			System.out.println("Booking successful for "+customerName);
		}else{
			System.out.println("Sorry, this showtime is unavailable.");
		}
	}
	public List<Movie> searchMoviesByName(String name){
		List<Movie> result=new ArrayList<>();
		for(Movie movie:movies){
			if(movie.getName().contains(name)){
				result.add(movie);
			}
		}
		return result;
	}
	public void sortMovies(){
		Collections.sort(movies);
	}
	public List<Showtime> searchShowtimes(Movie movie,Theater theater){
		List<Showtime> result=new ArrayList<>();
		for(Showtime showtime:theaterShowtimes.get(theater)){
			if(showtime.getMovie().equals(movie)){
				result.add(showtime);
			}
		}
		return result;
	}
	public static void main(String[] args){
		MovieTicketBookingSystem system=new MovieTicketBookingSystem();
		Movie movie1=new Movie("Varanasi","Globe-Trotter",148);
		Movie movie2=new Movie("Bahubali 2","Action",152);
		system.addMovie(movie1);
		system.addMovie(movie2);
		Theater theater1=new Theater("IMAX Theater","City Center");
		Theater theater2=new Theater("PVR","Lb Nagar");
		system.addTheater(theater1);
		system.addTheater(theater2);
		Showtime showtime1=new Showtime(LocalDateTime.of(2025,6,10,19,30),movie1);
		Showtime showtime2=new Showtime(LocalDateTime.of(2025,6,10,21,30),movie2);
		system.addShowtimeToTheater(theater1,showtime1);
		system.addShowtimeToTheater(theater2,showtime2);
		system.bookTicket(movie1,showtime1,"Mahesh Babu");
		List<Movie> searchResults=system.searchMoviesByName("Varanasi");
		System.out.println("Search Results: "+searchResults);
		system.sortMovies();
		System.out.println("Sorted Movies: "+system.movies);
	}
}