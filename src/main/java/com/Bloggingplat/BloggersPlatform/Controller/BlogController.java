package com.Bloggingplat.BloggersPlatform.Controller;


import com.Bloggingplat.BloggersPlatform.Entity.Blogs;
import com.Bloggingplat.BloggersPlatform.Entity.Comments;
import com.Bloggingplat.BloggersPlatform.Service.BlogService;
import com.Bloggingplat.BloggersPlatform.Service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BlogController {
    @Autowired
    private BlogService blogService;

    @Autowired
    private CommentService commentService;

    @PostMapping(path = "/blogs")
    public String saveBlogs(@RequestBody Blogs blogs){
        try {
            return blogService.saveBlogs(blogs);
        }
        catch(Exception e) {
            return "Please enter a valid entry";
        }
    }

    @GetMapping(path = "/blogs")
    public List<Blogs> getAllBlogs(){
        return blogService.getAllBlogs();
    }

    @GetMapping(path = "blogs/:{id}")
    public Blogs getBlogById(@PathVariable long id){
        return blogService.getBlogById(id);
    }

    @PutMapping(path = "/blogs/:{id}")
    public String updateBlog(@RequestBody Blogs update, @PathVariable long id){
        return blogService.updateBlog(update, id);
    }

    //These below two requests are no longer in use after the relationship establishment between
    //blogs and comments where Blogs entity is the parent class and has a foreign constraint in Comments
    //entity

//    @DeleteMapping(path = "/blogs")
//    public String DeleteBlogs(){
//        return blogService.deleteBlogs();
//    }

//    @DeleteMapping(path = "/blogs/:{id}")
//    public String deleteBlogById(@PathVariable long id){
//        return blogService.deleteBlogById(id);
//    }

    @GetMapping(path = "/blogs/published")
    public List<Blogs> getPublishedBlogs(){
        return blogService.getPublishedBlogs();
    }

}
