package org.sean.service;

import org.sean.domain.blog.BlogComments;
import org.sean.domain.blog.BlogDto;
import org.sean.mapper.BlogMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


/**
 * Created by wanlichao on 2016/10/26 0026.
 */
public class BlogService {
    @Autowired
    private BlogMapper mapper;

    public void show(String blogId){
        BlogDto blog = mapper.selectById(blogId);
        System.out.println("当前正在访问博客 - "+blog.getTitle());
        System.out.println("博客ID："+blog.getId());
        System.out.println("博客地址："+blog.getUrl());
        if(blog.getUser()!=null){
            System.out.println("=======================================");
            System.out.println("博客作者信息：");
            System.out.println("用户名："+blog.getUser().getUsername());
            System.out.println("用户信息："+blog.getUser().getUserinfo());
        }
        if(blog.getPosts()!=null&&blog.getPosts().size()>0){
            System.out.println("=======================================");
            System.out.println("博客文章数："+blog.getPosts().size());
            for(int i=0;i<blog.getPosts().size();i++){
                System.out.println("第"+(i+1)+"篇:"+blog.getPosts().get(i).getPostid());
                System.out.println("内容：\n"+blog.getPosts().get(i).getPostinfo());
                List<BlogComments> comments = blog.getPosts().get(i).getComments();
                if(comments!=null&&comments.size()>0){
                    System.out.println("====================");
                    System.out.println("用户回复:");
                    for(int j=0;j<comments.size();j++){
                        System.out.println(comments.get(j).getUsername()+" ： “"+comments.get(j).getMsg()+"”");
                    }
                }
                System.out.println("\n");
            }
        }

    }
}
