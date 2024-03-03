INSERT INTO tb_user (name, email, password) VALUES ('Alex Brown', 'alex@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');
INSERT INTO tb_user (name, email, password) VALUES ('Bob Brown','bob@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');
INSERT INTO tb_user (name, email, password) VALUES ('Maria Green','maria@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');

INSERT INTO tb_role (authority) VALUES ('ROLE_STUDENT');
INSERT INTO tb_role (authority) VALUES ('ROLE_INSTRUCTOR');
INSERT INTO tb_role (authority) VALUES ('ROLE_ADMIN');

INSERT INTO tb_user_role (user_id, role_id) VALUES (1, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 2);
INSERT INTO tb_user_role (user_id, role_id) VALUES (3, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (3, 2);
INSERT INTO tb_user_role (user_id, role_id) VALUES (3, 3);

INSERT INTO tb_notification (text, moment, read, route, user_id) VALUES ('Lorem ipsum', TIMESTAMP WITH TIME ZONE '2020-07-13T20:50:07.12345Z', false, '...', 1);
INSERT INTO tb_notification (text, moment, read, route, user_id) VALUES ('Lorem ipsum', TIMESTAMP WITH TIME ZONE '2020-08-13T20:50:07.12345Z', true, '...', 2);

INSERT INTO tb_course (name, img_uri, img_gray_uri) VALUES ('Bootcamp HTML', 'https://c.pxhere.com/images/e7/04/ae65a1f30d7b6c505ad4eb7781bf-1449493.jpg!d', 'https://www.publicdomainpictures.net/pictures/190000/velka/travel-background-1469438300Bbk.jpg');

INSERT INTO tb_offer (edition, start_moment, end_moment, course_id) VALUES ('1.0', TIMESTAMP WITH TIME ZONE '2020-07-13T20:50:07.12345Z', TIMESTAMP WITH TIME ZONE '2021-07-13T20:50:07.12345Z', 1);
INSERT INTO tb_offer (edition, start_moment, end_moment, course_id) VALUES ('2.0', TIMESTAMP WITH TIME ZONE '2020-10-13T20:50:07.12345Z', TIMESTAMP WITH TIME ZONE '2021-10-13T20:50:07.12345Z', 1);

INSERT INTO tb_resource (title, description, position, img_uri, type, offer_id) VALUES ('Trilha HTML', 'Trilha principal do curso', 1, 'https://www.publicdomainpictures.net/pictures/190000/velka/travel-background-1469438300Bbk.jpg', 1, 1);
INSERT INTO tb_resource (title, description, position, img_uri, type, offer_id) VALUES ('Fórum', 'Tire suas dúvidas', 2, 'https://www.publicdomainpictures.net/pictures/190000/velka/travel-background-1469438300Bbk.jpg', 2, 1);
INSERT INTO tb_resource (title, description, position, img_uri, type, offer_id) VALUES ('Lives', 'Lives exclusivas para a turma', 3, 'https://www.publicdomainpictures.net/pictures/190000/velka/travel-background-1469438300Bbk.jpg', 0, 1);

INSERT INTO tb_section (title, description, position, img_uri, resource_id, prerequisite_id) VALUES ('Capítulo 1', 'Neste capítulo vamos começar', 1, 'https://www.publicdomainpictures.net/pictures/190000/velka/travel-background-1469438300Bbk.jpg', 1, null)
INSERT INTO tb_section (title, description, position, img_uri, resource_id, prerequisite_id) VALUES ('Capítulo 2', 'Neste capítulo vamos continuar', 2, 'https://www.publicdomainpictures.net/pictures/190000/velka/travel-background-1469438300Bbk.jpg', 1, 1)
INSERT INTO tb_section (title, description, position, img_uri, resource_id, prerequisite_id) VALUES ('Capítulo 3', 'Neste capítulo vamos finalizar', 3, 'https://www.publicdomainpictures.net/pictures/190000/velka/travel-background-1469438300Bbk.jpg', 1, 2)

INSERT INTO tb_enrollment (user_id, offer_id, enroll_moment, refund_moment, available, only_update) VALUES (1, 1, '2020-07-13T13:00:07.12345Z', null, true, false)
INSERT INTO tb_enrollment (user_id, offer_id, enroll_moment, refund_moment, available, only_update) VALUES (2, 1, '2020-07-13T13:00:07.12345Z', null, true, false)

INSERT INTO tb_lesson (title, position, section_id) VALUES ('Aula 1 do capítulo', 1, 1)
INSERT INTO tb_content (id, text_content, video_uri) VALUES (1, 'Material de apoio', 'https://www.youtube.com/watch?v=D4frmIHAxEY')

INSERT INTO tb_lesson (title, position, section_id) VALUES ('Aula 2 do capítulo', 2, 1)
INSERT INTO tb_content (id, text_content, video_uri) VALUES (2, '', 'https://www.youtube.com/watch?v=D4frmIHAxEY')

INSERT INTO tb_lesson (title, position, section_id) VALUES ('Aula 3 do capítulo', 3, 1)
INSERT INTO tb_content (id, text_content, video_uri) VALUES (3, '', 'https://www.youtube.com/watch?v=D4frmIHAxEY')

INSERT INTO tb_lesson (title, position, section_id) VALUES ('Tarefa do capítulo 1', 4, 1)
INSERT INTO tb_task (id, description, question_count, approval_count, weight, due_date) VALUES (4, 'Fazer trabalho', 5, 4, 1.0, '2020-07-13T13:00:07.12345Z')

INSERT INTO tb_lessons_done (lesson_id, user_id, offer_id) VALUES (1, 1, 1)
INSERT INTO tb_lessons_done (lesson_id, user_id, offer_id) VALUES (2, 1, 1)
