create table IF NOT EXISTS accounts
(
    id      bigint not null generated ALWAYS AS IDENTITY
        primary key,
    balance integer,
    code    varchar(255),
    owner   varchar(255)
);




create table IF NOT EXISTS history
(
    id        bigint not null generated ALWAYS AS IDENTITY
        primary key,
    code      varchar(255),
    operation integer
);
