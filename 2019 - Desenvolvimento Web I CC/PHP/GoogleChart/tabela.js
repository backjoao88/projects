window.onload = function(){
    document.getElementById('btn_adicionar_linha').addEventListener('click', function(){
        adicionarLinhaTabela()
    })
}

function adicionarLinhaTabela(){
    
    var tabelaxy                        = document.querySelector('#tabela-x-y')
    var numero_linhas_tabela            = tabelaxy.rows.length
    
    var ultima_linha_tabela             = tabelaxy.insertRow(numero_linhas_tabela)

    var coluna_x                        = ultima_linha_tabela.insertCell(0)
    var coluna_y                        = ultima_linha_tabela.insertCell(1)
    var coluna_acao                     = ultima_linha_tabela.insertCell(2)

    coluna_x.innerHTML                  = "<input name='x[]'type='text' value='' required/>"
    coluna_y.innerHTML                  = "<input name='y[]'type='text' value='' required/>"
    coluna_acao.innerHTML               = "<button onclick='removerLinhaTabela(this)' type='button' class='btn btn-default btn-sm' data-dismiss='modal'><span class='glyphicon glyphicon-plus'></span>&times;</button>"

}

function removerLinhaTabela(indexLinha){

    var index                           = indexLinha.parentNode.parentNode.rowIndex;
    var tabelaxy                        = document.querySelector('#tabela-x-y')
    
    tabelaxy.deleteRow(index)
}

