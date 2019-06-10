
function inserirLinhaTabelaUsuario(idTabela, usu) {

    var tabela_usuarios                = document.getElementById(idTabela).getElementsByTagName('tbody')[0]

    var num_linhas_tabela_usuarios     = tabela_usuarios.rows.length;

    var linha_tabela_usuario           = tabela_usuarios.insertRow(num_linhas_tabela_usuarios);

    var coluna_id       = linha_tabela_usuario.insertCell(0)
    var coluna_login    = linha_tabela_usuario.insertCell(1)
    var coluna_senha    = linha_tabela_usuario.insertCell(2)
    var coluna_nome     = linha_tabela_usuario.insertCell(3)
    var coluna_cpf      = linha_tabela_usuario.insertCell(4)
    var coluna_acoes    = linha_tabela_usuario.insertCell(5)
    

    coluna_id.innerHTML     = usu.usuario_id
    coluna_login.innerHTML  = usu.usuario_login
    coluna_nome.innerHTML   = usu.usuario_nome
    coluna_senha.innerHTML    = usu.usuario_senha
    coluna_cpf.innerHTML    = usu.usuario_cpf


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
        history.pushState(null, null, "usuarios.php?id=" + id_selecionado);

        var row = a_editar.parentNode.parentNode.parentNode.rowIndex-1;
        var tr = tabela_usuarios.getElementsByTagName('tr')[row];
        var tds = tr.getElementsByTagName('td')

        document.getElementById('edit-login').value = tds[1].innerHTML;
        document.getElementById('edit-nome').value  = tds[3].innerHTML;
        document.getElementById('edit-cpf').value   = tds[4].innerHTML;

    }

    a_deletar.onclick = function(){
        var tr = a_deletar.parentNode.parentNode.parentNode.firstChild.innerHTML;
        id_selecionado = parseInt(tr); 
        history.pushState(null, null, "usuarios.php?id=" + id_selecionado);
    }

    a_deletar.addEventListener('deletar-usuario', function(){
        var tr = a_deletar.parentNode.parentNode.parentNode.rowIndex-1; 
        tabela_usuarios.deleteRow(tr)
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