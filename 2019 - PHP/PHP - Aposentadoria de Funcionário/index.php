<html>
    
    <?php

        include_once('autoload.php');

        $titulo        = 'Cálculo Salário Funcionario';




        if(isset($_POST['btn-enviar'])){

            $usuario               = isset($_POST['usuario']) ? $_POST['usuario'] : 0;
            $senha                 = isset($_POST['senha']) ? $_POST['senha'] : 0; 
            $nome                  = isset($_POST['nome']) ? $_POST['nome'] : 0; 
            $email                 = isset($_POST['email']) ? $_POST['email'] : 0; 
            $sexo                  = isset($_POST['sexo']) ? $_POST['sexo'] : ''; 
            $dataNascimento        = isset($_POST['data-nascimento']) ? $_POST['data-nascimento'] : 0; 
            $vetorHorasTrabalhadas = isset($_POST['horas-trabalhadas']) ? $_POST['horas-trabalhadas'] : 0;
            $vetorValorHora        = isset($_POST['valor-hora']) ? $_POST['valor-hora'] : 0;
            $qtdMaioresSalarios    = isset($_POST['qtd-menores-salarios']) ? $_POST['qtd-menores-salarios'] : 0;
            $qtdMenoresSalarios    = isset($_POST['qtd-maiores-salarios']) ? $_POST['qtd-maiores-salarios'] : 0;

            $funcionario = new Funcionario($usuario, $senha, $nome, $sexo, $email, $dataNascimento, $vetorHorasTrabalhadas, $vetorValorHora);

            $aposentadoria = new Aposentadoria($funcionario);

        }
        
    ?>

    <head>
        <meta name="author" content="João Paulo Back" charset="UTF-8">
        <title><?php echo $titulo; ?></title> 
        <script type="text/javascript" src="script/tabela.js"></script>
        <script type="text/javascript" src="script/validar.js"></script>
        <link rel="stylesheet" type="text/css" href="estilo/estilo.css">
    </head>
    <body>
        <div id="container">
            <div id="container-form">
                <form  id="entrada_dados" method="POST" enctype="multipart/form-data" onsubmit="return validar()">
                <h1>Cálculo Salário Funcionario</h1>
                    Login <input class="form-input" id="usuario" type="text" name="usuario" value=<?php if(isset($_POST['btn-enviar'])){echo $usuario;}else{echo '';} ?>> <br> <br>
                    Senha <input class="form-input" id="senha" type="password" name="senha" value=''> <br> <br>
                    Nome <input class="form-input" id="nome" type="text" name="nome" value=<?php if(isset($_POST['btn-enviar'])){echo $nome;}else{echo '';} ?>> <br> <br>
                    <input class="form-input-radio" id="sexo" type="radio" name="sexo" value="M" <?php if(isset($_POST['btn-enviar']) && $sexo == 'M'){echo 'checked';} ?>> Masculino
                    <input class="form-input-radio" id="sexo" type="radio" name="sexo" value="F" <?php if(isset($_POST['btn-enviar']) && $sexo == 'F'){echo 'checked';} ?>> Feminino <br> <br>
                    E-mail <input class="form-input" id="email" type="text" name="email" value=<?php if(isset($_POST['btn-enviar'])){echo $email;}else{echo '';} ?>> <br> <br>
                    Data Nascimento <input class="form-input" id="data-nascimento" type="date" name="data-nascimento" value=<?php if(isset($_POST['btn-enviar'])){echo $dataNascimento;}else{echo '';} ?>> <br> <br>
                    Qtd. Maiores Salários <input class="form-input" id="qtd-maiores-salarios" type="text" name="qtd-maiores-salarios" value=<?php if(isset($_POST['btn-enviar'])){echo $qtdMaioresSalarios;}else{echo '';} ?>> <br> <br>
                    Qtd. Menores Salários <input class="form-input" id="qtd-menores-salarios" type="text" name="qtd-menores-salarios" value=<?php if(isset($_POST['btn-enviar'])){echo $qtdMenoresSalarios;}else{echo '';} ?>> <br> <br>

                    <table name="info-tabela" class="info-tabela" id="tabela-salario">
                        <tr>
                            <th>Seq.</th>
                            <th>Valor Hora</th>
                            <th>Horas Trabalhadas</th>
                            <th>Remover</th>
                        </tr>
                        <button class="form-button" type="button" id="btn_adicionar_linha"> Adicionar</button> <br> <br>
                    </table>

             

                    <br><br>
                    <input class="form-button" id="btn-enviar" name="btn-enviar" value="Enviar" type="submit">
                    <br><br>
                    <hr>
                    
                </form>

                <div id="container-tabela">

                <table class="info-tabela" id="saida_dados">
                    <h1>Dados Gerais</h1>
                    <tr>
                        <th>Nome</th>
                        <td><?php if(isset($_POST['btn-enviar'])){echo $funcionario->getNome();}else{echo 0;} ?></td>
                    </tr>
                    <tr>
                        <th>Idade</th>
                        <td><?php if(isset($_POST['btn-enviar'])){echo $funcionario->calcularIdade();}else{echo 0;} ?></td>
                    </tr>
                    <tr>
                        <th>Sexo</th>
                        <td><?php if(isset($_POST['btn-enviar'])){echo $sexo;}else{echo 0;} ?></td>
                    </tr>
                    <tr>
                        <th>Email</th>
                        <td><?php if(isset($_POST['btn-enviar'])){echo $funcionario->getEmail();}else{echo 0;} ?></td>
                    </tr>
                    <tr>
                        <th>Usuario</th>
                        <td><?php if(isset($_POST['btn-enviar'])){echo $funcionario->getLogin();}else{echo 0;} ?></td>
                    </tr>
                    <tr>
                        <th>Senha</th>
                        <td><?php if(isset($_POST['btn-enviar'])){echo $funcionario->getSenha();}else{echo 0;} ?></td>
                    </tr>
                    <tr>
                        <th>Data Nascimento</th>
                        <td><?php if(isset($_POST['btn-enviar'])){echo $funcionario->getDataNascimento();}else{echo 0;} ?></td>
                    </tr>
                    <tr>
                        <th>Média Salários</th>
                        <td><?php if(isset($_POST['btn-enviar'])){echo $funcionario->mediaTodosSalarios();}else{echo 0;} ?></td>
                    </tr>
                    <tr>
                        <th>Meses Trabalhados</th>
                        <td><?php if(isset($_POST['btn-enviar'])){echo $funcionario->numeroMesesTrabalhados();}else{echo 0;} ?></td>
                    </tr>
                    <tr>
                        <th>Anos Trabalhados</th>
                        <td><?php if(isset($_POST['btn-enviar'])){echo $funcionario->numeroAnosTrabalhados();}else{echo 0;} ?></td>
                    </tr>
                    
                </table>
                
                <table class="info-tabela" id="tabela-valor-horas-trabalhadas">
                    <h1>Valor Hora e Horas Trabalhadas</h1>
                    <tr>
                        <th>Seq.</th>
                        <th>Valor Hora</th>
                        <th>Horas Trabalhadas</th>
                    </tr>
                    <?php
                        if(isset($_POST['btn-enviar'])){
                            for ($i = 0; $i < $funcionario->numeroMesesTrabalhados(); $i++){
                                echo '<tr><td>' . $i . '</td><td>' . $funcionario->getVetorValorHora()[$i]. '</td><td>'.$funcionario->getVetorHorasTrabalhadas()[$i] .'</td></tr>';
                            }
                        }
                    ?>
                </table>

                <table class="info-tabela" id="salarios">
                    <h1>Salarios</h1>
                    <tr>
                        <th>Seq.</th>
                        <th>Salário</th>
                    </tr>
                    <?php
                        if(isset($_POST['btn-enviar'])){
                            for ($i = 0; $i < $funcionario->numeroMesesTrabalhados(); $i++){
                                echo '<tr><td>' . $i . '</td><td>' . $funcionario->calcularSalarioMes($i). '</td></tr>';
                            }
                        }
                    ?>
                </table>

                <table class="info-tabela" id="n-menores-salarios">
                    <h1>Os N Menores Salarios</h1>
                    <tr>
                        <th>Salário</th>
                    </tr>
                    <?php
                        if(isset($_POST['btn-enviar'])){
                            $menoresSalarios = $funcionario->menoresSalariosAte($qtdMenoresSalarios);
                            for ($i = 0; $i < sizeof($menoresSalarios); $i++){
                                echo '<tr><td>'. $menoresSalarios[$i] .'</td></tr>';
                            }
                        }
                    ?>
                </table>

                <table class="info-tabela" id="n-maiores-salarios">
                <h1>Os N Maiores Salários</h1>
                    <tr>
                        <th>Salário</th>
                    </tr>
                    <?php
                        if(isset($_POST['btn-enviar'])){
                            $maioresSalarios = $funcionario->maioresSalariosAte($qtdMaioresSalarios);
                            for ($i = 0; $i < sizeof($maioresSalarios); $i++){
                                echo '<tr><td>'. $maioresSalarios[$i] .'</td></tr>';
                            }
                        }
                    ?>
                </table>

                <table class="info-tabela" id="tabela-aposentadoria">
                <h1>Dados Aposentadoria</h1>
                    <tr>
                        <th>Idade Atual</th>
                        <th>Anos Contribuidos</th>
                        <th>Idade Aposentadoria</th>
                        <th>Ano Aposentadoria</th>
                    </tr>
                    <tr>
                    <td><?php if(isset($_POST['btn-enviar'])){echo $funcionario->calcularIdade();}?></td>
                    <td><?php if(isset($_POST['btn-enviar'])){echo $funcionario->numeroAnosTrabalhados();}?></td>
                    <td><?php if(isset($_POST['btn-enviar'])){echo $aposentadoria->calcularIdadeNaAposentadoria();}?></td>
                    <td><?php if(isset($_POST['btn-enviar'])){echo $aposentadoria->calcularAnoQueIraAposentar();} ?></td></tr>

                </table>
                
                
            </div>

            </div>
        </div>
    </body>
</html>