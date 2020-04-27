package com.etutor.user.dao;

import com.etutor.model.entity.CollectDO;
import net.paoding.rose.jade.annotation.DAO;
import net.paoding.rose.jade.annotation.SQL;

/**
 * 
 *
 * @author winter
 * @since 1.0 2020-04-28
 */
@DAO
public interface CollectDAO {

    String TABLE_NAME = " collect ";

    String ALL_COLUMNS = " id,  type,  user_id,  relation_id,  add_time,  update_time ";

    @SQL("insert into " + TABLE_NAME + "(" + ALL_COLUMNS + ") " +
            " VALUES(:1.id, :1.type, :1.userId, :1.relationId,  now() ,  now()   )")
    int insertCollectDO(CollectDO collectDO);

    @SQL("update " + TABLE_NAME + " set type=:1.type, user_id=:1.userId, relation_id=:1.relationId, update_time= now() " +
            " where id = :1.id")
    int updateCollect(CollectDO collectDO);

    @SQL("select " + ALL_COLUMNS + " from " + TABLE_NAME + " where id = :1")
    CollectDO getCollectDOById(long id);
}