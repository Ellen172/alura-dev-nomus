
/* $(".frase") = jQuery(".frase") */
var frase = $(".frase").text(); //retorna o texto do elemento que tem classe frase
var tamanhoFrase = $("#tamanho-frase");
contaPalavras(frase, tamanhoFrase);

// contadores do textarea
var campoDigitacao = $("#campo-digitacao");
var contPalavras = $("#contador-palavras");
var contCaracteres = $("#contador-caracteres");
campoDigitacao.on("input", function(){
    contaPalavras(campoDigitacao.val(), contPalavras); //conta as palavras
    contCaracteres.text(campoDigitacao.val().length); //conta os caracteres (tamanho total)
});

// decrescer contador de tempo
var tempoRestante = $("#tempo-digitacao").text();
campoDigitacao.one("focus", function(){ // chama na primeira vez que ocorre o focus
    var cronometroId = setInterval(function(){
        tempoRestante--;
        $("#tempo-digitacao").text(tempoRestante); 
        console.log(tempoRestante);
        if(tempoRestante < 1){
            // game over
            campoDigitacao.attr("disabled", "");
            clearInterval(cronometroId);
        }
    }, 1000);
});

function contaPalavras(frase, elemento){
    var numPalavras = frase.split(/\S+/).length -1; //cria uma array, onde cada espaço vazio divide o elemento e retorna o tamanho
    elemento.text(numPalavras); // troca o texto do elemento pelo numPalavras
}