package org.cdc.plugins;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.nio.file.Path;
import java.util.List;

@Data
public class PluginInformation {

    @JSONField(name = "name")
    private String pluginName;

    @JSONField(name = "version")
    private String version;

    @JSONField(name = "authors")
    private String[] authors;

    @JSONField(name = "description")
    private String description;

    @JSONField(name = "main")
    private String mainClass;

    @JSONField(name = "depends")
    private List<String> depends;
    /**
     * 数据存放目录
     */
    private Path dataPath;
}
