
package com.example.demo.secondary.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.secondary.entity.UserSecondary;

public interface UserSecondaryRepo extends JpaRepository<UserSecondary, Long> {
}
