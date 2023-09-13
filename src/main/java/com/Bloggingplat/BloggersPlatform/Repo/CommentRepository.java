package com.Bloggingplat.BloggersPlatform.Repo;

import com.Bloggingplat.BloggersPlatform.Entity.Comments;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface CommentRepository extends JpaRepository<Comments, Long> {
    List<Comments> findByBlogsId(long blogId);

    Comments findById(long id);

    @Transactional
    @Modifying
    @Query("DELETE FROM Comments c WHERE c.blogs.id = ?1")
    void deleteCommentsByBlogId(long blogId);
}
