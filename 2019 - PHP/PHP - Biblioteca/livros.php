<?php


    include('header.php');

    include('autoload.php');

    $livroDAO = new LivroDAOMySQL();
    $livroBO = new LivroBO($livroDAO);

    if(isset($_POST['adicionar-livro'])){

        $id        = isset($_POST['id']) ? $_POST['id'] : 0;
        $isbn      = isset($_POST['isbn']) ?$_POST['isbn'] : '';
        $nome      = isset($_POST['nome']) ?$_POST['nome'] : '';
        $edicao    = isset($_POST['edicao']) ?$_POST['edicao'] : '';
        $data      = isset($_POST['data-publicacao']) ?$_POST['data-publicacao'] : '';
        $autor     = isset($_POST['autor']) ?$_POST['autor'] : '';

        $livro = (new Livro())->setLivroId(intval($id))
                                        ->setLivroNome($nome)
                                        ->setLivroIsbn($isbn)
                                        ->setLivroEdicao($edicao)
                                        ->setLivroDataPublicacao($data)
                                        ->setLivroAutor($autor);
        $livroBO->inserir($livro);

    }


    if(isset($_POST['deletar-livro'])){
        $linha_selecionada = $_GET['id'];
        $liv = (new Livro())->setLivroId(intval($linha_selecionada));
        $livroBO->excluir($liv);
    }

    if(isset($_POST['editar-livro'])){

        $id        = $_GET['id'];
        
        $isbn      = isset($_POST['edit-isbn']) ? $_POST['edit-isbn'] : '';
        $nome      = isset($_POST['edit-nome']) ? $_POST['edit-nome'] : '';
        $edicao    = isset($_POST['edit-edicao']) ? $_POST['edit-edicao'] : '';
        $data      = isset($_POST['edit-data-pub']) ? $_POST['edit-data-pub'] : '';
        $autor     = isset($_POST['edit-autor']) ? $_POST['edit-autor'] : ''; 



        $livro = (new Livro())->setLivroId(intval($id))
                                ->setLivroNome($nome)
                                ->setLivroIsbn($isbn)
                                ->setLivroEdicao($edicao)
                                ->setLivroDataPublicacao($data)
                                ->setLivroAutor($autor);
        
        echo $livroBO->alterar($livro);

    }


?>

        <div class="table-wrapper">

            <div class="table-title">
                <div class="row">
                    <div class="col-sm-6">
						<h2>Livros</h2>
					</div>
					<div class="col-sm-6">
						<a href="#addEmployeeModal" class="btn btn-success" data-toggle="modal"><i class="material-icons">&#xE147;</i> <span>Novo Livro</span></a>					
					</div>
                </div>
            </div>


            <table id="tabela-livros" class="table table-striped table-hover">
            
                <thead>
                    <tr>    
                        <th>ID</th>
                        <th>Nome</th>
						<th>ISBN</th>
						<th>Edicao</th>
						<th>Data Publicacao</th>
						<th>Autor</th>
                        <th>Ações</th>
                    </tr>
                </thead>

                <tbody>

                </tbody>

            </table>

            <!-- Add Modal HTML -->
            <div id="addEmployeeModal" class="modal fade">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <form method="POST">
                            <div class="modal-header">						
                                <h4 class="modal-title">Adicionar Livro</h4>
                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                            </div>
                            <div class="modal-body">
                                <!-- <div class="form-group">
                                    <label>ID</label>
                                    <input name="id" type="number" min="1" class="form-control" required>
                                </div>	 -->
                                <div class="form-group">
                                    <label>Nome</label>
                                    <input name="nome" type="text" class="form-control" required>
                                </div>
                                <div class="form-group">
                                    <label>ISBN</label>
                                    <input pattern="^(?:ISBN(?:-10)?:?\)?(?=[0-9X]{10}$|(?=(?:[0-9]+[-\]){3})[-\0-9X]{13}$)[0-9]{1,5}[-\]?[0-9]+[-\]?[0-9]+[-\]?[0-9X]$"id="isbn" name="isbn" type="text" class="form-control" required>
                                    <script type="text/javascript">
                                    
                                       // $('#isbn').mask('', {reverse: true});

                                    </script>
                                </div>
                                <div class="form-group">
                                    <label>Edicao</label>
                                    <input name="edicao" type="text" class="form-control" required>
                                </div>
                                <div class="form-group">
                                    <label>Data Publicação</label>
                                    <input name="data-publicacao" type="date" class="form-control" required>
                                </div>
                                <div class="form-group">
                                    <label>Autor</label>
                                    <input name="autor" type="text" class="form-control" required>
                                </div>	
                                					
                            </div>
                            <div class="modal-footer">
                                <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancelar">
                                <input name="adicionar-livro" type="submit" class="btn btn-success" value="Adicionar">
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
                                <h4 class="modal-title">Editar Livro</h4>
                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                            </div>
                            <div class="modal-body">	
                                <div class="form-group">
                                    <label>Nome</label>
                                    <input id="edit-nome" name="edit-nome" type="text" class="form-control" required>
                                </div>
                                <div class="form-group">
                                    <label>ISBN</label>
                                    <input id="edit-isbn" name="edit-isbn" type="text" class="form-control" required>
                                </div>
                                <div class="form-group">
                                    <label>Edicao</label>
                                    <input id="edit-edicao" name="edit-edicao" type="text" class="form-control" required>
                                </div>
                                <div class="form-group">
                                    <label>Data Publicação</label>
                                    <input id="edit-data-pub" name="edit-data-pub" type="date" class="form-control" required>
                                </div>
                                <div class="form-group">
                                    <label>Autor</label>
                                    <input id="edit-autor" name="edit-autor" type="text" class="form-control" required>
                                </div>							
                            </div>
                            <div class="modal-footer">
                                <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancelar">
                                <input name="editar-livro" type="submit" class="btn btn-info" value="Salvar">
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
                                <h4 class="modal-title">Deletar Livro</h4>
                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                            </div>
                            <div class="modal-body">					
                                <p>Tem razão que deseja excluir?</p>
                                <p class="text-warning"><small>Essa ação não pode ser desfeita.</small></p>
                            </div>
                            <div class="modal-footer">
                                <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancelar">
                                <input id="deletar-livro" name="deletar-livro" type="submit" class="btn btn-danger" value="Deletar">
                            </div>
                        </form>
                    </div>
                </div>
            </div>
            

<?php

    include('footer.php');


    $lista_livros = [];

    $lista_livros = $livroBO->listarLivros();

    foreach($lista_livros as $livro){
        $livroJson = json_encode($livro);
        echo "<script>inserirLinhaTabelaLivro('tabela-livros', $livroJson)</script>";
    }  
    

?>

