import java.util.Scanner;

public class CinemaBookingSystem
{
    private static Scanner scan = new Scanner(System.in);
    private static String name;
    private static String seat;
    private static String yes;
    private static String opt;
    private static int totalPrice;
    private static int amountOfSeats;
    private static String [][] seats = {{"A1", "A2", "A3", "A4"},
                                        {"B1", "X ", "X ", "B4"},
                                        {"C1", "C2", "C3", "C4"},
                                        {"D1", "D2", "D3", "D4"}};



    public static void main(String[] args)
    {
        System.out.println("Hello customer, I am your Cinema Booking System.");
        getName();
        options();

    }

    public static void getName()
    {
        System.out.println("Please enter your Name.");
        name=scan.nextLine();
        System.out.println("Hello " +name+".");
    }

    public static void printSeats(String[][] seats)
    {
        System.out.println("\n" + "Seat list: (X = reserved seats)");
      for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(seats[i][j] + "   ");
            }
            System.out.println("   ");
        }
    }

    public static void chooseSeats()
    {
        System.out.println("\n" + "Please choose your seat. Each reservation costs 7€.");
        seat = scan.nextLine();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++){
                if(seats[i][j].equalsIgnoreCase(seat))
                {
                    if(seats[i][j] == "X ")
                    {
                        System.out.println("Seat is already taken.");
                    }
                    else {
                        seats[i][j] = "X ";
                        System.out.println("You have chosen seat: " + seat + ".");
                        amountOfSeats++;
                    }
                }

            }
        }
        printSeats(seats);
        System.out.println("If you want another seat...type: yes");
        System.out.println("Else, press enter");
        yes=scan.nextLine();
        if (yes.equalsIgnoreCase("yes"))
        {
            chooseSeats();
        }
        else
        {
            System.out.println("Continue booking...");
        }
    }

    public static int getPrice()
    {
        totalPrice = 7 * amountOfSeats;
        return totalPrice;
    }

    public static void deleteBooking() {

        System.out.println("Which Seat would you like to delete from your reservation?");
        seat = scan.nextLine();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (seats[i][j].equalsIgnoreCase(seat)) {

                    if (seats[i][j] == "X ") {
                        seats[i][j] = seat;
                        System.out.println("You've successfully deleted your Reservation. Would you like to delete another?");
                        yes = scan.nextLine();
                        if (yes.equalsIgnoreCase("yes"))
                        { deleteBooking(); }
                        else {System.out.println("We hope to see you again.");}

                    } else {
                        System.out.println("I am sorry, but it seems like this seat is still available. Please try again.");
                    }
                }
            }

        }
    }

    public static void options()
    {
        System.out.println("What do you want to do. Type reservation, delete reservation or quit");
        opt=scan.nextLine();
        if (opt.equalsIgnoreCase("reservation"))
        {
            System.out.println("We are very sorry, but today program only consists of one Show.");
            printSeats(seats);
            chooseSeats();
            getPrice();
            System.out.println("The reservation costs " + totalPrice + "€.");
            options();
        }
        else if (opt.equalsIgnoreCase("delete reservation"))
        {
            deleteBooking();
            printSeats(seats);
            options();
        }
        else if (opt.equalsIgnoreCase("quit"))
        {
            System.out.println("\n" + "Have a wonderful day.");
        }
    }

}
