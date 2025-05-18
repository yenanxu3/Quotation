/*
 * ICS4U Unit7 assignment
 * The "QuoteTester" program, demos using classes.
 *
 * @author  Yenan Xu
 * @version 1.0
 * @since   2025-05-16
 */

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class QuoteEngine {
    // properties
    private ArrayList<Quote> quotes = new ArrayList<>();

    private int quoteCount;

    private int currQuoteCount;

    // constructor

    public QuoteEngine() {
        quoteCount = 0;
        currQuoteCount = 0;
    }

    public void initializeQuote() {
        try {
            BufferedReader readFile = new BufferedReader(
                    new FileReader("./quotes.txt"));
            String line;
            while ((line = readFile.readLine()) != null) {
                // Assuming the format is "quote|author"
                String[] parts = line.split("\\|", 2);
                if (parts.length == 2) {
                    quotes.add(new Quote(parts[0], parts[1]));
                }
            }
            readFile.close();
        } catch (IOException e) {
            System.out.println("No quotes information is currently stored.");
        }
    }
    public void saveQuote() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("./quotes.txt"))) {
            for (Quote q : quotes) {
                writer.write(q.getQuote() + "|" + q.getAuthor());
                writer.newLine();
            }
            System.out.println("Quotes saved to file successfully.");
        } catch (IOException e) {
            System.err.println("Error saving quotes: " + e.getMessage());
        }
    }

    public void addQuote(final String quoteMessage, final String authorName) {
        quotes.add(new Quote(quoteMessage, authorName));
        quoteCount++;
    }

    public void removeQuote(final int quoteNumber) {
        quotes.remove(quoteNumber - 1);
        quoteCount--;
    }

    public void sortQuote() {
    }

    public String searchQuote(final int quoteNumber) {
        Quote searchedQuote = quotes.get(quoteNumber - 1);
        currQuoteCount = quoteNumber - 1;
        return quoteCount + searchedQuote.getQuote() + "|" + searchedQuote.getAuthor();
    }

    public String randomQuote() {
        int randomNum = (int) (Math.random() * quoteCount);
        Quote randomQuote = quotes.get(randomNum);
        currQuoteCount = randomNum;
        return quoteCount + randomQuote.getQuote() + "|" + randomQuote.getAuthor();
    }

    public String viewCurrQuote() {
        Quote currQuote = quotes.get(currQuoteCount);
        return quoteCount + currQuote.getQuote() + "|" + currQuote.getAuthor();
    }
    
    public String toString() {
        String output = "";
        for (int counter = 0; counter < quoteCount; counter++) {
            output += counter + ". " + quotes.get(counter).getQuote() + "|" + quotes.get(counter).getAuthor() + "\n";
        }
        return output;
    }
}
