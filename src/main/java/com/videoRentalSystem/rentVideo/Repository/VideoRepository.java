package com.videoRentalSystem.rentVideo.Repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.videoRentalSystem.rentVideo.Entity.Video;

public interface VideoRepository extends JpaRepository<Video , Long>
{
    List<Video> findByAvailableTrue();
}
