<?php

    include('header.php');
    include('autoload.php');

    
    $emprestimosDAO = new EmprestimoDAOMySQL();
    $emprestimoBO = new EmprestimoBO($emprestimosDAO);

    $bibliotecarioDAO = new BibliotecarioDAOMySQL();
    $bibliotecarioBO = new BibliotecarioBO($bibliotecarioDAO);

    $livroDAO = new LivroDAOMySQL();
    $livroBO = new LivroBO($livroDAO);

    if(isset($_POST['adicionar-emprestimo'])){

        $id                 = isset($_POST['id']) ? $_POST['id'] : 0;
        $data_entrega       = isset($_POST['data-entrega']) ? $_POST['data-entrega'] : '';
        $data_devolucao     = isset($_POST['data-devolucao']) ? $_POST['data-devolucao'] : '';
        $bibliotecarioId          = isset($_POST['bibliotecarios']) ? $_POST['bibliotecarios'] : '';
        $livros             = isset($_POST['livros']) ? $_POST['livros'] : '';

        $bibliotecarioProcurar = (new Bibliotecario())->setBibliotecarioId(intval($bibliotecarioId));

        $bibliotecario = $bibliotecarioBO->procurarBibliotecarioPorId($bibliotecarioProcurar);

        foreach($livros as $livroId){
            $livroProcurar = (new Livro())->setLivroId(intval($livroId));
            $livro = $livroBO->procurarLivroPorId($livroProcurar);
            $lista_livros[] = $livro;
        }

        $emp = (new Emprestimo())->setEmprestimoId(intval($id))
                                ->setEmprestimoDataEntrega($data_entrega)
                                ->setEmprestimoDataDevolucao($data_devolucao)
                                ->setEmprestimoBibliotecarioId($bibliotecario)
                                ->setEmprestimoLivros($lista_livros);

        $emprestimoBO->inserir($emp);

    }

    if(isset($_POST['deletar-emprestimo'])){
        $id = intval($_GET['id']);
        $emp = (new Emprestimo())->setEmprestimoId($id);
        $emprestimoBO->excluir($emp);
    }

    if(isset($_POST['editar-emprestimo'])){
        
        $id = intval($_GET['id']);

        $data_entrega       = isset($_POST['edit-data-ent']) ? $_POST['edit-data-ent'] : '';
        $data_devolucao     = isset($_POST['edit-data-dev']) ? $_POST['edit-data-dev'] : '';
        $bibliotecario      = isset($_POST['edit-bibliotecarios']) ? $_POST['edit-bibliotecarios'] : '';
        $livros             = isset($_POST['edit-livros']) ? $_POST['edit-livros'] : '';

        $bibliotecarioProcurar = (new Bibliotecario())->setBibliotecarioId(intval($bibliotecario));

        $bibliotecarioObj = $bibliotecarioBO->procurarBibliotecarioPorId($bibliotecarioProcurar);

        foreach($livros as $livroId){
            $livroProcurar = (new Livro())->setLivroId(intval($livroId));
            $livro = $livroBO->procurarLivroPorId($livroProcurar);
            $lista_livros[] = $livro;
        }

        $emp = (new Emprestimo())->setEmprestimoId(intval($id))
                                ->setEmprestimoDataEntrega($data_entrega)
                                ->setEmprestimoDataDevolucao($data_devolucao)
                                ->setEmprestimoBibliotecarioId($bibliotecarioObj)
                                ->setEmprestimoLivros($lista_livros);

        
        $emprestimoBO->alterar($emp);

    }



?>

        <div class="table-wrapper">

            <div class="table-title">
                <div class="row">
                    <div class="col-sm-6">
						<h2>Empréstimos</h2>
					</div>
					<div class="col-sm-6">
						<a href="#addEmployeeModal" class="btn btn-success" data-toggle="modal"><i class="material-icons">&#xE147;</i> <span>Novo Empréstimo</span></a>					
					</div>
                </div>
            </div>


            <table name="tabela-emprestimos" id="tabela-emprestimos" class="table table-striped table-hover">
            
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Data Entrega</th>
						<th>Data Devolucao</th>
                        <th>Bibliotecario</th>
                        <th>Livros</th>
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
                        <form method="POST">
                            <div class="modal-header">						
                                <h4 class="modal-title">Adicionar Empréstimo</h4>
                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                            </div>
                            <div class="modal-body">
                                <!-- <div class="form-group">
                                    <label>ID</label>
                                    <input name="id" type="number" min="1"  class="form-control" required>
                                </div>	 -->
                                <div class="form-group">
                                    <label>Data de Entrega</label>
                                    <input name="data-entrega" type="date" class="form-control" required>
                                </div>
                                <div class="form-group">
                                    <label>Data de Devolução</label>
                                    <input name="data-devolucao" type="date" class="form-control" required>
                                </div>
                                <div class="form-group">
                                    <label>Bibliotecario</label>
                                    <select class="custom-select custom-select-sm" name="bibliotecarios" id="bibliotecarios" required> 
                                    <?php

                                    $lista_bibliotecario = $bibliotecarioBO->listarBibliotecarios();

                                        foreach($lista_bibliotecario as $bibliotecario){
                                            echo '<option value=' . $bibliotecario->getBibliotecarioId() .   '>' . $bibliotecario->getBibliotecarioNome() . '</option>';
                                        }

                                    ?>

                                    </select>

                                </div>
                                <div class="form-group">
                                    <label>Livros</label>
                                    <select class="custom-select" name="livros[]"id="livros" multiple required> 
                                    <?php

                                    $lista_livros = $livroBO->listarLivros();

                                        foreach($lista_livros as $livro){
                                            echo '<option value=' . $livro->getLivroId() .   '>' . $livro->getLivroNome() . '</option>';
                                        }
                                    
                                    ?>
                                    
                                    </select>
                                </div>					
                            </div>
                            <div class="modal-footer">
                                <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancelar">
                                <input name="adicionar-emprestimo" type="submit" class="btn btn-success" value="Adicionar">
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
                                <h4 class="modal-title">Editar Empréstimo</h4>
                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                            </div>
                            <div class="modal-body">					
                                <div class="form-group">
                                    <label>Data de Entrega</label>
                                    <input id="edit-data-ent" name="edit-data-ent" type="date" class="form-control" required>
                                </div>
                                <div class="form-group">
                                    <label>Data de Devolução</label>
                                    <input id="edit-data-dev" name="edit-data-dev" type="date" class="form-control" required>
                                </div>
                                <div class="form-group">
                                    <label>Bibliotecario</label>
                                    <select class="custom-select custom-select-sm" id="edit-bibliotecarios" name="edit-bibliotecarios" required>
                                    <?php

                                    $lista_bibliotecarios = $bibliotecarioBO->listarBibliotecarios();

                                        foreach($lista_bibliotecarios as $bibliotecario){
                                            echo '<option value=' . $bibliotecario->getBibliotecarioID() .   '>' . $bibliotecario->getBibliotecarioNome() . '</option>';
                                        }

                                    ?>

                                    </select>
                                </div>
                                <div class="form-group">
                                    <label>Livros</label>
                                    <select class="custom-select" name="edit-livros[]" id="edit-livros" multiple required>
                                    <?php

                                    $lista_livros = $livroBO->listarLivros();

                                        foreach($lista_livros as $livro){
                                            echo '<option value=' . $livro->getLivroId() .   '>' . $livro->getLivroNome() . '</option>';
                                        }
                                    
                                    ?>
                                    
                                    </select>
                                </div>					
                            </div>
                            <div class="modal-footer">
                                <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancelar">
                                <input name="editar-emprestimo" type="submit" class="btn btn-info" value="Salvar">
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
                                <h4 class="modal-title">Deletar Empréstimo</h4>
                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                            </div>
                            <div class="modal-body">					
                                <p>Tem razão que deseja excluir?</p>
                                <p class="text-warning"><small>Essa ação não pode ser desfeita.</small></p>
                            </div>
                            <div class="modal-footer">
                                <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancelar">
                                <input name="deletar-emprestimo" type="submit" class="btn btn-danger" value="Deletar">
                            </div>
                        </form>
                    </div>
                </div>
            </div>
            

<?php

    include('footer.php');

    $lista_emps = [];

    $lista_emps = $emprestimoBO->listarEmprestimos();
    
    foreach($lista_emps as $emp){
        $empJson = json_encode($emp);
        echo "<script>inserirLinhaTabelaEmprestimo('tabela-emprestimos', $empJson)</script>";
    }  
    
?>

