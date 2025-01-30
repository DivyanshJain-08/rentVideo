package com.videoRentalSystem.rentVideo.Repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.videoRentalSystem.rentVideo.Entity.User;

public interface UserRepository extends JpaRepository<User , Long>
{
    Optional<User> findByEmail(String email);
}
