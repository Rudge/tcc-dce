DROP DATABASE TCC;

CREATE DATABASE TCC;

USE TCC;

CREATE TABLE ADMINISTRADOR (
  IDADMINISTRADOR INT NOT NULL AUTO_INCREMENT,
  NOME VARCHAR(45) NOT NULL,
  LOGIN VARCHAR(20) NOT NULL,
  SENHA VARCHAR(20) NOT NULL,
  LEMBRAR_SENHA VARCHAR(45) NOT NULL,
  PRIMARY KEY(IDADMINISTRADOR)
);

CREATE TABLE ALUNO (
  MATRICULA BIGINT NOT NULL AUTO_INCREMENT,
  NOME VARCHAR(70) NOT NULL,
  PRIMARY KEY(MATRICULA)
)
ROW_FORMAT = DYNAMIC;

CREATE TABLE PROFESSOR (
  IDPROFESSOR INT NOT NULL AUTO_INCREMENT,
  NOME VARCHAR(70) NOT NULL,
  LOGIN VARCHAR(20) NOT NULL,
  SENHA VARCHAR(20) NOT NULL,
  LEMBRAR_SENHA VARCHAR(50) NOT NULL,
  PRIMARY KEY(IDPROFESSOR)
)
ROW_FORMAT = DYNAMIC;

CREATE TABLE SERIE (
  SERIE INT NOT NULL AUTO_INCREMENT,
  TURMA CHAR(1) NOT NULL,
  PRIMARY KEY(SERIE, TURMA)
)
ROW_FORMAT = DYNAMIC;

CREATE TABLE DISCIPLINAS (
  IDDISCIPLINA INT NOT NULL AUTO_INCREMENT,
  PROFESSOR_IDPROFESSOR INT NOT NULL,
  NOME VARCHAR(45) NOT NULL,
  PRIMARY KEY(IDDISCIPLINA),
  INDEX DISCIPLINAS_PROFESSOR(PROFESSOR_IDPROFESSOR),
  FOREIGN KEY (PROFESSOR_IDPROFESSOR) REFERENCES PROFESSOR (IDPROFESSOR)
);

CREATE TABLE CHAMADA (
  IDCHAMADA INT NOT NULL AUTO_INCREMENT,
  DISCIPLINAS_IDDISCIPLINA INT NOT NULL,
  DATA_CHAMADA DATE NOT NULL,
  HORA_AULA VARCHAR(13) NOT NULL,
  PRIMARY KEY(IDCHAMADA, DISCIPLINAS_IDDISCIPLINA),
  INDEX CHAMADA(IDCHAMADA, DISCIPLINAS_IDDISCIPLINA),
  FOREIGN KEY (DISCIPLINAS_IDDISCIPLINA) REFERENCES DISCIPLINAS (IDDISCIPLINA)
)
ROW_FORMAT = DYNAMIC;

CREATE TABLE CLASSE (
  IDCLASSE INT NOT NULL AUTO_INCREMENT,
  SERIE_SERIE INT NOT NULL,
  SERIE_TURMA CHAR(1),
  PERIODO VARCHAR(20) NOT NULL,
  DESCRICAO_SALA VARCHAR(20) NULL,
  ANO NUMERIC NOT NULL,
  PRIMARY KEY(IDCLASSE, SERIE_SERIE),
  INDEX CLASSE_SERIE(SERIE_SERIE, SERIE_TURMA),
  FOREIGN KEY (SERIE_SERIE,SERIE_TURMA ) REFERENCES SERIE (SERIE, TURMA)
)
ROW_FORMAT = DYNAMIC;

CREATE TABLE CLASSE_CHAMADA(
  CHAMADA_IDCHAMADA INT NOT NULL,
  CLASSE_IDCLASSE INT NOT NULL,
  ALUNO_MATRICULA BIGINT NOT NULL,
  PRESENCA BOOL NOT NULL DEFAULT FALSE,
  INDEX CLASSE_CHAMADA(CHAMADA_IDCHAMADA, CLASSE_IDCLASSE),
  FOREIGN KEY (CHAMADA_IDCHAMADA) REFERENCES CHAMADA (IDCHAMADA),
  FOREIGN KEY (CLASSE_IDCLASSE) REFERENCES CLASSE (IDCLASSE),
  FOREIGN KEY (ALUNO_MATRICULA) REFERENCES ALUNO (MATRICULA)
)
ROW_FORMAT = DYNAMIC;