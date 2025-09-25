const mdlClientes = require("../model/mdlClientes");

const GetAllClientes = (req, res) =>
  (async () => {
    let registro = await mdlClientes.GetAllClientes();
    res.json({ status: "ok", registro: registro });
  })();

const GetClienteByID = (req, res) =>
  (async () => {
    const clientID = req.body.clienteid;

    let registro = await mdlClientes.GetClienteByID(clientID);
    res.json({ status: "ok", registro: registro });
  })();

const InsertCliente = (request, res) =>
  (async () => {
    const registro = request.body;
    let { msg, linhasAfetadas } = await mdlClientes.InsertCliente(registro);
    res.json({ status: msg, linhasAfetadas: linhasAfetadas });
  })();

const UpdateClientes = (request, res) =>
  (async () => {
    const registro = request.body;
    let { msg, linhasAfetadas } = await mdlClientes.UpdateCliente(registro);
    res.json({ status: msg, linhasAfetadas: linhasAfetadas });
  })();

const DeleteClientes = (request, res) =>
  (async () => {
    const registro = request.body;
    let { msg, linhasAfetadas } = await mdlClientes.DeleteCliente(registro);
    res.json({ status: msg, linhasAfetadas: linhasAfetadas });
  })();

module.exports = {
  GetAllClientes,
  GetClienteByID,
  InsertCliente,
  UpdateClientes,
  DeleteClientes,
};
