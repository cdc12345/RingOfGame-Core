package org.cdc.data.mob;

/**
 * @Classname org.cdc.data.mob.MobGender
 * @Description 生物性别
 * @date 2022年3月31日 12点52分
 * @author cdc123
 */
public enum MobGender {
    /**雄性与雌性*/Male("雄性"),Female("雌性");
    String name;
    MobGender(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
}
