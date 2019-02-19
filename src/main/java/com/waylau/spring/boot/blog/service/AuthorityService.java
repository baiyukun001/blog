package com.waylau.spring.boot.blog.service;

import com.waylau.spring.boot.blog.domain.Authority;

/**
 * Authority 服务接口.
 */
public interface AuthorityService {
	/**
	 * 根据ID查询 Authority
	 */
    Authority getAuthorityById(Long id);
}
