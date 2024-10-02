var fernando = {
    nome: "Fernando",
    cidadeNatal: function() {
      return {
        estado: "Acre",
        cidade: "Rio Branco"
      };
    },
    formacao: {
      ensinoMedio: "Completo",
      cursos: ["Administração (2 meses)"]
    },
  };

  function getHabilidades(fernando) {
    return {
      softSkills: ["Trabalho em Equipe", "Adaptabilidade", "Auto-Gerenciamento"],
      hardSkills: ["Python", "Java", "Banco de Dados"]
    };
  }

  function getInteresses(fernando) {
    return {
      hobbies: ["Jogar videogames", "Ouvir Música"],
      palavraChave: "Persistente"
    };
  }
  