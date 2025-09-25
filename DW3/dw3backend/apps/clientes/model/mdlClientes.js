const db = require("../../../database/databaseconfig");

const GetAllClientes = async () => {
  return (
    await db.query(
      `
            SELECT 
                *
            FROM
                clientes
            WHERE
                deleted = false
            `
    )
  ).rows;
};

const GetClienteByID = async (clienteIDPar) => {
  return (
    await db.query(
      `
            SELECT
                *
            FROM 
                clientes
            WHERE
                clienteid = $1 AND 
                deleted = false
            `,
      [clienteIDPar]
    )
  ).rows;
};

const InsertCliente = async (registroPar) => {
  let linhasAfetadas;
  let msg = "ok";
  try {
    linhasAfetadas = (
      await db.query(
        `
                INSERT INTO clientes 
                VALUES (
                    default,
                    $1,
                    $2,
                    $3,
                    $4,
                    false
                )
                `,
        [
          registroPar.codigo,
          registroPar.nome,
          registroPar.endereco,
          registroPar.ativo,
        ]
      )
    ).rowCount;
  } catch (error) {
    msg = "[mdlClientes|insert] " + error.detail;
    linhasAfetadas = -1;
  }

  return { msg, linhasAfetadas };
};

const UpdateCliente = async (registroPar) => {
  let linhasAfetadas;
  let msg = "ok";
  try {
    linhasAfetadas = (
      await db.query(
        `
                UPDATE clientes SET 
                    codigo = $2,
                    nome = $3,
                    endereco = $4,
                    ativo = $5,
                    deleted = $6
                WHERE clienteid = $1
                `,[
          registroPar.clienteid,
          registroPar.codigo,
          registroPar.nome,
          registroPar.endereco,
          registroPar.ativo,
          registroPar.deleted
        ]
      )
    ).rowCount;
  } catch (error) {
    msg = "[mdlClientes|UpdateClientes] " + error.detail;
    linhasAfetadas = -1;
  }

  return { msg, linhasAfetadas };
};

const DeleteCliente = async (registroPar) => {
  let linhasAfetadas;
  let msg = "ok";
  try {
    linhasAfetadas = (
      await db.query(
        `
                UPDATE clientes SET
                    deleted = true
                WHERE 
                    clienteid = $1
                `,
        [registroPar.clienteid]
      )
    ).rowCount;
  } catch (error) {
    msg = "[mdlClientes|DeleteCliente] " + error.detail;
    linhasAfetadas = -1;
  }

  return { msg, linhasAfetadas };
};

module.exports = {
  GetAllClientes,
  GetClienteByID,
  InsertCliente,
  UpdateCliente,
  DeleteCliente,
};
