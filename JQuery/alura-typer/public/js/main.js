// $("#frase") = jQuery("#frase") 

var campoDigitacao = $(".campo-digitacao");
var tempoInicial = $("#tempo-digitacao").text();
var cronometro = $("#tempo-digitacao");

$(function(){
//$(document).ready(function(){

    //executado assim que a pagina estiver pronta

    atualizaTamanhoFrase();
    inicializaContadores();
    inicializaCronometro(tempoInicial);
    inicializaMarcadores();
        
    $("#btn-reiniciar").click(reiniciaJogo);
});


/* funções */  

function inicializaMarcadores(){

    var frase = $("#frase").text();
    campoDigitacao.on("input", function(){
        var digitado = $(".campo-digitacao").val();
        var comparavel = frase.substr(0, digitado.length);
        console.log(digitado);
        console.log(comparavel);
        if(digitado == comparavel){
            campoDigitacao.removeClass("texto-errado");
            campoDigitacao.addClass("texto-correto");
        } else {
            campoDigitacao.removeClass("texto-correto");
            campoDigitacao.addClass("texto-errado");
        }
        
    });
}

function reiniciaJogo(){
    campoDigitacao.attr("disabled", false); //habilita textarea
    campoDigitacao.val(""); //reseta valor do campo

    inicializaContadores();
    cronometro.text(tempoInicial);
    inicializaCronometro(tempoInicial);
    campoDigitacao.removeClass("campo-desativado");
    campoDigitacao.removeClass("texto-correto");
    campoDigitacao.removeClass("texto-errado");
}

function inicializaCronometro(tempoRestante){
    campoDigitacao.one("focus", function(){ // chama na primeira vez que ocorre o focus
        $("#btn-reiniciar").attr("disabled", true);
        var cronometroId = setInterval(function(){
            tempoRestante--;
            cronometro.text(tempoRestante); 
            
            if(tempoRestante < 1){
                // game over
                campoDigitacao.attr("disabled", true);
                campoDigitacao.addClass("campo-desativado");
                $("#btn-reiniciar").attr("disabled", false);
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
    var frase = $("#frase").text(); //retorna o texto do elemento que tem classe frase
    var tamanhoFrase = $("#tamanho-frase");
    contaPalavras(frase, tamanhoFrase);
    
}

function contaPalavras(frase, elemento){
    var numPalavras = frase.split(/\S+/).length -1; //cria uma array, onde cada espaço vazio divide o elemento e retorna o tamanho
    elemento.text(numPalavras); // troca o texto do elemento pelo numPalavras
}