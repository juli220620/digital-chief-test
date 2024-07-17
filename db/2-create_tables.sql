create type model.industry as enum
    ( 'FINTECH', 'OUTSOURCE', 'OUTSTAFF', 'GAMING', 'MANUFACTURING', 'LOGISTICS', 'OTHER');

create table model.company (
    id bigserial not null primary key,
    name text not null,
    capitalisation double precision not null default 0.0,
    industry industry not null default 'OTHER'
);

create table model.employee (
    id bigserial not null primary key,
    company_id bigserial not null references model.company(id),
    name text not null,
    department text not null,
    salary double precision not null
);