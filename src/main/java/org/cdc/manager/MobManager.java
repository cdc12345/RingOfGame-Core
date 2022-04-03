package org.cdc.manager;

import lombok.Getter;
import org.cdc.LoadedInformation;
import org.cdc.data.ai.DefaultAI;
import org.cdc.data.mob.AI;
import org.cdc.data.mob.AggressiveMob;
import org.cdc.data.mob.Mob;

import java.util.Locale;
import java.util.TreeMap;

/**
 * @author cdc123
 * @Classname org.cdc.data.skills.MobManager
 * @Description 生物管理
 * @date 2022/4/3 16:48
 * @e-mail 3154934427@qq.com
 */
public class MobManager {

    public static class Ais{
        private static final TreeMap<String, AI> AIS = new TreeMap<>();
        public boolean register(String name,AI ai){
            if (isRegistered(ai)){
                return false;
            }
            if (name == null){
                name = ai.getClass().getSimpleName();
            }
            AIS.put(name,ai);
            return true;
        }

        /**
         * 得到被注册的AI
         * @param name 名字
         * @return ai
         */
        public AI getRegisteredByName(String name){
            return AIS.get(name);
        }

        public boolean isRegistered(AI ai){
            return AIS.containsValue(ai);
        }

    }

    @Getter
    private static final AI DEFAULT_AI =  new DefaultAI();

    public static void fight(AggressiveMob self,AggressiveMob another){

    }

    /**
     * 被注册的生物
     */
    private static final TreeMap<String,Mob> REGISTERED_MOBS = new TreeMap<>();

    /**
     * 注册生物
     * @param mob 被注册的生物
     * @return 是否成功
     */
    public static boolean register(Mob mob){
        if (isRegistered(mob)) {
            return false;
        }
        //得到id
        mob.setMobId(REGISTERED_MOBS.size());
        if (mob.getAi() == null&& LoadedInformation.getInstance().getScripts().containsKey(mob.getName())){
            mob.setAi(mob.getName());
        }
        REGISTERED_MOBS.put(mob.getName(),mob);
        return true;
    }

    public static Mob getRegisteredMobByName(String name){
        return REGISTERED_MOBS.get(name);
    }

    public static Mob getRegisteredMobById(long id){
        for (Mob mob :REGISTERED_MOBS.values()){
            if (mob.getMobId() == id){
                return mob;
            }
        }
        return null;
    }

    public static String getMobType(Mob mob){
        return mob.getClass().getSimpleName().toLowerCase(Locale.ROOT);
    }

    public static boolean isRegistered(Mob mob){
        if (mob.getMobId() == -1){
            return false;
        }
        return REGISTERED_MOBS.containsKey(mob.getName());
    }

}
