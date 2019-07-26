
INSERT INTO GROUP4.VIDEOS (video_id, video_name, video_bytes, user_id, video_path,video_size,video_type)
VALUES ('32', 'SampleVideo_1280x720_1mb.mp4', null, 'abc','https://video-new-tube.herokuapp.com/videos/32',1055736,'video/mp4');

INSERT INTO GROUP4.USERS (user_id, first_name, last_name, password, logged_in, log_in_time)
VALUES ('abc', 'TOM', 'JERRY', 'TEXT', false, now());

INSERT INTO GROUP4.COMMENTS(comment_id,comment_text,video_id,user_id,create_date)
VALUES (3,'second Comment from API',1,'abc', now());
