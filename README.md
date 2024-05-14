
# Seminário de `Angular`

Seminário técnico e aprofundado sobre `Angular`, com foco na arquitetura e implementação, referente à matéria de Programação Web ministrada por [Helaine Lins](https://github.com/helaine-barreiros).

> **Obs:** Este repositório é apenas uma cópia do que foi feito no repositório [Harmonify](https://github.com/Bunbismuth/Harmonify), o qual foi utilizado para o desenvolvimento desse projeto, em colaboração com [@MateusVasc](https://github.com/MateusVasc), [@Jdbsn](https://github.com/jdbsn) e [@Bunbismuth](https://github.com/Bunbismuth). 

# Seção 1: Introdução ao Angular

## 1.1 O que é Angular?

Angular (comumente referido como **"Angular 2+"** ou **"Angular 2"**) é uma plataforma de aplicações web de código-fonte aberto e front-end baseado em TypeScript liderado pela Equipe Angular do Google e por uma comunidade de indivíduos e corporações. Angular é **uma reescrita completa do AngularJS**, feito pela mesma equipe que o construiu.

### Angular vs Angular.js

Originalmente, a reescrita do **AngularJS** foi chamado de "Angular 2" pela equipe, mas isto levou à confusão entre os desenvolvedores. Para esclarecer, a equipe anunciou que termos separados devem ser usados para cada Framework, com "AngularJS", referindo-se a 1.X versões e "Angular" sem o "JS", referindo-se às versões à partir da 2 até a última.

### Diferenças do Angular para o Angular.js
- Angular não tem um conceito de "escopo" ou controladores, em vez disso, ele usa uma hierarquia de componentes como o seu principal conceito arquitetônico
- Angular tem uma expressão diferente de sintaxe, concentrando-se no uso de "[ ]" para a propriedade de ligação, e no uso de "( )" para ligação do evento
- Modularidade – muito das funcionalidades principais foram movidas para as tabelas
- Carregamento dinâmico
- O TypeScript é um superconjunto do ECMAScript 6 (ES6), e é compatível com ECMAScript 5 (i.e.: JavaScript). Angular também inclui ES6: 
    - Lambdas
    - Iteradores
    - For/Of loops
    - Python - estilo de geradores
    - Reflexão
- Modelo de compilação assíncrono
- A substituição de controladores e $escopo com componentes e diretrizes – um componente é uma directiva com um modelo
- Programação reativa de suporte usando RxJS

## Características do Angular

- **Suporte cross-platform:** esse framework fornece suporte a múltiplas plataformas de desenvolvimento. O Angular pode ser utilizado para criar aplicações web SPA, aplicações mobile (com o suporte do Ionic, por exemplo) ou até mesmo aplicações desktop (com o suporte do Electron).
- **Integração e suporte à todas as fases de desenvolvimento:** provê ferramental e suporte para todas as fases de desenvolvimento, desde a escrita do código em si (apoiando-se bastante na API e no sistema de tipos do TypeScript) até a criação de fluxos de teste (com o apoio principalmente do Karma – uma biblioteca para escrita de testes JavaScript), passando pelo suporte excelente à criação de animações, o provisionamento de estruturas de acessibilidade e até mesmo o scaffolding de projetos através do Angular CLI;
- **Produtividade aliada à performance:** consegue oferecer suporte ao desenvolvimento rápido de aplicações através de uma API simples, bem estruturada e bem documentada, o que acaba trazendo bastante produtividade.
- Por fim, por mais que o Angular **não utilize o conceito de Virtual DOM** (conceito utilizado por outros frameworks, como o React), ainda sim o Angular oferece uma performance bem interessante, principalmente com a Ivy, a engine de renderização utilizada desde o Angular 6+.

### Curva de Aprendizado

**O Angular é o framework que tem a curva de aprendizado mais complexa**, pois envolve o entendimento de Typescript e da arquitetura Model-View-Control (MVC). O MVC separa a aplicação em camadas, de modo que a interface e os dados se comunicam através de um controlador. Entretanto, o tempo investido pode valer a pena, pois se trata de uma tecnologia bem completa.

Quanto ao React, sua curva de aprendizado não é tão íngreme. Por outro lado, trata-se de um framework que **depende da adição de recursos externos** para a criação de aplicações mais complexas. Esse ponto, além de **causar um maior número de importações ao código, pode ocasionar mais erros**. 

Por fim, o Vue é o mais fácil de todos. Seu aprendizado é simples e o entendimento desse framework pode ser um facilitador para quem deseja posteriormente avançar para React ou Angular. Entretanto, o Vue é uma tecnologia flexível, o que permite **a construção de código ruim que pode dificultar a manutenção das aplicações**. 

### Flexibilidade

O Vue é o framework mais flexível de todos, sendo o React o intermediário e o Angular o mais complexo.  Entretanto, a flexibilidade do Vue pode favorecer a desorganização do código e o excesso de responsabilidades em virtude da adição de bibliotecas externas.

### Simplicidade de Desenvolvimento

Todos os três frameworks possuem configurações semelhantes, podendo utilizar o terminal de comando do sistema operacional para isso. Quanto à facilidade de desenvolvimento, o Angular se torna o mais complexo, **por usar linguagem de programação tipada e orientação a objetos**. 

Enquanto o Vue se torna o mais simples, mas seu excesso de flexibilidade **pode tornar o projeto difícil de manter**. Já o React, também não há muitas dificuldades em se utilizar, porém trata-se de uma tecnologia que **precisa de bibliotecas de terceiros para incorporar funcionalidades**.

## 1.2 Por que Angular?

O `Angular` se tornou um dos frameworks JavaScript mais populares para o desenvolvimento de aplicações web complexas por diversos motivos:

- **Facilidade de Desenvolvimento:** Principalmente devido ao conceito de `data-binding`, que permite a sincronização automática entre a interface do usuário e a lógica de negócios, simplificando a manipulação de dados.
- **Extensibilidade:** Permite a criação de módulos, componentes e serviços personalizados pelos desenvolvedores, contribuindo bastante para flexibilidade do framework.
- **Integração com Outras Tecnologias:** Compatível com diversas tecnologias front-end e back-end, como bibliotecas JavaScript, frameworks CSS e APIs RESTful. Isso ocorre principalmente por fatores de modularidade e padronização que o `Angular` segue, bem como por possuir uma comunidade ativa e que contribui com o framework.
- **Injeção de Dependências:** O sistema de injeção de dependências do `Angular` facilita a organização do código, promovendo a reutilização de componentes e serviços de forma clara e estruturada.
- **Comunidade forte:** Tem uma comunidade de desenvolvedores que contribue bastante com documentação, tutoriais e ferramentas, facilitando muito o suporte e troca de conhecimento.

**Casos de Uso:**

Alguns casos de uso ideais para `Angular` são:

- **Single Page Applications (SPAs):** É adequado para o desenvolvimento de SPAs, pois oferece a capacidade de atualizar dinamicamente apenas as partes necessárias da página, sem recarregar a página inteira, proporcionando uma experiência de usuário mais rápida e fluida.
- **Aplicativos Móveis:** É adequado para aplicativos móveis devido à sua arquitetura modular e extensível. A sua estruturação de componentes permite a criação de interfaces dinâmicas, responsivas e reutilizáveis.

**Considerações:**

Embora seja um framework extremamente útil e robusto, é importante reconhecer que nenhum framework ou biblioteca é perfeito, e sua escolha deve depender das necessidades do projeto e da equipe de desenvolvimento. Algumas desvantagens do `Angular` em comparação com outros frameworks e bibliotecas, como `React` e `Vue`, são:

- **Curva de Aprendizado Mais Íngreme:** A complexidade de sua arquitetura e a variedade de conceitos, como `módulos`, `componentes`, `injeção de dependência`, `serviços` e `data-binding` podem tornar a entrada para desenvolvedores iniciantes mais desafiadora e sufocante.
- **Tamanho do Pacote:** O tamanho do pacote do `Angular` é geralmente maior do que o de bibliotecas como React ou Vue. Isso pode afetar o tempo de carregamento da aplicação.
- **Performance em Aplicações Menos Complexas**: Em projetos menos complexos, a estrutura robusta do `Angular` pode ser considerada excessiva e sobrecarregada.

## 1.3 Primeiros Passos com Angular

### Instalação

Para instalar o Angular é necessário ter um gerenciador de pacotes instalado, como o npm (obtido junto com o [Node.js](https://nodejs.org/en)) ou [yarn](https://yarnpkg.com/). Dito isto, abra seu terminal para executar o comando de acordo com seu gerenciador:

**npm:**
```
npm install -g @angular/cli
```
**yarn:**
```
yarn global add @angular/cli
```

<br>

> O `-g` ou o `global` indicam que o Angular será instalado globalmente
> no sistema, ao invés de apenas em um projeto em especifico, o que
> permite utilizar seus comandos em qualquer lugar.

### Primeiro projeto

Com a instalação concluída, navegue até a pasta que será criado seu projeto Angular, e use o seguinte comando:

```
ng new nome-do-projeto
```

Será perguntado qual mecanismo de  estilização você deseja usar, (ex.: CSS, SCSS). Para escolher, use as setas do teclado e aperte enter. Após isso, será perguntado se quer que o SSR (renderização em tempo real) e SSG (renderização em tempo de compilação) sejam ativados. Por padrão, essa opção fica desativada, logo, basta apertar enter mais uma vez. Serão instalados todos os pacotes necessários, o que em geral, leva um certo tempo até em computadores mais potentes.

Parâmetros também pode ser adicionados após o nome do projeto, entre eles:

| Parâmetro  | Descrição |
|--|--|
| `--routing` | Habilita o roteamento no projeto. |
| `--skip-git` | Não inicializa um repositório Git local. |
| `--skip-tests` | Não gera os arquivos de teste `spec.ts`. |
| `--commit` | Desativa o commit inicial automático. |

### Estrutura de pastas

Ao criar um projeto, por padrão, são criadas duas pastas:

- src
	- app (componentes, serviços, módulos, etc)
	- assets (arquivos estáticos, como imagens, CSS, scripts, etc)
- node_modules (dependências do projeto)

Além disso, também são criados arquivos necessários para a aplicação, como o `main.ts`, responsável por iniciar a aplicação, o `package.json`, que contém informações do projeto e onde estão listadas todas as dependências e o `angular.json`, o arquivo de configurações do Angular CLI. Vale ressaltar que na maior parte do tempo, só será trabalhado os arquivos dentro de "src".

## 1.4 Primeiro Componente Angular

O Angular é estruturado em torno de componentes - uma parte independente e reutilizável da interface (UI) que contém um template (página HTML), junto com o arquivo para sua estilização e uma classe TypeScript, responsável pelas operações e manipulação de dados. 
A comunicação do template com seu componente (via a classe TS) é possível devido o conceito de data-binding, que consiste em um mecanismo que mantem a página atualizada baseada no estado da aplicação e vice-versa.

Um componente pode ser gerado utilizando um dos seguintes comandos:
```bash
ng generate component [nome]
ng g c [nome]
```

# Seção 2: Arquitetura do Angular

## 2.1 Estrutura de Componentes do Angular

Arquitetura do Angular é toda baseada em componentes e módulos. Nós criamos componentes individuais que ao juntar formamos nossa página.

Porém cada componente atende de forma singular uma tarefa, sendo assim, a **reutilização é muito grande**. Uma aplicação tem pelo menos um módulo que inicia toda a aplicação necessária para rodar.

### Componentes

Os componentes são um conjunto de elementos e funcionalidades que dão vida aquela aplicação.

Um componente é uma classe TypeScript com o decorator @Component, um componente de view por exemplo contra o GUI (Graphical User Interface), e um component lógico, controla as funções que são endereçadas a ele.

Um componente pode ser composto por outros componentes também, um exemplo é uma tarefa ativa pode ser seu próprio componente assim como uma tarefa concluída.

Nós injetamos o Service para definir o comportamento do componente, isso na lógica do componente. E os Decorators nos ajudam a manipular o DOM.

### Angular Modules

Uma aplicação é um conjunto construído por Components, Directives e Services. Esse grupo com essa organização é chamado de Modules e por padrão ele é chamado de **ngModule**.

Aplicações tendem a ter vários modules, porém só com o padrão a aplicação já funciona.

Ele nos ajuda a **organizar e modularizar a nossa aplicação, sendo assim, podemos reutilizar o módulo completo em outras partes da aplicação** em si e com os módulos podemos escolher o que vamos expor para fora dele.

Um modulo pode ser gerado pelo o AngularCLI da seguinte forma:
```bash
ng generate module [nome]
ng g m [nome]
```

### Angular Imports

Os imports são usados para saber onde o Angular irá procurar a funcionalidade que estamos usando em nosso módulo.

Todas as dependências como libs, módulos integrados ou personalizados, devem ser importados antes de usarmos as funcionalidades, ou seja, devem ser a primeira coisa a ser importada.

### Angular Classes e decorators

O **decorator é uma forma de dizer ao Angular como uma classe deve ser tratada**. Um exemplo é o @Component, estamos dizendo ao Angular que aquela classe é um componente e assim deve ser tratado, alguns componentes do Angular:

- @NgModule
- @Component
- @Pipe
- @Input
- @Output
- @ContentChild
- @ContentChildren
- @Injectable
- @Directive
- @HostBinding
- @HostListener
- @ViewChild
- @ViewChildren

### Templates

São neles que definimos onde o Angular em si irá procurar os arquivos que lidam diretamente na view do usuário que são os arquivos HTML e CSS que interagem com o componente que estamos vendo na tela no momento. O Angular usa {} para interpolação e [] para vincular propriedades.

### Metadata

É aqui onde informamos ao Angular como processar uma classe um exemplo é o @Componente que é um metadata como selector, templateURL e outros.

### Services

Com o Service do Angular, podemos usar ele para prover uma funcionalidade comum para um componente por exemplo:

Temos um sistema de mensagem que é responsável por dar o Ok ou falha para uma determinada função na aplicação, e ela se repete em várias partes, não vamos colocar essa mensagem em todos os componentes um a um, podemos criar um Service que será usado por todos os componentes em si.

Um Service pode ser gerado pelo o AngularCLI da seguinte forma:
```bash
ng generate service [nome]
ng g s [nome]
```

## 2.2 Data-binding Bidirecional do Angular

## Definição de data binding

Podemos dizer que data-binding é a comunicação entre a view e a lógica, quando atualizamos a lógica ela reflete na view. Existem três tipos de databinding no Angular:

1. **One way  databinding**, que vai da lógica do TS para o view do HTML. A saída de dados da lógica reflete na view como ``String Interpolation`` ou ``Property binding``.
2. **One way databinding**, da view para lógica. Aqui podemos reagir a eventos do HTML, como clicks de botões, com o ``Event binding``. 
3. **Two way binding**, entre a lógica e a view. Aqui é uma combinação, podemos reagir a eventos e output ao mesmo tempo.

No two-way data binding, alterações na **view são refletidas na fonte de dados e atualizações na fonte refletem na view** sem a necessidade de manipulação explícita do DOM.

## Implementando two-way data-binding no Angular

Em outubro de 2014 foi anunciado o desenvolvimento da versão 2.0 ou Angular do framework da Google. A nova versão gerou muita polêmica por ser muito diferente da anterior, inclusive por **não oferecer mais o two-way data binding, pelo menos não como o conhecemos no Angular 1.X ou Angular.js**.

Embora houveram alterações no Angular em comparação ao Angular.js nesse aspecto do data biding bidirecional, podemos conseguir algo semelhante combinando os dois tipos de associação do Angular (data binding + event binding):

```html
 <!-- template --> 
 <form ng-submit="grava()"> 
  <input (input)="palestrante.nome = $event.target.value" 
  ```value="palestrante.nome" placeholder="Nome">

  <input (input)="palestrante.email = $event.target.value" 
  ```value="palestrante.email" placeholder="E-mail">

  <button type="submit">Gravar</button>
</form> 
```

Quando o evento ``input`` é disparado, ``$event.target`` representa quem disparou o evento. Sendo um elemento do DOM, podemos acessar seu valor com ``$event.target.value``. É este valor que é atualizado na propriedade palestrante do nosso componente.

Contudo, a equipe do Angular 2 criou uma diretiva que funciona como uma espécie de atalho para esses dois tipos de associação, a ``ngModel``:

```html
 <!-- template --> 
 <form ng-submit="grava()"> 
  <input ```(ngModel)="palestrante.nome" placeholder="Nome">

  <input ```(ngModel)="palestrante.email" placeholder="E-mail">

  <button type="submit">Gravar</button> 
</form> 
```

Veja que a diretiva está envolvida por ``[()]``, ou seja, temos **os dois tipos de associações unidirecionais ao mesmo tempo**, mas com direções opostas no fluxo de atualização.

Apesar de uma sintaxe e uma implementação um tanto diferente (data binding + event binding), é possível conseguir uma **resultado semelhante ao two-way data binding em Angular**.

## 2.3 Comunicação Entre Componentes

A comunicação eficaz entre componentes é fundamental para o desenvolvimento de aplicações `Angular` robustas e modulares. Neste tópico, serão apresentadas 4 maneiras de implementar a comunicação de componentes em Angular:

1. **Usando o decorator `@Input` para definir propriedades de entrada e passar dados de um pai para um filho.**
2. **Usando o decorator `@Output` para definir propriedades de saída e enviar uma resposta de um filho de volta para seu pai.**
3. **Usando o decorator `@ViewChild` ou `@ViewChildren` para definir ou ler propriedades de um componente filho de dentro de seu pai.**
4. **Usaando um `Service` como intermediário para comunicação entre componentes não relacionados em todo o aplicativo.**

### `@Input` Decorator (Pai-->Filho)

Se dois componentes tiverem um relacionamento `pai-filho`, na maioria dos casos o uso de propriedades de entrada será a melhor opção para passar dados de um pai para seu filho.

Para definir uma propriedade de entrada, adicionamos o decorator `@Input` à propriedade.

```typescript
import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-child',
  templateUrl: './child.component.html',
  styleUrls: ['./child.component.css']
})
export class ChildComponent implements OnInit {

  @Input() checked: boolean;

  constructor() { }

  ngOnInit() {
  }

}
```

Essa propriedade fica então disponível para vinculação. O pai pode usá-lo para vincular um valor, uma variável ou uma expressão a essa propriedade de entrada.

```typescript
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-parent',
  templateUrl: './parent.component.html',
  styleUrls: ['./parent.component.css'],
})
export class ParentComponent implements OnInit {
  isChecked = false;
  constructor() {}

  ngOnInit() {}
}
```

```html
<div class="wrapper">
  <input type="checkbox" [(ngModel)]="isChecked" />
  <p>Agree that you love pandas?</p>
</div>
<app-child [checked]="isChecked"></app-child>
```

A propriedade de entrada `[checked]` é o destino da ligação, enquanto `isChecked` é a fonte da ligação. Como a vinculação de propriedade é usada, isso significa que se o pai modificar a propriedade de origem, o filho receberá o valor alterado.

```html
<p *ngIf="checked; else notChecked">You love pandas! Yay!</p>
<ng-template #notChecked>
  <p>No? How could you?!</p>
</ng-template>
```

### `@Output` Decorator (Filho-->Pai)

Respectivamente, se o filho precisar se comunicar com seu pai, podemos definir propriedades de saída no componente filho. No entanto, diferentemente das propriedades de entrada que usam associação de propriedade, as propriedades de saída funcionam emitindo eventos que são capturados com associação de evento.

Para definir uma propriedade de saída, adicionamos o decorator `@Output` à propriedade. O componente filho pode então usar essa propriedade para emitir um evento. Opcionalmente, ele pode anexar alguns dados (conhecidos como carga útil do evento) ao evento emitido.

```typescript
import { Component, OnInit, Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'app-child',
  templateUrl: './child.component.html',
  styleUrls: ['./child.component.css'],
})
export class ChildComponent implements OnInit {
  @Output() selectedItem = new EventEmitter<number>();
  constructor() {}

  ngOnInit() {}

  selectBox(id: number) {
    this.selectedItem.emit(id);
  }
}
```

```html
<!-- child.component.html -->
<div>
  <button *ngFor="let id of [1, 2, 3]" (click)="selectBox(id)">
    Box {{ id }}
  </button>
</div>
```

O pai pode capturar esses eventos usando a vinculação de eventos em seu modelo.

```html
<p *ngIf="!id">Select a box:</p>
<p *ngIf="id">You selected box no. {{ id }}</p>

<app-child (selectedItem)="onItemSelection($event)"></app-child>
```

Ele pode então chamar um método para reagir ao evento.

```typescript
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-parent',
  templateUrl: './parent.component.html',
  styleUrls: ['./parent.component.css'],
})
export class ParentComponent implements OnInit {
  id: number;
  constructor() {}

  ngOnInit() {}

  onItemSelection(id: number): void {
    this.id = id;
  }
}
```

**Os decorators `@Input` e `@Output` podem ser combinados para obter uma ligação bidirecional `(two-way binding)` entre as propriedades pai e filho.**

Na classe do componente filho, definimos uma propriedade de entrada e saída. O nome da propriedade de saída deve ser o nome da propriedade de entrada com o sufixo Change no final.

```typescript
//child.component.ts
import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';

@Component({
  selector: 'app-child',
  templateUrl: './child.component.html',
  styleUrls: ['./child.component.css'],
})
export class ChildComponent implements OnInit {
  @Input() text: string;
  @Output() textChange = new EventEmitter<string>();

  valueChange(value: string): void {
    this.textChange.emit(value);
  }

  constructor() {}

  ngOnInit() {}
}
```

```typescript
//parent.component.ts
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-parent',
  templateUrl: './parent.component.html',
  styleUrls: ['./parent.component.css'],
})
export class ParentComponent implements OnInit {
  text: string;
  constructor() {}

  ngOnInit() {}
}
```

```html
<p>My child typed: {{ text }}</p>

<app-child [(text)]="text"></app-child>
```

```html
<input type="text" [ngModel]="text" (ngModelChange)="valueChange($event)" />
```

### `@ViewChild` Decorator

Em vez de passar dados por meio de propriedades de **input** ou emitir eventos por meio de propriedades de **output**, o pai pode acessar as propriedades e métodos do filho diretamente usando o decorador `@ViewChild` ou `@ViewChilden`.

O decorador `@ViewChild` nos permite obter uma referência a qualquer elemento, diretiva ou componente filho do modelo.

Para obter a referência, podemos usar uma variável de referência de modelo:

```html
<app-child #child></app-child>
```

ou o tipo de componente filho:

```typescript
@Component({ ... })
export class ParentComponent {
  @ViewChild('child') child: ChildComponent;
  // ...
}
```

### `Service`

Os componentes nem sempre terão um relacionamento `pai-filho`. Eles podem não estar relacionados e aparecer em locais diferentes do aplicativo.

Os `services` podem ser definidos anotando uma classe com o decorator `@Injectable`. Se definirmos a propriedade `providedIn` como **root**, o serviço será registrado como um singleton. Angular manterá uma única instância do serviço na cadeia de injeção de dependência.

```typescript
import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class DataService {
  private isCheckedSubject = new BehaviorSubject<boolean>(false);
  public isChecked$ = this.isCheckedSubject.asObservable();

  constructor() {}

  public setCheckedValue(value: boolean) {
    this.isCheckedSubject.next(value);
  }
}
```

```typescript
import { Component, OnInit } from '@angular/core';
import { DataService } from '../data.service';

@Component({
  selector: 'app-two',
  templateUrl: './two.component.html',
  styleUrls: ['./two.component.css'],
})
export class TwoComponent implements OnInit {
  constructor(public dataService: DataService) {}

  ngOnInit() {}
}
```

```typescript
import { Component, OnInit } from '@angular/core';
import { DataService } from '../data.service';

@Component({
  selector: 'app-one',
  templateUrl: './one.component.html',
  styleUrls: ['./one.component.css'],
})
export class OneComponent implements OnInit {
  constructor(private dataService: DataService) {}

  ngOnInit() {}

  onChange(value: boolean): void {
    this.dataService.setCheckedValue(value);
  }
}
```

```html
<!-- app.component.html -->
<div>
  <app-one></app-one>
  <app-two></app-two>
</div>
```

```html
<!-- two.component.html -->
<p *ngIf="dataService.isChecked$ | async; else notChecked">
  You love pandas! Yay!
</p>

<ng-template #notChecked>
  <p>No? How could you?!</p>
</ng-template>
```

```html
<!-- one.component.html -->
<div class="wrapper">
  <input type="checkbox" (change)="onChange($any($event).target.checked)" />
  <p>Agree that you love pandas?</p>
</div>
```

# Seção 3: Padrões de Projeto e Implementação Avançada no Angular

## 3.1 Padrões de Projeto no Angular

Padrões de projeto são soluções comuns de arquiteturas e padrões de códigos para problemas comuns em desenvolvimento de software. São modos de implementação para solucionar algo específico no desenvolvimento de um projeto. Podem se encaixar também como um modelo de solucionar um problema que pode ser resolvido de diversas maneiras. Dentro do `Angular` não é diferente, ele possui uma estrutura poderosa que incorpora vários padrões de projeto para facilitar o desenvolvimento web. Cada padrão desempenha um papel fundamental na criação de aplicações robustas e manuteníveis. Dentre os principais padrões dentro do framework, podemos destacar alguns:

### 3.1.1 Singleton ###

O padrão Singleton garante que uma determinada classe tenha apenas uma instância e fornece um ponto de acesso global para essa instância. No Angular, os serviços são frequentemente implementados como singletons. Eles são injetados em componentes e módulos, proporcionando uma única instância compartilhada. Isso é crucial para manter o estado consistente em toda a aplicação. Isso significa que todos os componentes que dependem desse serviço receberão a mesma instância única. Portanto, podemos usar esse serviço para armazenar dados na memória e recuperar os dados armazenados do mesmo ou de diferentes componentes. Isso pode trazer diversos benefícios, como:

- **Melhor desempenho:** Como só existe uma instância, não há necessidade de criar e destruir objetos constantemente, o que pode melhorar o desempenho da aplicação.
- **Economia de memória:** Com apenas uma instância, menos memória é utilizada, o que pode ser importante em aplicações com recursos limitados.
- **Código mais limpo:** O uso de singletons pode ajudar a manter o código mais organizado e fácil de entender, pois não há necessidade de se preocupar com a criação e o gerenciamento de várias instâncias.
- **Consistência:** O uso de singletons garante que o estado de um objeto seja sempre consistente, pois não há várias instâncias modificando o mesmo estado.

Uma das maneiras de definir um serviço como Singleton é definindo o parâmetro `providedIn` como `root` dentro do Decorator `@Injectable`. Isso garante que apenas uma instância do serviço seja criada e usada em toda a aplicação. Após isso, você pode importar o serviço no componente que precisa usá-lo e injetar o mesmo no construtor do componente.

```typescript
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class AuthService {

  constructor() { }

  login() {
    // ...
  }

  logout() {
    // ...
  }
}
```

```typescript
import { Component, OnInit } from '@angular/core';
import { AuthService } from './auth.service';

@Component({
  selector: 'my-app',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {

  constructor(private authService: AuthService) { }

  ngOnInit() {
    // ...
  }
}
```

### 3.1.2 Decorator ###

O padrão Decorator permite adicionar comportamentos adicionais a objetos de forma dinâmica. No Angular, os decoradores são frequentemente utilizados para aprimorar ou modificar o comportamento de classes ou membros de classes sem modificar diretamente o código subjacente. Como a anotação `@Component` para transformar uma classe comum em um componente Angular.

```typescript
@Component({
  selector: 'app-meu-componente',
  templateUrl: './meu-componente.component.html',
  styleUrls: ['./meu-componente.component.css']
})
export class MeuComponente {
  // ...
}
```

Aqui, o decorador `@Component` informa ao Angular que a classe MeuComponente é um componente. Ele também fornece metadados sobre o componente, como o seletor, o template HTML e os estilos CSS. Ao usar o padrão Decorator em Angular, você pode estender ou modificar dinamicamente a funcionalidade dos componentes existentes. Essa abordagem fornece flexibilidade, capacidade de reutilização de código e capacidade de manutenção, pois você pode reutilizar os componentes básicos enquanto adiciona comportamento ou conteúdo específico conforme necessário.

### 3.1.2 Padrão MVC e MVVM

![MVC Architecture](https://miro.medium.com/v2/resize:fit:640/format:webp/1*WW33OuunwrO4UR5uWn-Ueg.jpeg)

Ambos os padrões de arquitetura **Model-View-Controller (MVC)** e **Model-View-ViewModel (MVVM)** são usados em Angular e servem como princípios fundamentais de design para estruturar aplicações web.

### Padrão Model-View-Controller (MVC)

1. **Model(M):** O Modelo representa os dados e a lógica de negócios do aplicativo. No Angular, isso geralmente é representado por serviços ou classes que gerenciam dados, realizam operações e interagem com APIs. O Modelo é responsável por recuperar, atualizar e manipular dados. Nesse caso, é um serviço que disponibiliza uma lista de livros.

```typescript
// book.service.ts
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class BookService {
  private books = [
    { id: 1, title: 'Angular Basics', author: 'John Doe' },
    { id: 2, title: 'JavaScript Mastery', author: 'Jane Smith' },
    // ...mais livros
  ];

  getBooks() {
    return this.books;
  }
}
```

2. **View(V):** A Visualização é a interface do usuário (UI) do aplicativo. No Angular, a View é representada por templates HTML que definem como os dados do Modelo devem ser exibidos ao usuário. A View é responsável por apresentar os dados e capturar a entrada do usuário.

```typescript
// book-list.component.ts
import { Component } from '@angular/core';
import { BookService } from './book.service';

@Component({
  selector: 'app-book-list',
  template: `
    <h1>Book List</h1>
    <ul>
      <li *ngFor="let book of books">{{ book.title }} 
      by {{ book.author }}</li>
    </ul>
  `,
})
export class BookListComponent {
  books = [];

  constructor(private bookService: BookService) {
    this.books = bookService.getBooks();
  }
}
```

3. **Controller(C):** No MVC tradicional, o Controlador atua como intermediário entre o Modelo e a Visualização. Ele recebe a entrada do usuário da Visualização, processa-a, interage com o Modelo para recuperar ou atualizar dados e atualiza a Visualização de acordo. No Angular, a função de Controlador é amplamente substituída por Componentes.

Classe BookListComponent. Ele recupera dados do Modelo (o BookService) e os vincula à Visualização.

### Padrão Model-View-ViewModel

![MVVM Architecture](https://learn.microsoft.com/en-us/dotnet/architecture/maui/media/mvvm-pattern.png)

MVVM significa Model-View-ViewModel. É um padrão arquitetural que divide as preocupações de um aplicativo em três partes: Model, View e ViewModel. Essa separação de interesses auxilia na organização, manutenção e teste do código.

1. **Model(M):** O Model representa os dados e a lógica de negócios do aplicativo. É responsável por recuperar e armazenar dados de/para o banco de dados ou API.

2. **View(V):** A View representa a interface do usuário do aplicativo. É responsável por exibir os dados ao usuário e registrar as interações do usuário.

3. **ViewModel(VM):** O ViewModel serve como intermediário entre a visualização e o modelo. Ele abriga a lógica do aplicativo que vincula a visualização ao modelo. Ele também expõe os dados à visualização em um formato fácil de vincular e exibir.

Podemos usar as seguintes etapas para implementar a arquitetura MVVM em um aplicativo Angular:

### Passo 1: Crie o Model

O Model representa os dados e a lógica de negócios do aplicativo. Em Angular, podemos criar uma classe de modelo que define as propriedades e métodos dos dados. Um exemplo de classe Model é o seguinte:

```typescript
export class User {
id: number;
name: string;
email: string;
}
```

### Passo 2: Crie o ViewModel

O ViewModel serve como intermediário entre a visualização e o modelo. Ele abriga a lógica do aplicativo que vincula a visualização ao modelo. Podemos usar Angular para criar um componente que sirva como ViewModel. Um componente ViewModel é ilustrado abaixo:

```typescript
import { Component, OnInit } from '@angular/core';
import { User } from '../models/user';
import { UserService } from '../services/user.service';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {
  users: User[];

  constructor(private userService: UserService) { }

  ngOnInit() {
    this.userService.getUsers().subscribe(users => {
      this.users = users;
    });
  }
}
```

Aqui o UserComponent atua como ViewModel. Ele busca os usuários do UserService e os expõe à visualização.

### Passo 3: Crie a View

A View representa a interface do usuário do aplicativo. É responsável por exibir os dados ao usuário e registrar as interações do usuário. No Angular, podemos criar um modelo que define a interface do usuário da visualização. Um exemplo de modelo de View é o seguinte:

```typescript
<h2>Users</h2>

<ul>
  <li *ngFor="let user of users">
    {{ user.name }} - {{ user.email }}
  </li>
</ul>
```

Aqui, o modelo de visualização exibe a lista de usuários obtidos do ViewModel.

### Qual a diferença do MVC para o MVVM?

O padrão arquitetural Model-View-ViewModel (MVVM) **é uma extensão do Model-View-Controller (MVC)**. O padrão MVC separa uma aplicação em três partes: Models, Views e Controllers. MVVM adiciona uma camada chamada **ViewModel** entre a View e o Model. O ViewModel atua como um mediador de comunicação entre a View e o Model. O ViewModel é responsável por lidar com as interações do usuário com o aplicativo e atualizar o Model de acordo. O padrão MVVM permite a separação de interesses dentro de uma aplicação. Também torna mais fácil testar e manter sua base de código.

### 3.1.3 Injeção de Dependência

### O que é Injeção de Dependência?

Considere o seguinte exemplo: se a classe A precisa de informações da classe B para poder funcionar, então, A depende de B, ou seja, B é uma dependência para A.

De forma mais técnica, dependências são serviços, objetos, funções ou até mesmo um valor que uma classe necessita para desempenhar sua função. No nosso exemplo, a classe A pode ela mesma ser responsável por criar uma instância da classe B, ou então, essa dependência pode ser passada para ela, ou melhor dizendo, ser injetada nela. Esse processo recebe o nome de injeção de dependência.

De acordo com a documentação do Angular, injeção de dependência é um padrão de projeto no qual uma classe solicita dependências de fontes externas ao invés de criá-las.

#### Código sem injeção de dependências
```typescript
export class BobComponent {
    // declaração dos atributos do service
    
    hamburguerDeSiriService: HamburguerDeSiriService;

    constructor() {
        this.hamburguerDeSiriService = new HamburguerDeSiriService
    }

    // métodos da classe
}
```
#### Código com injeção de dependências
```typescript
export class BobComponent {

    constructor(private HamburguerDeSiriService: HamburguerDeSiriService) {

    }

    // métodos da classe
}

```

### Criação de um Service para exemplificação

Temos uma aplicação de delivery e vamos criar um serviço chamado FoodService, utilizando o seguinte comando do Angular CLI:

```bash
ng generate service food
```

Ou, de forma abreviada:

```bash
ng g s food
```

Será gerado um arquivo com a seguinte estrutura: 

```typescript
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})

export class FoodService {
  constructor() { }
}
```

Analisando este arquivo, percebemos que se trata de uma classe que contém um decorator chamado **@Injectable()**, importado do pacote @angular/core. Esse decorator **indica ao Angular que essa classe é injetável** e pode ser utilizada em outras classes.

### Tipos de injetores

O decorator @injectable(), por padrão, possui um metadado chamado providedIn. Esse nome vem de provider (provedor), que significa fornecedor. Ele é o responsável por **fornecer uma instância dessa classe através da injeção de dependência**. Nesse caso, o valor dessa propriedade: providedIn: 'root', indica que o Angular deve fornecer o serviço no injetor raiz, em outras palavras, significa que esse **serviço é visível para toda a aplicação e você pode injetá-lo em qualquer lugar do seu projeto**. Essa definição de provider root acontece quando queremos ter uma **única instância de um serviço em toda a aplicação e pode ser chamada de Singleton**.

Vale destacar, que o Singleton é um padrão de projeto que busca limitar a quantidade de instâncias de uma classe específica, para que todos os elementos dependentes acessem uma única instância compartilhada. Essa configuração como Singleton pode ser realizada tanto no nível raiz da hierarquia de injeção de dependência quanto através do uso do modificador ``providedIn: 'root'.``

Recomenda-se **sempre fornecer seu serviço no injetor 'root'**, a menos que haja um caso em que você deseja que o serviço esteja disponível apenas se o consumidor importar um @NgModule específico.

Nesse caso, é possível especificar que um serviço deve ser fornecido em um determinado @NgModule. Por exemplo, se você quisesse que o FoodService só pudesse ser usado nos locais em que um módulo UserModule que você criou estivesse importado, você poderia especificar que o service deve ser fornecido no módulo da seguinte forma:

```typescript
import { Injectable } from '@angular/core';
import { UserModule } from './user.module';

@Injectable({
  providedIn: UserModule
})

export class FoodService {
  constructor() { }
}
```

Além disso, o provider também pode ser definido como ``any``, indicando que um serviço deve ser instanciado de forma diferente com base em se está sendo utilizado em módulos carregados imediatamente (eager loading) ou tardiamente (lazy loading). Se definimos any em módulos carregados imediatamente, todos compartilham a mesma instância do serviço, assim como ocorreria com root. No entanto, em módulos carregados tardiamente, cada módulo recebe sua própria instância do serviço, garantindo isolamento entre os diferentes módulos e evitando conflitos.

### Exemplificação 

No nosso projeto, temos um componente chamado delivery, que é utilizado para renderizar na tela as opções de pedidos num restaurante. Esse componente precisa do serviço que criamos anteriormente, o FoodService, para a escolha do tipo de refeição.

Em alguns dias da semana, o restaurante faz uma promoção para as pessoas que quiserem pedir, além da refeição, uma sobremesa ou uma bebida. Nesse caso, o FoodService precisa se comunicar com outros dois serviços, o DessertService e o DrinkService.

Agora, vamos ao código ver como resolver isso!

Sem a injeção de dependência, teríamos que instanciar manualmente todos os serviços de que precisamos no componente, além de ter que passar todos os possíveis parâmetros que esses serviços utilizam. Assim:

> **delivery.component.ts**
```typescript
export class DeliveryComponent {

  // declaração dos atributos dos services
  drinkService: DrinkService;
  dessertService: DessertService;
  foodService: FoodService;

  constructor() {
    this.drinkService = new DrinkService();
    this.dessertService = new DessertService();
    this.foodService = new FoodService(this.dessertService, this.drinkService);
  }

  // métodos da classe
}
```

Vamos ao exemplo com injeção de dependência:

```typescript
export class DeliveryComponent {

  constructor(private foodService: FoodService) { }

  // métodos da classe
}
```

Sim, é só isso mesmo! No Angular, a injeção de dependência pode ser feita via construtor, onde especificamos um parâmetro com o tipo da dependência (foodService: FoodService) e, ao colocar o modificador de acesso private, fazemos com que esse atributo seja automaticamente declarado como atributo dessa classe.

Além disso, a partir da versão 14 do Angular, recebemos a nova função inject, que também nos permite fazer a injeção de dependências de um modo diferente. Com ela, podemos fazer a mesma injeção que fizemos no bloco anterior, mas da seguinte forma:
```typescript
import { Component, inject } from '@angular/core';
export class DeliveryComponent {

  foodService = inject(FoodService);

  // métodos da classe
}
```

Nesse caso, usamos inject para injetar o ``FoodService`` na classe ``DeliveryComponent``, atribuindo o serviço à propriedade ``foodService``.

A injeção de dependências pode ser feita tanto através do construtor, como através da função ``inject()``. A escolha entre elas fica a seu critério, mas é crucial lembrar que ao utilizar ``inject`` é necessário lembrar de realizar sua importação de ``@angular/core``.

## 4 Técnicas Avançadas de Implementação

### 4.1 Diretivas Personalizadas

Uma forma de estender as funcionalidades do HTML é criação de diretivas. Existem 3 tipos de diretivas no Angular:

1. Diretivas de atributos - mudam a aparência e comportamento dos elementos. O `NgStyle` e o `NgClass` são exemplos incorporados por padrão.
2. Diretivas estruturais - alteram a estrutura dos elementos, adicionando ou removendo-os. `NgIf`, `NgFor`, e `NgSwitch` são exemplos.
3. Componentes - diretivas com modelos (templates).

Abaixo tem o exemplo de uma diretiva de atributos, que ao passar o mouse em cima de uma tag, faz seu texto fica em negrito. Perceba o uso do decorator `@Directive`, bem como seu seletor, que é o que o identifica dentro da tag. Além disso, existe um atributo 'fontWeight', que guarda a espessura da fonte para ser especificada no CSS. Já o `@HostListener` é um listener que fica esperando que um evento ocorra no elemento em questão para chamar o método ao lado.

``` typescript
import { Directive, ElementRef, HostListener, Input } from  '@angular/core';

@Directive({
	selector:  '[destaqueTexto]'
})
export  class  DestaqueTexto {	 
	@Input() fontWeight:  string  =  '';

	constructor(private  el:  ElementRef) { }

	@HostListener('mouseenter') onMouseEnter() {
		this.setBoldText(this.fontWeight  ||  'bold');
	}

	@HostListener('mouseleave') onMouseLeave() {
		this.setBoldText(null);
	}
  
	private  setBoldText(fontWeight:  string  |  null) {
		this.el.nativeElement.style.fontWeight  =  fontWeight;
	}
}
```
Para que a diretiva esteja acessível para uso, ela deve ser importação em um módulo específico ou no módulo raiz da aplicação:

``` typescript
@NgModule({
declarations: [
	AppComponent,
	DestaqueTexto
]
```
Já no HTML, basta adicionar o nome da diretiva e passar o parâmetro solicitado, nesse caso 'fontWeight', que é a espessura do texto:
``` html
<span destaqueTexto [fontWeight]="'bold'">
	Harmonify
</span>
```

### 4.2 Serviços

As classes de serviço tem como objetivo encapsular regras de negócio e separar as operações que não tem relação com a exibição. Desta forma, são usadas para fornecer dados e funcionalidades para toda a aplicação, inclusive para fazer requisições HTTP para uma API. Entre algumas de suas vantagens:

 - Ciclo de vida independente da UI;
 - Injeção de dependência embutido;
 - Reutilização de código.

No exemplo abaixo, temos uma classe de serviço responsável por pegar uma lista de músicas da API e também por salva-las na mesma API. O decorator `@Injectable` para realizar a injeção de dependência.

``` typescript
import { Injectable } from  '@angular/core';
import { Musica } from  '../modelos/musica';
import { HttpClient } from  '@angular/common/http';
import { Observable } from  'rxjs';

@Injectable({
	providedIn:  'root'
})
export  class  MusicasService {

	private  readonly  API_SPRING  =  'api/musicas';

	constructor(private  httpClient:  HttpClient) { }

	listarMusicas() :  Observable<Musica[]> {
		return  this.httpClient.get<Musica[]>(this.API_SPRING);
	}

	salvarMusica(musica:  Musica) {
		return  this.httpClient.post<Musica>(this.API_SPRING, musica);
	}

}
```
No Angular.js, as fábricas eram um tipo especializado de serviço para criar objetos. Com o uso do  `@Injectable`,  elas caíram em desuso.
  
## 5 Referências

- [Documentação do Angular v17](https://angular.dev/essentials)
- [Documentação do AngularCLI](https://angular.io/)
- [Arquitetura Angular](https://vidafullstack.com.br/angular/arquitetura-angular/)
- [Two-way data binding no Angular](https://www.alura.com.br/artigos/angular-2-o-fim-do-two-way-data-binding)
- [Injeção de Dependência, Alura](https://www.alura.com.br/artigos/services-injecao-dependencia-angular-o-que-sao-como-funcionam)
- [História e Origem do Angular](https://pt.wikipedia.org/wiki/Angular_(framework))
- [Principais Características do Angular e diferenças para outros Frameworks](https://blog.betrybe.com/framework-de-programacao/angular/#6)
- [Características do MVVM](https://learn.microsoft.com/en-us/dotnet/architecture/maui/mvvm)
- [MVVM Aplicado ao Angular](https://deepakjosecodes.com/mvvm-architecture-in-angular-guide-with-code-examples/)
- [Comparação entre o MVVM e o MVC no contexto do Angular](https://medium.com/front-end-world/mvc-and-mvvm-patterns-in-angular-7397e0bc7b07)
- [Padrões de Projeto](https://dev.to/galwhocod3z/design-patterns-angular-34dk)
- [Padrões de Projeto](https://angular.io/guide/singleton-services)
- [Padrões de Projeto](https://blog.devgenius.io/design-patterns-in-angular-212fcf468dce)
- [Criação de diretivas personalizadas ](https://www.freecodecamp.org/portuguese/news/como-usar-e-criar-diretivas-personalizadas-no-angular/)
