package org.cdc.data.mob;

import org.cdc.events.CombatEvent;
import org.cdc.events.DeathEvent;
import org.cdc.events.MoveEvent;
import org.cdc.events.TalkEvent;

public interface AI {
    /**
     * 移动事件
     * @param e 事件实例
      */
    void onMoveEvent(MoveEvent e);

    /**
     * 战斗事件
     * @param e 事件源
     */
    void onCombatEvent(CombatEvent e);

    /**
     * 死亡事件
     * @param e 事件源
     */
    void onDeathEvent(DeathEvent e);

    /**
     * 对话事件
     * @param e 事件源
     */
    void onTalkEvent(TalkEvent e);

}
