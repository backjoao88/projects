<?php

    include('autoload.php');    

    $grafico = (new Pizza())->comOTitulo("Número de alunos em uma escola por série")
                                ->legendadoCom("Teste")
                                ->utilizandoADescricaoX("Série do Aluno")
                                ->utilizandoADescricaoY("Número de Alunos")
                                ->comOsValoresX(["7º ano","6º ano","5º ano"])
                                ->comOsValoresY([23,32,21]);

    header('Content-Type: application/json; charset=UTF-8');
    echo json_encode($grafico);

?>