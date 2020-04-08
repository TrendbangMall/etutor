package com.winter.etutor.dao.user;

import com.winter.etutor.bean.user.entity.UserInfoDO;
import net.paoding.rose.jade.annotation.DAO;
import net.paoding.rose.jade.annotation.ReturnGeneratedKeys;
import net.paoding.rose.jade.annotation.SQL;

import java.util.List;

/**
 * 用户表
 *
 * @author winter
 * @since 1.0 2020-04-08
 */
@DAO
public interface UserInfoDAO {

    String TABLE_NAME = " user_info ";

    String SELECT_COLUMNS = "   name,  nickname,  sex,  age,  add_time,  update_time,  icon,  breaking_value ";

    String ALL_COLUMNS = " id, " + SELECT_COLUMNS;

    String JOIN_COLUMNS = " ui.id,  ui.name,  ui.nickname,  ui.sex,  ui.age,  ui.add_time,  ui.update_time,  ui.icon,  ui.breaking_value ";

    @ReturnGeneratedKeys
    @SQL("insert into " + TABLE_NAME + "(" + SELECT_COLUMNS + ") " +
            " VALUES(:1.name, :1.nickname, :1.sex, :1.age,  now() ,  now() , :1.icon, :1.breakingValue )")
    long insertUserInfoDO(UserInfoDO userInfoDO);

    @SQL("update " + TABLE_NAME + " set name=:1.name, nickname=:1.nickname, sex=:1.sex, age=:1.age, update_time= now() , icon=:1.icon, breaking_value=:1.breakingValue" +
            " where id = :1.id")
    int updateUserInfo(UserInfoDO userInfoDO);

    @SQL("select " + ALL_COLUMNS + " from " + TABLE_NAME + " where id = :1")
    UserInfoDO getUserInfoDOById(long id);

    @SQL("select " + ALL_COLUMNS + " from " + TABLE_NAME + " where id in (:1)")
    List<UserInfoDO> getUserInfoDOListByIds(List<Long> ids);
}