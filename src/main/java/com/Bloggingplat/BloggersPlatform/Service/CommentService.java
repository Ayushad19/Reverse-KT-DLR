package com.Bloggingplat.BloggersPlatform.Service;
import com.Bloggingplat.BloggersPlatform.Entity.Blogs;
import com.Bloggingplat.BloggersPlatform.Entity.Comments;
import com.Bloggingplat.BloggersPlatform.Repo.BlogRepository;
import com.Bloggingplat.BloggersPlatform.Repo.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    @Autowired
    private BlogRepository blogRepository;

    @Autowired
    private CommentRepository commentRepository;

    public String saveComment(long blogId, Comments comment) {
        Blogs blog = blogRepository.findById(blogId);
        if (blog != null) {
            comment.setBlogs(blog);
            commentRepository.save(comment);
            return "Comment added to Blog with ID "+blogId+" successfully!";
        } else {
            return "Blog with ID "+blogId+" not found.";
        }
    }


    public List<Comments> getCommentsOfBlog(long blogId){
            return commentRepository.findByBlogsId(blogId);
    }

    public Comments getCommentsById(long id){
        return commentRepository.findById(id);
    }

    public String updateComment(Comments update, long id){
        Comments temp = commentRepository.findById(id);
        if (temp != null)
        {
           temp.setContent(update.getContent());
           commentRepository.save(temp);
           return "Comment of ID: "+id+" updated successfully";
        }
        return "Comment does not exists";
    }

    public String deleteCommentById(long id) {
        Comments temp = commentRepository.findById(id);
        if (temp != null) {
            temp.setBlogs(null);
            commentRepository.delete(temp);
            return "Comment of 'id: " + id + "' is deleted successfully!";
        } else {
            return "Comment not found";
        }
    }


    public String deleteBlogNCommentsById(long blogId) {
        commentRepository.deleteCommentsByBlogId(blogId);
        blogRepository.deleteById(blogId);
        return "Blog with ID " + blogId + " and its associated comments are deleted successfully!";
    }

    public String deleteAllCommentsOfBlog(long blogId){
        Blogs blog = blogRepository.findById(blogId);
        if (blog != null) {
            commentRepository.deleteCommentsByBlogId(blogId);
            return "All comments for Blog with ID " + blogId + " are deleted successfully!";
        } else {
            return "Blog with ID " + blogId + " not found.";
        }
    }
}
