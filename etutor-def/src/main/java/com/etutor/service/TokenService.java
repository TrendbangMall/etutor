package com.etutor.service;

import com.etutor.model.entity.TokenDO;

/**
 * @author winter
 */
public interface TokenService {

    boolean addToken(TokenDO tokenDO);

    boolean updateToken(TokenDO tokenDO);

    boolean disableToken(TokenDO tokenDO);

    TokenDO getToken(String token);

    boolean checkToken(String token);

    boolean logout(String token);



}
