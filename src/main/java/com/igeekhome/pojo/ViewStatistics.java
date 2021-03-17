package com.igeekhome.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
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
public class ViewStatistics implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("viewType")
    private String viewtype;

    @TableField("pageView")
    private Integer pageview;

    @TableField("visitorNum")
    private Integer visitornum;

    @TableField("visitorCount")
    private Integer visitorcount;


}
