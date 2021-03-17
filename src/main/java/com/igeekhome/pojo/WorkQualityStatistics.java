package com.igeekhome.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 工作质量统计
 * </p>
 *
 * @author ${author}
 * @since 2021-03-16
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class WorkQualityStatistics implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("nickName")
    private String nickname;

    @TableField("effectiveSessionCount")
    private Integer effectivesessioncount;

    private Integer resolved;

    private Integer unsolved;

    @TableField("goodReview")
    private Integer goodreview;

    @TableField("mediumReview")
    private Integer mediumreview;

    @TableField("badReview")
    private Integer badreview;

    @TableField("noReview")
    private Integer noreview;


}
