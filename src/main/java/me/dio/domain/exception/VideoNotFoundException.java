package me.dio.domain.exception;

public class VideoNotFoundException extends EntityNotFoundException {

	private static final long serialVersionUID = 1L;

	public VideoNotFoundException(Long id) {
		super(String.format("Not exists video records with code %d", id));
	}

}
