package com.etutor.user.dao;


import com.etutor.model.entity.CourseDetailDO;
import net.paoding.rose.jade.annotation.DAO;
import net.paoding.rose.jade.annotation.SQL;

/**
 * 
 *
 * @author winter
 * @since 1.0 2020-04-28
 */
@DAO
public interface CourseDetailDAO {

    String TABLE_NAME = " course_detail ";

    String ALL_COLUMNS = " id,  course_id,  start_time,  end_time,  teacher,  course_address,  price,  assemble_price,  add_time,  update_time ";

    @SQL("insert into " + TABLE_NAME + "(" + ALL_COLUMNS + ") " +
            " VALUES(:1.id, :1.courseId, :1.startTime, :1.endTime, :1.teacher, :1.courseAddress, :1.price, :1.assemblePrice,  now() ,  now()   )")
    int insertCourseDetailDO(CourseDetailDO courseDetailDO);

    @SQL("update " + TABLE_NAME + " set course_id=:1.courseId, start_time=:1.startTime, end_time=:1.endTime, teacher=:1.teacher, course_address=:1.courseAddress, price=:1.price, assemble_price=:1.assemblePrice, update_time= now() " +
            " where id = :1.id")
    int updateCourseDetail(CourseDetailDO courseDetailDO);

    @SQL("select " + ALL_COLUMNS + " from " + TABLE_NAME + " where id = :1")
    CourseDetailDO getCourseDetailDOById(long id);
}