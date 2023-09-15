package com.Bloggingplat.BloggersPlatform.Repo;

import com.Bloggingplat.BloggersPlatform.Entity.Blogs;
import com.Bloggingplat.BloggersPlatform.Entity.Comments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@EnableJpaRepositories
public interface BlogRepository extends JpaRepository<Blogs, Long> {
    List<Blogs> findAll();

    Blogs findById(long id);
}