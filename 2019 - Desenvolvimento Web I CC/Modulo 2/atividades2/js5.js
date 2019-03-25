window.onload = function(){
    var botaoEnviarDados = document.getElementById("botaoEnviarDados");
    botaoEnviarDados.addEventListener("click", function(){
        valorDeducoes = retornaValorDeducoes();
        valorRendimentos = retornaValorRendimentos();
        valorImposto = calcularValorImposto(valorDeducoes, valorRendimentos);
        var preElement = document.createElement("PRE");
        var textElement = document.createTextNode("O valor do imposto é: " + valorImposto);
        preElement.appendChild(textElement);
        document.body.appendChild(preElement);
    })
}

function calcularValorImposto(valorDeducoes, valorRendimentos){
    const VALOR_JURO = 0.15;
    valorImposto = (VALOR_JURO*(valorRendimentos-valorDeducoes));
    return valorImposto;
}

function retornaValorRendimentos(){
    valorRendimentos = document.getElementById("entradaRendimentos").value;
    return valorRendimentos;
}

function retornaValorDeducoes(){
    valorDeducoes = document.getElementById("entradaDeducoesCabiveis").value;
    return valorDeducoes;
}

