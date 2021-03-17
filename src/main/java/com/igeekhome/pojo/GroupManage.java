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
 * 组管理
 * </p>
 *
 * @author ${author}
 * @since 2021-03-16
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class GroupManage implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "groupId", type = IdType.AUTO)
    private Integer groupid;

    @TableField("groupName")
    private String groupname;

    @TableField("groupNumber")
    private Integer groupnumber;

    @TableField("createTime")
    private LocalDateTime createtime;


}
