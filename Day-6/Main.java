package day6;
class TicketBooking {
    int totalSeats = 5;

    synchronized void bookTicket(String user, int seats) {
        if (seats <= totalSeats) {
            System.out.println(user + " is booking " + seats + " seat(s)...");
            try {
                Thread.sleep(1000); // Simulate delay
            } catch (InterruptedException e) {
                System.out.println(e);
            }
            totalSeats -= seats;
            System.out.println(user + " booked successfully. Remaining seats: " + totalSeats);
        } else {
            System.out.println("Sorry " + user + ", not enough seats. Remaining: " + totalSeats);
        }
    }
}

class User extends Thread {
    TicketBooking booking;
    String user;
    int seats;

    User(TicketBooking booking, String user, int seats) {
        this.booking = booking;
        this.user = user;
        this.seats = seats;
    }

    public void run() {
        booking.bookTicket(user, seats);
    }
}

public class Main {
    public static void main(String[] args) {
        TicketBooking booking = new TicketBooking();

        User u1 = new User(booking, "User1", 2);
        User u2 = new User(booking, "User2", 2);
        User u3 = new User(booking, "User3", 2);

        u1.start();
        u2.start();
        u3.start();
    }
}