window.onload = function(){

    somaFinal = 0;

    for (i = 0; i < 3; i++){

        primeiroNumero = window.prompt("Digite o primeiro número: ");
        segundoNumero = window.prompt("Digite o segundo número: ");
        
        soma = somar(parseInt(primeiroNumero), parseInt(segundoNumero));
        media = mediaParcial(parseInt(soma));

        window.alert("A soma é: " +soma);
        window.alert("A média parcial é: "+ media);

        somaFinal = somaFinal + soma;

    }

    mediaFinal = mediaFinal(parseInt(somaFinal));

    window.alert("A média final é: " +mediaFinal);

}

function somar(primeiroNumero, segundoNumero){
    return (primeiroNumero+segundoNumero);
}

function mediaParcial(soma){
    return soma / 2;
}
function mediaFinal(somaFinal){
    return somaFinal / 3;
}