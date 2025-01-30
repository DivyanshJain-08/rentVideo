package com.videoRentalSystem.rentVideo.Service;

import java.util.List;
import com.videoRentalSystem.rentVideo.Entity.Video;

public interface VideoService 
{
    public List<Video> getAvailableVideos();    
    public Video addVideo(Video video);
    public void deleteVideo(Long id); 
}
