package domain;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class OrderTests {

    LocalDateTime Tuesday = LocalDateTime.of(2019, 2, 5, 15, 1,1 );
    LocalDateTime Weekend = LocalDateTime.of(2019, 2, 2, 15, 1,1 );

    Movie movie = new Movie("wall-e");
    MovieScreening movieScreeningTuesday = new MovieScreening(movie, Tuesday, 10);
    MovieScreening movieScreeningWeekend = new MovieScreening(movie, Weekend, 10);

//    MovieTicket movieTicketTuesday = new MovieTicket(movieScreeningTuesday, true, 1, 1);
//    MovieTicket movieTicketWeekend = new MovieTicket(movieScreeningWeekend, true, 1, 1);

    @Test //studenten
    public void StudentFirstPremium() {
        MovieTicket movieTicketTuesday = new MovieTicket(movieScreeningTuesday, true, 1, 1);
        Order order = new Order(1, true);
        order.addSeatReservation(movieTicketTuesday);
        double price = order.calculatePrice();

        assertEquals(12, price);
    }

    @Test //studenten
    public void StudentFirstNormal() {
        MovieTicket movieTicketTuesday = new MovieTicket(movieScreeningTuesday, false, 1, 1);
        Order order = new Order(1, true);
        order.addSeatReservation(movieTicketTuesday);
        double price = order.calculatePrice();

        assertEquals(10, price);
    }

    @Test //studenten
    public void StudentSecondPremium() {
        //
    }

    @Test //studenten
    public void StudentSecondNormal() {
        //
    }

    @Test //niet studenten
    public void NonStudentWeekdayFirstPremium() {
        MovieTicket movieTicketTuesday = new MovieTicket(movieScreeningTuesday, true, 1, 1);
        Order order = new Order(1, false);
        order.addSeatReservation(movieTicketTuesday);
        double price = order.calculatePrice();

        assertEquals(10, price);
    }

    @Test //niet studenten
    public void NonStudentWeekdayFirstNormal() {
        MovieTicket movieTicketTuesday = new MovieTicket(movieScreeningTuesday, false, 1, 1);
        Order order = new Order(1, false);
        order.addSeatReservation(movieTicketTuesday);
        double price = order.calculatePrice();

        assertEquals(10, price);
    }

    @Test //niet studenten
    public void NonStudentWeekdaySecondPremium() {
        //
    }

    @Test //niet studenten
    public void NonStudentWeekdaySecondNormal() {
        //
    }
    @Test //niet studenten
    public void NonStudentNonWeekdayFirstPremium() {
        MovieTicket movieTicketTuesday = new MovieTicket(movieScreeningWeekend, true, 1, 1);
        Order order = new Order(1, false);
        order.addSeatReservation(movieTicketTuesday);
        double price = order.calculatePrice();

        assertEquals(10, price);
    }

    @Test //niet studenten
    public void NonStudentNonWeekdayFirstNormal() {
        MovieTicket movieTicketTuesday = new MovieTicket(movieScreeningWeekend, false, 1, 1);
        Order order = new Order(1, false);
        order.addSeatReservation(movieTicketTuesday);
        double price = order.calculatePrice();

        assertEquals(10, price);
    }

    @Test //niet studenten
    public void NonStudentNonWeekdaySecondPremium() {
        //
    }

    @Test //niet studenten
    public void NonStudentNonWeekdaySecondNormal() {
        //
    }
}
