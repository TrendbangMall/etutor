package com.etutor.user.dao;


import com.etutor.model.entity.CommentDO;
import net.paoding.rose.jade.annotation.DAO;
import net.paoding.rose.jade.annotation.SQL;

/**
 * 
 *
 * @author winter
 * @since 1.0 2020-04-28
 */
@DAO
public interface CommentDAO {

    String TABLE_NAME = " comment ";

    String ALL_COLUMNS = " id,  score_skills,  score_service,  score_patience,  score_price,  content,  course_detail_id,  course_comment_user_id,  course_comment_time,  file,  add_time,  update_time ";

    @SQL("insert into " + TABLE_NAME + "(" + ALL_COLUMNS + ") " +
            " VALUES(:1.id, :1.scoreSkills, :1.scoreService, :1.scorePatience, :1.scorePrice, :1.content, :1.courseDetailId, :1.courseCommentUserId, :1.courseCommentTime, :1.file,  now() ,  now()   )")
    int insertCommentDO(CommentDO commentDO);

    @SQL("update " + TABLE_NAME + " set score_skills=:1.scoreSkills, score_service=:1.scoreService, score_patience=:1.scorePatience, score_price=:1.scorePrice, content=:1.content, course_detail_id=:1.courseDetailId, course_comment_user_id=:1.courseCommentUserId, course_comment_time=:1.courseCommentTime, file=:1.file, update_time= now() " +
            " where id = :1.id")
    int updateComment(CommentDO commentDO);

    @SQL("select " + ALL_COLUMNS + " from " + TABLE_NAME + " where id = :1")
    CommentDO getCommentDOById(long id);
}