create table author
(
    id          VARCHAR(36)  NOT NULL,
    nickname    VARCHAR(36)  NOT NULL,
    surname     VARCHAR(36),
    email       VARCHAR(36)  NOT NULL,
    phonenumber VARCHAR(36),
    age         VARCHAR(36)  NOT NULL,
    place       VARCHAR(200) NOT NULL,
    constraint author_pk primary key (id)
);

create table xrequest
(
    id         VARCHAR(36)  NOT NULL,
    author_id  VARCHAR(36)  NOT NULL,
    dateTime   VARCHAR(36)  NOT NULL,
    category   varchar(36)  NOT NULL,
    title      varchar(50)  NOT NULL,
    content    varchar(500) NOT NULL,
    photos_url varchar(100) ARRAY,
    tags       varchar(100) ARRAY,
    constraint xrequest_pk primary key (id),
    CONSTRAINT author_id_fk FOREIGN KEY (author_id) REFERENCES author (id)
);
