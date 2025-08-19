<!DOCTYPE html>
<html lang="pt-BR">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Praticando GET</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 20px;
            max-width: 1200px;
            margin: 0 auto;
        }

        h1 {
            color: #333;
            border-bottom: 1px solid #ddd;
            padding-bottom: 10px;
            margin-bottom: 30px;
        }

        .user-link {
            display: block;
            margin-bottom: 15px;
            color: #0066cc;
            text-decoration: none;
        }

        .user-link:hover {
            text-decoration: underline;
        }

        .limpar {
            display: block;
            margin: 20px 0;
            color: #0066cc;
            text-decoration: none;
        }

        .limpar:hover {
            text-decoration: underline;
        }

        .color-samples {
            display: flex;
            justify-content: space-between;
            margin: 30px 0;
            flex-wrap: wrap;
        }

        .color-sample {
            width: 30%;
            height: 200px;
            border: 2px solid #000;
            margin-bottom: 20px;
            position: relative;
            display: flex;
            flex-direction: column;
            justify-content: flex-end;
            padding: 10px;
            box-sizing: border-box;
            color: white;
        }

        .color-red {
            background-color: #FF0000;
        }

        .color-green {
            background-color: #00FF00;
        }

        .color-blue {
            background-color: #0000FF;
        }

        .color-name {
            font-weight: bold;
            font-size: 18px;
        }

        .color-hex {
            font-size: 14px;
            margin-top: 5px;
        }

        .canva-logo {
            position: absolute;
            bottom: 10px;
            right: 10px;
            background-color: white;
            border-radius: 50%;
            width: 30px;
            height: 30px;
            display: flex;
            justify-content: center;
            align-items: center;
            font-size: 10px;
            font-weight: bold;
        }

        footer {
            background-color: #689F38;
            color: white;
            text-align: center;
            padding: 15px;
            position: fixed;
            bottom: 0;
            left: 0;
            width: 100%;
        }
    </style>
</head>

<body>
    <h1>Praticando GET</h1>

    <a href="?nome=Eder&email=epansani@gmail.com" class="user-link">[nome = Eder | email = epansani@gmail.com]</a>

    <a href="?nome=Gustavo Bizo&email=gustavobizo@protonmail.com" class="user-link">[nome = Gustavo Bizo | email =
        gustavobizo@protonmail.com]</a>

    <a href="destino-get.php" class="limpar">Limpar tudo</a>

    <div class="color-samples">
        <div class="color-sample color-red">
            <div class="color-name">Red</div>
            <div class="color-hex">#FF0000</div>
        </div>

        <div class="color-sample color-green">
            <div class="color-name">Green</div>
            <div class="color-hex">#00FF00</div>
        </div>

        <div class="color-sample color-blue">
            <div class="color-name">Blue</div>
            <div class="color-hex">#0000FF</div>
        </div>
    </div>
    <?php
    if (isset($_GET['nome']) && isset($_GET['email'])) {
        echo '<script>';
        echo 'document.title = "Usuário: ' . $_GET['nome'] . '";';
        echo '</script>';
    }
    ?>
</body>

</html>