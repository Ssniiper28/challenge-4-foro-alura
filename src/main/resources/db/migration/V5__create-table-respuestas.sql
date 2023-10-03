CREATE TABLE respuestas(

    id bigint not null auto_increment,
    mensaje varchar(1500) not null,
    id_topico bigint not null,
    fechaCreacion date not null,
    id_autor_mensaje bigint not null,
    solucion tinyint not null,

    PRIMARY KEY(id),

    constraint fk_topicos_id_topico foreign key (id_topico) references topicos(id),
    constraint fk_usuarios_id_autor_mensaje foreign key (id_autor_mensaje) references usuarios(id)
);