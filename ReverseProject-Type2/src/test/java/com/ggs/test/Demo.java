//package com.ggs.test;
//
//import com.ggs.mapper.BlogMapper;
//import com.ggs.pojo.Blog;
//import com.ggs.pojo.BlogExample;
//import com.ggs.utils.MybatisUtils;
//import org.apache.ibatis.session.SqlSession;
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//
//import java.util.Date;
//import java.util.List;
//import java.util.UUID;
//
///**
// *
// *  @author: Starbug
// *  @date: 2020-06-26 17:05
// */
//public class Demo {
//
//    SqlSession sqlSession;
//    BlogMapper mapper;
//
//    @Before
//    public void beforeTest() {
//        sqlSession = MybatisUtils.getSqlSession();
//        mapper = sqlSession.getMapper(BlogMapper.class);
//    }
//
//    @After
//    public void afterTest() {
//        sqlSession.close();
//    }
//
//    //条件查询,通过Example对象,进行条件封装,注意模糊查询需要自己加上%号
//    @Test
//    public void test1() {
//        BlogExample blogExample = new BlogExample();
//        blogExample.createCriteria().andAuthorEqualTo("starbug").andTitleLike("%ng%");
//        List<Blog> blogs = mapper.selectByExample(blogExample);
//        blogs.forEach(System.out::println);
//    }
//
//    //修改
//    @Test
//    public void test2() {
//        BlogExample blogExample = new BlogExample();
//        blogExample.createCriteria().andAuthorEqualTo("星星虫");
//        Blog blog = new Blog();
//        blog.setCreateTime(new Date());
//        blog.setViews(888);
//        // 修改部分数据
//        int count = mapper.updateByExampleSelective(blog, blogExample);
//        //修改全部数据, 如果某个字段为空, 会报错
////        int count = mapper.updateByExample(blog,blogExample);
//        if (count > 0) {
//            System.out.println("修改成功");
//        }
//    }
//
//    //添加
//    @Test
//    public void test3() {
//        Blog blog = new Blog();
//        blog.setId(UUID.randomUUID().toString().replace("-", ""));
//        blog.setViews(16888);
//        blog.setTitle("逆向工程2");
//        //添加数据, 如果某字段为空, 会报错
////        int insert = mapper.insert(blog);
//        // 添加数据, 可以只添加部分, 允许字段为空, 前提是数据库允许该字段为空
//        int insert = mapper.insertSelective(blog);
//        if (insert > 0) {
//            System.out.println("添加成功");
//        }
//    }
//
//    //删除
//    @Test
//    public void test4() {
//        BlogExample blogExample = new BlogExample();
//        blogExample.createCriteria().andViewsEqualTo(16888);
//        //根据条件删除
////        int deleteCount = mapper.deleteByExample(blogExample);
//
//        //根据主键删除
//        int deleteCount = mapper.deleteByPrimaryKey("bd02d9d857ce4112ab66654636d78840");
//        if(deleteCount>0){
//            System.out.println("删除成功");
//        }
//    }
//
//}
