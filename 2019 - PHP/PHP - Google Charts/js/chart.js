$.ajax({

    type     : "GET",
    url      : "index.php", 
    dataType : "json", 
    async    : false,
    success  : function(json){
        graph = json
        switch (graph.IDENTIFICACAO){
            case 1:
                google.charts.load('current', {'packages':['corechart']});
                google.charts.setOnLoadCallback(drawPieChart);
                break;
            case 2:
                google.charts.load('current', {'packages':['corechart']});
                google.charts.setOnLoadCallback(drawBarChart);
                break;
            case 3:
                google.charts.load('current', {'packages':['corechart']});
                google.charts.setOnLoadCallback(drawLineChart);
                break;
            default:
                console.log("Tipo inválido!")
        }
    },
    
    error   : function(err){
        console.log(err.message)
    }
})



function drawPieChart() {

    // PIZZA

    var data = new google.visualization.DataTable();

    data.addColumn('string', graph.desc_linha)
    data.addColumn('number', graph.desc_coluna)

    var options = {
        title: graph.titulo,
        subtitle: graph.legenda,
        pieHole: graph.pizzaTamanhoBuraco,
        pieStartAngle: graph.pizzaAnguloDeInicio,
        width: graph.largura,
        height: graph.altura
    };

    for (let i = 0; i < graph.valoresX.length; i++){
    data.addRows([
        [graph.valoresX[i], graph.valoresY[i]]
    ])
    }
    
    var chart = new google.visualization.PieChart(document.getElementById('piechart'));
    chart.draw(data, options);

}

function drawLineChart() {

    var data = new google.visualization.DataTable();

    data.addColumn('string', graph.desc_linha)
    data.addColumn('number', graph.desc_coluna)

    var options = {
        title: graph.titulo,
        subtitle: graph.legenda,
        curveType: graph.tipoCurva,
        width: graph.largura,
        height: graph.altura
    };

    for (let i = 0; i < graph.valoresX.length; i++){
    data.addRows([
        [graph.valoresX[i], graph.valoresY[i]]
    ])
    }

    var chart = new google.visualization.LineChart(document.getElementById('curve_chart'));
    chart.draw(data, options);

}

function drawBarChart() {

    var data = new google.visualization.DataTable();

    data.addColumn('string', graph.desc_linha)
    data.addColumn('number', graph.desc_coluna)

    var options = {
        title: graph.titulo,
        subtitle: graph.legenda,
        bar: {groupWidth: graph.larguraBarra},
        width: graph.largura,
        height: graph.altura
    };

    for (let i = 0; i < graph.valoresX.length; i++){
        data.addRows([
            [graph.valoresX[i], graph.valoresY[i]]
        ])
    }

    var chart = new google.visualization.BarChart(document.getElementById('bar-chart'));
    chart.draw(data, options);

}