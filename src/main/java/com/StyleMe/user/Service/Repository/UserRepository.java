package com.StyleMe.user.Service.Repository;

import com.StyleMe.user.Service.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
