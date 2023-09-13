package com.Bloggingplat.BloggersPlatform.Controller;


import com.Bloggingplat.BloggersPlatform.Entity.Comments;
import com.Bloggingplat.BloggersPlatform.Service.BlogService;
import com.Bloggingplat.BloggersPlatform.Service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class CommentController {

    @Autowired
    private BlogService blogService;

    @Autowired
    private CommentService commentService;

    @PostMapping(path = "/blogs/:{id}/comments")
    public String saveComment(@RequestBody Comments comments, @PathVariable("id") long blogId){

        return commentService.saveComment(comments, blogId);
    }

}
