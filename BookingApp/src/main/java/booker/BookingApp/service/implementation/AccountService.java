package booker.BookingApp.service.implementation;

import booker.BookingApp.model.users.Account;
//import booker.BookingApp.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccountService {
    //@Autowired
    //private AccountRepository accountRepository;

    public Account findOne(Long id) {
//        if (accountRepository.findOne(id) == null) {
//            return null;
//        }
//        return accountRepository.findOne(id);
        return new Account();
    }

    public Account findOneByUserId(Long userId) {
//        if (accountRepository.findOneByUserId(userId) == null) {
//            return null;
//        }
//        return accountRepository.findOneByUserId(userId);
        return new Account();
    }

    public List<Account> findAll() {
        //return accountRepository.findAll();
        Account account = new Account();
        List<Account> accounts = new ArrayList<>();
        accounts.add(account);
        return accounts;
    }

    public Account create(Account account) {
        //return accountRepository.create(account);
        return new Account();
    }

    public Account update(Account account) {
        //return accountRepository.update(account);
        return new Account();
    }

    public void remove(Long id) {
        //accountRepository.deleteById(id);
    }

    public Account save(Account account) {
        //return accountRepository.save(account);
        return new Account();
    }
}