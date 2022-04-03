package org.cdc.data.inventory;

import lombok.Data;

/**
 * 物品类
 * @author cdc123
 */
@Data
public class Item {
    private static long existItemId = -1;

    /**
     * 分配物品唯一id
     * 如果想要获得当前分配到娜了请看{@link Item#getExistItemId()}
     * @return 分配的id
     */
    public static long createItemId(){
        return ++existItemId;
    }

    /**
     * 获取当前分配的物品id
     * @return 如果没有分配则返回-1
     */
    public static long getExistItemId(){
        return existItemId;
    }
    public Item(){
        this("");
    }
    public Item(String itemName){
        this(itemName,createItemId());
    }
    public Item(String itemName,long itemId){
        this(itemName,itemId,a->true);
    }
    public Item(String itemName, long itemId, ItemAvailableChecker available){
        this.itemName = itemName;
        this.itemId = itemId;
        this.available = available;
    }
    /**
     * 物品名称
     */
    protected String itemName;
    /**
     * 物品唯一id
     */
    protected long itemId;
    /**
     * 可用性检查
     */
    protected ItemAvailableChecker available;
    public boolean isAvailable() {
        return available.checkItem(this);
    }
}
