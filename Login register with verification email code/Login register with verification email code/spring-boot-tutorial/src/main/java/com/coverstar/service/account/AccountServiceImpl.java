package com.coverstar.service.account;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.coverstar.dao.account.AccountDao;
import com.coverstar.dao.verify_account.VerifyAccountDao;
import com.coverstar.dto.AccountCreateDto;
import com.coverstar.dto.VerifyCodeDto;
import com.coverstar.mail.Mail;
import com.coverstar.mail.MailService;
import com.coverstar.model.Account;
import com.coverstar.model.Role;
import com.coverstar.model.VerifyAccount;
import com.coverstar.service.role.RoleService;
import com.coverstar.util.RandomUtil;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;

    @Autowired
    private RoleService roleService;

    @Autowired
    private MailService mailService;

    @Autowired
    private VerifyAccountDao verifyAccountDao;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public Account createMember(AccountCreateDto accountDto) throws MessagingException {

        String email = accountDto.getEmail();
        String username = accountDto.getUsername();
        String password = accountDto.getPassword();

        Account account = new Account();
        account.setEmail(email);
        account.setUsername(username);
        account.setPassword(passwordEncoder.encode(password));
        account.setActive(false);

        if (roleService.findById(2l).isPresent()) {
            Role role = roleService.findById(2l).get();
            account.addRole(role);
        }

        String token = RandomUtil.generateRandomStringNumber(6).toUpperCase();

        VerifyAccount verifyAccount = new VerifyAccount();
        verifyAccount.setAccount(account);
        verifyAccount.setCreatedDate(LocalDateTime.now());
        verifyAccount.setExpiredDataToken(5);
        verifyAccount.setToken(token);
        verifyAccountDao.create(verifyAccount);

        Map<String, Object> maps = new HashMap<>();
        maps.put("account", account);
        maps.put("token", token);

        Mail mail = new Mail();
        mail.setFrom("postmaster@mg.iteacode.com");
        mail.setSubject("Registration");
        mail.setTo(account.getEmail());
        mail.setModel(maps);
        mailService.sendEmail(mail);

        return accountDao.create(account);
    }

    @Override
    public Account createAdmin(AccountCreateDto accountDto) {
        String email = accountDto.getEmail();
        String username = accountDto.getUsername();
        String password = accountDto.getPassword();

        Account account = new Account();
        account.setEmail(email);
        account.setUsername(username);
        account.setPassword(passwordEncoder.encode(password));

        if (roleService.findById(2l).isPresent()) {
            Role role = roleService.findById(2l).get();
            account.addRole(role);
        }

        return accountDao.create(account);
    }

    @Override
    public Optional<Account> findByUsernameOrEmail(String username, String email) {
        return accountDao.findByUsernameOrEmail(username, email);
    }

    @Override
    public Optional<Account> findByEmail(String email) {
        return accountDao.findByEmail(email);
    }

    @Override
    public Optional<Account> findByUsername(String username) {
        return accountDao.findByUsername(username);
    }

    @Override
    public Optional<Account> findById(Long id) {
        return accountDao.findById(id);
    }

    public void verifyCode(VerifyCodeDto verifyCodeDto) {

        String token = verifyCodeDto.getToken();

        VerifyAccount verifyAccount = verifyAccountDao.findByToken(token).get();
        Account account = verifyAccount.getAccount();
        account.setActive(true);
        accountDao.update(account);
    }

}