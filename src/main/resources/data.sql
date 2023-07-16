insert into author(ID, NICKNAME, SURNAME, EMAIL, PHONENUMBER, AGE, PLACE)
values ('a90efda9-e231-400b-a24f-0365712b2df0',
        'test_request_user',
        'surname_testuser',
        'tester@xrequest.be',
        '001 001 001',
        30,
        'Brussels, Belgium');

insert into xrequest(ID, AUTHOR_ID, DATETIME, CATEGORY, TITLE, CONTENT, PHOTOS_URL, TAGS)
values ('b2a918b7-1e1d-4098-abc8-242bf39c6a20',
        'a90efda9-e231-400b-a24f-0365712b2df0',
        '14-01-2017 11:42:32',
        'COUPLE4COUPLE',
        'test_title',
        'test_content',
        array ['test/url', 'test/url2'],
        array ['sex, date', 'love', 'fuck']);