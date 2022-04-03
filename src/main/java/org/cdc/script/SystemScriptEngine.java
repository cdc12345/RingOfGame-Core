package org.cdc.script;

import org.cdc.LoadedInformation;
import org.cdc.data.mob.AggressiveMob;

import javax.script.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.file.Path;
/**
 * @author cdc123
 * @Classname org.cdc.data.skills.SkillReflect
 * @Description 系统脚本引擎
 * @date 2022/4/3 16:48
 */
public class SystemScriptEngine {

    public static long evalLevel(AggressiveMob mob) throws ScriptException, FileNotFoundException {
        Bindings bindings = new SimpleBindings();
        bindings.put("mob",mob);
        return (long) instance.evalScript("level",bindings);
    }
    private static SystemScriptEngine instance;

    public static SystemScriptEngine getInstance() {
        if (instance == null){
            instance = new SystemScriptEngine();
        }
        return instance;
    }

    private final ScriptEngine engine;
    private SystemScriptEngine() {
        //初始化脚本引擎
        LoadedInformation data = LoadedInformation.getInstance();
        ScriptEngineManager manager = new ScriptEngineManager();
        engine = manager.getEngineByName(data.getConfig().getProperty("script.engine"));
        data.setEngine(engine);
    }

    public void evalScript(String scriptName) throws FileNotFoundException, ScriptException {
        Path scriptPath = LoadedInformation.getInstance().getScriptsPath();
        String scriptFileName = LoadedInformation.getInstance().getScripts().getProperty(scriptName);
        Path scriptFilePath = scriptPath.resolve(scriptFileName);
        engine.eval(new FileReader(scriptFilePath.toFile()));
    }

    public Object evalScript(String scriptName, Bindings bindings) throws ScriptException, FileNotFoundException {
        if (bindings == null){
            evalScript(scriptName);
        }
        Path scriptPath = LoadedInformation.getInstance().getScriptsPath();
        String scriptFileName = LoadedInformation.getInstance().getScripts().getProperty(scriptName);
        Path scriptFilePath = scriptPath.resolve(scriptFileName);
        return engine.eval(new FileReader(scriptFilePath.toFile()),bindings);
    }

    public <E> E getInterface(Class<E> interfaceClass){
        return ((Invocable) engine).getInterface(interfaceClass);
    }
}
