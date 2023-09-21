package me.dio.domain.service;

import java.util.List;
import java.util.Optional;

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
	
	public Optional<Video> listById(Long id) {
		return videoRepository.findById(id);
	}
	
	public Optional<Video> update(Long id, Video video) {
		return videoRepository.findById(id)
				.map(recordFound -> {
					recordFound.setTitle(video.getTitle());
					recordFound.setDescription(video.getDescription());
					recordFound.setDuration(video.getDuration());
					return videoRepository.save(recordFound);
				});
	}
	
	public boolean delete(Long id) {
		return videoRepository.findById(id)
				.map(recordFound -> {
					videoRepository.deleteById(id);
					return true;
				})
				.orElse(false);
	}
	
}
