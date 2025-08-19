<?php
if ($_SERVER["REQUEST_METHOD"] == "POST") {
    $titulo = isset($_POST["titulo"]) ? htmlspecialchars($_POST["titulo"]) : "Título padrão";
    $corpo = isset($_POST["corpo"]) ? htmlspecialchars($_POST["corpo"]) : "Texto padrão";
    $cor_texto = isset($_POST["cor_texto"]) ? $_POST["cor_texto"] : "#000000";
    $url_imagem = isset($_POST["url_imagem"]) ? $_POST["url_imagem"] : "";
    $url_link = isset($_POST["url_link"]) ? $_POST["url_link"] : "#";
    $cor_fundo = isset($_POST["cor_fundo"]) ? $_POST["cor_fundo"] : "#ffffff";
} else {
    header("Location: index.html");
    exit;
}
?>

<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title><?php echo $titulo; ?></title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: <?php echo $cor_fundo; ?>;
            color: <?php echo $cor_texto; ?>;
            padding: 20px;
            max-width: 800px;
            margin: 0 auto;
        }
        h1 {
            border-bottom: 1px solid;
            padding-bottom: 10px;
        }
        .imagem-container {
            margin: 20px 0;
            text-align: center;
        }
        .imagem-container img {
            max-width: 100%;
            height: auto;
        }
        .link-container {
            margin: 20px 0;
            text-align: center;
        }
        .link-container a {
            color: <?php echo $cor_texto; ?>;
            text-decoration: underline;
            font-weight: bold;
        }
        .voltar {
            margin-top: 30px;
            text-align: center;
        }
        .voltar a {
            color: <?php echo $cor_texto; ?>;
            text-decoration: underline;
        }
    </style>
</head>
<body>
    <h1><?php echo $titulo; ?></h1>
    
    <div class="conteudo">
        <p><?php echo nl2br($corpo); ?></p>
    </div>
    
    <?php if (!empty($url_imagem)): ?>
    <div class="imagem-container">
        <img src="<?php echo $url_imagem; ?>" alt="Imagem da página">
    </div>
    <?php endif; ?>
    
    <?php if (!empty($url_link)): ?>
    <div class="link-container">
        <a href="<?php echo $url_link; ?>" target="_blank">Acesse este link</a>
    </div>
    <?php endif; ?>
    
    <div class="voltar">
        <a href="javascript:history.back()">Voltar ao formulário</a>
    </div>
</body>
</html>