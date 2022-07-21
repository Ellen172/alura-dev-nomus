console.log("Olá, mundo!");

calculaTodosImc();

// altera titulo
var titulo = document.querySelector(".titulo");
titulo.textContent = "Nutricionista Aparecida";

//mostra mensagem no console ao clicar no titulo
titulo.addEventListener("click", function(){
    console.log("olá, eu fui clicado!"); //função anônima
}) 

function calculaTodosImc(){
    //calcular imc

    var pacientes = document.querySelectorAll(".paciente"); // localiza todos os pacientes 

    for(var i=0; i< pacientes.length; i++){
        var paciente = pacientes[i];
        var peso = paciente.querySelector(".info-peso").textContent; //localiza dentro do paciente
        var altura = paciente.querySelector(".info-altura").textContent;
        var tdImc = paciente.querySelector(".info-imc");
        
        
        //validando valores 
        var pesoValido = validaPeso(peso);
        var alturaValida = validaAltura(altura);

        if(!pesoValido){
            tdImc.textContent = "Peso Inválido";
            paciente.classList.add("paciente-invalido");
        }

        if(!alturaValida){
            tdImc.textContent = "Altura Inválido";
            paciente.classList.add("paciente-invalido");
        }
        
        if(alturaValida == true && pesoValido == true){
            tdImc.textContent = calculaIMC(peso, altura); //insere valor calculado do imc
        }
    }
}

function calculaIMC(peso, altura){
    var imc = peso / (altura*altura);
    return imc.toFixed(2); 
}

function validaPeso(peso){
    if(peso >= 0 && peso < 1000) 
        return true;
    return false;
}

function validaAltura(altura){
    if(altura >= 0 && altura <= 3) 
        return true;
    return false;
}