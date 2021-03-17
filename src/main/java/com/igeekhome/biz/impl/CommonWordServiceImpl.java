package com.igeekhome.biz.impl;

import com.igeekhome.pojo.CommonWord;
import com.igeekhome.dao.CommonWordMapper;
import com.igeekhome.biz.ICommonWordService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 常见的用语 服务实现类
 * </p>
 *
 * @author ${author}
 * @since 2021-03-16
 */
@Service
public class CommonWordServiceImpl extends ServiceImpl<CommonWordMapper, CommonWord> implements ICommonWordService {

}
