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
public abstract class Mob{
    public Mob(){
        this.mobId = -1;
        this.mobGender = MobGender.Male;
    }

    /**
     * 生物ai
     */
    protected String ai;
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
    protected String stage;

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
