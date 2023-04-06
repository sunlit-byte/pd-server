package com.sunlit.partpart.service.impl;

import com.sunlit.partpart.domain.ImageEntity;
import com.sunlit.partpart.mapper.ImageMapper;
import com.sunlit.partpart.service.ImageService;
import com.sunlit.partpart.utils.Base64Util;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Paths;

/**
 * @author Sunlit
 * @description
 * @date 2023-04-07 0:55
 **/
@Service
@AllArgsConstructor
public class ImageServiceImpl implements ImageService {

    private final ImageMapper imageMapper;

//    private static final String IMAGE_DIR = "/home/ubuntu/partpart/image/"; //服务器图片保存路径
    private static final String IMAGE_DIR = "C:\\Users\\sunlit\\Desktop\\image"; //测试环境

    private static final String IMAGE_EXT = ".jpg";


    // 将字节数组保存为图片文件
    private String saveImageToFile(byte[] imageData, String imageName) throws IOException {
        String imagePath = Paths.get(IMAGE_DIR, imageName + IMAGE_EXT).toString();
        try (FileOutputStream fos = new FileOutputStream(new File(imagePath))) {
            fos.write(imageData);
        }
        return imagePath; // 返回图片文件的完整路径
    }

    /**
     * @param uuid
     * @param image
     * @description: 保存图片
     * @author: Sunlit
     * @date: 2023/4/7 1:33
     * @param: uuid
     * @param: image void
     */
    @Override
    public void saveImage(String uuid, String image) throws IOException {
        //现在得到的图片是一个base64编码，需要解码成byte[] 然后保存
        byte[] bytes = Base64Util.decode(image);
        String imagePath = saveImageToFile(bytes,uuid);
        ImageEntity entity = new ImageEntity();
        entity.setImageId(uuid);
        entity.setImage(imagePath);
        imageMapper.insert(entity);
    }
}
