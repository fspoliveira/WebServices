Dicas de instalação:

O Contatos Web Services, usa na camada de persistência o Banco de Dados Big Table NoSQL da Oracle

Projeto foi testado no Linux Ubuntu 10.10 kernel 2.6.35-30-generic-pae 

Para a instalação do NoSQL, seguir os segintes passos:

1) Acessar o site: http://www.oracle.com/technetwork/products/nosqldb/downloads/index.html
2) Efetuar download do arquivo kv-ce-1.2.123.zip que se encontra na seguinte seção: "Oracle NoSQL Database, Community Edition"
3) Descompactar o arquivo
4) Acessar a pasta kv-1.2.123/bin/
5) Subir o serviço do NoSQL no Linux o comando é: ./run-kvlite.sh
6) Verificar se o serviço está no no ar acessando o seguinte endereço  no browser http://localhost:5001
Executar a classe br.com.fiap.publisher.ContatoPublisher para disponibilizar os Web Services