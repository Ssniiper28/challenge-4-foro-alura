CREATE TABLE topicos(

    id bigint not null auto_increment,
    titulo varchar(150) not null,
    mensaje varchar(250) not null,
    fecha_creacion date not null,
    estatus varchar(100) not null,
    id_autor bigint not null,
    id_curso bigint not null,

    PRIMARY KEY(id),

    constraint fk_usuarios_id_autor foreign key (id_autor) references usuarios(id),
    constraint fk_cursos_id_curso foreign key (id_curso) references cursos(id)

);