package org.cdc.plugins;

import com.alibaba.fastjson.JSONObject;
import org.cdc.Data;
import org.cdc.plugins.exception.PluginException;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.jar.JarException;

/**
 * @author cdc123
 */
public class PluginClassLoader {
    private static ClassLoader parent = Thread.currentThread().getContextClassLoader();
    private final URLClassLoader pluginClassLoader;
    private PluginInformation information;
    public PluginClassLoader(File pluginFile) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException, PluginException {
        String jarExtension = ".jar";
        if (pluginFile.getName().endsWith(jarExtension)){
            URL[] urls = {pluginFile.toURI().toURL()};
            pluginClassLoader = new URLClassLoader(urls,parent);
            parent = pluginClassLoader;
        } else {
            throw new JarException(pluginFile.getAbsolutePath()+"不是jar");
        }
    }
    private AbstractPlugin pluginInstance;
    public AbstractPlugin loadPlugin() throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException, PluginException {
        information = loadPluginInformation();
        pluginInstance = initPlugin();
        Data.getInstance().getPluginList().add(pluginInstance);
        return pluginInstance;
    }

    /**
     * 载入插件信息
     * 这必须是第一个被执行
     * @return 插件信息实例
     * @throws IOException
     */
    public PluginInformation loadPluginInformation() throws IOException {
        //获取plugin.json
        URL plugin = pluginClassLoader.findResource("plugin.json");
        return JSONObject.parseObject(plugin.openStream(),PluginInformation.class);
    }

    /**
     * 初始化插件
     * 创建插件数据文件夹
     * 得到插件实例
     * @return 插件实例
     * @throws PluginException 插件错误
     * @throws ClassNotFoundException 类未找到
     * @throws InstantiationException 实例化错误
     * @throws IllegalAccessException 非法访问
     */
    public AbstractPlugin initPlugin() throws PluginException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        //创建对应的插件数据文件夹
        Path pluginDataStorePath = Paths.get(Data.getInstance().toString(), information.getPluginName());
        if (!pluginDataStorePath.toFile().exists()){
            pluginDataStorePath.toFile().mkdir();
        }
        information.setDataPath(pluginDataStorePath);
        //获取插件实例并存放
        Class<?> pluginClass = (Class<?>) pluginClassLoader
                .loadClass(information.getMainClass());
        if (pluginClass.getDeclaringClass().equals(AbstractPlugin.class)) {
            AbstractPlugin pluginInstance = (AbstractPlugin) pluginClass.newInstance();
            pluginInstance.init(information, this);
            return pluginInstance;
        } else {
            throw new PluginException(String.format("在插件%s中所定义的主类不是AbstractPlugin的子类，无法创建对象",information.getPluginName()));
        }
    }
}
