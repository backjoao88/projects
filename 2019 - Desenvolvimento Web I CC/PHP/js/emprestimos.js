
function inserirLinhaTabelaEmprestimo(idTabela, emp) {

    console.log(emp)

    var tabela_emp                          = document.getElementById(idTabela).getElementsByTagName('tbody')[0]

    var num_linhas_tabela_emp               = tabela_emp.rows.length;

    var linha_tabela_emp                    = tabela_emp.insertRow(num_linhas_tabela_emp);

    var coluna_id                           = linha_tabela_emp.insertCell(0)
    var coluna_data_entrega                 = linha_tabela_emp.insertCell(1)
    var coluna_data_devolucao               = linha_tabela_emp.insertCell(2)
    var coluna_bibliotecario                = linha_tabela_emp.insertCell(3)
    var coluna_livros                       = linha_tabela_emp.insertCell(4)
    var coluna_acoes                        = linha_tabela_emp.insertCell(5)


    coluna_id.innerHTML                     = emp.emprestimo_id
    coluna_data_entrega.innerHTML           = emp.emprestimo_data_entrega
    coluna_data_devolucao.innerHTML         = emp.emprestimo_data_devolucao
    coluna_bibliotecario.innerHTML          = emp.emprestimo_bibliotecario_id.bibliotecario_nome

    var ul = document.createElement('ul')

    emp.emprestimo_livros.forEach(element => {
        var li = document.createElement('li')
        li.innerHTML = element.livro_nome
        ul.appendChild(li)
    });

    coluna_livros.appendChild(ul)
    
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
    a_editar.setAttribute('name', 'a_editar')

    a_editar.onclick = function(){

        var tr = a_editar.parentNode.parentNode.parentNode.firstChild.innerHTML;
        id_selecionado = parseInt(tr); 
        history.pushState(null, null, "emprestimos.php?id=" + id_selecionado);

        var row = a_editar.parentNode.parentNode.parentNode.rowIndex-1;
        var tr = tabela_emp.getElementsByTagName('tr')[row];
        var tds = tr.getElementsByTagName('td')

        document.getElementById('edit-data-ent').value      = tds[1].innerHTML;
        document.getElementById('edit-data-dev').value      = tds[2].innerHTML;

        // BIBLIOTECARIO

        var nome_selecionado = tds[3].innerHTML;
        
        var selectBibliotecarios = document.getElementById('edit-bibliotecarios');

        var options = selectBibliotecarios.getElementsByTagName('option');

        for (let i = 0 ; i < options.length; i++){
            if(options[i].innerHTML === nome_selecionado){
                options[i].setAttribute('selected', 'selected')
            }
        }

        for (let i = 0 ; i < options.length; i++){
            if(options[i].innerHTML !== nome_selecionado){
                options[i].removeAttribute('selected')
            }
        }

        // LIVROS

        var livros_lista        = tds[4].firstChild
        var selecionados_livros = livros_lista.getElementsByTagName('li')
        var todos_livros        = document.getElementById('edit-livros');
/*
        for (let i = 0 ; i < todos_livros.length; i++){
            console.log(todos_livros[i].innerHTML)
        }

        for (let i = 0 ; i < selecionados_livros.length; i++){
            console.log(selecionados_livros[i].innerHTML)
        }*/


        for (let i = 0 ; i < todos_livros.length; i++){
            for (let j = 0 ; j < selecionados_livros.length; j++){
                if(todos_livros[i].innerHTML === selecionados_livros[j].innerHTML){
                    todos_livros[i].setAttribute('selected', 'selected')
                }
            }
        }

        var arrtodos = []
        var arrsel = []

        for(let i = 0; i < todos_livros.length; i++){
            arrtodos.push(todos_livros[i].innerHTML)
        }

        for(let i = 0; i < selecionados_livros.length; i++){
            arrsel.push(selecionados_livros[i].innerHTML)
        }

        var arrig = arrtodos.filter(function(leitura) {
            return arrsel.indexOf(leitura) < 0
        });


        for (let i = 0 ; i < arrig.length; i++){
            var index = arrtodos.indexOf(arrig[i]);
            todos_livros[index].removeAttribute('selected')
        }
    }

    a_deletar.href        = '#deleteEmployeeModal'
    a_deletar.className   = 'delete'
    a_deletar.dataset     = 'modal'

    a_deletar.onclick = function(){
        var tr = a_deletar.parentNode.parentNode.parentNode.firstChild.innerHTML;
        id_selecionado = parseInt(tr); 
        history.pushState(null, null, "emprestimos.php?id=" + id_selecionado);
    }

    
    a_deletar.addEventListener('deletar-emprestimo', function(){
        var tr = a_deletar.parentNode.parentNode.parentNode.rowIndex-1; 
        tabela_emp.deleteRow(tr)
    })

    a_deletar.setAttribute('data-toggle', 'modal')

    var acoes             = document.createElement('td')

    acoes.appendChild(a_editar)
    a_editar.appendChild(i1)
    acoes.appendChild(a_deletar)
    a_deletar.appendChild(i2)
    

    coluna_acoes.appendChild(acoes)

}

function removerLinhaTabelaEmprestimo(linha){
    console.log(linha)
}