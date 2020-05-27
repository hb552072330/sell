package com.study.sell.utils;

import com.study.sell.vo.ResultVO;

/**
 * @Author: zhanghongbing
 * @Description:
 * @Date: Create in 18:15 2020/5/17
 * @Modified By:
 */
public class ResultVOUtils {

    public static ResultVO success(Object o) {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(0);
        resultVO.setMessage("成功");
        resultVO.setData(o);
        return resultVO;
    }
}
