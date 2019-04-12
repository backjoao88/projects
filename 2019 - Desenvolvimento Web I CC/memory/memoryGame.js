const TABLE_HEIGHT   = 4
const TABLE_WIDTH    = 6
const MEMORY_TABLE_TOTAL_CARDS = TABLE_HEIGHT * TABLE_WIDTH;

const imgsTable      = ['<img class="imgElement" width="120" height="120" src=\'imgs/0.jpeg\'/>',
                        '<img class="imgElement" width="120" height="120" src=\'imgs/1.jpeg\'/>',
                        '<img class="imgElement" width="120" height="120" src=\'imgs/2.jpeg\'/>',
                        '<img class="imgElement" width="120" height="120" src=\'imgs/3.jpeg\'/>',
                        '<img class="imgElement" width="120" height="120" src=\'imgs/4.jpeg\'/>',
                        '<img class="imgElement" width="120" height="120" src=\'imgs/5.jpeg\'/>',
                        '<img class="imgElement" width="120" height="120" src=\'imgs/6.jpeg\'/>',
                        '<img class="imgElement" width="120" height="120" src=\'imgs/7.jpeg\'/>',
                        '<img class="imgElement" width="120" height="120" src=\'imgs/8.jpeg\'/>',
                        '<img class="imgElement" width="120" height="120" src=\'imgs/9.jpeg\'/>',
                        '<img class="imgElement" width="120" height="120" src=\'imgs/10.jpeg\'/>',
                        '<img class="imgElement" width="120" height="120" src=\'imgs/11.jpeg\'/>']                         

const memoryTable    = []

function start(){
    createTableDataStructure()
    createImagesPairs()
    renderTable()
    startGame()
}

/* .........................................................................................................*/

function startGame(){
    createPairTryHit()
}

/* .........................................................................................................*/

function createPairTryHit(){
    
    let currentClickedImgTableIndex         = -1
    let previousClickedImgTableIndex        = -1
    let currentClickedImgIndex              = -1
    let previousClickedImgIndex             = -1
    

    let imgClassElements = document.getElementsByClassName("imgElement")
    for (let i = 0; i < imgClassElements.length; i++){
        imgClassElements[i].addEventListener("click", function(){

            previousClickedImgIndex               = currentClickedImgIndex
            currentClickedImgIndex                = i

            previousClickedImgTableIndex          = currentClickedImgTableIndex
            currentClickedImgTableIndex           = memoryTable[i]

            if(previousClickedImgTableIndex == currentClickedImgTableIndex 
                && previousClickedImgIndex != currentClickedImgIndex){

                alert('You got one!')
                previousClickedImgTableIndex    = -1
                currentClickedImgTableIndex     = -1
            }
        })
    }

}


/* .........................................................................................................*/

function createImagesPairs(){
    createSequenceOfPairs()
    spreadCards()
}

/* .........................................................................................................*/

// function createListeningClickEvents(){
//     let imgClassElements = document.getElementsByClassName("imgElement")
//     for (let i = 0; i < imgClassElements.length; i++){
//         imgClassElements[i].addEventListener("click", function(){
//             clickedImgIndex = memoryTable[i]
//             return clickedImgIndex
//         })
//     }
// }

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

function spreadCards(){
    let rand = 2
    let aux = 0
    let randomIndexTableMemory = 0
    let randomIndexTableMemoryWithRand = 0

    for(let i = 0; i < 100; i++){
        randomIndexTableMemory = createRandomIndexTableMemory()
        randomIndexTableMemoryWithRand = randomIndexTableMemory + rand;

        if(randomIndexTableMemoryWithRand >= memoryTable.length){
            randomIndexTableMemoryWithRand = rand - 1;
        }

        aux = memoryTable[randomIndexTableMemory]
        memoryTable[randomIndexTableMemory] = memoryTable[randomIndexTableMemoryWithRand]
        memoryTable[randomIndexTableMemoryWithRand] = aux
    }
    
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
            indexImgTable = memoryTable[indexMemoryTable];
            html += '<td>'
            html += '<div>'+imgsTable[indexImgTable]+'</div>'
         //   html += '<div>'+memoryTable[indexMemoryTable]+'</div>'
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