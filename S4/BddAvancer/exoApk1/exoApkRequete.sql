-- Liste des étudiants dont le nom de famille est « KALAMOUKOU »
SELECT * FROM etudiant WHERE nome = 'KALAMOUKOU';

-- Liste des étudiants inscrits à l’Université UL
SELECT * FROM etudiant WHERE id_universite = 1;

-- Liste des étudiants nés en 1977 et inscrits à l’Université UK
SELECT * FROM etudiant WHERE id_universite = 3 AND YEAR(date_nais) = 1977;

-- Liste des étudiants inscrits à l’UCAO ou à l’UK
SELECT * FROM etudiant WHERE id_universite IN (2, 3);

-- Liste des étudiants inscrits à l’UK ou à UL et qui sont nés en 1977
SELECT * FROM etudiant WHERE (id_universite = 3 OR id_universite = 1) AND YEAR(date_nais) = 1977;

-- Liste des étudiants inscrits à l’UK ou ceux qui sont en même temps inscrits à UL et nés en 1977
SELECT * FROM etudiant WHERE (id_universite = 3 OR (id_universite = 1 AND YEAR(date_nais) = 1977));

-- Liste des étudiants nés avant 1976
SELECT * FROM etudiant WHERE YEAR(date_nais) < 1976;

-- Liste des étudiants dont le nom de famille commence par « M »
SELECT * FROM etudiant WHERE nome LIKE 'M%';

-- Liste des noms de famille des étudiants
SELECT nome FROM etudiant;

-- Liste des étudiants avec l’Université où ils sont inscrits
SELECT e.*, u.nomu AS universite_nom
FROM etudiant e
JOIN universite u ON e