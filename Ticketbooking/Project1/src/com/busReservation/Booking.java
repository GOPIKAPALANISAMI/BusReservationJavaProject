package com.busReservation;
import java.util.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
public class Booking {
	String passengerName;
	int busNo;
	Date date;
	int id;
	Booking(){
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter Your Name");
		passengerName=scanner.next();
		System.out.println("Enter Bus No");
		busNo=scanner.nextInt();
		System.out.println("Enter Date dd-mm-yyyy");
		String dateinput=scanner.next();
		SimpleDateFormat dateFormat=new SimpleDateFormat("dd-MM-yyyy");
		try {
			date=dateFormat.parse(dateinput);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
	}
	public boolean isAvailable(ArrayList<Bus>buses,ArrayList<Booking>bookings)
	{
		int capacity=0;
		for(Bus bus:buses)
		{
			if(bus.getBusNo()==busNo)
			{
				capacity=bus.getCapacity();
			}
		}
		
		int booked=0;
		for(Booking b:bookings)
		{
			if(b.busNo==busNo && b.date.equals(date))
			{
				booked++;
			}
		}
		id=booked+1;
		return booked<capacity?true:false;
	}
	public static boolean cancel(int ref, ArrayList<Booking> bookings) {
        for (Booking book : bookings) {
            if (book.id == ref) {
                bookings.remove(book);
                return true;
            }
        }
        return false;
    }

}
