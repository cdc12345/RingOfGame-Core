package org.cdc.events;

/**
 * @author cdc123
 * @Classname org.cdc.events.SkillCombatEvent
 * @Description 技能战斗事件
 * @date 2022/4/3 16:41
 */
public class SkillCombatEvent extends CombatEvent{

    public SkillCombatEvent(String sponsorName, String attacked, long damage) {
        super(sponsorName, attacked, damage);
    }
    protected String skill;
}
