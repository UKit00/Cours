/*==============================================================*/
/* Nom de SGBD :  MySQL 5.0                                     */
/* Date de cr�ation :  22/05/2023 09:29:14                      */
/*==============================================================*/


drop table if exists etudiant;

drop table if exists universite;

/*==============================================================*/
/* Table : etudiant                                             */
/*==============================================================*/
create table etudiant
(
   id_etudiant          int not null,
   id_universite        int not null,
   nomE                 varchar(30) not null,
   prenoms             varchar(100),
   date_nais            date,
   primary key (id_etudiant)
);

/*==============================================================*/
/* Table : universite                                           */
/*==============================================================*/
create table universite
(
   id_universite        int not null,
   nomU                 varchar(30) not null,
   abreviation          varchar(10) not null,
   ville                varchar(50),
   primary key (id_universite)
);

alter table etudiant add constraint fk_etre_inscrit foreign key (id_universite)
      references universite (id_universite) on delete restrict on update restrict;

