package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {

		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Room number: ");
		int room = sc.nextInt();
		System.out.print("Check-in date (dd/MM/yyyy): ");
		Date in = sdf.parse(sc.next());
		System.out.print("Check-out date (dd/MM/yyyy): ");
		Date out = sdf.parse(sc.next());
		
		if (!out.after(in)) {
			System.out.println("Error in reservation: Check-out date must be after check-in date!");
		}
		else {
			Reservation reserv = new Reservation(room, in, out);
			System.out.println("Reservation: " + reserv);
		
			System.out.println("\nEnter data to update the reservation: ");
			System.out.print("Check-in date (dd/MM/yyyy): ");
			in = sdf.parse(sc.next());
			System.out.print("Check-out date (dd/MM/yyyy): ");
			out = sdf.parse(sc.next());
			
			Date now = sdf.parse("11/05/2019");
			if(in.before(now) || out.before(now)) {
				System.out.println("Error in reservation: Reservation dates for update must be future dates");
			}
			else if(in.after(out)) {
				System.out.println("\"Error in reservation: Check-out date must be after check-in date!");
			}else {
				reserv.updateDates(in, out);
				System.out.println("Reservation: "+ reserv);
			}
			
		}
		
		
		sc.close();
		
		
		
	}

}
