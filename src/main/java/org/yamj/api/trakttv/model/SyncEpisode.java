package org.yamj.api.trakttv.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.joda.time.DateTime;

@JsonInclude(Include.NON_DEFAULT)
public class SyncEpisode extends AbstractJsonMapping {

    private static final long serialVersionUID = -7892135480595956382L;
    
    @JsonProperty("number")
    private Integer number;
    @JsonProperty("season")
    private Integer season;
    @JsonProperty("ids")
    private Ids ids;
    @JsonProperty("collected_at")
    private DateTime collectedAt;
    @JsonProperty("watched_at")
    private DateTime watchedAt;

    public SyncEpisode number(int number) {
        this.number = number;
        return this;
    }

    public SyncEpisode season(int season) {
        this.season = season;
        return this;
    }

    public SyncEpisode ids(Ids id) {
        this.ids = id;
        return this;
    }

    public SyncEpisode collectedAt(DateTime collectedAt) {
        this.collectedAt = collectedAt;
        return this;
    }

    public SyncEpisode watchedAt(DateTime watchedAt) {
        this.watchedAt = watchedAt;
        return this;
    }
}
