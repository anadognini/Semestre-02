-- INNER JOIN --

SELECT v.nr_placa, c.ds_cor
FROM veiculo v, cor c
WHERE v.cd_cor = c.cd_cor
AND c.ds_cor = 'Branco'; -- Filtro

-- Ou

SELECT v.nr_placa, c.ds_cor
FROM veiculo v INNER JOIN cor c ON (v.cd_cor = c.cd_cor) 
WHERE c.ds_cor = 'Branco'; 

-- FROM não filtra, apenas WHERE

-- LEFT X RIGHT --

SELECT v.nr_placa, c.ds_cor
FROM veiculo v LEFT JOIN cor c ON (v.cd_cor = c.cd_cor);

SELECT v.nr_placa, c.ds_cor
FROM veiculo v RIGHT JOIN cor c ON (v.cd_cor = c.cd_cor);

SELECT v.nr_placa, c.ds_cor
FROM veiculo v, cor c
WHERE v.cd_cor = c.cd_cor(+); -- RIGHT JOIN

SELECT v.nr_placa, c.ds_cor
FROM veiculo v, cor c
WHERE v.cd_cor(+) = c.cd_cor; -- LEFT JOIN

-- Se tiver uma certa quantidade de tabelas, a quantidade de junções que devem ser feitas é o número de tabelas - 1


