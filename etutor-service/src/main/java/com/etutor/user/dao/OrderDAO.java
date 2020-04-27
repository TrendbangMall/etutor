package com.etutor.user.dao;


import com.etutor.model.entity.OrderDO;
import net.paoding.rose.jade.annotation.DAO;
import net.paoding.rose.jade.annotation.SQL;

/**
 * 
 *
 * @author winter
 * @since 1.0 2020-04-28
 */
@DAO
public interface OrderDAO {

    String TABLE_NAME = " order ";

    String ALL_COLUMNS = " id,  assemble_id,  course_id,  order_price,  order_time,  order_number,  order_state,  cancel_reason,  cancel_time,  group_purchase_code,  add_time,  update_time ";

    @SQL("insert into " + TABLE_NAME + "(" + ALL_COLUMNS + ") " +
            " VALUES(:1.id, :1.assembleId, :1.courseId, :1.orderPrice, :1.orderTime, :1.orderNumber, :1.orderState, :1.cancelReason, :1.cancelTime, :1.groupPurchaseCode,  now() ,  now()   )")
    int insertOrderDO(OrderDO orderDO);

    @SQL("update " + TABLE_NAME + " set assemble_id=:1.assembleId, course_id=:1.courseId, order_price=:1.orderPrice, order_time=:1.orderTime, order_number=:1.orderNumber, order_state=:1.orderState, cancel_reason=:1.cancelReason, cancel_time=:1.cancelTime, group_purchase_code=:1.groupPurchaseCode, update_time= now() " +
            " where id = :1.id")
    int updateOrder(OrderDO orderDO);

    @SQL("select " + ALL_COLUMNS + " from " + TABLE_NAME + " where id = :1")
    OrderDO getOrderDOById(long id);
}