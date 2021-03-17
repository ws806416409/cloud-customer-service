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
 * 会话表
 * </p>
 *
 * @author ${author}
 * @since 2021-03-16
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Session implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "sessionId", type = IdType.AUTO)
    private Integer sessionid;

    @TableField("customerServiceId")
    private Integer customerserviceid;

    @TableField("visitorIp")
    private String visitorip;

    @TableField("visiterName")
    private String visitername;

    @TableField("createTime")
    private LocalDateTime createtime;

    @TableField("finishTime")
    private LocalDateTime finishtime;

    private String channel;

    @TableField("evaluationTime")
    private LocalDateTime evaluationtime;

    private String evaluation;

    @TableField("evaluationDetail")
    private String evaluationdetail;

    @TableField("firstResponeTime")
    private LocalDateTime firstresponetime;

    @TableField("customerMsgNum")
    private Integer customermsgnum;

    @TableField("customerServiceMsgNum")
    private Integer customerservicemsgnum;

    private Boolean active;


}
