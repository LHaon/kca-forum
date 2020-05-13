package com.mezjh.kcaforum.common.utils.photo;

import com.mezjh.kcaforum.common.utils.exception.KcaException;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author zjh
 * @date 2020/5/13
 */
public abstract class AbstractPhoto implements PhotoBaseMethod {
    protected void validateFile(MultipartFile file) {
        if (file == null || file.isEmpty()) {
            throw new KcaException("文件不能为空");
        }

        if (!FileType.checkFileType(file.getOriginalFilename())) {
            throw new KcaException("文件格式不支持");
        }
    }

    @Override
    public String store(MultipartFile file, String basePath) throws Exception {
        validateFile(file);
        return writeToStore(file.getBytes(), basePath, file.getOriginalFilename());
    }

    @Override
    public String storeScale(MultipartFile file, String basePath, int maxWidth) throws Exception {
        validateFile(file);
        byte[] bytes = ImageUtils.scaleByWidth(file, maxWidth);
        return writeToStore(bytes, basePath, file.getOriginalFilename());
    }

    @Override
    public String storeScale(MultipartFile file, String basePath, int width, int height) throws Exception {
        validateFile(file);
        byte[] bytes = ImageUtils.screenshot(file, width, height);
        return writeToStore(bytes, basePath, file.getOriginalFilename());
    }

    public String writeToStore(byte[] bytes, String src, String originalFilename) throws Exception {
        String path = FilePathUtils.wholePathName(src, originalFilename);
        return writeToStore(bytes, path);
    }
}
