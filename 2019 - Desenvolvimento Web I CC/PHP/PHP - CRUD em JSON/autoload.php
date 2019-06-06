<?php


    $paths = array(
        'classes' . DIRECTORY_SEPARATOR . 'DAO' . DIRECTORY_SEPARATOR,
        'classes' . DIRECTORY_SEPARATOR . 'DTO' . DIRECTORY_SEPARATOR,
        'classes' . DIRECTORY_SEPARATOR . 'BO'  . DIRECTORY_SEPARATOR,
        'interfaces' . DIRECTORY_SEPARATOR ,
        'interfaces' . DIRECTORY_SEPARATOR ,
        'interfaces' . DIRECTORY_SEPARATOR
    );

    spl_autoload_register(function ($className) {
        $paths = $GLOBALS['paths'];
        foreach($paths as $path) {
            $file = $path . $className . '.php';
           if(file_exists($file)){
                require_once $file;
           }
        }
    });

?>