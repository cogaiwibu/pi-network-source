package com.facebook.react.bridge;

public interface JavaJSExecutor {

    public interface Factory {
        JavaJSExecutor create() throws Exception;
    }

    void close();

    String executeJSCall(String str, String str2) throws ProxyExecutorException;

    void loadApplicationScript(String str) throws ProxyExecutorException;

    void setGlobalVariable(String str, String str2);

    public static class ProxyExecutorException extends Exception {
        public ProxyExecutorException(Throwable th) {
            super(th);
        }
    }
}
