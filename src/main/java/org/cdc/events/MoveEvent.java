package org.cdc.events;

/**
 * @Classname MoveEvent
 * @Description 移动事件
 * @Date 2022/3/30 12:31
 * @Created by Administrator
 */
public class MoveEvent {
    public MoveEvent(String mover, String from, String destination) {
        this.mover = mover;
        this.from = from;
        this.destination = destination;
    }

    private String watcher;
    /**
     * 移动者
     */
    private String mover;
    /**
     * 起点
     */
    private String from;
    /**
     * 终点
     */
    private String destination;
}
