package org.cdc.events;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Classname DeathEvent
 * @Description 死亡事件
 * @date 2022/3/31 12:18
 * @author cdc123
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class DeathEvent extends Event {
    public DeathEvent(String killer, String death) {
        this.killer = killer;
        this.death = death;
    }

    /**
     * 杀手
     */
    protected String killer;
    /**
     * 死者
     */
    protected String death;

}
