window.onload = function(){

    diaNascimento = window.prompt("Digite o dia de nascimento: ");
    mesNascimento = window.prompt("Digite o mes de nascimento: ");
    anoNascimento = window.prompt("Digite o ano de nascimento: ");

    var dataAtual = new Date();
    diaAtual = dataAtual.getDate();
    mesAtual = dataAtual.getMonth();
    anoAtual = dataAtual.getFullYear();

    qtdDias = diaAtual - diaNascimento;
    qtdMeses = (mesAtual - mesNascimento) * 12;
    qtdAnos = (anoAtual - anoNascimento) * 365;

    idadeEmDias = qtdDias + qtdMeses + qtdAnos;

    window.alert("Idade da pessoa em dias: " +idadeEmDias);


}
