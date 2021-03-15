package io.openact.data;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.*;
import java.util.stream.Collectors;

public abstract class ACTObject<E extends ACTObject<E>> {
    private final Map<String, String> properties;

    private final Map<String, String> propertiesReadonly;

    private final String name;

    public ACTObject(@Nonnull String name,
                     @Nonnull Map<String, String> properties) {
        this.properties = properties;
        this.propertiesReadonly = Collections.unmodifiableMap(properties);
        this.name = name;
    }

    @Nonnull
    public String getName() {
        return name;
    }

    @Nonnull
    public Map<String, String> getProperties() {
        return propertiesReadonly;
    }

    @Nullable
    public String getProperty(String key) {
        return properties.get(key);
    }

    public abstract ACTObject<E> withProperty(String key, String value);

    public abstract ACTObject<E> withProperties(Map<String, String> properties);


    @Override
    public String toString() {
        return getClass().getSimpleName() + "{name=" + name + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof ACTObject) {
            ACTObject<?> other = (ACTObject<?>) o;
            return this.getName().equals(other.getName()) && this.getClass().equals(other.getClass());
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return getName().hashCode()
                ^ getClass().getName().hashCode();
    }

    protected static <K, V> Map<K, V> mapWithoutNullValues(Map<K, V> original) {
        Map<K, V> ret = new HashMap<>();

        for (Map.Entry<K, V> entry : original.entrySet()) {
            if (entry.getValue() != null) {
                ret.put(entry.getKey(), entry.getValue());
            }
        }

        return ret;
    }

    protected static <V> List<V> listWithoutNullValues(List<V> original) {
        return original.stream()
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    protected static <V> Set<V> setWithoutNullValues(Set<V> original) {
        return original.stream()
                .filter(Objects::nonNull)
                .collect(Collectors.toSet());
    }
}
