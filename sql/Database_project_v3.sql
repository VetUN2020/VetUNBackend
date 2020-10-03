drop table if exists CITA;

drop table if exists COMENTARIO_MEDICO;

drop table if exists COMENTARIO_VETERINARIA;

drop table if exists COSTO_ATENCION;

drop table if exists DUENO;

drop table if exists MASCOTA;

drop table if exists MEDICO;

drop table if exists PREGUNTA;

drop table if exists RESPUESTA;

drop table if exists VACUNACION;

drop table if exists VETERINARIA;

/*==============================================================*/
/* Table: CITA                                                  */
/*==============================================================*/
create table CITA
(
   ID_CITA              int not null auto_increment,
   ID_VETERINARIA       int not null,
   ID_MASCOTA           int not null,
   FECHA_CITA           date not null,
   TIPO_CITA            varchar(150) not null,
   primary key (ID_CITA)
);

/*==============================================================*/
/* Table: COMENTARIO_MEDICO                                     */
/*==============================================================*/
create table COMENTARIO_MEDICO
(
   ID_COMENTARIO_M      int not null auto_increment,
   ID_DUENO             int not null,
   ID_MEDICO            int not null,
   COMENTARIO_M         varchar(150),
   PUNTUACION_M         float(8) not null,
   primary key (ID_COMENTARIO_M)
);

/*==============================================================*/
/* Table: COMENTARIO_VETERINARIA                                */
/*==============================================================*/
create table COMENTARIO_VETERINARIA
(
   ID_COMENTARIO_V      int not null auto_increment,
   ID_VETERINARIA       int not null,
   ID_DUENO             int not null,
   COMENTARIO_V         varchar(150),
   PUNTUACION_V         float(8) not null,
   primary key (ID_COMENTARIO_V)
);

/*==============================================================*/
/* Table: COSTO_ATENCION                                        */
/*==============================================================*/
create table COSTO_ATENCION
(
   ID_COSTO             int not null auto_increment,
   ID_MEDICO            int not null,
   DESCRIPCION_COSTO    varchar(150) not null,
   COSTO                int not null,
   primary key (ID_COSTO)
);

/*==============================================================*/
/* Table: DUENO                                                 */
/*==============================================================*/
create table DUENO
(
   ID_DUENO             int not null auto_increment,
   CEDULA_DUENO         varchar(20) not null,
   NOMBRE_DUENO         varchar(150) not null,
   APELLIDO_DUENO       varchar(150) not null,
   TELEFONO_DUENO       int not null,
   DIRECCION_CASA       varchar(150) not null,
   CORREO_ELECTRONICO   varchar(150) not null,
   CONTRASENIA_DUENO    varchar(150) not null,
   primary key (ID_DUENO)
);

/*==============================================================*/
/* Table: MASCOTA                                               */
/*==============================================================*/
create table MASCOTA
(
   ID_MASCOTA           int not null auto_increment,
   ID_DUENO             int not null,
   NOMBRE_MASCOTA       varchar(150) not null,
   ESPECIE              varchar(150) not null,
   RAZA                 varchar(150) not null,
   primary key (ID_MASCOTA)
);

/*==============================================================*/
/* Table: MEDICO                                                */
/*==============================================================*/
create table MEDICO
(
   ID_MEDICO            int not null auto_increment,
   ID_VETERINARIA       int,
   CEDULA_MEDICO        varchar(150) not null,
   NOMBRE_MEDICO        varchar(150) not null,
   APELLIDO_MEDICO      varchar(150) not null,
   DIRECCION_RESIDENCIA varchar(150) not null,
   TELEFONO_MEDICO      int not null,
   MATRICULA_PROFESIONAL varchar(150) not null,
   CORREO_MEDICO        varchar(150) not null,
   CONTRASENIA_MEDICO   varchar(150) not null,
   primary key (ID_MEDICO)
);

/*==============================================================*/
/* Table: PREGUNTA                                              */
/*==============================================================*/
create table PREGUNTA
(
   ID_PREGUNTA          int not null auto_increment,
   ID_DUENO             int not null,
   PREGUNTA             longtext not null,
   primary key (ID_PREGUNTA)
);

/*==============================================================*/
/* Table: RESPUESTA                                             */
/*==============================================================*/
create table RESPUESTA
(
   ID_RESPUESTA         int not null auto_increment,
   ID_PREGUNTA          int not null,
   ID_MEDICO            int not null,
   RESPUESTA            varchar(150) not null,
   primary key (ID_RESPUESTA)
);

/*==============================================================*/
/* Table: VACUNACION                                            */
/*==============================================================*/
create table VACUNACION
(
   ID_VACUNA            int not null auto_increment,
   ID_MASCOTA           int not null,
   ID_MEDICO            int not null,
   DESCRIPCION_VACUNA   varchar(150) not null,
   FECHA_VACUNA         date not null,
   primary key (ID_VACUNA)
);

/*==============================================================*/
/* Table: VETERINARIA                                           */
/*==============================================================*/
create table VETERINARIA
(
   ID_VETERINARIA       int not null auto_increment,
   NOMBRE_VETERINARIA   varchar(150) not null,
   DIRECCION_VETERINARIA varchar(150) not null,
   TELEFONO_VETERINARIA int not null,
   LOCALIZACION         varchar(150) not null,
   TIPO_VETERINARIA     varchar(150) not null,
   primary key (ID_VETERINARIA)
);

alter table CITA add constraint FK_ATENDIDO foreign key (ID_MASCOTA)
      references MASCOTA (ID_MASCOTA) on delete restrict on update restrict;

alter table CITA add constraint FK_ATIENDE foreign key (ID_VETERINARIA)
      references VETERINARIA (ID_VETERINARIA) on delete restrict on update restrict;

alter table COMENTARIO_MEDICO add constraint FK_CALIFICACION_M foreign key (ID_MEDICO)
      references MEDICO (ID_MEDICO) on delete restrict on update restrict;

alter table COMENTARIO_MEDICO add constraint FK_CALIFICA_M foreign key (ID_DUENO)
      references DUENO (ID_DUENO) on delete restrict on update restrict;

alter table COMENTARIO_VETERINARIA add constraint FK_CALIFICACION_V foreign key (ID_VETERINARIA)
      references VETERINARIA (ID_VETERINARIA) on delete restrict on update restrict;

alter table COMENTARIO_VETERINARIA add constraint FK_CALIFICA_V foreign key (ID_DUENO)
      references DUENO (ID_DUENO) on delete restrict on update restrict;

alter table COSTO_ATENCION add constraint FK_PRECIO foreign key (ID_MEDICO)
      references MEDICO (ID_MEDICO) on delete restrict on update restrict;

alter table MASCOTA add constraint FK_DUENO_DE foreign key (ID_DUENO)
      references DUENO (ID_DUENO) on delete restrict on update restrict;

alter table MEDICO add constraint FK_ASOCIADO foreign key (ID_VETERINARIA)
      references VETERINARIA (ID_VETERINARIA) on delete restrict on update restrict;

alter table PREGUNTA add constraint FK_PREGUNTA foreign key (ID_DUENO)
      references DUENO (ID_DUENO) on delete restrict on update restrict;

alter table RESPUESTA add constraint FK_RESPONDE foreign key (ID_MEDICO)
      references MEDICO (ID_MEDICO) on delete restrict on update restrict;

alter table RESPUESTA add constraint FK_RESPUESTA foreign key (ID_PREGUNTA)
      references PREGUNTA (ID_PREGUNTA) on delete restrict on update restrict;

alter table VACUNACION add constraint FK_VACUNADO foreign key (ID_MASCOTA)
      references MASCOTA (ID_MASCOTA) on delete restrict on update restrict;

alter table VACUNACION add constraint FK_VACUNA_MED foreign key (ID_MEDICO)
      references MEDICO (ID_MEDICO) on delete restrict on update restrict;

