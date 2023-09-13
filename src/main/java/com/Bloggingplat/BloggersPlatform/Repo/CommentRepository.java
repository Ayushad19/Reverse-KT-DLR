package com.Bloggingplat.BloggersPlatform.Repo;

import com.Bloggingplat.BloggersPlatform.Entity.Comments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface CommentRepository extends JpaRepository<Comments, Long> {

}