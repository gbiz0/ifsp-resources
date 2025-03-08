<!DOCTYPE html>
<html lang="pt-BR">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Formulário</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            max-width: 800px;
            margin: 0 auto;
            padding: 20px;
        }

        h1 {
            color: #333;
            border-bottom: 1px solid #ddd;
            padding-bottom: 10px;
        }

        .form-group {
            margin-bottom: 15px;
            display: flex;
            align-items: center;
        }

        .form-group label {
            width: 250px;
            text-align: right;
            padding-right: 15px;
        }

        .form-group input,
        .form-group textarea {
            flex: 1;
            padding: 8px;
            border: 1px solid #ddd;
            border-radius: 4px;
        }

        .form-group textarea {
            min-height: 100px;
        }

        .buttons {
            margin-top: 20px;
            text-align: center;
        }

        .btn-enviar {
            background-color: #007bff;
            color: white;
            border: none;
            padding: 10px 20px;
            border-radius: 4px;
            cursor: pointer;
        }

        .btn-limpar {
            background-color: #ffc107;
            color: black;
            border: none;
            padding: 10px 20px;
            border-radius: 4px;
            margin-left: 10px;
            cursor: pointer;
        }
    </style>
</head>

<body>
    <h1>Formulário</h1>

    <form action="pagina_destino.php" method="POST">
        <div class="form-group">
            <label for="titulo">Título da página:</label>
            <input type="text" id="titulo" name="titulo" required>
        </div>

        <div class="form-group">
            <label for="corpo">Corpo:</label>
            <textarea id="corpo" name="corpo" required></textarea>
        </div>

        <div class="form-group">
            <label for="cor_texto">Cor texto:</label>
            <input type="color" id="cor_texto" name="cor_texto" value="#000000">
        </div>

        <div class="form-group">
            <label for="url_imagem">URL de uma imagem:</label>
            <input type="url" id="url_imagem" name="url_imagem">
        </div>

        <div class="form-group">
            <label for="url_link">URL de link:</label>
            <input type="url" id="url_link" name="url_link">
        </div>

        <div class="form-group">
            <label for="cor_fundo">Cor de plano de fundo da página:</label>
            <input type="color" id="cor_fundo" name="cor_fundo" value="#ffffff">
        </div>

        <div class="buttons">
            <button type="submit" class="btn-enviar">Enviar</button>
            <button type="reset" class="btn-limpar">Limpar</button>
        </div>
    </form>
</body>

</html>