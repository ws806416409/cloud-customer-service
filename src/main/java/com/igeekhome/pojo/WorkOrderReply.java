package com.igeekhome.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 工作订单回复
 * </p>
 *
 * @author ${author}
 * @since 2021-03-16
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class WorkOrderReply implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "workOrderId", type = IdType.AUTO)
    private Integer workorderid;

    @TableField("customerServiceId")
    private Integer customerserviceid;

    @TableField("replyTime")
    private LocalDateTime replytime;

    private String content;


}
