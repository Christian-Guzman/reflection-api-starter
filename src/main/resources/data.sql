INSERT INTO users (username, password)
VALUES ('student', '{noop}testpass'),
('student2', '{noop}testpass'),
('admin', '{noop}testpass')
  ON CONFLICT DO NOTHING;

INSERT INTO authorities (username, authority)
VALUES ('student', 'ROLE_STUDENT'),
('student2', 'ROLE_STUDENT'),
('admin', 'ROLE_ADMIN')
  ON CONFLICT DO NOTHING;