import Database from "better-sqlite3";
import { mkdirSync } from "node:fs";
import { join } from "node:path";

const DATA_DIR = join(process.cwd(), "data");
mkdirSync(DATA_DIR, { recursive: true });

const db = new Database(join(DATA_DIR, "salas.db"));

db.pragma("journal_mode = WAL");

db.exec(`
CREATE TABLE IF NOT EXISTS salasdeaula (
salasdeaulaid INTEGER PRIMARY KEY AUTOINCREMENT,
descricao TEXT NOT NULL,
localizacao TEXT NOT NULL,
capacidade INTEGER NOT NULL CHECK (capacidade >= 0),
removido INTEGER NOT NULL DEFAULT 0 CHECK (removido IN (0,1)),
created_at TEXT NOT NULL DEFAULT (datetime('now')),
updated_at TEXT NOT NULL DEFAULT (datetime('now'))
);


CREATE TRIGGER IF NOT EXISTS trg_salas_update_ts
AFTER UPDATE ON salasdeaula
FOR EACH ROW BEGIN
UPDATE salasdeaula SET updated_at = datetime('now')
WHERE salasdeaulaid = OLD.salasdeaulaid;
END;
`);

export default db;
