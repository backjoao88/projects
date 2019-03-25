window.onload = function(){


    primeiroValor = window.prompt("Digite o primeiro valor: ");
    segundoValor = window.prompt("Digite o segundo valor: ");
    divisao = primeiroValor / segundoValor;

    if(divisao > 0){
        window.alert("Positivo!");
    }else{
        if(divisao < 0){
            window.alert("Negativo!");
        }else{
            window.alert("ERRO!");
        }
    }


}