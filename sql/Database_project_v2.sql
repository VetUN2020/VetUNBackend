drop table if exists CITAS;

drop table if exists COMENTARIOS_MEDICOS;

drop table if exists COMENTARIOS_VETERINARIA;

drop table if exists COSTO_ATENCION;

drop table if exists DUENOS;

drop table if exists MASCOTAS;

drop table if exists MEDICOS;

drop table if exists PREGUNTAS;

drop table if exists RESPUESTAS;

drop table if exists VACUNACION;

drop table if exists VETERINARIA;

/*==============================================================*/
/* Table: CITAS                                                 */
/*==============================================================*/
create table CITAS
(
   ID_CITA              int not null,
   ID_VETERINARIA       int not null,
   CEDULA_DUENO         varchar(20) not null,
   ID_MASCOTA           int not null,
   FECHA_CITA           datetime not null,
   TIPO_CITA            varchar(150) not null,
   primary key (ID_CITA)
);

/*==============================================================*/
/* Table: COMENTARIOS_MEDICOS                                   */
/*==============================================================*/
create table COMENTARIOS_MEDICOS
(
   CEDULA_DUENO         varchar(20) not null,
   CEDULA_MEDICO        varchar(150) not null,
   ID_COMENTARIO_M      int not null,
   COMENTARIO_M         varchar(150),
   PUNTUACION_M         float(8) not null,
   primary key (CEDULA_DUENO, CEDULA_MEDICO, ID_COMENTARIO_M)
);

/*==============================================================*/
/* Table: COMENTARIOS_VETERINARIA                               */
/*==============================================================*/
create table COMENTARIOS_VETERINARIA
(
   CEDULA_DUENO         varchar(20) not null,
   ID_VETERINARIA       int not null,
   ID_COMENTARIO_V      int not null,
   COMENTARIO_V         varchar(150),
   PUNTUACION_V         float(8) not null,
   primary key (CEDULA_DUENO, ID_VETERINARIA, ID_COMENTARIO_V)
);

/*==============================================================*/
/* Table: COSTO_ATENCION                                        */
/*==============================================================*/
create table COSTO_ATENCION
(
   ID_COSTO             int not null,
   CEDULA_MEDICO        varchar(150) not null,
   DESCRIPCION_COSTO    varchar(150) not null,
   COSTO                int not null,
   primary key (CEDULA_MEDICO, ID_COSTO)
);

/*==============================================================*/
/* Table: DUENOS                                                */
/*==============================================================*/
create table DUENOS
(
   CEDULA_DUENO         varchar(20) not null,
   NOMBRE_DUENO         varchar(150) not null,
   APELLIDO_DUENO       varchar(150) not null,
   TELEFONO_DUENO       int not null,
   DIRECCION_CASA       varchar(150) not null,
   CORREO_ELECTRONICO   varchar(150) not null,
   CONTRASENIA_DUENO    varchar(150) not null,
   primary key (CEDULA_DUENO)
);

/*==============================================================*/
/* Table: MASCOTAS                                              */
/*==============================================================*/
create table MASCOTAS
(
   ID_MASCOTA           int not null,
   CEDULA_DUENO         varchar(20) not null,
   NOMBRE_MASCOTA       varchar(150) not null,
   ESPECIE              varchar(150) not null,
   RAZA                 varchar(150) not null,
   primary key (CEDULA_DUENO, ID_MASCOTA)
);

/*==============================================================*/
/* Table: MEDICOS                                               */
/*==============================================================*/
create table MEDICOS
(
   CEDULA_MEDICO        varchar(150) not null,
   ID_VETERINARIA       int,
   NOMBRE_MEDICO        varchar(150) not null,
   APELLIDO_MEDICO      varchar(150) not null,
   DIRECCION_RESIDENCIA varchar(150) not null,
   TELEFONO_MEDICO      int not null,
   MATRICULA_PROFESIONAL varchar(150) not null,
   CORREO_MEDICO        varchar(150) not null,
   CONTRASENIA_MEDICO   varchar(150) not null,
   primary key (CEDULA_MEDICO)
);

/*==============================================================*/
/* Table: PREGUNTAS                                             */
/*==============================================================*/
create table PREGUNTAS
(
   CEDULA_DUENO         varchar(20) not null,
   ID_PREGUNTA          int not null,
   PREGUNTA             longtext not null,
   primary key (CEDULA_DUENO, ID_PREGUNTA)
);

/*==============================================================*/
/* Table: RESPUESTAS                                            */
/*==============================================================*/
create table RESPUESTAS
(
   CEDULA_MEDICO        varchar(150) not null,
   CEDULA_DUENO         varchar(20) not null,
   ID_PREGUNTA          int not null,
   ID_RESPUESTA         int not null,
   RESPUESTA            varchar(150) not null,
   primary key (CEDULA_MEDICO, CEDULA_DUENO, ID_PREGUNTA, ID_RESPUESTA)
);

/*==============================================================*/
/* Table: VACUNACION                                            */
/*==============================================================*/
create table VACUNACION
(
   ID_VACUNA            int not null,
   CEDULA_DUENO         varchar(20) not null,
   ID_MASCOTA           int not null,
   CEDULA_MEDICO        varchar(150) not null,
   DESCRIPCION_VACUNA   varchar(150) not null,
   FECHA_VACUNA         varchar(150) not null,
   primary key (ID_VACUNA)
);

/*==============================================================*/
/* Table: VETERINARIA                                           */
/*==============================================================*/
create table VETERINARIA
(
   ID_VETERINARIA       int not null,
   NOMBRE_VETERINARIA   varchar(150) not null,
   DIRECCION_VETERINARIA varchar(150) not null,
   TELEFONO_VETERINARIA int not null,
   LOCALIZACION         varchar(150) not null,
   TIPO_VETERINARIA     varchar(150) not null,
   primary key (ID_VETERINARIA)
);

alter table CITAS add constraint FK_ATENDIDO foreign key (CEDULA_DUENO, ID_MASCOTA)
      references MASCOTAS (CEDULA_DUENO, ID_MASCOTA) on delete restrict on update restrict;

alter table CITAS add constraint FK_ATIENDE foreign key (ID_VETERINARIA)
      references VETERINARIA (ID_VETERINARIA) on delete restrict on update restrict;

alter table COMENTARIOS_MEDICOS add constraint FK_CALIFICACION_M foreign key (CEDULA_MEDICO)
      references MEDICOS (CEDULA_MEDICO) on delete restrict on update restrict;

alter table COMENTARIOS_MEDICOS add constraint FK_CALIFICA_M foreign key (CEDULA_DUENO)
      references DUENOS (CEDULA_DUENO) on delete restrict on update restrict;

alter table COMENTARIOS_VETERINARIA add constraint FK_CALIFICACION_V foreign key (ID_VETERINARIA)
      references VETERINARIA (ID_VETERINARIA) on delete restrict on update restrict;

alter table COMENTARIOS_VETERINARIA add constraint FK_CALIFICA_V foreign key (CEDULA_DUENO)
      references DUENOS (CEDULA_DUENO) on delete restrict on update restrict;

alter table COSTO_ATENCION add constraint FK_PRECIO foreign key (CEDULA_MEDICO)
      references MEDICOS (CEDULA_MEDICO) on delete restrict on update restrict;

alter table MASCOTAS add constraint FK_DUENO foreign key (CEDULA_DUENO)
      references DUENOS (CEDULA_DUENO) on delete restrict on update restrict;

alter table MEDICOS add constraint FK_ASOCIADO foreign key (ID_VETERINARIA)
      references VETERINARIA (ID_VETERINARIA) on delete restrict on update restrict;

alter table PREGUNTAS add constraint FK_PREGUNTA foreign key (CEDULA_DUENO)
      references DUENOS (CEDULA_DUENO) on delete restrict on update restrict;

alter table RESPUESTAS add constraint FK_RESPONDE foreign key (CEDULA_MEDICO)
      references MEDICOS (CEDULA_MEDICO) on delete restrict on update restrict;

alter table RESPUESTAS add constraint FK_RESPUESTA foreign key (CEDULA_DUENO, ID_PREGUNTA)
      references PREGUNTAS (CEDULA_DUENO, ID_PREGUNTA) on delete restrict on update restrict;

alter table VACUNACION add constraint FK_VACUNACION foreign key (CEDULA_DUENO, ID_MASCOTA)
      references MASCOTAS (CEDULA_DUENO, ID_MASCOTA) on delete restrict on update restrict;

alter table VACUNACION add constraint FK_VACUNA_MED foreign key (CEDULA_MEDICO)
      references MEDICOS (CEDULA_MEDICO) on delete restrict on update restrict;

