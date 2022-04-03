package org.cdc.manager;

import org.cdc.data.inventory.Item;

import java.util.TreeMap;

/**
 * @author cdc123
 * @Classname org.cdc.manager.ItemManager
 * @Description 物品管理
 * @date 2022/4/1 12:51
 */
public class ItemManager {
    public static String getItemType(Item item){
        return item.getClass().getSimpleName();
    }

    private static final TreeMap<String,Item> REGISTERED_ITEMS = new TreeMap<>();

    public static boolean isRegistered(Item item){
        if (item.getItemId() == -1){
            return false;
        }
        return REGISTERED_ITEMS.containsKey(item.getItemName());
    }

    /**
     * 注册物品
     * @param item 物品
     * @return 成功性
     */
    public static boolean register(Item item){
        if (isRegistered(item)){
            return false;
        }
        item.setItemId(REGISTERED_ITEMS.size());
        REGISTERED_ITEMS.put(item.getItemName(), item);
        return true;
    }

    public static Item getRegisteredItemByName(String name){
        return REGISTERED_ITEMS.get(name);
    }

    public static Item getRegisteredItemById(long id){
        for (Item item : REGISTERED_ITEMS.values()){
            if (item.getItemId() == id){
                return item;
            }
        }
        return null;
    }
}
