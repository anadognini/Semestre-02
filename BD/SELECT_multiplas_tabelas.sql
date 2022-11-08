-- a)

SELECT p.nm_proprietario, l.nm_localidade
FROM proprietario p, localidade l
WHERE p.cd_localidade = l.cd_localidade;

-- Ou

SELECT p.nm_proprietario, l.nm_localidade
FROM proprietario p JOIN localidade l
ON (p.cd_localidade = l.cd_localidade);
    
-- b)

SELECT mo.ds_modelo, ma.ds_marca AS "Apenas para conferência"
FROM modelo mo, marca ma
WHERE ma.cd_marca = mo.cd_marca 
	AND ma.ds_marca = 'FIAT'
ORDER BY mo.ds_modelo;

-- Ou

SELECT mo.ds_modelo, ma.ds_marca AS "Apenas para conferência"
FROM modelo mo JOIN marca ma
ON (ma.cd_marca = mo.cd_marca)
WHERE ma.ds_marca = 'FIAT'
ORDER BY mo.ds_modelo;

-- c)

SELECT ma.ds_marca AS marca, mo.ds_modelo AS modelo
FROM modelo mo, marca ma
WHERE ma.cd_marca = mo.cd_marca 
ORDER BY marca, modelo;

-- Ou

SELECT ma.ds_marca AS marca, mo.ds_modelo AS modelo
FROM modelo mo JOIN marca ma 
ON (ma.cd_marca = mo.cd_marca)
ORDER BY marca, modelo;

-- d)

SELECT v.nr_placa, v.nr_ano_mod, c.ds_cor
FROM veiculo v, cor c
WHERE v.cd_cor = c.cd_cor
ORDER BY 2, 3;

-- Ou

SELECT v.nr_placa, v.nr_ano_mod, c.ds_cor
FROM veiculo v JOIN cor c 
ON (v.cd_cor = c.cd_cor)
ORDER BY 2, 3;

-- e)

SELECT v.nr_placa, p.nm_proprietario, l.nm_localidade
FROM veiculo v, proprietario p, localidade l
WHERE v.cd_proprietario = p.cd_proprietario
	AND p.cd_localidade = l.cd_localidade
	AND p.sg_uf = 'SC';
    
-- Ou

SELECT v.nr_placa, p.nm_proprietario, l.nm_localidade
FROM veiculo v JOIN proprietario p 
	       ON (v.cd_proprietario = p.cd_proprietario)
	       JOIN localidade l 
               ON (p.cd_localidade = l.cd_localidade)
WHERE p.sg_uf = 'SC';

-- f)

SELECT v.nr_placa, ma.ds_marca, mo.ds_modelo, v.nr_ano_mod, c.ds_combustivel 
FROM veiculo v, marca ma, modelo mo, veiculo_combustivel vc, combustivel c
WHERE v.cd_modelo = mo.cd_modelo 
	AND mo.cd_marca = ma.cd_marca 
	AND v.nr_placa = vc.nr_placa 
	AND vc.cd_combustivel = c.cd_combustivel;
	
-- g)

SELECT v.nr_placa, ma.ds_marca, mo.ds_modelo 
FROM veiculo v, marca ma, modelo mo, veiculo_acessorio va, acessorio a 
WHERE v.cd_modelo = mo.cd_modelo 
	AND mo.cd_marca = ma.cd_marca 
    	AND v.nr_placa = va.nr_placa 
    	AND va.cd_acessorio = a.cd_acessorio
    	AND a.ds_acessorio LIKE 'Direção hid%';
