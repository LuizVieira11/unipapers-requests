# API Unipapers

Esta API foi feita para a persistência das informações postadas pelo usuário.  

Até o momento foram feitos apenas endpoints referentes ao POST e GET, o básico devido pesquisa e tempo de criação.

### A fazer:
* Atualização do usuário (PUT ou BATCH)
* Delete do usuário
* Delete de pesquisas
* Adicionar usuários reais como colaboradores

### EndPoints de acesso:
* GET:
  * /api/readers
  * /api/readers/{id}
  * /api/readers/email?={email}
  * /api/writers
  * /api/writers/{id}
  * /api/writers/email?={email}
  * /api/researches
  * /api/researches/{id}
  * /api/researches/name?={name}
  * /api/researches/writer?={writer}
* POST:
  * /api/readers
  * /api/writers
  * /api/researches 
