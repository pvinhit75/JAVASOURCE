package com.coverstar.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.coverstar.model.Account;
import com.coverstar.repository.AccountRepository;

@Controller
@RequestMapping("/")
public class IndexController {


    @Autowired
    private AccountRepository accountRepository;

    @GetMapping
    public String home(Model model, Pageable pageable) {
        model.addAttribute("page", accountRepository.findAll(pageable));
        return "layout";
    }

    @GetMapping("/pagination")
    @ResponseBody
    public Page<Account> findAll(Pageable pageable) {
        return accountRepository.findAll(pageable);
    }

    @GetMapping("login")
    public String login(Model model, HttpServletRequest request) {
        return "login";
    }


}
