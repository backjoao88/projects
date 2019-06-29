<?php

    include('autoload.php');

    $livroDAO = new LivroDAOMySQL();
    $livroBO = new LivroBO($livroDAO);

    $livro = $livroBO->procurarLivroPorId((new Livro())->setLivroId(3));

    echo json_encode($livro, JSON_PRETTY_PRINT);



?>