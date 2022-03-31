package org.cdc.events;

import lombok.Data;

/**
 * @author Administrator
 * @Classname CombatEvent
 * @Description 战斗事件
 * @date 2022/3/30 12:33
 */
@Data
public class CombatEvent {
    public CombatEvent(String sponsorName, String attacked, long damage) {
        this.sponsorName = sponsorName;
        this.attacked = attacked;
        this.damage = damage;
    }

    private String watcher;
    /**
     * 攻击者
     */
    private final String sponsorName;
    /**
     * 被攻击者
     */
    private final String attacked;
    /**
     * 伤害
     */
    private final long damage;
}
