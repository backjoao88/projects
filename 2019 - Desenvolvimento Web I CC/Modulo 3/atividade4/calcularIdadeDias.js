window.onload = function(){

    diaNascimento = 01;
    mesNascimento = 08;
    anoNascimento = 1999;

    var dataAtual = new Date();
    diaAtual = dataAtual.getDate();
    mesAtual = dataAtual.getMonth();
    anoAtual = dataAtual.getFullYear();

    qtdDias = diaAtual - diaNascimento;
    qtdMeses = (mesAtual - mesNascimento) * 12;
    qtdAnos = (anoAtual - anoNascimento) * 365;

    idadeEmDias = qtdDias + qtdMeses + qtdAnos;

    document.write("Idade da pessoa em dias: " +idadeEmDias);


}
