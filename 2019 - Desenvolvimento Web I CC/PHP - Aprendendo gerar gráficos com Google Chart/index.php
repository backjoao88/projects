<?php

    include('autoload.php');    

    $grafico = (new Pizza())->comOTitulo("Ts")
                                ->legendadoCom("Legenda")
                                ->utilizandoADescricaoX("DescX")
                                ->utilizandoADescricaoY("DescY")
                                ->comOsValoresX(["Teste1","Teste2","Teste3","Teste4","Teste5"])
                                ->comOsValoresY([2,3,4,5,6]);

    header('Content-Type: application/json; charset=UTF-8');
    echo json_encode($grafico);

?>