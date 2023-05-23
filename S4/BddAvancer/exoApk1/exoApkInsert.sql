-- Insértion des universités
INSERT INTO universite (id_universite, nomU, abreviation, ville)
VALUES (1, 'Université de Lome', 'UL', 'Lome'),
       (2, 'Université UCAO', 'UCAO', 'Lome'),
       (3, 'Université de Kara', 'UK', 'Kara');

-- Insertion des étudiants
INSERT INTO etudiant (id_etudiant, id_universite, nomE, prenoms, date_nais)
VALUES (1, 1, 'Dupont', 'Jean', '1990-01-01'),
       (2, 1, 'Martin', 'Sophie', '1991-02-02'),
       (3, 1, 'Lefebvre', 'Pierre', '1992-03-03'),
       (4, 2, 'Dubois', 'Marie', '1993-04-04'),
       (5, 2, 'Thomas', 'Alexandre', '1994-05-05'),
       (6, 2, 'Robert', 'Isabelle', '1995-06-06'),
       (7, 3, 'Petit', 'Julien', '1996-07-07'),
       (8, 3, 'Durand', 'Laura', '1997-08-08'),
       (9, 3, 'Moreau', 'Nicolas', '1998-09-09'),
       (10, 2, 'Gagnon', 'Julie', '1999-10-10'),
       (11, 1, 'KALAMOUKOU', 'Gabriel', '2000-11-11'),
       (12, 3, 'Bélanger', 'Audrey', '1995-12-12'),
       (13, 1, 'Tremblay', 'Alexis', '1992-01-13'),
       (14, 2, 'Roy', 'Camille', '1993-02-14'),
       (15, 3, 'Gauthier', 'Simon', '1991-03-15'),
       (16, 1, 'Morin', 'Clara', '1990-04-16'),
       (17, 3, 'Lavoie', 'Olivier', '1994-05-17'),
       (18, 2, 'Fortin', 'Léa', '1997-06-18'),
       (19, 1, 'KALAMOUKOU', 'Thomas', '1998-07-19'),
       (20, 3, 'Girard', 'Jade', '1996-08-20'),
       (21, 1, 'Gagné', 'William', '1999-09-21'),
       (22, 2, 'Bergeron', 'Émilie', '2000-10-22'),
       (23, 1, 'KALAMOUKOU', 'Félix', '1995-11-23'),
       (24, 3, 'Beaudoin', 'Léonie', '1992-12-24'),
       (25, 2, 'Lefort', 'Noah', '1993-01-25'),
       (26, 1, 'Boucher', 'Clémence', '1991-02-26'),
       (27, 3, 'KALAMOUKOU', 'Samuel', '1990-03-27'),
       (28, 1, 'Couture', 'Éloïse', '1994-04-28'),
       (29, 3, 'Hamel', 'Raphaël', '1997-05-29'),
       (30, 2, 'Perron', 'Mélissa', '1998-06-30');