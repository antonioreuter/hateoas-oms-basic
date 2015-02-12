# Visão Geral

Código para o artigo da Java Magazine.

O objetivo desse projeto é demonstrar como tornar sua API segura utilizando Spring Security. O intuito é demonstrar ao leitor um passo a passo mostrando as armadilhas que podemos encontrar ao tentar blindar nossa aplicação. Para facilitar a configuração da aplicação é utilizado o Spring Boot.

Esse projeto utiliza a ferramenta [Gradle](http://www.gradle.org/) para compilar e executar a aplicação. Assim, é necessário que somente o Java 6 ou maior esteja instalado, as demais dependências serão baixadas da Internet.

-----

# Executando a aplicação

Essa aplicação foi configurada com a ferramenta  para compilação e execução. Não é necessário fazer download de nenhuma ferramenta. Basta executar o seguinte comando:

> ./gradlew bootRun # caso esteja utilizando Linux ou Mac OS

ou

> gradlew.bat bootRun # caso esteja utilizando Windows

-----

# Serviços disponíveis

- [GET] /hateoas-oms/orders
- [GET] /hateoas-oms/orders/{id}
- [PUT] /hateoas-oms/orders/{id}/cancel

TODO: completar lista de serviços.
