package com.waylau.spring.boot.blog.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.waylau.spring.boot.blog.domain.User;
import com.waylau.spring.boot.blog.repository.UserRepository;

import java.util.Collection;
import java.util.List;

/**
 * 用户服务接口实现.
 */
@Service
public class UserServiceImpl implements UserService, UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public User verify(String username) {
		return userRepository.findByUsername(username);
	}

	@Transactional
	@Override
	public User saveOrUpateUser(User user) {
		return userRepository.save(user);
	}

	@Transactional
	@Override
	public User registerUser(User user) {
		return userRepository.save(user);
	}

	@Transactional
	@Override
	public void removeUser(Long id) {
		userRepository.delete(id);
	}

	@Override
	public User getUserById(Long id) {
		return userRepository.findOne(id);
	}

	@Override
	public Page<User> listUsersByNameLike(String name, Pageable pageable) {
        // 模糊查询
        name = "%" + name + "%";
        Page<User> users = userRepository.findByNameLike(name, pageable);
        return users;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return userRepository.findByUsername(username);
	}

	@Override
	public List<User> listUsersByUsernames(Collection<String> usernames) {
		return userRepository.findByUsernameIn(usernames);
	}

}
