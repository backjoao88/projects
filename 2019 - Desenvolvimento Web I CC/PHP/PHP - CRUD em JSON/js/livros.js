var id_selecionado = 0;


function inserirLinhaTabelaLivro(idTabela, liv) {
 
    var tabela_livros                  = document.getElementById(idTabela).getElementsByTagName('tbody')[0]

    tabela_livros.setAttribute("name", "table_rows")

    var num_linhas_tabela_livros        = tabela_livros.rows.length;

    var linha_tabela_livros             = tabela_livros.insertRow(num_linhas_tabela_livros);

    var coluna_id               = linha_tabela_livros.insertCell(0)
    var coluna_nome             = linha_tabela_livros.insertCell(1)
    var coluna_isbn             = linha_tabela_livros.insertCell(2)
    var coluna_edicao           = linha_tabela_livros.insertCell(3)
    var coluna_data_pub         = linha_tabela_livros.insertCell(4)
    var coluna_autor            = linha_tabela_livros.insertCell(5)
    var coluna_acoes            = linha_tabela_livros.insertCell(6)
  
    coluna_id.innerHTML         = liv.livro_id
    coluna_nome.innerHTML       = liv.livro_nome
    coluna_isbn.innerHTML       = liv.livro_isbn
    coluna_edicao.innerHTML     = liv.livro_edicao
    coluna_data_pub.innerHTML   = liv.livro_data_publicacao
    coluna_autor.innerHTML      = liv.livro_autor

    // Para os links de editar e deletar
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
        history.pushState(null, null, "livros.php?id=" + id_selecionado);

        var row = a_editar.parentNode.parentNode.parentNode.rowIndex-1;
        var tr = tabela_livros.getElementsByTagName('tr')[row];
        var tds = tr.getElementsByTagName('td')

        document.getElementById('edit-nome').value = tds[1].innerHTML;
        document.getElementById('edit-isbn').value = tds[2].innerHTML;
        document.getElementById('edit-edicao').value = tds[3].innerHTML;
        document.getElementById('edit-data-pub').value = tds[4].innerHTML;
        document.getElementById('edit-autor').value = tds[5].innerHTML;
    }

    a_deletar.href        = '#deleteEmployeeModal'
    a_deletar.className   = 'delete'
    a_deletar.dataset     = 'modal'
    a_deletar.setAttribute('data-toggle', 'modal')
  
    a_deletar.onclick = function(){
        var tr = a_deletar.parentNode.parentNode.parentNode.firstChild.innerHTML;
        id_selecionado = parseInt(tr); 
        history.pushState(null, null, "livros.php?id=" + id_selecionado);
    }

    a_deletar.addEventListener('deletar-livro', function(){
        var tr = a_deletar.parentNode.parentNode.parentNode.rowIndex-1; 
        tabela_livros.deleteRow(tr)
    })

    var acoes             = document.createElement('td')

    acoes.appendChild(a_editar)
    a_editar.appendChild(i1)
    acoes.appendChild(a_deletar)
    a_deletar.appendChild(i2)
    
    coluna_acoes.appendChild(acoes)

}


