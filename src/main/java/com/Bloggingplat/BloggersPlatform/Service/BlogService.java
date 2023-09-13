package com.Bloggingplat.BloggersPlatform.Service;
import com.Bloggingplat.BloggersPlatform.Entity.Blogs;
import com.Bloggingplat.BloggersPlatform.Repo.BlogRepository;
import com.Bloggingplat.BloggersPlatform.Repo.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class BlogService {
    @Autowired
    private BlogRepository blogRepository;

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    public BlogService(BlogRepository blogRepository, CommentRepository commentRepository){
        this.blogRepository = blogRepository;
        this.commentRepository = commentRepository;
    }

    public String saveBlogs(Blogs blogs){
         blogRepository.save(blogs);
         return "Blog of title: "+blogs.getTitle()+" posted successfully";
    }

    public List<Blogs> getAllBlogs(){
        return blogRepository.findAll();
    }

    public Blogs getBlogById(long id){
        return blogRepository.findById(id);
    }

    public String updateBlog(Blogs updatedBlog, long id){

        Blogs temp = blogRepository.findById(id);
        if (temp != null)
        {
            temp.setTitle(updatedBlog.getTitle());
            temp.setDescription(updatedBlog.getDescription());
            temp.setPublished(updatedBlog.getPublished());
            blogRepository.save(temp);
            return "Blog of id: "+id+" updated successfully";

        }
        return "Blog does not exists";
    }

    public String deleteBlogs(){
        blogRepository.deleteAll();
        return "All blogs are deleted!!!";
    }

//    public String deleteBlogById(long id){
//        blogRepository.deleteById(id);
//        return "Blog of 'id: "+id+"' is deleted successfully!";
//    }

    public List<Blogs> getPublishedBlogs(){
       return blogRepository.findAll().stream().filter(Blogs::getPublished).toList();
    }
}
