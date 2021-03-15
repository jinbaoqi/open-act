package io.openact.access;

public interface Kernel {
    State getState();

    void setState(State newState);

    enum State {
        MODELING,
        OPERATING,
        SHUTDOWN
    }
}
