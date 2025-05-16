/*
 * ICS4U Unit7 assignment
 * The "QuoteTester" program, demos using classes.
 *
 * @author  Yenan Xu
 * @version 1.0
 * @since   2025-05-16
 */

/**
 * This class is the Quote class.
 */
public class Quote {
    // properties

    /**
     * The message of the quote.
     */
    private String quote;

    /**
     * The name of the author.
     */
    private String author;

    // constructor

    /**
     * Constructor for quote
     * 
     * @param quoteMessage The message of the quote
     * @param authorName   The name of the author
     */
    public Quote(final String quoteMessage, final String authorName) {
        this.quote = quoteMessage;
        this.author = authorName;
    }

    // methods

    /**
     * This method returns the name of the author.
     * 
     * @return The name of the author
     */
    public String getAuthor() {
        return this.author;
    }

    /**
     * This method returns the message of the quote.
     * 
     * @return The message of the quote.
     */
    public String getQuote() {
        return this.quote;
    }

    /**
     * This method sets the name of the author.
     */
    public void setAuthor(final String authorName) {
        this.author = authorName;
    }

    /**
     * This method sets the message of the quote.
     */
    public void setQuote(final String quoteMessage) {
        this.quote = quoteMessage;
    }
}
