package com.mezjh.kcaforum.common.utils.image;

import com.UpYun;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author zjh
 * @date 2020/3/24
 */
@Component
public class ImageUtil {

    @Autowired
    private UpYun upYun;

    public static boolean upImage(){
        return true;
    }
}
