package com.etutor.user.service.impl;

import com.etutor.model.entity.TokenDO;
import com.etutor.service.TokenService;
import com.etutor.user.dao.TokenDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TokenServiceImpl implements TokenService {

    @Autowired
    private TokenDAO tokenDAO;

    @Override
    public boolean updateToken(TokenDO tokenDO) {
        return tokenDAO.updateToken(tokenDO) > 0;
    }

    @Override
    public boolean disableToken(TokenDO tokenDO) {
        return tokenDAO.disableToken(tokenDO) > 0;
    }

    @Override
    public TokenDO getToken(String token) {
        return tokenDAO.getTokenByToken(token);
    }

    @Override
    public boolean checkToken(String token) {
        // 验证是否是最新的token
        TokenDO tokenDO = tokenDAO.getTokenByToken(token);
        return tokenDO != null && !tokenDO.getExprTime().before(new Date());
    }

    @Override
    public boolean logout(String token) {
        return tokenDAO.logout(token) > 0;
    }

    @Override
    public boolean addToken(TokenDO tokenDO) {
        return tokenDAO.insertToken(tokenDO) > 0;
    }


}
