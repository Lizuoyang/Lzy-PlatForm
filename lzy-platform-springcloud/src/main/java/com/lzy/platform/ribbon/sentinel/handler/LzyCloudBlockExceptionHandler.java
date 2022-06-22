package com.lzy.platform.ribbon.sentinel.handler;

import com.alibaba.csp.sentinel.adapter.spring.webmvc.callback.BlockExceptionHandler;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lzy.platform.base.result.Result;
import com.lzy.platform.base.enums.ResultCodeEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName LzyCloudBlockExceptionHandler
 * @Description Sentinel 自定义异常处理器
 * @Author LiZuoYang
 * @Date 2022/6/15 11:26
 **/
@Slf4j
@Component
public class LzyCloudBlockExceptionHandler implements BlockExceptionHandler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, BlockException exception) throws Exception {
        response.setStatus(ResultCodeEnum.SYSTEM_BUSY.getCode());
        response.setContentType("application/json;charset=utf-8");
        Result result = Result.error(ResultCodeEnum.SYSTEM_BUSY, ResultCodeEnum.SYSTEM_BUSY.getMsg());
        new ObjectMapper().writeValue(response.getWriter(), result);
    }
}
