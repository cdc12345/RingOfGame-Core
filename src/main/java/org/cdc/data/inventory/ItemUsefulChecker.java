package org.cdc.data.inventory;

import org.cdc.data.mob.AggressiveMob;

/**
 * @author cdc123
 * @Classname org.cdc.data.inventory.ItemUsefulChecker
 * @Description 物品可用性检查
 * @date 2022/4/3 17:01
 */
public interface ItemUsefulChecker {
    /**
     * 可用性检查
     * @param mob 生物
     * @return 可用性
     */
    boolean check(AggressiveMob mob);
}
