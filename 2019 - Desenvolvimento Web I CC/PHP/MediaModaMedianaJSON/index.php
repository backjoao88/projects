<html>
    
    <?php

        define("ALLOWED_EXTENSION", 'json');

        $title = "Calculadora de Média, Moda e Mediana com JSON"; 

        $numElementos = $mediana   = $moda = $media = $soma = 0;
        $valuesUploadedTextFormat  = $valuesStringFormat = "";
        $valuesArrayFormat         = array();
        $valuesStringFormat        = isset($_POST['valores'])? $_POST['valores'] : "";
        $valuesArrayFormat         = explode(";", $valuesStringFormat); 

        array_pop($valuesArrayFormat);

        function sum($valuesArrayFormat){
            return number_format(array_sum($valuesArrayFormat), 2);
        }

        function countElements($valuesArrayFormat){
            return number_format(count(array_filter($valuesArrayFormat)), 2);
        }

        function media($valuesArrayFormat){

            if(count(array_filter($valuesArrayFormat)) > 0){

                $soma = 0;
                $media = 0;
                
                foreach($valuesArrayFormat as $valor){
                    $soma = $soma + $valor;
                }

                $media = $soma / count($valuesArrayFormat);

                return  number_format($media, 2);
            }else{
                return 0;
            }

        }

        function mediana($valuesArrayFormat){
            if(count(array_filter($valuesArrayFormat))){
                $resto = count($valuesArrayFormat) % 2;
                $indiceMeio =  count($valuesArrayFormat) / 2;
                if($resto == 0){
                    $indiceMeioPost = 0;
                    $indiceMeioPost = $indiceMeio - 1;
                    return number_format(($valuesArrayFormat[$indiceMeio] + $valuesArrayFormat[$indiceMeioPost])/2, 2);
                }else{
                    return number_format($valuesArrayFormat[$indiceMeio], 2);
                }
            }else{
                return 0;
            }
        }

        function moda($valuesArrayFormat) {
            if(count(array_filter($valuesArrayFormat))){
                $ocorrencias = 0;
                $ocorrenciasCadaValor = array();
                $valorComMaiorOcorrencias = 0;

                for ($i = 0; $i < count($valuesArrayFormat); $i++){
                    for ($j = 0; $j < count($valuesArrayFormat); $j++){
                        if($valuesArrayFormat[$i] == $valuesArrayFormat[$j]){
                            $ocorrencias++;
                        }
                    }
                    if($ocorrencias > $valorComMaiorOcorrencias){
                        $valorComMaiorOcorrencias = $valuesArrayFormat[$i];
                    }
                    $ocorrencias = 0;
                }

                return  number_format($valorComMaiorOcorrencias,2);
            }else{
                return 0;
            }       
        }

        if(isset($_POST['calcular'])){

            $numElementos   = countElements($valuesArrayFormat); 
            $mediana        = mediana($valuesArrayFormat);
            $moda           = moda($valuesArrayFormat);
            $media          = media($valuesArrayFormat);
            $soma           = sum($valuesArrayFormat);   
        }
        
        if (isset($_POST['salvar_json'])) { 

            $valuesIntegerFormat = array();

            for($i = 0; $i < count($valuesArrayFormat); $i++){
                $valuesIntegerFormat[$i] = intval($valuesArrayFormat[$i]);
            }
            
            $json = json_encode($valuesIntegerFormat);
            $dataAtual = date("d-m-Y-H-i-s");
            $fp = fopen("json$dataAtual.json", "w");
            fwrite($fp, $json);
            fclose($fp);
        }

        if (isset($_POST['upload_files'])){

            $valuesUploadedStringFormat = '';
            $valuesUploadedArrayFormat  = array();
            $valuesUploadedTextFormat   = '';
            $file_directory_name        = isset($_FILES["searched_file"]["tmp_name"]) ? $_FILES["searched_file"]["tmp_name"] : FALSE;
            $file_extension_name        = pathinfo(($_FILES["searched_file"]["name"]), PATHINFO_EXTENSION);

            if($file_extension_name == ALLOWED_EXTENSION){
                $valuesUploadedStringFormat = file_get_contents($file_directory_name);
                $valuesUploadedArrayFormat  = json_decode($valuesUploadedStringFormat);
                for ($i = 0; $i < count($valuesUploadedArrayFormat); $i++){
                    $valuesUploadedTextFormat .= $valuesUploadedArrayFormat[$i] . ";";
                }
            }
        }

    ?>

    <head>
        <meta name="author" content="João Paulo Back" charset="UTF-8">
        <title><?php echo $title; ?></title> 
        <link rel="stylesheet" type="text/css" href="estilo.css">
        <script type="text/javascript" src="script.js"></script>

    </head>
    <body>
        <div id="container">
            <div id="container-form">
                <form id="entrada_dados" method="POST" enctype="multipart/form-data">
                    <h2> Medidas de Tendência Central </h2>
                    <fieldset style="border: none;">
                        <textarea id="entrada_dados_textarea" name="valores" rows="10" cols="90"><?php if (isset($_POST['upload_files'])){echo $valuesUploadedTextFormat;}else{echo $valuesStringFormat;} ?></textarea>

                        <div style="display: block"><br>
                            <input id="save_json_btn" name="salvar_json" value="Salvar JSON" type="submit">

                            <input id="calculate_btn" name="calcular" value="Calcular" type="submit">
                            <!--<input id="clear_btn" value="Limpar Resultados" type="button"> -->
            
                            <label for='searched_file'>Selecionar arquivo</label>           
                            <input id="searched_file" name="searched_file" type="file">
                            <input id="upload_files" name="upload_files" value="Upload" type="submit" hidden>
                        </div>

                    </fieldset>

                    <br>
                </form>
            </div>
            <div id="container-table">
                <table id="saida_dados">
                    <tr>
                        <th>Número de Elementos</th>
                        <th>Somatório</th>
                        <th>Média</th>
                        <th>Mediana</th>
                        <th>Moda</th>
                    </tr>
                    <tr>
                        <td><?php echo $numElementos ?></td>
                        <td><?php echo $soma ?></td>
                        <td><?php echo $media ?></td>
                        <td><?php echo $mediana ?></td>
                        <td><?php echo $moda ?></td>
                    </tr>
                </table>
            </div>
        </div>

    </body>

</html>