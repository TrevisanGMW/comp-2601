package ca.bcit.comp2601.assignment02.patterns;

import java.util.ArrayList;
import java.util.List;

/**
 * NewsAgency as observable
 *
 * @author Guilherme Trevisan, Monika Szucs
 * @version 0.0.1
 * @since 2022-12-03
 */
public class NewsAgency {
    private String news;
    private List<Channel> channels = new ArrayList<>();

    /**
     * Added observers
     * @param channel observing channel to add
     */
    public void addObserver(final Channel channel) {
        this.channels.add(channel);
    }

    /**
     * Remove observers
     * @param channel observing channel to remove
     */
    public void removeObserver(final Channel channel) {
        this.channels.remove(channel);
    }

    /**
     * News Setter (Notifies the channels)
     * @param news news to set
     */
    public void setNews(final String news) {
        this.news = news;
        for (Channel channel : this.channels) {
            channel.update(this.news);
        }
    }
}
