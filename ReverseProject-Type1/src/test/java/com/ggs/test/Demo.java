package com.ggs.test;

import com.ggs.mapper.BlogMapper;
import com.ggs.pojo.Blog;
import com.ggs.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 *
 *  @author: Starbug
 *  @date: 2020-06-26 17:56
 */
public class Demo {

    SqlSession sqlSession;
    BlogMapper mapper;

    @Before
    public void beforeTest() {
        sqlSession = MybatisUtils.getSqlSession();
        mapper = sqlSession.getMapper(BlogMapper.class);
    }

    @After
    public void afterTest() {
        sqlSession.close();
    }

    //条件查询 报错, 可能需要tk通用mapper和Spring整合才能用
    @Test
    public void test1() {
        Example example = new Example(Blog.class);
        Blog blog = new Blog();
        blog.setTitle("Spring博客");
        example.createCriteria().andEqualTo(blog);
        List<Blog> blogs = mapper.selectByExample(example);
        blogs.forEach(System.out::println);
    }

}
