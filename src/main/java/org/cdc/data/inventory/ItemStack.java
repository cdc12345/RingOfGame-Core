package org.cdc.data.inventory;

import com.sun.istack.internal.NotNull;
import lombok.Data;

import java.util.HashMap;

/**
 * 物品叠类
 */
@Data
public final class ItemStack implements Cloneable{
    private static HashMap<String,Item> enableItems = new HashMap<>();
    public static Item getItem(String name){
        Item item = enableItems.get(name);
        if (item == null){
            item = new Item(name);
            enableItems.put(name,item);
        }
        return item;
    }
    public static HashMap<String,Item> getEnableItems(){
        return enableItems;
    }
    public ItemStack(String itemName,long number){
        this(getItem(itemName),number);
    }
    public ItemStack(Item item,long number){
        this(item,number,"");
    }
    public ItemStack(Item item,long number,String lore){
        this.item = item;
        this.number = number;
        this.lore = lore;
    }
    /**
     * 物品实例
     */
    @NotNull
    private Item item;
    /**
     * 物品数量
     */
    private long number;
    /**
     * 物品叠lore
     */
    private String lore;

}
