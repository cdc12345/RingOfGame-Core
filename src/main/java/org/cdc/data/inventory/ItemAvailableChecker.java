package org.cdc.data.inventory;

/**
 * @author cdc123
 * @Classname org.cdc.data.inventory.ItemAvailableChecker
 * @Description 物品可
 * @date 2022/4/3 18:03
 * @e-mail 3154934427@qq.com
 */
public interface ItemAvailableChecker {
    /**
     * 检查物品可用性
     * @param item 被检查的物品
     * @return 可用性
     */
    boolean checkItem(Item item);
}
