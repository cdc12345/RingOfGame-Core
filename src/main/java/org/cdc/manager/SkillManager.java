package org.cdc.manager;

import org.cdc.data.skills.Skill;

import java.util.Locale;
import java.util.TreeMap;

/**
 * @author cdc123
 * @Classname org.cdc.manager.SkillManager
 * @Description 技能管理类
 * @date 2022/4/3 16:46
 */
public class SkillManager {
    /**
     * 技能类别
     * @param skill 技能
     * @return 技能类别
     */
    public static String getSkillType(Skill skill){
        return skill.getClass().getSimpleName().toLowerCase(Locale.ROOT);
    }

    private static final TreeMap<String,Skill> REGISTERED_SKILLS = new TreeMap<>();

    public boolean isRegistered(Skill skill){
        return REGISTERED_SKILLS.containsValue(skill);
    }

    public boolean register(Skill skill){
        if (isRegistered(skill)){
            return false;
        }
        REGISTERED_SKILLS.put(skill.getName(),skill);
        return true;
    }

    /**
     * 得到被注册的技能
     * @param name 技能名称
     * @return 技能实例
     */
    public Skill getRegisterByName(String name){
        return REGISTERED_SKILLS.get(name);
    }
}
