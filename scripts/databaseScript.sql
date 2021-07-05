create database provas;
use provas;

create table prova(
idProva int primary key auto_increment,
 nomeProva varchar(60) unique,
 criado DATETIME,
 uuid varchar (50) unique
 );
 
 create table questao(
 idQuestao int primary key auto_increment,
 opcao1 varchar(255),
 opcao2 varchar(255),
 opcao3 varchar(255),
 opcao4 varchar(255),
 opcaocorreta int,
 pergunta varchar(1000)
  );
 
 create table questaoprova(
   idProva int,
  idQuestao int,
   foreign key (idProva) references prova(idProva) on delete cascade,
  foreign key (idQuestao) references questao(idQuestao)  on delete cascade
 );
 
 
 
 create table aluno(
 idAluno int primary key auto_increment,
 nomeAluno varchar(255) unique,
 comecouAprova DATETIME,
 terminouAprova datetime,
 nota double,
 idProva int,
 foreign key (idProva) references prova(idProva)
 );
 
 
 insert into prova values(null, 'Prova de matemática', NOW(), 'aa203d25-d0b9-4cba-9f94-30c680f4ef96');
 insert into questaoprova values (1,1);
 
  insert into aluno values (null, 'Thiago Canella', Now(),null,null,1 );
 
 
 
 
 
 insert into questao values (null , 'somando os lados' ,' multiplicando um lado pelo outro' ,'raiz quadrarda da soma dos quadrados dos catetos' ,'cateto adjacente ao quadrado menos o cateto oposto', 3 , 'Como se obtém a hipotenusa?');