<?php

    include('autoload.php');    
/*

    $grafico = (new Pizza())->comOTitulo("Numero de alunos em uma escola por serie")
                                ->legendadoCom("Teste")
                                ->utilizandoADescricaoX("Serie do Aluno")
                                ->utilizandoADescricaoY("Numero de Alunos")
                                ->comOsValoresX(["7 ano","6 ano","5 ano"])
                                ->comOsValoresY([23,32,21])
                                ->comOTamanhoDoBuracoDe(30)
                                ->deAnguloDeInicio(40)
                                ->comAlturaDe(500)
                                ->comLarguraDe(500);
                                

    $grafico = (new Barra())->comOTitulo("Numero de alunos em uma escola por serie")
                                ->legendadoCom("Teste")
                                ->utilizandoADescricaoX("Serie do Aluno")
                                ->utilizandoADescricaoY("Numero de Alunos")
                                ->comOsValoresX(["7 ano","6 ano","5 ano"])
                                ->comOsValoresY([23,32,21])
                                ->comALarguraDeBarra(30)
                                ->comAlturaDe(500)
                                ->comLarguraDe(500);
*/
    
    $grafico = (new Linha())->comOTitulo("Numero de alunos em uma escola por 2")
                                ->legendadoCom("Teste")
                                ->utilizandoADescricaoX("Serie do Aluno")
                                ->utilizandoADescricaoY("Numero de Alunos")
                                ->comOsValoresX(["7 ano","6 ano","5 ano"])
                                ->comOsValoresY([23,355,21])
                                ->comOTipoDeCurva('function') 
                                ->comAlturaDe(500)
                                ->comLarguraDe(600);

    header('Content-Type: application/json; charset=UTF-8');
    echo json_encode($grafico);


    

?>