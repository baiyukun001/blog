package com.waylau.spring.boot.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.waylau.spring.boot.blog.domain.Vote;

/**
 * Vote Repository接口.
 */
public interface VoteRepository extends JpaRepository<Vote, Long> {
}