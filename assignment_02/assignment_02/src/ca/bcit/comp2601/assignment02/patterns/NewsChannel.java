package ca.bcit.comp2601.assignment02.patterns;

/**
 * NewsChannel as observer
 *
 * @author Guilherme Trevisan, Monika Szucs
 * @version 0.0.1
 * @since 2022-12-03
 */
public class NewsChannel implements Channel {
    private String news;

    /**
     * Implements update
     * @param news news to update (replaces current news)
     */
    @Override
    public void update(final Object news) {
        this.setNews((String) news);
    }

    /**
     * News Getter
     * @return news
     */
    public String getNews() {
        return news;
    }

    /**
     * News Setter
     * @param news news
     */
    public void setNews(final String news) {
        this.news = news;
    }
}
