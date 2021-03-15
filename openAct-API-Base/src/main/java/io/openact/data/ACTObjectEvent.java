package io.openact.data;

import javax.annotation.Nonnull;
import java.io.Serializable;

public class ACTObjectEvent implements Serializable {
    private final ACTObject<?> currentObjectState;
    private final ACTObject<?> previousObjectState;

    private final Type type;

    public ACTObjectEvent(ACTObject<?> currentObjectState,
                          ACTObject<?> previousObjectState,
                          @Nonnull Type type) {
        if (currentObjectState == null && !Type.OBJECT_REMOVED.equals(type)) {
            throw new IllegalArgumentException("current object is null " +
                    "but event type != OBJECT_REMOVED");
        }
        if (previousObjectState == null && !Type.OBJECT_CREATED.equals(type)) {
            throw new IllegalArgumentException("previous object is null " +
                    "but event type != OBJECT_CREATED");
        }
        this.currentObjectState = currentObjectState;
        this.previousObjectState = previousObjectState;
        this.type = type;
    }

    public ACTObject<?> getCurrentObjectState() {
        return currentObjectState;
    }

    public ACTObject<?> getPreviousObjectState() {
        return previousObjectState;
    }

    public ACTObject<?> getCurrentOrPreviousObjectState() {
        if (currentObjectState != null) {
            return currentObjectState;
        } else {
            return previousObjectState;
        }
    }

    public Type getType() {
        return type;
    }

    public enum Type {
        OBJECT_CREATED,
        OBJECT_MODIFIED,
        OBJECT_REMOVED;
    }
}
