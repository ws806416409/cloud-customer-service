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
 * 会话管理
 * </p>
 *
 * @author ${author}
 * @since 2021-03-16
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class SessionMessage implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("customerServiceId")
    private Integer customerserviceid;

    @TableField("visitorIp")
    private String visitorip;

    @TableField("fromVisitor")
    private Boolean fromvisitor;

    @TableField("sendTime")
    private LocalDateTime sendtime;

    private String content;

    @TableField("sessionId")
    private Integer sessionid;


}
