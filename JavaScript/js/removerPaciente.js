var tabela = document.querySelector("#tabela-pacientes");

tabela.addEventListener("dblclick", function(event) {
    // event.target => td que foi clicado
    // event.target.parentNode => tr (pai do td)

    event.target.parentNode.classList.add("fadeOut"); // animação de remoção
    setTimeout(function(){
        event.target.parentNode.remove(); 
    }, 500); //espera 500ms para remover elemento
    
});
