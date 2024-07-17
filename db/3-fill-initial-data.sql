insert into model.company(name, capitalisation, industry)
values ('Good Bank', 2.5, 'FINTECH'),
       ('Nice Gaming Studio', 1.5, 'GAMING'),
       ('Resourceful outsource', 1.8, 'OUTSOURCE'),
       ('Big Ships Corporation', 2.4, 'LOGISTICS');

insert into model.employee(company_id, name, department, salary)
values (1, 'Svetlana Ivanova', 'Management', 3000.),
       (1, 'Pierre Baudin', 'IT', 2500.),
       (2, 'Anne Boulogne', 'Design', 2800.),
       (2, 'Ivan Nemov', 'IT', 3500.),
       (2, 'Peter Schultz', 'Management', 3000.),
       (3, 'Larry Jonson', 'Management', 2000.),
       (3, 'Patricia Kaas', 'IT', 1500.),
       (3, 'Helene Montes', 'IT', 1500.),
       (4, ' Rosmunda Salim', 'Management', 2500.),
       (4, 'Gabriel Nazario', 'Production', 2000.),
       (4, 'Eduardo Ferraro', 'Production', 2000.);
