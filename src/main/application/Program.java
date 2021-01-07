import model.entities.Reservation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws ParseException {
        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("Room number: ");
        int number = scanner.nextInt();
        System.out.println("Check-in date (dd/MM/yyy): ");
        Date checkIn = sdf.parse(scanner.next());
        System.out.println("Check-Out date (dd/MM/yyy): ");
        Date checkOut = sdf.parse(scanner.next());

        if (!checkOut.after(checkIn)) {
            System.out.println("Error in reservation: Check-out date must be after check-n date");
        } else {
            Reservation reservation = new Reservation(number, checkIn, checkOut);
            System.out.println("Reservation: " + reservation);
            System.out.println();
            System.out.println("Enter data to update the reservation");

            System.out.println("Check-in date (dd/MM/yyy): ");
            checkIn = sdf.parse(scanner.next());
            System.out.println("Check-Out date (dd/MM/yyy): ");
            checkOut = sdf.parse(scanner.next());

            String error = reservation.updateDates(checkIn, checkOut);
            if (error != null) {
                System.out.println("Error in reservation: " + error);
            } else {
                System.out.println("Reservation: " + reservation);
            }

        }
    }

}