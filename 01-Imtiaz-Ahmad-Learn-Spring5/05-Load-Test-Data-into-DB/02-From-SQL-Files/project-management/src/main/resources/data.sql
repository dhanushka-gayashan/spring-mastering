-- Clean Old Data --
-- SET REFERENTIAL_INTEGRITY FALSE;
-- TRUNCATE TABLE project_employee;
-- TRUNCATE TABLE employee;
-- TRUNCATE TABLE project;
-- SET REFERENTIAL_INTEGRITY FALSE;

INSERT INTO employee (employee_id, first_name, last_name, email) VALUES (1, 'Dhanushka', 'Gayashan', 'dhanu@test.com');
INSERT INTO employee (employee_id, first_name, last_name, email) VALUES (2, 'Chamari', 'Nimalka', 'chamari@test.com');
INSERT INTO employee (employee_id, first_name, last_name, email) VALUES (3, 'Jack', 'Jil', 'jack@test.com');

INSERT INTO project (project_id, name, stage, description) VALUES (100, 'Coding', 'COMPLETED', 'Coding phrase is completed');
INSERT INTO project (project_id, name, stage, description) VALUES (200, 'DevOps', 'INPRPGRESS', 'Environment has been setup and working on code deployment');
INSERT INTO project (project_id, name, stage, description) VALUES (300, 'Testing', 'NOTSTARTED', 'Testing will need to start after deployment');

INSERT INTO project_employee (project_id, employee_id) VALUES (100, 1);
INSERT INTO project_employee (project_id, employee_id) VALUES (100, 2);
INSERT INTO project_employee (project_id, employee_id) VALUES (200, 2);
INSERT INTO project_employee (project_id, employee_id) VALUES (200, 3);
INSERT INTO project_employee (project_id, employee_id) VALUES (300, 3);
INSERT INTO project_employee (project_id, employee_id) VALUES (300, 1);

