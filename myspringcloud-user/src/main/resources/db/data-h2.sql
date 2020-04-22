DELETE FROM wt_user;
INSERT INTO wt_user (id, name, age, email) VALUES
(1, 'Jone', 18, 'test1@baomidou.com'),
(2, 'Jack', 20, 'test2@baomidou.com'),
(3, 'Tom', 28, 'test3@baomidou.com'),
(4, 'Exception', 21, 'test4@baomidou.com'),
(5, 'Billie', 24, 'test5@baomidou.com');

delete from wt_order;
INSERT INTO wt_order (id, user_id) VALUES
(1, 1),
(2, 1),
(3, 2),
(4, 2),
(5, 2),
(6, 2),
(7, 3),
(8, 5);

delete from wt_menu;
INSERT INTO wt_menu (menu_id, parent_menu_id) VALUES
(1, 0),
(2, 1),
(3, 1),
(4, 2),
(5, 2),
(6, 3),
(7, 4),
(8, 7),
(9, 8);