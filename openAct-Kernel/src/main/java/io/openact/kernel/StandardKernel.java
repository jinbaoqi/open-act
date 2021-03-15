package io.openact.kernel;

import io.openact.access.LocalKernel;
import io.openact.components.kernel.KernelExtension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.Semaphore;

public class StandardKernel implements LocalKernel, Runnable {
    private static final Logger LOG = LoggerFactory.getLogger(StandardKernel.class);
    private volatile boolean initialized;
    private final Semaphore terminationSemaphore = new Semaphore(0);

    @Override
    public State getState() {
        return null;
    }

    @Override
    public void setState(State newState) {

    }

    @Override
    public void addKernelExtension(KernelExtension newExtension) {

    }

    @Override
    public void removeKernelExtension(KernelExtension rmExtension) {

    }

    @Override
    public void run() {
        terminationSemaphore.acquireUninterruptibly();

        LOG.info("Terminating...");


    }

    @Override
    public void initialize() {
        if (isInitialized()) {
            return;
        }

        initialized = true;
    }

    @Override
    public boolean isInitialized() {
        return initialized;
    }

    @Override
    public void terminate() {
        if (!isInitialized()) {
            return;
        }

        initialized = false;
    }
}
