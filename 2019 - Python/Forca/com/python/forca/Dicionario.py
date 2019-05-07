class Dicionario:

    def lerPalavrasArquivo(self):
        arquivoDePalavras = open('palavras.txt', 'r');
        for palavra in arquivoDePalavras:
            print(palavra)


