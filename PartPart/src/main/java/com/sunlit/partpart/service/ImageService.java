package com.sunlit.partpart.service;

import java.io.IOException;

/**
 * @author Sunlit
 * @description
 * @date 2023-04-07 0:55
 **/
public interface ImageService {

    /**
     * @description: 保存图片
     * @author: Sunlit
     * @date: 2023/4/7 1:33
     * @param: uuid
     * @param: image void
     **/
    void saveImage(String uuid, String image) throws IOException;

    /**
     * @return
     * @description: 加载图片
     * @author: Sunlit
     * @date: 2023/4/7 15:19
     * @param: articleId void
     */
    String loadImage(String imageId);
}
