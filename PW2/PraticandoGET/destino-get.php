<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Destino GET</title>
</head>
<body>
    <div class="container">
        <h1 class="my-3">Destino GET</h1>
        <hr>
        <?php
        $nome = filter_input(INPUT_GET, "nome", FILTER_SANITIZE_SPECIAL_CHARS);
        $email = filter_input(INPUT_GET, "email", FILTER_SANITIZE_EMAIL);
        $cor = filter_input(INPUT_GET, "cor", FILTER_SANITIZE_SPECIAL_CHARS);

        echo "<p>Nome informado: $nome<br>Email: $email</p>";
        ?>
        <br>
        <p>
            <a href="index.php">Voltar para o formulário</a>
        </p>

        <style>
            body{
                background-color: <?php echo $cor; ?>;
            }
        </style>
    </div>
</body>
</html>