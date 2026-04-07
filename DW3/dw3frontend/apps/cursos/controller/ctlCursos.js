const axios = require("axios");
const moment = require("moment");

// Listagem e manutenção de cursos
const manutCursos = async (req, res) =>
  (async () => {
    const userName = req.session.userName;
    const token = req.session.token;

    const resp = await axios.get(process.env.SERVIDOR_DW3Back + "/GetAllCursos", {
      headers: {
        "Content-Type": "application/json",
        Authorization: `Bearer ${token}`
      }
    }).catch(error => {
      let remoteMSG;
      if (error.code === "ECONNREFUSED") {
        remoteMSG = "Servidor indisponível";
      } else if (error.code === "ERR_BAD_REQUEST") {
        remoteMSG = "Usuário não autenticado";
      } else {
        remoteMSG = error.message;
      }
      return res.render("cursos/view/vwManutCursos.njk", {
        title: "Manutenção de cursos",
        data: null,
        erro: remoteMSG,
        userName: userName,
      });
    });

    if (!resp) return;

    res.render("cursos/view/vwManutCursos.njk", {
      title: "Manutenção de cursos",
      data: resp.data.registro,
      erro: null,
      userName: userName,
    });
  })();

// Cadastro de cursos
const insertCursos = async (req, res) =>
  (async () => {
    const token = req.session.token;
    if (req.method == "GET") {
      return res.render("cursos/view/vwFCrCursos.njk", {
        title: "Cadastro de cursos",
        data: null,
        erro: null,
        userName: req.session.userName,
      });
    } else {
      const regData = req.body;
      try {
        const response = await axios.post(process.env.SERVIDOR_DW3Back + "/InsertCursos", regData, {
          headers: {
            'Content-Type': 'application/json',
            'Authorization': `Bearer ${token}`
          },
          timeout: 5000,
        });

        res.json({
          status: response.data.status,
          msg: response.data.status,
          data: response.data,
          erro: null,
        });
      } catch (error) {
        res.json({
          status: "Error",
          msg: error.message,
          data: null,
          erro: null,
        });
      }
    }
  })();

// Visualização de curso
const ViewCursos = async (req, res) =>
  (async () => {
    const userName = req.session.userName;
    const token = req.session.token;
    try {
      if (req.method == "GET") {
        const id = req.params.id;
        const response = await axios.post(
          process.env.SERVIDOR_DW3Back + "/GetCursoByID",
          { cursoid: id },
          {
            headers: {
              "Content-Type": "application/json",
              Authorization: "Bearer " + token,
            },
          }
        );
        if (response.data.status == "ok") {
          res.render("cursos/view/vwFRUDrCursos.njk", {
            title: "Visualização de cursos",
            data: response.data.registro[0],
            disabled: true,
            userName: userName,
          });
        } else {
          res.json({ status: "Curso não localizado!" });
        }
      }
    } catch (erro) {
      res.json({ status: "[ctlCursos.js|ViewCursos] Curso não localizado!" });
    }
  })();

// Atualização de curso
const UpdateCurso = async (req, res) =>
  (async () => {
    const userName = req.session.userName;
    const token = req.session.token;
    try {
      if (req.method == "GET") {
        const id = req.params.id;
        const response = await axios.post(
          process.env.SERVIDOR_DW3Back + "/GetCursoByID",
          { cursoid: id },
          {
            headers: {
              "Content-Type": "application/json",
              Authorization: "Bearer " + token,
            },
          }
        );
        if (response.data.status == "ok") {
          res.render("cursos/view/vwFRUDrCursos.njk", {
            title: "Atualização de dados de cursos",
            data: response.data.registro[0],
            disabled: false,
            userName: userName,
          });
        } else {
          res.json({ status: "Curso não localizado!" });
        }
      } else {
        const regData = req.body;
        try {
          const response = await axios.post(process.env.SERVIDOR_DW3Back + "/UpdateCursos", regData, {
            headers: {
              'Content-Type': 'application/json',
              'Authorization': `Bearer ${token}`
            },
            timeout: 5000,
          });

          res.json({
            status: response.data.status,
            msg: response.data.status,
            data: response.data,
            erro: null,
          });
        } catch (error) {
          res.json({
            status: "Error",
            msg: error.message,
            data: null,
            erro: null,
          });
        }
      }
    } catch (erro) {
      res.json({ status: "[ctlCursos.js|UpdateCurso] Curso não localizado!" });
    }
  })();

// Exclusão de curso
const DeleteCurso = async (req, res) =>
  (async () => {
    const regData = req.body;
    const token = req.session.token;
    try {
      const response = await axios.post(process.env.SERVIDOR_DW3Back + "/DeleteCursos", regData, {
        headers: {
          'Content-Type': 'application/json',
          'Authorization': `Bearer ${token}`
        },
        timeout: 5000,
      });

      res.json({
        status: response.data.status,
        msg: response.data.status,
        data: response.data,
        erro: null,
      });
    } catch (error) {
      res.json({
        status: "Error",
        msg: error.message,
        data: null,
        erro: null,
      });
    }
  })();

module.exports = {
  manutCursos,
  insertCursos,
  ViewCursos,
  UpdateCurso,
  DeleteCurso
};
