package com.sunlit.partpart.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sunlit.partpart.domain.TrashEntity;
import com.sunlit.partpart.mapper.TrashMapper;
import com.sunlit.partpart.service.TrashService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Sunlit
 * @description
 * @date 2023-04-06 13:51
 **/
@Service
@AllArgsConstructor
public class TrashServiceImpl implements TrashService {

    private final TrashMapper trashMapper;


    /**
     * @param classId
     * @description: 根据id 获取垃圾列表
     * @author: Sunlit
     * @date: 2023/4/6 13:55
     * @param: classId List<String>
     */
    @Override
    public List<String> getList(String classId) {
        QueryWrapper<TrashEntity> wrapper = new QueryWrapper<>();
        wrapper.eq("class_id", classId);
        List<TrashEntity> trashEntities = trashMapper.selectList(wrapper);
        List<String> res = new ArrayList<>();
        for(TrashEntity entity : trashEntities){
            res.add(entity.getTrashName());
        }
        return res;
    }
}
