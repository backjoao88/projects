<?php
spl_autoload_register(function ($class_name) {
    include_once 'classes'. DIRECTORY_SEPARATOR . $class_name . '.php';
});
?>