package com.igeekhome.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 常见的用语
 * </p>
 *
 * @author ${author}
 * @since 2021-03-16
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class CommonWord implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 内容
     */
    private String content;

    /**
     * 所属库
     */
    private String lib;

    /**
     * 类型
     */
    private String type;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;


}
