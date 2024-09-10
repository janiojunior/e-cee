# Projeto CEE - Clean Architecture com Quarkus

Este projeto segue os princípios da **Arquitetura Limpa** (Clean Architecture), utilizando o framework **Quarkus** para fornecer uma base sólida e escalável. A estrutura do projeto foi desenhada para separar claramente as responsabilidades e facilitar a manutenção, testes e evolução do software.

As camadas **Application**, **Domain** e **Infrastructure** fazem parte da **Arquitetura Limpa** (Clean Architecture), que tem como objetivo manter as responsabilidades bem separadas e o código organizado de uma forma que permita fácil manutenção, testes e escalabilidade. 

## 1. Application Layer (Camada de Aplicação)

**Responsabilidade**: A camada de aplicação orquestra o fluxo de dados entre as diferentes partes do sistema. Ela contém a lógica de **casos de uso** (use cases), que define o que o sistema deve fazer em um cenário específico.

**O que contém**:
- **Casos de Uso**: As classes de casos de uso são responsáveis por coordenar o comportamento da aplicação. Elas chamam os serviços e repositórios para executar as regras de negócio e a persistência dos dados.
- **Serviços**: Definições de serviços que coordenam interações entre as entidades de domínio e os repositórios.
- **Mapper**: Mapeadores que ajudam a converter objetos entre diferentes camadas, como entre a camada de domínio e DTOs.

**Depende de**: A camada de aplicação pode depender da camada de domínio e de interfaces (por exemplo, interfaces de repositório), mas não deve depender da camada de infraestrutura. Ela é independente dos frameworks, o que facilita a substituição de tecnologia.

**Exemplo**: Um caso de uso `CreateOrUpdateTipoDocumentoUseCase` na camada de aplicação pode coordenar a validação e persistência de um tipo de documento chamando o serviço apropriado e o repositório.

## 2. Domain Layer (Camada de Domínio)

**Responsabilidade**: A camada de domínio contém as regras de negócio e entidades centrais do sistema. Esta é a parte mais importante da aplicação, pois reflete o "coração" do software, sem depender de tecnologias externas.

**O que contém**:
- **Entidades**: Objetos de domínio que possuem comportamento e estado relacionados às regras de negócio. No caso do seu projeto, a entidade `TipoDocumento` representa o tipo de documento com suas propriedades e métodos.
- **Interfaces de Repositórios**: Contratos que descrevem como os dados serão acessados ou persistidos, sem definir como isso será feito (isso é responsabilidade da camada de infraestrutura).

**Depende de**: A camada de domínio é completamente independente das outras camadas. Ela não deve saber nada sobre frameworks, bancos de dados ou outros detalhes técnicos. É puramente focada nas regras de negócio.

**Exemplo**: Uma entidade `TipoDocumento` na camada de domínio possui regras de validação e comportamentos próprios, como verificar se o documento é válido, mas não sabe como ou onde será salvo.

## 3. Infrastructure Layer (Camada de Infraestrutura)

**Responsabilidade**: A camada de infraestrutura lida com detalhes técnicos como persistência de dados, comunicação com sistemas externos e frameworks de suporte. Ela implementa as interfaces definidas nas camadas de aplicação e domínio.

**O que contém**:
- **Repositórios Implementados**: As implementações concretas dos repositórios definidos na camada de domínio. Por exemplo, `TipoDocumentoRepositoryImpl` é a implementação que realmente persiste os dados no banco de dados.
- **Entidades de Persistência**: Entidades que mapeiam diretamente para tabelas no banco de dados. Elas podem ser diferentes das entidades de domínio, pois incluem detalhes técnicos necessários para a persistência, como mapeamento com frameworks ORM (e.g., JPA/Hibernate).
- **Recursos REST**: Os controladores ou recursos que expõem as APIs REST para o mundo externo, como `TipoDocumentoResource`.
- **Mapeadores DTO**: Objetos que transformam dados de entidades em DTOs (Data Transfer Objects) e vice-versa, para transportar dados entre as camadas de aplicação e a interface (ou API).

**Depende de**: A camada de infraestrutura depende tanto da camada de domínio quanto da camada de aplicação, pois implementa as interfaces e serviços definidos nessas camadas.

**Exemplo**: O repositório `TipoDocumentoRepositoryImpl` na infraestrutura seria responsável por persistir `TipoDocumento` no banco de dados, usando JPA ou outro ORM, mas ele implementa a interface definida na camada de domínio.

## Resumo das Diferenças

| **Camada**           | **Responsabilidade**                                                                                          | **Depende de**                                       | **Contém**                                                                                                                                                      |
|----------------------|--------------------------------------------------------------------------------------------------------------|-----------------------------------------------------|----------------------------------------------------------------------------------------------------------------------------------------------------------------|
| **Application**       | Orquestra o fluxo de dados e implementa casos de uso da aplicação                                             | Depende da camada de domínio (e interfaces)         | Casos de uso, serviços, mapeadores                                                                                                                              |
| **Domain**            | Regras de negócio e entidades do domínio, independentes de frameworks e detalhes de implementação técnica      | Independente de todas as camadas                    | Entidades de domínio, interfaces de repositórios, regras de negócio                                                                                             |
| **Infrastructure**    | Implementação técnica, como persistência, APIs, e comunicação com sistemas externos                           | Depende das camadas de domínio e aplicação          | Implementações de repositórios, entidades de persistência, DTOs, controladores REST, mapeadores de persistência                                          


## Estrutura de Pastas

A estrutura está organizada em camadas bem definidas, seguindo os princípios da Arquitetura Limpa, onde as camadas mais externas (como o acesso a dados e a interface) dependem das camadas mais internas (casos de uso e entidades de domínio).

### Pacotes

#### `br.gov.to.cee.ecee.application`

- **`mapper`**: Contém os mapeadores responsáveis por converter objetos entre as diferentes camadas. Exemplo: `TipoDocumentoEntityMapper`, que mapeia entre a entidade `TipoDocumento` e o DTO correspondente.
  
- **`model`**: Define os modelos utilizados na aplicação. Esses modelos são geralmente objetos de transporte de dados entre as camadas (DTOs ou modelos simplificados).
  
- **`service`**: Contém as interfaces dos serviços da aplicação. Por exemplo, `TipoDocumentoService` define os métodos para manipulação de tipos de documentos, mas não implementa a lógica.
  
- **`usecase`**: Implementa os casos de uso do sistema, ou seja, a lógica de negócio central. Cada classe dentro deste pacote representa um cenário específico de operação no sistema, como `CreateOrUpdateTipoDocumentoUseCase` (criação/atualização), `DeleteTipoDocumentoUseCase` (remoção), entre outros.

#### `br.gov.to.cee.ecee.domain`

- **`model`**: Contém as entidades que representam o domínio do sistema. No caso, `TipoDocumento` é a entidade que representa um tipo de documento.
  
- **`repository`**: Define as interfaces de repositórios do domínio. Por exemplo, `TipoDocumentoRepository` define os métodos que o repositório deve implementar para persistir e recuperar dados relacionados a `TipoDocumento`.

#### `br.gov.to.cee.ecee.infrastructure`

- **`dto`**: Contém os Data Transfer Objects (DTOs), que são utilizados para transportar dados entre o domínio e a infraestrutura, ou entre o sistema e o mundo externo (como a interface de usuário ou APIs externas). O `TipoDocumentoDTO` é o DTO correspondente à entidade `TipoDocumento`.

- **`entity`**: Define as entidades que mapeiam diretamente para o banco de dados, como `TipoDocumentoEntity`. Essas entidades são usadas nas implementações de repositório para persistir dados.

- **`repository`**: Contém as implementações das interfaces de repositório do domínio. Por exemplo, `TipoDocumentoRepositoryImpl` implementa `TipoDocumentoRepository` e lida com a persistência de `TipoDocumento` no banco de dados.

- **`resource`**: Define os endpoints REST que expõem a funcionalidade da aplicação. `TipoDocumentoResource` contém os endpoints relacionados à manipulação de tipos de documentos, seguindo os princípios do REST.

- **`service`**: Contém as implementações dos serviços definidos na camada de aplicação. Por exemplo, `TipoDocumentoServiceImpl` implementa os métodos definidos em `TipoDocumentoService` para manipular tipos de documentos.

## Benefícios da Arquitetura Limpa

- **Manutenibilidade**: Como as responsabilidades estão separadas, alterações em uma parte do sistema não afetam outras partes.
- **Testabilidade**: Com a lógica de negócio isolada na camada de domínio, fica mais fácil escrever testes unitários.
- **Escalabilidade**: O sistema pode crescer e se adaptar a novas tecnologias ou requisitos sem reescrever a lógica de negócio.

## Tecnologias Utilizadas

- **Quarkus**: Framework Java para microserviços.
- **Arquitetura Limpa**: Padrão arquitetural que separa as responsabilidades e facilita a evolução e manutenção do código.
- **JPA/Hibernate**: Para persistência de dados.


