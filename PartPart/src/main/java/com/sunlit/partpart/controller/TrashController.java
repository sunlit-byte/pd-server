package com.sunlit.partpart.controller;

import com.sunlit.partpart.base.BaseResp;
import com.sunlit.partpart.mapper.TrashMapper;
import com.sunlit.partpart.service.TrashService;
import com.sunlit.partpart.utils.StringUtils;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Sunlit
 * @description
 * @date 2023-04-06 13:52
 **/
@RestController
@RequestMapping("/trash")
@AllArgsConstructor
public class TrashController {

    private final TrashService trashService;


    @RequestMapping("/list")
    public BaseResp getList(@RequestParam(required = false,defaultValue = "") String classId){

        if(StringUtils.isBlank(classId)){
            return BaseResp.fail();
        }
        List<String> res = trashService.getList(classId);
        return BaseResp.ok(res);
    }

}
