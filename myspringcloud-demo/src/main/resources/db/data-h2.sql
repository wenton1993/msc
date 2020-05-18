delete from wt_user;
insert into wt_user (id, name, age, email) values
(1, 'Jone', 18, 'test1@baomidou.com'),
(2, 'Jack', 20, 'test2@baomidou.com'),
(3, 'Tom', 28, 'test3@baomidou.com'),
(4, 'Exception', 21, 'test4@baomidou.com'),
(5, 'Billie', 24, 'test5@baomidou.com'),
(6, 'Test', 6, 'test@baomidou.com'),
(7, 'Test', 7, 'test@baomidou.com'),
(8, 'Test', 8, 'test@baomidou.com'),
(9, 'Test', 9, 'test@baomidou.com'),
(10, 'Test', 10, 'test@baomidou.com'),
(11, 'Test', 11, 'test@baomidou.com');

delete from wt_order;
insert into wt_order (id, user_id, amount) values
(1, 1, 10),
(2, 1, 10),
(3, 2, 10),
(4, 2, 10),
(5, 2, 10),
(6, 2, 10),
(7, 3, 10),
(8, 5, 10);

delete from wt_menu;
insert into wt_menu (id, parent_id) values
(1, 0),
(2, 1),
(3, 1),
(4, 2),
(5, 2),
(6, 3),
(7, 4),
(8, 7),
(9, 8);