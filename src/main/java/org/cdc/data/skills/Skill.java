package org.cdc.data.skills;

import lombok.Data;
import org.cdc.events.SkillCombatEvent;

/**
 * @author cdc123
 * @date 2020.1.23
 * @e-mail 3154934427@qq.com
 */
@Data
public abstract class Skill {
    /**
     * 技能名字
     */
    protected  String name;
    /**
     * 技能反馈
     */
    protected SkillReflect skill;

    public Long getDamage(SkillCombatEvent event) {
        return skill.onSkillUsed(event);
    }

    public String getMessage(SkillCombatEvent event) {
        return skill.onSkillUsedMessage(event);
    }
}
