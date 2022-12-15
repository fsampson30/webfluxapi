package repository;

import document.Playlist;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

public interface PlaylistRepository extends ReactiveMongoRepository<Playlist, String> {
}
