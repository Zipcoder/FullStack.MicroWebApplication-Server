CREATE SCHEMA GROUP4;

CREATE TABLE GROUP4.COMMENTS (
  comment_id INT AUTO_INCREMENT  PRIMARY KEY,
  comment_text VARCHAR(250),
  video_id VARCHAR(250),
  user_id VARCHAR(250),
  create_date DATE
);

CREATE TABLE GROUP4.USERS (
  user_id VARCHAR PRIMARY KEY,
  first_name VARCHAR(250),
  last_name VARCHAR(250),
  password VARCHAR(250),
  log_in_time DATE,
  logged_in BOOLEAN
);

CREATE TABLE GROUP4.VIDEOS (
  video_id INTEGER PRIMARY KEY,
  video_name VARCHAR(250),
  video_bytes BLOB,
  user_id VARCHAR(250),
  video_path varchar(250),
  video_size INTEGER,
  video_type VARCHAR(250)
);
