package me.dio.domain.service;

import java.util.List;

import org.springframework.stereotype.Service;

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
}
