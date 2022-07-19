console.log("Olá, mundo!");

var titulo = document.querySelector(".titulo");
titulo.textContent = "Nutricionismo Aparecida";

//calcular imc

var paciente = document.querySelector("#primeiro-paciente"); // localiza primeiro cliente
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
}
if(altura <= 0 || altura >= 3){
    console.log("Altura inválida");
    alturaValida = false;    
    tdImc.textContent = "Altura Inválido";
}

if(alturaValida == true && pesoValido == true){
    //alterando valor do imc
    var imc = peso / (altura * altura);
    tdImc.textContent = imc;
}
