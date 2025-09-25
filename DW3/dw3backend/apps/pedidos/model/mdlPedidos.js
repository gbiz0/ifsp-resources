const db = require("../../../database/databaseconfig");

const getAllPedidos = async () => {
  return (
    await db.query(
      `SELECT p.* FROM pedidos p
            where p.deleted = false
            `
    )
  ).rows;
};

const getPedidoByID = async (PedidoIDPar) => {
  return (
    await db.query(
      `
        SELECT p.*, c.nome FROM pedidos p
        INNER JOIN clientes c
            ON c.clienteid = pedidoid
        WHERE pedidoid = $1
    `,
      [PedidoIDPar]
    )
  ).rows;
};

const insertPedidos = async (PedidoREGPar) => {
  let linhasAfetadas;
  let msg = "ok";
  try {
    linhasAfetadas = (
      await db.query(
        `
                INSERT INTO pedidos
                (
                    numero,
                    data,
                    valortotal,
                    clienteid,
                    deleted
                )
                VALUES
                (
                    $1,
                    $2,
                    $3,
                    $4,
                    false
                )
                `,
        [
          PedidoREGPar.numero,
          PedidoREGPar.data,
          PedidoREGPar.valortotal,
          PedidoREGPar.clienteid,
        ]
      )
    ).rowCount;
  } catch (error) {
    msg = "[mdlPedidos|insertPedidos] " + error.detail;
    linhasAfetadas = -1;
  }

  return { msg, linhasAfetadas };
};

const UpdatePedidos = async (PedidoREGPar) => {
  let linhasAfetadas;
  let msg = "ok";
  try {
    linhasAfetadas = (
      await db.query(
        `
                UPDATE pedidos SET 
                    numero = $1,
                    data = $2,
                    valortotal = $3,
                    clienteid = $4,
                    deleted = $5
                WHERE Pedidoid = $6
                `,
        [
          PedidoREGPar.numero,
          PedidoREGPar.data,
          PedidoREGPar.valortotal,
          PedidoREGPar.clienteid,
          PedidoREGPar.deleted,
          PedidoREGPar.pedidoid,
        ]
      )
    ).rowCount;
  } catch (error) {
    msg = "[mdlPedidos|updatePedidos] " + error.detail;
    linhasAfetadas = -1;
  }

  return { msg, linhasAfetadas };
};

const DeletePedidos = async (PedidoREGPar) => {
  let linhasAfetadas;
  let msg = "ok";

  try {
    linhasAfetadas = (
      await db.query(
        `
                UPDATE pedidos SET 
                    deleted = true
                WHERE 
                    pedidoid = $1
                `,
        [PedidoREGPar.pedidoid]
      )
    ).rowCount;
  } catch (error) {
    msg = "[mdlPedidos|deletePedidos] " + error.detail;
    linhasAfetadas = -1;
  }

  return { msg, linhasAfetadas };
};

module.exports = {
  getAllPedidos,
  getPedidoByID,
  insertPedidos,
  UpdatePedidos,
  DeletePedidos,
};
