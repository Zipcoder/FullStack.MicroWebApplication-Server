package com.phoenixvideos.phoenixapp.repository;

import com.phoenixvideos.phoenixapp.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
