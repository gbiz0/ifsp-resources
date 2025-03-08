<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>

<body>
    <h1>My first PHP page</h1>
    <?php 
    echo "Hello World!" ; 

    $nome = "Gustavo Bizo";
    $data = date("d/m/Y");
    $hora = date("H:i:s");

    echo "<br>Olá, eu sou $nome! Hoje é $data e agora são $hora.";
    
    ?>
</body>

</html>