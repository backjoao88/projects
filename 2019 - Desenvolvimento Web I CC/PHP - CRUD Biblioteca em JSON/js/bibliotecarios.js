
function inserirLinhaTabelaBibliotecario(idTabela, bib) {

    var tabela_bibliotecario                = document.getElementById(idTabela).getElementsByTagName('tbody')[0]

    var num_linhas_tabela_bibliotecario     = tabela_bibliotecario.rows.length;

    var linha_tabela_bibliotecario           = tabela_bibliotecario.insertRow(num_linhas_tabela_bibliotecario);

    var coluna_id       = linha_tabela_bibliotecario.insertCell(0)
    var coluna_nome     = linha_tabela_bibliotecario.insertCell(1)
    var coluna_cpf      = linha_tabela_bibliotecario.insertCell(2)
    var coluna_acoes    = linha_tabela_bibliotecario.insertCell(3)
    

    coluna_id.innerHTML     = bib.bibliotecario_id
    coluna_nome.innerHTML   = bib.bibliotecario_nome
    coluna_cpf.innerHTML    = bib.bibliotecario_cpf

    var a_editar          = document.createElement('a')
    var a_deletar         = document.createElement('a')

    var i1              = document.createElement('i')
    i1.className        = 'material-icons'
    i1.setAttribute('data-toggle', 'tooltip')
    i1.title            = 'Edit'
    i1.innerHTML        = '&#xE254;'

    var i2              = document.createElement('i')
    i2.className        = 'material-icons'
    i2.setAttribute('data-toggle', 'tooltip')
    i2.dataset          = 'tooltip'
    i2.title            = 'Delete'
    i2.innerHTML        = '&#xE872;'

    a_editar.href         = '#editEmployeeModal'
    a_editar.className    = 'edit'
    a_editar.dataset      = 'modal'
    a_editar.setAttribute('data-toggle', 'modal')

    a_editar.onclick = function(){

        var tr = a_editar.parentNode.parentNode.parentNode.firstChild.innerHTML;
        id_selecionado = parseInt(tr); 
        history.pushState(null, null, "bibliotecarios.php?id=" + id_selecionado);

        var row = a_editar.parentNode.parentNode.parentNode.rowIndex-1;
        var tr = tabela_bibliotecario.getElementsByTagName('tr')[row];
        var tds = tr.getElementsByTagName('td')

        document.getElementById('edit-nome').value  = tds[1].innerHTML;
        document.getElementById('edit-cpf').value   = tds[2].innerHTML;

    }

    a_deletar.onclick = function(){
        var tr = a_deletar.parentNode.parentNode.parentNode.firstChild.innerHTML;
        id_selecionado = parseInt(tr); 
        history.pushState(null, null, "bibliotecarios.php?id=" + id_selecionado);
    }

    a_deletar.addEventListener('deletar-bibliotecario', function(){
        var tr = a_deletar.parentNode.parentNode.parentNode.rowIndex-1; 
        tabela_bibliotecario.deleteRow(tr)
    })


    a_deletar.href        = '#deleteEmployeeModal'
    a_deletar.className   = 'delete'
    a_deletar.dataset     = 'modal'
    a_deletar.setAttribute('data-toggle', 'modal')

    var acoes             = document.createElement('td')

    acoes.appendChild(a_editar)
    a_editar.appendChild(i1)
    acoes.appendChild(a_deletar)
    a_deletar.appendChild(i2)

    coluna_acoes.appendChild(acoes)

}