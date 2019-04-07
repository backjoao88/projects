const TABLE_HEIGHT   = 4
const TABLE_WIDTH    = 6
const MEMORY_TABLE_TOTAL_CARDS = TABLE_HEIGHT * TABLE_WIDTH;

const imgsTable      = ['<img width="120" height="120" src=\'imgs/0.jpeg\'/>',
                        '<img width="120" height="120" src=\'imgs/1.jpeg\'/>',
                        '<img width="120" height="120" src=\'imgs/2.jpeg\'/>',
                        '<img width="120" height="120" src=\'imgs/3.jpeg\'/>',
                        '<img width="120" height="120" src=\'imgs/4.jpeg\'/>',
                        '<img width="120" height="120" src=\'imgs/5.jpeg\'/>',
                        '<img width="120" height="120" src=\'imgs/5.jpeg\'/>',
                        '<img width="120" height="120" src=\'imgs/5.jpeg\'/>',
                        '<img width="120" height="120" src=\'imgs/5.jpeg\'/>',
                        '<img width="120" height="120" src=\'imgs/5.jpeg\'/>',
                        '<img width="120" height="120" src=\'imgs/5.jpeg\'/>',
                        '<img width="120" height="120" src=\'imgs/5.jpeg\'/>']                         

const memoryTable    = []

function start(){
    createTableDataStructure()
    createImagesPairs()
    renderTable()
}

/* .........................................................................................................*/

function createImagesPairs(){
    createSequenceOfPairs();
    spreadCards();
}

/* .........................................................................................................*/

function createSequenceOfPairs(){
    for(let i = 0; i < 2; i++){
        for (let j = 0; j < imgsTable.length; j++){
            indexMemoryTable = ((imgsTable.length * i) + j)
            memoryTable[indexMemoryTable] = j
        }
    }
}

/* .........................................................................................................*/

/*

INICIO
	INDEX_ATUAL = GERAR INDEX ALETAORIO DA TABELA;
	IF(INDEX_ATUAL == 24)
		INDEX_ATUAL = 0
	LET AUX = 0;
	INDEX_A_SER_TROCADO = INDEX_ATUAL + 1;
	AUX = TABELA[INDEX_ATUAL];
	TABELA[INDEX_ATUAL] = TABELA[INDEX_A_SER_TROCADO]
	TABELA[INDEX_A_SER_TROCADO] = AUX

FIM.

*/

function spreadCards(){
    let rand = 2;
    let aux = 0;
    let indexToBeChange = 0;
  //  for(let i = 0; i < 5; i++){
        let randomIndexTableMemory = createRandomIndexTableMemory()
        if(randomIndexTableMemory == 23){
            indexToBeChange = rand - 1;
        }else{
            indexToBeChange = randomIndexTableMemory + rand;
        }

        console.log(randomIndexTableMemory)
        console.log(indexToBeChange)

        aux = memoryTable[randomIndexTableMemory]
        memoryTable[randomIndexTableMemory] = memoryTable[indexToBeChange]
        memoryTable[indexToBeChange] = aux
  //  }
}

/* .........................................................................................................*/

function createTableDataStructure(){

    for (let i = 0; i < (TABLE_HEIGHT*TABLE_WIDTH); i++){
        memoryTable[i] = -1
    }
}

/* .........................................................................................................*/

function renderTable(){
    
    let indexMemoryTable = 0;

    let html = '<table border="1">'

    for (let i = 0; i < TABLE_HEIGHT; i++){

        html += '<tr>'

        for (let j = 0; j < TABLE_WIDTH; j++){
            indexMemoryTable = ((TABLE_WIDTH * i) + j);
            html += '<td>'
            html += '<div>'+memoryTable[indexMemoryTable]+'</div>'
            html += '</td>'   
        }

        html += '</tr>'
    }

    html += '</table>'

    document.querySelector('#tableMemory').innerHTML = html;
}

/* .........................................................................................................*/

function createRandomIndexTableMemory(){
    return Math.floor(Math.random() * MEMORY_TABLE_TOTAL_CARDS);
}

start();