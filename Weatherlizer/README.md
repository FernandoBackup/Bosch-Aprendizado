# Weatherlizer

## Resumo
O Weatherlizer é uma aplicação web que fornece informações climáticas para uma localização específica, baseada em latitude e longitude. A aplicação utiliza uma API externa para obter os dados climáticos e os armazena em um arquivo local.

## Funcionalidades
- Exibe um formulário para inserir latitude e longitude.
- Realiza validações de faixa para latitude e longitude.
- Obtém dados climáticos de uma API externa.
- Armazena os dados climáticos em um arquivo local.
- Exibe os dados climáticos em uma página web.

## Tecnologias
- **Linguagem de programação:** Java
- **Framework:** Spring
- **API:** ApiServiceWeather (não especificada)
- **Armazenamento de dados:** FileService (não especificada)

## Organização
A aplicação é organizada em uma estrutura de pacotes, com os seguintes componentes:

- `com.app.weatherlizer.controllers`: Contém o controlador da aplicação, responsável por lidar com as requisições e respostas.
- `com.app.weatherlizer.displays`: Contém a classe `WeatherDisplay`, responsável por exibir os dados climáticos.
- `com.app.weatherlizer.api.response`: Contém a classe `WeatherResponse`, responsável por lidar com a resposta da API.
- `com.app.weatherlizer.api.service`: Contém as classes `ApiServiceWeather` e `FileService`, responsáveis por lidar com a API e o armazenamento de dados, respectivamente.

## Requisitos para rodar a aplicação localmente
Para rodar a aplicação localmente, você precisará:
- Ter o Java 8 ou superior instalado.
- Ter o Spring Framework instalado.
- Ter a API `ApiServiceWeather` configurada e disponível.
- Ter o `FileService` configurado e disponível.
- Ter um servidor web configurado para rodar a aplicação.

## Instruções para rodar a aplicação localmente
1. Clone o repositório da aplicação.
2. Configure a API `ApiServiceWeather` e o `FileService` de acordo com as suas necessidades.
3. Compile e execute a aplicação utilizando o Spring Framework, com o comando `mvn spring-boot:run`.
4. Acesse a aplicação em um navegador web, utilizando a URL `http://localhost:8080/home/`.
5. Insira a latitude e longitude desejadas e clique em "Enviar".
6. A aplicação exibirá os dados climáticos para a localização especificada.
