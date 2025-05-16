/*
 * ICS4U Unit7 assignment
 * The "QuoteTester" program, demos using classes.
 *
 * @author  Yenan Xu
 * @version 1.0
 * @since   2025-05-16
 */

import java.util.Scanner;

public final class QuoteTester {
    /**
     * Prevent instantiation.
     * Throw an exception IllegalStateException.
     * if this is ever called
     *
     * @throws IllegalStateException if this is ever called
     *
     */
    private QuoteTester() {
        throw new IllegalStateException("Cannot be instantiated");
    }

    /**
     * The starting main() function.
     *
     * @param args No args will be used
     */
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        QuoteEngine quoteEngine = new QuoteEngine();
        quoteEngine.initializeQuote();
        while (true) {
            System.out.println("""
            Menu:
            1--Add Quote
            2--Remove Quote
            3--Search Quote
            4--Display Current Quote
            5--Display Random Quote
            6--Display All Quotes
            7--Exit
            """);
            String userChoice = userInput.nextLine();
            if (userChoice.equals("1")) {
                System.out.println("Quote Message:");
                String userQuote = userInput.nextLine();
                System.out.println("Author Name:");
                String userName = userInput.nextLine();
                quoteEngine.addQuote(userQuote, userName);
            } else if (userChoice.equals("2")) {
                System.out.println("Number of the Quote you want to remove:");
                int userRemoveNumber = Integer.parseInt(userInput.nextLine());
                quoteEngine.removeQuote(userRemoveNumber);
            } else if (userChoice.equals("3")) {
                System.out.println("Number of the Quote you want to search:");
                int userSearchNumber = Integer.parseInt(userInput.nextLine());
                quoteEngine.searchQuote(userSearchNumber);
            } else if (userChoice.equals("4")) {
                System.out.println(quoteEngine.viewCurrQuote());
            } else if (userChoice.equals("5")) {
                System.out.println(quoteEngine.randomQuote());
            } else if (userChoice.equals("6")) {
                System.out.println(quoteEngine.toString());
            } else if (userChoice.equals("7")) {
                quoteEngine.saveQuote();
                System.exit(0);
            } else {
                System.out.println("Invalid input, please try again.");
            }
        }
    }
 }