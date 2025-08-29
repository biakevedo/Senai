-- insert cadastrar
-- update atualizar
-- delete apagar

-- opcional
-- set search_patch to <schema>;
-- clinica.paciente > paciente

-- insert into schema.tabela(colunas) values

insert into clinica.medico(nome, especialidade, crm) values 
('Beatriz', 'Psicologia', '202020'),
('Ariel', 'Cardiologia', '123456'),
('Vinicio', 'Ortopedia', '987654'),
('Pedro', 'Neurologia', '101015'),
('Marcela', 'Oftalmologia', '505050')

select * from clinica.medico;

insert into clinica.paciente(nome, idade, data_nascimento) values
('José', 23, '2002-07-20'),
('Camila', 34, '1990-11-25'),
('Lucy', 55, '1970-03-27'),
('Beatriz', 26, '1999-03-24');

select * from clinica.paciente;

insert into clinica.clinica(nome, descricao, endereco) values
('Clínica Bom Braço', 'Clínica de Ortopedia', 'Rua Niterói, 180'),
('Neuro Center', 'Neurologia do ABC', 'Rua Lauro Gomes, 358'),
('Mais Olhos', 'Desde 1830 no mercado', 'Av do Estado, 5333'),
('Sorrir', 'Cuide da sua saúde', 'Rua Paulo Antonio, 53'),
('CMA vida', 'Corpo, mente e alma', 'Av Pedro Pascal, 548')

select * from clinica.clinica;

insert into clinica.consulta(data, valor, id_medico, id_clinica, id_paciente) values
('2025-08-28 09:30:00-03', 350.00, 1, 5, 4),
('2025-08-30 05:10:00-03', 200.00, 5, 3, 1),
('2025-09-03 10:25:00-03', 650.00, 4, 2, 1),
('2025-09-15 02:50:00-03', 110.00, 5, 3, 2)

select * from clinica.consulta

--update <tabela> <coluna>
update clinica.consulta set valor = 200 where id_medico = 5;


update clinica.consulta 
set valor = 530
where valor > 500;



