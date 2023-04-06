package com.sunlit.partpart.service;

import java.util.List;

/**
 * @author Sunlit
 * @description
 * @date 2023-04-06 13:51
 **/
public interface TrashService {

    /**
     * @description: 根据id 获取垃圾列表
     * @author: Sunlit
     * @date: 2023/4/6 13:55
     * @param: classId List<String>
     **/
    List<String> getList(String classId);
}
