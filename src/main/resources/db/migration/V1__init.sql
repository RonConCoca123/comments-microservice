CREATE TABLE comment (
  id BIGSERIAL PRIMARY KEY,
  usuario_id BIGINT NOT NULL,
  docente_id BIGINT NOT NULL,
  cuerpo TEXT NOT NULL,
  calificacion INT NOT NULL,
  created_at TIMESTAMPTZ NOT NULL DEFAULT now(),
  likes_count INT NOT NULL DEFAULT 0
);
CREATE TABLE comment_like (
  comment_id BIGINT NOT NULL,
  usuario_id BIGINT NOT NULL,
  PRIMARY KEY (comment_id, usuario_id),
  FOREIGN KEY (comment_id) REFERENCES comment(id) ON DELETE CASCADE
);