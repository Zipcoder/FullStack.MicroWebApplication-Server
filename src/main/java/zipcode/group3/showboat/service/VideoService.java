package zipcode.group3.showboat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import zipcode.group3.showboat.model.Video;
import zipcode.group3.showboat.repository.VideoRepository;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@Service
public class VideoService {

    private VideoRepository repository;
    private FileStorageService fileStorageService;
    @Autowired
    public VideoService(VideoRepository repository, FileStorageService fileStorageService) {
        this.repository = repository;
        this.fileStorageService = fileStorageService;
    }

    public Video create(String title, String description, MultipartFile file) {
        Video video = repository.save(new Video(title, null, LocalDate.now(), description, file));

        //Save file and get file path
        try {
            String filepath = fileStorageService.storeWithS3(file, video.getId());
            video.setFilepath("//showboatvideos.s3.us-east-2.amazonaws.com/" + filepath);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return repository.save(video);
    }

    public Video read(Long id) {
        return repository.findById(id).get();
    }
    public List<Video> readAll() {
        return repository.findAll();
    }

    public Video update(Long id, Video updatedVideo) {
        Video video = read(id);
        video.setTitle(updatedVideo.getTitle());
        video.setFilepath(updatedVideo.getFilepath());
        video.setDatecreated(updatedVideo.getDatecreated());
        video.setDescription(updatedVideo.getDescription());
        return repository.save(video);
    }

    public Boolean delete(Long id) {
        repository.deleteById(id);
        return true;
    }
}
