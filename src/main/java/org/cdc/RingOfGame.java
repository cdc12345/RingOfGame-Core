package org.cdc;

import lombok.SneakyThrows;
import org.cdc.plugins.AbstractPlugin;
import org.cdc.plugins.PluginClassLoader;
import org.cdc.plugins.exception.PluginException;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.Properties;

public class RingOfGame {
    private static RingOfGame instance;
    public static RingOfGame getInstance(){
        if (instance == null) {
            instance = new RingOfGame();
        }
        return instance;
    }
    private boolean afterInit = false;
    private Properties config;
    public static void main(String[] args){
        RingOfGame instance = getInstance();
    }
    @SneakyThrows
    public void init(String workDirectory){
        //载入配置文件
        config.load(new FileInputStream("config.properties"));
        config.put("workDirectory",workDirectory);
        Data.getInstance().setConfig(config);
        Data.getInstance().setConfigPath(Paths.get("config.properties"));
        //载入脚本定义文件
        Properties scripts = new Properties();
        scripts.load(new FileInputStream("scripts.properties"));
        Data.getInstance().setScripts(scripts);
        //文件结构
        //脚本放置目录
        Path scripts1 = Paths.get(workDirectory,"scripts");
        Data.getInstance().setScriptsPath(scripts1);
        if (!scripts1.toFile().exists()){
            scripts1.toFile().mkdir();
        }
        //数据放置目录
        Path data = Paths.get(workDirectory,"data");
        Data.getInstance().setData(data);
        if (!data.toFile().exists()){
            scripts1.toFile().mkdir();
        }
        //插件放置目录
        Path plugins = Paths.get(workDirectory, "plugins");
        Data.getInstance().setPlugins(plugins);
        if (!plugins.toFile().exists()){
            plugins.toFile().mkdir();
        }
        //插件载入
        for (File jarFile: Objects.requireNonNull(plugins.toFile().listFiles(a -> a.getName().endsWith(".jar")))){
            PluginClassLoader pluginClassLoader = new PluginClassLoader(jarFile);
            AbstractPlugin plugin = pluginClassLoader.loadPlugin();
            //插件载入初始化
            plugin.onEnable();
        }
        //TODO:创建一个系统生物(Player)
        afterInit = true;
    }
    public void exit(){
        Data.getInstance().getPluginList().forEach(AbstractPlugin::onDisable);
    }
    public boolean isAfterInit() {
        return afterInit;
    }

    public Properties getConfig(){
        return config;
    }

    public String getVersion(){
        return config.getProperty("RingOfGame.version");
    }
}
