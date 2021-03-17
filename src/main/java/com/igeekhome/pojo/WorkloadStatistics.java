package com.igeekhome.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 工作量统计
 * </p>
 *
 * @author ${author}
 * @since 2021-03-16
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class WorkloadStatistics implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("nickName")
    private String nickname;

    @TableField("totalMessageCount")
    private Integer totalmessagecount;

    @TableField("totalSessionCount")
    private Integer totalsessioncount;

    @TableField("totalEffectiveSessionCount")
    private Integer totaleffectivesessioncount;

    @TableField("totalEndSessionCount")
    private Integer totalendsessioncount;

    @TableField("totalSessionTime")
    private Integer totalsessiontime;


}
