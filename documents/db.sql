-- Dropando todas as tabelas antes de qualquer passo
drop table Beneficiario cascade constraints;
drop table Plano cascade constraints;
drop table Sinistro cascade constraints;
drop table Consulta cascade constraints;
drop table Exame cascade constraints;
drop table Profissional cascade constraints;

-- Tabela Plano Odontológico
CREATE TABLE Plano (
                       id_plano NUMBER GENERATED AS IDENTITY CONSTRAINT pk_id_plano PRIMARY KEY,
                       nome_plano VARCHAR(50) NOT NULL,
                       tipo_plano VARCHAR(50) NOT NULL,
                       valor_mensal DECIMAL(10, 2) NOT NULL
);

-- Tabela Profissional de Saúde
CREATE TABLE Profissional (
                              id_profissional NUMBER GENERATED AS IDENTITY CONSTRAINT pk_id_profissional PRIMARY KEY,
                              nome VARCHAR(100) NOT NULL,
                              especialidade VARCHAR(50),
                              crm VARCHAR(20) UNIQUE NOT NULL
);

-- Tabela Beneficiário
CREATE TABLE Beneficiario (
                              id_beneficiario NUMBER GENERATED AS IDENTITY CONSTRAINT pk_id_beneficiario PRIMARY KEY,
                              nome VARCHAR(100) NOT NULL,
                              data_nascimento DATE NOT NULL,
                              cpf VARCHAR(11) UNIQUE NOT NULL,
                              telefone VARCHAR(15),
                              email VARCHAR(100),
                              endereco VARCHAR(255),
                              ranking CHAR(2),
                              id_plano NUMBER,
    -- CHAVES ESTRANGEIRAS
                              CONSTRAINT fk_id_plano_Beneficiario FOREIGN KEY (id_plano)
                                  REFERENCES Plano(id_plano)
);

-- Tabela Histórico de Sinistro
CREATE TABLE Sinistro (
                          id_sinistro NUMBER GENERATED AS IDENTITY CONSTRAINT pk_id_sinistro PRIMARY KEY,
                          id_beneficiario NUMBER,
                          data_sinistro DATE NOT NULL,
                          tipo_sinistro VARCHAR(50),
                          valor_sinistro DECIMAL(10, 2),
    -- CHAVES ESTRANGEIRAS
                          CONSTRAINT fk_id_beneficiario_Sinistro FOREIGN KEY (id_beneficiario)
                              REFERENCES Beneficiario(id_beneficiario)
);

-- Tabela Consulta
CREATE TABLE Consulta (
                          id_consulta NUMBER GENERATED AS IDENTITY CONSTRAINT pk_id_consulta PRIMARY KEY,
                          id_beneficiario NUMBER,
                          data_consulta DATE NOT NULL,
                          motivo_consulta VARCHAR(50),
                          status VARCHAR(20),
                          id_profissional NUMBER,
    -- CHAVES ESTRANGEIRAS
                          CONSTRAINT fk_id_beneficiario_Consulta FOREIGN KEY (id_beneficiario)
                              REFERENCES Beneficiario(id_beneficiario),
                          CONSTRAINT fk_id_profissional_Consulta FOREIGN KEY (id_profissional)
                              REFERENCES Profissional(id_profissional)
);

-- Tabela Exame
CREATE TABLE Exame (
                       id_exame NUMBER GENERATED AS IDENTITY CONSTRAINT pk_id_exame PRIMARY KEY,
                       id_beneficiario NUMBER,
                       data_exame DATE NOT NULL,
                       tipo_exame VARCHAR(50),
                       resultado_exame VARCHAR(20),
                       id_profissional NUMBER,
    -- CHAVES ESTRANGEIRAS
                       CONSTRAINT fk_id_beneficiario_Exame FOREIGN KEY (id_beneficiario)
                           REFERENCES Beneficiario(id_beneficiario),
                       CONSTRAINT fk_id_profissional_Exame FOREIGN KEY (id_profissional)
                           REFERENCES Profissional(id_profissional)
);


-- Inserindo 10 registros na tabela Plano
INSERT INTO Plano (nome_plano, tipo_plano, valor_mensal) VALUES ('OdontoPrev Básico', 'Individual', 120.00);
INSERT INTO Plano (nome_plano, tipo_plano, valor_mensal) VALUES ('OdontoPrev Familiar', 'Familiar', 250.00);
INSERT INTO Plano (nome_plano, tipo_plano, valor_mensal) VALUES ('OdontoPrev Coletivo', 'Coletivo', 100.00);
INSERT INTO Plano (nome_plano, tipo_plano, valor_mensal) VALUES ('OdontoPrev Empresarial', 'Empresarial', 450.00);
INSERT INTO Plano (nome_plano, tipo_plano, valor_mensal) VALUES ('OdontoPrev Premium', 'Individual', 180.00);
INSERT INTO Plano (nome_plano, tipo_plano, valor_mensal) VALUES ('OdontoPrev Plus', 'Familiar', 300.00);
INSERT INTO Plano (nome_plano, tipo_plano, valor_mensal) VALUES ('OdontoPrev Max', 'Coletivo', 130.00);
INSERT INTO Plano (nome_plano, tipo_plano, valor_mensal) VALUES ('OdontoPrev Corporativo', 'Empresarial', 520.00);
INSERT INTO Plano (nome_plano, tipo_plano, valor_mensal) VALUES ('OdontoPrev Simples', 'Individual', 160.00);
INSERT INTO Plano (nome_plano, tipo_plano, valor_mensal) VALUES ('OdontoPrev Familiar Gold', 'Familiar', 370.00);
COMMIT;

-- Inserindo 10 registros na tabela Beneficiário
INSERT INTO Beneficiario (nome, data_nascimento, cpf, telefone, email, endereco, ranking, id_plano)
VALUES ('João da Silva', TO_DATE('1990-05-15', 'YYYY-MM-DD'), '12345678901', '11987654321', 'joao.silva@odontoprev.com', 'Rua das Flores, 123', 'B', 1);
INSERT INTO Beneficiario (nome, data_nascimento, cpf, telefone, email, endereco, ranking, id_plano)
VALUES ('Maria Oliveira', TO_DATE('1985-10-20', 'YYYY-MM-DD'), '23456789012', '11976543210', 'maria.oliveira@odontoprev.com', 'Rua das Palmeiras, 456', 'A', 2);
INSERT INTO Beneficiario (nome, data_nascimento, cpf, telefone, email, endereco, ranking, id_plano)
VALUES ('Pedro Santos', TO_DATE('2000-12-30', 'YYYY-MM-DD'), '34567890123', '11876543210', 'pedro.santos@odontoprev.com', 'Rua do Sol, 789', 'C', 3);
INSERT INTO Beneficiario (nome, data_nascimento, cpf, telefone, email, endereco, ranking, id_plano)
VALUES ('Ana Costa', TO_DATE('1992-07-05', 'YYYY-MM-DD'), '45678901234', '11765432109', 'ana.costa@odontoprev.com', 'Avenida das Árvores, 101', 'A', 4);
INSERT INTO Beneficiario (nome, data_nascimento, cpf, telefone, email, endereco, ranking, id_plano)
VALUES ('Lucas Lima', TO_DATE('1988-03-25', 'YYYY-MM-DD'), '56789012345', '11654321098', 'lucas.lima@odontoprev.com', 'Rua dos Coqueiros, 202', 'B', 5);
INSERT INTO Beneficiario (nome, data_nascimento, cpf, telefone, email, endereco, ranking, id_plano)
VALUES ('Juliana Ferreira', TO_DATE('1995-09-15', 'YYYY-MM-DD'), '67890123456', '11543210987', 'juliana.ferreira@odontoprev.com', 'Rua das Margaridas, 303', 'A', 6);
INSERT INTO Beneficiario (nome, data_nascimento, cpf, telefone, email, endereco, ranking, id_plano)
VALUES ('Ricardo Almeida', TO_DATE('1980-06-10', 'YYYY-MM-DD'), '78901234567', '11432109876', 'ricardo.almeida@odontoprev.com', 'Rua dos Lírios, 404', 'D', 7);
INSERT INTO Beneficiario (nome, data_nascimento, cpf, telefone, email, endereco, ranking, id_plano)
VALUES ('Fernanda Martins', TO_DATE('1975-11-25', 'YYYY-MM-DD'), '89012345678', '11321098765', 'fernanda.martins@odontoprev.com', 'Rua das Orquídeas, 505', 'C', 8);
INSERT INTO Beneficiario (nome, data_nascimento, cpf, telefone, email, endereco, ranking, id_plano)
VALUES ('Thiago Ribeiro', TO_DATE('1993-04-20', 'YYYY-MM-DD'), '90123456789', '11210987654', 'thiago.ribeiro@odontoprev.com', 'Rua do Ipê, 606', 'B', 9);
INSERT INTO Beneficiario (nome, data_nascimento, cpf, telefone, email, endereco, ranking, id_plano)
VALUES ('Patrícia Souza', TO_DATE('1982-08-12', 'YYYY-MM-DD'), '01234567890', '11109876543', 'patricia.souza@odontoprev.com', 'Rua das Azaléias, 707', 'A', 10);
COMMIT;

-- Inserindo 10 registros na tabela Profissional
INSERT INTO Profissional (nome, especialidade, crm) VALUES ('Dr. Carlos Andrade', 'Dentista', '123456');
INSERT INTO Profissional (nome, especialidade, crm) VALUES ('Dra. Ana Beatriz', 'Odontopediatria', '234567');
INSERT INTO Profissional (nome, especialidade, crm) VALUES ('Dr. Jorge Oliveira', 'Ortodontia', '345678');
INSERT INTO Profissional (nome, especialidade, crm) VALUES ('Dra. Juliana Ferreira', 'Periodontia', '456789');
INSERT INTO Profissional (nome, especialidade, crm) VALUES ('Dr. Ricardo Lima', 'Endodontia', '567890');
INSERT INTO Profissional (nome, especialidade, crm) VALUES ('Dr. Thiago Martins', 'Implantodontia', '678901');
INSERT INTO Profissional (nome, especialidade, crm) VALUES ('Dra. Paula Medeiros', 'Cirurgia', '789012');
INSERT INTO Profissional (nome, especialidade, crm) VALUES ('Dr. Gustavo Souza', 'Estética', '890123');
INSERT INTO Profissional (nome, especialidade, crm) VALUES ('Dra. Bruna Pereira', 'Ortodontia', '901234');
INSERT INTO Profissional (nome, especialidade, crm) VALUES ('Dr. Fabio Lima', 'Periodontia', '012345');
COMMIT;

-- Inserindo 10 registros na tabela Consulta (com status corretos)
INSERT INTO Consulta (id_beneficiario, data_consulta, motivo_consulta, status, id_profissional)
VALUES (1, TO_DATE('2023-08-01', 'YYYY-MM-DD'), 'Check-up odontológico', 'Realizada', 1);
INSERT INTO Consulta (id_beneficiario, data_consulta, motivo_consulta, status, id_profissional)
VALUES (2, TO_DATE('2023-08-05', 'YYYY-MM-DD'), 'Limpeza dental', 'Realizada', 2);
INSERT INTO Consulta (id_beneficiario, data_consulta, motivo_consulta, status, id_profissional)
VALUES (3, TO_DATE('2023-08-10', 'YYYY-MM-DD'), 'Avaliação ortodontica', 'Pendente', 3);
INSERT INTO Consulta (id_beneficiario, data_consulta, motivo_consulta, status, id_profissional)
VALUES (4, TO_DATE('2023-08-15', 'YYYY-MM-DD'), 'Tratamento de canal', 'Realizada', 4);
INSERT INTO Consulta (id_beneficiario, data_consulta, motivo_consulta, status, id_profissional)
VALUES (5, TO_DATE('2023-08-20', 'YYYY-MM-DD'), 'Consulta de rotina', 'Pendente', 5);
INSERT INTO Consulta (id_beneficiario, data_consulta, motivo_consulta, status, id_profissional)
VALUES (6, TO_DATE('2023-09-01', 'YYYY-MM-DD'), 'Avaliação geral', 'Cancelada', 6);
INSERT INTO Consulta (id_beneficiario, data_consulta, motivo_consulta, status, id_profissional)
VALUES (7, TO_DATE('2023-09-05', 'YYYY-MM-DD'), 'Tratamento ortodôntico', 'Pendente', 7);
INSERT INTO Consulta (id_beneficiario, data_consulta, motivo_consulta, status, id_profissional)
VALUES (8, TO_DATE('2023-09-10', 'YYYY-MM-DD'), 'Tratamento estético', 'Realizada', 8);
INSERT INTO Consulta (id_beneficiario, data_consulta, motivo_consulta, status, id_profissional)
VALUES (9, TO_DATE('2023-09-15', 'YYYY-MM-DD'), 'Extração de dente', 'Pendente', 9);
INSERT INTO Consulta (id_beneficiario, data_consulta, motivo_consulta, status, id_profissional)
VALUES (10, TO_DATE('2023-09-20', 'YYYY-MM-DD'), 'Limpeza geral', 'Cancelada', 10);
COMMIT;

-- Inserindo 10 registros na tabela Exame
INSERT INTO Exame (id_beneficiario, data_exame, tipo_exame, resultado_exame, id_profissional)
VALUES (1, TO_DATE('2023-09-01', 'YYYY-MM-DD'), 'Radiografia', 'Normal', 1);
INSERT INTO Exame (id_beneficiario, data_exame, tipo_exame, resultado_exame, id_profissional)
VALUES (2, TO_DATE('2023-09-05', 'YYYY-MM-DD'), 'Exame de sangue', 'Normal', 2);
INSERT INTO Exame (id_beneficiario, data_exame, tipo_exame, resultado_exame, id_profissional)
VALUES (3, TO_DATE('2023-09-10', 'YYYY-MM-DD'), 'Avaliação periodontal', 'Normal', 3);
INSERT INTO Exame (id_beneficiario, data_exame, tipo_exame, resultado_exame, id_profissional)
VALUES (4, TO_DATE('2023-09-15', 'YYYY-MM-DD'), 'Radiografia periapical', 'Normal', 4);
INSERT INTO Exame (id_beneficiario, data_exame, tipo_exame, resultado_exame, id_profissional)
VALUES (5, TO_DATE('2023-09-20', 'YYYY-MM-DD'), 'Tomografia dental', 'Normal', 5);
INSERT INTO Exame (id_beneficiario, data_exame, tipo_exame, resultado_exame, id_profissional)
VALUES (6, TO_DATE('2023-09-25', 'YYYY-MM-DD'), 'Biópsia bucal', 'Normal', 6);
INSERT INTO Exame (id_beneficiario, data_exame, tipo_exame, resultado_exame, id_profissional)
VALUES (7, TO_DATE('2023-09-30', 'YYYY-MM-DD'), 'Escaneamento digital', 'Normal', 7);
INSERT INTO Exame (id_beneficiario, data_exame, tipo_exame, resultado_exame, id_profissional)
VALUES (8, TO_DATE('2023-10-01', 'YYYY-MM-DD'), 'Panorâmica dental', 'Normal', 8);
INSERT INTO Exame (id_beneficiario, data_exame, tipo_exame, resultado_exame, id_profissional)
VALUES (9, TO_DATE('2023-10-05', 'YYYY-MM-DD'), 'Radiografia lateral', 'Normal', 9);
INSERT INTO Exame (id_beneficiario, data_exame, tipo_exame, resultado_exame, id_profissional)
VALUES (10, TO_DATE('2023-10-10', 'YYYY-MM-DD'), 'Tomografia 3D', 'Normal', 10);
COMMIT;

-- Inserindo 10 registros na tabela Sinistro
INSERT INTO Sinistro (id_beneficiario, data_sinistro, tipo_sinistro, valor_sinistro)
VALUES (1, TO_DATE('2023-08-01', 'YYYY-MM-DD'), 'Corretivo', 500.00);
INSERT INTO Sinistro (id_beneficiario, data_sinistro, tipo_sinistro, valor_sinistro)
VALUES (2, TO_DATE('2023-08-05', 'YYYY-MM-DD'), 'Preventivo', 150.00);
INSERT INTO Sinistro (id_beneficiario, data_sinistro, tipo_sinistro, valor_sinistro)
VALUES (3, TO_DATE('2023-08-10', 'YYYY-MM-DD'), 'Preventivo', 200.00);
INSERT INTO Sinistro (id_beneficiario, data_sinistro, tipo_sinistro, valor_sinistro)
VALUES (4, TO_DATE('2023-08-15', 'YYYY-MM-DD'), 'Corretivo', 1000.00);
INSERT INTO Sinistro (id_beneficiario, data_sinistro, tipo_sinistro, valor_sinistro)
VALUES (5, TO_DATE('2023-08-20', 'YYYY-MM-DD'), 'Preventivo', 300.00);
INSERT INTO Sinistro (id_beneficiario, data_sinistro, tipo_sinistro, valor_sinistro)
VALUES (6, TO_DATE('2023-08-25', 'YYYY-MM-DD'), 'Corretivo', 600.00);
INSERT INTO Sinistro (id_beneficiario, data_sinistro, tipo_sinistro, valor_sinistro)
VALUES (7, TO_DATE('2023-09-01', 'YYYY-MM-DD'), 'Corretivo', 700.00);
INSERT INTO Sinistro (id_beneficiario, data_sinistro, tipo_sinistro, valor_sinistro)
VALUES (8, TO_DATE('2023-09-05', 'YYYY-MM-DD'), 'Preventivo', 120.00);
INSERT INTO Sinistro (id_beneficiario, data_sinistro, tipo_sinistro, valor_sinistro)
VALUES (9, TO_DATE('2023-09-10', 'YYYY-MM-DD'), 'Corretivo', 400.00);
INSERT INTO Sinistro (id_beneficiario, data_sinistro, tipo_sinistro, valor_sinistro)
VALUES (10, TO_DATE('2023-09-15', 'YYYY-MM-DD'), 'Preventivo', 450.00);
COMMIT;