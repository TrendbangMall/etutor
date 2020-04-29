package com.etutor.user.service.impl;

import com.etutor.model.dto.UserDTO;
import com.etutor.model.entity.TokenDO;
import com.etutor.model.entity.UserInfoDO;
import com.etutor.model.entity.wx.WeixinUserDO;
import com.etutor.model.vo.UserInfoVO;
import com.etutor.service.TokenService;
import com.etutor.service.UserInfoService;
import com.etutor.service.WxUserService;
import com.etutor.user.dao.UserInfoDAO;
import com.etutor.utils.DozerUtils;
import com.etutor.utils.JWTUtil;
import com.github.dozermapper.core.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service("userInfoService")
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoDAO userInfoDAO;

    @Autowired
    private Mapper mapper;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private WxUserService wxUserService;

    @Override
    public long insertUser(UserInfoDO userInfoDO) {
        return userInfoDAO.insertUserInfoDO(userInfoDO);
    }

    @Override
    public String registerByPhone(UserDTO userDTO) {
        // 短信校验
//        if (!checkSmsCode(userDTO.getCode(), userDTO.getPhone())) {
//            throw new BusinessException(12, "验证码错误");
//        }
        UserInfoDO checkDO = userInfoDAO.getUserByPhone(userDTO.getPhone());
        if (checkDO == null) {
            UserInfoDO userDO = DozerUtils.map(mapper, userDTO, UserInfoDO.class);
            userDO.setPhone(userDTO.getPhone());
            long userId = userInfoDAO.insertUserInfoDO(userDO);
            return createToken(userId);
        } else {
            return createToken(checkDO.getId());
        }
    }

    @Override
    public String loginByPhone(UserDTO userDTO) {
        String code = userDTO.getCode();
        String phone = userDTO.getPhone();
        // 手机号格式校验
        /*if(!FrameStringUtils.checkPhoneNumber(phone)){
            throw new BusinessException(11, "手机号格式不正确");
        }*/
        // 短信校验
//        if (!checkSmsCode(code, phone)) {
//            throw new BusinessException(12, "验证码错误");
//        }
        UserInfoDO checkDO = userInfoDAO.getUserByPhone(userDTO.getPhone());
        if (checkDO == null) {
            return null;
        } else {
            return createToken(checkDO.getId());
        }
    }

    @Override
    public UserInfoVO getUserInfoByToken(String token) {
        TokenDO tokenDO = tokenService.getToken(token);
        UserInfoDO userInfoDO = userInfoDAO.getUserInfoDOById(tokenDO.getUserId());
        return DozerUtils.map(mapper, userInfoDO, UserInfoVO.class);
    }

    @Override
    public String createToken(long userId) {
        UserDTO userDTO = new UserDTO();
        userDTO.setUserId(userId);
        // 登录   设置token, 保存到数据库
        String token = JWTUtil.sign(userDTO);
        TokenDO tokenDO = new TokenDO();
        tokenDO.setExprTime(new Date(System.currentTimeMillis() + JWTUtil.EXPIRE_TIME));
        tokenDO.setToken(token);
        tokenDO.setUserId(userId);
        tokenDO.setUpdateTime(new Date());
        tokenDO.setAddTime(new Date());
        boolean b = tokenService.updateToken(tokenDO);
        // 重新登录,每次都要将旧的token置为失效, 再新增一条新的数据
        tokenService.addToken(tokenDO);
        return token;
    }

    /**
     * 其他平台创建token
     */
    @Override
    public String createToken(Long teamId, Long userId, String systemCode, Integer tokenType) {
        UserDTO userDTO = new UserDTO();
        userDTO.setTeamId(teamId);
        userDTO.setCode(systemCode);
        userDTO.setSysType(tokenType);
        // 登录   设置token, 保存到数据库
        String token = JWTUtil.sign(userDTO);
        TokenDO tokenDO = new TokenDO();
        tokenDO.setExprTime(new Date(System.currentTimeMillis() + JWTUtil.EXPIRE_TIME));
        tokenDO.setToken(token);
        tokenDO.setUserId(userId);
        tokenDO.setUpdateTime(new Date());
        // add
        tokenDO.setSysType(tokenType);
        tokenDO.setAddTime(new Date());
        tokenService.disableToken(tokenDO);
        // 重新登录,每次都要将旧的token置为失效, 再新增一条新的数据
        tokenService.addToken(tokenDO);
        return token;
    }

    @Override
    public UserInfoDO getUserById(long userId) {
        return userInfoDAO.getUserById(userId);
    }

    @Override
    public UserInfoVO getUserInfoBySessionKey(String sessionKey) {

        UserInfoVO userInfo = new UserInfoVO();
        // 从token中获取 userId, teamId, staffId
        WeixinUserDO weixinUserDO = wxUserService.getWeixinUserBySession(sessionKey);
        // 根据 UserId 获取 User信息
        UserInfoDO userDO = userInfoDAO.getUserById(weixinUserDO.getUserId());
        if (userDO != null) {
            userInfo.setPhone(userDO.getPhone());
            userInfo.setName(userDO.getName());
            userInfo.setId(userDO.getId());
        }
        return userInfo;
    }

}
