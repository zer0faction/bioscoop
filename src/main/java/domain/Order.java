package domain;

import java.util.ArrayList;

public class Order
{
    private int orderNr;
    private boolean isStudentOrder;

    private ArrayList<MovieTicket> tickets;

    public Order(int orderNr, boolean isStudentOrder)
    {
        this.orderNr = orderNr;
        this.isStudentOrder = isStudentOrder;

        tickets = new ArrayList<MovieTicket>();
    }

    public int getOrderNr()
    {
        return orderNr;
    }

    public void addSeatReservation(MovieTicket ticket)
    {
        tickets.add(ticket);
    }

    public double calculatePrice()
    {
        double price = 0; //1
        if (this.isStudentOrder = true) { //A

            int i = -1; //2
            for(MovieTicket m : tickets){
                i = i + 1; //3
                if ((i%2)==0){ //B
                    price = price + m.getPrice();
                    if(m.isPremiumTicket()){
                        price = price + 2; //4
                    }
                }
            }
            return price;

        } else {

            int i = -1; //6
            for(MovieTicket m : tickets){
                i = i + 1; //7

                if(m.getDate().getDayOfWeek().equals("MONDAY") || //C
                        m.getDate().getDayOfWeek().equals("TUESDAY") ||
                        m.getDate().getDayOfWeek().equals("WEDNESDAY") ||
                        m.getDate().getDayOfWeek().equals("THURSDAY")
                        ){
                    if ((i%2)==0) //D
                    {
                        price = price + m.getPrice(); //8
                        if(m.isPremiumTicket()){ //E
                            price = price + 3; //9
                        }
                    }
                } else {
                    price = price + m.getPrice(); //10
                    if(m.isPremiumTicket()){ //F
                        price = price + 3; //11
                    }
                }
            }
            if (i > 5){ //G
                price = price * 0.90; //12
            }
            return price;

        }
    }

    public void export(TicketExportFormat exportFormat)
    {
        // Bases on the string respresentations of the tickets (toString), write
        // the ticket to a file with naming convention Order_<orderNr>.txt of
        // Order_<orderNr>.json
    }
}
