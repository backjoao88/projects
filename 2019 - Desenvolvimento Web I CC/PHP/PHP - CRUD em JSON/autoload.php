<?php

    spl_autoload_register(function ($className) {
        include 'classes' . DIRECTORY_SEPARATOR . $className . '.php';
    });

?>