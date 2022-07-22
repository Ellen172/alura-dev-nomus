



// definir numero de palavras da frase

var frase = $(".frase").text(); //retorna o texto do elemento que tem classe frase
/* $(".frase") = jQuery(".frase") */
var numPalavras = frase.split(" ").length; //cria uma array, onde cada espaço divide o elemento, retorna o tamanho

// definir info-tamanho
var tamanhoFrase = $("#tamanho-frase");
tamanhoFrase.text(numPalavras);