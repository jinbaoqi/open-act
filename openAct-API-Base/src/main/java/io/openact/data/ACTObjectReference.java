package io.openact.data;

import javax.annotation.Nonnull;
import java.util.Objects;

public class ACTObjectReference<E extends ACTObject<E>> {
    private final String name;
    private final Class<?> referentClass;

    public ACTObjectReference(@Nonnull String name,
                              @Nonnull Class<?> referentClass) {
        this.name = name;
        this.referentClass = referentClass;
    }

    public ACTObjectReference(@Nonnull ACTObject<E> referent) {
        referentClass = referent.getClass();
        name = referent.getName();
    }

    public String getName() {
        return name;
    }

    public Class<?> getReferentClass() {
        return referentClass;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof ACTObjectReference) {
            ACTObjectReference<?> other = (ACTObjectReference<?>) o;

            return this.getName().equals(other.getName())
                    && this.getReferentClass().equals(other.getReferentClass());
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        // TODO:此处需要注意 名称需要有规则
        return name.hashCode();
    }
}
