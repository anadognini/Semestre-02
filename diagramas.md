Relacionamento entre objetos

Assim como no mundo real, os objetos na OO também se relacionam e este relacionamento ocorre de diferentes formas e graus.

Basicamente podemos identificar os relacionamentos temporários e duradouros entre objetos.

Um relacionamento temporário é aquele em que, para cumprir determinada responsabilidade, um objeto necessita de outro objeto (conhecê-lo e solicitar suas operações) apenas durante a execução desta responsabilidade. Este tipo de relacionamento é chamado de dependência e ocorre no nível dos métodos.

Os relacionamentos duradouros são aqueles em que durante a vida de um objeto ele está ligado a outro para cumprir várias de suas responsabilidades. Estes relacionamentos podem ser de associação ou de agregação e ocorrem no nível dos atributos.

Class (Classe) – É a classe propriamente dita. Usamos este elemento quando queremos demostrar visualmente a classe no diagrama (exemplos mais à frente).

Association (Associação – conector sem pontas) – É um tipo de relacionamento usado entre classes. Aplicável a classes que são independentes (vivem sem dependência umas das outras), mas que em algum momento no ciclo de vida do software (enquanto ele está em execução) podem ter alguma relação conceitual.

Generalization (Herança – conector com seta em uma das pontas) –  É um tipo de relacionamento onde a classe generalizada (onde a “ponta da seta” do conector fica) fornece recursos para a classe especializada (herdeira). Excetuando conceitos mais avançados (como padrões de projeto, interfaces, visibilidades específicas etc.), tudo que a classe mãe (generalizada) tem, a filha (especializada) terá.

Compose (Composição – conector com um “diamante” hachurado na ponta) – É um tipo de relacionamento onde a classe composta depende de outras classes para “existir”. Por exemplo, a classe “CorpoHumano” possui um composição com a classe “Coracao”. Sem a classe “Coracao”, a classe “CorpoHumano” não pode existir. Mais detalhes neste post completo sobre Composição.

Aggregate (Agregação – conector com um “diamante” vazado na ponta) – É um tipo de relacionamento onde a classe agregada usa outra classes para “existir”, mas pode viver sem ela. Por exemplo, a classe “CorpoHumano” possui uma agregação com a classe “Mao”. Sem a “Mao” a classe “CorpoHumano” pode existir. Mais detalhe neste post completo sobre Agregação.

1. Dependência

Como dito, a relação de dependência ocorre entre dois objetos quando temporariamente um necessita do outro – assim, o objeto A necessita/depende do objeto B.

No diagrama de classe da UML isto é representado por uma linha pontilhada, terminada em uma seta da classe dependente para a classe utilizada.

![Unidade 6 - Dependência genérica](https://user-images.githubusercontent.com/92342881/192633815-b0eee1c3-1ed7-4f02-8b08-875b47a67ee6.png)

Em termos de código, a dependência é percebida quando um objeto é utilizado como variável local a um método (parâmetro ou declarado localmente).

Como exemplo, imagine a situação onde um objeto de projetor possua um método limpar(). Para executar esta operação ele precisa temporariamente de um objeto de Pano, que o servirá apenas naquele instante.

class Projetor {

...

public void limpar(){

     Pano umPano = new Pano();  // exemplo de dependência

     umPano.esfregar();         // por declaração local   

...

}

 

public void limpar(Pano p){  // exemplo de dependência

     ...                                // por parâmetro

     p.esfregar();

     ...

}

}

 

class Pano {

...

}

2. Associação

A relação de associação ocorre entre dois objetos quando este relacionamento é uma das características de um dos objetos, isto é, um dos atributos relevantes de um objeto é o outro objeto. Assim, o relacionamento é mais duradouro entre o objeto A e o objeto B.

O motivo ou significado do relacionamento deve ser expresso, ou seja, deve-se nomear o relacionamento.

No diagrama de classe da UML isto é representado por uma linha, com a nomeação da associação indicada.

![Unidade 6 - Associação genérica](https://user-images.githubusercontent.com/92342881/192634000-d1e96eaa-986e-462c-a01a-02158e73a59b.png)

Na associação, além de nomeá-la, devemos também indicar sua multiplicidade. Lembre-se da teoria dos conjuntos. Para a multiplicidade vamos identificar quantos objetos de um conjunto se relacionam com quantos objetos do outro conjunto.

Como exemplo, imagine que um Projetor está alocado ou instalado em uma Sala. Identificar a multiplicidade é fazer duas perguntas:

Quantos Projetores podem estar alocados em uma mesma Sala (0, 1 ou vários)?
Em quantas Salas pode estar alocado o mesmo Projetor (0, 1 ou várias)?

![Unidade 6 - Associação Projetor-Sala](https://user-images.githubusercontent.com/92342881/192634101-a0d0dcc8-0639-4867-8d54-128eee8c1ec0.png)

Então a leitura se dá: um objeto de Projetor está alocado a nenhum ou no máximo a um objeto de Sala. Um objeto de Sala aloca nenhum ou vários objetos de Projetor.

Em termos de código, a associação é implementada colocando como atributo de uma das classes um handle para objeto(s) da outra.

Qual classe conterá o atributo? Depende do contexto do problema e da maneira como se quer projetar a solução. Normalmente a classe que participa com multiplicidade 1 é atributo da outra. Mas para deixar isto bem claro no diagrama, ainda existe a notação da navegabilidade (uma seta no final da linha de associação), que indicará a partir de qual objeto existe a referência para o outro.

![Unidade 6 - Navegabilidade Projetor-Sala](https://user-images.githubusercontent.com/92342881/192634159-64a9508f-68ed-4503-843c-2513ea043ced.png)

Como atributo, devemos lembrar que seu conteúdo será encapsulado. Isto requer a implementação de métodos para manipular esta referência.

class Projetor {

...

     private Sala umaSala;

 

public void setSala(Sala s){

... 

     this.umaSala = s;

...

}

}

 

class Sala {

...

}

3.  Agregação

A relação de agregação ocorre entre dois objetos quando está envolvido o conceito de “todo-parte”, isto é, um objeto forma ou compõe o outro objeto.

Neste momento não discutiremos a diferença entre agregação e composição, assumindo que ocorrendo “todo-parte” será modelada a agregação.

No diagrama de classe da UML isto é representado por uma linha com um losango junto à classe que indica o todo na relação. Não há necessidade de nomear uma agregação, pois seu significado já está determinado: a parte (Classe B) está contida no todo (Classe A); o todo tem uma parte.

![Unidade 6 - Agregação genérica](https://user-images.githubusercontent.com/92342881/192634424-bcc341fa-f39d-4e11-8da1-9d3e01965b66.png)

Também aqui devemos indicar sua multiplicidade, fazendo as mesmas perguntas da associação. Imagine que o campus universitário é formado por Blocos de edifícios e que estes são formados por Salas:

Quantos Salas podem estar existir em um mesmo Bloco (0, 1 ou várias)?
Em quantos Blocos pode estar alocada a mesma Sala (0, 1 ou vários)?

![Unidade 6 - Agregação Bloco-Sala](https://user-images.githubusercontent.com/92342881/192634512-ac67abf8-57d6-4578-9dd3-f4a3769bb143.png)

Então a leitura se dá: um objeto de Bloco é formado por no mínimo 1 ou vários objetos de Sala. Um objeto de Sala faz parte de 1 objeto de Bloco.

Em termos de código, a agregação é implementada colocando como atributo de uma das classes (todo) um handle para uma coleção de objetos da outra (parte). E normalmente esta é a navegabilidade esperada (que fica implícita no diagrama).

Como atributo, devemos lembrar que seu conteúdo será encapsulado. Isto requer a implementação de métodos para manipular esta coleção.

class Bloco {

...

     private List salas = new ArrayList();

 

public void addSala(Sala s){

... 

     salas.add(s);

...

}

}

 

class Sala {

...

}

Exemplo de Uso

![diagrama-classes-compartimentos](https://user-images.githubusercontent.com/92342881/192638487-09a24968-87d2-45b5-b766-89bf24bad7a2.png)

Uma classe, na UML (e na Orientação a Objetos também) possui três compartimentos, sendo para: Nome (primeiro), Atributos (segundo) e Operações (terceiro).

Quando fazemos o uso de um diagrama de classes no dia a dia da produção de software, nem sempre é necessário/relevante representar cada classe no menor nível de detalhe , ou seja, com os três compartimentos, e com todo rigor nas especificações dos atributos e operações.

Abaixo temos três exemplos de um mesmo diagrama, em níveis de detalhes diferentes. No último exemplo vamos ver detalhes de cada classe e seus relacionamentos.

![diagrama-classes-compartimentos-apenas-classes](https://user-images.githubusercontent.com/92342881/192638544-d13c8a9c-a7d2-4758-8e36-3e7faa38afdd.png)

No diagrama cima temos relacionamentos de Associação, Agregação, Composição e Generalização (Herança). A explicação a seguir aplica-se a todos os três exemplos, pois foca apenas nos relacionamentos:

Cozinha pode ter ou não uma PortaCozinha, podendo existir se não tiver. (Agregação)
PortaCozinha generaliza Porta, possuindo todas as características que Porta têm, além das suas específicas. (Generalização)
Quarto deve ter PortaQuarto, não podendo existir se não tiver. (Composição)
PortaQuarto generaliza Porta, que tem todas as características que Porta têm, além das suas específicas. (Generalização)
Sala deve ter PortaSala, não podendo existir se não tiver. (Composição)
PortaSala generaliza Porta, que tem todas as características que Porta têm, além das suas específicas. (Generalização)
Sala pode ter ou não uma Porta que não seja uma PortaSala, mas se tiver ou não isso não fará diferença, pois Porta pode existir sem Sala, e Sala pode existir sem Porta. (Associação).
(no contexto do diagrama anterior) este tipo de representação acima é muito usado/recomendado quando:

Uma equipe está discutindo um problema e algum profissional quer esboçar (esboço = rascunho, “rabisco”) como pensa na solução, em termos de arquitetura.
Um profissional quer mostrar apenas as dependências entre as classes do sistema, para uma análise de impacto ou contextualização da arquitetura.
Não há necessidade de entrar em maiores detalhes sobre as classes, apenas identificá-las e ilustrar suas relações.

![diagrama-classes-compartimentos-classes-atributos](https://user-images.githubusercontent.com/92342881/192638619-8df6df0e-8732-496f-9f1a-12efdd728bc2.png)

O diagrama acima já é um pouco diferente do primeiro, pois além dos compartimentos com os nomes das classes, possui também um outro compartimento contendo os atributos da classe (as classes sem atributos são classes “filhas” de outras [generalização], que portanto, implicitamente possuem todos os atributos que a classe “mãe” possui).

Este tipo de representação acima é muito usado/recomendado quando:

O objetivo é demonstrar as classes, seus relacionamentos, seus atributos e não há necessidade de detalhar as operações da classe.
O profissional precisa (ou entende ser necessário) dar mais contexto às classes, detalhando seus atributos, para que se compreenda melhor o escopo de cada classe do modelo e como isso compõe o entendimento sobre as relações entre as classes.

![diagrama-classes-compartimentos-classes-atributos-operacoes-completo](https://user-images.githubusercontent.com/92342881/192638666-f2a18c4e-c72f-481a-9abf-df00c855c998.png)

O diagrama acima já é bem diferente do primeiro e do segundo, pois além dos compartimentos com os nomes das classes e atributos, possui também um outro compartimento contendo as operações da classe.

Este tipo de representação acima é muito usado/recomendado quando:

O objetivo é demonstrar as classes, seus relacionamentos, e cada classe com seu escopo completo.
Quando a empresa realiza projeto formal do software, utilizando ferramentas case, modelos de classes que serão utilizados para outra empresa (ou a mesma até) para entendimento sobre o software a ser construído.
Muito cobrado em empresas que prestam serviço para órgãos públicos através de licitação.
O profissional precisa (ou entende ser necessário) dar 100% de contexto às classes, detalhando seus atributos e suas operações, para que se compreenda melhor o escopo de cada classe do modelo e como isso compõe o entendimento sobre as relações entre as classes.

Concluindo

O diagrama de classes da UML é sem dúvida uma ferramenta espetacular para auxiliar os profissionais de produção de software no entendimento acerca do que deve ser feito, e como deve ser feito.

Saber utilizá-lo da maneira correta e com bom senso auxilia demais qualquer equipe, mas abusar de seu uso, documentando o desnecessário e gastando tempo detalhando o que não é relevante, subtrai muito da produtividade de qualquer profissional/empresa.
