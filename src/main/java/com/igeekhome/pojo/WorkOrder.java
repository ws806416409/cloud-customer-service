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
 * 工作订单
 * </p>
 *
 * @author ${author}
 * @since 2021-03-16
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class WorkOrder implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("workType")
    private String worktype;

    private String title;

    @TableField("orderDesc")
    private String orderdesc;

    private String attachments;

    private String cclist;

    private String priority;

    private String state;

    @TableField("customerServiceGroupId")
    private Integer customerservicegroupid;

    @TableField("customerServiceId")
    private Integer customerserviceid;

    @TableField("customerId")
    private Integer customerid;

    private String channel;

    @TableField("updateTime")
    private LocalDateTime updatetime;

    @TableField("createTime")
    private LocalDateTime createtime;


}
