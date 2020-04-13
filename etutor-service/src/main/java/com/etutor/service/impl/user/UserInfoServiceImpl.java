package com.etutor.service.impl.user;

import com.etutor.dao.UserInfoDAO;
import com.etutor.dto.UserInfoDTO;
import com.etutor.model.entity.UserInfoDO;
import com.etutor.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userInfoService")
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoDAO userInfoDAO;

    @Override
    public long insertUser(UserInfoDO userInfoDO) {
        return userInfoDAO.insertUserInfoDO(userInfoDO);
    }

    @Override
    public UserInfoDO getUserInfoById(long id) {
        return userInfoDAO.getUserInfoDOById(id);
    }

    @Override
    public String registerByPhone(UserInfoDTO userInfoDTO) {
        return null;
    }

    @Override
    public String loginByPhone(UserInfoDTO userInfoDTO) {
        return null;
    }

}
