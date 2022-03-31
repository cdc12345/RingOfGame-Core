package org.cdc.manager;

import lombok.Getter;
import org.cdc.data.ai.DefaultAI;
import org.cdc.data.mob.AI;
import org.cdc.data.mob.AggressiveMob;
import org.cdc.data.mob.Mob;

/**
 * @author cdc123
 */
public class MobManager {
    @Getter
    private static final AI DEFAULT_AI =  new DefaultAI();

    public static void fight(AggressiveMob self,AggressiveMob another){

    }

    public static String getMobType(Mob mob){
        return mob.getClass().getSimpleName();
    }
}
