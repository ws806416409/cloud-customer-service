package com.igeekhome.biz.impl;

import com.igeekhome.pojo.Tags;
import com.igeekhome.dao.TagsMapper;
import com.igeekhome.biz.ITagsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 标签 服务实现类
 * </p>
 *
 * @author ${author}
 * @since 2021-03-16
 */
@Service
public class TagsServiceImpl extends ServiceImpl<TagsMapper, Tags> implements ITagsService {

}
