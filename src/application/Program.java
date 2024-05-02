package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		try {
			System.out.print("Room number: ");
			int room = sc.nextInt();
			System.out.print("Check-in date (dd/MM/yyyy): ");
			Date in = sdf.parse(sc.next());
			System.out.print("Check-out date (dd/MM/yyyy): ");
			Date out = sdf.parse(sc.next());
	
			Reservation reserv = new Reservation(room, in, out);
			System.out.println("Reservation: " + reserv);
	
			System.out.println("\nEnter data to update the reservation: ");
			System.out.print("Check-in date (dd/MM/yyyy): ");
			in = sdf.parse(sc.next());
			System.out.print("Check-out date (dd/MM/yyyy): ");
			out = sdf.parse(sc.next());
			
			reserv.updateDates(in, out);
			System.out.print("Reservation " + reserv);
		}
		
		catch (ParseException e) {
			System.out.println("Ivalid date format! ");
		}
		catch (DomainException e) {
			System.out.println("Error in reservation: " + e.getMessage());
		}
		


		sc.close();

	}
		
}
