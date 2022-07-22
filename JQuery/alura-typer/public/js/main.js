// $(".frase") = jQuery(".frase") 

var campoDigitacao = $("#campo-digitacao");
var tempoInicial = $("#tempo-digitacao").text();
var cronometro = $("#tempo-digitacao");

$(function(){
//$(document).ready(function(){

    //executado assim que a pagina estiver pronta
    console.log(tempoInicial);
    atualizaTamanhoFrase();
    inicializaContadores();
    inicializaCronometro(tempoInicial);
        
    $("#btn-reiniciar").click(reiniciaJogo);
});


/* funções */  


function reiniciaJogo(){
    campoDigitacao.attr("disabled", false); //habilita textarea
    campoDigitacao.val(""); //reseta valor do campo

    inicializaContadores();
    cronometro.text(tempoInicial);
    inicializaCronometro(tempoInicial);
}

function inicializaCronometro(tempoRestante){
    campoDigitacao.one("focus", function(){ // chama na primeira vez que ocorre o focus
        var cronometroId = setInterval(function(){
            tempoRestante--;
            cronometro.text(tempoRestante); 
            
            if(tempoRestante < 1){
                // game over
                campoDigitacao.attr("disabled", true);
                clearInterval(cronometroId);
            }
        }, 1000);
    });
}

function inicializaContadores(){
    campoDigitacao.on("input", function(){        
        var contPalavras = $("#contador-palavras");
        var contCaracteres = $("#contador-caracteres");
        
        contaPalavras(campoDigitacao.val(), contPalavras); //conta as palavras
        contCaracteres.text(campoDigitacao.val().length); //conta os caracteres (tamanho total)
    });
}

function atualizaTamanhoFrase(){
    var frase = $(".frase").text(); //retorna o texto do elemento que tem classe frase
    var tamanhoFrase = $("#tamanho-frase");
    contaPalavras(frase, tamanhoFrase);
    
}

function contaPalavras(frase, elemento){
    var numPalavras = frase.split(/\S+/).length -1; //cria uma array, onde cada espaço vazio divide o elemento e retorna o tamanho
    elemento.text(numPalavras); // troca o texto do elemento pelo numPalavras
}