-- Gerado por Oracle SQL Developer Data Modeler 23.1.0.087.0806
--   em:        2023-05-08 23:42:05 BRT
--   site:      Oracle Database 11g
--   tipo:      Oracle Database 11g



-- predefined type, no DDL - MDSYS.SDO_GEOMETRY

-- predefined type, no DDL - XMLTYPE

CREATE TABLE t_cliente (
    id_pessoa NUMBER(100000) NOT NULL
);

ALTER TABLE t_cliente ADD CONSTRAINT cliente_pk PRIMARY KEY ( id_pessoa );

CREATE TABLE t_email (
    id_email         NUMBER(100000) NOT NULL,
    email            VARCHAR2(100) NOT NULL,
    provedor         VARCHAR2(30),
    pessoa_id_pessoa NUMBER(100000) NOT NULL
);

ALTER TABLE t_email ADD CONSTRAINT email_pk PRIMARY KEY ( id_email );

CREATE TABLE t_endereco (
    id_endereco                NUMBER(100000) NOT NULL,
    tipo_logradouro            VARCHAR2(15) NOT NULL,
    logradouro                 VARCHAR2(35) NOT NULL,
    numero                     NUMBER(10) NOT NULL,
    complemento                VARCHAR2(50),
    cep                        NUMBER(8),
    bairro                     VARCHAR2(50),
    cidade                     VARCHAR2(50),
    estado                     VARCHAR2(50),
    pais                       VARCHAR2(50),
    pessoa_id_pessoa           NUMBER(100000) NOT NULL,
    ensaio_id_ensaio           NUMBER(100000) NOT NULL,
    ensaio_fotografa_id_pessoa NUMBER(100000) NOT NULL
);

CREATE UNIQUE INDEX endereco__idx ON
    t_endereco (
        ensaio_id_ensaio
    ASC,
        ensaio_fotografa_id_pessoa
    ASC );

ALTER TABLE t_endereco ADD CONSTRAINT endereco_pk PRIMARY KEY ( id_endereco );

CREATE TABLE t_ensaio (
    id_ensaio           NUMBER(100000) NOT NULL,
    data                DATE NOT NULL,
    tipo                VARCHAR2(50) NOT NULL,
    duracao             NUMBER(24),
    qtdfotos            NUMBER(10000) NOT NULL,
    precototal          NUMBER(100000) NOT NULL,
    entregue            CHAR(1),
    fotografa_id_pessoa NUMBER(100000) NOT NULL,
    cliente_id_pessoa   NUMBER(100000) NOT NULL
);

ALTER TABLE t_ensaio
    ADD CHECK ( tipo IN ( 'aniversario', 'casamento', 'evento', 'marcapessoal', 'newborn',
                          'parque', 'retrato', 'smash' ) );

ALTER TABLE t_ensaio ADD CONSTRAINT ensaio_pk PRIMARY KEY ( id_ensaio,
                                                            fotografa_id_pessoa );

CREATE TABLE t_fotografa (
    id_pessoa     NUMBER(100000) NOT NULL,
    especialidade VARCHAR2(50) NOT NULL,
    website       VARCHAR2(50),
    precoporhora  NUMBER(10000),
    camera        VARCHAR2(50)
);

ALTER TABLE t_fotografa
    ADD CHECK ( especialidade IN ( 'casamento', 'marcas', 'mulheres', 'newborn', 'retrato' ) );

ALTER TABLE t_fotografa ADD CONSTRAINT fotografa_pk PRIMARY KEY ( id_pessoa );

CREATE TABLE t_pessoa (
    id_pessoa     NUMBER(100000) NOT NULL,
    sobrenome     VARCHAR2(20) NOT NULL,
    nome          VARCHAR2(20) NOT NULL,
    empresa       VARCHAR2(40),
    dt_nascimento DATE,
    tipo          VARCHAR2(50)
);

ALTER TABLE t_pessoa
    ADD CHECK ( tipo IN ( 'Cliente', 'Fotógrafa' ) );

ALTER TABLE t_pessoa ADD CONSTRAINT pessoa_pk PRIMARY KEY ( id_pessoa );

CREATE TABLE t_telefone (
    id_telefone      NUMBER(1000000) NOT NULL,
    nr_ddd           NUMBER(3) NOT NULL,
    nr_telefone      NUMBER(9) NOT NULL,
    nr_ramal         NUMBER(2),
    pessoa_id_pessoa NUMBER(100000) NOT NULL
);

ALTER TABLE t_telefone ADD CONSTRAINT telefone_pk PRIMARY KEY ( id_telefone );

ALTER TABLE t_cliente
    ADD CONSTRAINT cliente_pessoa_fk FOREIGN KEY ( id_pessoa )
        REFERENCES t_pessoa ( id_pessoa );

ALTER TABLE t_email
    ADD CONSTRAINT email_pessoa_fk FOREIGN KEY ( pessoa_id_pessoa )
        REFERENCES t_pessoa ( id_pessoa );

ALTER TABLE t_endereco
    ADD CONSTRAINT endereco_ensaio_fk FOREIGN KEY ( ensaio_id_ensaio,
                                                    ensaio_fotografa_id_pessoa )
        REFERENCES t_ensaio ( id_ensaio,
                              fotografa_id_pessoa );

ALTER TABLE t_endereco
    ADD CONSTRAINT endereco_pessoa_fk FOREIGN KEY ( pessoa_id_pessoa )
        REFERENCES t_pessoa ( id_pessoa );

ALTER TABLE t_ensaio
    ADD CONSTRAINT ensaio_cliente_fk FOREIGN KEY ( cliente_id_pessoa )
        REFERENCES t_cliente ( id_pessoa );

ALTER TABLE t_ensaio
    ADD CONSTRAINT ensaio_fotografa_fk FOREIGN KEY ( fotografa_id_pessoa )
        REFERENCES t_fotografa ( id_pessoa );

ALTER TABLE t_fotografa
    ADD CONSTRAINT fotografa_pessoa_fk FOREIGN KEY ( id_pessoa )
        REFERENCES t_pessoa ( id_pessoa );

ALTER TABLE t_telefone
    ADD CONSTRAINT telefone_pessoa_fk FOREIGN KEY ( pessoa_id_pessoa )
        REFERENCES t_pessoa ( id_pessoa );

CREATE OR REPLACE TRIGGER arc_fkarc_1_t_fotografa BEFORE
    INSERT OR UPDATE OF id_pessoa ON t_fotografa
    FOR EACH ROW
DECLARE
    d VARCHAR2(50);
BEGIN
    SELECT
        a.tipo
    INTO d
    FROM
        t_pessoa a
    WHERE
        a.id_pessoa = :new.id_pessoa;

    IF ( d IS NULL OR d <> 'Fotógrafa' ) THEN
        raise_application_error(-20223, 'FK FOTOGRAFA_PESSOA_FK in Table T_FOTOGRAFA violates Arc constraint on Table T_PESSOA - discriminator column tipo doesn''t have value ''Fotógrafa'''
        );
    END IF;

EXCEPTION
    WHEN no_data_found THEN
        NULL;
    WHEN OTHERS THEN
        RAISE;
END;
/

CREATE OR REPLACE TRIGGER arc_fkarc_1_t_cliente BEFORE
    INSERT OR UPDATE OF id_pessoa ON t_cliente
    FOR EACH ROW
DECLARE
    d VARCHAR2(50);
BEGIN
    SELECT
        a.tipo
    INTO d
    FROM
        t_pessoa a
    WHERE
        a.id_pessoa = :new.id_pessoa;

    IF ( d IS NULL OR d <> 'Cliente' ) THEN
        raise_application_error(-20223, 'FK CLIENTE_PESSOA_FK in Table T_CLIENTE violates Arc constraint on Table T_PESSOA - discriminator column tipo doesn''t have value ''Cliente'''
        );
    END IF;

EXCEPTION
    WHEN no_data_found THEN
        NULL;
    WHEN OTHERS THEN
        RAISE;
END;
/

CREATE SEQUENCE t_email_id_email_seq START WITH 1 NOCACHE ORDER;

CREATE OR REPLACE TRIGGER t_email_id_email_trg BEFORE
    INSERT ON t_email
    FOR EACH ROW
    WHEN ( new.id_email IS NULL )
BEGIN
    :new.id_email := t_email_id_email_seq.nextval;
END;
/

CREATE SEQUENCE t_endereco_id_endereco_seq START WITH 1 NOCACHE ORDER;

CREATE OR REPLACE TRIGGER t_endereco_id_endereco_trg BEFORE
    INSERT ON t_endereco
    FOR EACH ROW
    WHEN ( new.id_endereco IS NULL )
BEGIN
    :new.id_endereco := t_endereco_id_endereco_seq.nextval;
END;
/

CREATE SEQUENCE t_ensaio_id_ensaio_seq START WITH 1 NOCACHE ORDER;

CREATE OR REPLACE TRIGGER t_ensaio_id_ensaio_trg BEFORE
    INSERT ON t_ensaio
    FOR EACH ROW
    WHEN ( new.id_ensaio IS NULL )
BEGIN
    :new.id_ensaio := t_ensaio_id_ensaio_seq.nextval;
END;
/

CREATE SEQUENCE t_pessoa_id_pessoa_seq START WITH 1 NOCACHE ORDER;

CREATE OR REPLACE TRIGGER t_pessoa_id_pessoa_trg BEFORE
    INSERT ON t_pessoa
    FOR EACH ROW
    WHEN ( new.id_pessoa IS NULL )
BEGIN
    :new.id_pessoa := t_pessoa_id_pessoa_seq.nextval;
END;
/



-- Relatório do Resumo do Oracle SQL Developer Data Modeler: 
-- 
-- CREATE TABLE                             7
-- CREATE INDEX                             1
-- ALTER TABLE                             18
-- CREATE VIEW                              0
-- ALTER VIEW                               0
-- CREATE PACKAGE                           0
-- CREATE PACKAGE BODY                      0
-- CREATE PROCEDURE                         0
-- CREATE FUNCTION                          0
-- CREATE TRIGGER                           6
-- ALTER TRIGGER                            0
-- CREATE COLLECTION TYPE                   0
-- CREATE STRUCTURED TYPE                   0
-- CREATE STRUCTURED TYPE BODY              0
-- CREATE CLUSTER                           0
-- CREATE CONTEXT                           0
-- CREATE DATABASE                          0
-- CREATE DIMENSION                         0
-- CREATE DIRECTORY                         0
-- CREATE DISK GROUP                        0
-- CREATE ROLE                              0
-- CREATE ROLLBACK SEGMENT                  0
-- CREATE SEQUENCE                          4
-- CREATE MATERIALIZED VIEW                 0
-- CREATE MATERIALIZED VIEW LOG             0
-- CREATE SYNONYM                           0
-- CREATE TABLESPACE                        0
-- CREATE USER                              0
-- 
-- DROP TABLESPACE                          0
-- DROP DATABASE                            0
-- 
-- REDACTION POLICY                         0
-- 
-- ORDS DROP SCHEMA                         0
-- ORDS ENABLE SCHEMA                       0
-- ORDS ENABLE OBJECT                       0
-- 
-- ERRORS                                   0
-- WARNINGS                                 0
