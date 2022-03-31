package org.cdc;


import org.cdc.plugins.AbstractPlugin;

import javax.script.ScriptEngine;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Properties;

@lombok.Data
public class Data {
    private static Data instance;
    public static Data getInstance(){
        if (instance == null) instance = new Data();
        return instance;
    }
    public Data(){
    }

    /**
     * 配置目录
     */
    private Path configPath;
    /**
     * 配置实例
     */
    private Properties config;
    /**
     * 脚本定义配置实例
     */
    private Properties scripts;
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
