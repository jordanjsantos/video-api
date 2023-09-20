package me.dio.domain.service;

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
}
