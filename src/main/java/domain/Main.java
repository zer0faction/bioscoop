package domain;

import java.text.SimpleDateFormat;
import javax.swing.*;
import java.time.LocalDateTime;
import java.util.Date;

public class Main {
    public static void main(String[] args) {

        //Wat testen:
        //Combinatie van SeatRow + SeatNr mag bij geen een van de tickets hetzelfde zijn. Test of het fout gaat bij verkeerde tickets.
        //Calculate prijs moet goed zijn

        LocalDateTime now = LocalDateTime.now();
        now.getDayOfWeek();

        Movie movie = new Movie("wall-e");
        MovieScreening movieScreening = new MovieScreening(movie, now, 10);
        MovieTicket movieTicket = new MovieTicket(movieScreening, true, 1, 1);
        MovieTicket movieTicket2 = new MovieTicket(movieScreening, true, 1, 2);
        MovieTicket movieTicket3 = new MovieTicket(movieScreening, false, 1, 3);
        MovieTicket movieTicket4 = new MovieTicket(movieScreening, false, 1, 4);
        MovieTicket movieTicket5 = new MovieTicket(movieScreening, false, 1, 4);
        MovieTicket movieTicket6 = new MovieTicket(movieScreening, false, 1, 4);


        Order order = new Order(1, true);
        order.addSeatReservation(movieTicket);
        order.addSeatReservation(movieTicket2);
        order.addSeatReservation(movieTicket3);
        order.addSeatReservation(movieTicket4);
        order.addSeatReservation(movieTicket5);
        order.addSeatReservation(movieTicket6);

        System.out.println(order.calculatePrice());
    }
}
