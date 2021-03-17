package com.igeekhome.pojo;

import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 视图统计
 * </p>
 *
 * @author ${author}
 * @since 2021-03-16
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class VisitorInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    private String ip;

    @TableField("visitorName")
    private String visitorname;

    private String terminal;

    private String browser;

    @TableField("screenSize")
    private String screensize;

    private String device;

    @TableField("customerServiceId")
    private Integer customerserviceid;

    private String state;

    @TableField("visitDuration")
    private Integer visitduration;

    @TableField("visitTime")
    private LocalDateTime visittime;


}
