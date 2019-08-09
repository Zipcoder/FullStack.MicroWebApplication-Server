package zipcode.group3.showboat.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Video {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="videoid")
    private Long id;
    private String title;
    private String filepath;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate datecreated;
    private String description;

    private Long userId;

    @OneToMany(mappedBy = "video")
    @JsonIgnoreProperties("video")
    private List<Comment> comments;

//    @Transient
//    private transient MultipartFile file;

    public Video() { }

    public Video(String title, String filepath, LocalDate datecreated, String description, MultipartFile file) {
        this.title = title;
        this.filepath = filepath;
        this.datecreated = datecreated;
        this.description = description;
//        this.file = file;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String name) {
        this.title = name;
    }

    public String getFilepath() {
        return filepath;
    }

    public void setFilepath(String filepath) {
        this.filepath = filepath;
    }

    public LocalDate getDatecreated() {
        return datecreated;
    }

    public void setDatecreated(LocalDate datecreated) {
        this.datecreated = datecreated;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComment(List<Comment> comments) {
        this.comments = comments;
    }

    //    public MultipartFile getFile() {
//        return file;
//    }
//
//    public void setFile(MultipartFile file) {
//        this.file = file;
//    }

    @Override
    public String toString() {
        return "Video{" +
                "id=" + id +
                ", name='" + title + '\'' +
                ", filepath='" + filepath + '\'' +
                ", datecreated='" + datecreated.toString() + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
