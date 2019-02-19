package com.waylau.spring.boot.blog.service;

import com.waylau.spring.boot.blog.vo.Response;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.waylau.spring.boot.blog.domain.User;
import org.springframework.http.ResponseEntity;

import java.util.Collection;
import java.util.List;

/**
 * 用户服务接口.
 */
public interface UserService {

    User verify(String username);
	 /**
     * 新增、编辑、保存用户
     */
    User saveOrUpateUser(User user);

    /**
     * 注册用户
     */
    User registerUser(User user);

    /**
     * 删除用户
     */
    void removeUser(Long id);

    /**
     * 根据id获取用户
     */
    User getUserById(Long id);

    /**
     * 根据用户名进行分页模糊查询
     */
    Page<User> listUsersByNameLike(String name, Pageable pageable);

    /**
     * 根据用户名集合，查询用户详细信息列表
     */
    List<User> listUsersByUsernames(Collection<String> usernames);
}