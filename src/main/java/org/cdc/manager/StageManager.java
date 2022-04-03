package org.cdc.manager;

import org.cdc.data.stage.Stage;

import java.util.TreeMap;

/**
 * @author cdc123
 * @Classname org.cdc.manager.StageManager
 * @Description 场景管理类
 * @date 2022/4/1 12:30
 */
public class StageManager {
    /**
     * 得到场景类型
     * @param stage 场景实例
     * @return 场景类型
     */
    public static String getStageType(Stage stage){
        return stage.getClass().getSimpleName();
    }

    /**
     * 注册的场景
     */
    private static final TreeMap<String,Stage> REGISTERED_STAGES = new TreeMap<>();

    public static boolean isRegistered(Stage stage){
        if (stage.getId() == -1){
            return false;
        }
        return REGISTERED_STAGES.containsKey(stage.getName());
    }

    public static boolean register(Stage stage){
        if (isRegistered(stage)){
            return false;
        }
        //创建id
        stage.setId(REGISTERED_STAGES.size());
        REGISTERED_STAGES.put(stage.getName(),stage);
        return true;
    }
    public static Stage getRegisteredStageByName(String name){
        return REGISTERED_STAGES.get(name);
    }

    public static Stage getRegisteredStageById(long id){
        for (Stage stage : REGISTERED_STAGES.values()){
            if (stage.getId() == id){
                return stage;
            }
        }
        return null;
    }
}
