package org.cdc.data.stage;

import lombok.Data;
import org.cdc.data.mob.Mob;

import java.util.ArrayList;

/**
 * 场景基类
 * @author cdc123
 */
@Data
public abstract class Stage {

    public Stage(String name){
        this(name,null,new ArrayList<>(),true);
    }
    public Stage(String name, Stage parent, ArrayList<Mob> mobs,boolean lock) {
        this.name = name;
        this.parent = parent;

        this.mobs = mobs;
        this.lock = lock;
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
    protected long id = -1;
    /**
     * 生物列表
     */
    protected final ArrayList<Mob> mobs;

    /**
     * 是否锁定,如果被锁定那么就不是临时场景
     */
    protected final boolean lock;

}
