create table accounts
(
    id      bigint not null generated ALWAYS AS IDENTITY
        primary key,
    balance integer,
    code    varchar(255),
    owner   varchar(255)
);




create table history
(
    id        bigint not null generated ALWAYS AS IDENTITY
        primary key,
    code      varchar(255),
    operation integer
);
