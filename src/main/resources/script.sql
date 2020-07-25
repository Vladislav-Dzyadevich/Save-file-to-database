# create table user
# (
#     id       bigint       not null
#         primary key,
#     email    varchar(255) null,
#     login    varchar(255) null,
#     name     varchar(255) null,
#     password varchar(255) null,
#     role     varchar(255) null,
#     sur_name varchar(255) null
# )
#     engine = MyISAM;
#
# create table files
# (
#     id        bigint       not null
#         primary key,
#     content   longblob     null,
#     file_name varchar(255) null,
#     status    varchar(255) null,
#     size      bigint       null,
#     user_id   bigint       not null
# )
#     engine = MyISAM;
#
# create index FKdgr5hx49828s5vhjo1s8q3wdp
#     on files (user_id);