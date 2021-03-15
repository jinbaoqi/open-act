package io.openact.components;

public interface Lifecycle {
    void initialize();

    boolean isInitialized();

    void terminate();
}
