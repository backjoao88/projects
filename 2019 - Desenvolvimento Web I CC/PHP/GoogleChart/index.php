<?php

    include('autoload.php');    

    $grafico = (new Grafico())->comOTitulo("Titulo")
                                ->legendadoCom("Legenda")
                                ->utilizandoADescricaoX("DescX")
                                ->utilizandoADescricaoY("DescY")
                                ->comOsValoresX([2,3,4,5,6,7,8])
                                ->comOsValoresY([2,3,4,5,6,7,8]);

    header('Content-Type: application/json; charset=UTF-8');
    echo json_encode($grafico);

?>