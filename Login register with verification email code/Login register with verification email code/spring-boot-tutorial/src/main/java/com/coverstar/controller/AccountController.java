package com.coverstar.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.coverstar.dto.AccountCreateDto;
import com.coverstar.dto.VerifyCodeDto;
import com.coverstar.model.Account;
import com.coverstar.service.account.AccountService;

@Controller
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping("sign-up")
    public String signUp(AccountCreateDto accountCreateDto, Model model) {
        return "sign-up";
    }

    @PostMapping("sign-up")
    public String signUp(@Valid AccountCreateDto accountCreateDto, BindingResult result) throws Exception {

        if (result.hasErrors()) {
            return "sign-up";
        }

        Account account = accountService.createMember(accountCreateDto);
        accountCreateDto.setId(account.getId());

        return "redirect:/verify-code";
    }

    @GetMapping("verify-code")
    public String verifyCode(Model model, VerifyCodeDto verifyCodeDto) {

        return "verify-code";
    }

    @PostMapping("verify-code")
    public String verifyCodeAction(Model model, @Valid VerifyCodeDto verifyCodeDto, BindingResult result) {
        if (result.hasErrors()) {
            return "verify-code";
        }

        accountService.verifyCode(verifyCodeDto);

        return "redirect:/login";
    }
}
