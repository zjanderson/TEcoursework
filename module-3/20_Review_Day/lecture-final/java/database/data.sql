BEGIN TRANSACTION;

INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');

INSERT INTO list (user_id, name)
VALUES ((SELECT user_id FROM users WHERE username = 'user'), 'Practical List'),
       ((SELECT user_id FROM users WHERE username = 'user'), 'Caffeine List');

INSERT INTO list_item (list_id, item_name)
VALUES ((SELECT list_id FROM list WHERE name = 'Practical List'), 'Milk'),
       ((SELECT list_id FROM list WHERE name = 'Practical List'), 'Bread'),
       ((SELECT list_id FROM list WHERE name = 'Practical List'), 'Eggs');

INSERT INTO list_item (list_id, item_name)
VALUES ((SELECT list_id FROM list WHERE name = 'Caffeine List'), 'Coffee'),
       ((SELECT list_id FROM list WHERE name = 'Caffeine List'), 'Tea');

COMMIT TRANSACTION;
