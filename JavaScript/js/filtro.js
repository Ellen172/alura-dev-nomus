var filtroNome = document.querySelector("#filtro-nome");

filtroNome.addEventListener("input", function(){
    var pacientes = document.querySelectorAll(".paciente");

    if(this.value.length > 0){ // mostra pacientes iguais
        pacientes.forEach(function(paciente){
            nome = paciente.querySelector(".info-nome").textContent;

            var expressao = new RegExp(filtroNome.value, "i");
            
            if(!expressao.test(nome)){
                paciente.classList.add("invisivel");
            } else {
                paciente.classList.remove("invisivel");
            }
            
        })
    }

    else { // mostra todos os pacientes
        pacientes.forEach(function(paciente){
            paciente.classList.remove("invisivel");
        })
    }

});
