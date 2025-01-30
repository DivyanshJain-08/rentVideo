package com.videoRentalSystem.rentVideo.Service;

import java.util.Optional;

import com.videoRentalSystem.rentVideo.Entity.User;

public interface UserService 
{
    public User registerUser(User user);

    public Optional<User> findByEmail(String string);    
}
