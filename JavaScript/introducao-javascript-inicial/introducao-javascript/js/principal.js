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
        
        
        var pesoValido = true;
        var alturaValida = true;
        //validando valores 
        if(peso <= 0 || peso >= 1000){
            console.log("Peso inválido");
            pesoValido = false;
            tdImc.textContent = "Peso Inválido";
            paciente.classList.add("paciente-invalido");
        }
        if(altura <= 0 || altura >= 3){
            console.log("Altura inválida");
            alturaValida = false;    
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