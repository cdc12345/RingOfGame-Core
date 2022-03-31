package org.cdc.plugins;

import com.sun.istack.internal.NotNull;
import org.cdc.Data;

import java.nio.file.Path;

public abstract class AbstractPlugin {
    public static AbstractPlugin getPlugin(@NotNull String name){
        for (AbstractPlugin plugin: Data.getInstance().getPluginList()){
            if (plugin.getName().equals(name)){
                return plugin;
            }
        }
        return null;
    }
    private PluginInformation pluginInformation;
    private PluginClassLoader pluginClassLoader;
    void init(@NotNull PluginInformation pluginInformation,@NotNull PluginClassLoader classLoader){
        this.pluginInformation = pluginInformation;
        this.pluginClassLoader = classLoader;
    }
    public String getName(){
        return pluginInformation.getPluginName();
    }
    public String getVersion(){
        return pluginInformation.getVersion();
    }
    public String getDescription(){
        return pluginInformation.getDescription();
    }
    public String[] getAuthors(){
        return pluginInformation.getAuthors();
    }
    public Path getDataPath(){
        return pluginInformation.getDataPath();
    }
    public PluginClassLoader getPluginClassLoader(){
        return pluginClassLoader;
    }

    /**
     * 启用事件
     */
    public abstract void onEnable();

    /**
     * 禁用事件
     */
    public abstract void onDisable();
}
