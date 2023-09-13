package com.Bloggingplat.BloggersPlatform.Service;

import com.Bloggingplat.BloggersPlatform.Entity.Blogs;
import com.Bloggingplat.BloggersPlatform.Entity.Comments;
import com.Bloggingplat.BloggersPlatform.Repo.BlogRepository;
import com.Bloggingplat.BloggersPlatform.Repo.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CommentService {
    @Autowired
    private BlogRepository blogRepository;

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    public CommentService(BlogRepository blogRepository, CommentRepository commentRepository){
        this.blogRepository = blogRepository;
        this.commentRepository = commentRepository;
    }

    public String saveComment(Comments comments, long blogId){
        Blogs store = blogRepository.findById(blogId);
        List<Comments> commentsList = store.getComments();
        comments.setBlogs(store);
        commentsList.add(comments);
        commentRepository.save(comments);
        return "Commented";
    }
}
