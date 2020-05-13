package com.mezjh.kcaforum.common.utils.photo;

import com.UpYun;
import com.mezjh.kcaforum.common.utils.image.ImageConfig;
import com.upyun.UpYunUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author zjh
 * @date 2020/5/13
 */
@Slf4j
@Component
public class UpYunStorageImpl extends AbstractPhoto implements PhotoBaseMethod {

    @Autowired
    private ImageConfig imageConfig;

    @Override
    public String writeToStore(byte[] bytes, String pathAndFileName) throws Exception {
        String domain = imageConfig.getDomain();
        String src = imageConfig.getSrc();

        if (StringUtils.isBlank(src)) {
            src = "";
        } else {
            if (!src.startsWith("/")) {
                src = "/" + src;
            }

            if (!src.endsWith("/")) {
                src = src + "/";
            }
        }

        String key = UpYunUtils.md5(bytes);
        String path = src + key + FileType.getSuffix(pathAndFileName);
        UpYun upYun = builder();
        upYun.setContentMD5(key);
        upYun.writeFile(path, bytes, true);
        return domain.trim() + path;
    }

    @Override
    public void deleteFile(String storePath) {
        String domain = imageConfig.getDomain();
        String path = StringUtils.remove(storePath, domain.trim());
        UpYun yun = builder();
        try {
            yun.deleteFile(path);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }

    private UpYun builder() {
        String bucket = imageConfig.getServerName();
        String operator = imageConfig.getUsername();
        String password = imageConfig.getPassword();

        UpYun yun = new UpYun(bucket, operator, password);
        yun.setTimeout(60);
        yun.setApiDomain(UpYun.ED_AUTO);
        yun.setDebug(true);
        return yun;
    }
}
