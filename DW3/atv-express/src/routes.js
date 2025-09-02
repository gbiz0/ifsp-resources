import { Router } from "express";
import { SalasRepo } from "./repository.js";
import { SalaCreateSchema, SalaUpdateSchema, parseBody } from "./validation.js";

const router = Router();

router.get("/health", (_, res) => res.json({ status: "ok" }));

router.get("/salas", (req, res) => {
  const data = SalasRepo.getAll();
  res.json(data);
});

router.get("/salas/:id", (req, res) => {
  const id = Number(req.params.id);
  if (!Number.isInteger(id))
    return res.status(400).json({ message: "id inválido" });
  const row = SalasRepo.getById(id);
  if (!row) return res.status(404).json({ message: "sala não encontrada" });
  res.json(row);
});

router.post("/salas", (req, res, next) => {
  try {
    const payload = parseBody(SalaCreateSchema, req.body);
    const created = SalasRepo.insert(payload);
    res.status(201).json(created);
  } catch (e) {
    next(e);
  }
});

router.put("/salas/:id", (req, res, next) => {
  try {
    const id = Number(req.params.id);
    if (!Number.isInteger(id))
      return res.status(400).json({ message: "id inválido" });
    const payload = parseBody(SalaUpdateSchema, req.body);
    const updated = SalasRepo.update(id, payload);
    if (!updated)
      return res
        .status(404)
        .json({ message: "sala não encontrada (ou removida)" });
    res.json(updated);
  } catch (e) {
    next(e);
  }
});

router.delete("/salas/:id", (req, res) => {
  const id = Number(req.params.id);
  if (!Number.isInteger(id))
    return res.status(400).json({ message: "id inválido" });
  const ok = SalasRepo.softDelete(id);
  if (!ok)
    return res
      .status(404)
      .json({ message: "sala não encontrada (ou já removida)" });
  res.status(204).send();
});

export default router;
