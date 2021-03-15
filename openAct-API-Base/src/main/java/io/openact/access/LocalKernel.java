package io.openact.access;

import io.openact.components.Lifecycle;
import io.openact.components.kernel.KernelExtension;

public interface LocalKernel extends Kernel, Lifecycle {
    void addKernelExtension(KernelExtension newExtension);

    void removeKernelExtension(KernelExtension rmExtension);
}
