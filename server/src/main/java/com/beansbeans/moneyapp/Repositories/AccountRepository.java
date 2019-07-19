package com.beansbeans.moneyapp.Repositories;

import com.beansbeans.moneyapp.Model.Account;
import com.beansbeans.moneyapp.Model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends CrudRepository<Account, Long> {

    Iterable<Account> findAllByUserIdIs(Long userId);
}
