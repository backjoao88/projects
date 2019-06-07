function inserirLinhaTabela() {

    // Captura a referência da tabela com id “minhaTabela”
    var tabela = document.getElementById("tabela-usuarios");
    // Captura a quantidade de linhas já existentes na tabela
    var linha = tabela.rows.length;
    // Captura a quantidade de colunas da última linha da tabela
    var coluna = tabela.rows[linha-1].cells.length;
    // CONTADOR DE LINHAS
    var aux = 1;

    // Insere uma linha no fim da tabela.
    var novaLinha = tabela.insertRow(linha);                            
    
    // Faz um loop para criar as colunas
    for (var j = 0; j < coluna; j++) {
        // Insere uma coluna na nova linha 
        novaColuna = novaLinha.insertCell(j);
        // Insere um conteúdo na coluna
        if (j === 0){
            novaColuna.innerHTML = linha;
        }
        if (j===1){
            novaColuna.innerHTML = '<?php echo $produtos?>';
        }
        if (j===2){
            novaColuna.innerHTML = '<input class="form-control" name="qtde" id="qtde" required="">';
        }
    }
    
}