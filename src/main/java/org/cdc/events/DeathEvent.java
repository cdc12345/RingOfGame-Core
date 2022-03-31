package org.cdc.events;

import lombok.Data;

/**
 * @Name DeathEvent
 * @Description 死亡事件
 * @date 2022/3/31 12:18
 * @author cdc123
 */
@Data
public class DeathEvent {
    public DeathEvent(String killer, String death) {
        this.killer = killer;
        this.death = death;
    }

    /**
     * 事件观察者
     */
    private String watcher;
    /**
     * 杀手
     */
    private String killer;
    /**
     * 死者
     */
    private String death;

}
