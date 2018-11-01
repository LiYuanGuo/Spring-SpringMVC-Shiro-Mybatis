package com.system.util.distributedUUID;

public interface WorkerIdStrategy {
    void initialize();

    long availableWorkerId();

    void release();
}
