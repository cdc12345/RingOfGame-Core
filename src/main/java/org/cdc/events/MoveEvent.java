package org.cdc.events;

/**
 * @Classname MoveEvent
 * @Description 移动事件
 * @date 2022/3/30 12:31
 * @author cdc123
 */
public class MoveEvent extends Event {
    public MoveEvent(String mover, String from, String destination) {
        this.mover = mover;
        this.from = from;
        this.destination = destination;
    }
    /**
     * 移动者
     */
    protected String mover;
    /**
     * 起点
     */
    protected String from;
    /**
     * 终点
     */
    protected String destination;
}
