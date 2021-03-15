package io.openact.data.notification;

import javax.annotation.Nullable;
import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

public class UserNotification implements Serializable {
    @Nullable
    private final String source;
    private final String text;
    private final Level level;
    private final Instant timestamp;

    public UserNotification(@Nullable String source, String text, Level level) {
        this.source = source;
        this.text = Objects.requireNonNull(text);
        this.level = Objects.requireNonNull(level);
        timestamp = Instant.now();
    }

    @Nullable
    public String getSource() {
        return source;
    }

    public String getText() {
        return text;
    }

    public Level getLevel() {
        return level;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserNotification that = (UserNotification) o;
        return Objects.equals(source, that.source) && Objects.equals(text, that.text) && level == that.level && Objects.equals(timestamp, that.timestamp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(source, text, level, timestamp);
    }

    public enum Level {
        INFORMATIONAL,
        NOTEWORTHY,
        IMPORTANT
    }
}
