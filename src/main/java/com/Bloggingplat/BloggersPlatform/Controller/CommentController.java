package com.Bloggingplat.BloggersPlatform.Controller;


import com.Bloggingplat.BloggersPlatform.Entity.Comments;
import com.Bloggingplat.BloggersPlatform.Service.BlogService;
import com.Bloggingplat.BloggersPlatform.Service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CommentController {

    @Autowired
    private BlogService blogService;

    @Autowired
    private CommentService commentService;

    @PostMapping(path = "/blogs/:{id}/comments")
    public String saveComment(@PathVariable("id") long blogId, @RequestBody Comments comment){

        return commentService.saveComment(blogId, comment);
    }

    @GetMapping(path = "/blogs/:{id}/comments")
    public List<Comments> getCommentsOfBlog(@PathVariable("id") long blogId){
        return commentService.getCommentsOfBlog(blogId);
    }

    @GetMapping(path = "/comments/:{id}")
    public Comments getCommentsById(@PathVariable long id){
        return commentService.getCommentsById(id);
    }

    @PutMapping(path = "/comments/:{id}")
    public String updateComment(@RequestBody Comments updatedComment, @PathVariable long id){
        return commentService.updateComment(updatedComment, id);
    }

    @DeleteMapping(path = "/comments/:{id}")
    public String deleteCommentById(@PathVariable long id){
        return commentService.deleteCommentById(id);
    }

    @DeleteMapping(path = "/blogs/:{id}")
    public String DeleteBlogNCommentsById(@PathVariable("id") long blogId){
        return commentService.deleteBlogNCommentsById(blogId);
    }

    @DeleteMapping(path = "/blogs/:{id}/comments")
    public String deleteAllCommentsOfBlog(@PathVariable("id") long blogId){
        return commentService.deleteAllCommentsOfBlog(blogId);
    }
}
