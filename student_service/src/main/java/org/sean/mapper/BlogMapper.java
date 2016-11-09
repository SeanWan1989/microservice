package org.sean.mapper;


import org.apache.ibatis.annotations.Mapper;
import org.sean.domain.blog.BlogDto;

@Mapper
public interface BlogMapper {
    BlogDto selectById(String id);
}