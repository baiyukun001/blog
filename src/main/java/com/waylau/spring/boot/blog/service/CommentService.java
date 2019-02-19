package com.waylau.spring.boot.blog.service;

import com.waylau.spring.boot.blog.domain.Comment;

/**
 * Comment Service接口.
 */
public interface CommentService {

	/**
     * 根据id获取 Comment
     */
    Comment getCommentById(Long id);
    /**
     * 删除评论
     */
    void removeComment(Long id);
}
