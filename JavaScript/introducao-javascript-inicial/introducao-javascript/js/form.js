
var btnAdicionar = document.querySelector("#adicionar-paciente");
btnAdicionar.addEventListener("click", insereNaTabela);


function insereNaTabela(event){
    event.preventDefault(); // impede o comportamento padrão do botão
    console.log("insere na tabela");

    // localiza no form
    var form = document.querySelector("#form-adiciona");
    var paciente = obtemPacienteForm(form);

    // cria tr e td 
    var pacienteTr = montaTr(paciente);
    
    // insere tr na tabela
    var tabela = document.querySelector("#tabela-pacientes");
    tabela.appendChild(pacienteTr);

    form.reset(); // limpa o form
}

function obtemPacienteForm(form){
    var paciente = {
        nome: form.nome.value,
        peso: form.peso.value,
        altura: form.altura.value,
        gordura: form.gordura.value,
        imc: calculaIMC(form.peso.value, form.altura.value)
    }

    return paciente;
}

function montaTr(paciente){
    // cria elementos
    var pacienteTr = document.createElement("tr"); 

    // td como filhos de tr 
    pacienteTr.appendChild(montaTd(paciente.nome, "info-nome"));
    pacienteTr.appendChild(montaTd(paciente.peso, "info-peso"));
    pacienteTr.appendChild(montaTd(paciente.altura, "info-altura"));
    pacienteTr.appendChild(montaTd(paciente.gordura, "info-gordura"));
    pacienteTr.appendChild(montaTd(paciente.imc, "info-imc"));

    return pacienteTr;  
}

function montaTd(valor, classe){
    var td = document.createElement("td"); // cria elemento 
    td.textContent = valor; // adiciona valor
    td.classList.add(classe); // adiciona classe

    return td;
}