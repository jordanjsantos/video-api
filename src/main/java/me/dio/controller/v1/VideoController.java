package me.dio.controller.v1;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import me.dio.domain.model.Video;
import me.dio.domain.service.VideoService;

@RestController
@RequestMapping("/api/v1/videos")
@RequiredArgsConstructor
public class VideoController {
	
	private final VideoService videoService;
	
	@PostMapping
	public ResponseEntity<Video> create(@RequestBody Video video) {
		video = videoService.create(video);
		
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(video);
	}
	
	@GetMapping
	public List<Video> list() {
		return videoService.list();
	}

}
