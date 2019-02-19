package com.waylau.spring.boot.blog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.waylau.spring.boot.blog.domain.Catalog;
import com.waylau.spring.boot.blog.domain.User;
import com.waylau.spring.boot.blog.repository.CatalogRepository;

/**
 * Catalog 服务接口实现.
 */
@Service
public class CatalogServiceImpl implements CatalogService {
	@Autowired
	private CatalogRepository catalogRepository;
	
	@Override
	public Catalog saveCatalog(Catalog catalog) {
		 // 判断重复
		if (catalog.getId() != null) {
			System.out.println(catalog.getId());
			return catalogRepository.save(catalog);
		} else {
			List<Catalog> list = catalogRepository.findByUserAndName(catalog.getUser(), catalog.getName());
			if(list !=null && list.size() > 0) {
				throw new IllegalArgumentException("该分类已经存在了");
			}
			return catalogRepository.save(catalog);
		}
	}
	
	@Override
	public void removeCatalog(Long id) {
		catalogRepository.delete(id);
	}

	@Override
	public Catalog getCatalogById(Long id) {
		return catalogRepository.findOne(id);
	}

	@Override
	public List<Catalog> listCatalogs(User user) {
		return catalogRepository.findByUser(user);
	}

}
