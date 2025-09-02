import express from "express";
import morgan from "morgan";
import router from "./routes.js";

const app = express();
app.use(express.json());
app.use(morgan("dev"));

app.use("/api", router);

app.use((err, req, res, next) => {
  if (err && err.status === 400 && err.message === "VALIDATION_ERROR") {
    return res
      .status(400)
      .json({ message: "Erro de validação", issues: err.details });
  }
  console.error(err);
  res.status(500).json({ message: "Erro interno" });
});

const PORT = process.env.PORT || 3000;
app.listen(PORT, () => {
  console.log(`Salas de Aula API ouvindo em http://localhost:${PORT}/api`);
});
