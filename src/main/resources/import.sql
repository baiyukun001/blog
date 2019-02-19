INSERT INTO user (id, username, password, name, email) VALUES (1, 'admin', '$2a$10$tPt7vy5OJFH6GBswLVw..OAyWXnF0Guj/b.HMCDDdm/dnC9dF/oi.', '管理员', 'i-am-green@163.com');
INSERT INTO user (id, username, password, name, email) VALUES (2, 'anonymous', '$2a$10$tPt7vy5OJFH6GBswLVw..OAyWXnF0Guj/b.HMCDDdm/dnC9dF/oi.', '匿名', 'anonymous@non.com');
INSERT INTO user (id, username, password, name, email) VALUES (3, 'baiyukun', '$2a$10$tPt7vy5OJFH6GBswLVw..OAyWXnF0Guj/b.HMCDDdm/dnC9dF/oi.', '白煜琨', '412627624@qq.com');
INSERT INTO user (id, username, password, name, email) VALUES (4, 'liuhui', '$2a$10$tPt7vy5OJFH6GBswLVw..OAyWXnF0Guj/b.HMCDDdm/dnC9dF/oi.', '刘慧', '1234567@qq.com');

INSERT INTO authority (id, name) VALUES (1, 'ROLE_ADMIN');
INSERT INTO authority (id, name) VALUES (2, 'ROLE_USER');

INSERT INTO user_authority (user_id, authority_id) VALUES (1, 1);
INSERT INTO user_authority (user_id, authority_id) VALUES (2, 2);
INSERT INTO user_authority (user_id, authority_id) VALUES (3, 2);
INSERT INTO user_authority (user_id, authority_id) VALUES (4, 2);
