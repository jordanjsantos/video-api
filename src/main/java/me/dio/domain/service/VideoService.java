package me.dio.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import lombok.RequiredArgsConstructor;
import me.dio.domain.model.Video;
import me.dio.domain.repository.VideoRepository;

@Service
@RequiredArgsConstructor
public class VideoService {

	private final VideoRepository videoRepository;
	
	public Video create(Video video) {
		return videoRepository.save(video);
	}
	
	public List<Video> list() {
		return videoRepository.findAll();
	}
	
	public Optional<Video> listById(@PathVariable Long id) {
		return videoRepository.findById(id);
	}
}
