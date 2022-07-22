
/* $(".frase") = jQuery(".frase") */
var frase = $(".frase").text(); //retorna o texto do elemento que tem classe frase
var tamanhoFrase = $("#tamanho-frase");
contaPalavras(frase, tamanhoFrase);

var campo = $("#campo-digitacao");
var contPalavras = $("#contador-palavras");
var contCaracteres = $("#contador-caracteres");
campo.on("input", function(){
    contaPalavras(campo.val(), contPalavras); //conta as palavras
    contCaracteres.text(campo.val().length); //conta os caracteres (tamanho total)
});


function contaPalavras(frase, elemento){
    var numPalavras = frase.split(/\S+/).length -1; //cria uma array, onde cada espaço vazio divide o elemento e retorna o tamanho
    elemento.text(numPalavras); // troca o texto do elemento pelo numPalavras
}