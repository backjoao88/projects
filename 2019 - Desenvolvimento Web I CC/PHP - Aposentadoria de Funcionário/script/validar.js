function validar(){

    var usuario = document.querySelector('#usuario').value
    var senha = document.querySelector('#senha').value
    var info_tabela = document.querySelector('.info-tabela')
    var linhas = info_tabela.querySelectorAll('tr')
    var qtd_maior_salario = document.querySelector('#qtd-maiores-salarios').value
    var qtd_menor_salario = document.querySelector('#qtd-menores-salarios').value
    var qtdLinhasInfoTabela = linhas.length-1

    if(usuario === senha){
        alert('Usuário e senha não podem ser iguais!')
        return false;
    }

    if(qtd_menor_salario > qtdLinhasInfoTabela){
        alert('Valor Qtd. Menor Salário não pode ser maior que o número de linhas da tabela!')
        return false;
    }

    if(qtd_maior_salario > qtdLinhasInfoTabela){
        alert('Valor Qtd. Maior Salário não pode ser maior que o número de linhas da tabela!')
        return false;
    }

    return true;

}
    