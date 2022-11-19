public class Note{
    private final String note;
    private final String bookTitle;
    private final int numberOfPages;

    public Note(final String note, final String bookTitle, final int numberOfPages)    {
        this.note = note;
        this.bookTitle = bookTitle;
        this.numberOfPages = numberOfPages;
    }

    public String getNote()    {
        return note;
    }

    public String getBookTitle()    {
        return bookTitle;
    }

    public int getNumberOfPages()    {
        return numberOfPages;
    }

    @Override
    public String toString()    {
        return "Note{" +
                "note='" + note + '\'' +
                ", bookTitle='" + bookTitle + '\'' +
                ", numberOfPages=" + numberOfPages +
                '}';
    }
}