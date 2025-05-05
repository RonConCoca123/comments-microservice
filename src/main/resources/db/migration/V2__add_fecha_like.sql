-- V2: añade timestamp del like
ALTER TABLE comment_like
  ADD COLUMN fecha TIMESTAMPTZ NOT NULL DEFAULT now();
