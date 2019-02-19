package com.waylau.spring.boot.blog.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.waylau.spring.boot.blog.domain.Catalog;
import com.waylau.spring.boot.blog.domain.User;

/**
 * Catalog Repository.
 */
public interface CatalogRepository extends JpaRepository<Catalog, Long> {
    /**
     * 根据用户查询
     */
    List<Catalog> findByUser(User user);

    /**
     * 根据用户、分类名称查询
     */
    List<Catalog> findByUserAndName(User user, String name);


}
