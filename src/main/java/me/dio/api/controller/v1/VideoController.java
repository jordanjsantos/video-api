package me.dio.api.controller.v1;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import me.dio.domain.model.Video;
import me.dio.domain.service.VideoService;

@RestController
@RequestMapping("/v1/videos")
@RequiredArgsConstructor
public class VideoController {
	
	private final VideoService videoService;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Video create(@RequestBody Video video) {
		return videoService.create(video);
	}
	
	@GetMapping
	public List<Video> list() {
		return videoService.list();
	}
	
	@GetMapping("/{id}")
	public Video listById(@PathVariable Long id) {
		return videoService.listById(id);
	}
	
	@PutMapping("/{id}")
	public Video update(@PathVariable Long id, @RequestBody Video video) {
		return videoService.update(id, video);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		videoService.delete(id);
	}

}
