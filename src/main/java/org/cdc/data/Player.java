package org.cdc.data;

import lombok.Data;
import org.cdc.data.mob.AggressiveMob;

@Data
public class Player extends AggressiveMob {
    /**
     * 直接与qq接轨,此处填写qq
     */
    private long qq;

}
