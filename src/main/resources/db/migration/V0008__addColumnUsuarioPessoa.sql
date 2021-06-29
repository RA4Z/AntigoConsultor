ALTER TABLE consultor
ADD COLUMN usuario_id BIGINT NOT NULL DEFAULT 0;

ALTER TABLE consultor ADD CONSTRAINT fk_usuario_consultor
FOREIGN KEY (usuario_id) REFERENCES usuario (id);