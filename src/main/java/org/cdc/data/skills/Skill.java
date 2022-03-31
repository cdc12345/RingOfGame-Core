package org.cdc.data.skills;

import lombok.Getter;
import lombok.Setter;
import org.cdc.events.CombatEvent;

import java.util.function.Function;

@Getter
public class Skill {
    private String name;
    @Setter
    private Function<CombatEvent,Long> damage;
    /**
     * 使用此技能会出现的描述性文字
     */
    private String afterWords = "[self]对[another]使用了[skill],造成了[damage]";

    public Long getDamage(CombatEvent selfAttackedEvent){
        return damage.apply(selfAttackedEvent);
    }
}
