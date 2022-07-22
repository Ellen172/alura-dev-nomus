erroCarregaPaciente = document.querySelector("#erro-carrega-paciente");
erroCarregaPaciente.classList.add("invisivel");

var btnCarregar = document.querySelector("#carregar-paciente");

btnCarregar.addEventListener("click", function(){
    console.log("carregando pacientes");

    var xhr = new XMLHttpRequest(); // objeto para requesições html 
    xhr.open("GET", "https://api-pacientes.herokuapp.com/pacientes"); // metodo da requisição, url da requisição
    
    xhr.addEventListener("load", function(){
        if(xhr.status == 200){ // nenhum erro
            erroCarregaPaciente.classList.add("invisivel");

            // recebe resposta da requisição
            var resposta = xhr.responseText;
            
            // converte para ojeto javascript
            var pacientes = JSON.parse(resposta);
            
            // insere pacientes na tabela
            pacientes.forEach( function (paciente) {
                insereNaTabela(paciente);
            });
        } else { // erro na requisição
            console.log(xhr.status);
            console.log(xhr.responseText);
            erroCarregaPaciente.classList.remove("invisivel");
        }
    });
    
    xhr.send();


});