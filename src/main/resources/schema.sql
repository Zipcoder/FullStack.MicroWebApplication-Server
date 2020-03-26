CREATE TABLE videos
(
    videoID int NOT NULL,
    videoEtag varchar(100) NOT NULL,
    fileName varchar(100) NOT NULL,
    videoURL varchar(150) NOT NULL,
    thumbnailURL varchar(150) NOT NULL,
    PRIMARY KEY (videoID)
);
