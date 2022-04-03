package org.cdc.events;

import lombok.Data;

/**
 * @author cdc123
 * @Classname org.cdc.events.Event
 * @Description 事件的母类
 * @date 2022/4/3 16:41
 */
@Data
public abstract class Event {
    /**
     * 事件观察者
     */
    protected String watcher;
}
