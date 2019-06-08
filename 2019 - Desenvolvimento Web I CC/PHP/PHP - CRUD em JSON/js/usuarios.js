
function inserirLinhaTabelaUsuario(idTabela, usu) {

    var tabela_usuarios                = document.getElementById(idTabela).getElementsByTagName('tbody')[0]

    var num_linhas_tabela_usuarios     = tabela_usuarios.rows.length;

    var linha_tabela_usuario           = tabela_usuarios.insertRow(num_linhas_tabela_usuarios);

    var coluna_id   = linha_tabela_usuario.insertCell(0)
    var coluna_nome = linha_tabela_usuario.insertCell(1)
    var coluna_cpf  = linha_tabela_usuario.insertCell(2)
    var coluna_acoes  = linha_tabela_usuario.insertCell(3)
    

    coluna_id.innerHTML     = usu.usuario_id
    coluna_nome.innerHTML   = usu.usuario_nome
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

    console.log(tabela_usuarios)


    /*

    <tr>
        <td>
            <span class="custom-checkbox">
                <input type="checkbox" id="checkbox2" name="options[]" value="1">
                <label for="checkbox2"></label>
            </span>
        </td>

        <td>Dominique Perrier</td>
        <td>dominiqueperrier@mail.com</td>
        <td>Obere Str. 57, Berlin, Germany</td>
        <td>(313) 555-5735</td>
        <td>
            <a href="#editEmployeeModal" class="edit" data-toggle="modal">
            <i class="material-icons" data-toggle="tooltip" title="Edit">&#xE254;</i></a>
            <a href="#deleteEmployeeModal" class="delete" data-toggle="modal">
            <i class="material-icons" data-toggle="tooltip" title="Delete">&    </i></a>
        </td>
    </tr>

    */


}