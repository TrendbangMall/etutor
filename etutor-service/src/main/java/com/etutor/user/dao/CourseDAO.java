package com.etutor.user.dao;


import com.etutor.model.entity.CourseDO;
import net.paoding.rose.jade.annotation.DAO;
import net.paoding.rose.jade.annotation.SQL;

/**
 * 
 *
 * @author winter
 * @since 1.0 2020-04-28
 */
@DAO
public interface CourseDAO {

    String TABLE_NAME = " course ";

    String ALL_COLUMNS = " id,  type,  name,  number,  price,  brief_info,  video_duration,  main_picture_id,  start_date,  end_date,  course_number,  course_address,  business_id,  add_time,  update_time ";

    @SQL("insert into " + TABLE_NAME + "(" + ALL_COLUMNS + ") " +
            " VALUES(:1.id, :1.type, :1.name, :1.number, :1.price, :1.briefInfo, :1.videoDuration, :1.mainPictureId, :1.startDate, :1.endDate, :1.courseNumber, :1.courseAddress, :1.businessId,  now() ,  now()   )")
    int insertCourseDO(CourseDO courseDO);

    @SQL("update " + TABLE_NAME + " set type=:1.type, name=:1.name, number=:1.number, price=:1.price, brief_info=:1.briefInfo, video_duration=:1.videoDuration, main_picture_id=:1.mainPictureId, start_date=:1.startDate, end_date=:1.endDate, course_number=:1.courseNumber, course_address=:1.courseAddress, business_id=:1.businessId, update_time= now() " +
            " where id = :1.id")
    int updateCourse(CourseDO courseDO);

    @SQL("select " + ALL_COLUMNS + " from " + TABLE_NAME + " where id = :1")
    CourseDO getCourseDOById(long id);
}