const express = require("express");
const routerApp = express.Router();

const appAlunos = require("../apps/alunos/controller/ctlAlunos");
const appCursos = require("../apps/cursos/controller/ctlCursos");
const appLogin = require("../apps/login/controller/ctlLogin");
const appPedidos = require("../apps/pedidos/controller/ctlPedidos");
const appClientes = require("../apps/clientes/controller/ctlClientes");
// middleware that is specific to this router
routerApp.use((req, res, next) => {
  next();
});

routerApp.get("/", (req, res) => {
  res.send("Olá mundo!");
});

//Rotas de Alunos
routerApp.get("/getAllAlunos", appLogin.AutenticaJWT, appAlunos.getAllAlunos);
routerApp.post("/getAlunoByID", appLogin.AutenticaJWT, appAlunos.getAlunoByID);
routerApp.post("/insertAlunos", appLogin.AutenticaJWT, appAlunos.insertAlunos);
routerApp.post("/updateAlunos", appLogin.AutenticaJWT, appAlunos.updateAlunos);
routerApp.post("/DeleteAlunos", appLogin.AutenticaJWT, appAlunos.DeleteAlunos);

//Rotas de Cursos
routerApp.get("/GetAllCursos", appLogin.AutenticaJWT, appCursos.GetAllCursos);
routerApp.post("/GetCursoByID", appLogin.AutenticaJWT, appCursos.GetCursoByID);
routerApp.post("/InsertCursos", appLogin.AutenticaJWT, appCursos.InsertCursos);
routerApp.post("/UpdateCursos", appLogin.AutenticaJWT, appCursos.UpdateCursos);
routerApp.post("/DeleteCursos", appLogin.AutenticaJWT, appCursos.DeleteCursos);

// Rota Login
routerApp.post("/Login", appLogin.Login);
routerApp.post("/Logout", appLogin.Logout);


// Rotas de Pedidos
routerApp.get("/GetAllPedidos", appLogin.AutenticaJWT, appPedidos.GetAllPedidos);
routerApp.get("/GetPedidoById", appLogin.AutenticaJWT, appPedidos.GetPedidoByID)
routerApp.post("/InsertPedidos", appLogin.AutenticaJWT, appPedidos.InsertPedido);
routerApp.post("/UpdatePedidos", appLogin.AutenticaJWT, appPedidos.UpdatePedidos);
routerApp.post("/DeletePedidos", appLogin.AutenticaJWT, appPedidos.DeletePedidos);

// Rotas de Clientes
routerApp.get("/GetAllClientes", appLogin.AutenticaJWT, appClientes.GetAllClientes);
routerApp.get("/GetClienteById", appLogin.AutenticaJWT, appClientes.GetClienteByID)
routerApp.post("/InsertClientes", appLogin.AutenticaJWT, appClientes.InsertCliente);
routerApp.post("/UpdateClientes", appLogin.AutenticaJWT, appClientes.UpdateClientes);
routerApp.post("/DeleteClientes", appLogin.AutenticaJWT, appClientes.DeleteClientes);

module.exports = routerApp;