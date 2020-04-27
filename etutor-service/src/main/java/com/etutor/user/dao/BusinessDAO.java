package com.etutor.user.dao;

import com.etutor.model.entity.BusinessDO;
import net.paoding.rose.jade.annotation.DAO;
import net.paoding.rose.jade.annotation.SQL;

/**
 * 
 *
 * @author winter
 * @since 1.0 2020-04-28
 */
@DAO
public interface BusinessDAO {

    String TABLE_NAME = " business ";

    String ALL_COLUMNS = " id,  name,  phone,  province,  city,  region,  address_full,  is_auth,  business_score,  lon,  lat,  business_logo,  add_time,  update_time ";

    @SQL("insert into " + TABLE_NAME + "(" + ALL_COLUMNS + ") " +
            " VALUES(:1.id, :1.name, :1.phone, :1.province, :1.city, :1.region, :1.addressFull, :1.isAuth, :1.businessScore, :1.lon, :1.lat, :1.businessLogo,  now() ,  now()   )")
    int insertBusinessDO(BusinessDO businessDO);

    @SQL("update " + TABLE_NAME + " set name=:1.name, phone=:1.phone, province=:1.province, city=:1.city, region=:1.region, address_full=:1.addressFull, is_auth=:1.isAuth, business_score=:1.businessScore, lon=:1.lon, lat=:1.lat, business_logo=:1.businessLogo, update_time= now() " +
            " where id = :1.id")
    int updateBusiness(BusinessDO businessDO);

    @SQL("select " + ALL_COLUMNS + " from " + TABLE_NAME + " where id = :1")
    BusinessDO getBusinessDOById(long id);
}