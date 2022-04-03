package org.cdc.events;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author Administrator
 * @Classname CombatEvent
 * @Description 战斗事件
 * @date 2022/3/30 12:33
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class CombatEvent extends Event {
    public CombatEvent(String sponsorName, String attacked, long damage) {
        this.sponsorName = sponsorName;
        this.attacked = attacked;
        this.damage = damage;
    }
    /**
     * 攻击者
     */
    protected final String sponsorName;
    /**
     * 被攻击者
     */
    protected final String attacked;
    /**
     * 伤害
     */
    protected final long damage;
}
