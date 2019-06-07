
window.onload = function(){
    document.getElementById('btn_adicionar_linha').addEventListener('click', function(){
        adicionarLinhaTabela()
    })
}

function adicionarLinhaTabela(){
    
    var tabela_salario                 = document.querySelector('#tabela-salario')
    var numero_linhas_tabela           = tabela_salario.rows.length
    
    var ultima_linha_tabela            = tabela_salario.insertRow(numero_linhas_tabela)

    var coluna_seq                     = ultima_linha_tabela.insertCell(0)
    var coluna_valor_hora              = ultima_linha_tabela.insertCell(1)
    var coluna_horas_trabalhadas       = ultima_linha_tabela.insertCell(2)
    var coluna_remover                 = ultima_linha_tabela.insertCell(3)

    coluna_valor_hora.innerHTML        = "<input name='valor-hora[]'type='text'/>"
    coluna_horas_trabalhadas.innerHTML = "<input name='horas-trabalhadas[]'type='text'/>"
    coluna_remover.innerHTML           = "<button class=\"form-button\" type=\"button\" onclick='removerLinhaTabela(this)'>Remover Linha</button>"
  
    atualizarSeqIndexes()
}

function removerLinhaTabela(indexLinha){

    var index                          = indexLinha.parentNode.parentNode.rowIndex;
    var tabela_salario                 = document.getElementById('tabela-salario')
    
    tabela_salario.deleteRow(index)

    atualizarSeqIndexes()
}

function atualizarSeqIndexes(){
    
    var new_line_counter    = 1
    var tabela_salario  = document.querySelector('#tabela-salario')

    for (let i = 1; i < tabela_salario.rows.length; i++){
        tabela_salario.rows[i].cells[0].innerHTML = new_line_counter
        new_line_counter = new_line_counter + 1
    }

}