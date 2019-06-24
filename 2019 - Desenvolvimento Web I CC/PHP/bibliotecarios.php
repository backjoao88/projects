
<?php


    include('autoload.php');

    include('header.php');

    
    $bibliotecarioDAO = new BibliotecarioDAO();
    $bibliotecarioBO = new BibliotecarioBO($bibliotecarioDAO);

    if(isset($_POST['adicionar-bibliotecario'])){

        $id                   = isset($_POST['id']) ? $_POST['id'] : '';
        $nome_bibliotecario   = isset($_POST['bibliotecario-nome']) ? $_POST['bibliotecario-nome'] : '';
        $cpf_bibliotecario    = isset($_POST['bibliotecario-cpf']) ? $_POST['bibliotecario-cpf'] : '';

        $bib = (new Bibliotecario())->utilizandoOID(intval($id))
                            ->comONome($nome_bibliotecario)
                            ->utilizandoOCpf($cpf_bibliotecario);

        $bibliotecarioBO->inserir($bib);
    }

    if(isset($_POST['deletar-bibliotecario'])){
        $linha_selecionada = $_GET['id'];
        $bib = (new Bibliotecario())->utilizandoOID(intval($linha_selecionada));
        $bibliotecarioBO->excluir($bib);

    }

    if(isset($_POST['editar-bibliotecario'])){
        
        $id             = $_GET['id'];
        $nome_bibliotecario   = isset($_POST['edit-nome']) ? $_POST['edit-nome'] : '';
        $cpf_bibliotecario    = isset($_POST['edit-cpf']) ? $_POST['edit-cpf'] : '';

        $bib = (new Bibliotecario())->utilizandoOID(intval($id))
                            ->comONome($nome_bibliotecario)
                            ->utilizandoOCpf($cpf_bibliotecario);

        echo $bibliotecarioBO->alterar($bib);
    }



?>

        <div class="table-wrapper">

            <div class="table-title">
                <div class="row">
                    <div class="col-sm-6">
						<h2>Bibliotecarios</h2>
					</div>
					<div class="col-sm-6">
						<a href="#addEmployeeModal" class="btn btn-success" data-toggle="modal"><i class="material-icons">&#xE147;</i> <span>Novo Bibliotecario</span></a>					
					</div>
                </div>
            </div>


            <table id="tabela-bibliotecario" class="table table-striped table-hover">
            
                <thead>
                    <tr>
                        <th>ID</th>
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
                                <h4 class="modal-title">Adicionar Bibliotecario</h4>
                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                            </div>
                            <div class="modal-body">
                                <div class="form-group">
                                    <label>ID</label>
                                    <input name="id" type="number" min="1"  class="form-control" required>
                                </div>						
                                <div class="form-group">
                                    <label>Nome</label>
                                    <input name="bibliotecario-nome" type="text" class="form-control" required>
                                </div>
                                <div class="form-group">
                                    <label>CPF</label>
                                    <input id="cpf" pattern="\d{3}\.\d{3}\.\d{3}-\d{2}" name="bibliotecario-cpf" type="text" class="form-control" required>
                                    <script type="text/javascript">
                                    
                                        $('#cpf').mask('000.000.000-00', {reverse: true});

                                    </script>
                                </div>					
                            </div>
                            <div class="modal-footer">
                                <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancelar">
                                <input name='adicionar-bibliotecario' type="submit" class="btn btn-success" value="Adicionar">
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
                                <h4 class="modal-title">Editar Bibliotecario</h4>
                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                            </div>
                            <div class="modal-body">					
                                <div class="form-group">
                                    <label>Nome</label>
                                    <input id="edit-nome" name="edit-nome" type="text" class="form-control" required>
                                </div>
                                <div class="form-group">
                                    <label>CPF</label>
                                    <input id="edit-cpf" pattern="\d{3}\.\d{3}\.\d{3}-\d{2}" name="edit-cpf" type="text" class="form-control" required>
                                    <script type="text/javascript">
                                    
                                        $('#edit-cpf').mask('000.000.000-00', {reverse: true});

                                    </script>
                                </div>					
                            </div>
                            <div class="modal-footer">
                                <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancelar">
                                <input name="editar-bibliotecario" type="submit" class="btn btn-info" value="Salvar">
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
                                <h4 class="modal-title">Deletar Bibliotecario</h4>
                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                            </div>
                            <div class="modal-body">					
                                <p>Tem razão que deseja excluir?</p>
                                <p class="text-warning"><small>Essa ação não pode ser desfeita.</small></p>
                            </div>
                            <div class="modal-footer">
                                <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancelar">
                                <input name="deletar-bibliotecario" type="submit" class="btn btn-danger" value="Deletar">
                            </div>
                        </form>
                    </div>
                </div>
            </div>
            

<?php




    include('footer.php');


    $lista_bibliotecarios = [];

    $lista_bibliotecarios = $bibliotecarioBO->listarBibliotecarios();

    foreach($lista_bibliotecarios as $bibliotecario){
        $bibliotecarioJson = json_encode($bibliotecario);
        echo "<script>inserirLinhaTabelaBibliotecario('tabela-bibliotecario', $bibliotecarioJson)</script>";
    }  
    
    
?>

