package org.cdc.plugins.exception;

public class PluginException extends Exception{
    public PluginException(String message){
        super(message);
    }
    public PluginException(String message,Exception e){
        super(message,e);
    }
}
