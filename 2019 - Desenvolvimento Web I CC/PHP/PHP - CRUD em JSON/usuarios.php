<?php

    include('autoload.php');
    include('header.php');

    $lista_usuarios = [];

    $usuarioDAO = new UsuarioDAO();
    $usuarioBO = new UsuarioBO($usuarioDAO);

    $lista_usuarios = $usuarioBO->listarUsuarios();



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
						<th>
							<span class="custom-checkbox">
								<input type="checkbox" id="selectAll">
								<label for="selectAll"></label>
							</span>
						</th>
                        <th>ID</th>
                        <th>Nome</th>
						<th>CPF</th>
                    </tr>
                </thead>

                <tbody>
                    <tr>

						<td>
							<span class="custom-checkbox">
								<input type="checkbox" id="checkbox1" name="options[]" value="1">
								<label for="checkbox1"></label>
							</span>
						</td>

                        <td>Thomas Hardy</td>
                        <td>thomashardy@mail.com</td>
						<td>89 Chiaroscuro Rd, Portland, USA</td>

                        <td>
                            <a href="#editEmployeeModal" class="edit" data-toggle="modal"><i class="material-icons" data-toggle="tooltip" title="Edit">&#xE254;</i></a>
                            <a href="#deleteEmployeeModal" class="delete" data-toggle="modal"><i class="material-icons" data-toggle="tooltip" title="Delete">&#xE872;</i></a>
                        </td>

                    </tr>

                </tbody>

            </table>

            <!-- Add Modal HTML -->
            <div id="addEmployeeModal" class="modal fade">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <form>
                            <div class="modal-header">						
                                <h4 class="modal-title">Adicionar Usuário</h4>
                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                            </div>
                            <div class="modal-body">					
                                <div class="form-group">
                                    <label>Login</label>
                                    <input type="text" class="form-control" required>
                                </div>
                                <div class="form-group">
                                    <label>Senha</label>
                                    <input type="password" class="form-control" required>
                                </div>
                                <div class="form-group">
                                    <label>Nome</label>
                                    <input type="text" class="form-control" required>
                                </div>
                                <div class="form-group">
                                    <label>CPF</label>
                                    <input type="text" class="form-control" required>
                                </div>					
                            </div>
                            <div class="modal-footer">
                                <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancelar">
                                <input type="submit" class="btn btn-success" value="Adicionar">
                            </div>
                        </form>
                    </div>
                </div>
            </div>

            <!-- Edit Modal HTML -->
            <div id="editEmployeeModal" class="modal fade">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <form>
                            <div class="modal-header">						
                                <h4 class="modal-title">Editar Usuário</h4>
                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                            </div>
                            <div class="modal-body">					
                                <div class="form-group">
                                    <label>Login</label>
                                    <input type="text" class="form-control" required>
                                </div>
                                <div class="form-group">
                                    <label>Senha</label>
                                    <input type="password" class="form-control" required>
                                </div>
                                <div class="form-group">
                                    <label>Nome</label>
                                    <input type="text" class="form-control" required>
                                </div>
                                <div class="form-group">
                                    <label>CPF</label>
                                    <input type="text" class="form-control" required>
                                </div>					
                            </div>
                            <div class="modal-footer">
                                <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancelar">
                                <input type="submit" class="btn btn-info" value="Salvar">
                            </div>
                        </form>
                    </div>
                </div>
            </div>

            <!-- Delete Modal HTML -->
            <div id="deleteEmployeeModal" class="modal fade">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <form>
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
                                <input type="submit" class="btn btn-danger" value="Deletar">
                            </div>
                        </form>
                    </div>
                </div>
            </div>
            

<?php
    include('footer.php');
?>

