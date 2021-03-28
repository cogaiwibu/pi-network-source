package com.ironsource.sdk.controller;

import java.util.ArrayList;

public class CommandExecutor {
    private ArrayList mCommandExecutorQueue = new ArrayList();
    private CommandExecutorState mCommandExecutorState = CommandExecutorState.NOT_READY;
    private String mName;

    /* access modifiers changed from: package-private */
    public enum CommandExecutorState {
        NOT_READY,
        READY
    }

    public CommandExecutor(String str) {
        this.mName = str;
    }

    public synchronized void setReady() {
        this.mCommandExecutorState = CommandExecutorState.READY;
    }

    public synchronized void executeCommand(Runnable runnable) {
        if (this.mCommandExecutorState != CommandExecutorState.READY) {
            this.mCommandExecutorQueue.add(runnable);
        } else {
            runnable.run();
        }
    }

    public synchronized void purgeDelayedCommands() {
        Object[] array = this.mCommandExecutorQueue.toArray();
        for (int i = 0; i < array.length; i++) {
            ((Runnable) array[i]).run();
            array[i] = null;
        }
        this.mCommandExecutorQueue.clear();
    }
}
