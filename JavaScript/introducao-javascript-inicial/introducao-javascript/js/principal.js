console.log("Olá, mundo!");

calculaImc();

var titulo = document.querySelector(".titulo");
titulo.textContent = "Nutricionista Aparecida";

//mostra mensagem no console ao clicar no titulo
titulo.addEventListener("click", function(){
    console.log("olá, eu fui clicado!"); //função anônima
}) 

var btnAdicionar = document.querySelector("#adicionar-paciente");
btnAdicionar.addEventListener("click", insereNaTabela);


function insereNaTabela(event){
    event.preventDefault(); //impede o comportamento padrão do botão
    console.log("insere na tabela");

    //localiza no form
    var form = document.querySelector("#form-adiciona");
    var nome = form.nome.value;
    var peso = form.peso.value;
    var altura = form.altura.value;
    var gordura = form.gordura.value;

    //cria elementos
    var pacienteTr = document.createElement("tr"); 
    var nomeTd = document.createElement("td");
    var pesoTd = document.createElement("td");
    var alturaTd = document.createElement("td");
    var gorduraTd = document.createElement("td");
    var imcTd = document.createElement("td");

    //td como filhos de tr 
    pacienteTr.appendChild(nomeTd);
    pacienteTr.appendChild(pesoTd);
    pacienteTr.appendChild(alturaTd);
    pacienteTr.appendChild(gorduraTd);
    pacienteTr.appendChild(imcTd);
    
    //adiciona classes
    pacienteTr.classList.add("paciente"); 
    nomeTd.classList.add("info-nome");
    pesoTd.classList.add("info-peso");
    alturaTd.classList.add("info-altura");
    gorduraTd.classList.add("info-gorduda");
    imcTd.classList.add("info-imc");
    
    //atribui valores aos elementos
    nomeTd.textContent = nome;
    pesoTd.textContent = peso;
    alturaTd.textContent = altura;
    gorduraTd.textContent = gordura;

    //inserindo na tabela
    var tabela = document.querySelector("#tabela-pacientes");
    tabela.appendChild(pacienteTr);
}

function calculaImc(){
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
            //alterando valor do imc
            var imc = peso / (altura * altura);
            tdImc.textContent = imc.toFixed(2);
        }
    }
}
