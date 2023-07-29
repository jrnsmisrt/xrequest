drop table if exists author cascade;
drop table if exists xrequest cascade;
drop table if exists place cascade;

create table place
(
    id      integer      not null,
    city    varchar(200) not null,
    state   varchar(200),
    country varchar(200) not null,
    constraint place_pk primary key (id)
);

insert into place(id, city, state, country)
values (1, 'Oostende', 'West-Vlaanderen', 'België');

create table author
(
    id          VARCHAR(36) NOT NULL,
    family_name VARCHAR(36),
    surname     VARCHAR(36),
    nickname    VARCHAR(36) NOT NULL,
    email       VARCHAR(36) NOT NULL,
    phonenumber VARCHAR(36),
    age         VARCHAR(36) NOT NULL,
    place       INTEGER     NOT NULL,
    constraint author_pk primary key (id),
    constraint place_id_fk foreign key (place) references place (id)
);

create table xrequest
(
    id               VARCHAR(36)  NOT NULL,
    author_id        VARCHAR(36)  NOT NULL,
    datetime_request         VARCHAR(36)  NOT NULL,
    category_request VARCHAR(36)  NOT NULL,
    title            VARCHAR(50)  NOT NULL,
    content_request  VARCHAR(500) NOT NULL,
    photos_url       VARCHAR(100) ARRAY,
    tags             VARCHAR(100) ARRAY,
    constraint xrequest_pk primary key (id),
    CONSTRAINT author_id_fk FOREIGN KEY (author_id) REFERENCES author (id)
);

insert into author(ID, FAMILY_NAME, NICKNAME, SURNAME, EMAIL, PHONENUMBER, AGE, PLACE)
values ('64686c7c-de43-4667-8a13-eb192c0bd080',
        'test user name',
        'test_request_user',
        'surname_testuser',
        'tester@xrequest.be',
        '001 001 001',
        30,
        1);

insert into xrequest(id, AUTHOR_ID, DATETIME_REQUEST, category_request, TITLE, content_request, PHOTOS_URL, TAGS)
values ('a90efda9-e231-400b-a24f-0365712b2df0',
        '64686c7c-de43-4667-8a13-eb192c0bd080',
        '29-07-2023 08:45:10',
        'COUPLE4COUPLE',
        'test_title',
        'test_content',
        array ['test/url', 'test/url2'],
        array ['sex, date', 'love', 'fuck']);