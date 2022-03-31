package org.cdc.script;

import org.cdc.Data;
import org.cdc.data.mob.AggressiveMob;

import javax.script.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.file.Path;

public class SystemScriptEngine {

    public static void evalLevel(AggressiveMob mob) throws ScriptException, FileNotFoundException {
        Bindings bindings = new SimpleBindings();
        bindings.put("mob",mob);
        instance.evalScript("level",bindings);
    }
    private static SystemScriptEngine instance;

    public static SystemScriptEngine getInstance() {
        if (instance == null) instance = new SystemScriptEngine();
        return instance;
    }

    private ScriptEngine engine;
    private SystemScriptEngine() {
        //初始化脚本引擎
        Data data = Data.getInstance();
        ScriptEngineManager manager = new ScriptEngineManager();
        engine = manager.getEngineByName(data.getConfig().getProperty("script.engine"));
        data.setEngine(engine);
    }

    public Object evalScript(String scriptName) throws FileNotFoundException, ScriptException {
        Path scriptPath = Data.getInstance().getScriptsPath();
        String scriptFileName = Data.getInstance().getScripts().getProperty(scriptName);
        Path scriptFilePath = scriptPath.resolve(scriptFileName);
        return engine.eval(new FileReader(scriptFilePath.toFile()));
    }

    public Object evalScript(String scriptName, Bindings bindings) throws ScriptException, FileNotFoundException {
        if (bindings == null){
            evalScript(scriptName);
        }
        Path scriptPath = Data.getInstance().getScriptsPath();
        String scriptFileName = Data.getInstance().getScripts().getProperty(scriptName);
        Path scriptFilePath = scriptPath.resolve(scriptFileName);
        return engine.eval(new FileReader(scriptFilePath.toFile()),bindings);
    }
}
