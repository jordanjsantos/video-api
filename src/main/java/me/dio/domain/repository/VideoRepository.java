package me.dio.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import me.dio.domain.model.Video;

@Repository
public interface VideoRepository extends JpaRepository<Video, Long> {

}
