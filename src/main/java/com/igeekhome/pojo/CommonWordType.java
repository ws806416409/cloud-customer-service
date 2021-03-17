package com.igeekhome.pojo;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 常见的用语—类型
 * </p>
 *
 * @author ${author}
 * @since 2021-03-16
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class CommonWordType implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 类型
     */
    private String type;

    /**
     * 类型内容
     */
    private String content;


}
