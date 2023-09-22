package me.dio.domain.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import me.dio.domain.exception.VideoNotFoundException;
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
	
	public Video listById(Long id) {
		return videoRepository.findById(id)
				.orElseThrow(() -> new VideoNotFoundException(id));
	}
	
	public Video update(Long id, Video video) {
		return videoRepository.findById(id)
				.map(recordFound -> {
					recordFound.setTitle(video.getTitle());
					recordFound.setDescription(video.getDescription());
					recordFound.setDuration(video.getDuration());
					return videoRepository.save(recordFound);
				}).orElseThrow(() -> new VideoNotFoundException(id));
	}
	
	public void delete(Long id) {
		videoRepository.delete(videoRepository.findById(id)		
				.orElseThrow(() -> new VideoNotFoundException(id)));
	}
	
}
