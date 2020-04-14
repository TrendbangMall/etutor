package com.etutor.intercepter;

import com.etutor.annotation.LoginCheck;
import com.etutor.constant.LoginConstant;
import com.etutor.model.vo.UserInfoVO;
import com.etutor.response.ResultCode;
import com.etutor.service.TokenService;
import com.etutor.service.UserInfoService;
import com.etutor.utils.JWTUtil;
import com.etutor.utils.JsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author ：Lion
 * @date ：2020/1/7 3:46 下午
 * @description ：
 */
@Slf4j
public class LoginCheckInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private UserInfoService userService;

    @Autowired
    private TokenService tokenService;


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        // token
        String token = request.getHeader(LoginConstant.ETUTOR_TOKEN);
        // 根据注解判断是否需要校验登录状态
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        LoginCheck loginCheck = handlerMethod.getMethodAnnotation(LoginCheck.class);
        if (loginCheck == null) {
            loginCheck = handlerMethod.getMethod().getDeclaringClass().getAnnotation(LoginCheck.class);
        }
        // 包含注解, 且注解value为"unCheck", 则不需要校验登录
        if (loginCheck == null || loginCheck.value().equals(LoginConstant.IS_CHECK)) {
            log.info("checkLogin -->  ");
            if (!StringUtils.isNotBlank(token)){
                return generateErrorResponse(response, ResultCode.TOKEN_NULL);
            }
            // 登录校验
            if (!(JWTUtil.verify(token) && tokenService.checkToken(token))) {
                return generateErrorResponse(response, ResultCode.TOKEN_INVALID);
            }

            // 获取User信息, 放到UserInfo中
            UserInfoVO userInfo = userService.getUserInfoByToken(token);
            request.setAttribute(LoginConstant.ETUTOR_USER, userInfo);
        }
        return super.preHandle(request, response, handler);
    }

    private boolean generateErrorResponse(HttpServletResponse response, ResultCode errorCodeEnum) throws Exception {
        response.setCharacterEncoding("UTF-8");
        response.setHeader("Content-type", "application/json;charset=UTF-8");
        response.getWriter().write(JsonUtils.toJson(errorCodeEnum));
        return false;
    }
}
