CREATE TABLE usuarios(

    id bigint not null auto_increment,
    nombre varchar(150) not null,
    email varchar(150) not null,
    pass varchar(300) not null,

    PRIMARY KEY(id)
);