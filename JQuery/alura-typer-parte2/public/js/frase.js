$("#botao-frase").click(fraseAleatoria);

function fraseAleatoria(){
    $("#spinner").show();

    $.get("http://localhost:3000/frases", trocaFraseAleatoria)
        .fail(function(){
            $("#erro").show();
            setTimeout(() => {
                $("#erro").toggle();
            }, 2000);
        })
        .always(function(){
            $("#spinner").toggle();
        });

}

function trocaFraseAleatoria(data){
    var frase = $(".frase");
    var numAleatorio = Math.floor(Math.random() * data.length);
    frase.text(data[numAleatorio].texto);
    atualizaTamanhoFrase();
    atualizaTempoInicial(data[numAleatorio].tempo);
}