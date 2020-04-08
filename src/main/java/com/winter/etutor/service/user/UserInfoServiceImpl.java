package com.winter.etutor.service.user;

import com.winter.etutor.bean.user.entity.UserInfoDO;
import com.winter.etutor.dao.user.UserInfoDAO;
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
}
