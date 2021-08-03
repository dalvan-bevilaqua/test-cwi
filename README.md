# Requisitos: Java 12, Docker ou Postgree.

Usuários Docker: abrir no cmd a raiz da pasta e executar docker-compose up.

Usuários Postgree: Configurar o arquivo application.properties com o caminho porta e senha do seu banco de dados.

Após isso rodar o programa como qualquer aplicação spring.


http://localhost:8089/v1/pauta
{
  "nome":"teste",
  "descricao":"teste"
}

http://localhost:8089/v1/pauta/1/iniciar
{
  "dtFechamento": "2021-07-21T22:45:35.566-0300"
}

http://localhost:8089/v1/voto
{
  "idPauta":1,
  "voto":"S",
  "cpf":"07245516999"
}

select * from pauta

select * from voto

select * from votante

select * from pautaresultado 
