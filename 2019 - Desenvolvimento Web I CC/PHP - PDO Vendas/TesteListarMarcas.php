<?php

    include('autoload.php');

    $marcaDAO = new MarcaDAO();
    $marcaBO = new MarcaBO($marcaDAO);

    header('Content-Type: application/json');
    echo json_encode($marcaBO->listarMarcas(), JSON_PRETTY_PRINT);

?>