package com.igeekhome.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 考勤表
 * </p>
 *
 * @author ${author}
 * @since 2021-03-16
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class AttendanceStatistics implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 用户名
     */
    @TableField("nickName")
    private String nickname;

    @TableField("loginTime")
    private Integer logintime;

    @TableField("freeTime")
    private Integer freetime;

    @TableField("busyTime")
    private Integer busytime;

    @TableField("onlineTime")
    private Integer onlinetime;

    @TableField("offlineTime")
    private Integer offlinetime;


}
