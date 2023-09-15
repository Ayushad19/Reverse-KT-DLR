package com.Bloggingplat.BloggersPlatform.Service;
import com.Bloggingplat.BloggersPlatform.Entity.Blogs;
import com.Bloggingplat.BloggersPlatform.Repo.BlogRepository;
import com.Bloggingplat.BloggersPlatform.Repo.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BlogService {
    @Autowired
    private BlogRepository blogRepository;

    @Autowired
    private CommentRepository commentRepository;

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

    public String updateBlog(Blogs update, long id){

        Blogs temp = blogRepository.findById(id);
        if (temp != null)
        {
            temp.setTitle(update.getTitle());
            temp.setDescription(update.getDescription());
            temp.setPublished(update.getPublished());
            blogRepository.save(temp);
            return "Blog of id: "+id+" updated successfully";

        }
        return "Blog does not exists";
    }

    //These below two methods are no longer in use after the relationship establishment between
    //blogs and comments where Blogs entity is the parent class and has a foreign constraint in Comments
    //entity

//    public String deleteBlogs(){
//        blogRepository.deleteAll();
//        return "All blogs are deleted!!!";
//    }

//    public String deleteBlogById(long id){
//        blogRepository.deleteById(id);
//        return "Blog of 'id: "+id+"' is deleted successfully!";
//    }

    public List<Blogs> getPublishedBlogs(){
       return blogRepository.findAll().stream().filter(Blogs::getPublished).toList();
    }
}
