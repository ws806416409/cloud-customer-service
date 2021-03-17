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
 * 角色管理
 * </p>
 *
 * @author ${author}
 * @since 2021-03-16
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class RoleManage implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "roleId", type = IdType.AUTO)
    private Integer roleid;

    @TableField("roleName")
    private String rolename;

    @TableField("roleCount")
    private Integer rolecount;

    @TableField("createTime")
    private LocalDateTime createtime;

    @TableField("roleDesc")
    private String roledesc;

    private String power;


}
