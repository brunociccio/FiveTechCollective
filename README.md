# 5Tech Collective

API do Projeto 5Tech Colletive 

## Integrantes 

BRUNO MATHEWS DE CICICO OLIVEIRA - RM 99097 - Java Advanced e Devops

ISABELLE CORSI - RM 97751 - Mastering Relational and Non-Relationl Database

JOSÉ LUIZ FERREIRA DUARTE - RM 99488 - Mobile Application Development

MARINA DE SOUZA CUCCO - RM 551569 - Complice, Quality Assurance and Tests e Disruptive Architectures

THALITA FACHINETE DE ALENCAR - RM 99292 - Advanced Business Development With .NET e Disruptive Architectures

## OBJETIVO

Acelerar e privilegiar a entrada dos clientes Plusoft do setor automobilístico e do setor financeiro no mercado de carros elétricos, por meio da parceria advinda do compartilhamento, análise e tratamento de Machine Learning de dados disponíveis de ambos e de outros datasets. A resultante predição de comportamento do consumidor, sendo esses advindos da cartela desses clientes Plusoft ou não, identificará potenciais compradores de carros nessa nova modalidade além de clientes aptos a receber benefícios bancários para a compra.
Os modelos de Inteligência Artificial e suas predições de comportamento, portanto, terão como objetivo identificar e prever comportamentos e potencialidades em clientes e, partir dessas análises, será possível não só segmentar campanhas de marketing, mas principalmente elaborar ofertas de benefícios bancários e parcerias estratégicas para acelerar a montagem, revenda e/ou fabricação de carros elétricos e pontos de recarga.
Os benefícios dessa parceria entre banco e montadora são muitos e se alastram para as duas pontas. Em vista da crescente preocupação com questões de sustentabilidade, governo, consumidores e patrocinadores estão voltando seus interesses e esforços para empresas que contribuam com iniciativas sustentáveis. O ESG (Environmental, Social and Governance), sigla que representa a conformidade com aspectos ambientais, sociais e de governança na sociedade, se configura como um almejado indicativo de desempenho pelas empresas. 
       	Além disso, é inegável a crescente nos mercados de carros elétricos no mundo. A procura por meios sustentáveis e altamente tecnológicos tende a crescer cada vez mais, como vem acontecendo em outros países. Segundo análise de Rystad Energy, “17,5 milhões de eletrificados devem ser comercializados no ano, um crescimento de 18,5% em relação a 2023”.

Alguns exemplos de benefícios:
Subsídios e isenções fiscais
Expansão de base de clientes e aumento de participação no mercado
Liderança tecnológica de diferenciação competitiva
Inovação contínua por parte de montadora a partir da introdução de baterias de carregamento rápido
Melhora da imagem da empresa por meio de responsabilidade ambiental
Empresas que investem em veículos elétricos podem receber benefícios fiscais e subsídios e insumos governamentais.
Ou seja, empresas que financiam, apoiam e/ou geram o crescimento do consumo de carros elétricos no Brasil têm grandes chances de se beneficiarem com aumento de lucros, melhoria da imagem corporativa, inovação contínua, ganho de incentivos fiscais, novas oportunidades de negócios e uma posição competitiva fortalecida no mercado.

## Detalhamento do Objetivo

No cenário altamente competitivo do setor automobilístico, a conversão de leads em negócios concretos é crucial para o sucesso das empresas. No entanto, essa transição enfrenta desafios significativos, como a falta de compreensão do comportamento dos leads e a dificuldade em identificar oportunidades promissoras. Para superar esses desafios, estamos desenvolvendo uma ferramenta que utiliza análises avançadas de dados e Machine Learning.
Nossa abordagem se baseia em estudos específicos do segmento de carros elétricos, comparando-os com o segmento de carros convencionais. O objetivo é fornecer insights detalhados sobre o comportamento de compra dos usuários de carros convencionais que investem valores equivalentes aos de carros elétricos. Com isso, visamos identificar se esses usuários podem se tornar potenciais compradores do segmento de carros elétricos.
A ferramenta que estamos desenvolvendo permitirá compreender e prever o comportamento dos leads com alta precisão. Utilizando modelos preditivos aplicados a datasets tratados do setor automobilístico, buscamos fornecer insights valiosos que capacitem as empresas do setor de automóveis elétricos a tomar decisões estratégicas fundamentadas em dados.
Esses insights não só ajudarão a segmentar campanhas de marketing de maneira mais eficaz, mas também permitirão a elaboração de ofertas de benefícios bancários e parcerias estratégicas. O objetivo final é acelerar a montagem, revenda e/ou fabricação de carros elétricos e pontos de recarga, impulsionando a eficiência na conversão de leads.
Dessa forma, buscamos oferecer uma solução que beneficie todos os envolvidos, promovendo a sustentabilidade e contribuindo para o crescimento do mercado de carros elétricos. Ao capacitar as empresas com decisões estratégicas baseadas em dados, pretendemos não só melhorar a taxa de conversão de leads, mas também fomentar a inovação contínua e a liderança tecnológica no setor automobilístico.


## Java Advanced - Aplicação Java e Spring Boot

- Produzir pelo menos um dos domínios da solução tecnologógica utilizando Java e Spring [ok]
- Conter código que respeite a coesão e desacoplamento [ok]
- Respeitar os padrões DTO e utilizar Beans Validation [ok]
- Respeitar os conceitos fundamentais de REST [ok]
- API contendo um modelo com nível de maturidade 1 [ok]: feito com base em tudo o que aplicamos na matéria até o momento
- Utilizamos o Repository [ok]
- Utilizamos o JPA Query Methods [ok]
- O repositório está publicado no GitHub com domínio público[ok]

## Entrega

- Apresentar o cronograma de desenvolvimento e respeitar os prazos {esse item constá nessa documentação do arquivo README} - 5 pts [ok]
- Diagrama de Entidade de Relacionamento (DER) e Diagrama de Classes das Entidades constam em uma pasta nesse projeto chamada "Diagramas" - 10 pts [ok]
- Implementação das classes de Entidade necessárias para solução, atenção devida ao encapsulamento, tipagem dos atributos e ao mapeamento  objeto relacional com JPA - Consta no cronograma - primeiro Diagrama de Classe já implementado no projeto com as classes relacionadas ao Cadastro de usuários em nossa aplicação - 40 pts [ok]
- A aplicação respeita os conceitos fundamentais do REST e de acordo com a maturidade de nível 1 - 15 pts [ok]
- A gestão de configuração dos artefatos de software, o repositório está publicado devidamente no GitHub - 10 pts [ok]
- Link do GitHub - 10 pts [ok]: https://github.com/brunociccio/FiveTechColletive
- Link do Pitch no YouTube [versão 1 do Pitch, iremos produzir uma outra]: https://youtu.be/jTpoI_ScsZ8

## Cronograma e Implementações

- [ ] CRUD da classe Cadastro (implementado - sprint 1)
- [ ] CRUD das outras classes: CadastrarCnpj, Contato, Documentos e Endereço (implementado - sprint 2, na sprint 3 será implementada uma API no frontend para a busca do endereço através do CEP)
- [ ] CRUD de Login (será implementado até a sprint 3, utilizará uma API de autenticação)
- [ ] Dashboard (será implementado conforme a evoluação das telas entregues pelo responsavel de Mobile App - sprints 3 e 4)
- [ ] IA (será implementando conforme o desenvolvimento dos datasets que será tratados com base em IA Generativa junto a nossa aplicação - sprints 3 e 4)
- [ ] Banco de Dados (implementado parcialmente, evoluirá conforme o decorrer do projeto e a implementação das outras classes - sprint 3 e 4)
- [ ] Diagrama de Classes 1 - Login e Cadastrar (implementado no sprint 1 e 2)
- [ ] Diagrama de Classes 2 - Funcionalidades da Aplicação (será implementado junto a evoluação das matérias no decorrer da entraga das sprints 3 e 4)
- [ ] Documentação de todos os endpoints e funcionalidades do projeto foram implementados com swagger (implementado na sprint 2)
- [ ] Aplicação do admin criado em outro projeto Java / Spring (implementado na sprint 2)

# Documentação da API

A aplicação roda no http://localhost:8080/home

A documentação roda:
springdoc.swagger-ui.path=/docs
http://localhost:8080/swagger-ui/index.html#/

O console de adm está no repositório do GitHub:
https://github.com/brunociccio/ADM-Java-Spring.git
spring.boot.admin.client.url=http://localhost:9090
