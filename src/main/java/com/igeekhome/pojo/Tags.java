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
 * 标签
 * </p>
 *
 * @author ${author}
 * @since 2021-03-16
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Tags implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableField("tagName")
    private String tagname;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("tagType")
    private String tagtype;

    private String color;

    @TableField("useCount")
    private Integer usecount;

    @TableField("createTime")
    private LocalDateTime createtime;


}
