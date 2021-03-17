package com.igeekhome.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 客户信息
 * </p>
 *
 * @author ${author}
 * @since 2021-03-16
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class CustomerInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 状态
     */
    private String state;

    /**
     * 客户名
     */
    @TableField("customerName")
    private String customername;

    /**
     * 真实姓名
     */
    @TableField("realName")
    private String realname;

    /**
     * 电话
     */
    private String phone;

    /**
     * email
     */
    private String email;

    /**
     * 公司
     */
    private String company;

    /**
     * 地址
     */
    private String address;

    /**
     * 级别
     */
    private String level;

    /**
     * 途径
     */
    private String channel;

    /**
     * 标签id
     */
    @TableField("tagsId")
    private Integer tagsid;

    /**
     * 标注
     */
    private String remark;

    /**
     * 客服id
     */
    @TableField("customerServiceId")
    private Integer customerserviceid;

    /**
     * 最后登录时间
     */
    @TableField("lastedLoginTime")
    private LocalDateTime lastedlogintime;

    /**
     * 创建时间
     */
    @TableField("createTime")
    private LocalDateTime createtime;

    /**
     * 更新时间
     */
    @TableField("updateTime")
    private LocalDateTime updatetime;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;


}
