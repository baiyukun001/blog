package com.waylau.spring.boot.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.waylau.spring.boot.blog.domain.Comment;

/**
 * Comment Repository 接口.
 */
public interface CommentRepository extends JpaRepository<Comment, Long> {

}
