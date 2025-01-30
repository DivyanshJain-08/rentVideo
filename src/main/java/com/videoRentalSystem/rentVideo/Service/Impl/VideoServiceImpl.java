package com.videoRentalSystem.rentVideo.Service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.videoRentalSystem.rentVideo.Entity.Video;
import com.videoRentalSystem.rentVideo.Repository.VideoRepository;
import com.videoRentalSystem.rentVideo.Service.VideoService;

@Service
public class VideoServiceImpl implements VideoService
{

    private final VideoRepository videoRepository;

    @Autowired
    public VideoServiceImpl(VideoRepository videoRepository)
    {
        this.videoRepository = videoRepository;
    }

    @Override
    public List<Video> getAvailableVideos() 
    {
        return videoRepository.findByAvailableTrue();
    }

    @Override
    public Video addVideo(Video video) 
    {
        return videoRepository.save(video);
    }

    @Override
    public void deleteVideo(Long id) 
    {
        videoRepository.deleteById(id);    
    }
    
}
