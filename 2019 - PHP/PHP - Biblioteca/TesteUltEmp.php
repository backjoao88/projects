<?php

    include('autoload.php');

    $emprestimosDAO = new EmprestimoDAOMySQL();
    $emprestimoBO = new EmprestimoBO($emprestimosDAO);

    $emp = $emprestimoBO->procurarUltimoEmprestimo();

    echo json_encode($emp);


?>