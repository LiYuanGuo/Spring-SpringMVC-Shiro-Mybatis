package com.system.util.distributedUUID;

public interface RandomCodeStrategy {
    void init();

    int prefix();

    int next();

    void release();
}
