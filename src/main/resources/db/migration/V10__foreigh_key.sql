alter table if exists comments add constraint comments_posts_fk foreign key (post_id) references posts;
alter table if exists comments add constraint comments_users_fk foreign key (user_id) references users;
alter table if exists posts add constraint posts_users_fk foreign key (user_id) references users;
alter table if exists tag_to_post add constraint tag_to_post_fk foreign key (post_id) references posts;
alter table if exists tag_to_post add constraint post_to_tags_fk foreign key (tag_id) references tags;