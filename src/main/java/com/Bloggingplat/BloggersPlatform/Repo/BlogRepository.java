package com.Bloggingplat.BloggersPlatform.Repo;

import com.Bloggingplat.BloggersPlatform.Entity.Blogs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface BlogRepository extends JpaRepository<Blogs, Long> {
    @Override
    List<Blogs> findAll();

    Blogs findById(long id);

}
