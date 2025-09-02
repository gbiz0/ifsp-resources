import db from "./db.js";

const mapRow = (r) =>
  r && {
    salasdeaulaid: r.salasdeaulaid,
    descricao: r.descricao,
    localizacao: r.localizacao,
    capacidade: r.capacidade,
    removido: Boolean(r.removido),
    created_at: r.created_at,
    updated_at: r.updated_at,
  };

export const SalasRepo = {
  getAll() {
    const stmt = db.prepare(`
SELECT salasdeaulaid, descricao, localizacao, capacidade, removido,
created_at, updated_at
FROM salasdeaula
WHERE removido = 0
ORDER BY salasdeaulaid ASC;
`);
    return stmt.all().map(mapRow);
  },

  getById(id) {
    const stmt = db.prepare(`
SELECT salasdeaulaid, descricao, localizacao, capacidade, removido,
created_at, updated_at
FROM salasdeaula
WHERE salasdeaulaid = ? AND removido = 0;
`);
    return mapRow(stmt.get(id));
  },

  insert({ descricao, localizacao, capacidade }) {
    const ins = db.prepare(`
INSERT INTO salasdeaula (descricao, localizacao, capacidade, removido)
VALUES (?, ?, ?, 0);
`);
    const info = ins.run(descricao, localizacao, capacidade);
    return this.getById(info.lastInsertRowid);
  },

  update(id, { descricao, localizacao, capacidade }) {
    const upd = db.prepare(`
UPDATE salasdeaula
SET descricao = ?, localizacao = ?, capacidade = ?
WHERE salasdeaulaid = ? AND removido = 0;
`);
    const info = upd.run(descricao, localizacao, capacidade, id);
    if (info.changes === 0) return null;
    return this.getById(id);
  },

  softDelete(id) {
    const del = db.prepare(`
UPDATE salasdeaula
SET removido = 1
WHERE salasdeaulaid = ? AND removido = 0;
`);
    const info = del.run(id);
    return info.changes > 0;
  },
};
