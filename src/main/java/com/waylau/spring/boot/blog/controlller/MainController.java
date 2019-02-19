package com.waylau.spring.boot.blog.controlller;

import java.util.ArrayList;
import java.util.List;

import com.waylau.spring.boot.blog.vo.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.waylau.spring.boot.blog.domain.Authority;
import com.waylau.spring.boot.blog.domain.User;
import com.waylau.spring.boot.blog.service.AuthorityService;
import com.waylau.spring.boot.blog.service.UserService;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 主页控制器.
 */
@Controller
public class MainController {
	
	private static final Long ROLE_USER_AUTHORITY_ID = 2L;
	@Autowired
	private UserService userService;
	
	@Autowired
	private AuthorityService authorityService;
	
	@GetMapping("/")
	public String root() {
		return "redirect:/index";
	}
	
	@GetMapping("/index")
	public String index() {
		return "redirect:/blogs";
	}

	@GetMapping("/verify")
	public ResponseEntity<Response> verify(@RequestParam(value="username",required=true) String username){
		System.out.println(username);
		if (userService.verify(username)== null){
			return ResponseEntity.ok().body(new Response(false, "账号不存在"));
		}
		return ResponseEntity.ok().body(new Response(true, username + " 您好!"));
	}

	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@GetMapping("/login-error")
	public String loginError(Model model) {
		model.addAttribute("loginError", true);
		model.addAttribute("errorMsg", "登陆失败，用户名或者密码错误！");
		return "login";
	}
	
	@GetMapping("/register")
	public String register() {
		//return "register";
		return "redirect:/error";
	}
	
    /**
     * 注册用户
     */
    //@PostMapping("/register")
    public String registerUser(User user) {
    	try {
			List<Authority> authorities = new ArrayList<>();
			authorities.add(authorityService.getAuthorityById(ROLE_USER_AUTHORITY_ID));
			user.setAuthorities(authorities);
			userService.registerUser(user);
		} catch (Exception e) {
    		return "redirect:/error";
		}
        return "redirect:/login";
    }

	@GetMapping("/error")
	public String error() {
		return "error";
	}



}
