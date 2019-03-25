window.onload = function(){


    primeiroValor = window.prompt("Digite o primeiro valor: ");
    operando = window.prompt("Digite o operando (DIV/MULT/SOMA/SUB): ");
    segundoValor = window.prompt("Digite o segundo valor: ");

    resultado = 0;

    if(operando == "DIV"){
        if(segundoValor != 0){
            resultado = primeiroValor / segundoValor;
        }else{
            window.alert("ERRO");
        }
    }else{
        if(operando == "MULT"){
            resultado = primeiroValor * segundoValor;
        }else{
            if(operando == "SOMA"){
                resultado = primeiroValor + segundoValor;
            }else{
                if(operando == "SUB"){
                    resultado = primeiroValor - segundoValor;
                }
            }
        }
    }

    window.alert("O resultado é: " +resultado);





}