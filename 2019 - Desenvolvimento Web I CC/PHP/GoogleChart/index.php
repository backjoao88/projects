<!DOCTYPE html>

<html>

    <?php

        include('autoload.php');    

        if(isset($_POST['btn-gerar-grafico'])){

            $titulo         = isset($_POST['titulo']) ? $_POST['titulo'] : '';
            $legenda        = isset($_POST['legenda']) ? $_POST['legenda'] : '';
            $desc_coluna    = isset($_POST['desc-coluna']) ? $_POST['desc-coluna'] : '';
            $desc_linha     = isset($_POST['desc-linha']) ? $_POST['desc-linha'] : '';
            $x        = isset($_POST['x']) ? $_POST['x'] : '';
            $y        = isset($_POST['y']) ? $_POST['y'] : '';

            $grafico = (new Grafico())->comOTitulo($titulo)
                                      ->legendadoCom($legenda)
                                      ->utilizandoADescricaoX($desc_linha)
                                      ->utilizandoADescricaoY($desc_coluna)
                                      ->comOsValoresX($x)
                                      ->comOsValoresY($y);

            echo $grafico->toString();

        }

    ?>
    
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Visualização de Gr   áficos</title>
    <style>

        #container{
            margin-top: 50px;
            width: 750px;
            margin: 0 auto;
        }

        #tabela-x-y thead tr th{
            width: 45%;
        }

    </style>
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <link   rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
</head>

<body>

    <div id="container">

        <form method="POST">

            <div class="form-group">						
                <h4 class="modal-title">Visualização de Gráficos</h4>
            </div>
            
            <div class="form-group">					
                <div class="form-group">
                    <label>Título</label>
                    <input id="desc-titulo" name="titulo" type="text" class="form-control" required>
                </div>
                <div class="form-group">
                    <label>Legenda</label>
                    <input id="desc-linha" name="legenda" type="text" class="form-control" required>
                </div>	
                <div class="form-group">
                    <label>Descrição Coluna</label>
                    <input id="desc-coluna" name="desc-coluna" type="text" class="form-control" required>
                </div>
                <div class="form-group">
                    <label>Descrição Linha</label>
                    <input id="desc-coluna" name="desc-linha" type="text" class="form-control" required>
                </div>
                <div class="form-group">
                <label>Tabela de Valores</label>
                    <div class="modal-header">
                        <label></label>						
                        <button id="btn_adicionar_linha" type="button" class="btn btn-default btn-sm" data-dismiss="modal"><span class="glyphicon glyphicon-plus"></span>&plus;</button>
                    </div>
                    <table id="tabela-x-y" class="table table-hover" class="form-control" style="width:100%">
                        <thead>
                            <tr>
                                <th>X</th>
                                <th>Y</th>
                                <th>Ação</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>

                            </tr>
                        </tbody>
                    </table>
                </div>							
            </div>

            <div class="form-group">
                <input name="btn-gerar-grafico" type="submit" class="btn btn-info" value="Salvar">
            </div>

        </form>

    </div>


    <div id="piechart_3d"></div>
    <!-- https://google-developers.appspot.com/chart/interactive/docs/gallery/piechart -->
    
    <script src="piechart.js"></script>
    <script src="tabela.js"></script>
</body>
</html>