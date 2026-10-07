-- Parte 3: campo "ativo", usado para a exclusao logica.

alter table consertos add ativo boolean;

-- Os registros que ja existiam passam a ficar "ativos":
update consertos set ativo = true;
