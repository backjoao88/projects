var request = $.ajax({
    url: "index.php", 
    dataType:"json", 
    async: false}
);

var json_text = request.responseText;
var graph     = JSON.parse(json_text);

google.charts.load('current', {'packages':['corechart']});
google.charts.setOnLoadCallback(drawPieChart);

function drawPieChart() {

    // PIZZA

    var data = new google.visualization.DataTable();

    data.addColumn('string', graph.desc_linha)
    data.addColumn('number', graph.desc_coluna)

    var options = {
        title: graph.titulo,
        subtitle: graph.legenda,
        pieHole: 0.4,
        slices: { 0: {offset: 0.2},
                  1: {offset: 0.3},
                  2: {offset: 0.4},
        },
        pieStartAngle: 5
    };

    for (let i = 0; i < graph.valoresX.length; i++){
    data.addRows([
        [graph.valoresX[i], graph.valoresY[i]]
    ])
    }
    
    var chart = new google.visualization.PieChart(document.getElementById('piechart'));
    chart.draw(data, options);

}

google.charts.load('current', {'packages':['corechart']});
google.charts.setOnLoadCallback(drawLineChart);

function drawLineChart() {

    var data = new google.visualization.DataTable();

    data.addColumn('string', graph.desc_linha)
    data.addColumn('number', graph.desc_coluna)

    var options = {
        title: graph.titulo,
        subtitle: graph.legenda
    };

    for (let i = 0; i < graph.valoresX.length; i++){
    data.addRows([
        [graph.valoresX[i], graph.valoresY[i]]
    ])
    }

    var chart = new google.visualization.LineChart(document.getElementById('curve_chart'));
    chart.draw(data, options);

}

google.charts.load('current', {'packages':['corechart']});
google.charts.setOnLoadCallback(drawBarChart);

function drawBarChart() {

    var data = new google.visualization.DataTable();

    data.addColumn('string', graph.desc_linha)
    data.addColumn('number', graph.desc_coluna)

    var options = {
        title: graph.titulo,
        subtitle: graph.legenda
    };

    for (let i = 0; i < graph.valoresX.length; i++){
        data.addRows([
            [graph.valoresX[i], graph.valoresY[i]]
        ])
    }

    var chart = new google.visualization.BarChart(document.getElementById('bar-chart'));
    chart.draw(data, options);

}