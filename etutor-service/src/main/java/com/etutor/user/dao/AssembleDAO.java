package com.etutor.user.dao;

import com.etutor.model.entity.AssembleDO;
import net.paoding.rose.jade.annotation.DAO;
import net.paoding.rose.jade.annotation.SQL;

/**
 * 
 *
 * @author winter
 * @since 1.0 2020-04-28
 */
@DAO
public interface AssembleDAO {

    String TABLE_NAME = " assemble ";

    String ALL_COLUMNS = " id,  type,  relation_id,  start_time,  end_time,  remark,  number,  owner_id,  status,  cancel_time,  add_time,  update_time ";

    @SQL("insert into " + TABLE_NAME + "(" + ALL_COLUMNS + ") " +
            " VALUES(:1.id, :1.type, :1.relationId, :1.startTime, :1.endTime, :1.remark, :1.number, :1.ownerId, :1.status, :1.cancelTime,  now() ,  now()   )")
    int insertAssembleDO(AssembleDO assembleDO);

    @SQL("update " + TABLE_NAME + " set type=:1.type, relation_id=:1.relationId, start_time=:1.startTime, end_time=:1.endTime, remark=:1.remark, number=:1.number, owner_id=:1.ownerId, status=:1.status, cancel_time=:1.cancelTime, update_time= now() " +
            " where id = :1.id")
    int updateAssemble(AssembleDO assembleDO);

    @SQL("select " + ALL_COLUMNS + " from " + TABLE_NAME + " where id = :1")
    AssembleDO getAssembleDOById(long id);
}