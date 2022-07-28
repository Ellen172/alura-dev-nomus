$("#botao-frase").click(fraseAleatoria);
$("#botao-buscar-frase").click(buscaFrase);

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

function buscaFrase(){
    $("#spinner").show();

    var fraseId = $("#busca-frase").val();
    console.log(fraseId);
    var dados = { id: fraseId };
    $.get("http://localhost:3000/frases", dados, trocaFraseId)
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

function trocaFraseId(data){
    console.log(data);
    var frase = $(".frase");
    frase.text(data.texto);
    atualizaTamanhoFrase();
    atualizaTempoInicial(data.tempo);
}