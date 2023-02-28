create table IF NOT EXISTS accounts
(
    id      bigint
        primary key,
    balance integer,
    code    varchar(255),
    owner   varchar(255)
);




create table IF NOT EXISTS history
(
    id        bigint
        primary key,
    code      varchar(255),
    operation integer
);
