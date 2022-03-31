package org.cdc.data.inventory;

import lombok.Data;
import org.cdc.data.mob.AggressiveMob;

import java.util.function.Function;

/**
 * 特殊物品类
 */
@Data
public class SpecialItem extends Item{
    public SpecialItem(){
        super();
        this.useful = bagMob -> true;
    }

    public SpecialItem(String itemName) {
        super(itemName);
        this.useful = bagMob -> true;
    }

    public SpecialItem(String itemName, long itemId) {
        super(itemName, itemId);
        this.useful = a->true;
    }

    public SpecialItem(String itemName, long itemId, Function<Item, Boolean> available) {
        super(itemName, itemId, available);
        this.useful = bagMob -> true;
    }

    public SpecialItem(String itemName, long itemId, Function<Item, Boolean> available, Function<AggressiveMob, Boolean> useful){
        super(itemName, itemId, available);
        this.useful = useful;
    }

    public SpecialItem(String itemName, long itemId, Function<Item, Boolean> available, String place, double health,
                       double power, double damage, double defense, double powerDamage, double powerDefense,
                       Function<AggressiveMob, Boolean> useful) {
        super(itemName, itemId, available);
        this.place = place;
        this.health = health;
        this.power = power;
        this.damage = damage;
        this.defense = defense;
        this.powerDamage = powerDamage;
        this.powerDefense = powerDefense;
        this.useful = useful;
    }

    /**
     * 特殊物品的存放位置
     */
    protected String place;
    /**
     *加成最大生命
     */
    protected double health;
    /**
     * 加成最大能量
     */
    protected double power;
    /**
     * 加成普通攻击力
     */
    protected double damage;
    /**
     * 加成普通防御力
     */
    protected double defense;
    /**
     * 加成能量攻击力
     */
    protected double powerDamage;
    /**
     * 加成能量防御力
     */
    protected double powerDefense;
    /**
     * 特殊物品可用性检查
     */
    protected Function<AggressiveMob, Boolean> useful;
    public boolean isUseful(AggressiveMob bagMob){
        return useful.apply(bagMob);
    }

}
