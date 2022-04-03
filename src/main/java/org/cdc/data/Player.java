package org.cdc.data;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.cdc.data.mob.AggressiveMob;

/**
 * @author cdc1234
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class Player extends AggressiveMob {
    /**
     * 直接与qq接轨,此处填写qq
     */
    private long qq;

}
