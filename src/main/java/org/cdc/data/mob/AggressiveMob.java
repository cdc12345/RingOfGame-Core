package org.cdc.data.mob;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.cdc.data.Inventory;
import org.cdc.data.inventory.SpecialItem;
import org.cdc.data.stage.Stage;
import org.cdc.manager.ItemManager;
import org.cdc.manager.MobManager;
import org.cdc.script.SystemScriptEngine;

import javax.script.ScriptException;
import java.io.IOException;

/**
 * 攻击性生物基类 继承了{@link Mob}
 * @author cdc
 * @version 2022年1月29日
 */
@EqualsAndHashCode(callSuper = false)
@Data
public abstract class AggressiveMob extends Mob {
    public AggressiveMob(){
        super();
        this.inventory = new Inventory(this);
    }

    /**
     * 等级
     */
    protected long level;
    /**
     * 最大经验
     */
    protected long maxExp;
    /**
     * 当前经验值
     */
    protected long exp;
    /**
     * 最大生命值
     */
    protected double maxHealth;
    /**
     * 当前生命值
     */
    protected double health;
    /**
     * 最大能量
     */
    protected double maxPower;
    /**
     * 当前能量
     */
    protected double power;
    /**
     * 普通攻击力
     */
    protected double damage;
    /**
     * 普通防御力
     */
    protected double defense;
    /**
     * 能量攻击力
     */
    protected double powerDamage;
    /**
     * 能量防御力
     */
    protected double powerDefense;
    /**
     * 物品栏
     */
    Inventory inventory;

    public double getDamageAfterMarch(){
        return inventory.getEquipment().values().stream().map(a-> ((SpecialItem)ItemManager.getRegisteredItemByName(a)).getDamage()
        ).reduce(getDamage(),Double::sum);
    }

    public double getDefenseAfterMarch() {
        return inventory.getEquipment().values().stream().map(a->(SpecialItem)ItemManager.getRegisteredItemByName(a)).map(SpecialItem::getDefense).reduce(getDefense(),Double::sum);
    }
    public double getMaxHealthAfterMarch() {
        return inventory.getEquipment().values().stream().map(a->(SpecialItem)ItemManager.getRegisteredItemByName(a)).map(SpecialItem::getHealth).reduce(getMaxHealth(),Double::sum);
    }
    public double getMaxPowerAfterMarch() {
        return inventory.getEquipment().values().stream().map(a->(SpecialItem)ItemManager.getRegisteredItemByName(a)).map(SpecialItem::getPower).reduce(getMaxPower(),Double::sum);
    }
    public double getPowerDamagedAfterMarch(){
        return inventory.getEquipment().values().stream().map(a->(SpecialItem)ItemManager.getRegisteredItemByName(a)).map(SpecialItem::getPowerDamage).reduce(getPowerDamage(),Double::sum);
    }
    public double getPowerDefenseAfterMarch(){
        return inventory.getEquipment().values().stream().map(a->(SpecialItem)ItemManager.getRegisteredItemByName(a)).map(SpecialItem::getPowerDefense).reduce(getPowerDefense(),Double::sum);
    }

    public void updateMob(){
        //检查数据是否安全
        if (level < 0 ){
            level = 0;
        }
        if (exp < 0){
            exp = 0;
        }
        if (maxExp < 0){
            maxExp = 0;
        }
        if (health < 0){
            health = 0;
        }
        if (maxHealth < 0){
            maxHealth = 0;
        }
        if (power < 0){
            power = 0;
        }
        if (maxPower < 0){
            maxPower = 0;
        }
        if (damage < 0){
            damage = 0;
        }
        if (defense < 0){
            defense = 0;
        }
        if (powerDamage < 0){
            powerDamage = 0;
        }
        if (powerDefense < 0){
            powerDefense = 0;
        }
    }

    /**
     * 升级检查
     * @return 升级了多少
     */
    public int levelUp() throws ScriptException, IOException {
        //升级了多少级
        int levels = 0;
        while (true) {
            //升级操作
            if (maxExp == -1){
                break;
            }
            if (exp >= maxExp) {
                exp = exp - maxExp;
                maxExp = SystemScriptEngine.evalLevel(this);
                level++;
                levels++;
            } else {
                break;
            }
        }
        return levels;
    }
}
