drop table if exists author cascade;
drop table if exists xrequest cascade;
drop table if exists place cascade;

create table place
(
    id      SERIAL,
    postal  VARCHAR(200) not null,
    city    varchar(200) not null,
    state   varchar(200),
    country varchar(200) not null,
    constraint place_pk primary key (id)
);

/*insert into place(id, city, state, country)
values (1, 'Oostende', 'West-Vlaanderen', 'België');*/

create table author
(
    id          VARCHAR(200),
    family_name VARCHAR(36),
    surname     VARCHAR(36),
    nickname    VARCHAR(36)  NOT NULL,
    email       VARCHAR(36)  NOT NULL,
    phonenumber VARCHAR(36),
    age         VARCHAR(36)  NOT NULL,
    place       VARCHAR(200) NOT NULL,
    constraint author_pk primary key (id),
    constraint place_id_fk foreign key (place) references place (id)
);

create table xrequest
(
    id               VARCHAR(36)  NOT NULL,
    author_id        VARCHAR(36)  NOT NULL,
    datetime_request VARCHAR(36)  NOT NULL,
    category_request VARCHAR(36)  NOT NULL,
    title            VARCHAR(50)  NOT NULL,
    content_request  VARCHAR(500) NOT NULL,
    photos_url       VARCHAR(500) ARRAY,
    tags             VARCHAR(100) ARRAY,
    constraint xrequest_pk primary key (id),
    CONSTRAINT author_id_fk FOREIGN KEY (author_id) REFERENCES author (id)
);

insert into place(postal, city, state, country)
select postal, city, state, country
-- FROM CSVREAD('G:/_development/xrequest/data/place.csv');
FROM CSVREAD('C:/_development/personal/xrequest/data/place.csv');

insert into author(ID, FAMILY_NAME, NICKNAME, SURNAME, EMAIL, PHONENUMBER, AGE, PLACE)
values ('64686c7c-de43-4667-8a13-eb192c0bd080',
        'test user name',
        'test_request_user',
        'surname_testuser',
        'tester@xrequest.be',
        '001 001 001',
        30,
        (select id from place where city = 'Bredene'));

insert into xrequest(id, AUTHOR_ID, DATETIME_REQUEST, category_request, TITLE, content_request, PHOTOS_URL, TAGS)
values ('a90efda9-e231-400b-a24f-0365712b2df0',
        '64686c7c-de43-4667-8a13-eb192c0bd080',
        '29-07-2023 13:30:10',
        'COUPLE4COUPLE',
        'test_title',
        'Lorem ipsum dolor sit amet,
 consectetur adipisicing elit. Architecto distinctio dolorem et
 exercitationem, illo itaque laudantium magni natus nisi nostrum
 numquam quae quaerat quas quis, saepe sequi vero voluptatibus! Repellat.',
        '"https://placehold.co/600x400?text=XRequest", "https://placehold.co/600x400?text=XRequest"',
        '"sex, date", "love", "fuck"');

insert into xrequest(id, AUTHOR_ID, DATETIME_REQUEST, category_request, TITLE, content_request, PHOTOS_URL, TAGS)
values ('a90efda9-e231-400b-a24f-0365712b2df1',
        '64686c7c-de43-4667-8a13-eb192c0bd080',
        '29-07-2021 20:45:10',
        'FEMALE4FEMALE',
        'test_title',
        'Lorem ipsum dolor sit amet,
consectetur adipisicing elit. Architecto distinctio dolorem et
exercitationem, illo itaque laudantium magni natus nisi nostrum
numquam quae quaerat quas quis, saepe sequi vero voluptatibus! Repellat.',
        '"https://placehold.co/600x400?text=XRequest", "https://placehold.co/600x400?text=XRequest"',
        '"sex, date", "love", "fuck"');

insert into xrequest(id, AUTHOR_ID, DATETIME_REQUEST, category_request, TITLE, content_request, PHOTOS_URL, TAGS)
values ('a90efda9-e231-400b-a24f-0365712b2df2',
        '64686c7c-de43-4667-8a13-eb192c0bd080',
        '29-07-2022 08:45:10',
        'MALE4COUPLE',
        'test_title',
        'Lorem ipsum dolor sit amet,
 consectetur adipisicing elit. Architecto distinctio dolorem et
 exercitationem, illo itaque laudantium magni natus nisi nostrum
 numquam quae quaerat quas quis, saepe sequi vero voluptatibus! Repellat.',
        '"https://placehold.co/600x400?text=XRequest", "https://placehold.co/600x400?text=XRequest", "https://placehold.co/600x400?text=XRequest"',
        '"sex, date", "love", "fuck"');

insert into xrequest(id, AUTHOR_ID, DATETIME_REQUEST, category_request, TITLE, content_request, PHOTOS_URL, TAGS)
values ('a90efda9-e231-400b-a24f-0365712b2df3',
        '64686c7c-de43-4667-8a13-eb192c0bd080',
        '29-07-2024 08:45:10',
        'BDSMFETISHKINK',
        'test_title',
        'Lorem ipsum dolor sit amet,
        consectetur adipisicing elit. Architecto distinctio dolorem et
        exercitationem, illo itaque laudantium magni natus nisi nostrum
        numquam quae quaerat quas quis, saepe sequi vero voluptatibus! Repellat.',
        '"https://placehold.co/600x400?text=XRequest", "https://placehold.co/600x400?text=XRequest"',
        '"sex, date", "love", "fuck"');

insert into xrequest(id, AUTHOR_ID, DATETIME_REQUEST, category_request, TITLE, content_request, PHOTOS_URL, TAGS)
values ('a90efda9-e231-400b-a24f-0365712b2df4',
        '64686c7c-de43-4667-8a13-eb192c0bd080',
        '29-07-2024 08:45:10',
        'BDSMFETISHKINK',
        'test_title',
        'Lorem ipsum dolor sit amet,
        consectetur adipisicing elit. Architecto distinctio dolorem et
        exercitationem, illo itaque laudantium magni natus nisi nostrum
        numquam quae quaerat quas quis, saepe sequi vero voluptatibus! Repellat.',
        '"https://placehold.co/600x400?text=XRequest", "https://placehold.co/600x400?text=XRequest"',
        '"sex, date", "love", "fuck"');

insert into xrequest(id, AUTHOR_ID, DATETIME_REQUEST, category_request, TITLE, content_request, PHOTOS_URL, TAGS)
values ('a90efda9-e231-400b-a24f-0365712b2df5',
        '64686c7c-de43-4667-8a13-eb192c0bd080',
        '29-07-2024 08:45:10',
        'BDSMFETISHKINK',
        'test_title',
        'Lorem ipsum dolor sit amet,
        consectetur adipisicing elit. Architecto distinctio dolorem et
        exercitationem, illo itaque laudantium magni natus nisi nostrum
        numquam quae quaerat quas quis, saepe sequi vero voluptatibus! Repellat.',
        '"https://placehold.co/600x400?text=XRequest", "https://placehold.co/600x400?text=XRequest"',
        '"sex, date", "love", "fuck"');

insert into xrequest(id, AUTHOR_ID, DATETIME_REQUEST, category_request, TITLE, content_request, PHOTOS_URL, TAGS)
values ('a90efda9-e231-400b-a24f-0365712b2df6',
        '64686c7c-de43-4667-8a13-eb192c0bd080',
        '29-07-2024 08:45:10',
        'BDSMFETISHKINK',
        'test_title',
        'Lorem ipsum dolor sit amet,
        consectetur adipisicing elit. Architecto distinctio dolorem et
        exercitationem, illo itaque laudantium magni natus nisi nostrum
        numquam quae quaerat quas quis, saepe sequi vero voluptatibus! Repellat.',
        '"https://placehold.co/600x400?text=XRequest", "https://placehold.co/600x400?text=XRequest"',
        '"sex, date", "love", "fuck"');

insert into xrequest(id, AUTHOR_ID, DATETIME_REQUEST, category_request, TITLE, content_request, PHOTOS_URL, TAGS)
values ('a90efda9-e231-400b-a24f-0365712b2df7',
        '64686c7c-de43-4667-8a13-eb192c0bd080',
        '29-07-2024 08:45:10',
        'BDSMFETISHKINK',
        'test_title',
        'Lorem ipsum dolor sit amet,
        consectetur adipisicing elit. Architecto distinctio dolorem et
        exercitationem, illo itaque laudantium magni natus nisi nostrum
        numquam quae quaerat quas quis, saepe sequi vero voluptatibus! Repellat.',
        '"https://placehold.co/600x400?text=XRequest", "https://placehold.co/600x400?text=XRequest"',
        '"sex, date", "love", "fuck"');

insert into xrequest(id, AUTHOR_ID, DATETIME_REQUEST, category_request, TITLE, content_request, PHOTOS_URL, TAGS)
values ('a90efda9-e231-400b-a24f-0365712b2df8',
        '64686c7c-de43-4667-8a13-eb192c0bd080',
        '29-07-2024 08:45:10',
        'BDSMFETISHKINK',
        'test_title',
        'Lorem ipsum dolor sit amet,
        consectetur adipisicing elit. Architecto distinctio dolorem et
        exercitationem, illo itaque laudantium magni natus nisi nostrum
        numquam quae quaerat quas quis, saepe sequi vero voluptatibus! Repellat.',
        '"https://placehold.co/600x400?text=XRequest", "https://placehold.co/600x400?text=XRequest"',
        '"sex, date", "love", "fuck"');

insert into xrequest(id, AUTHOR_ID, DATETIME_REQUEST, category_request, TITLE, content_request, PHOTOS_URL, TAGS)
values ('a90efda9-e231-400b-a24f-0365712b2df9',
        '64686c7c-de43-4667-8a13-eb192c0bd080',
        '29-07-2024 08:45:10',
        'BDSMFETISHKINK',
        'test_title',
        'Lorem ipsum dolor sit amet,
        consectetur adipisicing elit. Architecto distinctio dolorem et
        exercitationem, illo itaque laudantium magni natus nisi nostrum
        numquam quae quaerat quas quis, saepe sequi vero voluptatibus! Repellat.',
        '"https://placehold.co/600x400?text=XRequest", "https://placehold.co/600x400?text=XRequest"',
        '"sex, date", "love", "fuck"');