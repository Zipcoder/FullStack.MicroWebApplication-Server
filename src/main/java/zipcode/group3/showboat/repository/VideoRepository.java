package zipcode.group3.showboat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import zipcode.group3.showboat.model.Video;

@Repository
public interface VideoRepository extends JpaRepository<Video, Long> {
}
