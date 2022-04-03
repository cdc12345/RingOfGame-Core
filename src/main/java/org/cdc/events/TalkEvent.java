package org.cdc.events;

/**
 * @author cdc123
 * @Classname org.cdc.events.TalkedEvent
 * @Description 对话事件
 * @date 2022/3/31 12:31
 */
public class TalkEvent extends Event{
    public TalkEvent(String speaker, String listener, String message) {
        this.speaker = speaker;
        this.listener = listener;
        this.message = message;
    }

    /**
     * 说话者
     */
    protected String speaker;
    /**
     * 聆听者
     */
    protected String listener;
    /**
     * 消息
     */
    protected String message;
}
