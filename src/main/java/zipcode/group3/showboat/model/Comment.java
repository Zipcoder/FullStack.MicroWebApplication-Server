package zipcode.group3.showboat.model;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;


@Entity
@Table(name= "comments")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String comment;

    @ManyToOne//(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name="videoid",nullable=false)
    @JsonIgnoreProperties("comments")
    private Video video;


    public Comment() {
    }

    public Comment(String comment) {
        this.comment = comment;
    }



//    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "MM-dd-yyyy")
//    private DataFormat dateCreated;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Video getVideo() {
        return video;
    }

    public void setVideo(Video video) {
        this.video = video;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", videoid=" + video.getId() +
                ", comment='" + comment + '\'' +
                '}';
    }

}

