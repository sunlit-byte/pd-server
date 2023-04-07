package com.sunlit.partpart.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sunlit.partpart.domain.ImageEntity;
import com.sunlit.partpart.mapper.ImageMapper;
import com.sunlit.partpart.service.ImageService;
import com.sunlit.partpart.utils.Base64Util;
import com.sunlit.partpart.utils.StringUtils;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.*;
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

    private byte[] loadImageFromFile(String imagePath){
        File imageFile = new File(imagePath);
        try (InputStream inputStream = new FileInputStream(imageFile)) {
            // 获取图片文件的大小（字节数），用于创建字节数组
            int fileSize = (int) imageFile.length();
            byte[] imageData = new byte[fileSize];
            // 读取图片文件的字节数据到字节数组中
            int bytesRead = 0;
            int offset = 0;
            while (offset < fileSize && (bytesRead = inputStream.read(imageData, offset, fileSize - offset)) >= 0) {
                offset += bytesRead;
            }
            return imageData;
        } catch (FileNotFoundException e) {
            return null;
        } catch (IOException e) {
            System.out.println("获取图片数据错误");
            throw new RuntimeException(e);
        }

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

    /**
     * @param
     * @return
     * @description: 加载图片
     * @author: Sunlit
     * @date: 2023/4/7 15:19
     * @param: articleId void
     */
    @Override
    public String loadImage(String imageId) {
        //获取图片的地址
        QueryWrapper<ImageEntity> wrapper = new QueryWrapper<>();
        wrapper.eq("image_id",imageId);
        ImageEntity entity = imageMapper.selectOne(wrapper);
        if(entity == null || StringUtils.isBlank(entity.getImage())){
            return null;
        }
        byte[] bytes = loadImageFromFile(entity.getImage());
        if(bytes == null){
            return null;
        }
        return Base64Util.encode(bytes);
    }
}
