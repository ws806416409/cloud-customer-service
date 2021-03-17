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
 * 客服表
 * </p>
 *
 * @author ${author}
 * @since 2021-03-16
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class CustomerService implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 密码
     */
    private String password;

    /**
     * 状态
     */
    private String state;

    /**
     * 头像
     */
    @TableField("headImg")
    private String headimg;

    private String email;

    /**
     * 头像
     */
    @TableField("nickName")
    private String nickname;

    /**
     * 头像
     */
    @TableField("realName")
    private String realname;

    /**
     * 头像
     */
    @TableField("customerServicePhone")
    private String customerservicephone;

    @TableId(value = "customerServiceId", type = IdType.AUTO)
    private Integer customerserviceid;

    /**
     * 总
     */
    @TableField("totalOnlineTime")
    private Integer totalonlinetime;

    /**
     * 开始时间
     */
    @TableField("onlineTimeBegin")
    private LocalDateTime onlinetimebegin;

    /**
     * 结束时间
     */
    @TableField("onlineTimeEnd")
    private LocalDateTime onlinetimeend;

    /**
     * 会话次数
     */
    @TableField("sessionCount")
    private Integer sessioncount;

    /**
     * 信息次数
     */
    @TableField("msgCount")
    private Integer msgcount;

    /**
     * 服务组
     */
    @TableField("serviceGroup")
    private String servicegroup;

    /**
     * 服务角色
     */
    @TableField("serviceRole")
    private String servicerole;


}
