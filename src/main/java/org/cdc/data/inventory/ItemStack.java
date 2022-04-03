package org.cdc.data.inventory;

import com.sun.istack.internal.NotNull;
import lombok.Data;
import org.cdc.manager.ItemManager;

import java.util.HashMap;

/**
 * 物品叠类
 * @author Administrator
 */
@Data
public final class ItemStack{
    public ItemStack(String itemName,long number){
        this(itemName,number,"");
    }
    public ItemStack(String item,long number,String lore){
        this.item = item;
        this.number = number;
        this.lore = lore;
    }

    public Item getItem(){
        return ItemManager.getRegisteredItemByName(item);
    }
    /**
     * 物品实例
     */
    @NotNull
    private String item;
    /**
     * 物品数量
     */
    private long number;
    /**
     * 物品叠lore
     */
    private String lore;

}
