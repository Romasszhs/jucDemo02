package com.hang.threadwaitnotify;

import com.hang.threadwaitnotify.Nent.Fu;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @author: hangshuo
 * @date: 2021/04/18 12:53
 * @Description:
 */

@Data
@Getter
@Setter

public class Zi extends Fu {
    String name;

    public Zi(String name) {
        this.name = name;
    }

    public Zi(int id, String name) {
        super(id);
        this.name = name;
    }


}
