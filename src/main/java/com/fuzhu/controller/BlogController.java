package com.fuzhu.controller;

import com.fuzhu.model.BlogEntity;

import com.fuzhu.model.UserEntity;
import com.fuzhu.repository.BlogRepository;
import com.fuzhu.repository.BlogPageDao;
import com.fuzhu.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by ${符柱成} on 2016/12/29.
 */
@Controller
public class BlogController {
    @Autowired
    BlogRepository blogRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    private BlogPageDao districtRepository;
    // 查看所有博文，实现分页查询！！！
    @RequestMapping(value = "/admin/blogs", method = RequestMethod.GET)
    public String showBlogs(ModelMap modelMap,@RequestParam(value = "pageNonumber", required = false, defaultValue = "0") Integer pageNonumber) {
        //下面二句是没分页功能的。单纯显示全部的信息
//        List<BlogEntity> blogList = blogRepository.findAll();
//        modelMap.addAttribute("blogList", blogList);
        //return "admin/blogs";

        if (pageNonumber == null ||  pageNonumber==-1) {
            pageNonumber = 0;
        }
        // pageNo从0开始
        int pageSize = 5;       //页面大小
        // PageRequest接口通常使用的起PageRequest实现类，其中封装了需要分页的信息
        PageRequest pageRequest = new PageRequest(pageNonumber, pageSize);
        Page<BlogEntity> page = districtRepository.findAll(pageRequest);
        System.out.println("总记录数：" + page.getTotalElements());
        System.out.println("当前第几页：" + page.getNumber());
        System.out.println("总页数" + page.getTotalPages());
        System.out.println("当前页面的list：" + page.getContent());
        System.out.println("当前页面记录数：" + page.getNumberOfElements());

        modelMap.addAttribute("sourceCodeList",page.getContent());  //当前页面的list
        modelMap.addAttribute("totalPageNumber",page.getTotalElements());//总记录数
        modelMap.addAttribute("numberPage",page.getNumber());//当前第几页
        modelMap.addAttribute("totalPages",page.getTotalPages());//总页数

        return "pages/testPage";
    }

    // 添加博文
    @RequestMapping(value = "/admin/blogs/add", method = RequestMethod.GET)
    public String addBlog(ModelMap modelMap) {
        List<UserEntity> userList = userRepository.findAll();
        // 向jsp注入用户列表
        modelMap.addAttribute("userList", userList);
        return "pages/addBlog";
    }

    // 添加博文，POST请求，重定向为查看博客页面
    @RequestMapping(value = "/admin/blogs/addP", method = RequestMethod.POST)
    public String addBlogPost(@ModelAttribute("blog") BlogEntity blogEntity) {
        // 打印博客标题
        System.out.println(blogEntity.getTitle());
        // 打印博客作者
        System.out.println(blogEntity.getUserByUserId().getNickname());
        // 存库
        blogRepository.saveAndFlush(blogEntity);
        // 重定向地址
        return "redirect:/admin/blogs";
    }

    // 查看博文详情，默认使用GET方法时，method可以缺省
    @RequestMapping("/admin/blogs/show/{id}")
    public String showBlog(@PathVariable("id") int id, ModelMap modelMap) {
        BlogEntity blog = blogRepository.findOne(id);
        modelMap.addAttribute("blog", blog);
        return "pages/blogDetail";
    }

    // 修改博文内容，页面
    @RequestMapping("/admin/blogs/update/{id}")
    public String updateBlog(@PathVariable("id") int id, ModelMap modelMap) {
        // 是不是和上面那个方法很像
        BlogEntity blog = blogRepository.findOne(id);
        List<UserEntity> userList = userRepository.findAll();
        modelMap.addAttribute("blog", blog);
        modelMap.addAttribute("userList", userList);
        return "pages/updateBlog";
    }

    // 修改博客内容，POST请求
    @RequestMapping(value = "/admin/blogs/updateP", method = RequestMethod.POST)
    public String updateBlogP(@ModelAttribute("blogP") BlogEntity blogEntity) {
        // 更新博客信息
        blogRepository.updateBlog(blogEntity.getTitle(), blogEntity.getUserByUserId().getId(),
                blogEntity.getContent(), blogEntity.getPubDate(), blogEntity.getId());
        blogRepository.flush();
        return "redirect:/admin/blogs";
    }

    // 删除博客文章
    @RequestMapping("/admin/blogs/delete/{id}")
    public String deleteBlog(@PathVariable("id") int id) {
        blogRepository.delete(id);
        blogRepository.flush();
        return "redirect:/admin/blogs";
    }

}
