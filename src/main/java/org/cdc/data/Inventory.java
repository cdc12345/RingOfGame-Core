package org.cdc.data;

import lombok.Data;
import org.cdc.data.inventory.Item;
import org.cdc.data.inventory.ItemStack;
import org.cdc.data.inventory.SpecialItem;
import org.cdc.data.mob.AggressiveMob;

import java.util.HashMap;
import java.util.Map;

/**
 * 背包数据存储类
 */
@Data
public class Inventory {
    public Inventory(AggressiveMob upperMob){
        this.upperMob = upperMob;
    }
    private AggressiveMob upperMob;
    /**
     * 根据名字映射ItemStack已有实例
     */
    protected HashMap<String,ItemStack> items = new HashMap<>();
    /**
     * 装备映射
     */
    protected HashMap<String, SpecialItem> equipment = new HashMap<>();

    /**
     * 替换物品,与{@link Inventory#addItem(String, long)}存在区别,详情请看它的注释
     * @param name 物品名称
     * @param number 数量
     * @return 返回 true
     */
    public boolean replaceItem(String name,long number){
        ItemStack stack = new ItemStack(name,number);
        items.put(name,stack);
        return !updateItems();
    }

    /**
     * 添加物品,与{@link Inventory#replaceItem(String, long)}存在差异
     * 等效于replaceItem(name,number+)
     * @param name
     * @param number
     * @return
     */
    public boolean addItem(String name,long number){
        if (items.containsKey(name)){
            ItemStack item = items.get(name);
            item.setNumber(item.getNumber()+number);
        } else {
            items.put(name,new ItemStack(name,number));
        }
        new ItemStack(name,number);
        return true;
    }

    /**
     * 减少物品,与
     * @param name 物品名称
     * @param number 减少的物品数量
     * @return 如果不存在物品则返回false 否则返回 true
     */
    public boolean removeItem(String name,long number){
        if (items.containsKey(name)){
            ItemStack item = items.get(name);
            item.setNumber(item.getNumber()-number);
            updateItems();
        } else {
            return false;
        }
        return true;
    }

    /**
     * 检查物品的可用性
     * 如果出现了物品栏的变动那么就会返回true
     */
    private boolean updateItems(){
        boolean result = false;
        for (Map.Entry<String,ItemStack> a:items.entrySet()){
            if (a.getValue().getNumber() <= 0){
                items.remove(a.getKey());
                result = true;
                continue;
            }
            if (!a.getValue().getItem().isAvailable()){
                items.remove(a.getKey());
                result = true;
            }
        }
        for (Map.Entry<String, SpecialItem> a:equipment.entrySet()){
            if (!a.getValue().isAvailable()){
                equipment.remove(a.getKey());
                result = true;
                continue;
            }
            if (!a.getValue().isUseful(upperMob)){
                addItem(a.getValue().getItemName(),1);
                equipment.remove(a.getKey());
                result = true;
            }
        }
        return result;
    }

    /**
     * 得到物品数量
     * @param name 物品名称
     * @return
     */
    public long getItemNumber(String name){
        return items.get(name).getNumber();
    }
    public boolean addEquivalence(String name,boolean fromInventory){
        if (fromInventory){
            if (!(items.containsKey(name))) {
                return false;
            }
            removeItem(name,1);
        }
        Item item = ItemStack.getItem(name);
        if (!(item instanceof SpecialItem)){
            return false;
        }
        SpecialItem specialItem = (SpecialItem) item;
        equipment.put(specialItem.getPlace(), specialItem);
        return true;
    }
}
