/*==============================================================*/
/* Nom de SGBD :  MySQL 5.0                                     */
/* Date de création :  27/03/2023 12:29:58                      */
/*==============================================================*/


drop table if exists artistes;

drop table if exists disques;

drop table if exists labels;

/*==============================================================*/
/* Table : artistes                                             */
/*==============================================================*/
create table artistes
(
   id_artiste           int not null,
   nom_artiste          varchar(200) not null,
   primary key (id_artiste)
);

/*==============================================================*/
/* Table : disques                                              */
/*==============================================================*/
create table disques
(
   id_disque            int not null,
   id_artiste           int not null,
   id_label             int not null,
   titre                varchar(200) not null,
   annee                date not null,
   primary key (id_disque)
);

/*==============================================================*/
/* Table : labels                                               */
/*==============================================================*/
create table labels
(
   id_label             int not null,
   nom_label            varchar(200) not null,
   primary key (id_label)
);

alter table disques add constraint fk_est__produit_par foreign key (id_label)
      references labels (id_label) on delete restrict on update restrict;

alter table disques add constraint fk_y_participer foreign key (id_artiste)
      references artistes (id_artiste) on delete restrict on update restrict;

