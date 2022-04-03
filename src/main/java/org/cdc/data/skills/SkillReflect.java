package org.cdc.data.skills;

import org.cdc.events.SkillCombatEvent;

/**
 * @author cdc123
 * @Classname org.cdc.data.skills.SkillReflect
 * @Description 技能反馈
 * @date 2022/4/3 16:48
 */
public interface SkillReflect {
    /**
     * 技能被使用
     * @param event 事件源
     * @return 伤害
     */
    long onSkillUsed(SkillCombatEvent event);

    /**
     * 技能被使用后的消息
     * @param event 事件源一般与{@link org.cdc.data.skills.SkillReflect#onSkillUsed(SkillCombatEvent)}一致
     * @return 消息
     */
    String onSkillUsedMessage(SkillCombatEvent event);

}
