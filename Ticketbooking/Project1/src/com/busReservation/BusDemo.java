package com.busReservation;
import java.util.Scanner;
import java.util.ArrayList;
public class BusDemo {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		ArrayList<Bus>buses=new ArrayList<Bus>();
		buses.add(new Bus(1,true,2));
		buses.add(new Bus(2,false,50));
		buses.add(new Bus(3,true,43));
		buses.add(new Bus(4,true,48));
		
		for(Bus b:buses)
		{
			b.displayBusInfo();
		}
		ArrayList<Booking>bookings=new ArrayList<Booking>();
		
		int userOpt=1;
		while(userOpt==1||userOpt==2) {
		System.out.println("Enter 1 to Book and 2 to cancellation and 3 to exit ");
		userOpt=scanner.nextInt();
		if(userOpt==1)
		{
			Booking booking=new Booking();
			if(booking.isAvailable(buses,bookings))
			{
				bookings.add(booking);
				System.out.println("Your booking is confirmed and your booking id is "+booking.id);
			}
			else
			{
				System.out.println("Sorry, Bus is full. Try another bus or date. ");
			}
		}
		if(userOpt==2)
		{
			System.out.println("Enter your Booking id to cancel the booking ");
			int reference=scanner.nextInt();
			boolean success = Booking.cancel(reference, bookings);
			System.out.println("successfully cancelled");
		}
		}
		scanner.close();
	}


}
