package com.etutor.dao;

import com.etutor.model.entity.TokenDO;
import net.paoding.rose.jade.annotation.DAO;
import net.paoding.rose.jade.annotation.ReturnGeneratedKeys;
import net.paoding.rose.jade.annotation.SQL;

@DAO
public interface TokenDAO {

    String TABLE_NAME = " token_record ";

    String ALL_COLUMNS = " id,  token,  user_id,  expr_time,  add_time,  update_time, status ";

    String INSERT_COLUMNS = " token,  user_id,  expr_time,  add_time,  update_time ";


    /**
     * 通过token获取
     *
     * @return
     */
    @SQL(" select " + ALL_COLUMNS + " from " + TABLE_NAME + " where token=:1 and status = 0")
    TokenDO getTokenByToken(String token);

    /**
     * 通过手机号获取
     *
     * @param phone
     * @return
     */
    @SQL(" select " + ALL_COLUMNS + " from " + TABLE_NAME + " where mobile=:1 and status = 0")
    TokenDO getTokenByMobile(String phone);

    /**
     * 通过主键获取
     *
     * @param id
     * @return
     */
    @SQL(" select " + ALL_COLUMNS + " from " + TABLE_NAME + " where id=:1 and status = 0 ")
    TokenDO getTokenById(long id);


    /**
     * 新增token
     *
     * @param tokenDO
     * @return
     */
    @ReturnGeneratedKeys
    @SQL("insert into " + TABLE_NAME + " ( " + INSERT_COLUMNS + " ) values (:1.token, :1.userId, :1.exprTime, now(), now())")
    Long insertToken(TokenDO tokenDO);

    /**
     * 更新token
     *
     * @param tokenDO
     * @return
     * 为什么登录的这里, 使用返回主键的注解会报错
     */
    @SQL(" update " + TABLE_NAME + " set status = -1, update_time = now() where user_id = :1.userId ")
    int updateToken(TokenDO tokenDO);

    @SQL(" update " + TABLE_NAME + " set team_id = :2, staff_id = :3, update_time = now() where token = :1 ")
    int updateToken(String token, long teamId, long staffId);

    @SQL(" update " + TABLE_NAME + " set status = -1, update_time = now() where token = :1")
    int logout(String token);
}
