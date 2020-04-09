package com.etutor.service.impl.user;

import com.etutor.dao.UserInfoDAO;
import com.etutor.model.UserInfoDO;
import com.etutor.model.service.UserInfoService;
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
