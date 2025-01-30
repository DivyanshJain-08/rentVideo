package com.videoRentalSystem.rentVideo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.videoRentalSystem.rentVideo.Entity.Video;
import com.videoRentalSystem.rentVideo.Service.VideoService;

@RestController
@RequestMapping("/api/videos")

public class VideoController 
{
    private final VideoService videoService;

    @Autowired
    public VideoController(VideoService videoService)
    {
        this.videoService = videoService;
    }

    @GetMapping
    public ResponseEntity<List<Video>> getAvailableVideos() {
        return ResponseEntity.ok(videoService.getAvailableVideos());
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<Video> addVideo(@RequestBody Video video) {
        return ResponseEntity.ok(videoService.addVideo(video));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteVideo(@PathVariable Long id) {
        videoService.deleteVideo(id);
        return ResponseEntity.ok("Video deleted successfully");
    }
}
