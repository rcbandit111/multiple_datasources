
package com.example.demo.primary.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.primary.entity.UserPrimary;

public interface UserPrimaryRepo extends JpaRepository<UserPrimary, Long> {
}
