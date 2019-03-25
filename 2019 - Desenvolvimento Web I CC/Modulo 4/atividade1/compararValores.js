window.onload = function(){


    primeiroValor = window.prompt("Digite o primeiro valor: ");
    segundoValor = window.prompt("Digite o segundo valor: ");

    if(primeiroValor > segundoValor){
        window.alert("O primeiro é maior que o segundo!");
    }else{
        if(segundoValor > primeiroValor){
            window.alert("O segundo é maior que o primeiro!");
        }else{
            window.alert("Os dois são iguais!");
        }
    }


}