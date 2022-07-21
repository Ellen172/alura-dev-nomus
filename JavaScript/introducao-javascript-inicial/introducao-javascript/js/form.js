
var btnAdicionar = document.querySelector("#adicionar-paciente");
btnAdicionar.addEventListener("click", insereNaTabela);


function insereNaTabela(event){
    event.preventDefault(); // impede o comportamento padrão do botão
    
    var form = document.querySelector("#form-adiciona"); // localiza form
    var paciente = obtemPacienteForm(form); // obtem valores do form
    var pacienteTr = montaTr(paciente); // cria elementos tr e td

    // exibe erros
    var erros = validaPaciente(paciente);
    exibeErros(erros);

    // mensagem de sucesso
    sucesso = document.querySelector("#mensagem-sucesso");
    sucesso.textContent = "";

    if(erros.length == 0){ // sem erros
        // insere tr na tabela
        var tabela = document.querySelector("#tabela-pacientes");
        tabela.appendChild(pacienteTr);
        form.reset(); // limpa o form
        sucesso.textContent = "Paciente inserido com sucesso!";
    } 

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

function validaPaciente(paciente){
    var erros = [];

    // insere erros
    if(paciente.nome.length == 0) erros.push("Nome não pode ser vazio");
    if(paciente.peso.length == 0) erros.push("Peso não pode ser vazio");
    if(!validaPeso(paciente.peso)) erros.push("Peso inválido");
    if(paciente.altura.length == 0) erros.push("Altura não pode ser vazia")
    if(!validaAltura(paciente.altura)) erros.push("Altura inválida");
    if(paciente.gordura.length == 0) erros.push("Gordura não pode ser vazia");

    return erros;
}

function exibeErros(erros){
    var ul = document.querySelector("#mensagem-erro");

    // remove erros anteriores
    ul.innerHTML = "";

    erros.forEach(function(erro){ 
        li = document.createElement("li"); //cria li
        li.textContent = erro; //adiciona erro como texto
        ul.appendChild(li); //insere como filho no ul
    });
}