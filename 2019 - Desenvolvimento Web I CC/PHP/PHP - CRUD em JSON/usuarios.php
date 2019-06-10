
<?php


    include('autoload.php');

    include('header.php');

    
    $usuarioDAO = new UsuarioDAO();
    $usuarioBO = new UsuarioBO($usuarioDAO);

    if(isset($_POST['adicionar-usuario'])){

        $id             = isset($_POST['id']) ? $_POST['id'] : '';
        $nome_usuario   = isset($_POST['usuario-nome']) ? $_POST['usuario-nome'] : '';
        $login_usuario  = isset($_POST['usuario-login']) ? $_POST['usuario-login'] : '';
        $senha_usuario  = isset($_POST['usuario-senha']) ? $_POST['usuario-senha'] : '';
        $cpf_usuario    = isset($_POST['usuario-cpf']) ? $_POST['usuario-cpf'] : '';

        $usu = (new Usuario())->utilizandoOID(intval($id))
                            ->cadastradoComOLogin($login_usuario)
                            ->cadastradoComASenha($senha_usuario)
                            ->comONome($nome_usuario)
                            ->utilizandoOCpf($cpf_usuario);

        $usuarioBO->inserir($usu);
    }

    if(isset($_POST['deletar-usuario'])){
        $linha_selecionada = $_GET['id'];
        $usu = (new Usuario())->utilizandoOID(intval($linha_selecionada));
        $usuarioBO->excluir($usu);

    }

    if(isset($_POST['editar-usuario'])){
        
        $id             = $_GET['id'];
        $nome_usuario   = isset($_POST['edit-nome']) ? $_POST['edit-nome'] : '';
        $login_usuario  = isset($_POST['edit-login']) ? $_POST['edit-login'] : '';
        $senha_usuario  = isset($_POST['edit-senha']) ? $_POST['edit-senha'] : '';
        $cpf_usuario    = isset($_POST['edit-cpf']) ? $_POST['edit-cpf'] : '';

        $usu = (new Usuario())->utilizandoOID(intval($id))
                            ->cadastradoComOLogin($login_usuario)
                            ->cadastradoComASenha($senha_usuario)
                            ->comONome($nome_usuario)
                            ->utilizandoOCpf($cpf_usuario);

        echo $usuarioBO->alterar($usu);



    }



?>

        <div class="table-wrapper">

            <div class="table-title">
                <div class="row">
                    <div class="col-sm-6">
						<h2>Tabela de Usuários</h2>
					</div>
					<div class="col-sm-6">
						<a href="#addEmployeeModal" class="btn btn-success" data-toggle="modal"><i class="material-icons">&#xE147;</i> <span>Novo Usuário</span></a>
						<a href="#deleteEmployeeModal" class="btn btn-danger" data-toggle="modal"><i class="material-icons">&#xE15C;</i> <span>Deletar</span></a>						
					</div>
                </div>
            </div>


            <table id="tabela-usuarios" class="table table-striped table-hover">
            
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Login</th>
                        <th>Senha</th>
                        <th>Nome</th>
						<th>CPF</th>
                        <th>Ações</th>
                    </tr>
                </thead>

                <tbody>
                
                <tr>
                </tr>

                </tbody>

            </table>

            <!-- Add Modal HTML -->
            <div id="addEmployeeModal" class="modal fade">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <form method="POST" enctype="multipart/form-data" autocomplete="off">
                            <div class="modal-header">						
                                <h4 class="modal-title">Adicionar Usuário</h4>
                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                            </div>
                            <div class="modal-body">
                                <div class="form-group">
                                    <label>ID</label>
                                    <input name="id" type="number" class="form-control" required>
                                </div>						
                                <div class="form-group">
                                    <label>Login</label>
                                    <input name="usuario-login" type="text" class="form-control" required>
                                </div>
                                <div class="form-group">
                                    <label>Senha</label>
                                    <input name="usuario-senha" type="password" class="form-control" required>
                                </div>
                                <div class="form-group">
                                    <label>Nome</label>
                                    <input name="usuario-nome" type="text" class="form-control" required>
                                </div>
                                <div class="form-group">
                                    <label>CPF</label>
                                    <input name="usuario-cpf" type="text" class="form-control" required>
                                </div>					
                            </div>
                            <div class="modal-footer">
                                <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancelar">
                                <input name='adicionar-usuario' type="submit" class="btn btn-success" value="Adicionar">
                            </div>
                        </form>
                    </div>
                </div>
            </div>

            <!-- Edit Modal HTML -->
            <div id="editEmployeeModal" class="modal fade">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <form method="POST">
                            <div class="modal-header">						
                                <h4 class="modal-title">Editar Usuário</h4>
                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                            </div>
                            <div class="modal-body">					
                                <div class="form-group">
                                    <label>Login</label>
                                    <input id="edit-login" name="edit-login" type="text" class="form-control" required>
                                </div>
                                <div class="form-group">
                                    <label>Senha</label>
                                    <input id="edit-senha" name="edit-senha" type="password" class="form-control" required>
                                </div>
                                <div class="form-group">
                                    <label>Nome</label>
                                    <input id="edit-nome" name="edit-nome" type="text" class="form-control" required>
                                </div>
                                <div class="form-group">
                                    <label>CPF</label>
                                    <input id="edit-cpf" name="edit-cpf" type="text" class="form-control" required>
                                </div>					
                            </div>
                            <div class="modal-footer">
                                <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancelar">
                                <input name="editar-usuario" type="submit" class="btn btn-info" value="Salvar">
                            </div>
                        </form>
                    </div>
                </div>
            </div>

            <!-- Delete Modal HTML -->
            <div id="deleteEmployeeModal" class="modal fade">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <form method="POST">
                            <div class="modal-header">						
                                <h4 class="modal-title">Deletar Usuário</h4>
                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                            </div>
                            <div class="modal-body">					
                                <p>Tem razão que deseja excluir?</p>
                                <p class="text-warning"><small>Essa ação não pode ser desfeita.</small></p>
                            </div>
                            <div class="modal-footer">
                                <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancelar">
                                <input name="deletar-usuario" type="submit" class="btn btn-danger" value="Deletar">
                            </div>
                        </form>
                    </div>
                </div>
            </div>
            

<?php




    include('footer.php');


    $lista_usuarios = [];

    $lista_usuarios = $usuarioBO->listarUsuarios();

    foreach($lista_usuarios as $usuario){
        $usuarioJson = json_encode($usuario);
        echo "<script>inserirLinhaTabelaUsuario('tabela-usuarios', $usuarioJson)</script>";
    }  
    
    
?>

