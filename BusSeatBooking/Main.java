package Projects.BusSeatBooking;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[][] seats = {
                {"|___", "|___|  ", "|___", "|___", "|___"},
                {"|___", "|___|  ", "|___", "|___", "|___"},
                {"|___", "|___|  ", "|___", "|___", "|___"},
                {"|___", "|___|  ", "|___", "|___", "|___"},
                {"|___", "|___|  ", "|___", "|___", "|___"},
                {"|___", "|___|  ", "|___", "|___", "|___"},
                {"|___", "|___|  ", "|___", "|___", "|___"},
                {"|___", "|___|  ", "|___", "|___", "|___"},
                {"|___", "|___|  ", "|___", "|___", "|___"},
                {"|___", "|___|  ", "|___", "|___", "|___"},};
        boolean[][] book = {{false, false, false, false, false},
                {false, false, false, false, false},
                {false, false, false, false, false},
                {false, false, false, false, false},
                {false, false, false, false, false},
                {false, false, false, false, false},
                {false, false, false, false, false},
                {false, false, false, false, false},
                {false, false, false, false, false},
                {false, false, false, false, false}};

        int[][] ticketNo = new int[10][5];
//You can also make your unique Ticket Numbers
        for (int i = 0; i < ticketNo.length; i++) {
            for (int j = 0; j < ticketNo[i].length; j++) {
                ticketNo[i][j] = (int) (Math.random() * 10000);
            }
        }


        System.out.println("================================================================");
        System.out.println("Welcome to Bus Booking Enter the required option you need to do!");

        boolean exit = false;
        while (!exit) {
            System.out.println("================================================================");
            System.out.println("1 - To view Bus Seat");
            System.out.println("2 - Book Seat");
            System.out.println("3 - Cancel Seat");
            System.out.println("4 - Exit");
            System.out.println("================================================================");

            System.out.print("Enter your option: ");
            int option = scanner.nextInt();
            switch (option) {
                case 1 -> printSeats(seats);
                case 2 -> bookSeat(seats, book, ticketNo);
                case 3 -> cancelSeat(seats, book, ticketNo);
                case 4 -> exit = true;
                default -> System.out.println("Your choice is wrong enter correct option respectively");
            }
        }

    }

    static void printSeats(String[][] seats) {


        for (int i = 0; i < seats.length; i++) {

            if (i == 0) {
                System.out.print("    ");
                for (int j = 0; j <= seats[0].length; j++) {
                    if (j < 2) {
                        System.out.print(" " + (j + 1) + "  ");
                    } else if (j == 2) {
                        System.out.print("   ");
                    } else {
                        System.out.print(" " + j + "  ");
                    }
                }
                System.out.println();
            }

            System.out.print((char) (i + 65) + "  ");
            for (int j = 0; j < seats[i].length; j++) {
                System.out.print(seats[i][j]);
            }
            System.out.print("|");
            System.out.println();
            System.out.println();
        }
    }

    static void bookSeat(String[][] seats, boolean[][] book, int[][] ticketNo) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter seat number ( Ex - A1): ");
        String seatNoStr = scanner.next().toUpperCase();
        int first = (int) seatNoStr.charAt(0) - 65;
        int second = seatNoStr.charAt(1) - 49;

        if (seatNoStr.length() != 2 || first > 9 || second > 4 || first < 0 || second < 0) {
            System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
            System.out.println("XXXXX          INPUT ERROR       XXXXX");
            System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
        } else {

            if (!book[first][second] && second == 1) {
                System.out.println("Your seat " + seatNoStr + " booked");
                System.out.println("Your ticket no: " + ticketNo[first][second]);
                seats[first][second] = "| X |  ";
                book[first][second] = true;
            } else if (!book[first][second]) {
                System.out.println("Your seat " + seatNoStr + " booked");
                System.out.println("Your ticket no: " + ticketNo[first][second]);
                seats[first][second] = "| X ";
                book[first][second] = true;
            } else {
                System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
                System.out.println("The Seat you picked is already booked by others");
                System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
            }
        }

    }

    static void cancelSeat(String[][] seats, boolean[][] book, int[][] ticketNo) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter seat number (Ex - A1): ");
        String seatNoStr = scanner.next().toUpperCase();
        int first = (int) seatNoStr.charAt(0) - 65;
        int second = seatNoStr.charAt(1) - 49;

        if (seatNoStr.length() != 2 || first > 9 || second > 4) {
            System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
            System.out.println("XXXXX         INPUT ERROR        XXXXX");
            System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
        } else if (!book[first][second]) {
            System.out.println("This seat is not been booked");
        } else {

            if (book[first][second] && second == 1) {
                System.out.print("Enter the correct ticket no provided to cancel: ");
                int ticket = scanner.nextInt();
                if (ticket == ticketNo[first][second]) {
                    System.out.println("Your seat " + seatNoStr + " got Canceled");
                    seats[first][second] = "|___|  ";
                    book[first][second] = false;
                } else {
                    System.out.println("Oops provided ticket number is wrong!");
                }
            } else if (book[first][second]) {
                System.out.print("Enter the correct ticket no provided to cancel: ");
                int ticket = scanner.nextInt();
                if (ticket == ticketNo[first][second]) {
                    System.out.println("Your seat " + seatNoStr + " got Canceled");
                    seats[first][second] = "|___";
                    book[first][second] = false;
                } else {
                    System.out.println("Oops provided ticket number is wrong!");
                }
            } else {
                System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
                System.out.println("The Seat you picked is already booked by others");
                System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
            }
        }
    }

}


