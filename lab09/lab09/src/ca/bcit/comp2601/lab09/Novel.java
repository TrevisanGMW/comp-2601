package ca.bcit.comp2601.lab09;

/**
 * Novel Class - Modified for Quiz 4
 *
 * @author Guilherme Trevisan
 * @version 0.0.2
 * @since 2022-11-18
 */
public class Novel {
    private final String title;
    private final String authorName;
    private final int yearPublished;

    /**
     * Default Constructor for Novel
     *
     * @param title         : the title of book
     * @param authorName    : the name of author
     * @param yearPublished : the year of published
     */
    public Novel(final String title, final String authorName, final int yearPublished) {
        if(title == null || title.isBlank()) {
            throw new IllegalArgumentException("Invalid title. Cannot be null or blank");
        }
        if(authorName == null || authorName.isBlank()) {
            throw new IllegalArgumentException("Invalid author. Cannot be null or blank");
        }
        this.title = title;
        this.authorName = authorName;
        this.yearPublished = yearPublished;
    }

    /**
     * Getter Title
     *
     * @return the name or title of book
     */
    public String getTitle() {
        return title;
    }

    /**
     * Getter Author Name
     *
     * @return the name of author
     */
    public String getAuthorName() {
        return authorName;
    }

    /**
     * Getter Year Published
     *
     * @return the year of published
     */
    public int getYearPublished() {
        return yearPublished;
    }

    /**
     * toString override (I had already overridden before the quiz requirement, so I kept it as it is)
     * @return returns a string containing title author and year published
     */
    @Override
    public String toString() {
        return title + " by " + authorName + " (Published Year " + yearPublished + ")";
    }
}
