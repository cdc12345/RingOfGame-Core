package org.cdc;


import lombok.Data;
import org.cdc.plugins.AbstractPlugin;

import javax.script.ScriptEngine;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Properties;

/**
 * @author cdc123
 */
@Data
public class LoadedInformation {
    private static LoadedInformation instance;

    public static LoadedInformation getInstance() {
        if (instance == null) {
            instance = new LoadedInformation();
        }
        return instance;
    }

    private LoadedInformation() {
    }

    /**
     * 配置实例
     */
    private Properties config;
    /**
     * 脚本定义配置实例
     */
    private Properties scripts;


    /**
     * 配置目录
     */
    private Path configPath;
    /**
     * 数据目录
     */
    private Path data;
    /**
     * 脚本目录
     */
    private Path scriptsPath;
    /**
     * 插件目录
     */
    private Path plugins;

    /**
     * 插件实例存放表
     */
    private ArrayList<AbstractPlugin> pluginList = new ArrayList<>();

    /**
     * 脚本引擎
     */
    private ScriptEngine engine;

}
