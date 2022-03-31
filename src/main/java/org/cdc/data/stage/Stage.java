package org.cdc.data.stage;

import lombok.Data;
import org.cdc.data.mob.Mob;

import java.util.ArrayList;

/**
 * 场景基类
 */
@Data
public abstract class Stage {
    private static long existStageId = -1;

    /**
     * 分配场景唯一id
     * 如果想要获得生物id分配到了哪,请看{@link Stage#getExistStageId()} }
     * @return 分配的id
     */
    public static long createStageId(){
        return ++existStageId;
    }

    /**
     * 获取当前分配至的场景唯一id
     * @return 如果没有分配那么返回-1
     */
    public static long getExistStageId(){return existStageId;}

    public Stage(){
        this("");
    }
    public Stage(String name){
        this(name,null,createStageId(),new ArrayList<>());
    }
    public Stage(String name, Stage parent, long id, ArrayList<Mob> mobs) {
        this.name = name;
        this.parent = parent;
        this.id = id;
        this.mobs = mobs;
    }

    /**
     * 舞台名字
     */
    protected String name;
    /**
     * 母舞台
     */
    protected Stage parent;
    /**
     * 舞台id
     */
    protected long id;
    /**
     * 生物列表
     */
    protected ArrayList<Mob> mobs;

}
