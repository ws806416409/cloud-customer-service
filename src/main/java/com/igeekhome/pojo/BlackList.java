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
 * 恶意用户列表
 * </p>
 *
 * @author ${author}
 * @since 2021-03-16
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class BlackList implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 客服id
     */
    @TableField("customerServiceId")
    private Integer customerserviceid;

    /**
     * 客户Id
     */
    @TableField("customerId")
    private Integer customerid;

    /**
     * 理由
     */
    private String reason;

    private LocalDateTime time;

    /**
     * ip地址
     */
    private String source;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;


}
