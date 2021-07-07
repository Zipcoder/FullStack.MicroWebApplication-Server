package zipcode.group3.showboat;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import zipcode.group3.showboat.model.Comment;
import zipcode.group3.showboat.model.User;
import zipcode.group3.showboat.model.Video;
import zipcode.group3.showboat.repository.CommentRepository;
import zipcode.group3.showboat.repository.UserRepository;
import zipcode.group3.showboat.repository.VideoRepository;

import java.util.stream.Stream;

@SpringBootApplication
public class ShowboatApplication {


	public static void main(String[] args) { SpringApplication.run(ShowboatApplication.class, args); }

//	@Bean
//	CommandLineRunner init(UserRepository userRepository, VideoRepository videoRepository, CommentRepository commentRepository) {
//		return args -> {
//			Stream.of("John", "Julie", "Jennifer", "Helen", "Rachel").forEach(name -> {
//                        User user = new User(name, name.toLowerCase() + "@domain.com");
//                        userRepository.save(user);
//                    });
//
//			Video video = new Video("DogPlay", "https://www.youtube.com/user/PottyTrainingAPuppy?v=IPQAazegMQg",
//					"March 10, 2019", "Dogs playing");
//				videoRepository.save(video);
//
//			Comment comment = new Comment(1,"awesome video");
//			commentRepository.save(comment);
//
//			userRepository.findAll().forEach(System.out::println);
//		};
//
//
//	}

}
