<?php

    include('autoload.php');

    $cli = new Cliente('João', 'teste');
    echo $cli->toString();


?>