package com.etutor.user.dao;

import com.etutor.model.entity.BusinessAuthDO;
import net.paoding.rose.jade.annotation.DAO;
import net.paoding.rose.jade.annotation.SQL;

/**
 * 
 *
 * @author winter
 * @since 1.0 2020-04-28
 */
@DAO
public interface BusinessAuthDAO {

    String TABLE_NAME = " business_auth ";

    String ALL_COLUMNS = " id,  business_id,  auth_file,  auth_file_upload_time,  check_name,  check_opinion,  check_time,  is_approve,  add_time,  update_time ";

    @SQL("insert into " + TABLE_NAME + "(" + ALL_COLUMNS + ") " +
            " VALUES(:1.id, :1.businessId, :1.authFile, :1.authFileUploadTime, :1.checkName, :1.checkOpinion, :1.checkTime, :1.isApprove,  now() ,  now()   )")
    int insertBusinessAuthDO(BusinessAuthDO businessAuthDO);

    @SQL("update " + TABLE_NAME + " set business_id=:1.businessId, auth_file=:1.authFile, auth_file_upload_time=:1.authFileUploadTime, check_name=:1.checkName, check_opinion=:1.checkOpinion, check_time=:1.checkTime, is_approve=:1.isApprove, update_time= now() " +
            " where id = :1.id")
    int updateBusinessAuth(BusinessAuthDO businessAuthDO);

    @SQL("select " + ALL_COLUMNS + " from " + TABLE_NAME + " where id = :1")
    BusinessAuthDO getBusinessAuthDOById(long id);
}