window.onload = function(){

    for (i = 0; i < 3; i++){

        primeiroNumero = window.prompt("Digite o primeiro número: ");
        segundoNumero = window.prompt("Digite o segundo número: ");
        
        soma = somar(parseInt(primeiroNumero), parseInt(segundoNumero));

        window.alert("A soma é: " +soma);
    }

}

function somar(primeiroNumero, segundoNumero){
    return (primeiroNumero+segundoNumero);
}