package com.zipcodewilmington.videoproject.repositories;

import com.zipcodewilmington.videoproject.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, String> {
}
