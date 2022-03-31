package org.cdc.data.mob;

import com.sun.istack.internal.NotNull;
import lombok.Data;
import org.cdc.data.ai.DefaultAI;
import org.cdc.data.stage.Stage;
import org.cdc.manager.MobManager;

import java.util.Objects;

/**
 * 生物基类
 * @author cdc
 * @version 2022年1月29日
 */
@Data
public abstract class Mob implements Cloneable{
    private static long existMobId = -1;

    /**
     * 分配生物唯一id
     * 如果想要获得生物id分配到了哪,请看{@link Mob#getExistMobId()}
     * @return 分配的id
     */
    public static long createMobId(){
        return ++existMobId;
    }

    /**
     * 获取当前分配至的生物唯一id
     * @return 如果没有分配那么返回-1
     */
    public static long getExistMobId(){return existMobId;}
    public Mob(){
        this.mobId = createMobId();
        this.mobGender = MobGender.Male;
        this.AI = MobManager.getDEFAULT_AI();
    }
    public Mob(String name, Long mobId, MobGender mobGender,Stage stage,AI ai) {
        this.name = name;
        this.mobId = mobId;
        this.mobGender = mobGender;
        this.stage = stage;
        this.AI = ai;
    }

    /**
     * 生物ai
     */
    protected AI AI;
    /**
     * 生物名字
     */
    protected String name;
    /**
     * 生物id(具有唯一性)
     */
    @NotNull
    protected long mobId;
    /**
     * 生物性别
     */
    @NotNull
    protected MobGender mobGender;
    /**
     * 生物所在舞台
     */
    @NotNull
    protected Stage stage;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Mob mob = (Mob) o;
        return mob.name.equals(name) && mobId == mob.mobId && mobGender == mob.mobGender ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, mobId, mobGender);
    }
}
