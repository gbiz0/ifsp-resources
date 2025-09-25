const mdlPedidos = require("../model/mdlPedidos");

const GetAllPedidos = (req, res) =>
  (async () => {
    let registro = await mdlPedidos.getAllPedidos();
    res.json({ status: "ok", registro: registro });
  })();

const GetPedidoByID = (req, res) =>
  (async () => {
    const pID = parseInt(req.body.pedidoid);
    let registro = await mdlPedidos.getPedidoByID(pID);

    res.json({ status: "ok", registro: registro });
  })();

const InsertPedido = (request, res) =>
  (async () => {
    const registro = request.body;
    let { msg, linhasAfetadas } = await mdlPedidos.insertPedidos(registro);
    res.json({ status: msg, linhasAfetadas: linhasAfetadas });
  })();

const UpdatePedidos = (request, res) =>
  (async () => {
    const registro = request.body;
    let { msg, linhasAfetadas } = await mdlPedidos.UpdatePedidos(registro);
    res.json({ status: msg, linhasAfetadas: linhasAfetadas });
  })();

const DeletePedidos = (request, res) =>
  (async () => {
    const registro = request.body;
    let { msg, linhasAfetadas } = await mdlPedidos.DeletePedidos(registro);
    res.json({ status: msg, linhasAfetadas: linhasAfetadas });
  })();

module.exports = {
  GetAllPedidos,
  GetPedidoByID,
  InsertPedido,
  UpdatePedidos,
  DeletePedidos,
};
