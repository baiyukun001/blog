package com.waylau.spring.boot.blog.service;
 

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.waylau.spring.boot.blog.domain.User;
import com.waylau.spring.boot.blog.domain.es.EsBlog;
import com.waylau.spring.boot.blog.vo.TagVO;

/**
 * EsBlog 服务接口.
 */
public interface EsBlogService {
 	
	/**
	 * 删除EsBlog
	 */
	void removeEsBlog(String id);
	
	/**
	 * 更新 EsBlog
	 */
	EsBlog updateEsBlog(EsBlog esBlog);
	
	/**
	 * 根据Blog的Id获取EsBlog
	 */
	EsBlog getEsBlogByBlogId(Long blogId);
 
	/**
	 * 最新博客列表，分页
	 */
	Page<EsBlog> listNewestEsBlogs(String keyword, Pageable pageable);
 
	/**
	 * 最热博客列表，分页
	 */
	Page<EsBlog> listHotestEsBlogs(String keyword, Pageable pageable);
	
	/**
	 * 博客列表，分页
	 * @param pageable
	 * @return
	 */
	Page<EsBlog> listEsBlogs(Pageable pageable);
	/**
	 * 最新前5
	 */
	List<EsBlog> listTop5NewestEsBlogs();
	
	/**
	 * 最热前5
	 */
	List<EsBlog> listTop5HotestEsBlogs();
	
	/**
	 * 最热前 30 标签
	 */
	List<TagVO> listTop30Tags();

	/**
	 * 最热前12用户
	 */
	List<User> listTop12Users();
}
