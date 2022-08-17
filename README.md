<p align="center">
        <img src="https://avatars.githubusercontent.com/u/109238400?s=400&u=e5b242311297e5a0b1c2a7e4efd42d523c158b59&v=4">
</p>

## Sobre

Essa aplicação tem como base o projeto desenvolvido em: [Freshwarehouse](https://github.com/javatastico/freshWarehouse).
Porém com um requisito extra para realizar gerencia de uma lista de desejos do usuário.


## Requisito desenvolvido

O requisito desenvolvido tem como objetivo permitir que um usuário monte uma lista de desejos,
adicionando os produtos que tenha interesse para deixa-los salvos para consultar quando desejar.
Ao adicionar um produto em um carrinho de compras existem algumas validações que validam a quantidade do produto em um estoque, sua data de validade,
entre outros. Porém ao adicionar o produto somente na lista de compras estas validações não se fazem necessárias, pois tratam apenas do interesse do
usuário com aquele determinado produto, sem ser necessárias informações administrativas em relação ao lote ou localização do produto em estoque.
Para o sistema o interessante de ter esse requisito seria poder utilizar alguns atributos para notificar o usuário quando um produto estiver disponível,
acabando, de promoção, ou outros fatores que possam levar o usuário a comprar aqueles produtos que já demonstrou interesse anteriormente.

## Documentação

A documentação completa da história de usuário pode ser baixado em: [Documentos](https://github.com/MateusMeli/freshWarehouse-Mateus/raw/feature/US06_Wishlist/Documents/Requisito%206%20-%20Inserir%20produto%20na%20lista%20de%20desejos.pdf).


## Como subir o projeto

Ao inicializar o projeto serão criados alguns dados iniciais no banco. Estes dados são gerados por meio do script data.sql que
pode ser encontrado na pasta de resources. Caso não possua nenhum dado no seu banco mesmo após o levantamento do projeto, rode os seguintes comandos em ordem:

```SQL
use fresh_warehouse_db;

INSERT INTO warehouse(address, city, country, number, state) values('Address 1', 'City 1', 'Country 1', 1, 'State 1');
INSERT INTO section(name, id_warehouse, available_space) values('Fresh', 1, 100);
INSERT INTO seller(name) values('Seller Name');
INSERT INTO buyer(name) VALUES ('Buyer Name');
```

Após esta inicialização dos dados básicos, é necessário criar um produto através de uma requisição.
Para criar este produto, primeiramente,
importe no seu Postman a Collection [US06](https://github.com/MateusMeli/freshWarehouse-Mateus/blob/feature/US06_Wishlist/Documents/collections/US06%20-%20Mateus.postman_collection.json)
, depois disso, abra a requisição de "Post Product" e aperte para enviar. Caso a importação da collection
fornecida não tenha funcionado, realize uma requisição do tipo POST na rota:
http://localhost:8080/api/v1/fresh-products/product passando como body:

```JSON
{
    "name": "Apple",
    "price": 10.00,
    "sectionsId": [1],
    "sellerId": 1
}
```

Após esta requisição já podemos visitar os 4 endpoints do requisito em si.

### Add to Wishlist

Nesse primeiro endpoint vamos adicionar um produto na lista de desejos
de um comprador. Para isso você pode utilizar o request Add to Wishlist fornecido no postman
ou realizar uma requisição de POST na rota: http://localhost:8080/api/v1/fresh-products/wishlist
com o body:

```JSON
{
  "buyerId": 1,
  "productId": 1
}
```

Ao executar pela primeira vez, sera criada a lista de desejos do usuário
mas caso ele já possua uma, você pode fornecer produtos diferentes e ele irá incrementar na lista existente estes novos produtos.

### Get all wishlists

Neste endpoint vamos retornar todas as listas de desejos
do sistema. Para isso você pode utilizar o request
Get All fornecido no postman
ou realizar uma requisição de GET na rota:
http://localhost:8080/api/v1/fresh-products/wishlist

### Get by Id

Neste endpoint vamos retornar todas a lista de desejos
que possua o Id fornecido na rota. Para isso você pode utilizar o request
Get by ID fornecido no postman
ou realizar uma requisição de GET na rota:
http://localhost:8080/api/v1/fresh-products/wishlist/1

### Get by Buyer

Neste endpoint vamos retornar a lista de desejos
do comprador que possua o Id indicado na rota. Para isso você pode utilizar o request
Get by Buyer fornecido no postman
ou realizar uma requisição de GET na rota:
http://localhost:8080/api/v1/fresh-products/wishlist/buyer?buyerId=1

## UML

<p align="center">
  <img src="https://github.com/MateusMeli/freshWarehouse-Mateus/blob/feature/US06_Wishlist/Documents/UML.png?raw=true">
</p>