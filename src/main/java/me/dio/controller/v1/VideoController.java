package me.dio.controller.v1;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
	public ResponseEntity<Video> create(@RequestBody Video video) {
		video = videoService.create(video);
		
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(video);
	}
	
	@GetMapping
	public List<Video> list() {
		return videoService.list();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Video> listById(@PathVariable Long id) {
		return videoService.listById(id)
				.map(recordFound -> ResponseEntity.ok().body(recordFound))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Video> update(@PathVariable Long id, @RequestBody Video video) {
		return videoService.update(id, video)
				.map(recordFound -> ResponseEntity.ok().body(recordFound))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Video> delete(@PathVariable Long id) {
		if (videoService.delete(id)) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.notFound().build();
	}

}
