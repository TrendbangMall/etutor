package com.etutor.wx.dao;

import com.etutor.model.entity.wx.WeixinUserDO;
import net.paoding.rose.jade.annotation.DAO;
import net.paoding.rose.jade.annotation.ReturnGeneratedKeys;
import net.paoding.rose.jade.annotation.SQL;

@DAO
public interface WeixinUserDAO {

    String TABLE_NAME = " weixin_user ";

    String ALL_COLUMNS = " id,  user_id,  subscribe, subscribe_time, open_id, union_id,  nick_name,  mobile, gender, " +
            "country,  province, city, language, avatar_url,  session_key,  weixin_gh_id, add_time, update_time ";

    String INSERT_COLUMNS = " user_id,  subscribe, subscribe_time, open_id, union_id,  nick_name,  mobile, gender, " +
            "country,  province, city, language, avatar_url,  session_key,  weixin_gh_id, add_time, update_time ";

    /**
     * 通过主键获取用户姓名
     */
    @SQL(" select nick_name from " + TABLE_NAME + " where id = :1 ")
    String getNameById(long id);

    /**
     * 通过手机号获取用户信息
     */
    @SQL(" select " + ALL_COLUMNS + " from " + TABLE_NAME + " where mobile = :1 ")
    WeixinUserDO getUserByPhone(String phone);

    /**
     * 通过sessionKey获取用户信息
     */
    @SQL(" select " + ALL_COLUMNS + " from " + TABLE_NAME + " where session_key = :1 ")
    WeixinUserDO getUserBySessionKey(String sessionKey);

    /**
     * 通过openId获取用户信息
     */
    @SQL(" select " + ALL_COLUMNS + " from " + TABLE_NAME + " where open_id = :1 ")
    WeixinUserDO getUserByOpenId(String openId);

    /**
     * 通过openId获取用户信息
     */
    @SQL(" select " + ALL_COLUMNS + " from " + TABLE_NAME + " where user_id = :1 ")
    WeixinUserDO getUserByUserId(long userId);


    /**
     * 添加用户
     */
    @ReturnGeneratedKeys
    @SQL("insert into " + TABLE_NAME + " ( " + INSERT_COLUMNS + " ) values ( :1.userId, :1.subscribe, :1.subscribeTime, " +
            " :1.openId, :1.unionId, :1.nickName, :1.mobile, :1.gender, :1.country, :1.province, :1.city, :1.language,"  +
            " :1.avatarUrl,  :1.sessionKey, :1.weixinGhId, :1.addTime, :1.updateTime )")
    Long addUser(WeixinUserDO userDO);

    /**
     * 更新用户
     */
    @SQL(" update " + TABLE_NAME + " set update_time = now() " +
            "#if(:1.userId != null and :1.userId != -1){,user_id = :1.userId} " +
            "#if(:1.subscribe != null and :1.subscribe != '0'){,subscribe = :1.subscribe} " +
            "#if(:1.subscribeTime != null and :1.subscribeTime != 0){,subscribe_time = :1.subscribeTime} " +
            "#if(:1.openId != null and :1.openId != ''){,open_id = :1.openId} " +
            "#if(:1.unionId != null and :1.unionId != ''){,union_id = :1.unionId} " +
            "#if(:1.nickName != null and :1.nickName != ''){,nick_name = :1.nickName} " +
            "#if(:1.mobile != null and :1.mobile != ''){,mobile = :1.mobile} " +
            "#if(:1.gender != null and :1.gender != '0'){,gender = :1.gender} " +
            "#if(:1.country != null and :1.country != ''){,country = :1.country} " +
            "#if(:1.province != null and :1.province != ''){,province = :1.province} " +
            "#if(:1.city != null and :1.city != ''){,city = :1.city} " +
            "#if(:1.language != null and :1.language != ''){,language = :1.language} " +
            "#if(:1.avatarUrl != null and :1.avatarUrl != ''){,avatar_url = :1.avatarUrl} " +
            "#if(:1.sessionKey != null and :1.sessionKey != ''){,session_key = :1.sessionKey} " +
            "#if(:1.weixinGhId != null and :1.weixinGhId != ''){,weixin_gh_id = :1.weixinGhId} " +
            " where id = :1.id ")
    int updateUser(WeixinUserDO userDO);
}
