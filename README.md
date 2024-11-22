# Projeto de Gerenciamento de Energia - SunnyMeter
Este projeto fornece uma API REST para gerenciar instalações, contratos, consumo e produção de energia solar, utilizando o banco de dados H2 e comandos do Maven para execução.

## 🛠️ Integrantes
- Anna Yagyu (RM 550360)
- Breno Silva (RM 99275)
- Lucas Vinicius Brigida (RM 99094)

## 🛠️ Tecnologias Utilizadas
- Java 17
- Spring Boot 3.x
- Maven 3.8
- Banco de Dados H2

## 🚀 Inicialização do Projeto

## Pré-requisitos
- **JDK 17+:** [Instale aqui](https://www.oracle.com/java/technologies/javase-jdk17-downloads.html)
- **Maven:** [Instale aqui](https://maven.apache.org/install.html)

## Configuração do Banco de Dados
O projeto utiliza o banco de dados H2 em modo persistente. As configurações padrão estão no arquivo `application.properties`.

## Execute o comando para iniciar o servidor
- mvn spring-boot:run

Acesse a aplicação em: http://localhost:8080

## Acessando o Console do H2
- URL do console: http://localhost:8080/h2-console

## Credenciais:
- JDBC URL: jdbc:h2:mem:testdb
- Username: sa (padrão)
- Password: (deixe vazio, padrão)

## 🌐 Rotas Disponíveis
### Clientes
- **Criar Cliente**
  
POST /clientes

  Body:
  ```json
   {
      "nome": "João Silva",
      "endereco": "Rua A, 123",
      "documento": "12345678900",
      "tipo": "Físico",
      "cep": "12345-678"
    }
   ```
    

- Listar Todos os Clientes
  
    GET /clientes

- Buscar Cliente por UUID
  
    GET /clientes/{cliente_uuid}

- Deletar Cliente

    DELETE /clientes/{cliente_uuid}


### Instalações
- **Criar Instalação**
POST /instalacoes

  Body:
```json
    {
  "nome": "Instalação Solar A",
  "endereco": "Rua das Flores, 41",
  "capacidade": 50.5
}
   ```
  
   

- Listar Todas as Instalações
  
    GET /instalacoes

- Buscar Instalação por UUID
  
    GET /instalacoes/{instalacao_uuid}

- Deletar Instalação
  
    DELETE /instalacoes/{instalacao_uuid}

### Contratos
- **Criar Contrato**
  
POST /contratos

  Body:
  ```json
{
  "cliente_uuid": "84b4b063-58a4-4dab-bf4f-fd13954c328c",
  "instalacao_uuid": "7da41106-5109-45f4-8d09-9ca405c33e5c",
  "dataInicio": "2024-01-01",
  "dataFim": "2025-01-01",
  "descricao": "Contrato para instalação A"
}
  ```

- Buscar Contrato por UUID
  
    GET /contratos/{contrato_uuid}

- Deletar Contrato
  
    DELETE /contratos/{contrato_uuid}
  
### Consumo
- **Registrar Consumo**
  
POST /consumo

Body:
```json
{
  "cliente_uuid": "84b4b063-58a4-4dab-bf4f-fd13954c328c",
  "dataConsumo": "2024-11-01",
  "quantidade": 410.90
}
```

- Obter Consumo Mensal
  
    GET /consumo/{cliente_uuid}

### Produção
- **Registrar Produção**
  
POST /producao

Body:
```json
{
  "instalacao_uuid": "7da41106-5109-45f4-8d09-9ca405c33e5c",
  "dataProducao": "2024-11-01",
  "quantidade": 15.51
}
```
- Obter Produção Mensal
  
GET /producao/{instalacao_uuid}

### Produção 
- **Obter Produção Mensal**  
  **GET** `/producao/{instalacao_uuid}`  

  Exemplo de Retorno:
  ```json
  {
    "instalacao": "Instalação Solar A",
    "totalProduzido": 450.75,
    "mes": "Novembro",
    "ano": 2024
  }

 ## 📝 Descrição das Entidades e Relacionamento
 
### RegistroProducao

- id: Identificador único (UUID).
- dataProducao: Data do registro de produção (String).
- quantidade: Quantidade de energia produzida (double).
- descricao: Informações adicionais sobre o registro (String).
- instalacao: Relacionamento com uma instalação.
- cliente: Relacionamento com um cliente.
  
### Cliente

- clienteUuid: Identificador único do cliente (UUID).
- nome: Nome do cliente (String).
- endereco: Endereço do cliente (String).
- documento: Número do documento (CPF ou CNPJ).
- tipo: Tipo de cliente (Físico ou Jurídico).
- cep: Código postal do cliente (String).
  
### Instalacao

- id: Identificador único da instalação (UUID).
- nome: Nome ou descrição da instalação (String).
- endereco: Endereço onde está localizada a instalação (String).
- capacidade: Capacidade de produção da instalação (double).
- cliente: Relacionamento com o cliente responsável.
  
### Contrato

- id: Identificador único do contrato (UUID).
- cliente: Relacionamento com o cliente.
- instalacao: Relacionamento com a instalação.
- dataInicio: Data de início do contrato (String).
- dataFim: Data de término do contrato (String).
- descricao: Informações adicionais sobre o contrato (String).
  
### RegistroConsumo

- id: Identificador único do registro (UUID).
- cliente: Relacionamento com o cliente.
- dataConsumo: Data do registro de consumo (String).
- quantidade: Quantidade de energia consumida (double).
